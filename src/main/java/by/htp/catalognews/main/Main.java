package by.htp.catalognews.main;

import by.htp.catalognews.dao.xml.JaxbParser;
import by.htp.catalognews.entity.CatalogNews;
import by.htp.catalognews.entity.criteria.Criteria;
import by.htp.catalognews.entity.News;
import by.htp.catalognews.service.Constant;
import by.htp.catalognews.service.NewsService;
import by.htp.catalognews.service.impl.NewsServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class Main {
    private static ClassPathXmlApplicationContext contextSpring;
    public static void main(String[] args) throws IOException, JAXBException {

        contextSpring = new ClassPathXmlApplicationContext("applicationContext.xml");
        NewsService newsService = contextSpring.getBean("idNewsService",NewsServiceImpl.class);
        Criteria criteriaForCreate = contextSpring.getBean("idCriteriaForCreate",Criteria.class);
        Constant constant = contextSpring.getBean("idConstant", Constant.class);

        News news = newsService.add(criteriaForCreate);

        CatalogNews catalogFromXML = JaxbParser.readXML(constant.getFullPathFileXML());
        catalogFromXML.add(news);

        JaxbParser.saveFile(catalogFromXML, constant.getFullPathFileXML());

        OutputData.printCatalogNews(catalogFromXML);

        Criteria criteriaFind = contextSpring.getBean("idCriteriaForFind",Criteria.class);

        List<News> newsList = newsService.find(criteriaFind, constant.getFullPathFileXML());

        OutputData.printCatalogNews("Найденные новости "+criteriaFind, newsList);

    }

    private static Criteria getCriteriaFromConsole() throws IOException {
        HashMap<String, Object> parametersForCreate = InputData.readFromConsole();
        Criteria criteriaForCreate = new Criteria();
        criteriaForCreate.setCriteria(parametersForCreate);
        return criteriaForCreate;
    }

    public static ClassPathXmlApplicationContext getContextSpring() {
        return contextSpring;
    }
}
