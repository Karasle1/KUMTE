package com.example.mhd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edA;
    private EditText edB;
    private LocationManager locationManager;

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

        //  LocationListener locationListener = new MyLocationListener();


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Location poloha = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            double sirka = poloha.getLatitude();
            double delka = poloha.getLongitude();

            Log.d("Poloha Delka", String.valueOf(delka));
            Log.d("Poloha Sirka",String.valueOf(sirka));
        //    return;
        }





     //   Intent intentP = new Intent(this, Vysledek.class);
    //    startActivity(intentP);

        //todo


    }
}