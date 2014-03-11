

import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 * Defines the methods for a FIFO queue that handles integers
 */
public interface IntQueueWithMin {

    /**
     * Return true if the queue is empty
     */
    public boolean isEmpty();

    /**
     * Insert an integer item to the queue
     */
    public void put(int item);

    /**
     * Remove and return the oldest item of the queue
     * @throws NoSuchElementException is the queue is empty
     */
    public int get() throws NoSuchElementException;

    /**
     * Print the elements of the queue, starting from the oldest 
     * item, to the print stream given as argument. For example, to 
     * print the elements to the
     * standard output, pass System.out as parameter. E.g.,
     * printQueue(System.out);
     */
    public void printQueue(PrintStream stream);

    /**
     * Return the size of the queue, 0 if it is empty
     */
    public int size();

    /**
     * Return the minimum integer in the queue (i.e. its value) 
     */
    public int min();
}