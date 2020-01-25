import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        Graph graph = new Graph();

        graph.addNode("Google");
        graph.addNode("Apple");
        graph.addNode("IBM");
        graph.addNode("Intel");

        graph.addEdge(graph.getNode("Google"), graph.getNode("Apple"), 0);
        graph.addEdge(graph.getNode("Google"), graph.getNode("IBM"), 0);
        graph.addEdge(graph.getNode("IBM"), graph.getNode("Apple"), 0);
        graph.addEdge(graph.getNode("IBM"), graph.getNode("Intel"), 0);

        if (GraphUtils.graphHasCycle(graph, null, null, new LinkedList<Node>()))
            System.out.println("YES");
        else
            System.out.println("FUCK");
        System.out.println(graph);
    }
}
