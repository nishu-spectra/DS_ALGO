package DS_ALGO;
import java.util.*;
/* In LOOK the head serves in left direction and instead of going to the beginning of the disk head it moves to the last request to be served in front of the head i.e,62 and then changes its direction thereafter */
public class LOOK {
    //function to calculate the total disk movement
    public static void findLOOK(Queue<Integer> queue, int c)
    {
    	System.out.println("Request Sequence under LOOK: "+queue);
    	int totalDiskMovement=0;
    	while(!queue.isEmpty())
        {
        	int currentElement = queue.poll();
        	int diff = Math.abs(c-currentElement);
        	totalDiskMovement += diff;
        	c= currentElement;
        }
    	System.out.println("Total disk movement= "+totalDiskMovement+" tracks");
    }
	public static void main(String[] args)
	{
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		q1.addAll(Arrays.asList(95,180,34,119,11,123,62,64));
		int currentHead = 50; 
        
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
        	findLOOK(q1,currentHead);
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
        	q2.addAll(q1);
        	findLOOK(q2,currentHead); 	
        }
	}
    
}
