import util.Graph;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

import static util.Graph.Vertex;

public class DFS {

    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Vertex v6 = new Vertex("6");
        Vertex v7 = new Vertex("7");

        graph.insertVertex(v0);
        graph.insertVertex(v1);
        graph.insertVertex(v2);
        graph.insertVertex(v3);
        graph.insertVertex(v4);
        graph.insertVertex(v5);
        graph.insertVertex(v6);
        graph.insertVertex(v7);

        graph.insertEdge(v0, v3);
        graph.insertEdge(v3, v7);
        graph.insertEdge(v7, v4);
        graph.insertEdge(v3, v5);
        graph.insertEdge(v5, v6);
        graph.insertEdge(v6, v2);
        graph.insertEdge(v2, v1);
        graph.printGraph();

        System.out.print("Depth First Search : ");
        depthFirstSearch(graph, v0);
    }

    public static void depthFirstSearch(Graph graph, Vertex startingVertex) {
        Stack<Vertex> vertexStack = new Stack<>();
        Set<Vertex> visited = new LinkedHashSet<>();

        vertexStack.push(startingVertex);

        while (!vertexStack.isEmpty()) {
            Vertex vertex = vertexStack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjacentVertices(vertex)) {
                    vertexStack.push(v);
                }
            }
        }

        System.out.println(visited);
    }
}