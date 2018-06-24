package com.magister.unab.predictormundialista;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.magister.unab.predictormundialista.adapters.CountryArrayAdapter;
import com.magister.unab.predictormundialista.helpers.GroupHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GroupOneActivity  extends AppCompatActivity {

    //Properties
    private String[] countriesValue;
    private List<CountryDO> countries;
    private int groupSelected;
    private int predictionCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_one);

        //Init
        countriesValue = new String[4];
        countries = new ArrayList<>(4);
        predictionCount = 0;
    }

    /**
     * Probabilidad en porcentaje de ganar para el grupo seleccionado
     * @param view View
     */
    public void getValueProbabilityWinning(View view)
    {
        groupSelected = GroupHelper.getNumGroupSelect(view);
        countries = GroupHelper.GetAllCountryForGroup (groupSelected);
        predictionCount = 0;

        //Load all data for count group
        setCountriesDataForGroup ();
    }

    /**
     * Set all data for Countries in Group selected
     */
    private void setCountriesDataForGroup ()
    {
        DatabaseReference resultsDB = FirebaseDatabase.getInstance().getReference().child("resultados");

        resultsDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot result) {
                predictionCount = (int) result.getChildrenCount();

                //Clean for any change
                cleanData ();

                for (DataSnapshot prediction : result.getChildren())
                {
                    for (DataSnapshot group : prediction.getChildren())
                    {
                        if (Integer.decode(group.getKey()) == groupSelected)
                        {
                            String firstCountryOnGroup = null;
                            String secondCountryOnGroup = null;

                            //Load Teams of this Group
                            for (DataSnapshot team : group.getChildren()) {
                                switch (team.getKey())
                                {
                                    case "0":
                                        firstCountryOnGroup = team.getValue().toString();
                                        break;
                                    case "1":
                                        secondCountryOnGroup = team.getValue().toString();
                                        break;
                                }
                            }

                            //Set in the List the First/Second on Group
                            setFirstSecondPlaceOnGroup (firstCountryOnGroup, secondCountryOnGroup);

                            //To the next prediction
                            break;
                        }
                    }
                }

                if (countries.size() > 0)
                {
                    //Set Percentage to Win with the Prediction Count
                    setPercentageToWin ();

                    //Order by Des
                    OrderCountries();

                    //Set adapter
                    setListAdapter ();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    /**
     * Clean Data on Country
     */
    private void cleanData ()
    {
        for (CountryDO item : countries)
        {
            item.setSecondGroupCount(0);
            item.setSecondGroupCount(0);
            item.setPercentage(0);
        }
    }

    /**
     * Set in the List the First/Second on Group
     * @param firstCountryOnGroup First on Group
     * @param secondCountryOnGroup Second on Group
     */
    private void setFirstSecondPlaceOnGroup (String firstCountryOnGroup, String secondCountryOnGroup)
    {
        boolean findFirst = firstCountryOnGroup == null;
        boolean findSecond = secondCountryOnGroup == null;
        int i = 0;
        while (i < countries.size() && (!findFirst || !findSecond))
        {
            if (!findFirst && countries.get(i).getName().equalsIgnoreCase(firstCountryOnGroup))
            {
                countries.get(i).setFistOnGroupCount(countries.get(i).getFistOnGroupCount() + 1);
                findFirst = true;
            }
            if (!findSecond && countries.get(i).getName().equalsIgnoreCase(secondCountryOnGroup))
            {
                countries.get(i).setSecondGroupCount(countries.get(i).getSecondGroupCount() + 1);
                findSecond = true;
            }
            i++;
        }
    }

    /**
     * Set Percentage with the Prediction Count
     */
    private void setPercentageToWin()
    {
        if (predictionCount > 0)
        {
            for (CountryDO item : countries)
            {
                double first = item.getFistOnGroupCount();
                double percentage = first/predictionCount * 100;
                item.setPercentage((int)percentage);
            }
        }
    }

    /**
     * Set adapter of the list View
     */
    private void setListAdapter()
    {
        //Set adapter
        ListView listView = findViewById(R.id.resultListView);
        listView.setAdapter(new CountryArrayAdapter(this, countriesValue, countries));
    }

    /**
     * Order Countries
     */
    private void OrderCountries()
    {
        Collections.sort(countries, new Comparator<CountryDO>() {
            @Override
            public int compare(CountryDO c1, CountryDO c2) {
                return new Integer(c2.getPercentage()).compareTo(new Integer(c1.getPercentage()));
            }
        });
    }
}
