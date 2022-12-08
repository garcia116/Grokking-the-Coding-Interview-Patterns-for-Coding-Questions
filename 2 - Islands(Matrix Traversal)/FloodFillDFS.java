/*

Any image can be represented by a 2D integer array (i.e., a matrix) where each cell represents the pixel value of the image.

Flood fill algorithm takes a starting cell (i.e., a pixel) and a color. The given color is applied to all horizontally and vertically connected cells with the same color as that of the starting cell. Recursively, the algorithm fills cells with the new color until it encounters a cell with a different color than the starting cell. 

Given a matrix, a starting cell, and a color, flood fill the matrix.

Example 1

Input: matrix =



     starting cell = (1, 3)
     new color = 2
Output:


Example 2

Input: matrix =



     starting cell = (3, 2)
     new color = 5
Output:

*/

import java.util.*;

public class FloodFillDFS {
    public static int[][] floodFill(int[][] matrix, int x, int y, int newColor){
        
        if(matrix[x][y] != newColor){
            fillDFS(matrix, x, y, matrix[x][y], newColor);
        }
        
        return matrix;
    }
    public static void fillDFS(int[][] matrix, int x, int y, int oldColor, int newColor){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] != oldColor){
            return;
        }
        matrix[x][y] = newColor;
        
        fillDFS(matrix, x+1, y, oldColor, newColor);
        fillDFS(matrix, x-1, y, oldColor, newColor);
        fillDFS(matrix, x, y+1, oldColor, newColor);
        fillDFS(matrix, x, y-1, oldColor, newColor);
    }
    public static void main(String args[]) {
        System.out.println(Arrays.deepToString(FloodFillDFS.floodFill(
        new int[][] {
            { 0, 1, 1, 1, 0 },
            { 0, 0, 0, 1, 1 },
            { 0, 1, 1, 1, 0 },
            { 0, 1, 1, 0, 0 },
            { 0, 0, 0, 0, 0 }
        }, 1, 3, 2)));

    System.out.println(Arrays.deepToString(FloodFillDFS.floodFill(
        new int[][] {
            { 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0 },
            { 0, 0, 1, 1, 0 },
            { 0, 0, 1, 0, 0 },
            { 0, 0, 1, 0, 0 }
        }, 3, 2, 5)));
    }
}
