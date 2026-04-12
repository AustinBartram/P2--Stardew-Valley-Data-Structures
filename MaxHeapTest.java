import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for MaxHeap using a JUnit style. 
 * @author Austin Bartram
 */
public class MaxHeapTest {

    private MaxHeap heap;

    @BeforeEach
    void setUp() {
        heap = new MaxHeap();
    }

    private Task makeTask(int priority, int hourCreated) {
        return new Task(priority, Task.TaskType.FARM_MAINTENANCE, "Task " + priority, hourCreated);
    }

    @Test
    void testEmpty() {
        assertTrue(heap.isEmpty());
    }

    @Test
    void testInsert() throws HeapException {
        heap.insert(new Task(3, Task.TaskType.FISHING, "Low", 0));
        heap.insert(new Task(7, Task.TaskType.MINING, "High", 1));

        assertFalse(heap.isEmpty());
        assertEquals(7, heap.max().getPriority());
    }

    @Test
    void testExtractMax() throws HeapException {
        heap.insert(new Task(2, Task.TaskType.FISHING, "A", 0));
        heap.insert(new Task(6, Task.TaskType.MINING, "B", 1));
        heap.insert(new Task(4, Task.TaskType.FARM_MAINTENANCE, "C", 2));

        assertEquals(6, heap.extractMax().getPriority());
        assertEquals(4, heap.extractMax().getPriority());
        assertEquals(2, heap.extractMax().getPriority());
    }

    @Test
    void testIncreaseKey() throws HeapException {
        heap.insert(new Task(1, Task.TaskType.FISHING, "A", 0));
        heap.insert(new Task(5, Task.TaskType.MINING, "B", 1));
        heap.insert(new Task(3, Task.TaskType.FARM_MAINTENANCE, "C", 2));

        heap.increaseKey(2, new Task(10, Task.TaskType.FISHING, "A", 0));

        assertEquals(10, heap.extractMax().getPriority());
    }

    @Test
    void testOrder() throws HeapException {
        for (int i = 1; i <= 5; i++) {
            heap.insert(new Task(i, Task.TaskType.FISHING, "Task " + i, i));
        }

        int last = Integer.MAX_VALUE;

        while (!heap.isEmpty()) {
            int current = heap.extractMax().getPriority();
            assertTrue(current <= last);
            last = current;
        }
    }

    @Test
    void testEmptyExtract() {
        assertThrows(Exception.class, () -> heap.extractMax());
    }

    private boolean isHeap(Task[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;

            if (left < arr.length && arr[i].compareTo(arr[left]) < 0) {
                return false;
            }

            if (right < arr.length && arr[i].compareTo(arr[right]) < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testAscendingInsert() throws HeapException {
        int size = 25;

        for (int i = 1; i <= size; i++) {
            heap.insert(makeTask(i, i));
        }

        assertTrue(isHeap(heap.getHeap()));

        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = heap.extractMax().getPriority();
        }

        assertTrue(isSorted(nums));
    }

    @Test
    void testDescendingInsert() throws HeapException {
        int size = 25;

        for (int i = size; i >= 1; i--) {
            heap.insert(makeTask(i, i));
        }

        assertTrue(isHeap(heap.getHeap()));

        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = heap.extractMax().getPriority();
        }

        assertTrue(isSorted(nums));
    }

    @Test
    void testRandomInsert() throws HeapException {
        int size = 25;
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(25) + 1;
            heap.insert(makeTask(num, i));
        }

        assertTrue(isHeap(heap.getHeap()));

        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = heap.extractMax().getPriority();
        }

        assertTrue(isSorted(nums));
    }
}
