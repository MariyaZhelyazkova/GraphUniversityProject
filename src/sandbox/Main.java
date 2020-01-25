package sandbox;

import base.Graph;
import base.Node;
import utils.CSVReader;
import utils.GraphUtils;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        
        Graph graph = CSVReader.loadGraphFromCSV("D:\\Java\\GraphUniversityProject\\docs\\mtx_correl_ewm_vol.csv", ",");
        System.out.println(graph);
    }
}
