package Beadando;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;




public class XmlReader {
    public static void main(String[] args){
        ArrayList<Sugar> betegek = XmlReader.readBetegekFromXml("src/main/resources/betegek.xml");
        System.out.println(betegek.size());
        System.out.println(betegek);
    }


    public static ArrayList<Sugar> readBetegekFromXml(String filepath)  {
        ArrayList<Sugar> betegek = new ArrayList<>();
        try {
            DocumentBuilderFactory documentBuilderFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder =
                    documentBuilderFactory.newDocumentBuilder();
            Document document =
                    documentBuilder.parse(filepath);
            Element rootElement = document.getDocumentElement();
            NodeList childNodesList = rootElement.getChildNodes();
            int numberOfElementNodes = 0;
            Node node;
            for (int i = 0; i < childNodesList.getLength(); i++) {
                node = childNodesList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    numberOfElementNodes++;
                    NodeList childNodesOfBetegTag = node.getChildNodes();
                    String nev = "", tajszam = "", lakhely = "", ev = "", ho = "", nap ="", nem = "", telefonszam = "", diagnozis = "",
                            kezeles = "", eloirtCiklusokSzama = "", jelenlegiCiklusokSzama = "", korterem = "", gyogyszerek = "", kemoterapia = "", kapeSugart= "", sugarKezeles="", eloirtSugar="", jelenlegiSugar="";
                    for (int j = 0; j < childNodesOfBetegTag.getLength(); j++) {
                        if (childNodesOfBetegTag.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            switch (childNodesOfBetegTag.item(j).getNodeName()) {
                                case "tajszam" -> tajszam = childNodesOfBetegTag.item(j).getTextContent();
                                case "nev" -> nev = childNodesOfBetegTag.item(j).getTextContent();
                                case "lakhely" -> lakhely = childNodesOfBetegTag.item(j).getTextContent();
                                case "ev" -> ev = childNodesOfBetegTag.item(j).getTextContent();
                                case "ho" -> ho = childNodesOfBetegTag.item(j).getTextContent();
                                case "nap" -> nap = childNodesOfBetegTag.item(j).getTextContent();
                                case "nem" -> nem = childNodesOfBetegTag.item(j).getTextContent();
                                case "telefonszam" -> telefonszam = childNodesOfBetegTag.item(j).getTextContent();
                                case "diagnozis" -> diagnozis = childNodesOfBetegTag.item(j).getTextContent();
                                case "kezeles" -> kezeles = childNodesOfBetegTag.item(j).getTextContent();
                                case "eloirtCiklusokSzama" -> eloirtCiklusokSzama = childNodesOfBetegTag.item(j).getTextContent();
                                case "jelenlegiCiklusokSzama" -> jelenlegiCiklusokSzama = childNodesOfBetegTag.item(j).getTextContent();
                                case "korterem" -> korterem = childNodesOfBetegTag.item(j).getTextContent();
                                case "gyogyszerek" -> gyogyszerek = childNodesOfBetegTag.item(j).getTextContent();
                                case "kemoterapia" -> kemoterapia = childNodesOfBetegTag.item(j).getTextContent();
                                case "kapeSugart" -> kapeSugart = childNodesOfBetegTag.item(j).getTextContent();
                                case "sugarKezeles" -> sugarKezeles = childNodesOfBetegTag.item(j).getTextContent();
                                case "eloirtSugar" -> eloirtSugar = childNodesOfBetegTag.item(j).getTextContent();
                                case "jelenlegiSugar" -> jelenlegiSugar = childNodesOfBetegTag.item(j).getTextContent();
                            }
                        }
                    }
                    betegek.add(new Sugar(Integer.parseInt(tajszam), nev, lakhely,Integer.parseInt(ev), Integer.parseInt(ho), Integer.parseInt(nap), Integer.parseInt(nem), Integer.parseInt(telefonszam),
                            diagnozis, kezeles, Integer.parseInt(eloirtCiklusokSzama), Integer.parseInt(jelenlegiCiklusokSzama), Integer.parseInt(korterem), gyogyszerek,Kemoterapia.valueOf(kemoterapia),
                            Integer.parseInt(kapeSugart), sugarKezeles, Integer.parseInt(eloirtSugar),Integer.parseInt(jelenlegiSugar) ));
                }
            }
        }catch  (Exception e){
            e.printStackTrace();
        }
        return betegek;
    }
}
