package co.uk.directlinegroup.tt.utils.common;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlOperations {

    private FormatOperations FormatOperationsObj = new FormatOperations();

    private DateOperations DateOperationsObj = new DateOperations();

    public List<Map<String, String>> xmlNodeListMap(String fileName, String xmlNode, int flag) {
        //get map values for child nodes currencyPairFxRates
        List<Map<String, String>> PairMapList = new ArrayList<Map<String, String>>();

        try {
            //Initialize the document builder to read the xml
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            //Parse the Xml file
            Document doc = docBuilder.parse(new File(fileName));
            // normalize text representation
            doc.getDocumentElement().normalize();
            //Flag 0 to get all the fields //Flag 1 to get specific fields
            PairMapList = getXmlNodeListPair(doc, xmlNode, flag);
        } catch (SAXParseException err) {
            System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
        } catch (SAXException e) {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return PairMapList;
    }

    public List<Map<String, String>> getXmlNodeListPair(Document doc, String tagName, int flag) {
        List<Map<String, String>> NodeListMap = new ArrayList<Map<String, String>>();
        //NodeListMap contains array of tagname and value
        NodeList listOfNodes = doc.getElementsByTagName(tagName);
        int totalNodes = listOfNodes.getLength();
        for (int i = 0; i < totalNodes; i++) {
            Map<String, String> Nodepair = new HashMap<String, String>();
            //Nodepair has tagname and its value
            Node firstNode = listOfNodes.item(i);
            childRecursion(firstNode, Nodepair, flag);
            NodeListMap.add(i, Nodepair);
        }
        return NodeListMap;
    }

    public void childRecursion(Node node, Map<String, String> MapList, int flag) {

        NodeList nodeList = node.getChildNodes(); //gets the child nodes for the Node sent in parameter
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            int type = currentNode.getNodeType();
        /*<quotedCurrencyPair> --- ElementNode
            <currency1> --- ElementNode
                USD--- TextNode
            </currency1>
            <currency2>
                NLG
            </currency2>
            <quoteBasis>
                Currency2 Per Currency1
            </quoteBasis>
        </quotedCurrencyPair>*/
            switch (type) {
                case Node.ELEMENT_NODE: {
                    childRecursion(currentNode, MapList, flag);
                    break;
                }
                case Node.TEXT_NODE: {
                    String nodeName = currentNode.getParentNode().getNodeName();
                    if (flag == 1) {
                        switch (nodeName) {
                            case "currency1":
                                if (!currentNode.getNodeValue().trim().isEmpty()) {
                                    MapList.put("BaseCurrencyCode", currentNode.getNodeValue().trim());
                                }
                                break;
                            case "currency2":
                                if (!currentNode.getNodeValue().trim().isEmpty()) {
                                    MapList.put("CurrencyCode", currentNode.getNodeValue().trim());
                                }
                                break;
                            case "date":
                                if (!currentNode.getNodeValue().trim().isEmpty()) {
                                    String Dt = currentNode.getNodeValue().trim();
                                    MapList.put("ConversionDate", DateOperationsObj.date(Dt, "dd/mm/yyyy hh:mm:ss"));
                                }
                                break;
                            case "priceLevelScheme":
                                if (!currentNode.getNodeValue().trim().isEmpty() && currentNode.getNodeValue().trim().equalsIgnoreCase("mid")) {
                                    NodeList sibling = currentNode.getParentNode().getParentNode().getChildNodes();
                                    for (i = 0; i < sibling.getLength(); i++) {
                                        if (sibling.item(i).getNodeName().equalsIgnoreCase("rate")) {
                                            String rt = sibling.item(i).getFirstChild().getNodeValue() + "00000";
                                            double fr = Double.parseDouble(rt);
                                            double tr;
                                            tr = 1 / fr;
                                            MapList.put("FromGBPRate", rt);
                                            MapList.put("ToGBPRate", FormatOperationsObj.FloatToStingFormat(tr));
                                        }
                                    }
                                }
                                break;
                            default:
                                if (!currentNode.getNodeValue().trim().isEmpty()) {
                                }
                                break;
                        }
                    } else {
                        if (!currentNode.getNodeValue().trim().isEmpty()) {
                            MapList.put(nodeName, currentNode.getNodeValue().trim());
                        }
                    }
                    break;
                }
            }
        }
    }

}