package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private final List<Vertex> vertices = new ArrayList();
    private final List<Edge> edges = new ArrayList();

    public int numVertices() {
        return vertices.size();
    }

    public int numEdges() {
        return edges.size();
    }

    public int getDegree(Vertex v) {
        return v.getAdjacencyMap().size();
    }

    public List<Edge> getEdges(Vertex v) {
        HashMap<Vertex, Edge> hm = v.getAdjacencyMap();

        List<Edge> edgeList = new ArrayList();
        for (HashMap.Entry<Vertex, Edge> entry : hm.entrySet()) {
            edgeList.add(entry.getValue());
        }
        return edgeList;
    }

    public Vertex[] getVertices(Edge e) {
        return e.getVertices();
    }

    public List<Vertex> getAdjacentVertices(Vertex v) {
        List<Vertex> vertexList = new ArrayList();
        for (Edge e : getEdges(v)) {
            vertexList.add(getOppositeVertex(v, e));
        }
        return vertexList;
    }

    public Edge getEdge(Vertex u, Vertex v) {
        return u.getAdjacencyMap().get(v);
    }

    public Vertex getOppositeVertex(Vertex v, Edge e) {
        Vertex[] vertices = e.getVertices();
        if (vertices[0] == v) {
            return vertices[1];
        } else if (vertices[1] == v) {
            return vertices[0];
        } else {
            throw new IllegalArgumentException("Specified Vertex is not incident to the specified Edge");
        }
    }

    public void insertVertex(Vertex v) {
        vertices.add(v);
    }

    public Edge insertEdge(Vertex u, Vertex v) {
        if (getEdge(u, v) == null) {
            Edge e = new Edge(u, v);
            edges.add(e);

            u.getAdjacencyMap().put(v, e);
            v.getAdjacencyMap().put(u, e);
            return e;
        } else {
            throw new IllegalArgumentException("Edge already exists");
        }
    }

    public void removeVertex(Vertex v) {
        for (HashMap.Entry<Vertex, Edge> entry : v.getAdjacencyMap().entrySet()) {
            removeEdge(entry.getValue());
        }
        vertices.remove(v);
    }

    public void removeEdge(Edge e) {
        Vertex[] vertices = e.getVertices();
        Vertex u = vertices[0];
        Vertex v = vertices[1];

        HashMap<Vertex, Edge> hm = new HashMap(u.getAdjacencyMap());
        for (HashMap.Entry<Vertex, Edge> entry : u.getAdjacencyMap().entrySet()) {
            if (entry.getKey() == v) {
                hm.remove(v);
            }
        }
        u.setAdjacencyMap(hm);

        hm = new HashMap(v.getAdjacencyMap());
        for (HashMap.Entry<Vertex, Edge> entry : v.getAdjacencyMap().entrySet()) {
            if (entry.getKey() == u) {
                hm.remove(u);
            }
        }
        v.setAdjacencyMap(hm);
    }

    public void printGraph() {
        for (int i = 0; i < vertices.size(); ++i) {
            Vertex v = vertices.get(i);

            System.out.print("Vertex " + v + " ");
            for (Edge e : getEdges(v)) {
                System.out.print("\n   " + v + " ------> " + getOppositeVertex(v, e));
            }
            System.out.print("\n\n");
        }
    }


    public static class Vertex {

        private final String name;
        private HashMap<Vertex, Edge> adjacencyMap = new HashMap();

        public Vertex(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public HashMap<Vertex, Edge> getAdjacencyMap() {
            return adjacencyMap;
        }

        @Override
        public String toString() {
            return name;
        }

        public void setAdjacencyMap(HashMap<Vertex, Edge> adjacencyMap) {
            this.adjacencyMap = adjacencyMap;
        }
    }

    public static class Edge {

        private final Vertex[] vertices;

        public Edge(Vertex u, Vertex v) {
            vertices = new Vertex[]{u, v};
        }

        public Vertex[] getVertices() {
            return vertices;
        }
    }
}