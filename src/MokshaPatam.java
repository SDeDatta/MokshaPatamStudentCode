import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Surya De Datta
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes)
    {
        int moves = 0;
        moves = (int) (boardsize/6) + 1;
        int [][] board = new int[(int) floor(sqrt(boardsize))][(int) (boardsize/floor(sqrt(boardsize)))];
        int counter = 0;
        for(int rows = 0; rows < board.length; rows++)
        {
            for(int col = 0; col < board[0].length; col++)
            {
                board[rows][col] = counter;
                counter++;
            }
        }
        Queue<Integer> nextCells = new LinkedList<>();
        int cellToAdd;
        int currentCell = maze.getStartCell();
        nextCells.add(currentCell);
        // Marks the start as the first step to solving the maze with BFS
        while(!nextCells.isEmpty())
        {
            // Removes the first cell in the queue (FIFO)
            currentCell = nextCells.remove();
            int row = currentCell.getRow();
            int col = currentCell.getCol();
            if(maze.isValidCell(row - 1,col))
            {
                cellToAdd = maze.getCell(row - 1, col);
                cellToAdd.setParent(currentCell);
                // Sets the neighboring cell as explored to make sure we don't go back to it after visiting once
                cellToAdd.setExplored(true);
                nextCells.add(cellToAdd);
            }
            if(maze.isValidCell(row,col + 1))
            {
                cellToAdd = maze.getCell(row , col + 1);
                cellToAdd.setParent(currentCell);
                cellToAdd.setExplored(true);
                nextCells.add(cellToAdd);
            }
            if(maze.isValidCell(row + 1,col))
            {
                cellToAdd = maze.getCell(row + 1, col);
                cellToAdd.setParent(currentCell);
                cellToAdd.setExplored(true);
                nextCells.add(cellToAdd);
            }
            if(maze.isValidCell(row,col - 1))
            {
                cellToAdd = maze.getCell(row , col - 1);
                cellToAdd.setParent(currentCell);
                cellToAdd.setExplored(true);
                nextCells.add(cellToAdd);
            }
        }
        // Returns the path from start to end
        return getSolution();
    }
        // import breadth first search to find the shortest path to the final square
            // Go through each of the spots you can get to with a roll between 1 and 6
            // Check if each of those spots has a snake, ladder, or neither
            // Check if square has been visited already or not
            // If not, add to queue to check

        // return the shortest path
        // if breadth first search doesn't end at the final spot, there is no solution
        //

        //
/*        while(spot != min)
        {
            for(int i = 1; i <= 6; i++)
            {
                if(spot-i >= min && i>biggestNumber)
                {
                    biggestNumber = i;
                }
            }
            spot -= biggestNumber;
            count++;
        }*/

        if(spot + count < 10 )
        for(int i = boardsize; i > 0; i++)
        {
            for(int j = 0; j < b)
        }
        return 0;
    }
}
