package teamproject.savannahpyle.calendarapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by savannahpyle on 3/21/18.
 *
 * Task List is a container for {@link Task} objects. This container
 * is basically a to-do list.
 *
 * @author Paul Land and Savannah Pyle
 */
public class ToDoList {

    private String listName;
    private List<Task> tasks;

    /**
     * Default constructor with no arguments for Firebase use.
     */
    public ToDoList() {
        // Purposely blank for use with Firebase Database
    }

    /**
     * Non-default constructor that takes a name and the list of tasks
     *
     * @param listName Name of the list
     * @param task A list of tasks to add to this list
     */
    public ToDoList(String listName, List<Task> task) {
        this.listName = listName;

        if (task != null)
            tasks = task;
        else
            tasks = new ArrayList<>();
    }

    /**
     * Another non-default constructor that takes only the name of the list
     *
     * @param listName The name of the new list
     */
    public ToDoList(String listName) {
        this.listName = listName;
        tasks = new ArrayList<>();
    }

    /**
     * Adds a new task to this to-do list.
     *
     * @param Description Description of the new task being added
     */
    public void addTask(String Description) {
        Task task = new Task(this, Description);
        tasks.add(task);
    }

    /**
     * Adds a new task to this to-do list.
     *
     * @param Description Description of the new task being added
     * @param dueDate the date that the task is due
     */
    public void addTask(String Description, GregorianCalendar dueDate) {
        Task task = new Task(this, Description);
        task.setDueDate(dueDate);
        tasks.add(task);
    }

    /**
     * Removes a task from the list
     *
     * @param task The task to be removed
     */
    public void removeTask(Task task){
        // Remove the task if it exists
        if(tasks.contains(task)) {
            tasks.remove(task);
        }
    }

    /**
     *
     * @param taskName Name of the task to return
     * @return A task
     */
    public Task getTask(String taskName) {
        for (Task t : tasks) {
            if (taskName.equals(t.getDescription())) {
                return t;
            }
        }
        return new Task(this, taskName);
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
    public List<Task> getTasks() {
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
    public void setTasks(List<Task> task) {
        this.tasks = task;
    }
}
