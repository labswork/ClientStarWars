package utils;

import models.People;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rootid on 08.04.2017.
 */
public class ParserStax implements Parser {
    @Override
    public People getObject(String filePath, Class c) {
        String fileName = filePath;
        People people = null;
        List<String> films = null;
        List<String> species = null;
        List<String> vehicles = null;
        List<String> starships = null;
        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));

            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
//                    System.out.println(xmlr.getLocalName());

                    switch (xmlr.getName().getLocalPart()){

                        case "People":
                            people = new People();
                            if (xmlr.getAttributeCount() == 1) people.setUrl(xmlr.getAttributeValue( "", "url"));
                            break;

                        case "name":
                            assert people != null;
                            people.setName(xmlr.getText());
                            break;

                        case "height":
                            assert people != null;
                            people.setHeight(xmlr.getText());
                            break;

                        case "mass":
                            assert people != null;
                            people.setMass(xmlr.getText());
                            break;

                        case "hair_color":
                            assert people != null;
                            people.setHair_color(xmlr.getText());
                            break;

                        case "skin_color":
                            assert people != null;
                            people.setSkin_color(xmlr.getText());
                            break;

                        case "eye_color":
                            assert people != null;
                            people.setEye_color(xmlr.getText());
                            break;

                        case "birth_year":
                            assert people != null;
                            people.setBirth_year(xmlr.getText());
                            break;

                        case "gender":
                            assert people != null;
                            people.setGender(xmlr.getText());
                            break;

                        case "homeworld":
                            assert people != null;
                            people.setHomeworld(xmlr.getText());
                            break;

                        case "films":
                            films = new ArrayList<>();
                            break;

                        case "film":
                            assert films != null;
                            films.add(xmlr.getText());
                            break;

                        case "species":
                            species = new ArrayList<>();
                            break;

                        case "specie":
                            assert species != null;
                            species.add(xmlr.getText());
                            break;

                        case "vehicles":
                            vehicles = new ArrayList<>();
                            break;

                        case "vehicle":
                            assert vehicles != null;
                            vehicles.add(xmlr.getText());
                            break;

                        case "starships":
                            starships = new ArrayList<>();
                            break;

                        case "starship":
                            assert starships != null;
                            starships.add(xmlr.getText());
                            break;

                    }

                } else if (xmlr.isEndElement()) {
                } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                }
            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
        }

        return people;
    }

    @Override
    public void setObject(String file, Object o) {

    }
}
