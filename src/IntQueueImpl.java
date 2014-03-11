import java.io.PrintStream;
import java.util.NoSuchElementException;

public class IntQueueImpl implements IntQueue {
    /*
     * FIFO structure is being used to create a Queue
     * Tail represents the last object that was inserted and head the first object that was inserted
     */

    private Node tail, head;
    private String name;


    //inner class to create Node objects
    private class Node
    {

        private int val;
        private Node next;

        //Two-argument node constructor used to set node's val and node's next node
        public Node(int value, Node n)
        {
            this.val = value;
            this.next = n;
        }
        
        //One Argument constructor uses the two-argument constructor, but sets the next node to null
        public Node(int value)
        {
            this(value, null);
        }

        public int getVal()
        {
            return this.val;
        }

        public Node getNext()
        {
            return this.next;
        }
    }//end of Node

    //Queue Constructor
    public IntQueueImpl(String str)
    {
        this.name = str;
        tail = head = null;
    }

    //Default queue constructor
    public IntQueueImpl()
    {
        this("IntQueue");
    }

    public Node getHead()
    {
        return this.head;
    }

    public Node getTail()
    {
        return this.tail;
    }

    public boolean isEmpty()
    {
        return (head == null);
    }

    public void put(int item) //Inserts new node at the tail of the queue
    {
        Node n = new Node(item);
        if (isEmpty())
        {
            head = tail = n;    //Unique node
        }
        else
        {
            //Sets the new tail
            tail.next = n;
            tail = n;
        }
    }

    public int get() throws NoSuchElementException //Removes the head node and returns its value
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        } 
        else
        {
            int i = head.getVal(); //Return value
            if (head == tail)
            {
                head = tail = null; //The queue is emptied
            } 
            else
            {
                head = head.next;  //Sets the head's next node as the new head
            }
            return i;
        }
    }

    public void printQueue(PrintStream stream)
    {
        if (isEmpty())
        {
            stream.append("Queue is empty.");
        } 
        else
        {
            Node n = head;  //Temporary node
            stream.append(name + " : "); //Prints the queue name
            do
            {
                stream.append(n.getVal() + " ");    //Prints the nodes
            } while ((n = n.getNext()) != null);    //Sets the next node to the temporary node and continues
        }
        stream.append("\n");
        stream.flush(); //Empties the stream
    }

    public int size() //Counts the number of nodes with a counter
    {
        if (isEmpty())
        {
            return 0;
        } else
        {
            Node n = head;
            int size = 0;
            do
            {
                size++;
            } while ((n = n.getNext()) != null);

            return size;

        }

    }
}