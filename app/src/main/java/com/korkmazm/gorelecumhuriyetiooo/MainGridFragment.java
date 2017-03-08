package com.korkmazm.gorelecumhuriyetiooo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by KorkmazM on 01/03/2017.
 */

public class MainGridFragment extends Fragment {

    private View rootView;
    GridView gridViewUygulamalar;
    GridView gridViewOkulumuz;
    GridView gridViewOnline;
    GridView gridViewBaglantilar;
    GridView gridViewSosyal;

    private AdView mAdView;

    static final String[] UYGULAMALAR = new String[] {
            "Duolingo", "Eba","Dyned", "EOkulO", "EOkulV", "MEB Personel", "AOF", "Edevlet"};

    static final String[] OKULUMUZ = new String[] {
            "Görele Cumhuriyet İO", "Görele Cumhuriyet OO" };

    static final String[] ONLINE = new String[] {
            "MEBBİS", "Fatih Projesi"};

    static final String[] BAGLANTILAR = new String[] {
            "Duyurular", "İlçe MEB", "İl MEB", "MEB", "Belediye", "Kaymakamlık" };

    static final String[] SOSYAL = new String[] {
            "Facebook", "Messenger", "Twitter", "Instagram", "Telegram" };

    GridAdapter gridAdapterUygulamalar;
    GridAdapter gridAdapterOkulumuz;
    GridAdapter gridAdapterOnline;
    GridAdapter gridAdapterBaglantilar;
    GridAdapter gridAdapterSosyal;

    public MainGridFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.maingridfragment, container, false);

        mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        gridViewUygulamalar = (GridView)  rootView.findViewById(R.id.gridUygulamalar);
        gridAdapterUygulamalar = new GridAdapter(rootView.getContext(), UYGULAMALAR, false);
        gridViewUygulamalar.setAdapter(gridAdapterUygulamalar);


        gridViewUygulamalar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                switch (position){
                    case 0 :
                        startNewActivity(rootView.getContext(), "com.duolingo");
                        break;
                    case 1:
                        startNewActivity(rootView.getContext(), "tr.gov.eba.hesap");
                        break;
                    case 2:
                        startNewActivity(rootView.getContext(), "com.dyned.engine");
                        break;
                    case 3:
                        startNewActivity(rootView.getContext(), "com.meb.e_okul");
                        break;
                    case 4:
                        startNewActivity(rootView.getContext(), "com.meb.vbsmobil");
                        break;
                    case 5:
                        startNewActivity(rootView.getContext(), "com.meb.personelV2");
                        break;
                    case 6:
                        startNewActivity(rootView.getContext(), "com.meb.acikLise");
                        break;
                    case 7:
                        startNewActivity(rootView.getContext(), "tr.gov.turkiye.edevlet.kapisi");
                        break;
                }
            }
        });

        gridViewOkulumuz = (GridView)rootView.findViewById(R.id.gridOkulumuz);
        gridAdapterOkulumuz = new GridAdapter(rootView.getContext(), OKULUMUZ, true);
        gridViewOkulumuz.setNumColumns(1);
        gridViewOkulumuz.setAdapter(gridAdapterOkulumuz);
        gridViewOkulumuz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        /*Intent browserIntent1 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.gorelecumhuriyetio.meb.k12.tr/"));
                        startActivity(browserIntent1);*/


                        Intent intentGoreleIO = new Intent(rootView.getContext(), WebDetails.class);
                        intentGoreleIO.putExtra("URL",
                                "http://www.gorelecumhuriyetio.meb.k12.tr/");
                        startActivity(intentGoreleIO);
                        break;
                    case 1 :
                        /*Intent browserIntent2 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.gorelecumhuriyetio.meb.k12.tr/"));
                        startActivity(browserIntent2);*/

                        Intent intentGoreleOO = new Intent(rootView.getContext(), WebDetails.class);
                        intentGoreleOO.putExtra("URL",
                                "http://gorelecumhuriyetioo.meb.k12.tr/");
                        startActivity(intentGoreleOO);

                        break;

                }
            }
        });

        gridViewOnline = (GridView)rootView.findViewById(R.id.gridOnline);
        gridAdapterOnline = new GridAdapter(rootView.getContext(), ONLINE, false);
        gridViewOnline.setNumColumns(gridAdapterOnline.getCount());
        gridViewOnline.setAdapter(gridAdapterOnline);
        gridViewOnline.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0 :
                        Intent browserIntent8 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://mebbis.meb.gov.tr/default.aspx"));
                        startActivity(browserIntent8);
                        break;
                    case 1 :
                        Intent browserIntent16 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://fatihprojesi.meb.gov.tr/"));
                        startActivity(browserIntent16);
                        break;
                }
            }
        });


        gridViewBaglantilar = (GridView)rootView.findViewById(R.id.gridBaglantilar);
        gridAdapterBaglantilar = new GridAdapter(rootView.getContext(), BAGLANTILAR, true);
        gridViewBaglantilar.setNumColumns(2);
        gridViewBaglantilar.setAdapter(gridAdapterBaglantilar);
        gridViewBaglantilar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        Intent browserIntent9 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.meb.gov.tr/meb_duyuruindex.php?dil=tr"));
                        startActivity(browserIntent9);
                        break;
                    case 1:
                        Intent browserIntent10 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://gorele.meb.gov.tr/"));
                        startActivity(browserIntent10);
                        break;
                    case 2:
                        Intent browserIntent11 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://giresun.meb.gov.tr/"));
                        startActivity(browserIntent11);
                        break;
                    case 3:
                        Intent browserIntent12 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.meb.gov.tr/"));
                        startActivity(browserIntent12);
                        break;
                    case 4 :
                        Intent browserIntent14 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.gorele.bel.tr/"));
                        startActivity(browserIntent14);
                        break;
                    case 5 :
                        Intent browserIntent15 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.gorele.gov.tr/"));
                        startActivity(browserIntent15);
                        break;
                }
            }
        });


        gridViewSosyal = (GridView)  rootView.findViewById(R.id.gridSosyal);
        gridAdapterSosyal = new GridAdapter(rootView.getContext(), SOSYAL, false);
        gridViewSosyal.setNumColumns(gridAdapterSosyal.getCount());
        gridViewSosyal.setAdapter(gridAdapterSosyal);
        gridViewSosyal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0 :
                        Intent facebook = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("fb://facewebmodal/f?href=https://m.facebook.com/gorelecumhuriyet/"));
                        startActivity(facebook);
                        break;
                    case 1 :
                        Intent messenger = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://m.me/gorelecumhuriyet"));
                        startActivity(messenger);
                        break;
                    case 2 :
                        Intent twitter = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://twitter.com/gorelecumhuriyt?s=08"));
                        startActivity(twitter);
                        break;
                    case 3 :
                        Intent instagram = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://instagram.com/_u/gorelecumhuriyet?r=sun1"));
                        startActivity(instagram);
                        break;
                    case 4 :
                        Intent telegram = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://t.me/cumio"));
                        startActivity(telegram);
                        break;
                }
            }
        });

        return rootView;
    }

    public void startNewActivity(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent == null) {
            // Bring user to the market or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
