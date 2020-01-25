package base;

public class Edge implements Comparable<Edge> {

    private static int edgeId = 0;

    public static int getNextEdgeId(){
        return edgeId++;
    }

    private final Node target;
    private final Float wieght;

    public Edge(Node target, float weight){
        this.target = target;
        this.wieght = weight;
    }

    public Float getWeigth(){
        return wieght;
    }

    public Node getTarget(){
        return target;
    }

    @Override
    public String toString() {
        return "base.Edge{" +
                "target=" + target +
                ", wieght=" + wieght +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.getWeigth().compareTo(o.getWeigth());
    }
}
