

import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 * Defines the methods for a double-ended queue that handles integers
 */
public interface DoubleEndedQueue {

    /**
     * Return true if the queue is empty
     */
    public boolean isEmpty();

    /**
     * Insert an integer item at the front of the queue
     */
    public void addFirst(int item);

    /**
     * Remove and return an integer item from the front of the queue
     */
    public int removeFirst();

    /**
     * Remove and return an integer item from the end of the queue
     */
    public int removeLast();

    /**
     * Return the first item in the queue
     */
    public int getFirst();

    /**
     * Return the last item in the queue
     */
    public int getLast();

    /**
     * Print the elements of the queue, starting from the front, 
     * to the print stream given as argument. For example, to print the elements
     * to the standard output, pass System.out as parameter. 
     * E.g., printQueue(System.out);
     */
    public void printQueue(PrintStream stream);

    /**
     * Return the size of the queue, 0 if it is empty
     */
    public int size();
}
