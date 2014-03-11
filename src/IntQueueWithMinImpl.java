import java.io.PrintStream;
import java.util.NoSuchElementException;

public class IntQueueWithMinImpl implements IntQueueWithMin
{

    //The D queue tail node value is the minimum value of the F queue nodes
    private DoubleEndedQueueImpl dq;
    private IntQueueImpl fq;

    //Default constructor
    public IntQueueWithMinImpl()
    {
        dq = new DoubleEndedQueueImpl();
        fq = new IntQueueImpl();
    }

    //Constructor
    public IntQueueWithMinImpl(String Fname, String Dname)
    {
        dq = new DoubleEndedQueueImpl(Dname);
        fq = new IntQueueImpl(Fname);
    }

    public boolean isEmpty()
    {
        return fq.isEmpty();
    }

    public void put(int item)
    {
        fq.put(item);   //Inserts the new node at the F queue
        if (dq.isEmpty())
        {
            dq.addFirst(item);
        } 
        else
        {
            if (dq.getFirst() > item)   //Checks the D queue's head
            {
                /*
                * If the head is greater than the input
                * all the nodes after the head with values greater than the input value, are removed
                */
                while (dq.getFirst() > item)
                {
                    dq.removeFirst();
                    if (dq.isEmpty())
                    {
                        break;
                    }
                }
                dq.addFirst(item); //Adds the new head (input)
            } 
            else //If the head's value is lower or equal to the input value, it only inserts the input
            {

                dq.addFirst(item);
            }

        }
    }

    public int get() throws NoSuchElementException
    {
        int temp = fq.get(); //Return value, F queue head
        if (fq.isEmpty()) //If the removal at the previous line empties the F queue, empty the D queue
        {
            dq.removeLast();
        } 
        else if (dq.getLast() == temp) //Only removes the D queue's tail if it's equal to the input value
        {
            dq.removeLast();
        }
        return temp;
    }

    public void printQueue(PrintStream stream) //Prints both queues (FIFO queue F, double ended queue D)
    {
        fq.printQueue(stream);
        dq.printQueue(stream);
    }

    public int size()
    {
        return fq.size();
    }

    public int min() //Returns the queue's last(tail) node value, which is the minimum one
    {
        return dq.getLast();
    }
}