package com.example.task_tracker;

import com.example.task_tracker.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {
    List<Task> tasks = new ArrayList<>(
            Arrays.asList(
                    new Task(1,"Drink Water","Drink 8 litres of water per day","yet to start"),
                    new Task(2,"Assessment","Complete the assessment","completed")
            )
    );

    public List<Task> getMapping(){
        return tasks;
    }

    public Task getTaskById(int id){
        int index=0;
        boolean flag = false;
        for(int i=0;i<tasks.size();i++){
            if(tasks.get(i).getId()==id){
                System.out.println("Task with id "+id+ "is found");
                index = i;
                flag = true;
                break;
            }
        }
        if(flag){
            return tasks.get(index);
        }
        else{
            return null;
        }
    }

    public List<Task> getTaskByStatus(String status) {
        List<Task> foundTasks = new ArrayList<>();
        for(Task task : tasks){
            if(task.getStatus() != null && task.getStatus().trim().equalsIgnoreCase(status.trim())){
                foundTasks.add(task);
            }
        }
        return foundTasks;
    }
    public String createTask(Task newtask){
       tasks.add(newtask);
       return "Task created successfully";
    }

    public String updatedTask(Task updatedTask,int id){
        int index = 0;
        boolean flag = false;
        for(int i =0; i<tasks.size();i++){
            if(tasks.get(i).getId()==id){
                System.out.println("Task with id "+tasks.get(i).getId());
                index = i;
                flag = true;
                break;
            }

        }
        if(flag){
            tasks.set(index,updatedTask);
            return "Task updated successfully";
        }
        else{
            return "Task not found";
        }
    }
    public String deleteTask(int id){
        int index = 0;
        boolean flag = false;
        for(int i =0; i<tasks.size();i++){
            if(tasks.get(i).getId()==id){
                System.out.println("Task with id "+tasks.get(i).getId());
                index = i;
                flag = true;
                break;
            }

        }
        if(flag){
            tasks.remove(index);
            return "Task updated successfully";
        }
        else{
            return "Task not found";
        }
    }
}
