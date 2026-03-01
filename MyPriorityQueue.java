/**
 * The MyPriorityQueue class is a subclass of MaxHeap that implements the PriorityQueueInterface.
 * It provides implementations for the methods defined in the PriorityQueueInterface, such as enqueue, dequeue
 * isEmpty, and update. The MyPriorityQueue class is designed to manage and prioritize a queue of Task objects,
 * allowing for efficient insertion and retrieval.
 * @author Austin Bartram
 */
public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface{

    /**
     * adds a new Task to the priority queue using insert(), which is inherited from the MaxHeap class. This method takes an Object as a parameter, casts it to a Task, and then calls the insert method to add it to the heap.
     */
   @Override
    public void enqueue(Object task) {
        insert((Task) task);
    }

    /**
     * adds a new Task to the priority queue using insert(), which is inherited from the MaxHeap class. This method takes a Task object as a parameter and calls the insert method to add it to the heap.
     */
    @Override
    public void enqueue(Task task) {
        insert(task);
    }

    /**
     * the dequeue method removes the front element from the list by enforcing the extractMax method
     * from the MaxHeap class, which retrieves and removes the task with the highest priority.
     */
    @Override
    public Task dequeue() {
        return extractMax();
    }

    /**
     * the isEmpty method checks if the max-heap is empty by utilizing the isEmpty method from the MaxHeap class.
     * @return true or false - depending on if the Heap is empty
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * the update method iterates through the tasks in the max-heap and increments their waiting time. If a task's waiting time
     * reaches a specified threshold (timeToIncrementPriority) and its priority is below a maximum limit (maxPriority), the method increases the task's priority by one and resets its waiting time.
     * @param timeToIncrementPriority
     * @param maxPriority
     *
     */
    @Override
    public void update(int timeToIncrementPriority, int maxPriority) {
        for (int i = 1; i <= size; i++) {
            Task currentTask = A[i];

            currentTask.incrementWaitingTime();

            if (currentTask.getWaitingTime() >= timeToIncrementPriority && currentTask.getPriority() < maxPriority) {
                currentTask.setPriority(currentTask.getPriority() + 1);
                currentTask.resetWaitingTime();
            }
        }
        for (int i = size / 2; i >= 1; i--) {
        super.heapify(i);
    }
    }
}
