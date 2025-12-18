import java.time.LocalDateTime;

public class Task {
    private String id;
    private String name;
    private int priority; // 1–5
    private LocalDateTime deadline;
    private int durationMinutes;

    public Task(String id, String name, int priority,
                LocalDateTime deadline, int durationMinutes) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
        this.durationMinutes = durationMinutes;
    }

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return name + " (priority=" + priority +
               ", deadline=" + deadline +
               ", duration=" + durationMinutes + "m)";
    }
}
