package Beadando;

public class Beteg {
    private int tajszam;
    private String nev;
    private String lakhely;
    private int ev;
    private int ho;
    private int nap;
    private int nem;
    private int telefonszam;
    private String diagnozis;
    private String kezeles;
    private int eloirtCiklusokSzama;
    private int jelenlegiCiklusokSzama;
    private int korterem;
    private String gyogyszerek;
    private Kemoterapia kemoterapia;
    private int kapeSugart;



    //Konstruktor
    public Beteg(int tajszam, String nev, String lakhely, int ev, int ho, int nap, int nem, int telefonszam, String diagnozis, String kezeles, int eloirtCiklusokSzama,
                 int jelenlegiCiklusokSzama, int korterem, String gyogyszerek, Kemoterapia kemoterapia, int kapeSugart){
        this.tajszam = tajszam;
        this.nev = nev;
        this.lakhely = lakhely;
        this.ev = ev;
        this.ho = ho;
        this.nap = nap;
        this.nem = nem;
        this.telefonszam = telefonszam;
        this.diagnozis = diagnozis;
        this.kezeles = kezeles;
        this.eloirtCiklusokSzama = eloirtCiklusokSzama;
        this.jelenlegiCiklusokSzama = jelenlegiCiklusokSzama;
        this.korterem = korterem;
        this.gyogyszerek = gyogyszerek;
        this.kemoterapia = kemoterapia;
        this.kapeSugart = kapeSugart;
    }


    // Getter, Setter


    public String getGyogyszerek() {
        return gyogyszerek;
    }

    public void setGyogyszerek(String gyogyszerek) {
        this.gyogyszerek = gyogyszerek;
    }

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public int getHo() {
        return ho;
    }

    public void setHo(int ho) {
        this.ho = ho;
    }

    public int getNap() {
        return nap;
    }

    public void setNap(int nap) {
        this.nap = nap;
    }

    public String getLakhely() {
        return lakhely;
    }

    public void setLakhely(String lakhely) {
        this.lakhely = lakhely;
    }

    public String getKezeles() {
        return kezeles;
    }

    public void setKezeles(String kezeles) {
        this.kezeles = kezeles;
    }

    public int getTajszam() {
        return tajszam;
    }

    public void setTajszam(int tajszam) {
        this.tajszam = tajszam;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getNem() {
        return nem;
    }

    public void setNem(int nem) {
        this.nem = nem;
    }

    public String getDiagnozis() {
        return diagnozis;
    }

    public void setDiagnozis(String diagnozis) {
        this.diagnozis = diagnozis;
    }


    public int getEloirtCiklusokSzama() {
        return eloirtCiklusokSzama;
    }

    public void setEloirtCiklusokSzama(int eloirtCiklusokSzama) {
        this.eloirtCiklusokSzama = eloirtCiklusokSzama;
    }

    public int getJelenlegiCiklusokSzama() {
        return jelenlegiCiklusokSzama;
    }

    public void setJelenlegiCiklusokSzama(int jelenlegiCiklusokSzama) {
        this.jelenlegiCiklusokSzama = jelenlegiCiklusokSzama;
    }
    public int getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(int telefonszam) {
        this.telefonszam = telefonszam;
    }

    public int getKorterem() {
        return korterem;
    }

    public void setKorterem(int korterem) {
        this.korterem = korterem;
    }

    public Kemoterapia getKemoterapia() {
        return kemoterapia;
    }

    public int getKapeSugart() {
        return kapeSugart;
    }

    public void setKapeSugart(int kapeSugart) {
        this.kapeSugart = kapeSugart;
    }

    /*@Override
    public String toString() {
        return nev + '(' + tajszam + ')';
    }*/

    @Override
    public String toString() {
        return "Beteg[" +
                "Tajszám:" + tajszam +
                ", Név:" + nev +
                ", lakhely:" + lakhely +
                ", Születési év:" + ev +
                ", Születési hónap:" + ho +
                ", Születési nap:" + nap +
                ", Beteg neme:" + nem +
                ", Telefonszám:" + telefonszam +
                ", Diagnózis:" + diagnozis +
                ", Kezelés:" + kezeles +
                ", Előírt ciklusainak száma:" + eloirtCiklusokSzama +
                ", Teljesített ciklusok száma:" + jelenlegiCiklusokSzama +
                ", Kórterem:" + korterem +
                ", Beteg által szedett gyógyszerek:" + gyogyszerek +
                ", Kemotárpia fajtája:" + kemoterapia +
                ", Sugárkezelés:" + kapeSugart + "]";
    }
}

