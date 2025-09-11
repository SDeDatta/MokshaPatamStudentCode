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

public class MokshaPatam
{
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes)
    {
        // Creates an array to represent the "board"
        int[] jumpArray = new int[boardsize+1];
        for(int k = 1; k <= boardsize; k++)
        {
            jumpArray[k] = k;
        }
        // Includes the spots that ladders connect to as part of the board
        // Ex: If there is a ladder at 3 that goes to 17. The jumpArray "board" will store 17 at the 3rd spot not 3
        int spot = 0;
        for(int i = 0; i < ladders.length; i++)
        {
            spot = ladders[i][0];
            jumpArray[spot] = ladders[i][1];
        }
        // Includes snakes on the board
        for(int j = 0; j < snakes.length;j++)
        {
            spot = snakes[j][0];
            jumpArray[spot] = snakes[j][1];
        }
        // Creates a queue to check shortest path to final spot
        Queue<Integer> myQueue = new LinkedList<Integer>();
        // Adds the first spot on the board
        myQueue.add(1);
        int toVisit = 0;
        int next = 0;
        // Creates a visited array to determine if a spot has been visited or not
        boolean[] visited = new boolean[boardsize+1];
        // Creates an array to determine how many moves it takes to get to a given spot
        int[] count = new int[boardsize+1];
        visited[1] = true;
        // While there are still spots on the board to visit...keep going
        while(!myQueue.isEmpty())
        {
            // Pops the next board spot to look at
            toVisit = myQueue.remove();
            // Checks if current board spot is the final spot
            // If so, returns the number of moves it takes to get there
            if(toVisit == boardsize)
            {
                return count[toVisit];
            }
            // Checks each possible roll number
            for(int i = 1; i <= 6; i++)
            {
                next = toVisit + i;
                // Ensures the prospective spot is in the board
                if(next <= boardsize)
                {
                    // Makes sure we're not revisiting spots on the board over again
                    if(!visited[jumpArray[next]])
                    {
                        visited[jumpArray[next]] = true;
                        myQueue.add(jumpArray[next]);
                        // Adds one more move to get to a spot one "roll" away
                        count[jumpArray[next]] = count[toVisit] + 1;
                    }
                }
            }
        }
        return -1;
    }
}
