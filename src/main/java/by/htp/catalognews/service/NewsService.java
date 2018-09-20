package by.htp.catalognews.service;

import by.htp.catalognews.entity.criteria.Criteria;
import by.htp.catalognews.entity.News;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface NewsService {
    List<News> find(Criteria criteria, String pathFile) throws IOException, JAXBException;
    News add(Criteria criteria);

}
