import java.util.Random;

/**
 * the task generator class implements the taskGeneratorInterface and is responsible for generating new tasks 
 * based on a 'specified' probability. This class also manages the energy storage for the given tasks(Fishing, Mining, ...etc)
 * and provides methods to decrement energy storage based on the type of task, reset energy storage, and generate new tasks.
 * @author Austin Bartram
 */
/**
 * the taskGenerator class implements the taskGeneratorInterface and this generates more tasks.
 */
public class TaskGenerator implements TaskGeneratorInterface {
   private int currentEnergyStorage;
   private double taskGenerationProbability;
   private Random random;

   /**
    * the constructor that only has probability
    * @param probability
    */
   public TaskGenerator(double probability) {
      this.taskGenerationProbability = probability;
      this.currentEnergyStorage = DEFAULT_ENERGY;
      this.random = new Random();
   }

   /**
    * the constructor that has both probability and a seed
    * @param probability
    * @param seed
    */
   public TaskGenerator(double probability, long seed) {
      this.taskGenerationProbability = probability;
      this.random = new Random(seed);
      this.currentEnergyStorage = DEFAULT_ENERGY;
   }

   /**
    * the getNewTask method creates and returns a new task object which is based on these given parameters:
    * hourCreated, taskType, and taskDescription. The method initializes the new task with a priority of 0
    * and the provided parameters, allowing for the generation of tasks with specific characteristics.
    */
   @Override
   public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
      return new Task(0, taskType, taskDescription, hourCreated);
   }

   /**
    * the decrementEnergyStorage method reduces the current energy storage based on the type of task being performed.
    * Different task types have different energy costs, and this method updates the current energy storage accordingly
    * by checking the task type and applying the appropriate energy reduction. For example, mining and fishing tasks 
    * may consume more energy than feeding or socializing tasks.
    */
   @Override
   public void decrementEnergyStorage(Task.TaskType taskType) {
      switch (taskType) {
         case MINING:
         case FISHING:
            currentEnergyStorage -= 20;
            break;
         
         case FEEDING:
         case FARM_MAINTENANCE:
            currentEnergyStorage -= 10;
            break;

         case FORAGING:
         case SOCIALIZING:
            break;
      }
   }

   /**
    * the decrementEnergyStorage method reduces the current energy storage based on the type of task being performed. 
    * This method takes an Object as a parameter, casts it to a Task.TaskType, and then calls the decrementEnergyStorage 
    * method that accepts a Task.TaskType parameter to update the energy storage accordingly.
     * @param taskType
    */
   @Override
   public void decrementEnergyStorage(Object taskType) {
      decrementEnergyStorage((Task.TaskType) taskType);
   }

   /**
    * the resetCurrentEnergyStorage method resets the current energy storage to a default value, which is defined as DEFAULT_ENERGY.
    * This method is useful for restoring the energy storage to its initial state, allowing for a fresh start in managing energy levels for tasks.
    */
   @Override
   public void resetCurrentEnergyStorage() {
      currentEnergyStorage = DEFAULT_ENERGY;
   }

   /**
    * the getCurrentEnergyStorage method returns the current energy storage value, allowing other parts of the program to access and utilize this 
    * information for decision-making or display purposes. This method provides a way to retrieve the current energy level, which can be important 
    * for determining whether certain tasks can be performed based on available energy.
    */
   @Override
   public int getCurrentEnergyStorage() {
      return currentEnergyStorage;
   }

   /**
    * the setCurrentEnergyStorage method allows for updating the current energy storage value to a new specified amount. This method takes an integer parameter
    * representing the new energy amount and updates the currentEnergyStorage variable accordingly, providing flexibility in managing energy levels based on 
    * changing conditions or requirements.
    * @param newEnergyAmount
    */
   @Override
   public void setCurrentEnergyStorage(int newEnergyAmount) {
      currentEnergyStorage = newEnergyAmount;
   }

   /**
    * the generateTask method generates a new task based on a specified probability. It uses a random number generator to determine whether a new task
    * should be created, returning true if the generated random number is less than the taskGenerationProbability, and false otherwise. This method allows
    * for the dynamic creation of tasks based on probabilistic conditions, simulating real-world scenarios where tasks may arise unpredictably.
    * @return true or false - depending on if a new task is generated
    */
   @Override
   public boolean generateTask() {
      return random.nextDouble() < taskGenerationProbability;
   }

   /**
    * the getUnlucky method determines whether a task is considered "unlucky" based on a given probability. It generates a random number and compares it to the
    * provided unluckyProbability, returning 1 if the random number is less than the unluckyProbability.
    */
   @Override
   public int getUnlucky(Task task, double unluckyProbability) {
      if (random.nextDouble() < unluckyProbability) {
         return 1;
      }
      return 0;
   }

   /**
    * the toString method provides a string representation of a task based on its type and the current energy storage. It formats the output to include the 
    * task type, description, current energy storage, and priority, allowing for a clear and informative display of task details.
    */
   @Override
   public String toString(Task task, Task.TaskType taskType) {

      if(taskType == Task.TaskType.MINING) {
         return "     Mining " + task.getTaskDescription() + 
                " at " + currentEnergyStorage + 
                " energy points (Priority:" + task.getPriority() + ")";
        }

      if(taskType == Task.TaskType.FISHING) {
         return "     Fishing " + task.getTaskDescription() + 
                " at " + currentEnergyStorage + 
                " energy points (Priority:" + task.getPriority() + ")";
        }

      if(taskType == Task.TaskType.FARM_MAINTENANCE) {
         return "     Farm Maintenance " + task.getTaskDescription() + 
                " at " + currentEnergyStorage + 
                " energy points (Priority:" + task.getPriority() + ")";
        }

      if(taskType == Task.TaskType.FORAGING) {
         return "     Foraging " + task.getTaskDescription() + 
                " at " + currentEnergyStorage + 
                " energy points (Priority:" + task.getPriority() + ")";
        }

      if(taskType == Task.TaskType.FEEDING) {
         return "     Feeding " + task.getTaskDescription() + 
                " at " + currentEnergyStorage + 
                " energy points (Priority:" + task.getPriority() + ")";
        }

      if(taskType == Task.TaskType.SOCIALIZING) {
         return "     Socializing " + task.getTaskDescription() + 
                " at " + currentEnergyStorage + 
                " energy points (Priority:" + task.getPriority() + ")";
        }

         return "nothing to see here...";
   }

}
