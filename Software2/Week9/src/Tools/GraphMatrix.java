package codinguniwork.software2.week9.src.tools;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphMatrix<V, E extends Edge<V>> implements IGraph<V,E>{
    int[][] adjacency;
    Map<V, Integer> indexMapping;
    Map<Integer, V> vertexMapping;
    

    @Override
    public Set<V> getVertices() {
        return null;
    }

    @Override
    public Set<E> getEdges() {
        return null;
    }

    @Override
    public boolean containsVertex(V vertex) {
        return false;
    }

    @Override
    public boolean containsEdge(E edge) {
        return false;
    }

    @Override
    public Set<V> getNeighbours(V vertex) {
        return null;
    }

    @Override
    public Set<E> getInEdges(V vertex) {
        return null;
    }

    @Override
    public Set<E> getOutEdges(V vertex) {
        return null;
    }

    @Override
    public List<Set<V>> getComponents() {
        return null;
    }

    @Override
    public boolean addEdge(V source, V target) {
        return false;
    }

    @Override
    public boolean addVertex(V vertex) {
        return false;
    }
    
}