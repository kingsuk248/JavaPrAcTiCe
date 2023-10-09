package sites.coding.codesignal;

public class MatrixElementSum {
    public static void main(String[] args) {
        MatrixElementSum mes = new MatrixElementSum();
        int[][] matrix = {{0, 1, 1, 2},
                          {0, 5, 0, 0},
                          {2, 0, 3, 3}};
        int result = mes.solution(matrix);
        System.out.println(result);
    }

    int solution(int[][] matrix) {
        int totalCost = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int cost = matrix[row][col];
                if (cost == 0 && row < matrix.length - 1) {
                    matrix[row + 1][col] = 0;
                } else {
                    totalCost += cost;
                }
            }
        }
        return totalCost;
    }

}
