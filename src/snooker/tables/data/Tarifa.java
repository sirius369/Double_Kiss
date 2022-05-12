package snooker.tables.data;

import java.util.ArrayList;

public class Tarifa {
    private double cijena;
    private String naziv;

    public Tarifa(String naziv, double cijena){
        this.naziv = naziv;
        this.cijena = cijena;
    }


    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public static ArrayList<Tarifa> mockupTarife(){
        ArrayList<Tarifa> t = new ArrayList<>();
        t.add(new Tarifa("Tarifa 1", 2.1));
        t.add(new Tarifa("Tarifa 2", 2.5));
        return t;
    }

}
