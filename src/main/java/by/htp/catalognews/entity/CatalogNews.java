package by.htp.catalognews.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "catalog_news")
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogNews {

    @XmlElement(name="news")
    private ArrayList<News> list = new ArrayList<News>();

    public ArrayList<News> getList() {
        return list;
    }

    public void setList(ArrayList<News> list)
    {
        this.list = list;
    }
    public boolean add(News st) {
        if (st!=null){
            list.add(st);
            return true;
        }
        return false;
    }

    public boolean addList(ArrayList<News> list){
        for (News news : list) {
            this.list.add(news);
        }
        return true;
    }

    @Override
    public String toString() {
        String printList="";
        for (News news:list ) {
            printList = printList+ news.toString()+"\n\n";
        }
        return "CATALOG NEWS " + printList;
    }

}