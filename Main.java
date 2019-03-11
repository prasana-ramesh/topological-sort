import java.util.Stack;

public class Main {

    static int counter = 0;

    static Vertex getNewVertex() { return new Vertex(counter++); }

    public static void main(String[] args) {
        Vertex zero = new Vertex(0);
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);

        Graph graph = new Graph();

        five.addEdge(two);
        five.addEdge(zero);
        graph.addVertex(five);

        four.addEdge(zero);
        four.addEdge(one);
        graph.addVertex(four);

        two.addEdge(three);
        graph.addVertex(two);

        three.addEdge(one);
        graph.addVertex(three);

        graph.addVertex(one);
        graph.addVertex(zero);

        DFS dfs = new DFS(graph);

    }
}
