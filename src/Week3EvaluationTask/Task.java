package Week3EvaluationTask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    String taskId;
    String taskName;
    String taskDescription;
    String status;
    String DoneBy;

    public Task(String taskId, String taskName, String taskDescription, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.status = status;
    }

    public Task(String taskId, String taskName, String taskDescription, String status, String doneBy) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.status = status;
        DoneBy = doneBy;
    }

    static ArrayList<Task> tasks = new ArrayList<>();

    static ArrayList<Task> getTasks(){
        loadtasks();
        return tasks;
    }

     static void loadtasks(){
        try {
            File file = new File("src/Week3EvaluationTask/tasks.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String[] taskData = reader.nextLine().split(",");
                tasks.add(new Task(taskData[0],taskData[1],taskData[2],taskData[3],taskData[4]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
