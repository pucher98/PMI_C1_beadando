package Beadando;

public enum Kemoterapia {
    KURATÍV("Teljes gyógyulás elérése a cél"),
    RÁDIÓ("A sugárterápia hatékonyságának növelésére olyan kemoterápiás szert alkalmaznak, ami a daganatot érzékenyebbé teszi a sugárkezelésre."),
    NEOADJUVÁNS("A daganat méretének csökkentésére alkalmazzák az eltávolító műtétet megelőzően, hogy műthetővé válhasson a daganat."),
    ADJUVÁNS("Műtétet vagy sugárterápiát követően alkalmazzák, hogy a daganat kiújulásának esélyét csökkentsék."),
    PALLIATAV("Ha teljes gyógyulás nem érhető már el, akkor a daganat kontrollálása és a betegség előrehaladásának lassítása céljából alkalmazzák.");

    public final String label;

    private Kemoterapia(String label){
        this.label= label;
    }

    public String getKemoterapia(){
        return this.label;
    }


}
