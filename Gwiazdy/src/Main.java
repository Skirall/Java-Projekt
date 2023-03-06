import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void Szukaj_Nazwy(String Szukana_nazwa, ArrayList<Gwiazda>Baza_danych){
        System.out.println("Prosze podac nazwe gwiazdozbioru szukanej gwiazdy");
        for(int i = 0; i<= Baza_danych.size()-1; i++ ){
            if(Baza_danych.get(i).getGwiazdozbior().equals(Szukana_nazwa)){
                System.out.println(Baza_danych.get(i).getNazwa()); //Piotrek
            }
        }
    }
    public static void Odleglosc_w_parsekach(Double szukana_odleglosc, ArrayList<Gwiazda>Baza_danych){
        System.out.println("Prosze podac nazwe gwiazdozbioru szukanej gwiazdy");
        for(int i = 0; i<= Baza_danych.size()-1; i++ ){

            if(Baza_danych.get(i).getOdleglosc_w_latach_swietlnych() == szukana_odleglosc){
                System.out.println(Baza_danych.get(i).getNazwa());
            }
        }
    }
    public static void Supernowa(ArrayList<Gwiazda>Baza_danych){
        for(int i = 0; i<= Baza_danych.size()-1; i++ ){

            if(Baza_danych.get(i).getMasaS() >= 1.44){
                System.out.println(Baza_danych.get(i).getNazwa());
            }
        }
    }
    public static void main(String[] args) {


        ArrayList<Gwiazda> Baza_danych = new ArrayList<Gwiazda>();

        Gwiazda g1 = new Gwiazda("ABC1234","tak","tak",100,45,23,14,21,43,-2,54,545454,23);
        Gwiazda g2 = new Gwiazda("ABC4567","tak","tak",23,45,23,11,21,43,10,54,545454,23);
        Gwiazda g3 = new Gwiazda("OFS1234","nie","nie",60,45,23,23,45,43,11,54,545454,23);
        Gwiazda g4 = new Gwiazda("OFS5678","nie","nie",60,45,23,23,45,43,11,54,545454,23);


        Baza_danych.add(g1);
        Baza_danych.add(g2);
        Baza_danych.add(g3);
        Baza_danych.add(g4);
        g1.setNazwa("ABC");


        Scanner scan = new Scanner(System.in);

        String szukana_nazwa;
        double szukana_odleglosc;
        int wybor = 0;

        do
        {
            System.out.println("1.Pokaz Gwiazdy\n2.Szukaj Gwiazdy w Gwizdozbiorze\n3.Zakoncz");
            wybor = scan.nextInt();
            switch(wybor){

                case 1:
                    for (Object gwiazda: Baza_danych) {
                        System.out.println(gwiazda); //Piotrek
                    }
                    break;
                case 2:
                    Scanner nwm = new Scanner(System.in);
                    szukana_nazwa = nwm.nextLine();
                    System.out.println("Prosze podac nazwe gwiazdozbioru szukanej gwiazdy");
                    Szukaj_Nazwy(szukana_nazwa,Baza_danych);
                    break;
                case 3:
                    Scanner pr = new Scanner(System.in);
                    szukana_odleglosc =Double.parseDouble(pr.nextLine());
                    Odleglosc_w_parsekach(szukana_odleglosc,Baza_danych);
                case 4:
                    Supernowa(Baza_danych);

            }
        }
        while(wybor < 4);
    }
}