package com.magister.unab.predictormundialista;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class CountryActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private boolean[] ganadorGroupoLista = new boolean[8];
    private String [][] ganadoresLista = new String[8][2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_country);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.addOnPageChangeListener(this);
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }

    private TextView[] getTextViews(int posicionGrupo){
        TextView[] textViews = new TextView[2];
        switch(posicionGrupo){
            case 0:
                textViews[0] = findViewById(R.id.primero_a);
                textViews[1] = findViewById(R.id.segundo_a);
                break;
            case 1:
                textViews[0] = findViewById(R.id.primero_b);
                textViews[1] = findViewById(R.id.segundo_b);
                break;
            case 2:
                textViews[0] = findViewById(R.id.primero_c);
                textViews[1] = findViewById(R.id.segundo_c);
                break;
            case 3:
                textViews[0] = findViewById(R.id.primero_d);
                textViews[1] = findViewById(R.id.segundo_d);
                break;
            case 4:
                textViews[0] = findViewById(R.id.primero_e);
                textViews[1] = findViewById(R.id.segundo_e);
                break;
            case 5:
                textViews[0] = findViewById(R.id.primero_f);
                textViews[1] = findViewById(R.id.segundo_f);
                break;
            case 6:
                textViews[0] = findViewById(R.id.primero_g);
                textViews[1] = findViewById(R.id.segundo_g);
                break;
            case 7:
                textViews[0] = findViewById(R.id.primero_h);
                textViews[1] = findViewById(R.id.segundo_h);
                break;
        }
        return textViews;
    }

    public void cambiarPrimeroA(View view){
        TextView primeroA = (TextView) findViewById(R.id.primero_a);
        primeroA.setText("cambie el texto");
    }

    public void sendValue(View view){
        ImageButton boton = (ImageButton) view;
        View layout = (View) boton.getParent();
        String grupo = layout.getTag().toString();
        int posicionGroupo = grupo.charAt(0)-'a';
        int posicion = ganadorGroupoLista[posicionGroupo]?1:0;
        ganadorGroupoLista[posicionGroupo] = !ganadorGroupoLista[posicionGroupo];
        (getTextViews(posicionGroupo)[posicion]).setText(boton.getTag().toString());
        ganadoresLista[posicionGroupo][posicion] = boton.getTag().toString();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position <= 7)
        {
            if(ganadoresLista[position][0] != null)
                getTextViews(position)[0].setText(ganadoresLista[position][0]);
            if(ganadoresLista[position][1] != null)
                getTextViews(position)[1].setText(ganadoresLista[position][1]);
        }
        else if (position == 8)
        {
            //Load the Send Data
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
