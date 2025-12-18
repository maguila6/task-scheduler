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
        return queue.poll();
    }

    public boolean containsTask(String id) {
        return taskMap.containsKey(id);
    }
}
