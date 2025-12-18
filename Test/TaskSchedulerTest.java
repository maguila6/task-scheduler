import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class TaskSchedulerTest {

    @Test
    void highestPriorityTaskIsReturnedFirst() {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTask(new Task("1", "Low", 1,
                LocalDateTime.now().plusHours(1), 60));

        scheduler.addTask(new Task("2", "High", 5,
                LocalDateTime.now().plusHours(2), 30));

        Task next = scheduler.getNextTask();
        assertEquals("High", next.toString().split(" ")[0]);
    }
}
