import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

public class Solution {

    public static final String URI = "https://www.cbr-xml-daily.ru/daily_eng_utf8.xml";

    public static void main(String args[])  {


        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(URI);


            List<Valute> valuteList = new ArrayList<>();

            NodeList valuteNodeList = document.getElementsByTagName("Valute");

            for (int i = 0; i < valuteNodeList.getLength(); i++) {
                if (valuteNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element valuteElement = (Element) valuteNodeList.item(i);
                    Valute valute = new Valute();
                    valute.setId(valuteElement.getAttribute("ID"));

                    NodeList childNodes = valuteElement.getChildNodes();

                    for (int j = 0; j < childNodes.getLength(); j++) {
                        if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element childElement = (Element) childNodes.item(j);


                            switch (childElement.getTagName()) {
                                case "NumCode":
                                    valute.setNumCode(childElement.getTextContent());
                                    break;
                                case "CharCode":
                                    valute.setCharCode(childElement.getTextContent());
                                    break;
                                case "Nominal":
                                    valute.setNominal(Integer.parseInt(childElement.getTextContent()));
                                    break;
                                case "Name":
                                    valute.setName(childElement.getTextContent());
                                    break;
                                case "Value":
                                    valute.setValue(childElement.getTextContent());
                                    break;
                            }
                        }
                    }


                    valuteList.add(valute);
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/vladimir/Desktop/myXmlParse.txt"));

            for (Valute valute : valuteList) {
                writer.write(valute.toString());
            }

            writer.close();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }



    }





}
