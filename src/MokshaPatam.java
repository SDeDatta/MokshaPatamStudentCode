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
        int[] jumpArray = new int[boardsize+1];
        for(int k = 1; k <= boardsize; k++)
        {
            jumpArray[k] = k;
        }
        int spot = 0;
        for(int i = 0; i < ladders.length; i++)
        {
            spot = ladders[i][0];
            jumpArray[spot] = ladders[i][1];
        }
        for(int j = 0; j < snakes.length;j++)
        {
            spot = snakes[j][0];
            jumpArray[spot] = snakes[j][1];
        }

        Queue<Integer> myQueue = new LinkedList<Integer>();
        myQueue.add(1);
        int toVisit = 0;
        int next = 0;
        boolean[] visited = new boolean[boardsize+1];
        int[] count = new int[boardsize+1];
        visited[1] = true;
        while(!myQueue.isEmpty())
        {
            toVisit = myQueue.remove();
            if(toVisit == boardsize)
            {
                return count[toVisit];
            }
            for(int i = 1; i <= 6; i++)
            {
                next = toVisit + i;
                if(next <= boardsize)
                {
                    if(!visited[jumpArray[next]])
                    {
                        visited[jumpArray[next]] = true;
                        myQueue.add(jumpArray[next]);
                        count[jumpArray[next]] = count[toVisit] + 1;
                    }
                }
            }
        }
        return -1;
    }
}
