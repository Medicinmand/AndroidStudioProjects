package mwkn.ucn.dk.todolist;

/**
 * Created by martin on 23-02-2017.
 */

public class ToDoTask {
    private long id;
    private String task;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return task;
    }
}
