/*

Given a 2D array (i.e., a matrix) containing only 1s (land) and 0s (water), count the number of islands in it.

An island is a connected set of 1s (land) and is surrounded by either an edge or 0s (water). Each cell is considered connected to other cells horizontally or vertically (not diagonally).

Example 1

Input: matrix =


Output: 1
Explanation: The matrix has only one island. See the highlighted cells below.

Example 2

Input: matrix =


Output: 3
Explanation: The matrix has three islands. See the highlighted cells below.


*/

public class NumOfIslandsDFS {
    public static int countIslands(int[][] matrix){
        int totalIslands = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        for(int i=0; i < rowLen; i++){
            for(int j=0; j < colLen; j++){
                if(matrix[i][j] == 1){
                    helper(i, j, rowLen, colLen, matrix);
                    totalIslands++;
                }
            }
        }
        return totalIslands;
    }
    public static void helper(int x, int y, int rowLen, int colLen, int[][] matrix){
        if(x < 0 || x >= rowLen || y < 0 || y >= colLen || matrix[x][y] != 1){
            return;
        }
        matrix[x][y] = 0;
        
        helper(x-1, y, rowLen, colLen, matrix);
        helper(x+1, y, rowLen, colLen, matrix);
        helper(x, y-1, rowLen, colLen, matrix);
        helper(x, y+1, rowLen, colLen, matrix);
    }
    public static void main(String args[]) {
      System.out.println(NumOfIslandsDFS.countIslands(
        new int[][] {
            { 0, 1, 1, 1, 0 },
            { 0, 0, 0, 1, 1 },
            { 0, 1, 1, 1, 0 },
            { 0, 1, 1, 0, 0 },
            { 0, 0, 0, 0, 0 }
        }));

    System.out.println(NumOfIslandsDFS.countIslands(
        new int[][] {
            { 1, 1, 1, 0, 0 },
            { 0, 1, 0, 0, 1 },
            { 0, 0, 1, 1, 0 },
            { 0, 0, 1, 0, 0 },
            { 0, 0, 1, 0, 0 }
        }));
    }
}
