package sandbox;

import base.Graph;
import utils.CSVReader;
import utils.GraphUtils;
import utils.XMLWriter;

import java.io.File;

public class Main {
    public static void main(String[] args){
        execute("\\docs\\mtx_correl_ewm_vol.csv",
                "\\docs\\sorted_graph_correl.gexf",
                "\\docs\\spanning_tree_correl.gexf");

        execute("\\docs\\mtx_correl_log_ret.csv",
                "\\docs\\sorted_graph_log_return.gexf",
                "\\docs\\spanning_tree_log_return.gexf");
    }

    private static void execute(String inFilename, String exportFilename, String exportTreeFilename){
        String filepath = new File("").getAbsolutePath();

        //Loading the graph from CSV file
        Graph graph = CSVReader.loadGraphFromCSV(filepath.concat(inFilename), ",");

        //Sorting the graph and returning a new graph with the three highest weight for all of its nodes
        Graph sorted = GraphUtils.topThreeGraph(graph);

        //Exporting the sorted graph
        XMLWriter.exportToGephi(sorted, filepath.concat(exportFilename));

        //Finding the Maximum Spanning three of the sorted graph
        Graph maxSpanningTree = GraphUtils.maximumSpanningThree(sorted);

        //Exporting the Maximum Spanning Tree
        XMLWriter.exportToGephi(maxSpanningTree, filepath.concat(exportTreeFilename));
    }
}
