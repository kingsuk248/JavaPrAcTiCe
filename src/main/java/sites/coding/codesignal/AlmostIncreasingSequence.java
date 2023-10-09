package sites.coding.codesignal;

/*
Given a sequence of integers as an array, determine whether it is possible to obtain
a strictly increasing sequence by removing no more than one element from the array.
*/
public class AlmostIncreasingSequence {
    public static void main(String[] args) {
        //int[] sequence = {1, 3, 2, 1};
        //int[] sequence = {3, 6, 5, 8, 10, 20, 15};
        int[] sequence = {1, 2, 3, 4, 99, 5, 6};
        boolean result = new AlmostIncreasingSequence().solution(sequence);
        System.out.println(result);
    }

    private boolean solution(int[] sequence) {
        return false;
    }
}
