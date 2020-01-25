package utils;

import base.Edge;
import base.Graph;
import base.Node;

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

}
