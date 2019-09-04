package cn.keshe.entity;

public class position {

    private String lat;
    private String lon;
    private String d_name;
    private String t_id;
    private String n_id;

    public position() {
    }

    public position(String lat, String lon, String d_name, String t_id, String n_id) {
        this.lat = lat;
        this.lon = lon;
        this.d_name = d_name;
        this.t_id = t_id;
        this.n_id = n_id;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public void setN_id(String n_id) {
        this.n_id = n_id;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getD_name() {
        return d_name;
    }

    public String getT_id() {
        return t_id;
    }

    public String getN_id() {
        return n_id;
    }
}
