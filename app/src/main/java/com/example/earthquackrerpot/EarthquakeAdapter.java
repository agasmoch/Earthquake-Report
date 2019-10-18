package com.example.earthquackrerpot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter <Earthquake> {
    private static final  String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, int resource, List<Earthquake> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView==null){
            listItemView= LayoutInflater.from(getContext())
                    .inflate(R.layout.earthquake_list_item,parent,false);
        }
        Earthquake currentEarthquake = getItem(position);

        TextView manitudeView = (TextView) listItemView.findViewById(R.id.magnitude);

        String formattedMagnitude = formatMagnitude (currentEarthquake.getMagnitude());
        return listItemView;
    }

    private int getMagnitudeColor (double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
            magnitudeColorResourceId = R.color.magnitude1;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
            default:
                magnitudeColorResourceId = R.color.magnitude10;

        }
        return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
    }
    //Memasukan magnitude dengan bilangan desimal
    private  String formatMagnitude(double magnitude){
        DecimalFormat magnitudeFormat = new
                DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);

    }
    //Mengubah Long (time) menjadi tgl-bln-thn
    private String formatDate (Date dataObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LL dd,yyyy");
        return dateFormat.format(dataObject);
    }
    //Mengubah Long (time) menjadi tgl-bln-thn
    private String formatTime (Date dataObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("LL dd,yyyy");
        return timeFormat.format(dataObject);
    }
}
