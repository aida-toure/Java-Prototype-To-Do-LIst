package org.example.todolist.Manager;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import javafx.scene.chart.PieChart;
import org.example.todolist.Data.DataManager;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Dictionary;
import java.util.List;

public class Task {
    // attributes
    private String title;
    private String description;
    /** This attribute will be set by the user.
     * It indicates if the task has do be done urgently.
     * priority : 1 to 5 (1 being the most import, 5 being the least important) */
    private Integer priority;

    /** This attribute means if the user put all the necessary information before saving the task.
     * If it's not the case an error message will appear
     * require : title
     * not require : description */

    // constructor
    /** Create a task */
    public Task(String title, String description, Integer priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
    }
    //---------------- methods ------------------------
    //---- getters and setters
    public String getTitle() {return title;}
    public String getDescription() {return description;}
    public Integer getPriority() { return priority;}

    public void setTitle(String title) {this.title = title;}
    public void setDescription(String description) {this.description = description;}
    public void setPriority(Integer priority) {this.priority = priority;}

    //---- instance methods
    /** the task submitted will be sent here and stored */
    public void StoreData(Task[] newTask){
        try(Writer writer = new FileWriter(DataManager.tasksJSONPath)){
            new Gson().toJson(newTask, writer);
            System.out.println("Congrats task has been saved successfully !");
        } catch (IOException e) {
            System.out.println("Uh Oh...something went wrong about saving your data");
            System.out.println(e);
        }
    }
    /** the task submitted will be */
    public void RetrieveData(){
        DataManager.setIndexFreeSlot(1);
        try(FileReader reader = new FileReader(DataManager.tasksJSONPath)){
            // Note : type is used to
            Type listType = new TypeToken<List<Task>>(){}.getType();
            List<Task> tasks = new Gson().fromJson(reader, listType);

            // print the tasks
            if (tasks == null){
                System.out.println("Uh, Oh the data container doesn't exist");
            } else if (tasks.isEmpty()) {
                System.out.println("There is no task to achieve");
            }else{
                System.out.println("Here all your tasks : " + tasks);
                for (Task task : tasks) {
                    if (task == null){
                        System.out.println("task empty");
                    }else {
                        DataManager.setIndexFreeSlot(DataManager.getIndexFreeSlot() + 1);
                        System.out.println(task.getDescription());
                    }
                }
                DataManager.setIndexFreeSlot(DataManager.getIndexFreeSlot() + 1);
            }
        }catch (IOException e){
            System.out.println("Uh, Oh something went wrong about retrieving your tasks");
            System.out.println(e);
        }
    }
    public void RemoveATask(){

    }

}
