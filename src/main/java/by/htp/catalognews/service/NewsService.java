package by.htp.catalognews.service;

import by.htp.catalognews.entity.Criteria.Criteria;
import by.htp.catalognews.entity.News;

import java.io.IOException;
import java.util.List;

public interface NewsService {
    List<News> find(Criteria criteria) throws IOException;
    News add(Criteria criteria);

}
