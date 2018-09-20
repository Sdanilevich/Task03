package by.htp.catalognews.dao.xml;

import by.htp.catalognews.entity.CatalogNews;
import by.htp.catalognews.service.Util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class JaxbParser {

    public static CatalogNews readXML(String path) throws IOException, JAXBException {

        JAXBContext jc = JAXBContext.newInstance(CatalogNews.class);
        Unmarshaller u = jc.createUnmarshaller();
        if (Util.checkExistFile(path)) {
            FileReader reader = new FileReader(path);
            return (CatalogNews) u.unmarshal(reader);
        }
        return null;
    }

    public static void saveFile(CatalogNews catalogNews, String nameFile) throws JAXBException, FileNotFoundException {
           JAXBContext context = JAXBContext.newInstance(CatalogNews.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(catalogNews, new FileOutputStream(nameFile));
    }
}
