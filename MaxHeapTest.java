/**
 * MaxHeap is a class that implements a max heap data structure to manage tasks based on their priority.
 * This testing class contains a series of tests to validate the functionality of the MaxHeap class,
 * including checking if the heap is empty, inserting tasks and verifying the maximum task, 
 * extracting tasks in descending order, increasing task priority, and confirming the correct order of extraction.
 * These tests follow the suggested testing guide for MaxHeap.
 * @author Austin Bartram
 */
public class MaxHeapTest {
    /**
     * the main driver method to run the series of tests for the MaxHeap class.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(" MaxHeap Testing: \n");
        emptyTest();
        insertTest();
        extractTest();
        increaseTest();
        orderTest();
        System.out.println("\n Finished Tests for MaxHeap");
    }

    /**
     *  test 1: new heap should be empty
     */
    public static void emptyTest() {
        MaxHeap heap = new MaxHeap();

        if (heap.isEmpty()) {
            System.out.println("emptyTest: PASS");
        } else {
            System.out.println("emptyTest: FAIL");
        }
    }

    /**
     * test 2: insert and check max()
     */
    public static void insertTest() {
        MaxHeap heap = new MaxHeap();

        heap.insert(new Task(3, Task.TaskType.FISHING, "Low", 0));
        heap.insert(new Task(7, Task.TaskType.MINING, "High", 1));

        if (!heap.isEmpty() && heap.max().getPriority() == 7) {
            System.out.println("insertTest: PASS");
        } else {
            System.out.println("insertTest: FAIL");
        }
    }

    /**
     * test 3: extractMax should return values in descending order
     */
    public static void extractTest() {
        MaxHeap heap = new MaxHeap();

        heap.insert(new Task(2, Task.TaskType.FISHING, "A", 0));
        heap.insert(new Task(6, Task.TaskType.MINING, "B", 1));
        heap.insert(new Task(4, Task.TaskType.FARM_MAINTENANCE, "C", 2));

        int first = heap.extractMax().getPriority();
        int second = heap.extractMax().getPriority();
        int third = heap.extractMax().getPriority();

        if (first == 6 && second == 4 && third == 2) {
            System.out.println("extractTest: PASS");
        } else {
            System.out.println("extractTest: FAIL");
        }
    }

    /**
     * test 4: increaseKey should move element up
     */
    public static void increaseTest() {
        MaxHeap heap = new MaxHeap();

        heap.insert(new Task(1, Task.TaskType.FISHING, "A", 0));
        heap.insert(new Task(5, Task.TaskType.MINING, "B", 1));
        heap.insert(new Task(3, Task.TaskType.FARM_MAINTENANCE, "C", 2));

        heap.increaseKey(2, new Task(10, Task.TaskType.FISHING, "A", 0));

        int max = heap.extractMax().getPriority();

        if (max == 10) {
            System.out.println("increaseTest: PASS");
        } else {
            System.out.println("increaseTest: FAIL");
        }
    }

    /**
     * test 5: insert 1-5 and confirm descending extraction
     */
    public static void orderTest() {
        MaxHeap heap = new MaxHeap();

        for (int i = 1; i <= 5; i++) {
            heap.insert(new Task(i, Task.TaskType.FISHING, "T" + i, i));
        }

        boolean correct = true;
        int previous = Integer.MAX_VALUE;

        while (!heap.isEmpty()) {
            int current = heap.extractMax().getPriority();

            if (current > previous) {
                correct = false;
                break;
            }
            previous = current;
        }

        if (correct) {
            System.out.println("orderTest: PASS");
        } else {
            System.out.println("orderTest: FAIL");
        }
    }

    /**
     * test 6: extractMax on empty heap should throw exception
     */
    public static void emptyExtractTest() {
        MaxHeap heap = new MaxHeap();
        try {
            heap.extractMax();
            System.out.println("emptyExtractTest: FAIL");
        } catch (Exception e) {
            System.out.println("emptyExtractTest: PASS");
        }
    }
}