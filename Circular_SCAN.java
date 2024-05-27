package DS_ALGO;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public class Circular_SCAN {
    public static int C_SCAN(Queue<Integer> queue, int c)
	{
    	int totalDiskMovement=0;
    	while(!queue.isEmpty())
        {
        	int currentElement = queue.poll();
        	int diff = Math.abs(c-currentElement);
        	totalDiskMovement += diff;
        	c= currentElement;
        }
    	return totalDiskMovement;
	}
	public static void main(String[] args) 
	{
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		int currentHead=50;
		int tail = 199;
		int total=0;
		
		//creating list of queue for sorting
		q1.addAll(Arrays.asList(95,180,34,119,11,123,62,64));
		List<Integer> l1 = new ArrayList<Integer>(q1);
		Collections.sort(l1);//sorting the list
		q1.clear(); //removing the unsorted elements from the queue
		q1.addAll(l1);//adding sorted requests/elements in the queue
		int pointer=currentHead;
		//if the requests are all greater than or equal to the current head then the head will serve in only one direction
		if(q1.peek()>currentHead || q1.peek()==currentHead)
		{
		   pointer=q1.peek(); //updating pointer variable
		}
	    
		if(pointer==q1.peek())
		{
			q1.add(tail); //the head must reach its end 
			System.out.println("Request sequence under C_SCAN:\n "+q1);
			total=C_SCAN(q1,currentHead);
			currentHead=0;//after reaching the the end the head must move to the beginning to serve in a circular manner
			System.out.println("Total Disk Movement is "+total+" tracks");
		}
		//if all requests are not greater than current head
		else
		{
			//to break the queue into two half's
			while(q1.peek()<currentHead)
			{
				q2.add(q1.poll());
			}
			q1.add(tail);//the head must reach another end of the disk after serving in one direction
			//for reversing the left side queue
			List<Integer> l2 = new ArrayList<Integer>(q2);
			Collections.reverse(l2);
			q2.clear();
			q2.addAll(l2);
			q2.add(0);//adding beginning track as the head must reach the end track of the direction it is serving in
			List<Integer> l3 = new ArrayList<Integer>(q1);
			Collections.reverse(l3);
			q1.clear();
			q1.addAll(l3);
			//total disk movement in left from current head
			int firsttotal=C_SCAN(q2,currentHead);
			//total disk movement in left from end of disk
		    total = firsttotal+ C_SCAN(q1,q1.poll());
		}	
		System.out.println("Total Disk Movement is "+(total) +" tracks");
	}
    
}
