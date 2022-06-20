package University-Code.Software2.WeekS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerPermutation {

    public static Set<List<Integer>> allPertmutations(int upperBound) {
        if (upperBound <= 0) {
            throw new IllegalArgumentException();
        }
        Set<List<Integer>> listPermutations = new HashSet<>();
        List<Integer> permutation = getFirstPermutation(upperBound);
        while(permutation != null){
            listPermutations.add(permutation);
            permutation = nextPermutation(permutation);
        }
        return listPermutations;
    }

    public static List<Integer> getFirstPermutation(int upperBound){
        List<Integer> permutation = new ArrayList<>();
        for (int i = 0; i < upperBound; i++) {
            permutation.add(i);
        }
        return permutation;
    }

    public static Set<List<Integer>> allPertmutationsBacktrack(int upperBound) {
        if (upperBound <= 0) {
            throw new IllegalArgumentException();
        }
        Set<List<Integer>> listPermutations = new HashSet<>();
        List<Integer> indices = new ArrayList<>(upperBound);
        for (int i = 0; i < upperBound; i++) {
            indices.add(i);
        }
        permutations(indices, new ArrayList<Integer>(), listPermutations);
        return listPermutations;
    }

    private static void permutations(List<Integer> elements, 
            List<Integer> currentPermutation,
            Set<List<Integer>> allPermutations) {
        if (elements.isEmpty()) {
            allPermutations.add(currentPermutation);

        } else {
            for (Integer elem : elements) {
                List<Integer> remainingElements = new ArrayList<>(elements);
                remainingElements.remove(elem);
                List<Integer> updatedPermutation = new ArrayList<>(currentPermutation);
                updatedPermutation.add(elem);
                permutations(remainingElements, updatedPermutation, allPermutations);
            }
        }
    }

    public static List<Integer> nextPermutation(List<Integer> sequence) {
        int indexDecreasing = sequence.size() - 1;
        while (indexDecreasing > 0 && sequence.get(indexDecreasing - 1) >= sequence.get(indexDecreasing)) {
            indexDecreasing--;
        }
        if (indexDecreasing <= 0) {
            return null;
        }
        int swapIndex = sequence.size() - 1;
        while (sequence.get(swapIndex) < sequence.get(indexDecreasing - 1)) {
            swapIndex--;
        }
        int swappedValue = sequence.get(swapIndex);
        List<Integer> nextPermutation = new ArrayList<>(sequence);
        nextPermutation.set(swapIndex, sequence.get(indexDecreasing - 1));
        nextPermutation.set(indexDecreasing - 1, swappedValue);
        Collections.reverse(nextPermutation.subList(indexDecreasing, nextPermutation.size()));
        return nextPermutation;
    }
}
