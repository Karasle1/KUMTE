package com.example.mhd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
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
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

    }

    public void doSecti(View v){

        int a = Integer.parseInt(edA.getText().toString());
        int b = Integer.parseInt(edB.getText().toString());
        int vysledek = a+b;

        Log.d("SOUCET",String.format("Soucet je %d", vysledek));

        Intent intent = new Intent(this, Vysledek.class);
        intent.putExtra("vysledek",vysledek);
        startActivity(intent);

        //todo


    }
    public void najdiPolohu(View v){

      //  Location poloha = new Location(GPS_PROVIDER);

     //   double sirka = poloha.getLatitude();
      //  double delka = poloha.getLongitude();

      //  Log.d("Poloha Delka",String.format(delka));
     //   Log.d("Poloha Sirka",String.format(sirka));

       // Intent intentP = new Intent(this, Vysledek.class);
       // startActivity(intentP);

        //todo


    }
}