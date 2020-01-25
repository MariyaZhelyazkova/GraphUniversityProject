package utils;

import base.Edge;
import base.Graph;
import base.Node;
import org.w3c.dom.Element;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GraphUtils {

    public static boolean graphHasCycle(Graph graph, Node checkNode, Node parentNode, List<Node> visitedNodes){
        if (checkNode == null)
            checkNode = graph.getFirstNode();

        if (visitedNodes.contains(checkNode)){
            return true;
        } else {
            visitedNodes.add(checkNode);
            for (Edge e : graph.getEdges(checkNode)){
                Node node = e.getTarget();
                if (node != parentNode)
                    if (graphHasCycle(graph, node, checkNode, visitedNodes))
                        return true;
            }

            return false;
        }
    }

    public static Graph testSortGraph(Graph graph){
        Graph sortedGraph = new Graph();
        for(Node node : graph.getAllNodes())
        {
            int i = 0;
            List<Edge> edges = graph.getEdges(node);
            Collections.sort(edges, Collections.reverseOrder());
            for (Edge edge : edges){
                sortedGraph.addEdge(node, edge.getTarget(), edge.getWeigth());
                i++;
                if (i == 3) break;
            }
        }

        return sortedGraph;
    }

}
