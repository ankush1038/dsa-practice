class Task{
    int id;
    int taskId;
    int priority;

    public Task(int id, int taskId, int priority){
        this.id=id;
        this.taskId=taskId;
        this.priority=priority;
    }
}
public class TaskManager {
    private final PriorityQueue<Task> maxHeap;
    private final Map<Integer, Task> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        maxHeap = new PriorityQueue<>((a,b)-> {
            if(a.priority!=b.priority){
                return Integer.compare(b.priority, a.priority);
            }
            else {
                return Integer.compare(b.taskId, a.taskId);
            }
        });
        taskMap = new HashMap<>();
        for (List<Integer> task : tasks) {
            int id = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            Task t1=new Task(id, taskId, priority);
            taskMap.put(taskId, t1);
            maxHeap.offer(t1);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task=new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        maxHeap.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        if(!taskMap.containsKey(taskId)){
            return;
        }
        Task oldTask=taskMap.get(taskId);
        Task newTask=new Task(oldTask.id, taskId, newPriority);
        taskMap.put(taskId, newTask);
        maxHeap.offer(newTask);

    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            Task top = maxHeap.poll();
            Task current = taskMap.get(top.taskId);
            // Make sure the polled task is the current valid one
            if (current != null && current == top) {
                taskMap.remove(top.taskId);
                return top.id;
            }
        }
        return -1;
    }

}