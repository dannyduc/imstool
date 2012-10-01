package com.ingenuity.imstool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class CheckStatus {

    public static void main(String[] args) throws Exception {
        Process p = Runtime.getRuntime().exec("./status.sh");
//        Scanner scanner = new Scanner(p.getInputStream()).useDelimiter("\\A");
//        String response = scanner.next();
//        System.out.println(response);

//        jdom xml parser
//        SAXBuilder builder = new SAXBuilder();
//        Document document = builder.build(p.getInputStream());
//        Element dataSetNode = document.getRootElement();
//        String status = dataSetNode.getAttributeValue("status");
//        System.out.println(status);

        // jdk 1.6 xml parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(p.getInputStream());
        document.normalize();

        Element dataSet = document.getDocumentElement();
        String status = dataSet.getAttribute("status");
        System.out.println(status);
    }
}
