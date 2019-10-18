package com.example.earthquackrerpot;

public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    private  long mTimeInMilliseconds;
    private String mUrl;

    /** Membuat object baru "Earthqueake" (@link Earthquake)
     *
     * @param mMagnitude = Besar suatu gempa
     * @param mLocation = Lokasi gempa berada
     * @param mTimeInMilliseconds = Waktu dalam Milliseconds
     * @param mUrl = Website untuk menjelaskan detail gempa
     */

    public Earthquake(double mMagnitude, String mLocation, long mTimeInMilliseconds, String mUrl) {
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mTimeInMilliseconds = mTimeInMilliseconds;
        this.mUrl = mUrl;
    }

    /** Membuat getter baru dengan variabel yang sudah dibuat
     *
     * @return
     */

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getUrl() {
        return mUrl;
    }
}
