package by.htp.catalognews.dao;

import by.htp.catalognews.entity.criteria.Criteria;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface NewsDao<E> {
    List<E> find(Criteria criteria, String nameFile) throws IOException, JAXBException;
    E create(Criteria criteria);
}
