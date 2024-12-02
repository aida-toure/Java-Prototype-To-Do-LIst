package org.example.todolist.Data;

import java.io.File;

public class DataManager {
    // ------ attributes
    /** the maximum slot is 30 by default, but you are free to modify it.
     * It will adjust automatically */
    public static final Integer maximumTasksSlots = 30;
    /** indexFreeSlot will be used as an indicator and also to return the index(+1) free slot
     * so that the task will be placed just below the latest taken task*/
    public static Integer indexFreeSlot = 0;
    /** where all your tasks lies...
     * It saved your tasks even if you decide to close the window or restart*/
    public static final String tasksJSONPath = "src/main/resources/org/example/todolist/json/tasks.json";

    // ------ methods
    // ---- getters and setters
    public static Integer getIndexFreeSlot() {return indexFreeSlot;}
    public static void setIndexFreeSlot(Integer indexFreeSlot) {DataManager.indexFreeSlot = indexFreeSlot;}
}
