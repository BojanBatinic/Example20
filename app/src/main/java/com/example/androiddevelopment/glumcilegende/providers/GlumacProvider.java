package com.example.androiddevelopment.glumcilegende.providers;

import com.example.androiddevelopment.glumcilegende.model.Film;
import com.example.androiddevelopment.glumcilegende.model.Glumac;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by androiddevelopment on 27.10.17..
 */

public class GlumacProvider {


    public static List<Glumac> getGlumac() {

        ArrayList<Film> filmovi = new ArrayList<>();
        filmovi.add(new Film(0, "Valter brani Sarajevo"));
        filmovi.add(new Film(1, "Poslednji krug u Monci"));
        filmovi.add(new Film(2, "Sesta brzina"));


        List<Glumac> glumci = new ArrayList<>();
        glumci.add(new Glumac(0, "velimir.jpg", "Velimir Bata Zivojinovic", "Bio je jugoslovenski i srpski pozorišni, televizijski i filmski glumac. Najpoznatiji jugoslovenski glumac po ulogama u partizanskim filmovima vezanim za Drugi svetski rat...", new Date(1933,06,05), new Date(2016,05,16), filmovi));
        glumci.add(new Glumac(1, "dragan.jpg", "Dragan Gaga Nikolic", "Bio je jugoslovenski i srpski pozorišni, televizijski i filmski glumac. Važio je za predstavnika beogradskog šarma, šmekera sa karakterom gospodina, nacionalnu klasu, jednog od najvećih frajera YU filma...", new Date(1943,8,20), new Date(2016,03,11), filmovi));
        glumci.add(new Glumac(2, "zoran.jpg", "Zoran Radmilovic", "Bio je jugoslovenski i srpski pozorišni, televizijski i filmski glumac. Jedan od najboljih i najvoljenijih glumaca, kao i jedan od najvećih komičara sa ovih prostora...", new Date(1933,05,11), new Date(1985,07,21), filmovi));

        return glumci;
    }

    public static List<String> getImenaGlumaca() {

        List<String> imenaPrezimena = new ArrayList<>();
        imenaPrezimena.add("Velimir Bata Zivojinovic");
        imenaPrezimena.add("Dragan Gaga Nikolic");
        imenaPrezimena.add("Zoran Radmilovic");

        return imenaPrezimena;
    }

    public static Glumac getGlumacById(int id) {

        ArrayList<Film> filmovi = new ArrayList<>();
        filmovi.add(new Film(0, "Valter brani Sarajevo"));
        filmovi.add(new Film(1, "Poslednji krug u Monci"));
        filmovi.add(new Film(2, "Sesta brzina"));

        switch (id) {
            case 0:
                return new Glumac(0, "velimir.jpg", "Velimir Bata Zivojinovic", "Bio je jugoslovenski i srpski pozorišni, televizijski i filmski glumac. Bio je najpoznatiji jugoslovenski glumac po ulogama u partizanskim filmovima vezanim za Drugi svetski rat.", new Date(1933,06,05), new Date(2016,05,16), filmovi);
            case 1:
                return new Glumac(1, "dragan.jpg", "Dragan Gaga Nikolic", "Bio je jugoslovenski i srpski pozorišni, televizijski i filmski glumac. Važio je za predstavnika beogradskog šarma, šmekera sa karakterom gospodina, nacionalnu klasu, jednog od najvećih frajera YU filma...", new Date(1943,8,20), new Date(2016,03,11), filmovi);
            case 2:
                return new Glumac(2, "zoran.jpg", "Zoran Radmilovic", "Bio je jugoslovenski i srpski pozorišni, televizijski i filmski glumac. Jedan od najboljih i najvoljenijih glumaca, kao i jedan od najvećih komičara sa ovih prostora...", new Date(1933,05,11), new Date(1985,07,21), filmovi);
            default:
                return null;
        }
    }
}
