package by.htp.catalognews.service.validation;

import by.htp.catalognews.entity.criteria.Criteria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    public static boolean isNotEmpty(Criteria criteria){
        HashMap<String, Object> listParameters = criteria.getCriteria();

        int countParam = listParameters.size();
        int countEmpty = 0;
        for (Map.Entry<String, Object> entry: listParameters.entrySet()){
            if(entry.getKey().equals("providerAuthors")){
                if (entry.getValue()==null){
                    countEmpty++;
                }
                else {
                    List<String> listAuthors = (List<String>) criteria.getValue("providerAuthors");

                    if(listAuthors.size()==0){
                    countEmpty++;
                }}
            }
            else {
                String value = (String) entry.getValue();
                if (value.trim().length() == 0) {
                    countEmpty++;
                }
            }
        }

        if (countEmpty==countParam) return false;

        return true;
    }
}
