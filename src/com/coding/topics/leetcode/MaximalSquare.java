package com.coding.topics.leetcode;

public class MaximalSquare {
    public boolean scanForMaximalSquare(char[][] matrix, int i, int j, int temp, int m, int n){
        if ((i+temp <= m) && (j+temp <= n)) {
            for(int x = i; x < i+temp; x++){
                for(int y = j; y < j+temp; y++){
                    if(matrix[x][y] != '1'){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }


    public int maximalSquare(char[][] matrix) {
        int maxArea = 0;
        int m = matrix.length;
        int n = matrix[0].length;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                int temp = 1;
                boolean result = true;

                while(result) {
                    result = scanForMaximalSquare(matrix, i, j, temp, m, n);

                    if(result) {
                        maxArea = Math.max(maxArea, temp*temp);
                    }
                    temp++;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        int maxArea = maximalSquare.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
        System.out.println("Max Area : " + maxArea);
    }
}
