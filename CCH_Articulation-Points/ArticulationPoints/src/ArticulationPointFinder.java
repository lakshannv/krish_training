import util.Graph;
import util.Graph.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ArticulationPointFinder {

    public static Set<Vertex> findArticulationPoints(Graph graph) {
        HashSet<Vertex> visitedVertices = new HashSet<>();
        HashMap<Vertex, Integer> depths = new HashMap<>();
        HashMap<Vertex, Integer> lows = new HashMap<>();
        HashSet<Vertex> articulationPoints = new HashSet<>();

        for (Vertex u : graph.getVertices()) {
            if (!visitedVertices.contains(u)) {
                find(graph, u, visitedVertices, depths, lows, null, articulationPoints, 1);
            }
        }
        return articulationPoints;
    }

    private static void find(Graph graph, Vertex u, HashSet<Vertex> visitedVertices, HashMap<Vertex, Integer> depths, HashMap<Vertex, Integer> lows, Vertex parent, HashSet<Vertex> articulationPoints, int initialValue) {
        int childrenCount = 0;
        visitedVertices.add(u);
        depths.put(u, initialValue);
        lows.put(u, initialValue);

        for (Vertex v : graph.getAdjacentVertices(u)) {
            if (!visitedVertices.contains(v)) {
                childrenCount++;
                find(graph, v, visitedVertices, depths, lows, u, articulationPoints, ++initialValue);
                lows.put(u, Math.min(lows.get(u), lows.get(v)));
                if (parent != null && lows.get(v) >= depths.get(u)) {
                    articulationPoints.add(u);
                }
            } else if (v != parent) {
                lows.put(u, Math.min(lows.get(u), depths.get(v)));
            }
        }

        if (parent == null && childrenCount > 1) {
            articulationPoints.add(u);
        }
    }
}