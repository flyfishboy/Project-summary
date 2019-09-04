package com.nchu.model;
/*
 *区域：城市下市级县级单位
 */
public class Area {
    private Integer id;

    private String areaid;

    private String area;

    private String cityid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", areaid='" + areaid + '\'' +
                ", area='" + area + '\'' +
                ", cityid='" + cityid + '\'' +
                '}';
    }
}