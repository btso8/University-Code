package University-Code.Software2.Week9.src.Tools;

import java.util.List;
import java.util.Set;

public interface IGraph<V, E extends Edge<V>> {

    Set<V> getVertices();
    Set<E> getEdges();
    boolean containsVertex(V vertex);
    boolean containsEdge(E edge);
    Set<V> getNeighbours(V vertex);
    Set<E> getInEdges(V vertex);
    Set<E> getOutEdges(V vertex);
    List<Set<V>> getComponents();
    boolean addEdge(V source, V target);
    boolean addVertex(V vertex);
}
