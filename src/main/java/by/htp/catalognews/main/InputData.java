package by.htp.catalognews.main;

import by.htp.catalognews.service.Constant;
import by.htp.catalognews.service.Util;

import java.io.IOException;
import java.util.*;

public class InputData {

    public static HashMap<String, Object> readFromConsole() throws IOException {
        HashMap<String, Object> listCriteria = Util.getEmptyCriteria();
        for (Map.Entry<String, Object> entry: listCriteria.entrySet()) {
            String nameCriteria = entry.getKey();
            String pathForDataCriteria = Constant.directoryFileCriteria.concat(entry.getKey())+".txt";
            String valueCriteria;
            if (Util.checkExistFile(pathForDataCriteria)){
                List<String> list = Util.getInfoFromFile(pathForDataCriteria);
                OutputData.printInfoFromList(list);
                System.out.println("Enter the number of value of the parameter <"+nameCriteria+">");
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()){
                    int num = scanner.nextInt()-1;
                    if (num<=list.size()){
                        valueCriteria = list.get(num);
                    }
                    else {
                        valueCriteria = "";
                    }
                }
                else valueCriteria = scanner.nextLine();
            }
            else{
                System.out.println("Enter the value of the parameter <" + nameCriteria+">");
                Scanner scanner = new Scanner(System.in);
                valueCriteria = scanner.nextLine();
            }
            //переделать потом!!!! может в enum вынести тип параметра
            if (nameCriteria.equals("providerAuthors")){
                List<String> valueCriteriaList = Util.doArrayFromValueCriteria(valueCriteria);
                listCriteria.put(nameCriteria, valueCriteriaList);
            }
            else {
                listCriteria.put(nameCriteria, valueCriteria);
            }
        }
        return listCriteria;

    }



}
