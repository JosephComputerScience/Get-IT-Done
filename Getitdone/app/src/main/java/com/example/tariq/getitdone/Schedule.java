package com.example.tariq.getitdone;

/**
 * Created by Tariq on 2/3/2018.
 */

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Schedule {

    //List of tasks for this schedule
    private List<Task> taskList;
    private String file;

    //Default constructor, simply initializes the task list as empty
    //and with 10 slots to start.
    public Schedule()
    {
        taskList = new ArrayList(10);
        file = "today.txt";
    }

    //Constructor which creates the task list by reading the given file
    //and parsing the data into tasks.
    public Schedule(String fileName)
    {
        file = fileName;    //Storing file path for saving the list in the future.

        String line;        //Holds each line as we read the file.
        String taskText;    //Holds the task text from the lines in the file.
        String timeText;    //Holds the time text from lines in the file.
        LocalTime time;     //Holds LocalTime object
        int taskType;       //Holds task type int.

        int firstIndex;     //Tracking indices while parsing input.
        int lastIndex;

        taskList = new ArrayList<Task>(0);

        try {
            FileReader fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);

            //For each line in the given file.
            while((line = br.readLine()) != null)
            {
                //Task text string
                firstIndex = 1;
                lastIndex = line.lastIndexOf('"');
                taskText = line.substring(firstIndex, lastIndex);

                //LocalTime object
                firstIndex = lastIndex+3;
                lastIndex = line.lastIndexOf(')');
                timeText = line.substring(firstIndex,lastIndex);
                time = LocalTime.parse(timeText);

                //Task type int
                taskType = Integer.parseInt(line.substring(line.length()-1));

                //Create the task given the information we just parsed.
                Task t = new Task(taskText,time,taskType);

                taskList.add(t);
            }

            br.close();
        }
        catch (FileNotFoundException ex){
            //CHANGE THIS FOR ANDROID APP
            System.out.println("Could not find file " + file);
        }
        catch (IOException ex)
        {
            //CHANGE THIS FOR ANDROID APP
            System.out.println("Error reading file " + file);
        }
    }

    //Assuming the task object is created before reaching this method.
    //When a task is added to the schedule, the tasks are sorted by end time.
    public void addTask(Task task)
    {
        //System.out.println("Begin add task.");

        //Trivial case, list is empty.
        if(taskList.isEmpty())
            taskList.add(task);
        else {
            int index = 0;
            boolean insert = false;

            //Insert task by order of time.
            while(!insert && index < taskList.size())
            {
                //System.out.println("Inside while loop.");

                if(task.getTime().compareTo(taskList.get(index).getTime()) <= 0)
                {
                    taskList.add(index, task);
                    insert = true;
                }

                index++;
            }

            if(!insert)
                taskList.add(task);
        }
        saveToFile();

        // System.out.println("End add task.");
    }

    //Saving task list to file.
    public void saveToFile()
    {
        //System.out.println("Begin save to file.");

        try {
            FileWriter fw = new FileWriter(file);

            BufferedWriter bw = new BufferedWriter(fw);

            for(int i = 0; i < taskList.size(); i++)
            {
                bw.write('"');
                bw.write(taskList.get(i).getText());
                bw.write('"');
                bw.write(" (");
                bw.write(taskList.get(i).getTime().toString());
                bw.write(") " + taskList.get(i).getType());
                bw.newLine();
            }

            bw.close();
        }
        catch (IOException ex)
        {
            //CHANGE THIS FOR ANDROID APP
            System.out.println("Error reading file " + file);
        }

        //System.out.println("End save to file.");
    }


    //Assuming the index of the task to be removed is passed from the front-end.
    public void removeTask(int index)
    {
        taskList.remove(index);
        saveToFile();
    }

    //Updates the task data at given index with provided arguments, this method
    //allows for any combination of fields to be updated.
    public void updateTask(int index, String updateText, LocalTime updateTime, int updateType)
    {
        if(updateText != null)
        {
            taskList.get(index).setText(updateText);
        }

        if(updateTime != null)
        {
            taskList.get(index).setTime(updateTime);
        }

        if(updateType >= 0 && updateType <= 2)
        {
            taskList.get(index).setType(updateType);
        }
    }

    //METHOD CREATED FOR TESTING PURPOSES
    public void printTasks()
    {
        System.out.println("Tasks: " + taskList.size());

        for(int i = 0; i < taskList.size(); i++)
        {
            System.out.println(taskList.get(i).getText() + " " + taskList.get(i).getTime().toString() + " " + taskList.get(i).getType());
        }
    }


}
