import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Vertex> vertices;
    int V;

    Graph()
    {
        vertices = new ArrayList<Vertex>();
        V = 0;
    }

    public void addVertex(Vertex v)
    {
        vertices.add(v);
        V++;
    }

    public Vertex getVertex(int i) { return vertices.get(i); }

    public int size() {
        return V;
    }
}