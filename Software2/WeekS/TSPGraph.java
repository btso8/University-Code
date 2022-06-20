package codinguniwork.software2.weeks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TSPGraph {
    int[][] matrix;
    List<String> cities;

    public TSPGraph(List<String> cities) {
        this.cities = cities;
        matrix = new int[cities.size()][cities.size()];
    }

    public TSPGraph(String[] cities) {
        this.cities = Arrays.asList(cities);
        matrix = new int[cities.length][cities.length];
    }

    public TSPGraph(String[] cities, int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix.length) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] < 0 || matrix[i][j] != matrix[j][i]) {
                    throw new IllegalArgumentException();
                }
            }
        }
        this.cities = Arrays.asList(cities);
        this.matrix = matrix.clone();
    }

    public boolean addEdge(String cityA, String cityB, int cost) {
        int cityAIndex = cities.indexOf(cityA);
        int cityBIndex = cities.indexOf(cityB);
        if (cost <= 0 || cityAIndex < 0 || cityBIndex < 0 || matrix[cityAIndex][cityBIndex] != 0) {
            return false;
        }
        matrix[cityAIndex][cityBIndex] = cost;
        matrix[cityBIndex][cityAIndex] = cost;
        return true;
    }

    private List<String> convertFromIndices(List<Integer> indices) {
        List<String> route = new ArrayList<>();
        for (Integer index : indices) {
            route.add(cities.get(index));
        }
        return route;
    }

    public boolean setEdge(String cityA, String cityB, int cost) {
        int cityAIndex = cities.indexOf(cityA);
        int cityBIndex = cities.indexOf(cityB);
        if (cost <= 0 || cityAIndex < 0 || cityBIndex < 0) {
            return false;
        }
        matrix[cityAIndex][cityBIndex] = cost;
        matrix[cityBIndex][cityAIndex] = cost;
        return true;
    }

    public boolean removeEdge(String cityA, String cityB) {
        int cityAIndex = cities.indexOf(cityA);
        int cityBIndex = cities.indexOf(cityB);
        if (cityAIndex < 0 || cityBIndex < 0 || matrix[cityAIndex][cityBIndex] == 0) {
            return false;
        }
        matrix[cityAIndex][cityBIndex] = 0;
        matrix[cityBIndex][cityAIndex] = 0;
        return true;
    }

    public boolean isNeighbour(String cityA, String cityB) {
        int cityAIndex = cities.indexOf(cityA);
        int cityBIndex = cities.indexOf(cityB);
        if (cityAIndex < 0 || cityBIndex < 0 || matrix[cityAIndex][cityBIndex] <= 0) {
            return false;
        }
        return true;
    }

    public int getCost(String cityA, String cityB) {
        int cityAIndex = cities.indexOf(cityA);
        int cityBIndex = cities.indexOf(cityB);
        if (cityAIndex < 0 || cityBIndex < 0) {
            throw new IllegalArgumentException("Invalid city!");
        }
        return matrix[cityAIndex][cityBIndex];
    }

    public List<String> getNeighbours(String city) {
        List<String> neighbours = new ArrayList<>();
        int cityIndex = cities.indexOf(city);
        if (cityIndex < 0) {
            throw new IllegalArgumentException("Invalid city!");
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][cityIndex] > 0 && i != cityIndex) {
                neighbours.add(cities.get(i));
            }
        }
        return neighbours;
    }

    public List<Integer> getNeighbours(Integer cityIndex) {
        List<Integer> neighbours = new ArrayList<>();
        if (cityIndex < 0 || cityIndex >= cities.size()) {
            throw new IllegalArgumentException("Invalid city!");
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][cityIndex] > 0 && i != cityIndex) {
                neighbours.add(i);
            }
        }
        return neighbours;
    }

    public List<String> getShortestRoundTripBrute() {
        Set<List<Integer>> indicesPermutations = IntegerPermutation.allPertmutations(cities.size());
        int minCost = Integer.MAX_VALUE;
        List<Integer> optimalRoute = null;
        for (List<Integer> route : indicesPermutations) {
            int cost = getCost(route);
            if (cost < minCost) {
                minCost = cost;
                optimalRoute = route;
            }
        }

        if (optimalRoute == null) {
            return null;
        }

        List<String> solution = new ArrayList<>();
        for (Integer cityIndex : optimalRoute) {
            solution.add(cities.get(cityIndex));
        }
        return solution;
    }

    public int getRoundTripCost(List<String> route) {
        if (route == null) {
            return Integer.MAX_VALUE;
        }
        int cost = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            if (getCost(route.get(i), route.get(i + 1)) == 0) {
                return Integer.MAX_VALUE;
            } else {
                cost += getCost(route.get(i), route.get(i + 1));
            }
        }
        if (getCost(route.get(route.size() - 1), route.get(0)) == 0) {
            return Integer.MAX_VALUE;
        } else {
            cost += getCost(route.get(route.size() - 1), route.get(0));
        }
        return cost;
    }

    private int getCost(List<Integer> route) {
        int cost = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            if (matrix[route.get(i)][route.get(i + 1)] == 0) {
                return Integer.MAX_VALUE;
            } else {
                cost += matrix[route.get(i)][route.get(i + 1)];
            }
        }
        if (matrix[route.get(route.size() - 1)][route.get(0)] == 0) {
            return Integer.MAX_VALUE;
        } else {
            cost += matrix[route.get(route.size() - 1)][route.get(0)];
        }
        return cost;
    }

    public List<String> getGreedyRoundTrip(String start) {
        Integer indexStart = cities.indexOf(start);
        if (indexStart < 0) {
            throw new IllegalArgumentException();
        }
        List<String> route = new ArrayList<>();
        boolean[] visited = new boolean[cities.size()];
        Deque<Integer> toProcess = new LinkedList<>();
        toProcess.push(indexStart);
        while (!toProcess.isEmpty()) {
            Integer vertex = toProcess.pop();
            visited[vertex] = true;
            route.add(cities.get(vertex));
            List<Integer> neighbours = getNeighbours(vertex);
            Integer nextToVisit = -1;
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    if (nextToVisit < 0) {
                        nextToVisit = neighbour;
                    } else if (matrix[vertex][nextToVisit] > matrix[vertex][neighbour]) {
                        nextToVisit = neighbour;
                    }
                }
            }
            if (nextToVisit >= 0) {
                toProcess.push(nextToVisit);
            }
        }
        if (route.size() != cities.size()
                || matrix[cities.indexOf(route.get(0))][cities.indexOf(route.get(route.size() - 1))] == 0) {// Invalid
                                                                                                            // route
            return null;
        }
        return route;
    }

    public List<String> getShortestRoundTripBacktrack() {
        List<Integer> indices = new ArrayList<>();
        for (int i = 1; i < matrix.length; i++) {
            indices.add(i);
        }
        List<Integer> optimalCost = new ArrayList<>();
        optimalCost.add(Integer.MAX_VALUE);
        List<Integer> route = getShortestRoundTripBacktrack(matrix, indices, Arrays.asList(new Integer[] { 0 }), 0,
                optimalCost);
        return convertFromIndices(route);
    }

    private static List<Integer> getShortestRoundTripBacktrack(int[][] matrix, List<Integer> vertices,
            List<Integer> currentPath, int currentCost, List<Integer> optimalCost) {

        if (currentCost >= optimalCost.get(0)) {
            return null;
        }

        if (vertices.isEmpty()) {
            if (matrix[0][currentPath.get(currentPath.size() - 1)] != 0
                    && currentCost + matrix[0][currentPath.get(currentPath.size() - 1)] < optimalCost.get(0)) {
                optimalCost.set(0, currentCost + matrix[0][currentPath.get(currentPath.size() - 1)]); // new optimal
                                                                                                      // cost
                return currentPath;
            } else {
                return null;
            }
        }
        List<Integer> route = null;
        for (Integer vertex : vertices) {
            if (matrix[currentPath.get(currentPath.size() - 1)][vertex] != 0) {
                List<Integer> augmentedPath = new ArrayList<Integer>(currentPath);
                augmentedPath.add(vertex);
                List<Integer> remainingVertices = new ArrayList<>(vertices);
                remainingVertices.remove(vertex);
                List<Integer> newRoute = getShortestRoundTripBacktrack(matrix, remainingVertices, augmentedPath,
                        currentCost + matrix[currentPath.get(currentPath.size() - 1)][vertex], optimalCost);
                if (newRoute != null) {
                    route = newRoute;
                }
            }
        }
        return route;
    }

    public void print() {
        StringBuffer output = new StringBuffer();
        output.append("{");
        for (int[] costs : matrix) {
            output.append("{");
            for (int cost : costs) {
                output.append(cost);
                output.append(", ");
            }
            output.delete(output.length() - 2, output.length());
            output.append("},\n");
        }
        output.delete(output.length() - 2, output.length());
        output.append("}\n");
        System.out.println(output);
    }

    public static TSPGraph createRandomTSP(int numberVertex, long seed) {
        Random generator = new Random(seed);
        int numberVertices = numberVertex;
        String[] vertices = new String[numberVertices];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = Integer.toString(i);
        }
        TSPGraph graph = new TSPGraph(vertices);
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < i; j++) {
                graph.addEdge(Integer.toString(i), Integer.toString(j), generator.nextInt(30));
            }
        }
        graph.print();
        return graph;
    }

    public static void main(String[] args) {

        // printRandomTSP(6,100);
        TSPGraph network = new TSPGraph(new String[]{"1", "2", "3", "4"});
        network.addEdge("1", "2", 10);
        network.addEdge("1", "3", 15);
        network.addEdge("1", "4", 20);
        network.addEdge("3", "2", 35);
        network.addEdge("4", "2", 25);
        network.addEdge("4", "3", 30);

        List<String> optimalRoute;
        optimalRoute = network.getShortestRoundTripBrute();
        System.out.println("Brute Force:  " + network.getRoundTripCost(optimalRoute) + " : " + optimalRoute);
        optimalRoute = network.getShortestRoundTripBacktrack();
        System.out.println("Backtrack:  " + network.getRoundTripCost(optimalRoute) + " : " + optimalRoute);
        // List<String> suboptimalRoute = network.getGreedyRoundTrip("1");
        // System.out.println("Greedy:  " + network.getRoundTripCost(suboptimalRoute) + " : " + suboptimalRoute);
        TSPGraph graph;
        long seed = 100;
        for (int i = 5; i < 11; i++) {
            System.out.println("------------------------------------------------------\n");
            graph = createRandomTSP(i, seed + i);
            optimalRoute = graph.getShortestRoundTripBrute();
            System.out.println("Brute force:  " + graph.getRoundTripCost(optimalRoute) + " : " + optimalRoute);
            optimalRoute = graph.getShortestRoundTripBacktrack();
            System.out.println("Backtrack:  " + graph.getRoundTripCost(optimalRoute) + " : " + optimalRoute);
        }

    for (int i = 11; i < 18; i++) {
        System.out.println("------------------------------------------------------\n");
        graph = createRandomTSP(i, seed + i);
        optimalRoute = graph.getShortestRoundTripBacktrack();
        System.out.println("Backtrack:  " + graph.getRoundTripCost(optimalRoute) + " : " + optimalRoute);
    }
}

}
