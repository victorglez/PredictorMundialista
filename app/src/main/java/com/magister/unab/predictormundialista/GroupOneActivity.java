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

public class GroupOneActivity  extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_one);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("pruebaMensaje");

        //ViewPager viewPager = (ViewPager) findViewById(R.id.viewpagerGroupOne);
        //viewPager.addOnPageChangeListener(this);
        //viewPager.setAdapter(new CustomPagerAdapter(this));
    }

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
