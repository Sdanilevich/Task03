package by.htp.catalognews.main;

import by.htp.catalognews.entity.CatalogNews;
import by.htp.catalognews.entity.News;


import java.util.List;

public class OutputData {
    public static void printInfoFromList(List<String> list) {
        int i=0;
        for (String param:list) {
            i = i+1;
            System.out.print(i+": "+param+";");
        }
    }

    public static void printCatalogNews(CatalogNews catalogNews){
        System.out.println(catalogNews);
    }

    public static void printCatalogNews(String caption,CatalogNews catalogNews){
        System.out.println(caption);
        System.out.println(catalogNews);
    }

    public static void printCatalogNews(List<News> catalogNews)  {
        System.out.println(catalogNews);
    }

    public static void printCatalogNews(String caption,List<News> catalogNews)  {
        System.out.println(caption);
        System.out.println(catalogNews);
    }
}
