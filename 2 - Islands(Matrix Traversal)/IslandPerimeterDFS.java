/*
You are given a 2D matrix containing only 1s (land) and 0s (water).

An island is a connected set of 1s (land) and is surrounded by either an edge or 0s (water). Each cell is considered connected to other cells horizontally or vertically (not diagonally).

There are no lakes on the island, so the water inside the island is not connected to the water around it. A cell is a square with a side length of 1.. 

The given matrix has only one island, write a function to find the perimeter of that island.

Example 1

Input: matrix =



Output: 14
Explanation: The boundary of the island constitute 14 sides.

Example 2

Input: matrix =



Output: 12
Explanation: The boundary of the island constitute 12 sides.
*/

public class IslandPerimeterDFS {
    public static int findIslandPerimeter(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        boolean visited[][] = new boolean[row][col];
        
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    return islandPerimeterDFS(matrix, visited, i, j);
                }
            }
        }
        
        return 0;
    }
    public static int islandPerimeterDFS(int[][] matrix, boolean[][] visited, int x, int y){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length){
            return 1;
        }
        if(matrix[x][y] == 0){
            return 1;
        }
        if(visited[x][y]){
            return 0; // we have already visited this cell
        }
        visited[x][y] = true;
        
        int edgeCount = 0;
        
        edgeCount += islandPerimeterDFS(matrix, visited, x+1, y);
        edgeCount += islandPerimeterDFS(matrix, visited, x-1, y);
        edgeCount += islandPerimeterDFS(matrix, visited, x, y+1);
        edgeCount += islandPerimeterDFS(matrix, visited, x, y-1);
        
        return edgeCount;
    }
    public static void main(String args[]) {
      System.out.println(IslandPerimeterDFS.findIslandPerimeter(
        new int[][] {
            { 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0 },
            { 0, 1, 1, 0, 0 },
            { 0, 0, 0, 0, 0 }
        }));

    System.out.println(IslandPerimeterDFS.findIslandPerimeter(
        new int[][] {
            { 0, 0, 0, 0 },
            { 0, 1, 0, 0 },
            { 0, 1, 0, 0 },
            { 0, 1, 1, 0 },
            { 0, 1, 0, 0 }
        }));
    }
}
