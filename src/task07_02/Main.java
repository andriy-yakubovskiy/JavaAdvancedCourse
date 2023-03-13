/*
It is necessary that the project creates an XML file and builds a tree (city, street name, house).
In a city, use an attribute (for example, <city size=”big>Kiev</city>).
Using JAXB and SAXParser to read.
*/
package task07_02;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Addresses address = new Addresses("Kyiv", "big", "Naperejna", 20);

        File directory = new File("");
        String myPath = directory.getAbsolutePath();
        String myFilePath = myPath + "\\myfile.xml";

        //create
        try {
            File file = new File(myFilePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Addresses.class);
            Marshaller mar = jaxbContext.createMarshaller();

            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            mar.marshal(address, file);
            mar.marshal(address, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
            exit(0);
        }

        //pars
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean city = false;
                String typeCity = "";
                boolean street = false;
                boolean house = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equalsIgnoreCase("city")) {
                        city = true;
                    }
                    if (!(attributes.getValue("citySize") == null)) {
                        typeCity = attributes.getValue("citySize");
                    }
                    if (qName.equalsIgnoreCase("street")) {
                        street = true;
                    }
                    if (qName.equalsIgnoreCase("house")) {
                        house = true;
                    }
                }

                @Override
                public void characters(char ch[], int start, int length) {
                    if (city) {
                        System.out.println("city: " + new String(ch, start, length));
                        city = false;
                    }
                    if (!typeCity.isEmpty()) {
                        System.out.println("citySize: " + typeCity);
                        typeCity = "";
                    }
                    if (street) {
                        System.out.println("street: " + new String(ch, start, length));
                        street = false;
                    }
                    if (house) {
                        System.out.println("house: " + new String(ch, start, length));
                        house = false;
                    }
                }
            };

            saxParser.parse(myFilePath, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}