package Beadando;

public class Sugar extends Beteg{
    public String sugarKezeles;
    public int eloirtSugar;
    public int jelenlegiSugar;

    public Sugar(int ujTajszam, String ujNev, String ujLakhely, int ujEv, int ujHo, int ujNap, int ujNem, int ujTelefonszam, String ujDiagnozis, String ujKezeles, int ujEloirtCiklusokSzama,
                 int ujJelenlegiCiklusokSzama, int ujKorterem, String ujGyogyszerek, Kemoterapia ujKemoterapia, int ujKapeSugart, String sugarKezeles, int eloirtSugar, int jelenlegiSugar) {
        super(ujTajszam, ujNev, ujLakhely, ujEv, ujHo, ujNap, ujNem, ujTelefonszam, ujDiagnozis, ujKezeles, ujEloirtCiklusokSzama, ujJelenlegiCiklusokSzama, ujKorterem, ujGyogyszerek, ujKemoterapia, ujKapeSugart);
        this.sugarKezeles = sugarKezeles;
        this.eloirtSugar = eloirtSugar;
        this.jelenlegiSugar = jelenlegiSugar;
    }


    public String getSugarKezeles() {
        return sugarKezeles;
    }

    public void setSugarKezeles(String sugarKezeles) {
        this.sugarKezeles = sugarKezeles;
    }

    public int getEloirtSugar() {
        return eloirtSugar;
    }

    public void setEloirtSugar(int eloirtSugar) {
        this.eloirtSugar = eloirtSugar;
    }

    public int getJelenlegiSugar() {
        return jelenlegiSugar;
    }

    public void setJelenlegiSugar(int jelenlegiSugar) {
        this.jelenlegiSugar = jelenlegiSugar;
    }
}
