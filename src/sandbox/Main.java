package sandbox;

import base.Graph;
import base.Node;
import utils.CSVReader;
import utils.GraphUtils;
import utils.XMLWriter;

import java.io.File;
import java.time.LocalDateTime;
import java.util.LinkedList;

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

        Graph sorted = GraphUtils.topThreeGraph(graph);

        XMLWriter.exportToGephi(sorted, filepath.concat(exportFilename));

        Graph maxSpanningTree = GraphUtils.maximumSpanningThree(sorted);

        XMLWriter.exportToGephi(maxSpanningTree, filepath.concat(exportTreeFilename));
    }
}
