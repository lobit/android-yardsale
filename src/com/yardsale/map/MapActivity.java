// YardSale App

package com.yardsale.map;

import java.util.List;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.location.Location;
import android.os.Bundle;

public class MapActivity extends android.support.v4.app.FragmentActivity {
    /**
     * Null if Google Play services APK is not available.
     */
    private GoogleMap newMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		 Parse.initialize(this, "dMxkpeLG7xmr7W2FAq9mbfEa9ZBaH53SNJHv1C90", "9bqgPsYLxBorhHqefMUL5MNPgKeQ9dXaMwJMhFBA"); 
		 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setUpMapIfNeeded();
        setUpLocationMarkers(); //test
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
    	
    	List<ParseObject> list = null;
    
    	ParseQuery markerQuery = new ParseQuery("events");
    
    	try {
			list = markerQuery.find();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    for(int i = 0; i < list.size();i++){
		
    	
    	ParseObject new2 = list.get(i);
    
    	double lat = new2.getDouble("Latitude");
    	double longt = new2.getDouble("Longitude");

    	
    	newMap.addMarker(new MarkerOptions().position(new LatLng(lat, longt)).title(new2.getString("eventName")).snippet(new2.getString("Tags")));

    }
    	newMap.addMarker(new MarkerOptions().position(new LatLng(33.782079, -118.113799)).title("Andre's Yardsale").snippet("Tags:+Jewelry +Furniture"));

        newMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(new LatLng(33.782079, -118.113799), 12));
        newMap.setMyLocationEnabled(true);
   
    
    
    
    }

    private void setUpLocationMarkers(){
    	
    	ParseObject p = new ParseObject("events");
    	ParseObject z = new ParseObject("events");
    
    	z.put("eventName", "Jamal's Sale");
    	z.put("Tags", "+Auto +Chairs");
    	z.put("Latitude", 33.782605);
    	z.put("Longitude", -118.122379);
    	z.saveInBackground();
    	
    	p.put("eventName", "Jane's Sale");
    	p.put("Tags", "+Jewelry +Furniture");
    	p.put("Latitude", 33.775228);
    	p.put("Longitude", -118.120875);
    	p.saveInBackground();
    	System.out.println("Saved");
    	
    	
    }

    /**Instance Variables**/
    ParseObject markers;
    
    
    


}