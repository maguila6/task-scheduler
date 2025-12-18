private boolean higherPriority(Task a, Task b) {
    if (a.getPriority() != b.getPriority())
        return a.getPriority() > b.getPriority();

    if (!a.getDeadline().equals(b.getDeadline()))
        return a.getDeadline().isBefore(b.getDeadline());

    return a.getDurationMinutes() < b.getDurationMinutes();
}
