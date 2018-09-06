package by.htp.catalognews.service;

public class Constant {
    private static final String directoryFileXML = "src/main/resources/";
    private static final String nameFileXML = "catalog.xml";

    public static final String directoryFileCriteria = "src/main/resources/";
    public static final String nameFileCriteria = "criteria2.txt";

    public static String getFullPathFileXML(){

        return directoryFileXML.concat(nameFileXML);
    }
}
