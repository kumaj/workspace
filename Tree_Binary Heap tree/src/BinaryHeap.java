import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * http://www.sanfoundry.com/java-program-implement-binary-heap/ 
 * https://www.hackerearth.com/practice/notes/heaps-and-priority-queues/
 * @author kumaj04
 *
 */
public class BinaryHeap {
	private static final int d = 2;
	private int heapSize;
	private int[] heap;
	
	public BinaryHeap(int capacity) {
		heapSize = 0;
		heap = new int[capacity + 1];
		Arrays.fill(heap, -1);
	}
	
	/**
	 * Function to check if heap is empty.
	 * @return
	 */
	public boolean isEmpty() {
		return heapSize == 0;
	}
	
	/**
	 * Check if the heap is full.
	 * @return
	 */
	public boolean isFull() {
		return heapSize == heap.length;
	}
	
	/**
	 * clear heap.
	 */
	public void makeEmpty() {
		heapSize = 0;
	}
	
    /** Function to  get index parent of i **/
    public int parent(int i)  {
        return (i - 1)/d;
    }
    
	/**
	 * Function to get the kth child of i
	 * @param i
	 * @param k
	 * @return
	 */
	public int kthChild(int i, int k) {
		return d*i + k;
	}
	
	public void insert(int x) {
		if(isFull())
			throw new NoSuchElementException("Underflow exception");
		/** Perlocate up **/
		heap[heapSize++] = x;
		heapifyUp(heapSize - 1);
	}
	
	/**
	 * Method to get the min element
	 * @return
	 */
	public int findMin() {
		if(isEmpty())
			throw new NoSuchElementException("Underflow exception");
		return heap[0];
	}
	
	public int deleteMin() {
		int keyItem = heap[0];
		delete(0);
		return keyItem;
	}
	
	
	public int delete(int index) {
		if(isEmpty())
			throw new NoSuchElementException("Underflow exception");
		int keyItem = heap[index];
		heap[index] = heap[heapSize -1];
		heapSize--;
		heapifyDown(index);
		return keyItem;
	}
	
	/**
	 * Method to heapify up
	 * @param childIndex
	 */
	private void heapifyUp(int childIndex) {
		int temp = heap[childIndex];
		while(childIndex > 0 && temp < heap[parent(childIndex)]) {
			heap[childIndex] = heap[parent(childIndex)];
			childIndex = parent(childIndex);
		}
		heap[childIndex] = temp;
	}
	
	private void heapifyDown(int ind) {
        int child;
        int tmp = heap[ ind ];
        while (kthChild(ind, 1) < heapSize) {
            child = minChild(ind);
            if (heap[child] < tmp)
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
	}
	
    /** Function to get smallest child **/

    private int minChild(int ind) {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heapSize)) {
            if (heap[pos] < heap[bestChild]) 
                bestChild = pos;
            pos = kthChild(ind, k++);
        }    
        return bestChild;
    }
}

class Sloution {
	public static void main(String[] args) {
		
	}
}
