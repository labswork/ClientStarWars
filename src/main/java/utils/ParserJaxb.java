package utils;

import models.People;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class ParserJaxb implements Parser{
    @Override
    public People getObject(String filePath, Class c) {
        File file = new File(filePath);
        People object = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            object = (People) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void setObject(String file, Object o) {
        try {
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(o, new File(file));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
