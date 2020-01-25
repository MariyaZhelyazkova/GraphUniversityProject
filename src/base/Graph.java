package base;

import java.util.*;

public class Graph {
    private Map<Node, List<Edge>> graph = new HashMap<>();

    public void addNode(Node node){
        graph.putIfAbsent(node, new Vector<>());
    }

    public void addNode(String name){
        addNode(new Node(name));
    }

    public void addEdge(Node parent, Edge edge){
        if (!graph.containsKey(parent))
            addNode(parent);

        graph.get(parent).add(edge);
    }

    public void addEdge(Node source, Node target, float weight){
        if (source == target)
            return;

        addEdge(target, new Edge(source, weight));
        addEdge(source, new Edge(target, weight));
    }

    public Node getFirstNode(){
        HashMap.Entry<Node,List<Edge>> entry = graph.entrySet().iterator().next();
        return entry.getKey();
    }

    public Node getNode(String name){
        for (HashMap.Entry<Node,List<Edge>> entry : graph.entrySet()) {
            if(entry.getKey().getName() == name)
                return entry.getKey();
        }

        return null;
    }

    public List<Node> getAllNodes(){
        List<Node> nodes = new ArrayList<>();

        for (HashMap.Entry<Node,List<Edge>> entry : graph.entrySet())
            nodes.add(entry.getKey());

        return nodes;
    }

    public List<Edge> getEdges(Node node){
        return graph.get(node);
    }

    @Override
    public String toString() {
        return "base.Graph{" +
                "graph=" + graph +
                '}';
    }
}
