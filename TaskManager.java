import java.util.*;

class TaskManager {
    static class Task {
        int priority;
        int taskId;
        int userId;

        Task(int priority, int taskId, int userId) {
            this.priority = priority;
            this.taskId = taskId;
            this.userId = userId;
        }
    }

    PriorityQueue<Task> maxHeap;
    Map<Integer, Task> taskMap;
    Set<Integer> deleted;

    public TaskManager(List<List<Integer>> tasks) {
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) return b.priority - a.priority;  // Higher priority first
            return b.taskId - a.taskId;  // If priority is the same, higher taskId first
        });
        taskMap = new HashMap<>();
        deleted = new HashSet<>();

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            Task task = new Task(priority, taskId, userId);
            maxHeap.offer(task);
            taskMap.put(taskId, task);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(priority, taskId, userId);
        maxHeap.offer(task);
        taskMap.put(taskId, task);
    }

    public void edit(int taskId, int newPriority) {
        Task oldTask = taskMap.get(taskId);
        if (oldTask != null) {
            Task newTask = new Task(newPriority, taskId, oldTask.userId);
            maxHeap.offer(newTask);
            taskMap.put(taskId, newTask);
        }
    }

    public void rmv(int taskId) {
        deleted.add(taskId);
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            Task top = maxHeap.poll();
            if (!deleted.contains(top.taskId)) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
        }
        return -1;
    }
}
