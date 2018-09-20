package by.htp.catalognews.dao.impl;

import by.htp.catalognews.dao.xml.JaxbParser;
import by.htp.catalognews.entity.News;
import by.htp.catalognews.dao.NewsDao;
import by.htp.catalognews.entity.CatalogNews;
import by.htp.catalognews.entity.criteria.Criteria;
import by.htp.catalognews.service.Constant;
import by.htp.catalognews.service.Util;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;

public class NewsDaoImpl implements NewsDao<News> {
    public List<News> find(Criteria criteria, String nameFile) throws IOException, JAXBException {
        CatalogNews  catalogNews = JaxbParser.readXML(nameFile);

        List<News> listNews = catalogNews.getList();

        List<News> findCatalog = new ArrayList<>();

        HashMap<String,Object> listCriteria = criteria.getCriteria();

        for (News news: listNews) {
            int rez = 1;

            if(     !checkExistParameter(news, listCriteria,"category")||
                    !checkExistParameter(news, listCriteria,"name")||
                    !checkExistParameter(news, listCriteria,"country")||
                    !checkExistParameter(news, listCriteria,"newsBody")||
                    !checkExistParameter(news, listCriteria,"providerName")||
                    !checkExistParameter(news, listCriteria,"providerAuthors")
                    ){
                rez=0;
            }
            if (rez==1) findCatalog.add(news);
        }

        return findCatalog;
    }

    public News create(Criteria criteria) {

        News news = new News();
        news.setDate(Util.getDateFormat(new Date()));
        news.setCategory((String) criteria.getValue("category"));
        news.setName((String) criteria.getValue("name"));
        news.setCountry((String) criteria.getValue("country"));
        news.setNewsBody((String) criteria.getValue("newsBody"));
        News.ProviderNews providerNews = new News.ProviderNews();
        providerNews.setName((String) criteria.getValue("providerName"));

        List<String> listAuthors = (List<String>) criteria.getValue("providerAuthors");
        providerNews.setAuthors(listAuthors);

        news.setProviderNews(providerNews);
        return news;
    }


    private boolean checkExistParameter(News news, HashMap<String,Object> listCriteria, String criteriaKey){
        if (listCriteria.get(criteriaKey)!=null){
            if (criteriaKey.equals("category")){
                if (news.getCategory().compareToIgnoreCase((String)listCriteria.get(criteriaKey))==0){
                    return true;
                }
            }
            else if(criteriaKey.equals("name")){
                if (news.getName().compareToIgnoreCase((String)listCriteria.get(criteriaKey))==0){
                    return true;
                }
            }
            else if(criteriaKey.equals("country")){
                if (news.getCountry().compareToIgnoreCase((String)listCriteria.get(criteriaKey))==0){
                    return true;
                }
            }
            else if(criteriaKey.equals("newsBody")){
                if (news.getNewsBody().contains((String)listCriteria.get(criteriaKey))){
                    return true;
                }
            }
            else if(criteriaKey.equals("providerName")){
                if (news.getProviderNews().getName().compareToIgnoreCase((String)listCriteria.get(criteriaKey))==0){
                    return true;
                }
            }
            else if(criteriaKey.equals("providerAuthors")){
                List<String> listAuthors = news.getProviderNews().getAuthors();
                List<String> listFindAuthors = (List<String>) listCriteria.get(criteriaKey);
                int rez=0;
                for (String authorsNews: listAuthors) {
                    for (String authorsFind: listFindAuthors) {
                        if (authorsNews.compareToIgnoreCase(authorsFind)==0){
                           rez = 1;
                           break;
                        }
                    }
                    if (rez==1) break;
                }
                return rez == 1;

            }
            //параметр есть для поиска но найденные данные не подходят
            return false;

        }
        //такой параметр вообще в поиске не нужен
        return true;
    }

}
