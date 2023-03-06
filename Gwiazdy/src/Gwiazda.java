import java.util.Collections;
import java.util.ArrayList;

public class Gwiazda {

    private String nazwa;
    public String nazwa_katalogowa;
    private String deklinacja;
    private String rektascensja;
    private double obserwowana_wielkosc_giwazdowa;
    private String półkula;
    private double absolutna_wielkosc_giwazdowa;
    private double odleglosc_w_latach_swietlnych;
    private String gwiazdozbior;
    private int temperatura;
    private  double masaS;

    public String getNazwa() {
        return nazwa;
    }
    public String getRektascensja() {
        return rektascensja;
    }
    public double getObserwowana_wielkosc_giwazdowa() {
        return obserwowana_wielkosc_giwazdowa;
    }
    public Double getObserwowana_Wielkosc_Gwiazdowa(){return obserwowana_wielkosc_giwazdowa;}
    public Double getAbsolutna_Wielkosc_Gwiazdowa(){return absolutna_wielkosc_giwazdowa;}
    public double getOdleglosc_w_latach_swietlnych() {
        return odleglosc_w_latach_swietlnych;
    }
    public String getGwiazdozbior(){return gwiazdozbior;}
    public int getTemperatura(){return temperatura;}
    public double getMasaS(){return masaS;}

    public String getPółkula(){
        return półkula;
    }

    public void setNazwa(String nazwa) {

        if (nazwa.length() != 7) {
            System.out.println("Nazwa gwiazdy jest nie odpowiednia");
        } else {
            {
                int Zliczanie_duzych_liter = 0;
                int Zliczanie_cyfr = 0;
                for (int i = 0; i <= nazwa.length() - 1; i++) {
                    int x = nazwa.charAt(i);
                    if (x >= 65 && x <= 90) {
                        Zliczanie_duzych_liter += 1;
                    }
                    if (x >= 48 && x <= 57) {
                        Zliczanie_cyfr += 1;
                    }
                }
                if (Zliczanie_duzych_liter == 3 && Zliczanie_cyfr == 4) {
                    this.nazwa = nazwa;
                } else {
                    System.out.println("Nazwa gwiazdy jest nie odpowiednia");
                }
            }
        }


    } //Piotr - Stworzył warunek do nazwa
    public String getDeklinacja() {
        return deklinacja;
    }

    public void setObserwowana_wielkosc_giwazdowa(double owg){
        if (owg< -26.74 || owg > 15)
        {
            System.out.print("Niepoprawna obserwowana wielkość giwazdowa");
        } else {
            obserwowana_wielkosc_giwazdowa = owg;
        }
    } // Krzysiek Zdonek

    public void setAbsolutna_wielkosc_giwazdowa(int par){absolutna_wielkosc_giwazdowa = obserwowana_wielkosc_giwazdowa - (5*(Math.log(par)/Math.log(10)))+5;}

    public void setGwiazdozbior(String NazK){
        NazK = gwiazdozbior;
    }
    public void setTemperatura(int temp){
        if(temp<2000)
        {
            System.out.print("Temperatura jest za niska!");
        }else{
            temperatura = temp;
        }
    }
    public void setMasaS(double masa)
    {
        if (masa<0.1 || masa>50)
        {
            System.out.print("Masa gwiazdy jest nie poprawna");
        }else {
            masaS = masa;
        }
    }


    public Gwiazda() {
        nazwa = "";
        nazwa_katalogowa = "";
        deklinacja = BudowaDekklinacji(0, 0, 0);
        rektascensja = BudowaRektascensji(0, 0, 0);
        półkula = "";
        obserwowana_wielkosc_giwazdowa = 0;
        absolutna_wielkosc_giwazdowa = 0;
        odleglosc_w_latach_swietlnych = 0;
        gwiazdozbior = "Pustka";
        temperatura = 2000;
        masaS = 0.1;
    }

    public Gwiazda(String Naz, String nazK,String Gwiazdo, int stopnie, int minuty, int sekundy, int h, int m, int s, double owg, int par, int temp, double masa) { //Piotr - Stworzył konstruktor i warunek do nazwa

        if (Naz.length() != 7) {
            System.out.println("Nazwa gwiazdy jest nie odpowiednia");
        } else {
            {
                int Zliczanie_duzych_liter = 0;
                int Zliczanie_cyfr = 0;
                for (int i = 0; i <= Naz.length() - 1; i++) {
                    int x = Naz.charAt(i);
                    if (x >= 65 && x <= 90) {
                        Zliczanie_duzych_liter += 1;
                    }
                    if (x >= 48 && x <= 57) {
                        Zliczanie_cyfr += 1;
                    }
                }
                if (Zliczanie_duzych_liter == 3 && Zliczanie_cyfr == 4) {
                    nazwa = Naz;
                } else {
                    System.out.println("Nazwa gwiazdy jest nie odpowiednia");
                }
            }
        } //Piotrek

        deklinacja = BudowaDekklinacji(stopnie, minuty, sekundy); //Piotr

        rektascensja = BudowaRektascensji(h, m, s); //Piotr

        if (owg < -26.74 || owg > 15) // Krzysiek Zdonek
        {
            System.out.println("Niepoprawna obserwowana wielkość giwazdowa");
        } else {
            obserwowana_wielkosc_giwazdowa = owg;
        }

        absolutna_wielkosc_giwazdowa = obserwowana_wielkosc_giwazdowa - (5*(Math.log(par)/Math.log(10)))+5;
        odleglosc_w_latach_swietlnych = par*3.26;

        if(temp<2000) //Krzysztof
        {
            System.out.print("Temperatura jest za niska!");
        }else{
            temperatura = temp;
        }
        if (masa<0.1 || masa>50)
        {
            System.out.print("Masa gwiazdy jest nie poprawna");
        }else {
            masaS = masa;
        }


        String Pokula; //Piotr
        if(stopnie > 90 || stopnie < -90){
            System.out.println("Nie mozna ustalic polkuli");
        } else if (stopnie < 0 && stopnie > -90){
            półkula =  "PD";
        }else{
            półkula =  "PN";
        }

        String[] Litery_Greckie ={"alpha","beta","gamma","delta","epsilon","zeta","eta","theta"};

        this.gwiazdozbior = Gwiazdo;

        if (NazwaKatalogowa.Nazwa_Katalogowa.contains(nazK))
        {
            int wystapienie = Collections.frequency(NazwaKatalogowa.Nazwa_Katalogowa,nazK);
            this.nazwa_katalogowa = Litery_Greckie[wystapienie]+ " " + nazK;
        } else
        {
            NazwaKatalogowa.Nazwa_Katalogowa.add(nazK);
            this.nazwa_katalogowa = Litery_Greckie[0] + " "+ nazK;
        }//Krzysztof

    }

    public String BudowaDekklinacji(int stopnie, int minuty, int sekundy) {

        int[] deklinacjaTab = {0, 0, 0};


        if ((stopnie > 90 || stopnie < -90) || (minuty < 0 || minuty > 60) || (sekundy < 0 || sekundy > 60)) {
            System.out.println("Blad podczas wpisywania deklinacji");
        } else {
            deklinacjaTab[0] = stopnie;
            deklinacjaTab[1] = minuty;
            deklinacjaTab[2] = sekundy;
        }
        String deklinacja = deklinacjaTab[0] + " stopni " + deklinacjaTab[1] + " minut " + deklinacjaTab[2] + " sekund";

        return deklinacja;
    } //Piotr - Zrobił metode budującą deklinacje

    public String BudowaRektascensji(int godziny, int minuty, int sekundy) {

        int[] rektascensjaTab = {0, 0, 0};

        if ((godziny > 24 || godziny < 0) || (minuty < 0 || minuty > 60) || (sekundy < 0 || sekundy > 60)) {
            System.out.println("Blad podczas wpisywania rektascensji");
        } else {
            rektascensjaTab[0] = godziny;
            rektascensjaTab[1] = minuty;
            rektascensjaTab[2] = sekundy;
        }
        String rektascensja = rektascensjaTab[0] + "h " + rektascensjaTab[1] + "m " + rektascensjaTab[2] + "s";

        return rektascensja;

    } // Piotr - Zrobił metode budujaca rektascensje

    public void Budowa_Nazwa_katalogowa(String NazK) {

        String[] Litery_Greckie = {"alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta"};

        ArrayList<String> Konstelacje = new ArrayList<String>();

        if (Konstelacje.contains(NazK)) {
            int wystapienie = Collections.frequency(Konstelacje, NazK);
            this.nazwa_katalogowa = Litery_Greckie[wystapienie] + " " + NazK;
            System.out.println(Konstelacje);
        } else {
            Konstelacje.add(NazK);
            this.nazwa_katalogowa = Litery_Greckie[0] + " " + NazK;
            System.out.println(Konstelacje);
        }//Krzysztof


    }

    public String toString() { //Piotr
        return this.nazwa +"| Nazwa katalogowa: " +"| Gwiazdozbior: " + this.gwiazdozbior + this.nazwa_katalogowa +  "| deklinacja: " + this.deklinacja + "| rektascensja: " + this.rektascensja +
                "| obserwowana_wielkosc_giwazdowa: " + obserwowana_wielkosc_giwazdowa + "| półkula: " + półkula +
                "| absolutna_wielkosc_giwazdowa: " + absolutna_wielkosc_giwazdowa + "| odleglosc_w_latach_swietlnych: " +
                odleglosc_w_latach_swietlnych + "| temperatura: " + temperatura + "| masa: " + masaS;
    }

}
