import util.Graph;
import util.Graph.Vertex;

import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");
        Vertex i = new Vertex("I");

        graph.insertVertex(a);
        graph.insertVertex(b);
        graph.insertVertex(c);
        graph.insertVertex(d);
        graph.insertVertex(e);
        graph.insertVertex(f);
        graph.insertVertex(g);
        graph.insertVertex(h);
        graph.insertVertex(i);

        graph.insertEdge(a, d);
        graph.insertEdge(a, b);
        graph.insertEdge(d, c);
        graph.insertEdge(b, c);
        graph.insertEdge(e, f);
        graph.insertEdge(c, e);
        graph.insertEdge(c, f);
        graph.insertEdge(f, g);
        graph.insertEdge(g, i);
        graph.insertEdge(g, h);
        graph.insertEdge(h, i);

        graph.printGraph();

        System.out.print("Articulation Points : ");
        Set<Vertex> articulationPoints = ArticulationPointFinder.findArticulationPoints(graph);
        System.out.println(articulationPoints);
    }
}