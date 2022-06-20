package University-Code.Software2.WeekS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hamiltonian {

    public static boolean isHamiltonian(int[][] matrix){
        if(!isUndirected(matrix)){
            throw new IllegalArgumentException("The graph must be an undirected graph!");
        }
        List<Integer> path = IntegerPermutation.getFirstPermutation(matrix.length);
        while(path != null){
            if(isValidCycle(matrix, path)){
                return true;
            }
            path = IntegerPermutation.nextPermutation(path);
        }
        return false;
    }

    public static boolean isValidPath(int[][] matrix, List<Integer> path){
        if(matrix == null || path == null || path.isEmpty()){
            return false;
        }
        for (int i = 0; i < path.size() - 1; i++) {
            if(matrix[path.get(i)][path.get(i+1)] == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidCycle(int[][] matrix, List<Integer> path){
        return  isValidPath(matrix, path) 
                && matrix[path.get(0)][path.get(path.size()-1)] != 0;
    }

    public static boolean isUndirected(int[][] matrix){
        if(matrix == null){
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if(matrix[i][j] != matrix[j][i]){
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isHamiltonianBacktrack(int[][] matrix) {
        if(!isUndirected(matrix)){
            throw new IllegalArgumentException("The graph must be an undirected graph!");
        }
        List<Integer> indices = new ArrayList<>();
        for (int i = 1; i < matrix.length; i++) {
            indices.add(i);
        }
        return isHamiltonian(matrix, indices, Arrays.asList(new Integer[]{0}));
    }

    private static boolean isHamiltonian(int[][] matrix, 
            List<Integer> vertices, 
            List<Integer> currentPath) {
        if (vertices.isEmpty()) {
            return matrix[0][currentPath.get(currentPath.size()-1)] != 0;

        } else {
            for (Integer vertex : vertices) {
                if(matrix[currentPath.get(currentPath.size() - 1)][vertex] != 0){
                    List<Integer> augmentedPath = new ArrayList<Integer>(currentPath);
                    augmentedPath.add(vertex);
                    List<Integer> remainingVertices = new ArrayList<>(vertices);
                    remainingVertices.remove(vertex);
                    if(isHamiltonian(matrix, remainingVertices, augmentedPath)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
