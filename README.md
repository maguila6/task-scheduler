# Priority Task Scheduler (Java)

A Java-based task scheduling system that prioritizes tasks using a custom
binary heap implementation. Tasks are scheduled based on priority level
and deadline, ensuring high-importance and time-sensitive tasks are handled first.

## Features
- Custom max-heap priority queue (no Java PriorityQueue used)
- Task prioritization by:
  - Priority level (1–5)
  - Earliest deadline (tie-breaker)
- Add and retrieve scheduled tasks
- 
5 unit testing
- Clean object-oriented design

## Technologies
- Java 17
- JUnit 5
- Custom data structures
- Object-Oriented Programming (OOP)

## How It Works
- Tasks are inserted into a binary heap
- Higher priority tasks bubble up
- If priorities are equal, the task with the earlier deadline is selected
- The scheduler always returns the highest-priority task first

## How to Run
```bash
javac *.java
java SchedulerApp

##Sample Output
Next task: Project (priority=5, deadline=2025-..., duration=180m)

##Testing
Run unit tests using your IDE or:
- IntelliJ IDEA -> Run TaskSchedulerTest

##Future Improvements
- Persist taks to a date base
- Add a GUI or REST APi
- Support recurring tasks


Recruiters **do read this**.

---

##  Make 2 small code improvements (very portfolio-friendly)

### Improvement 1: Make `Task` comparable

This shows **data structure mastery**.

```java
public class Task implements Comparable<Task> {

    @Override
    public int compareTo(Task other) {
        if (this.priority != other.priority) {
            return Integer.compare(other.priority, this.priority);
        }
        return this.deadline.compareTo(other.deadline);
    }
}
Then the heap comparison becomes:
private boolean higherPriority(Task a, Task b) {
    return a.compareTo(b) < 0;
}

##Improvement 2: Add one more test
@Test
void earlierDeadlineWinsWhenPriorityEqual() {
    TaskScheduler scheduler = new TaskScheduler();

    scheduler.addTask(new Task("1", "Task A", 3,
            LocalDateTime.now().plusHours(3), 30));

    scheduler.addTask(new Task("2", "Task B", 3,
            LocalDateTime.now().plusHours(1), 30));

    Task next = scheduler.getNextTask();
    assertEquals("Task B", next.getName());
}

