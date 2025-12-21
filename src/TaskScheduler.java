import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    private PriorityTaskQueue queue;
    private Map<String, Task> taskMap;

    public TaskScheduler() {
        queue = new PriorityTaskQueue();
        taskMap = new HashMap<>();
    }

    public void addTask(Task task) {
        queue.add(task);
        taskMap.put(task.getId(), task);
    }

    public Task getNextTask() {
        Task next = queue.poll();
        if (next != null) {
            taskMap.remove(next.getId());
        }
        return next;
    }

    public boolean containsTask(String id) {
        return taskMap.containsKey(id);
    }
}
