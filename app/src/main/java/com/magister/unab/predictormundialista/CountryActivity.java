package com.magister.unab.predictormundialista;

import android.os.Debug;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.support.constraint.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

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

    public void sendPrediction (View view){
        Toast.makeText(this, "Enviado correctamente", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){}

    @Override
    public void onPageSelected(int position) {
        if (position <= 7){
            if(ganadoresLista[position][0] != null)
                getTextViews(position)[0].setText(ganadoresLista[position][0]);
            if(ganadoresLista[position][1] != null)
                getTextViews(position)[1].setText(ganadoresLista[position][1]);
        }else if (position == 8){
            List<TextView> finalistas = new ArrayList<TextView>();

            finalistas.add((TextView) findViewById(R.id.idTextFinalista1));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista2));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista3));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista4));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista5));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista6));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista7));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista8));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista9));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista10));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista11));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista12));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista13));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista14));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista15));
            finalistas.add((TextView) findViewById(R.id.idTextFinalista16));

            for(int group=0,u=0;group<8;group++){
                ConstraintLayout[] panels = getPanelViews(group);
                for(int e=0;e<2;e++){
                    String country = ganadoresLista[group][e];
                    finalistas.get(u++).setText(country);
                    //Set Flag
                    if (country != null && !country.isEmpty())
                        try
                        {
                            panels[e].setBackground(ContextCompat.getDrawable(this, FlagEntity.valueOf(country.replace(" ", "_")).getDrawableResId()));
                        }catch (Exception ex)
                        {
                            Log.d("Exception", ex.getMessage());
                        }
                }
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state){}

    /**
     * Get the Text by Position
     * @param posicionGrupo Position
     * @return Texts
     */
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

    /**
     * Get the Panels by Position
     * @param posicionGrupo Position
     * @return Panels
     */
    private ConstraintLayout[] getPanelViews(int posicionGrupo){
        ConstraintLayout[] panelViews = new ConstraintLayout[2];
        switch(posicionGrupo){
            case 0:
                panelViews[0] = findViewById(R.id.idPanel1A);
                panelViews[1] = findViewById(R.id.idPanel2A);
                break;
            case 1:
                panelViews[0] = findViewById(R.id.idPanel1B);
                panelViews[1] = findViewById(R.id.idPanel2B);
                break;
            case 2:
                panelViews[0] = findViewById(R.id.idPanel1C);
                panelViews[1] = findViewById(R.id.idPanel2C);
                break;
            case 3:
                panelViews[0] = findViewById(R.id.idPanel1D);
                panelViews[1] = findViewById(R.id.idPanel2D);
                break;
            case 4:
                panelViews[0] = findViewById(R.id.idPanel1E);
                panelViews[1] = findViewById(R.id.idPanel2E);
                break;
            case 5:
                panelViews[0] = findViewById(R.id.idPanel1F);
                panelViews[1] = findViewById(R.id.idPanel2F);
                break;
            case 6:
                panelViews[0] = findViewById(R.id.idPanel1G);
                panelViews[1] = findViewById(R.id.idPanel2G);
                break;
            case 7:
                panelViews[0] = findViewById(R.id.idPanel1H);
                panelViews[1] = findViewById(R.id.idPanel2H);
                break;
        }
        return panelViews;
    }
}
