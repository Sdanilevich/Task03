package by.htp.catalognews.service;


import by.htp.catalognews.entity.Criteria.SearchCriteria;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {

    public static boolean checkExistFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()){
            return false;
        }
        else {
            List<String> list = getInfoFromFile(path);
            return list.size() != 0;
        }
    }

    public static String getDateFormat(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }

    public static List<String> getInfoFromFile(String path) throws IOException {
          List<String> stringList = new ArrayList<>();
          InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));
          BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
          String  line;
          while ((line = bufferedReader.readLine())!=null){
              stringList.add(line);
          }
          return stringList;
    }

    public static HashMap<String, Object> getEmptyCriteria() throws IOException {
        String path = Constant.directoryFileCriteria+Constant.nameFileCriteria;
        HashMap<String, Object> criteriaList = new HashMap<>();
        if (Util.checkExistFile(path)){
            List<String> listCriteria = Util.getInfoFromFile(path);
            for (String oneCriteria: listCriteria) {
                criteriaList.put(oneCriteria,"");
            }
        }
        else {
            criteriaList = getFromEnum();
        }
        return criteriaList;
    }


    public static List<String> doArrayFromValueCriteria(Object criteriaValue) {
        if (criteriaValue instanceof String) {
            String criteriaValueString = (String) criteriaValue;
            if (criteriaValue != null) {
                return Arrays.asList(criteriaValueString.split(","));
            }
        }
        return Collections.emptyList();
    }


    public static HashMap<String, Object> getFromEnum(){
        HashMap<String, Object> listCriteria = new HashMap<>();
        for (SearchCriteria.CriteriaNews d : SearchCriteria.CriteriaNews.values()) {
            listCriteria.put(d.nameField, "");
        }
        return listCriteria;
    }

}
