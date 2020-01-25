public class Node {
    private static int nodeId = 0;

    public static int getNextNodeId(){
        return nodeId++;
    }

    private final int id;
    private final String name;

    public Node(String name){
        this.id = getNextNodeId();
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
