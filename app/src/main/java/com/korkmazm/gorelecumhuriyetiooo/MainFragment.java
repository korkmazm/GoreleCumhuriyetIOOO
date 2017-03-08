package com.korkmazm.gorelecumhuriyetiooo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by KorkmazM on 20/02/2017.
 */

public class MainFragment extends android.support.v4.app.Fragment {


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    public MainFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mainfragment, container, false);

        expandableListView = (ExpandableListView)rootView.findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListData.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        //java.util.Collections.sort(expandableListTitle);
        expandableListAdapter = new ExpandableListAdapter(rootView.getContext(), expandableListTitle,expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        for (int i = 0; i < expandableListAdapter.getGroupCount(); i++) {
            expandableListView.expandGroup(i);
        }


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                /*Toast.makeText(getApplicationContext(), expandableLİstTitle
                        .get(groupPosition).toString() + "List expanded",
                        Toast.LENGTH_SHORT).show();*/
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView,
                                        View view, int groupPosition,
                                        int childPosition, long id) {
                /*Toast.makeText(getApplicationContext(), expandableLİstTitle.get(groupPosition)
                        + " -> "+ expandableListDetail.get(expandableLİstTitle
                        .get(groupPosition)).get(childPosition),
                        Toast.LENGTH_SHORT).show();*/

                final String listItem = expandableListDetail.get(expandableListTitle
                        .get(groupPosition)).get(childPosition);
                switch (listItem){
                    case "Cumhuriyet İlk Okulu" :
                        Intent browserIntent1 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.gorelecumhuriyetio.meb.k12.tr/"));
                        startActivity(browserIntent1);
                        break;
                    case "Cumhuriyet Orta Okulu" :
                        Intent browserIntent2 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://gorelecumhuriyetioo.meb.k12.tr/"));
                        startActivity(browserIntent2);
                        break;
                    case "Facebook Sayfamız" :
                        Intent browserIntent3 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.facebook.com/gorelecumhuriyet/"));
                        startActivity(browserIntent3);
                        break;
                    case "EBA" :
                        Intent browserIntent4 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.eba.gov.tr/"));
                        startActivity(browserIntent4);
                        break;
                    case "DYNET" :
                        Intent browserIntent5 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://dyned.eba.gov.tr/EBA_Dyned/"));
                        startActivity(browserIntent5);
                        break;
                    case "Duolingo" :
                        Intent browserIntent6 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://tr.duolingo.com/"));
                        startActivity(browserIntent6);
                        break;
                    case "E-Okul" :
                        Intent browserIntent7 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://e-okul.meb.gov.tr/"));
                        startActivity(browserIntent7);
                        break;
                    case "MEBBİS" :
                        Intent browserIntent8 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://mebbis.meb.gov.tr/default.aspx"));
                        startActivity(browserIntent8);
                        break;
                    case "Acil Duyurular" :
                        Intent browserIntent9 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.meb.gov.tr/meb_duyuruindex.php?dil=tr"));
                        startActivity(browserIntent9);
                        break;
                    case "İlçe MEB" :
                        Intent browserIntent10 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://gorele.meb.gov.tr/"));
                        startActivity(browserIntent10);
                        break;
                    case "İl MEB" :
                        Intent browserIntent11 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://giresun.meb.gov.tr/"));
                        startActivity(browserIntent11);
                        break;
                    case "Başkanlık MEB" :
                        Intent browserIntent12 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.meb.gov.tr/"));
                        startActivity(browserIntent12);
                        break;
                    case "E-Devlet" :
                        Intent browserIntent13 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.turkiye.gov.tr/"));
                        startActivity(browserIntent13);
                        break;
                    case "Görele Belediyesi" :
                        Intent browserIntent14 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.gorele.bel.tr/"));
                        startActivity(browserIntent14);
                        break;
                    case "Görele Kymakamlığı" :
                        Intent browserIntent15 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.gorele.gov.tr/"));
                        startActivity(browserIntent15);
                        break;
                    case "Fatih Projesi" :
                        Intent browserIntent16 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://fatihprojesi.meb.gov.tr/"));
                        startActivity(browserIntent16);
                        break;
                }
                return false;
            }
        });

        return rootView;


    }
}
