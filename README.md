# Project 2: Stardew-Valley

* Author: Austin Bartram
* Class: CS321-001, Amit Jain
* Semester: Spring, 2026

## Overview

This program implements a priority Queue using a max-heap data structure to simulate a task management system that is inspired by the game Stardew Valley. this game runs through specifications like a specified number of days, and then schedules that are task based on priority, waiting time, and creation time. These tasks are made and organized and structured while maintaining the proper heap structure to make sure that the highest-priority task goes first. 

## Reflection

What went well in this project was getting the testing and the format of the files down. I got to rely a lot on our notes from both the textbook and in class and through those resources I got to draft out and understand more of the complexion on max-heaps and priority queues. As I got to implement these all from scratch I got a lot of set backs on what I though would and wouldn't work, and some were even just based on the type of object parameter they were, But in the end it came together. The file that I had most of my time was the taskGenerator as I got to make the code and methods print how it should match the assignment requirements. 

Through this project I had a lot of problems that I could reflect on, and most of those came from the debugging and understanding the errors that came from certain segments. In moments I didn't understand why I had some errors and through multiple attempts to patch these errors I found new errors and a rabbit-hole of problems. Being able to get the update fnuctions properly working and re-heapifying the structure was a moment where I had a lot of confusion and struggle and I was not able to get the resizing down on my first try. Once I did get the simulation running I really enjoyed the limits and how well the program worked. 


## Compiling and Using

How to compile these files starts with downloading the required files which starts with all in these files: 
- MyLifeInStardew.java
- MyPriorityQueue.java
- PriorityQueueInterface.java
- MaxHeap.java
- MaxHeapTest.java
- run-tests.sh
- StardewValleyClock.java
- Task.java
- TaskGenerator.java
- TaskGeneratorInterface.java
- README.md(this file)

From there compile all the files in the project directory:
- javac *.java

This will generate .class files for all of the given files. 
The simulation is executed using:
- java MyLifeInStardew <max-priority-level> <time-to-increment-priority> <total-days> <task-generation-probability> [seed]

These parameters are defined by:
- <max-priority-level> - the maximum priority a task can reach.
- <time-to-increment-priority> - the number of hours before a task's priority can increase if not completed.
- <total-days>  - this is the number of days in the game to run the simulation.
- <task-generation-probability> - the probability of generating a task each hour. 
- [seed] - the optional random seed for reproducible results.

Example run:
- java MyLifeInStardew 5 2 2 0.5 10

This tells you:
- Maximum priority of 5.
- Priority increases every 2 hours.
- simulation runs for 2 days time.
- there is a 50% chance of generating a task each hour.
- using a random seed based 10.

## Results 

This should give a result that looks like: (given example:
java MyLifeInStardew 5 2 2 0.5 10 ):

+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                DAY: 1  LUCK: 0.73
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                6:00AM
                                                        NEW TASK: Task@4554617c
                7:00AM       Feeding the Cows at 200 energy points (Priority:0)
                                                        NEW TASK: Task@6d6f6e28
                8:00AM       Feeding the Cows at 190 energy points (Priority:0)
                                                        NEW TASK: Task@135fbaa4
                9:00AM       Feeding the Cows at 180 energy points (Priority:0)
                10:00AM      Mining for Iron at 170 energy points (Priority:1)
                11:00AM      Farm Maintenance of Harvesting Wheat at 150 energy points (Priority:1)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                                                        NEW TASK: Task@45ee12a7
                12:00PM      Feeding the Cows at 140 energy points (Priority:1)
                1:00PM       Mining for Iron at 130 energy points (Priority:1)
                2:00PM       Farm Maintenance of Harvesting Wheat at 110 energy points (Priority:1)
                3:00PM       Feeding the Cows at 100 energy points (Priority:1)
                4:00PM       Mining for Copper at 90 energy points (Priority:2)
                                                        NEW TASK: Task@330bedb4
                5:00PM       Mining for Iron at 70 energy points (Priority:1)
                                                        NEW TASK: Task@2503dbd3
                6:00PM       Feeding the Cows at 50 energy points (Priority:1)
                7:00PM       Farm Maintenance of Harvesting Wheat at 40 energy points (Priority:2)
                8:00PM       Mining for Iron at 30 energy points (Priority:1)
                9:00PM       Mining for Copper at 10 energy points (Priority:2)
                                         =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                                         THE DAY IS OVER
                                         Energy sufficiently depleted!
                                         =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                         Cash made today: +1125$
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                DAY: 2  LUCK: 0.74
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                                        NEW TASK: Task@4b67cf4d
                6:00AM       Farm Maintenance of Wood Chopping at 200 energy points (Priority:2)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                                                        NEW TASK: Task@7ea987ac
                7:00AM       Feeding the Cows at 190 energy points (Priority:2)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                                                        NEW TASK: Task@12a3a380
                8:00AM       Feeding the Pigs at 180 energy points (Priority:3)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                9:00AM       Mining for Iron at 170 energy points (Priority:2)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                                                        NEW TASK: Task@29453f44
                10:00AM      Farm Maintenance of Harvesting Wheat at 150 energy points (Priority:3)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                                                        NEW TASK: Task@5cad8086
                11:00AM      Mining for Copper at 140 energy points (Priority:2)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                                                        NEW TASK: Task@6e0be858
                12:00PM      Mining for Copper at 120 energy points (Priority:3)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                1:00PM       Farm Maintenance of Wood Chopping at 100 energy points (Priority:3)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                                                        NEW TASK: Task@61bbe9ba
                2:00PM       Feeding the Cows at 90 energy points (Priority:3)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                3:00PM       Fishing in the Lake at 80 energy points (Priority:4)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                4:00PM       Feeding the Chickens at 60 energy points (Priority:4)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                5:00PM       Feeding the Pigs at 50 energy points (Priority:4)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                6:00PM       Mining for Iron at 40 energy points (Priority:4)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                                                        NEW TASK: Task@610455d6
                7:00PM       Farm Maintenance of Harvesting Wheat at 20 energy points (Priority:4)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                                                        NEW TASK: Task@511d50c0
                8:00PM       Feeding the Cows at 10 energy points (Priority:5)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                                                        NEW TASK: Task@60e53b93
                9:00PM       Fishing in the Pond at 0 energy points (Priority:5)
                                         =====================================================
                                                        YOU PASSED OUT
                                                        Energy meter depleted by 50% and
                                                        Doctor's visit took 25% of your income!
                                         =====================================================
                                         =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                                         THE DAY IS OVER
                                         Energy sufficiently depleted!
                                         =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                         Cash made today: +1250$
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

--- Simulation completed ---
Simulation time: 2 days
Total Tasks generated: 16
Total Simulation hours: 32 hours
Total Money made: 1240$
Total deaths/passouts: 17

## Sources used (this is VERY important!)

As the instructions had indicated about the usage of AI, I usedGemini for the sake of asking questions about errors and compiling problems and how to debug certain spots. The first Error that I requested some elaboration on was about the Enums in Task and TaskInterface. I did not request code or other additions. Just to what the error means. The problem was regarding:
- @Override
public void decrementEnergyStorage(TaskInterface.TaskType taskType)

and I knew that I had the interface defined but I would repeatedly get the error:

-E[1] The type TaskGenerator must implement the inherited abstract method TaskGeneratorInterface.decrementEnergyStorage(Object)

-E[2] TaskGenerator is not abstract and does not override abstract method decrementEnergyStorage(Object) in TaskGeneratorInterface

along with:

-E[3] The constructor Task(int, TaskInterface.TaskType, String, int) is undefined.

and how these questions went was:
- Can you please help elaborate to what this error means and some steps regarding debugging. Here is the error and I don't understand why this is fully happening as I have declared the method. Here is the error: Error 1,2 & 3.

Then from there it defined the errors through how the constructor was requesting a different type of object to pass in. The third error was in the same prompt but the answer that I had recieved back was:
-Try and take a look at what type of parameters are being ran through these methods. If you have any other questions let me know.

And that is when I stopped requesting help. And once again I did not get any code from the AI, Just some elaboration on parameters and Enums. And with that I was able to solve the issues with no further prompts.

## Notes

I am going to use 2 late day coupons. 
