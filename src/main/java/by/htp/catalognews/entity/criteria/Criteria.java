package by.htp.catalognews.entity.criteria;

import java.util.HashMap;
import java.util.Map;


public class Criteria<E> {

    private HashMap<E, Object> criteria = new HashMap<>();

    public HashMap<E, Object> getCriteria() {
        return criteria;
    }

    public void setCriteria(HashMap<E, Object> criteria) {
        this.criteria = criteria;
    }

    public void putValue(E key, Object value){
        criteria.put(key, value);
    }

    public Object getValue(String criteriaName){
        Object value = criteria.get(criteriaName);
        if (value!=null) {
            return criteria.get(criteriaName);
        }
        else return  null;
    }

    public String toString() {
        String listParameter = "";
        if (criteria != null) {
            for (Map.Entry<E, Object> entry : criteria.entrySet()) {
                E nameCriteria = entry.getKey();
                String valueCriteria = (String) entry.getValue();
                listParameter = listParameter.concat((String)nameCriteria) + "=" + valueCriteria+" ";
            }
        }
        return "Параметры:  " + listParameter;
    }

}
