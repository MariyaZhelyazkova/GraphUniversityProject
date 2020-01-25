import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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

    public List<Edge> getEdges(Node node){
        return graph.get(node);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "graph=" + graph +
                '}';
    }
}
