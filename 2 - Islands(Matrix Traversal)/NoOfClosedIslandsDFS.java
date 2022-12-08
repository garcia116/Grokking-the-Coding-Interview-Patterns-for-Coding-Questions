/*

You are given a 2D matrix containing only 1s (land) and 0s (water).

An island is a connected set of 1s (land) and is surrounded by either an edge or 0s (water). Each cell is considered connected to other cells horizontally or vertically (not diagonally).

A closed island is an island that is totally surrounded by 0s (i.e., water). This means all horizontally and vertically connected cells of a closed island are water. This also means that, by definition, a closed island can't touch an edge (as then the edge cells are not connected to any water cell). 

Write a function to find the number of closed islands in the given matrix.

Example 1

Input: matrix =



Output: 1
Explanation: The given matrix has two islands, but only the highlighted island is a closed island. The other island is touching the boundary that's why is is not considered a closed island.

Example 2

Input: matrix =



Output: 2
Explanation: The given matrix has two islands and both of them are closed islands.

*/

public class NoOfClosedIslandsDFS {
    public static int countClosedIslands(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int countClosedIslands = 0;
        boolean[][] visited = new boolean[rows][cols];
        
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    if(isClosedIslandDFS(matrix, visited, i, j)){
                        countClosedIslands++;
                    }
                }
            }
        }
        return countClosedIslands;
    }
    private static boolean isClosedIslandDFS(int[][] matrix, boolean[][] visited, int x, int y){
        if(x < 0 || x >= matrix.length || y < 0 || y > matrix[0].length){
            return false;
        }
        if(matrix[x][y] == 0 || visited[x][y]){
            return true;
        }
        
        visited[x][y] = true;
        boolean isClosed = true;
        
        isClosed &= isClosedIslandDFS(matrix, visited, x+1, y);
        isClosed &= isClosedIslandDFS(matrix, visited, x-1, y);
        isClosed &= isClosedIslandDFS(matrix, visited, x, y+1);
        isClosed &= isClosedIslandDFS(matrix, visited, x, y-1);
        
        return isClosed;
    }
    public static void main(String args[]) {
      System.out.println(NoOfClosedIslandsDFS.countClosedIslands(
        new int[][] {
            { 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0 },
            { 0, 0, 1, 1, 0 },
            { 0, 1, 1, 0, 0 },
            { 0, 0, 0, 0, 0 }
        }));

    System.out.println(NoOfClosedIslandsDFS.countClosedIslands(
        new int[][] {
            { 0, 0, 0, 0 },
            { 0, 1, 0, 0 },
            { 0, 1, 0, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 }
        }));

    }
}
