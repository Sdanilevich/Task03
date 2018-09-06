package by.htp.catalognews.dao;

import by.htp.catalognews.entity.Criteria.Criteria;

import java.io.IOException;
import java.util.List;

public interface NewsDao<E> {
    List<E> find(Criteria criteria) throws IOException;
    E create(Criteria criteria);
}
