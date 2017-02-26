package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

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
    private double rmutpLatADouble = 13.817843, rmutpLngADouble = 100.511888;
    private LatLng rmutpLatLng;
    private double userLatADouble = 0.0, userLngADouble = 0.0;
    private LocationManager locationManager;
    private Criteria criteria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //for setup
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    } //Main Method

    @Override
    protected void onResume() {
        super.onResume();
        Location networkLocation = myFindLocation(LocationManager.NETWORK_PROVIDER);
        if (networkLocation != null) {
            userLatADouble = networkLocation.getLatitude();
            userLngADouble = networkLocation.getLongitude();
        }

        Location gpsLocation = myFindLocation(LocationManager.GPS_PROVIDER);
        if (gpsLocation != null) {
            userLatADouble = gpsLocation.getLatitude();
            userLngADouble = gpsLocation.getLongitude();
        }

       // Log.d("11febV1","lat ==>" + userLatADouble);
        //Log.d("11febV1","lng ==>" + userLngADouble);

        try {
            LatLng latLng = new LatLng(userLatADouble, userLngADouble);
            myCreateMarker(latLng, R.drawable.m2);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }// onResume

    @Override
    protected void onStop() {
        super.onStop();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.removeUpdates(locationListener);



    }

    public Location myFindLocation(String strProvider) {
        Location location = null;

        if (locationManager.isProviderEnabled(strProvider)) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return null;
            }
            locationManager.requestLocationUpdates(strProvider, 1000, 10, locationListener);
            location = locationManager.getLastKnownLocation(strProvider);

        }   // if

        return location;
    }


    public LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

            userLatADouble = location.getLatitude();
            userLngADouble = location.getLongitude();


        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //   for Setup Center Map
        rmutpLatLng = new LatLng(rmutpLatADouble,rmutpLngADouble);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(rmutpLatLng,16));

        myCreateMarker(rmutpLatLng, R.drawable.m1);


    } //OnMap

    private void myCreateMarker(LatLng latLng,int intIcon) {
        mMap.addMarker(new MarkerOptions()
        .position(latLng)
        .icon(BitmapDescriptorFactory.fromResource(intIcon)));


    }

} //Main Class
