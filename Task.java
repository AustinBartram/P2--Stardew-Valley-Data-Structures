/**
 * The Task class represents a task with a priority, waiting time, task type, and description.
 * It implements the TaskInterface and Comparable interfaces, allowing it to be used in a max heap
 * data structure for priority queue management. The class provides methods to get and set the priority,
 * retrieve the task type and description, and manage the waiting time for the task.
 * @author Austin Bartram
 */

/**
 * The Task class represents a task with a priority, waiting time, task type, and description.
 */
public class Task implements TaskInterface, Comparable<Task>
{   private int priority;
    private int hourCreated;
    private int waitingTime;
    private TaskType taskType;
    private String description;

    /**
     * the constructor initializes a Task object with the specified priority, task type, and description.
     * @param priority
     * @param taskType
     * @param description
     */
    public Task(int priority, TaskType taskType, String description, int hourCreated) {
        this.priority = priority;
        this.waitingTime = 0;
        this.taskType = taskType;
        this.description = description;
        this.hourCreated = hourCreated;
    }

    /**
     * the getPriority method returns the priority of the task.
     */
   @Override
   public int getPriority() {
      return priority;
   }
   
   /**
    * the setPriority method sets the priority of the task to the specified value.
     * @param priority
    */
   @Override
   public void setPriority(int priority) {
      this.priority = priority;
   }

   /**
    * the getTaskType method retrieves the type of the task, which is defined by the TaskType enum.
    */
   @Override
   public TaskInterface.TaskType getTaskType() {
      return taskType;
   }

   /**
    * the getTaskDescription method retrieves the description of the task.
    */
   @Override
   public void incrementWaitingTime() {
    waitingTime++;
   }


   /**
    * the incrementWaitingTime method increments the waiting time of the task by one unit.
    */
   @Override
    public void resetWaitingTime() {
    waitingTime = 0;
    }

    /**
     * the getWaitingTime method returns the current waiting time of the task.
     */
    @Override
    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * the resetWaitingTime method resets the waiting time of the task to zero.
     */
    @Override
    public String getTaskDescription() {
        return description;
    }

    /**
     * the compareTo method compares the current Task object with another Task object based on their priority and hourCreated.
      * It returns a positive integer if the current task has a higher priority, a negative integer if it has a lower priority,
      * and zero if both tasks have the same priority and hour created. This method is used to maintain the order of tasks in a max heap.
      * @param other
     */
    @Override
    public int compareTo(Task other) {
        /**
         * First, compare the priority of the tasks. A higher priority value indicates a higher priority task.
         * If the current task has a higher priority than the other task, it should be considered greater (return 1).
         * If the current task has a lower priority than the other task, it should be considered lesser (return -1).
         * If the priorities are equal, the method will proceed to compare the hourCreated to determine the order of tasks with the same priority.
         */
        if (this.priority > other.priority) {
            return 1;
        } else if (this.priority < other.priority) {
            return -1;
        } 

        /**
         * If the priorities are equal, compare the hourCreated to determine the order of tasks with the same priority.
         * Tasks that were created earlier should be considered higher priority than those created later.
         */
        if (this.hourCreated < other.hourCreated) {
            return 1;
        } else if (this.hourCreated > other.hourCreated) {
            return -1;
        }

        return 0;
    }
}
