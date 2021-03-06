package teamproject.savannahpyle.calendarapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by savannahpyle on 3/21/18.
 *
 * ToDoList was a container for {@link Task} objects. This container
 * is basically a to-do list.
 *
 * Now this class just has a list of Strings to hold the various tasks
 * that are to be done.
 *
 * @author Paul Land and Savannah Pyle
 */
public class ToDoList {

    private static final String TAG = "ToDoList";

    private String firstTask = "Tap the '+' icon to add a task";

    private String listName;
    private String dueDate; // mm/dd/yyyy
    private List<String> tasks;
    private List<Boolean> isComplete;


    /**
     * Default constructor with no arguments for Firebase use.
     */
    public ToDoList() {

        listName = "";
        dueDate = "";

        tasks = new ArrayList<>();
        isComplete = new ArrayList<>();

        // There must be something in these vars for it to work with firebase
        tasks.add(firstTask);
        isComplete.add(true);
    }

    /**
     * Non-default constructor that takes a name and the list of tasks
     *
     * @param listName Name of the list
     * @param dueDate String due date in MM/DD/YYYY format
     * @param tasks A list of tasks to add to this list
     * @param isComplete list of booleans of whether task is complete
     */
    public ToDoList(String listName, String dueDate, List<String> tasks, List<Boolean> isComplete) {
        if (listName != null)
            this.listName = listName;
        else
            this.listName = "";

        if (dueDate != null)
            this.dueDate = dueDate;
        else
            this.dueDate = "";

        if (tasks != null)
            this.tasks = tasks;
        else {
            this.tasks = new ArrayList<>();
            this.tasks.add(firstTask); // For firebase
        }

        if (isComplete != null)
            this.isComplete = isComplete;
        else {
            this.isComplete = new ArrayList<>();
            this.isComplete.add(true); // For firebase
        }
    }

    /**
     * Another non-default constructor that takes only the name of the list
     *
     * @param listName The name of the new list
     */
    public ToDoList(String listName) {
        this.listName = listName;
        this.dueDate = "";
        tasks = new ArrayList<>();
        isComplete = new ArrayList<>();

        // For firebase
        tasks.add(firstTask);
        isComplete.add(true);
    }

    /**
     * Non-default constructor to set list name and due date
     * @param listName name of the list
     * @param dueDate string date in MM/DD/YYYY format
     */
    public ToDoList(String listName, String dueDate) {
        this.listName = listName;
        this.dueDate = dueDate;
        tasks = new ArrayList<>();
        isComplete = new ArrayList<>();

        // For firebase
        tasks.add(firstTask);
        isComplete.add(true);
    }

    /**
     * Adds a new task to this to-do list.
     *
     * @param Description Description of the new task being added
     */
    public void addTask(String Description) {

        if (Description == null)
            return;

        // An initial to-do list sets the value of the first task to "" and
        // the first isComplete to "true" so that it will be stored in firebase.
        // We must clear those initial values.
        if (tasks.size() == 1 && tasks.contains(firstTask)){
            tasks.clear();
            isComplete.clear();
        }

        // Add description and set completion to false
        tasks.add(Description);
        isComplete.add(false);
    }

    /**
     * Removes a task from the list
     *
     * @param task The task to be removed
     */
    public void removeTask(String task){
        // Remove the task if it exists
        for (int i = 0; i < tasks.size(); i++) {
            if (task.equals(tasks.get(i))) {
                tasks.remove(i);
                isComplete.remove(i);

                // For purpose of firebase storage
                if (tasks.isEmpty()) {
                    tasks.add(firstTask);
                    isComplete.add(true);
                }
                break;
            }
        }
    }

    /**
     * Gets the name of this to-do list
     *
     * @return The name of the list
     */
    public String getListName() {
        return listName;
    }

    /**
     * Gets the list of all task on this to-do list
     *
     * @return The list of tasks for this to-do list
     */
    public List<String> getTasks() {
        return tasks;
    }

    /**
     * Change/set the name of this to-do list
     *
     * @param listName Name of the to-do list
     */
    public void setListName(String listName) {
        this.listName = listName;
    }

    /**
     * Set the list of tasks. This should usually only be used for
     * Firebase Database updates.
     *
     * @param task The list of tasks to associate with this to-do list
     */
    public void setTasks(List<String> task) {
        this.tasks = task;
    }

    public List<Boolean> getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(List<Boolean> isComplete) {
        this.isComplete = isComplete;
    }

    public void setTaskComplete(String task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (task.equals(tasks.get(i))) {
                Boolean b = !isComplete.get(i);
                isComplete.set(i, b);
                i = tasks.size();
            }
        }
    }

    /**
     * Removes all of the completed tasks from the to-do list
     */
    public void removeCompleted() {
        // Loop through and remove completed tasks
        for (int i = 0; i < isComplete.size(); i++) {
            if (isComplete.get(i)) {
                isComplete.remove(i);
                tasks.remove(i);
                i--; // Since we've removed items we need the index to go back one
            }
        }
    }

    /**
     * Getter for string due date
     * @return string due date
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets the string of due dates
     * @param dueDate list of string due dates
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
