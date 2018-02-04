/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tariq.getitdone;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import java.util.HashMap;
import java.util.Map;


@IgnoreExtraProperties
public class Task {
    
    //Task text: WHAT is the task.
    private String text;
    
    //Time (limit) of task: WHEN is the task
    private String time;
    
    //Represents the metric by which the task time is measured.
    // 0: BY, Task needs to be done at a specific time.
    // 1: IN, Task needs to be done within a time frame relative to time of creation.
    // 2: Default, if not specified, this defaults to a setting from the developer.

    public Task(){

    }
    public Task(String taskText, String taskTime)
    {
        text = taskText;
        time = taskTime;
    }

    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("time", time);
        result.put("task", text);

        return result;
    }




    
    
    
}
