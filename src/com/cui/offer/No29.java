package com.cui.offer;

// 顺时针打印矩阵
public class No29 {
    public static void main(String[] args) {
        int[][] data={
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7},
        };
        int[] result = spiralOrder(data);
        for(int i : result) {
            System.out.print(i+",");
        }

    }

    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;

        while(true) {
            for(int j = left; j <= right; j++) {
                result[index++] = matrix[top][j];
            }
            if(top == bottom) {              // 最后一圈形如 1,2,3
                break;
            }
            for(int i = top + 1; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            if(left == right) {            // 最后一圈形如 1,
                break;                     //             2,
            }                              //             3
            for(int j = right - 1; j >= left; j--) {
                result[index++] = matrix[bottom][j];
            }
            if(top + 1 == bottom) {           // 最后一圈形如 1,2,3    或 1,2
                break;                        //             4,5,6       3,4
            }
            for(int i = bottom - 1; i > top; i--) {
                result[index++] = matrix[i][left];
            }
            if(left + 1 == right) {             // 最后一圈形如  1,2
                break;                          //              3,4
            }                                   //              5,6
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
