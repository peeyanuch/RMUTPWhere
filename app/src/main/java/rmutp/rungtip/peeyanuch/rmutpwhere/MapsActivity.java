package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    //Explicit
    private GoogleMap mMap;
    private double rmutpLatADouble = 13.817895 ,rmutpLngADouble = 100.511889;
    private LatLng rmutpLatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    } //Main Method



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //   for Setup Center Map
        rmutpLatLng = new LatLng(rmutpLatADouble,rmutpLngADouble);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(rmutpLatLng,16));

        myCreateMarker(rmutpLatLng, R.drawable.build4);


    } //OnMap

    private void myCreateMarker(LatLng latLng,int intIcon) {
        mMap.addMarker(new MarkerOptions()
        .position(latLng)
        .icon(BitmapDescriptorFactory.fromResource(intIcon)));


    }

} //Main Class
