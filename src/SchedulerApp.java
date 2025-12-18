import java.time.LocalDateTime;

public class SchedulerApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTask(new Task("1", "Study", 5,
                LocalDateTime.now().plusHours(3), 120));

        scheduler.addTask(new Task("2", "Laundry", 2,
                LocalDateTime.now().plusDays(1), 30));

        scheduler.addTask(new Task("3", "Project", 5,
                LocalDateTime.now().plusHours(1), 180));

        System.out.println("Next task: " + scheduler.getNextTask());
    }
}
