import util.Graph;

import java.util.*;

import static util.Graph.Vertex;
import static util.Graph.Edge;

public class BFS {

    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");

        graph.insertVertex(a);
        graph.insertVertex(b);
        graph.insertVertex(c);
        graph.insertVertex(d);
        graph.insertVertex(e);
        graph.insertVertex(f);
        graph.insertVertex(g);
        graph.insertEdge(a, c);
        graph.insertEdge(a, b);
        graph.insertEdge(b, d);
        graph.insertEdge(c, e);
        graph.insertEdge(c, g);
        graph.insertEdge(e, f);
        graph.insertEdge(f, g);
        graph.printGraph();

        System.out.print("Breadth First Search : ");
        breadthFirstSearch(graph, a);
    }

    public static void breadthFirstSearch(Graph graph, Vertex startingVertex) {
        Queue<Vertex> vertexQueue = new LinkedList<>();
        Set<Vertex> visited = new LinkedHashSet<>();
        visited.add(startingVertex);
        vertexQueue.add(startingVertex);

        while (!vertexQueue.isEmpty()) {
            Vertex vertex = vertexQueue.poll();
            for (Vertex v : graph.getAdjacentVertices(vertex)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    vertexQueue.add(v);
                }
            }
        }

        System.out.println(visited);
    }
}
