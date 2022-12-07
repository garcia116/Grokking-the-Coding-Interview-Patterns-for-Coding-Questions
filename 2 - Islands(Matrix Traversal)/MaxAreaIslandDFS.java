/*

Given a 2D array (i.e., a matrix) containing only 1s (land) and 0s (water), find the biggest island in it. Write a function to return the area of the biggest island. 

An island is a connected set of 1s (land) and is surrounded by either an edge or 0s (water). Each cell is considered connected to other cells horizontally or vertically (not diagonally).

Example 1

Input: matrix =



Output: 5
Explanation: The matrix has three islands. The biggest island has 5 cells .


*/

public class MaxAreaIslandDFS {
    public static int maxAreaOfIsland(int[][] matrix){
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int maxIslandArea = 0;
        
        for(int i=0; i < rowLen; i++){
            for(int j=0; j < colLen; j++){
                if(matrix[i][j] == 1){
                    
                    maxIslandArea = Math.max(maxIslandArea, visitIslandDFS(rowLen, colLen, i, j, matrix));
                }
            }
        }
        return maxIslandArea;
    }
    private static int visitIslandDFS(int rowLen, int colLen, int x, int y, int[][] matrix){
        if(x < 0 || x >= rowLen || y < 0 || y >= colLen || matrix[x][y] != 1){
            return 0;
        }
        matrix[x][y] = 0;
        
        int area = 1;
        // recursively visit all neighboring cells
        area += visitIslandDFS(rowLen, colLen, x+1, y, matrix);
        area += visitIslandDFS(rowLen, colLen, x-1, y, matrix);
        area += visitIslandDFS(rowLen, colLen, x, y+1, matrix);
        area += visitIslandDFS(rowLen, colLen, x, y-1, matrix);
        
        return area;

    }
    public static void main(String args[]) {
      System.out.println(MaxAreaIslandDFS.maxAreaOfIsland(
        new int[][] {
            { 1, 1, 1, 0, 0 },
            { 0, 1, 0, 0, 1 },
            { 0, 0, 1, 1, 0 },
            { 0, 1, 1, 0, 0 },
            { 0, 0, 1, 0, 0 }
        }));
    }
}
