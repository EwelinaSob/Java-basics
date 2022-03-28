package Purchases;

import java.util.Comparator;

public class Purchase {

        private String nazwa;
        private double cena;
        private String numer;
        private String klient;
        private double ilosc;

        public Purchase(String numer, String klient, String nazwa, double cena, double ilosc) {
            this.numer = numer;
            this.klient = klient;
            this.nazwa = nazwa;
            this.cena = cena;
            this.ilosc = ilosc;
        }

        public double getKoszt() {
            double koszt = this.getCena() * this.getIlosc();
            return koszt;

        }
//        public static Comparator<Purchase> nazwaArtComp = new Comparator<Purchase>() {
//
//            @Override
//            public int compare(Purchase o1, Purchase o2) {
//                String NazwaArt1 = o1.getNazwa().toUpperCase();
//                String NazwaArt2 = o2.getNazwa().toUpperCase();
//                return NazwaArt2.compareTo(NazwaArt1);
//            }};


        public String toString() {
            return numer+ ";" + klient + ";" + nazwa + ";" + cena + ";" + ilosc;

        }

        public String getNazwa() {
            return nazwa;
        }

        public void setNazwa(String nazwa) {
            this.nazwa = nazwa;
        }

        public double getCena() {
            return cena;
        }

        public void setCena(double cena) {
            this.cena = cena;
        }

        public String getNumer() {
            return numer;
        }

        public void setNumer(String numer) {
            this.numer = numer;
        }

        public String getKlient() {
            return klient;
        }

        public void setKlient(String klient) {
            this.klient = klient;
        }

        public double getIlosc() {
            return ilosc;
        }

        public void setIlosc(double ilosc) {
            this.ilosc = ilosc;
        }
    }
