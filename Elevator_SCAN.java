package DS_ALGO;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Elevator_SCAN {
    //function to calculate the total disk movement
    public static int SCAN(Queue<Integer> queue, int c)
    {
    	System.out.println("Stored read-write procedures for SCAN: "+queue);
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
        int tail = 199;
    
        List<Integer> li = new ArrayList<Integer>(q1);
        Collections.sort(li);
        q1.clear(); //deleting unsorted elements from the queue
        q1.addAll(li);//adding sorted elements in the queue
        int check=Integer.MAX_VALUE;
        if(q1.peek()>currentHead) //if the first element is less than current head
        {
        	check= tail; 
        }
        else if(q1.peek()<currentHead) //if first element is greater than current head
        {
        	check=0;
        }
        else //if both current head and first element are equal
        {
        	check=currentHead;
        }
        
        //loop to find out the element that is at least distance/time from the current head i.e,50 
        if(check==tail || check==currentHead)
        {
        	int total = SCAN(q1,currentHead);
            
            System.out.println("Total Disk Movement are "+total+" tracks");
        }
        else if(check==0)
        {
        	while(q1.peek()<currentHead)
            {
            	int key=q1.poll();
            	if(key<currentHead)
            	{
            		q2.add(key);
            	}
            }
        	
            List<Integer> l2 = new ArrayList<Integer>(q2);
            Collections.reverse(l2);
            q2.clear();//clear the un-reversed element from the queue
            q2.addAll(l2); //add the reversed element in the queue
            
            
            q2.add(0); //then add 0 as in SCAN the head tracer chooses one direction and then serves in that particular direction and after reaching the end of the track changes its direction
            q2.addAll(q1);//now adding the other queue
            
            //calculates the total disk movement
            int total = SCAN(q2,currentHead);
            
            System.out.println("Total Disk Movement are "+total+" tracks");

        	
        }
        
	}
    
}
