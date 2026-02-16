package Week3EvaluationTask;

import java.util.ArrayList;
import java.util.Collections;

public class Tester {
    ArrayList<Task> tasks = Task.getTasks();

    void taskList(){
        //TODO
        System.out.println("this future will come Soon!!");
        Collections.sort(tasks,(b1, b2)-> b1.status.compareTo(b2.status));
        tasks.forEach((task)->System.out.println(task.taskId+"\t"+task.taskName+"\t"+task.taskDescription+"\t"+task.status+"\t"+task.DoneBy));
    }


    void sendReview(){
        //TODO
        System.out.println("this future will come Soon!!");
    }

    void markCompleted(){
        //TODO
        System.out.println("this future will come Soon!!");
    }

}
