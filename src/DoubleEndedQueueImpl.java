import java.io.PrintStream;
import java.util.NoSuchElementException;

public class DoubleEndedQueueImpl implements DoubleEndedQueue
{
    /* Implements the Double Ended Queue
* Contains private inner class: DNode constructor, get, set, return methods and the node's pointers
* Contains 2 constructors, one default and one with a string argument(Queue name), get methods, isEmpty method
*/

    private DNode head, tail;
    private String name;

    private class DNode
    {

        private DNode next, prev;
        private int val;

        DNode(int i)
        {
            this.val = i;
            this.next = null;
            this.prev = null;
        }

        public int getVal()
        {
            return this.val;
        }

        public DNode getNext()
        {
            return this.next;
        }

        public void setNext(DNode dn)
        {
            this.next = dn;
        }

        public DNode getPrev()
        {
            return this.prev;
        }

        public void setPrev(DNode dn)
        {
            this.prev = dn;
        }
    }//end of DNode

    //Constructor
    public DoubleEndedQueueImpl(String str)
    {
        this.name = str;
        head = tail = null;
    }

    //Default constructor
    public DoubleEndedQueueImpl()
    {
        this("DoubleEndedQueue");
    }

    public DNode getHead()
    {
        return this.head;
    }

    public DNode getTail()
    {
        return this.tail;
    }

    public boolean isEmpty()
    {
        return (head == null);
    }


    public void addFirst(int item) 
    {
        DNode node = new DNode(item); //Creates new DNode
        if (isEmpty()) //Checks if the queue is empty
        {
            head = tail = node; //The inserted node is both the head and the tail
        } else
        {
            node.setNext(head); //Sets the new node's "next" pointer to the previous head
            head.setPrev(node); //Sets the previous head's "prev" pointer to the new node
            head = node; //Sets the new head node
        }
    }

    public int removeFirst() //Removes the first(newest) node of the queue and returns its content
    {
        if (isEmpty())
        {
            throw new NoSuchElementException(); //If the queue is empty (null head and tail) throws an exception
        }
        int val = head.getVal(); //Return value
        if (head == tail) //If the queue contained only one node, it is now empty
        {
            head = tail = null;
        }
        else //If the queue contains >2 nodes, it removes the node
        {
            head.getNext().setPrev(null); //Removes the "prev" pointer
            head = head.getNext(); //Sets the new head
        }
        return val;
    }

    public int removeLast() //Removes the last(oldest) node of the queue and returns its content
    {
        if (tail == null)
        {
            throw new NoSuchElementException();
        }
        int val = tail.getVal(); //Return value
        if (head == tail)
        {
            head = tail = null;
        } else
        {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
        }
        return val;
    }

    public int getFirst() //Returns the head node's value
    {
        if (head == null)
        {
            throw new NoSuchElementException();
        }
        return head.getVal();
    }

    public int getLast() //Returns the tail node's value
    {
        if (tail == null)
        {
            throw new NoSuchElementException();
        }
        return tail.getVal();
    }

    public void printQueue(PrintStream stream)
    {
        if (isEmpty())
        {
            stream.append("Double Ended Queue is empty.");
        }
        else
        {
            DNode n = head; //Temporary node
            stream.append(name + " : "); //Prints the queue name
            do
            {
                stream.append(n.getVal() + " "); //Prints the nodes
            } while ((n = n.getNext()) != null); //Sets the next node to the temporary node and continues
        }
        stream.append("\n");
        stream.flush(); //Empties the stream
    }

    public int size() //Counts the number of nodes with a counter
    {
        if (isEmpty())
        {
            return 0;
        }
        else
        {
            DNode n = head;
            int size = 0;
            do
            {
                size++;
            } while ((n = n.getNext()) != null);
            return size;
        }
    }
}