package com.magister.unab.predictormundialista;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupOneActivity  extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_one);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("pruebaMensaje");
    }

    //Example
    private void loadFromFirebase(){
        DatabaseReference resultsDB = FirebaseDatabase.getInstance().getReference().child("resultados");

        resultsDB.addValueEventListener(new ValueEventListener() {
            //resultsDB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot resultados) {
                for (DataSnapshot respuesta: resultados.getChildren()) {
                    System.out.println("-------------Respuesta-------------");
                    for(DataSnapshot grupo: respuesta.getChildren()){
                        System.out.println("------Grupo------");
                        for(DataSnapshot equipo : grupo.getChildren()){
                            String valor = (String)equipo.getValue();
                            System.out.println(valor);
                        }
                        System.out.println("----Fin Grupo----");
                    }
                    System.out.println("-----------Fin Respuesta----------");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError){
            }
        });
    }

    List<String> countries;
    String numGroup;

    //Probabilidad en porcentaje de ganar para el grupo 0 por ahora que corresponde al A... a modo de prueba
    public void getValueProbabilityWinning(View view){
        loadFromFirebase();
        numGroup = "0"; //Example Num Group
        countries = getAllCountriesForGroup();
        Set<String> uniqueCountries = new HashSet<String>(countries);
        ArrayList<CountryDO> countriesAndCountArray = new ArrayList<>();

        for(String uniqueCountry : uniqueCountries){
            int count = 0;
            CountryDO countryAndCount = new CountryDO();
            for(String country : countries){
                if(uniqueCountry.equals(country)){
                    countryAndCount.setCount(count++);
                    countryAndCount.setName(uniqueCountry);
                }
            }
            countriesAndCountArray.add(countryAndCount);
        }

        for(CountryDO countryDO : countriesAndCountArray){
            countryDO.setPercentage(countryDO.getCount()*100/countries.size());
            System.out.println(countryDO.getCount());
            System.out.println(countryDO.getName());
            System.out.println(countryDO.getPercentage());
        }
    }

    //Obtiene todos los paises por grupo el numero de grupo llega de forma global.
    private List<String> getAllCountriesForGroup() {
        DatabaseReference resultsDB = FirebaseDatabase.getInstance().getReference().child("resultados");

        resultsDB.addValueEventListener(new ValueEventListener() {
            //resultsDB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot resultados) {
                countries = new ArrayList<>();
                for (DataSnapshot respuesta : resultados.getChildren()) {
                    for (DataSnapshot grupo : respuesta.getChildren()) {
                        if (grupo.getKey().equals(numGroup)) {
                            for (DataSnapshot equipo : grupo.getChildren()) {
                                countries.add((String) equipo.getValue());
                            }
                        }
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return countries;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
    }

    @Override
    public void onPageSelected(int position){
    }

    @Override
    public void onPageScrollStateChanged(int state){
    }
}
