import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    int id;
    boolean visited;
    List<Vertex> neighbours;

    Vertex(int id)
    {
        this.id = id;
        neighbours = new ArrayList<Vertex>();
    }

    public void setVisited(boolean visited) { this.visited = visited; }
    public void addEdge(Vertex neighbour) { this.neighbours.add(neighbour); }
    public int getEdgeSize() { return neighbours.size(); }
    public Vertex getNeighbour(int i) { return neighbours.get(i); }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

    public boolean isVisited() { return visited; }

    @Override
    public int compareTo(Vertex that) {
        if(this.id == that.id)
            return 0;
        else return this.id > that.id ? 1 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return id == vertex.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public boolean allNeighboursVisted() {
        for(Vertex neighbour : neighbours)
        {
            if(!neighbour.isVisited())
                return false;
        }
        return true;
    }
}