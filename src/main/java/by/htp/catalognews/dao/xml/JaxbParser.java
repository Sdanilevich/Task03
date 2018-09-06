package by.htp.catalognews.dao.xml;

import by.htp.catalognews.entity.CatalogNews;
import by.htp.catalognews.main.Main;
import by.htp.catalognews.service.Constant;
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

    public static CatalogNews readXML(String path) throws IOException {

        CatalogNews catalogNews = Main.getContextSpring().getBean("idCatalogNews",CatalogNews.class);
        try {
            JAXBContext jc = JAXBContext.newInstance(CatalogNews.class);
            Unmarshaller u = jc.createUnmarshaller();
            if (Util.checkExistFile(path)) {
                FileReader reader = new FileReader(path);
                catalogNews = (CatalogNews) u.unmarshal(reader);
            }
            else {
                catalogNews = new CatalogNews();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return catalogNews;
    }

    public static void saveFile(CatalogNews catalogNews) {
        try {
            JAXBContext context = JAXBContext.newInstance(CatalogNews.class);
            Marshaller m = context.createMarshaller();
            m.marshal(catalogNews, new FileOutputStream(Constant.getFullPathFileXML()));

        } catch (FileNotFoundException e) {System.out.println("error XML: " + e);}
        catch (JAXBException e) {        System.out.println("error JAXB:" + e);        }
    }
}
