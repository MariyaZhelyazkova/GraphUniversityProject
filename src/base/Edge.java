package base;

public class Edge implements Comparable<Edge> {

    private static int edgeId = 0;

    public static int getNextEdgeId(){
        return edgeId++;
    }

    private final Node target;
    private final Float weight;
    private final int id;

    public Edge(Node target, float weight){
        this.target = target;
        this.weight = weight;
        this.id = getNextEdgeId();
    }

    public Float getWeigth(){
        return weight;
    }

    public Node getTarget(){
        return target;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "base.Edge{" +
                "target=" + target +
                ", wieght=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.getWeigth().compareTo(o.getWeigth());
    }
}
