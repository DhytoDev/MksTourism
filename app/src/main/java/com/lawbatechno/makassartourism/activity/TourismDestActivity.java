package com.lawbatechno.makassartourism.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lawbatechno.makassartourism.R;

public class TourismDestActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private Button btnTerrain, btnHybrid, btnNormal, btnSatelite ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_dest);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Tourism Destination");
        toolbar.setLogo(R.drawable.ic_tourist_destination_24dp);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnTerrain = (Button) findViewById(R.id.button_terrain);
        btnHybrid = (Button) findViewById(R.id.button_hybrid);
        btnNormal = (Button) findViewById(R.id.button_normal);
        btnSatelite = (Button) findViewById(R.id.button_satelite);

        btnTerrain.setOnClickListener(this);
        btnHybrid.setOnClickListener(this);
        btnNormal.setOnClickListener(this);
        btnSatelite.setOnClickListener(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng rotterdam = new LatLng(-5.1339352,119.4028091);
        LatLng parangloe = new LatLng(-5.2288027,119.6617291);
        LatLng balla_lompoa = new LatLng(-5.2062091,119.4506562);
        LatLng bantimurung = new LatLng(-5.0161006,119.6825893);
        LatLng sombaopu = new LatLng(-5.1932686,119.3941932);
        LatLng bugis_wtrpark = new LatLng(-5.155934,119.4860434);
        LatLng museum_kota = new LatLng(-5.1345915,119.4064374);
        LatLng pantai_losari = new LatLng(-5.1436783,119.4051762);
        mMap.addMarker(new MarkerOptions().position(rotterdam).title("Fort Rotterdam"));
        mMap.addMarker(new MarkerOptions().position(parangloe).title("Air Terjun Parangloe"));
        mMap.addMarker(new MarkerOptions().position(balla_lompoa).title("Ballak Lompoa"));
        mMap.addMarker(new MarkerOptions().position(bantimurung).title("Air Terjun Bantimurung"));
        mMap.addMarker(new MarkerOptions().position(sombaopu).title("Benteng Sombaopu"));
        mMap.addMarker(new MarkerOptions().position(bugis_wtrpark).title("Bugis Waterpark"));
        mMap.addMarker(new MarkerOptions().position(museum_kota).title("Museum Kota Makassar"));
        mMap.addMarker(new MarkerOptions().position(pantai_losari).title("Pantai Losari"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pantai_losari,12));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.button_satelite:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break ;
            case R.id.button_hybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break ;
            case R.id.button_normal:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.button_terrain:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
        }
    }
}
