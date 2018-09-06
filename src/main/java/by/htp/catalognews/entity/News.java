package by.htp.catalognews.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "News", propOrder = { "date", "country", "name", "newsBody", "providerNews" })
public class News {
    @XmlAttribute
    private String category;

    @XmlElement(required = true)
    private String date;

    @XmlElement(required = true)
    private String country;

    @XmlElement(required = true)
    private String name;

    @XmlElement(required = true)
    private String newsBody;

    @XmlElement(required = true)
    private ProviderNews providerNews = new ProviderNews();

    public News() { }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public ProviderNews getProviderNews() {
        return providerNews;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public void setProviderNews(ProviderNews providerNews) {
        this.providerNews = providerNews;
    }

    public String toString() {
        return "\nCategory: " + category + "\nDate: " + date + "\nCountry: " + country
                +"\nname: " + name   +" \nDesription: " + newsBody   +"\n"+ providerNews.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null) {
            return false;
        }
        if(getClass() != object.getClass()) {
            return false;
        }
        News news = (News) object;
        if (!category.equals(news.category)){
            return false;
        }
        if (date!=news.date){
            return false;
        }
        if (!country.equals(news.country)){
            return false;
        }
        if (!name.equals(news.name)){
            return false;
        }
        if (!newsBody.equals(news.newsBody)){
            return false;
        }
        if (!providerNews.equals(news.providerNews)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int rezult = 1;
        rezult = rezult*14 + (category==null ? 0: category.hashCode()) *rezult;
        rezult = rezult*14 + (date==null ? 0: date.hashCode()) *rezult;
        rezult = rezult*14 + (country==null ? 0: country.hashCode()) *rezult;
        rezult = rezult*14 + (name==null ? 0: name.hashCode()) *rezult;
        rezult = rezult*14 + (newsBody==null ? 0: newsBody.hashCode()) *rezult;
        rezult = rezult*14 + (providerNews==null ? 0: providerNews.hashCode()) *rezult;
        return rezult;
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = " providersNews ", propOrder = {
            "name",
            "authors"
    })
    public static class ProviderNews {
        @XmlElement
        private String name;

        @XmlElementWrapper(name = "authors")
        @XmlElement(name = "author")
        private List<String> authors ;
        public ProviderNews() {

        }
        public String getName() {
            return name;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }

        public String toString() {
            String listAuthors = "";
            if (authors!=null){
                listAuthors = String.join(",", authors);
            }

            return "provider name:" +name+ "\n\tAuthors: " + listAuthors;
        }
    }
}
