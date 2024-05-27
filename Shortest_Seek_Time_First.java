package DS_ALGO;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
public class Shortest_Seek_Time_First
{
    public static void SSTF(Queue<Integer> queue, int c)
	{
		System.out.println("Request sequence under SSTF "+queue);
		Queue<Integer> q2 = new LinkedList<Integer>();
		int totalDiskMovement=0;
		 while (!queue.isEmpty()) 
		 {
			 int min = Integer.MAX_VALUE;
	         int secondkey = Integer.MAX_VALUE;

	         // Find the next closest track
	         for (int key : queue)
	         {
	             int compare = Math.abs(key - c);
	              if (compare < secondkey) 
	            {
	              min = key;
	              secondkey = compare;
	            }
	         }
	        // Add the closest track to q2
	        q2.add(min);
	        // Update current head
	        c = min;
	        // Remove the closest track from q1
	       queue.remove(min);
	       // Update total disk movement
	       totalDiskMovement += secondkey;        
	     }
		System.out.println("Total disk movement = "+totalDiskMovement+" tracks");	
	}
	public static void main(String[] args) 
	{
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.addAll(Arrays.asList(95,180,34,119,11,123,62,64));
	
		// current head and tail can be taken at run time too
        int currentHead = 50;
        SSTF(q1,currentHead);
	}

}