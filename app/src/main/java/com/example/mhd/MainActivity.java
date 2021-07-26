package com.example.mhd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements LocationListener {

    private EditText edA;
    private EditText edB;
    private LocationManager locationManager;
    public Criteria criteria;
    public String bestProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edA = findViewById(R.id.edA);
        edB = findViewById(R.id.edB);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


    }

    public void doSecti(View v) {

        int a = Integer.parseInt(edA.getText().toString());
        int b = Integer.parseInt(edB.getText().toString());
        int vysledek = a + b;

        Log.d("SOUCET", String.format("Soucet je %d", vysledek));

        Intent intent = new Intent(this, Vysledek.class);
        intent.putExtra("vysledek", vysledek);
        startActivity(intent);

        //todo


    }


    public void najdiPolohu(View v) {

        //     LocationListener locationListener = new LocationListener();

        ///////
        criteria = new Criteria();
        bestProvider = String.valueOf(locationManager.getBestProvider(criteria, true));


        int REQUEST_CODE = 0;
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_CODE);
        } else {
            Location poloha = locationManager.getLastKnownLocation(bestProvider);

            //This is what you need:
            if (poloha != null) {
                Log.e("TAG", "GPS is on");
                double sirka = poloha.getLatitude();
                double delka = poloha.getLongitude();
                Log.d("Poloha Delka", String.valueOf(delka));
                Log.d("Poloha Sirka", String.valueOf(sirka));
                Log.d("Konec", String.format("Konec"));
                // Toast.makeText(MainActivity.this, "latitude:" + latitude + " longitude:" + longitude, Toast.LENGTH_SHORT).show();
                //  searchNearestPlace(voice2text);
            } else {
                locationManager.requestLocationUpdates(bestProvider, 1000, 0.1f, this);
                Log.e("TAG", "GPS is on");
                double sirka = poloha.getLatitude();
                double delka = poloha.getLongitude();
                Log.d("Poloha Delka", String.valueOf(delka));
                Log.d("Poloha Sirka", String.valueOf(sirka));
                Log.d("Konec", String.format("Konec"));
            }


            //  Location poloha = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            //   double sirka = poloha.getLatitude();
            //   double delka = poloha.getLongitude();


        }
        ///////


        //   Intent intentP = new Intent(this, Vysledek.class);
        //    startActivity(intentP);

        //todo


    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        //    return;

            locationManager.requestLocationUpdates(bestProvider, 1000, 0.1f, this);
            Location    poloha = locationManager.getLastKnownLocation(bestProvider);
            Log.e("TAG", "GPS is on");
            double sirka = poloha.getLatitude();
            double delka = poloha.getLongitude();
            Log.d("Poloha Delka", String.valueOf(delka));
            Log.d("Poloha Sirka", String.valueOf(sirka));
            Log.d("Konec", String.format("Konec"));
        }


    }
}