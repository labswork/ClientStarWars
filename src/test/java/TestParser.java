import models.People;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Client;
import utils.Parser;
import utils.ParserJaxb;

import java.io.File;


public class TestParser {
    @BeforeSuite
    public void setUp(){
        Client client = new Client();
        ParserJaxb parser = new ParserJaxb();
        File file = new File("fileName.xml");
    }


    public void testSetObject(String file){

        Client client = new Client();
        Parser parser = new ParserJaxb();

        client.getPeopleByID(1).ifPresent(people -> parser.setObject(file, people));
    }

    @Test
    public void testGetObgect(){
        String file = "fileName.xml";
        testSetObject(file);
        Client client = new Client();
        Parser parser = new ParserJaxb();

        People peopleFromXML = parser.getObject(file, People.class);
        client.getPeopleByID(1).ifPresent(people -> compare(people, peopleFromXML) );
        client.getPeopleByID(1).ifPresent(people -> Assert.assertEquals(people, peopleFromXML));


    }
    public void compare(People people, People peopleFromXML){
        Assert.assertEquals(people.getName(), peopleFromXML.getName());
        Assert.assertEquals(people.getUrl(), peopleFromXML.getUrl());
        Assert.assertEquals(people.getBirth_year(), peopleFromXML.getBirth_year());
        Assert.assertEquals(people.getEye_color(), peopleFromXML.getEye_color());
        Assert.assertEquals(people.getGender(), peopleFromXML.getGender());
        Assert.assertEquals(people.getHair_color(), peopleFromXML.getHair_color());
        Assert.assertEquals(people.getHeight(), peopleFromXML.getHeight());
        Assert.assertEquals(people.getHomeworld(), peopleFromXML.getHomeworld());
        Assert.assertEquals(people.getMass(), peopleFromXML.getMass());
        Assert.assertEquals(people.getSkin_color(), peopleFromXML.getSkin_color());
        Assert.assertEquals(people.getFilms(), peopleFromXML.getFilms());
//        Assert.assertEquals(people.getID(), peopleFromXML.getID());
        Assert.assertEquals(people.getSpecies(), peopleFromXML.getSpecies());
        Assert.assertEquals(people.getStarships(), peopleFromXML.getStarships());
        Assert.assertEquals(people.getVehicles(), peopleFromXML.getVehicles());

    }
}
