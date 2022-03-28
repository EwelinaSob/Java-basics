package Purchases;
import Strumienie.Stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class CustomersPurchaseSortFind {

  List<Purchase> purchases = new ArrayList<Purchase>();


    public void readFile(String fname) {

        Scanner scan = null;

        try {
            scan = new Scanner(new File(fname));
        } catch (FileNotFoundException exc) {
            System.out.println("***");
            System.exit(1);
        }

        while (scan.hasNextLine()) {
            Scanner line = new Scanner(scan.nextLine()).useDelimiter(";");
            String numer = line.next();
            String klient = line.next();
            String nazwa = line.next();
            String cena = line.next();
            String ilosc = line.next();

            purchases.add(new Purchase(numer, klient, nazwa, Double.parseDouble(cena), Double.parseDouble(ilosc)));
        }
    }


    public void showSortedBy(String string) {

        if(string.equals("Nazwiska")) {
            StringBuffer sb = new StringBuffer();
            sb.append(string);
            System.out.println(sb);

             Collections.sort(purchases, (a,b) -> {
                 if (!a.getKlient().equalsIgnoreCase(b.getKlient()))
                     return a.getKlient().toUpperCase().compareTo(b.getKlient().toUpperCase()) ;
                 else
                     return a.getNumer().compareTo(b.getNumer());
             });
            purchases.stream().forEach(elt-> System.out.println(elt));
        }
        else {
            System.out.println("\n" + string);
            Collections.sort(purchases, (a,b) -> {
                if (b.getKoszt() != a.getKoszt()) return  (int) (b.getKoszt() - a.getKoszt());
                else return a.getNumer().compareTo(b.getNumer());
            });
           purchases.stream().forEach(elt-> System.out.println(elt + " (koszt: " + elt.getKoszt() + ")"));

        }
    }

    public void showPurchaseFor(String id) {

        StringBuffer sb = new StringBuffer();
        sb.append('\n').append("Klient ").append(id);
        System.out.println(sb);

         purchases.stream().filter(e->e.getNumer().equalsIgnoreCase(id))
                 .sorted((a,b)-> b.getNazwa().toUpperCase().compareTo(a.getNazwa().toUpperCase()))
                // .sorted(Purchase.nazwaArtComp)
                 .forEach(elt-> System.out.println(elt));

    }
}
