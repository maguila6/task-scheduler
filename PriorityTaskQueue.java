import java.util.ArrayList;
import java.util.List;

public class PriorityTaskQueue {
    private List<Task> heap;

    public PriorityTaskQueue() {
        heap = new ArrayList<>();
    }

    public void add(Task task) {
        heap.add(task);
        heapifyUp(heap.size() - 1);
    }

    public Task poll() {
        if (heap.isEmpty()) return null;

        Task root = heap.get(0);
        Task last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return root;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (higherPriority(heap.get(index), heap.get(parent))) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        int left, right, best;

        while (true) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            best = index;

            if (left < heap.size() &&
                higherPriority(heap.get(left), heap.get(best))) {
                best = left;
            }

            if (right < heap.size() &&
                higherPriority(heap.get(right), heap.get(best))) {
                best = right;
            }

            if (best != index) {
                swap(index, best);
                index = best;
            } else break;
        }
    }

    private void swap(int i, int j) {
        Task temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
