package utils;

import base.Graph;
import base.Node;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static Graph loadGraphFromCSV(String filename, String separator){
        String line = "";
        int currentLine = 0;
        List<Node> nodes = new ArrayList<>();
        Graph graph = new Graph();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while((line = br.readLine()) != null) {
                if (currentLine == 0)
                    nodes = loadNodes(line, separator);
                else
                    graph = addEdges(nodes, line.split(separator), currentLine, graph);

                currentLine++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return graph;
    }

    private static List<Node> loadNodes(String line, String separator){
        List<Node> nodes = new ArrayList<>();

        for (String node : line.replace("\"", "").split(separator)){
            if (!node.isBlank())
                nodes.add(new Node(node));
        }

        return nodes;
    }

    private static Graph addEdges(List<Node> nodes, String[] line, int currentLine, Graph graph){
        Node targetNode = nodes.get(currentLine - 1);
        for (int i = 1; i < line.length; i++) {

            graph.addEdge(nodes.get(i-1), targetNode, Math.abs(Float.parseFloat(line[i])));
        }

        return graph;
    }
}
