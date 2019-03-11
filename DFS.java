import java.util.Stack;

class DFS {

    Stack<Vertex> stack;
    Stack<Vertex> backtrackingOrder;
    Stack<Vertex> topologicalOrder;

    DFS(Graph graph)
    {
        stack = new Stack<Vertex>();
        backtrackingOrder = new Stack<Vertex>();
        topologicalOrder = new Stack<Vertex>();

        for(int i=0; i<graph.size(); i++)
            if(!graph.getVertex(i).isVisited())
                iterativeDFS(graph.getVertex(i));

        printTopologicalOrdering();

    }

    private void printTopologicalOrdering() {
        while(!topologicalOrder.empty())
            System.out.print(topologicalOrder.pop()+" ");
    }


    public void recursiveDFS(Vertex vertex) {
        vertex.setVisited(true);
        for(int i=0; i < vertex.getEdgeSize(); i++)
        {
            Vertex neighbour = vertex.getNeighbour(i);
            if(!neighbour.isVisited())
                recursiveDFS(neighbour);
        }
        topologicalOrder.push(vertex);
    }

    private void iterativeDFS(Vertex vertex) {
        stack.push(vertex);
        while(!stack.empty())
        {
            Vertex currentVertex = stack.pop();
            currentVertex.setVisited(true);
            if(currentVertex.getEdgeSize() == 0 && !backtrackingOrder.isEmpty())
            {
                Vertex parent = backtrackingOrder.peek();
                topologicalOrder.push(currentVertex);
                while(!backtrackingOrder.empty() && parent.allNeighboursVisted())
                {
                    topologicalOrder.push(backtrackingOrder.pop());
                    if(!backtrackingOrder.empty())
                    parent = backtrackingOrder.peek();
                }
            } else {
                for(int i=0; i < currentVertex.getEdgeSize(); i++)
                {
                    Vertex neighbour = currentVertex.getNeighbour(i);
                    if(!neighbour.isVisited())
                    {
                        stack.push(neighbour);
                    }
                }
                backtrackingOrder.push(currentVertex);
            }
        }

        if(stack.isEmpty() && !backtrackingOrder.isEmpty())
            topologicalOrder.push(backtrackingOrder.pop());
    }

}