package by.htp.catalognews.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

@XmlRootElement(name = "catalog_news")
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogNews implements Serializable {

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

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (!(object instanceof CatalogNews)) {
            return false;
        }
        CatalogNews catalogNews = (CatalogNews) object;
        if (!catalogNews.equals(this)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int rezult = 1;
        if (list!=null){
            rezult = rezult*14 +list.hashCode();
        }
        return rezult;
    }
}