package com.academiamoviles.pokedexap.entity;

/**
 * Created by AcademiaMoviles on 18/06/2018.
 */

public class Pokemon {


    private int  number;


    private  String url;
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {

        String[]urlPart= url.split("/");
        //return Integer.parseInt(urlPart.length-1))
        return Integer.parseInt( urlPart[urlPart.length-1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
