// YardSale App

package com.yardsale.map;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;

public class MapActivity extends android.support.v4.app.FragmentActivity {
    /**
     * Null if Google Play services APK is not available.
     */
    private GoogleMap newMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed).
     * <p>
     * If not installed, then user will be prompted to install/update the Google Play services APK.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (newMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            newMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (newMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        newMap.addMarker(new MarkerOptions().position(new LatLng(33.782079, -118.113799)).title("YardSale"));
        newMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(new LatLng(33.782079, -118.113799), 12));
        newMap.setMyLocationEnabled(true);
    }
}