package by.htp.catalognews.service.impl;

import by.htp.catalognews.dao.NewsDao;
import by.htp.catalognews.entity.Criteria.Criteria;
import by.htp.catalognews.entity.News;
import by.htp.catalognews.main.Main;
import by.htp.catalognews.service.NewsService;
import by.htp.catalognews.service.validation.Validator;

import java.io.IOException;
import java.util.List;

public class NewsServiceImpl implements NewsService {

    public List<News> find(Criteria criteria) throws IOException {
        NewsDao newsDao = Main.getContextSpring().getBean("idNewsDao", NewsDao.class);

        List<News> newsList= newsDao.find(criteria);

        return newsList;
    }

    public News add(Criteria criteria) {
        if (Validator.isNotEmpty(criteria)){
            NewsDao newsDao = Main.getContextSpring().getBean("idNewsDao", NewsDao.class);

            News news = (News) newsDao.create(criteria);

            return news;
        }
        return null;
    }
}
