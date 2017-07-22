package com.fantasy1022.hackntu.presentation.entity;

/**
 * Created by fantasy_apple on 2017/7/22.
 */

public class PlaceDetailEntity {
    private String district;
    private String season;
    private String address;
    private String lat;
    private String lng;
    private String landarea;
    private String buildarea;
    private String landuse;
    private String time;
    private String number;
    private String tranfloor;
    private String type;
    private String use;
    private String material;
    private String finish;
    private String total;
    private String price;
    private String note;
    private String nDVI;
    private String nDVIrank;
    private String buden;
    private String budenrank;
    private String elec;
    private String elecrank;

    public PlaceDetailEntity() {
    }

    public String getDistrict() {
        return district;
    }

    public String getSeason() {
        return season;
    }

    public String getAddress() {
        return address;
    }

    public Double getLat() {
        return Double.parseDouble(lat);
    }

    public Double getLng() {
        return Double.parseDouble(lng);
    }

    public String getLandarea() {
        return landarea;
    }

    public String getBuildarea() {
        return buildarea;
    }

    public String getLanduse() {
        return landuse;
    }

    public String getTime() {
        return time;
    }

    public String getNumber() {
        return number;
    }

    public String getTranfloor() {
        return tranfloor;
    }

    public String getType() {
        return type;
    }

    public String getUse() {
        return use;
    }

    public String getMaterial() {
        return material;
    }

    public String getFinish() {
        return finish;
    }

    public String getTotal() {
        return total;
    }

    public String getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    public String getnDVI() {
        return nDVI;
    }

    public int getnDVIrank() {
        if (nDVIrank == null || nDVIrank.equals("")) {
            return (int) (Math.random() * 6);
        } else {
            return Integer.parseInt(nDVIrank);
        }
    }

    public String getBuden() {
        return buden;
    }

    public int getBudenrank() {
        if (budenrank == null || budenrank.equals("")) {
            return (int) (Math.random() * 6);
        } else {
            return Integer.parseInt(budenrank);
        }
    }

    public String getElec() {
        return elec;
    }

    public int getElecrank() {

        if (elecrank == null || elecrank.equals("")) {
            return (int) (Math.random() * 6);
        } else {
            return Integer.parseInt(elecrank);
        }

    }
}
