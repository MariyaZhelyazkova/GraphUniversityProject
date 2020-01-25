package base;

public class Edge {

    private static int edgeId = 0;

    public static int getNextEdgeId(){
        return edgeId++;
    }

    private final Node target;
    private final float wieght;

    public Edge(Node target, float weight){
        this.target = target;
        this.wieght = weight;
    }

    public float getWeigth(){
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
}
