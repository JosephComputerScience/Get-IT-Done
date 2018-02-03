/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getitdone;

import java.time.LocalTime;

/**
 *
 * @author Alejandro
 */

public class Task {
    
    //Task text: WHAT is the task.
    private String text;
    
    //Time (limit) of task: WHEN is the task
    private LocalTime time;
    
    //Represents the metric by which the task time is measured.
    // 0: BY, Task needs to be done at a specific time.
    // 1: IN, Task needs to be done within a time frame relative to time of creation.
    // 2: Default, if not specified, this defaults to a setting from the developer.
    private int type;
    
    public Task(String taskText, LocalTime taskTime, int taskType)
    {
        text = taskText;
        time = taskTime;
        type = taskType;
    }

    public String getText() {
        return text;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getType() {
        return type;
    }
    
    public void setText(String text) {
        this.text = text;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
    
    
}
