package mwkn.ucn.dk.earthquakefeed;

import java.util.Date;

/**
 * Created by User on 28-02-2017.
 */

public class QuakeModel {
    private Date time;
    private String mag;
    private String description;
    private String longitude;
    private String latitude;

    public QuakeModel() {
    }

    public QuakeModel(Date time, String magnitude, String description) {
        this.time = time;
        this.mag = magnitude;
        this.description = description;
    }

    public QuakeModel(Date time, String magnitude, String longitude, String latitude) {
        this.time = time;
        this.mag = magnitude;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
