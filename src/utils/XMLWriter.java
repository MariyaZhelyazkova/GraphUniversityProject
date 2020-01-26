package utils;

import base.Edge;
import base.Graph;
import base.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLWriter {

    public static void exportToGephi(Graph graph, String filename){
        try {
            GraphUtils.removeParallelEdges(graph);

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("graph");
            doc.appendChild(rootElement);
            rootElement.setAttribute("defaultedgetype", "undirected");
            rootElement.setAttribute("mode", "static");

            Element attributes = doc.createElement("attributes");
            attributes.setAttribute("class", "node");
            attributes.setAttribute("mode", "static");
            rootElement.appendChild(attributes);

            Element attribute = doc.createElement("attribute");
            attribute.setAttribute("id", "modularity_class");
            attribute.setAttribute("title", "Modularity Class");
            attribute.setAttribute("type", "integer");
            attributes.appendChild(attribute);

            Element nodes = doc.createElement("nodes");
            XMLWriter.addNodesToXML(nodes, doc, graph);
            rootElement.appendChild(nodes);

            Element edges = doc.createElement("edges");
            XMLWriter.addEdgesToXML(edges, doc, graph);
            rootElement.appendChild(edges);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void addNodesToXML(Element nodesElement, Document doc, Graph graph){
        for (Node node : graph.getAllNodes()) {
            Element nodeElement = doc.createElement("node");
            nodeElement.setAttribute("id", String.valueOf(node.getId()));
            nodeElement.setAttribute("label", node.getName());
            nodesElement.appendChild(nodeElement);
        }
    }

    private static void addEdgesToXML(Element edgesElement, Document doc, Graph graph){
        for(Node node : graph.getAllNodes())
            for (Edge edge : graph.getEdges(node)) {
                Element edgeElement = doc.createElement("edge");
                edgeElement.setAttribute("id", String.valueOf(edge.getId()));
                edgeElement.setAttribute("source", String.valueOf(node.getId()));
                edgeElement.setAttribute("target", String.valueOf(edge.getTarget().getId()));
                edgeElement.setAttribute("weight", String.valueOf(edge.getWeigth()));

                edgesElement.appendChild(edgeElement);
            }
    }
}
