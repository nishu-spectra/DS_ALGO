package DS_ALGO;
import java.util.*;
/* In C_LOOK the head serves in left moves to first request from the beginning and then moves to the last request of other end and serves thereafter */
public class Circular_LOOK 
{
    //function to calculate the total disk movement
	public static int C_LOOK(Queue<Integer> queue, int c)
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
		q1.addAll(Arrays.asList(95,180,34,119,11,123,62,64));
		int currentHead = 50; 
        int total=0;
        //for sorting the queue
        List<Integer> li = new ArrayList<Integer>(q1);
        Collections.sort(li);
        q1.clear(); //deleting unsorted elements from the queue
        q1.addAll(li);//adding sorted elements in the queue
        int pointer= currentHead;
        if(q1.peek()>currentHead || q1.peek()==currentHead)
        {
        	pointer = q1.peek();
        }
        if(pointer==q1.peek())
        {
        	System.out.println("Request sequence under C_LOOK "+q1);
        	total=C_LOOK(q1,currentHead);
        }
        else
        {
        	while(q1.peek()<currentHead)
        	{
        		q2.add(q1.poll());
        	}
        	List<Integer> l2 = new ArrayList<Integer>(q2);
        	Collections.reverse(l2);
        	q2.clear();
        	q2.addAll(l2);
        	List<Integer> l3 = new ArrayList<Integer>(q1);
        	Collections.reverse(l3);
        	q1.clear();
        	q1.addAll(l3);
        	int lefttotal= C_LOOK(q2,currentHead);
        	total = lefttotal +C_LOOK(q1,q1.poll());
        }
 ;       System.out.println("Total disk movement= "+total+" tracks");
	}
    
}
