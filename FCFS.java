package DS_ALGO;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
public class FCFS {
    public static void calculateFCFS(Queue<Integer> queue, int c)
	{
		System.out.println("Request sequence under FCFS ="+queue);
		int totalDiskMovement=0;
		while(!queue.isEmpty())
		{
			int key = queue.poll();
			totalDiskMovement += Math.abs(c-key);
			c= key;
		}
		System.out.println("Total disk movement = "+totalDiskMovement+" tracks");	
	}
	public static void main(String[] args)
	{
		Queue<Integer>q1 = new LinkedList<Integer>();
		//adding tracks to be read/write in the queue
		q1.addAll(Arrays.asList(95,180,34,119,11,123,62,64));
		int currentTrackHead=50; //initial head position
		calculateFCFS(q1,currentTrackHead);
        
	}
    
}
