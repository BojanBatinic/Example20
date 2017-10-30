package com.example.androiddevelopment.glumcilegende.model;

import java.util.ArrayList;


/**
 * Created by androiddevelopment on 27.10.17..
 */

public class Film  {

    private int id;
    private String nazivFilma;
    private ArrayList<Glumac> glumci;

    public Film() {

        this.glumci = new ArrayList<>();
    }

    public Film(int id, String nazivFilma) {
        this.id = id;
        this.nazivFilma = nazivFilma;
    }

    public Film(int id, String nazivFilma, ArrayList<Glumac> glumci) {
        this.id = id;
        this.nazivFilma = nazivFilma;
        this.glumci = glumci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivFilma() {
        return nazivFilma;
    }

    public void setNazivFilma(String nazivFilma) {
        this.nazivFilma = nazivFilma;
    }

    public ArrayList<Glumac> getGlumaci() {
        return glumci;
    }

    public void setGlumci(ArrayList<Glumac> glumci) {
        this.glumci = glumci;
    }

    @Override
    public String toString() {
        return nazivFilma;
    }
}
