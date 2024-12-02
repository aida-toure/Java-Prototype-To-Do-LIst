package org.example.todolist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import org.example.todolist.Data.DataManager;
import org.example.todolist.Manager.Task;

import java.util.ArrayList;

public class MainController {
    @FXML
    private Button CreateTask;
    @FXML
    private Text Description;


    public void onCreateButtonClick(ActionEvent actionEvent) {
        /** this is your */
        Task newTask = new Task( "Backend - To Do List Application", "", 1);
        Task[] newTaskToArray = new Task[DataManager.maximumTasksSlots];
        newTaskToArray[DataManager.indexFreeSlot] = newTask;

        newTask.StoreData(newTaskToArray);
        newTask.RetrieveData();
    }
}