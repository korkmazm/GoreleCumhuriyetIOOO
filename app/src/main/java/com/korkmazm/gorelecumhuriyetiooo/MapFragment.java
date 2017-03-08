package com.korkmazm.gorelecumhuriyetiooo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by KorkmazM on 20/02/2017.
 */

public class MapFragment extends android.support.v4.app.Fragment implements OnMapReadyCallback  {

    private AdView mAdView;
    private View rootView;

    private MapView mMapView;

    private TextView telText;
    private View telLayout;
    private View mailLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.mapfragment, container, false);

       mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mMapView = (MapView) rootView.findViewById(R.id.contact);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mMapView.getMapAsync(this);

        telLayout = (View) rootView.findViewById(R.id.telLayout);
        telText = (TextView)rootView.findViewById(R.id.telText);

        telLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+telText.getText()));
                startActivity(intent);
            }
        });

        mailLayout = (View)rootView.findViewById(R.id.mailLayout);
        mailLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://gorelecumhuriyetio.meb.k12.tr/tema/eposta/eposta_gonder.php?CHK=325472279273276275280275288333325322270331273274270340338288300292301302307305299294293&iframe=true&width=600&height=600"));
                startActivity(browserIntent2);
            }
        });

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(41.030071, 39.004080);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.m2))
                .title("Görele Cumhuriyet İO/OO"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);

        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 200, null);
    }
}
