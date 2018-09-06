package by.htp.catalognews.entity.Criteria;

import java.util.HashMap;
import java.util.Map;


public class Criteria {

    private static HashMap<String, Object> criteria = new HashMap<>();

    public HashMap<String, Object> getCriteria() {
        return criteria;
    }

    public void setCriteria(HashMap<String, Object> criteria) {
        Criteria.criteria = criteria;
    }

    public void putValue(String key, Object value){
        criteria.put(key, value);
    }

    public Object getValue(String criteriaName){
        Object value = criteria.get(criteriaName);
        if (value!=null) {
            return criteria.get(criteriaName);
        }
        else return  "";
    }

    public String toString() {
        String listParameter = "";
        if (criteria != null) {
            for (Map.Entry<String, Object> entry : criteria.entrySet()) {
                String nameCriteria = entry.getKey();
                String valueCriteria = (String) entry.getValue();
                listParameter = listParameter.concat(nameCriteria) + "=" + valueCriteria+" ";
            }
        }
        return "Параметры:  " + listParameter;
    }

}
