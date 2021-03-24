package com.cui.offer;

//二维数组中的查找
public class No4 {
    public static void main(String[] args) {
        // int[][] matrix = {{1,   4,  7, 11, 15},{2, 5, 8, 12, 19},{3, 6, 9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int[][] matrix = {};
        System.out.println(findNumberIn2DArray(matrix, 5));
        System.out.println(findNumberIn2DArray(matrix, 20));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        int n = matrix.length;
        if (n == 0)
            return false;
        else {
            int m = matrix[0].length;
            if (n > 1000 || m > 1000)
                return false;
            int row = 0;
            int column = m - 1;

            while (row <= n - 1 && column >= 0) {
                if (matrix[row][column] == target)
                    return true;
                else if (matrix[row][column] > target)
                    column--;
                else
                    row++;
            }
            return false;
        }
    }
}