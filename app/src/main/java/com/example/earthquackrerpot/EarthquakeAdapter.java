package com.example.earthquackrerpot;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
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

        TextView magnitudeView = listItemView.findViewById(R.id.magnitude);

        //Pewarnaan di Magnitude
        String formattedMagnitude = formatMagnitude (currentEarthquake.getMagnitude());
        magnitudeView.setText(formattedMagnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        //Untuk mengamil tempat lokasi
        String originalLocation = currentEarthquake.getLocation();
        String primaryLocation;
        String locationOffset;

        if (originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts [0] + LOCATION_SEPARATOR;
            primaryLocation = parts [1];
        }
        else {
            locationOffset = "Near the";
            primaryLocation = originalLocation;
        }
        //Menampilkan Lokasi
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView= listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);
        //
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
        TextView dateView = listItemView.findViewsWithText(R.id.date);
        String formattedDate =  formatDate(dateObject);
        dateView.setText(formattedDate);
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
                String formattedTime = formatTime(dateObject);
                timeView.setText(formattedTime);

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
