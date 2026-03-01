/**
 * The MaxHeap class represents a max heap data structure that stores Task objects.
 * It provides methods for inserting tasks, extracting the maximum priority task, and checking if the heap is empty.
 * The heap is implemented using an array of Task objects, and it maintains the properties of a max heap.
 * @author Austin Bartram
 */

public class MaxHeap {
    protected Task[] A;
    private static final int SIZE = 10;
    protected int size;

    public MaxHeap() {
        A = new Task[SIZE]; 
        size = 0;
    }

    /**
     * the isEmpty method checks if the heap is empty by comparing the size of the heap to zero.
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * the max method returns the task with the highest priority (the maximum element) from the heap without removing it. 
     * It checks if the heap is empty and throws an exception if it is, otherwise it returns the task at the root of the heap (index 1).
     * @return
     */
    public Task max() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return A[1];
    }



    /**
     * the insert method adds a new Task to the heap while maintaining the properties of a max heap.
     * It checks if the heap is full and resizes it if necessary. Then, it adds the new Task to the    
     * end of the heap and performs a "heapify up" operation to ensure that the max heap property is maintained.
     * @param t
     */

    public void insert(Task t) {
        if (size == A.length - 1) {
            resize();
        }
       size++;
       A[size] = t;
       int currentIndex = size;
       while (currentIndex > 1 && A[currentIndex].compareTo(A[parentValue(currentIndex)]) > 0) {
            swap(currentIndex, parentValue(currentIndex));
            currentIndex = parentValue(currentIndex);
       }
    }

    /**
     * the increaseKey method increases the priority of a task at a given position in the heap and maintains the max heap property by performing a "heapify up" operation. 
     * It checks if the specified position is within the bounds of the heap, updates the task at that position with the new task, and then compares it with its parent. 
     * If the new task has a higher priority than its parent, it swaps them and continues this process until the max heap property is restored.
     * @param position
     * @param task
     */
    public void increaseKey(int position, Task task) {
        if(position < 1 || position > size) {
            throw new IllegalArgumentException("Position out of bounds");
        }   
        A[position] = task;
        while (position > 1 && A[position].compareTo(A[parentValue(position)]) > 0) {
            swap(position, parentValue(position));
            position = parentValue(position);
        } 
    }

    /**
     * the buildMaxHeap method constructs a max heap from an unordered array of tasks by calling the heapify method on each non-leaf node starting from the last non-leaf node down to the root.
      * This method ensures that the properties of the max heap are maintained throughout the construction process.
     */
    private void buildMaxHeap() {
        for (int i = size / 2; i >= 1; i--) {
            heapify(i);
        }
    }

    /**
     * the MaxHeap constructor that takes an array of Task objects as a parameter initializes the heap with the given array and builds a max heap using the buildMaxHeap method. 
     * It creates a new heap array with a size one greater than the input array to accommodate the 1-based indexing of the heap, copies the tasks from the input array to the heap, and then calls buildMaxHeap to ensure that the max heap properties are maintained.
     * @param array
     */
    public MaxHeap(Task[] array) {
        this.A = new Task[array.length + 1];
        this.size = array.length;

        for (int i = 0; i < array.length; i++) {
            A[i + 1] = array[i];
        }

        buildMaxHeap();
    }

    /**
     * Removes and returns the highest priority task from the heap while maintaining the max heap property.
     * @return
     */
    public Task extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        Task root = A[1]; 
        A[1] = A[size];
        A[size] = null;
        size--;
        heapify(1);
        return root;
    }

    /**
     * the heapify method is a helper method that maintains the properties of the max heap after extracting the maximum element.
     */
    protected void heapify(int index) {
        int largest = index;
        int left = leftSubVal(index);
        int right = rightSubVal(index);

        if (left <= size && A[left].compareTo(A[largest]) > 0) {
            largest = left;
        }
        if (right <= size && A[right].compareTo(A[largest]) > 0) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    /**
     * the resize method doubles the size of the heap array when it becomes full, allowing for more tasks to be added to the heap.
     * @param i
     * @param j
     */
    private void resize() {
        Task[] newHeap = new Task[A.length * 2];
        for (int i = 1; i <= size; i++) {
            newHeap[i] = A[i];            
        }
        A = newHeap;
    }

    /**
     * the swap method is a helper method that swaps two elements in the heap array based on their values.
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Task limitedLifeSpan = A[i];
        A[i] = A[j];
        A[j] = limitedLifeSpan;
    }

    /**
     * the parentValue method calculates the index of the parent of a given index in the heap array.
     * @param index
     * @return
     */
    private int parentValue(int index) {
        return index / 2;
    }

    /**
     * the leftSubVal method calculates the index of the left child of a given index in the heap array.
     * @param index
     * @return
     */
    private int leftSubVal(int index) {
        return 2 * index;
    }

    /**
     * the rightSubVal method calculates the index of the right child of a given index in the heap array.
     * @param index
     * @return
     */
    private int rightSubVal(int index) {
        return 2 * index + 1;
    }

}
