import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * MaxHeap is a class that implements a max heap data structure to manage tasks based on their priority.
 * This testing class contains a series of tests to validate the functionality of the MaxHeap class,
 * including checking if the heap is empty, inserting tasks and verifying the maximum task, 
 * extracting tasks in descending order, increasing task priority, and confirming the correct order of extraction.
 * These tests follow the suggested testing guide for MaxHeap. The main difference is this testing class resorts to
 * using a JUnit testing framework.
 * @author Austin Bartram
 */
public class MaxHeapTest {

    private MaxHeap heap;

    @BeforeEach
    void setUp() {
        heap = new MaxHeap();
    }

    private Task task(int priority, int hourCreated) {
        return new Task(priority, TaskInterface.TaskType.FARM_MAINTENANCE, "p=" + priority, hourCreated);
    }

    @test
    void emptyTest() {
        assertTrue(heap.isEmpty());
    }

    @Test
    void insertTest() throws HeapException {
        heap.insert(new Task(3, Task.TaskType.FISHING, "Low", 0));
        heap.insert(new Task(7, Task.TaskType.MINING, "High", 1));

        assertFalse(heap.isEmpty());
        assertEquals(7, heap.max().getPriority());
    }

    @Test
    void extractTest() throws HeapException {
        heap.insert(new Task(2, Task.TaskType.FISHING, "A", 0));
        heap.insert(new Task(6, Task.TaskType.MINING, "B", 1));
        heap.insert(new Task(4, Task.TaskType.FARM_MAINTENANCE, "C", 2));

        assertEquals(6, heap.extractMax().getPriority());
        assertEquals(4, heap.extractMax().getPriority());
        assertEquals(2, heap.extractMax().getPriority());
    }

    @Test
    void increaseTest() throws HeapException {
        heap.insert(new Task(1, Task.TaskType.FISHING, "A", 0));
        heap.insert(new Task(5, Task.TaskType.MINING, "B", 1));
        heap.insert(new Task(3, Task.TaskType.FARM_MAINTENANCE, "C", 2));

        heap.increaseKey(2, new Task(10, Task.TaskType.FISHING, "A", 0));

        assertEquals(10, heap.extractMax().getPriority());
    }

    @Test
    void orderTest() throws HeapException {
        for (int i = 1; i <= 5; i++) {
            heap.insert(new Task(i, Task.TaskType.FISHING, "T" + i, i));
        }

        int previous = Integer.MAX_VALUE;

        while (!heap.isEmpty()) {
            int current = heap.extractMax().getPriority();
            assertTrue(current <= previous);
            previous = current;
        }
    }

    @Test
    void emptyExtractTest() {
        assertThrows(Exception.class, () -> {
            heap.extractMax();
        });
    }

    private boolean checkIfMaxHeap(Task[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length && arr[i].compareTo(arr[left]) < 0) return false;
            if (right < arr.length && arr[i].compareTo(arr[right]) < 0) return false;
        }
        return true;
    }

    private boolean checkIfReverseSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) return false;
        }
        return true;
    }

    @Test
    void insertAscending() throws HeapException {
        int n = 25;
        for (int i = 1; i <= n; i++) {
            heap.insert(task(i, i));
        }

        assertTrue(checkIfMaxHeap(heap.getHeap()));

        int[] extracted = new int[n];
        for (int i = 0; i < n; i++) {
            extracted[i] = heap.extractMax().getPriority();
        }
        assertTrue(checkIfReverseSorted(extracted));
    }

    @Test
    void insertDescending() throws HeapException {
        int n = 25;
        for (int i = n; i >= 1; i--) {
            heap.insert(task(i, i));
        }

        assertTrue(checkIfMaxHeap(heap.getHeap()));

        int[] extracted = new int[n];
        for (int i = 0; i < n; i++) {
            extracted[i] = heap.extractMax().getPriority();
        }
        assertTrue(checkIfReverseSorted(extracted));
    }

    @Test
    void insertRandom() throws HeapException {
        int n = 25;
        Random r = new Random(12345);

        for (int i = 0; i < n; i++) {
            int p = 1 + r.nextInt(n);
            heap.insert(task(p, i));
        }

        assertTrue(checkIfMaxHeap(heap.getHeap()));

        int[] extracted = new int[n];
        for (int i = 0; i < n; i++) {
            extracted[i] = heap.extractMax().getPriority();
        }
        assertTrue(checkIfReverseSorted(extracted));
    }
}