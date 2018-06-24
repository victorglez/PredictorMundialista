package com.magister.unab.predictormundialista.adapters;

import com.magister.unab.predictormundialista.CountryDO;
import com.magister.unab.predictormundialista.FlagEntity;
import com.magister.unab.predictormundialista.R;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<CountryDO> countries;

    /**
     * Constructor
     * @param context Context
     * @param values Value
     * @param countries Countries List
     */
    public CountryArrayAdapter(Context context, String[] values, List<CountryDO> countries) {
        super(context, R.layout.list_country_group, values);

        this.context = context;
        this.countries = countries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_country_group, parent, false);

        //Change Name
        TextView textView = rowView.findViewById(R.id.label);
        textView.setText(countries.get(position).getName());

        // Change icon based on name
        ImageView imageView = rowView.findViewById(R.id.logo);
        try
        {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, FlagEntity.valueOf(countries.get(position).getName().replace(" ", "_")).getDrawableResId()));
        }catch (Exception ex)
        {
            imageView.setImageResource(R.drawable.flag_none);
        }

        //Change Percentage
        TextView percentageView = rowView.findViewById(R.id.percentage);
        percentageView.setText(countries.get(position).getPercentage() + " %");

        return rowView;
    }
}
