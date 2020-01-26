package base;

import java.util.*;

public class Graph {
    private Map<Node, List<Edge>> graph = new HashMap<>();

    public void addNode(Node node){
        graph.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Node parent, Edge edge){
        if (!graph.containsKey(parent))
            addNode(parent);

        graph.get(parent).add(edge);
    }

    public void addEdge(Node source, Node target, float weight){
        if (source == target)
            return;

        if (findEdgeOfNodes(source, target) == null)
            addEdge(source, new Edge(target, weight));

        if (findEdgeOfNodes(target, source) == null)
            addEdge(target, new Edge(source, weight));
    }

    public Node getFirstNode(){
        HashMap.Entry<Node,List<Edge>> entry = graph.entrySet().iterator().next();
        return entry.getKey();
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

    public List<Edge> getAllEdges(){
        List<Edge> allEdges = new ArrayList<>();

        for (HashMap.Entry<Node,List<Edge>> entry : graph.entrySet()) {
            allEdges.addAll(entry.getValue());
        }

        return allEdges;
    }

    public Node getSourceNode(Edge edge){
        for (HashMap.Entry<Node,List<Edge>> entry : graph.entrySet()) {
            if (entry.getValue().contains(edge))
                return entry.getKey();
        }

        return null;
    }

    public Edge findEdgeOfNodes(Node source, Node target){
        List<Edge> edges = graph.get(source);

        if(edges != null)
            for (Edge edge : graph.get(source))
                if (target == edge.getTarget())
                    return edge;

        return null;
    }

    public void removeEdge(Node source, Node target){
        Edge remEdge = findEdgeOfNodes(source, target);
        graph.get(source).remove(remEdge);

        remEdge = findEdgeOfNodes(target, source);
        graph.get(target).remove(remEdge);
    }

    public void removeEdge(Node source, Edge edge){
        graph.get(source).remove(edge);
    }

    public int getEdgeCount(){
        return getAllEdges().size();
    }

    public int getNodesCount(){
        return graph.size();
    }

    @Override
    public String toString() {
        return "base.Graph{" +
                "graph=" + graph +
                '}';
    }
}
