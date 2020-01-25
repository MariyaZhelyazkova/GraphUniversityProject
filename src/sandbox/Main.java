package sandbox;

import base.Graph;
import base.Node;
import utils.CSVReader;
import utils.GraphUtils;
import utils.XMLWriter;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){

        System.out.println("Starting to read: " + LocalDateTime.now().toString());
        Graph graph = CSVReader.loadGraphFromCSV("D:\\Java\\GraphUniversityProject\\docs\\mtx_correl_ewm_vol.csv", ",");

        System.out.println("Checking for cycle: " + LocalDateTime.now().toString());
        if(GraphUtils.graphHasCycle(graph, null, null, new LinkedList<Node>()))
            System.out.println("YES");

        System.out.println("XML: " + LocalDateTime.now().toString());
        XMLWriter.exportToGephi(graph, "");

        System.out.println("END: " + LocalDateTime.now().toString());

        System.out.println(graph);
    }
}
