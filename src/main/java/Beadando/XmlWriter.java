package Beadando;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class XmlWriter {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Beteg> betegek = XmlReader.readBetegekFromXml("src/main/resources/betegek.xml");

        int choice = -1;
        while (choice != 0) {
            switch (choice) {
                case 1 -> listazas(betegek);
                case 2 -> felvetel(betegek);
                case 3 -> modositas(betegek);
                case 4 -> torles(betegek);
            }
            System.out.println("1 - Betegek listázása\r\n2 - Új beteg hozzáadása\r\n"
                    + "3 - Beteg adatainak módosítása\r\n4 - Beteg törlése\r\n0 - Kilépés");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 0 || choice > 4) {
                    System.out.println("Kérem a kívánt menűpont számát üsse be!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Nem érvényes opció!");
                scanner.nextLine();
            }
        }
        saveBetegekToXml(betegek, "src/main/resources/betegek.xml");
    }

    private static void felvetel(ArrayList<Beteg> betegek){
        int tajszam = tajszamBevitel();
        System.out.println("Írja be a beteg nevét: ");
        String nev = scanner.nextLine();
        System.out.println("Írja be a beteg lakhelyét :");
        String lakhely = scanner.nextLine();
        int ev = evBevitel();
        int ho = hoBevitel();
        int nap = napBevitel();
        int nem = nemBevitel();
        int telefonszam = telefonszamBevitel();
        System.out.println("Írja be a beteg diagnózisát :");
        String diagnozis = scanner.nextLine();
        System.out.println("Írja be a beteg Kezelési módját :");
        String kezeles = scanner.nextLine();
        int eloirtCiklusokSzama = eloirtCiklusokSzamaBevitel();
        int jelenlegiCiklusokSzama = jelenlegiCiklusokSzamaBevitel();
        int korterem = korteremBevitel();
        System.out.println("Adja meg a beteg által szedett gyógyszereket: ");
        String gyogyszerek = scanner.nextLine();
        betegek.add(new Beteg(tajszam, nev, lakhely, ev, ho, nap, nem, telefonszam, diagnozis, kezeles, eloirtCiklusokSzama, jelenlegiCiklusokSzama, korterem, gyogyszerek));
    }

    private static void modositas(ArrayList<Beteg> betegek){
        System.out.println("Írja be a módosítani kivánt beteg tajszámát: ");
        int tajszam = scanner.nextInt();
        for (Beteg beteg : betegek) {
            if(beteg.getTajszam() == tajszam){
                int ev =evBevitel();
                int ho = hoBevitel();
                int nap = napBevitel();
                System.out.println("Beteg neve: ");
                String nev = scanner.nextLine();
                System.out.println("Írja be a beteg lakhelyét :");
                String lakhely = scanner.nextLine();

                int nem = nemBevitel();
                int telefonszam = telefonszamBevitel();
                System.out.println("Írja be a beteg diagnózisát :");
                String diagnozis = scanner.nextLine();
                System.out.println("Írja be a beteg Kezelési módját :");
                String kezeles = scanner.nextLine();
                int eloirtCiklusokSzama = eloirtCiklusokSzamaBevitel();
                int jelenlegiCiklusokSzama = jelenlegiCiklusokSzamaBevitel();
                int korterem = korteremBevitel();
                System.out.println("Adja meg a beteg által szedett gyógyszereket: ");
                String gyogyszerek = scanner.nextLine();
                betegek.set(betegek.indexOf(beteg), new Beteg(tajszam, nev, lakhely, ev, ho, nap, nem, telefonszam, diagnozis, kezeles, eloirtCiklusokSzama, jelenlegiCiklusokSzama, korterem, gyogyszerek));
                System.out.println("Az adatokat sikeresen módosította");
                return;
            }
        }
        System.out.println("Nincs ilyen tajszámmal rendelkező beteg!");
    }



    private static void torles(ArrayList<Beteg> betegek) {
        System.out.println("Írja be a törölni kívánt beteg tajszámát: ");
        int tajszam = scanner.nextInt();
        for(Beteg beteg : betegek){
            if(beteg.getTajszam() == tajszam){
                betegek.remove(beteg);
                System.out.println("A beteg sikeresen eltávolítva a rendszerből!");
                return;
            }
        }
        System.out.println("Egyik beteg sem rendelkezik ezzel a tajszámmal!");

    }





    private static int tajszamBevitel(){
        int tajszam = 0;
        while (tajszam < 99999999 ||  999999999 < tajszam){
            try {
                System.out.print("Adja meg a beteg tajszámát: ");
                tajszam = scanner.nextInt();
                scanner.nextLine();
                if (tajszam < 99999999 ||  tajszam > 999999999 ){
                    System.out.println("Érvénytelen tajszám, kérem 6 számjegyből állót adjon meg!");
                }
            }catch(InputMismatchException e){
                System.out.println("Nem valós tajszám");
                scanner.nextLine();
            }
        }
        return tajszam;
    }



    private  static int nemBevitel(){
        int nem = 0;
        while (1 > nem || 2 < nem) {
            try {
                System.out.println("Adja meg a beteg nemét 1-gyel(férfi), vagy 2-vel(nő)");
                nem = scanner.nextInt();
                scanner.nextLine();
                if (nem < 1 || nem > 2) {
                    System.out.println("A nemet csak ezzel a két számmal adhatja meg! ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Adja mega nemet 1-gyel, vagy 2-vel");
                scanner.nextLine();
            }
        }
        return nem;
    }
        private  static int korteremBevitel(){
            int korterem = 0;
            while(99 > korterem || 300 < korterem){
                try {
                    System.out.println("Adja meg a beteg szobaszámát");
                    korterem = scanner.nextInt();
                    scanner.nextLine();
                    if (korterem < 99 || korterem > 300){
                        System.out.println("Kórtermet 100 és 300 között adhat meg!");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Adja meg a kórtermet 100 és 300 között!");
                    scanner.nextLine();
                }
            }
            return korterem;

    }

    private  static int evBevitel() {
        int ev = 0;
        while (1900 > ev || 2022 < ev) {
            try {
                System.out.println("Adja meg a beteg születésének évét: ");
                ev = scanner.nextInt();
                scanner.nextLine();
                if (ev < 1900 || ev > 2022) {
                    System.out.println("A születési évet 1900 és 2022 között adja meg! ");
                }
            } catch (InputMismatchException e) {
                System.out.println("A születési évet 1900 és 2022 között adja meg!");
                scanner.nextLine();
            }
        }
        return ev;
    }

    private  static int hoBevitel() {
        int ho = -1;
        while (1 > ho || 12 < ho) {
            try {
                System.out.println("Adja meg a beteg születésének hónapját: ");
                ho = scanner.nextInt();
                scanner.nextLine();
                if (ho < 0 || ho > 13) {
                    System.out.println("A születés hónapját 1 és 12 között adja meg! ");
                }
            } catch (InputMismatchException e) {
                System.out.println("A születés hónapját 1 és 12 között adja meg! ");
                scanner.nextLine();
            }
        }
        return ho;
    }
    private  static int napBevitel() {
        int nap = -1;
        while (1 > nap || 31 < nap) {
            try {
                System.out.println("Adja meg a beteg születésének napját: ");
                nap = scanner.nextInt();
                scanner.nextLine();
                if (nap < 0 || nap > 32) {
                    System.out.println("A születés napját 1 és 31 között adja meg! ");
                }
            } catch (InputMismatchException e) {
                System.out.println("\"A születés napját 1 és 31 között adja meg! ");
                scanner.nextLine();
            }
        }
        return nap;
    }

    private static int telefonszamBevitel(){
        int telefonszam = 0;
        while (99999999 > telefonszam || 999999999 < telefonszam) {
            try {
                System.out.println("Adja meg a beteg telefonszámát a +36:");
                telefonszam = scanner.nextInt();
                scanner.nextLine();
                if (telefonszam < 99999999 ||telefonszam > 999999999) {
                    System.out.println("A +36 utáni számot adja meg!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Adja meg a beteg telefonszámát!: +36");
                scanner.nextLine();
            }
        }
        return telefonszam;
    }

    private  static int eloirtCiklusokSzamaBevitel(){
        int eloirtCiklusokSzama = -1;
        while (0 > eloirtCiklusokSzama || 100 < eloirtCiklusokSzama) {
            try {
                System.out.println("Adja meg a betegnek előírt kemoterápiás ciklusok számát");
                eloirtCiklusokSzama = scanner.nextInt();
                scanner.nextLine();
                if (eloirtCiklusokSzama < 0 || eloirtCiklusokSzama > 100) {
                    System.out.println("A ciklusok számát 0 és 100 között tudja megadni! ");
                }
            } catch (InputMismatchException e) {
                System.out.println("A ciklusok számát 0 és 100 között tudja megadni! ");
                scanner.nextLine();
            }
        }
        return eloirtCiklusokSzama;
    }

    private  static int jelenlegiCiklusokSzamaBevitel(){
        int  jelenlegiCiklusokSzama = -1;
        while (0 >  jelenlegiCiklusokSzama || 100 <  jelenlegiCiklusokSzama) {
            try {
                System.out.println("Adja meg a betegnek jelenleg teljesített kemoterápiás ciklusainak számát");
                jelenlegiCiklusokSzama = scanner.nextInt();
                scanner.nextLine();
                if ( jelenlegiCiklusokSzama < 0 ||  jelenlegiCiklusokSzama > 100) {
                    System.out.println("A ciklusok számát 0 és 100 között tudja megadni! ");
                }
            } catch (InputMismatchException e) {
                System.out.println("A ciklusok számát 0 és 100 között tudja megadni! ");
                scanner.nextLine();
            }
        }
        return  jelenlegiCiklusokSzama;
    }

    private static void listazas(ArrayList<Beteg> betegek) {
        System.out.println(betegek);
    }

    public static void saveBetegekToXml(ArrayList<Beteg> betegek, String filepath){
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("betegek");
            document.appendChild(rootElement);

            for (Beteg beteg : betegek) {
                Element betegElement = document.createElement("beteg");
                rootElement.appendChild(betegElement);
                createChildElement(document, betegElement, "nev", beteg.getNev());
                createChildElement(document, betegElement, "tajszam", String.valueOf(beteg.getTajszam()));
                createChildElement(document, betegElement, "lakhely", beteg.getLakhely());
                createChildElement(document, betegElement, "ev",String.valueOf(beteg.getEv()));
                createChildElement(document, betegElement, "ho",String.valueOf(beteg.getHo()));
                createChildElement(document, betegElement, "nap",String.valueOf(beteg.getNap()));
                createChildElement(document, betegElement, "nem",String.valueOf(beteg.getNem()));
                createChildElement(document, betegElement, "telefonszam", String.valueOf(beteg.getTelefonszam()));
                createChildElement(document, betegElement, "diagnozis", beteg.getDiagnozis());
                createChildElement(document, betegElement, "kezeles", beteg.getKezeles());
                createChildElement(document, betegElement, "eloirtCiklusokSzama", String.valueOf(beteg.getEloirtCiklusokSzama()));
                createChildElement(document, betegElement, "jelenlegiCiklusokSzama", String.valueOf(beteg.getJelenlegiCiklusokSzama()));
                createChildElement(document, betegElement, "korterem", String.valueOf(beteg.getKorterem()));
                createChildElement(document, betegElement, "gyogyszerek", beteg.getGyogyszerek());
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(filepath));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createChildElement(Document document, Element parent, String tagName, String value) {
        Element element = document.createElement(tagName);
        element.setTextContent(value);
        parent.appendChild(element);
    }



}

