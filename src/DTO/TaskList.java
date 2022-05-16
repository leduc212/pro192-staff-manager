/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import util.MyToys;

/**
 *
 * @author HP
 */
public class TaskList {

    public ArrayList<Task> taskList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    //Tim task theo ID
    public int searchTaskByID(int ID) {
        if (taskList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == ID) {
                return i;
            }
        }
        return -1;
    }

    //Tim Task theo ID tra ve object
    public Task searchTaskObjectByID(int ID) {
        if (taskList.isEmpty()) {
            return null;
        }
        for (Task o : taskList) {
            if (o.getId() == ID) {
                return o;
            }
        }
        return null;
    }

    //Input Staff
    public void addNewTask() throws ParseException {
        int id;
        String title;
        String beginDate, endDate;
        int totalHours;
        int pos;

        do {
            id = MyToys.getAnInteger("Input Task's ID: (integer only)", "Invalid ID!", 0);
            pos = searchTaskByID(id);
            if (pos >= 0) {
                System.out.println("The Task ID is already existed! "
                        + "Input another one!");
            }
        } while (pos != -1);

        title = MyToys.getString("Input Task's title: ", "Invalid title!");
        beginDate = MyToys.getDate("Input begin date: (dd/mm/yyyy)", "Invalid date!");
        do {
            endDate = MyToys.getDate("Input end date: (dd/mm/yyyy)", "Invalid date!");
            if (!validEndDate(beginDate, endDate)) {
                System.out.println("Invalid end date!");
            }
        } while (!validEndDate(beginDate, endDate));

        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        Date bDay = formatter1.parse(beginDate);
        Date eDay = formatter1.parse(endDate);
        long diffInMillies = Math.abs(bDay.getTime() - eDay.getTime());
        int diff = Math.toIntExact(TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS));

        totalHours = MyToys.getAnInteger("Input Task's total hours: (integer only)", "Invalid number of hours!", 1 , diff);

        taskList.add(new Task(id, title, beginDate, endDate, totalHours));
        System.out.println("A Task is added successfully.");
    }

    public boolean validEndDate(String bDate, String eDate) {
        String begin[] = bDate.split("/");
        String end[] = eDate.split("/");
        if (Integer.parseInt(end[2]) < Integer.parseInt(begin[2])) {
            return false;
        } else if (Integer.parseInt(end[1]) < Integer.parseInt(begin[1])) {
            return false;
        } else if (Integer.parseInt(end[0]) < Integer.parseInt(begin[0])) {
            return false;
        } else {
            return true;
        }
    }

    //Update Task total hours
    public void updateTask() {
        int id;
        int tmpTotalHours;
        Task x;
        id = MyToys.getAnInteger("Input Task's ID: (integer only)", "Invalid ID!", 0);
        x = searchTaskObjectByID(id);
        System.out.println("===========================================");
        if (x == null) {
            System.out.println("Not Found!!!!");
        } else {
            System.out.println("Here is the Task before updating");
            x.outputTask();
            System.out.println("You are required to input new total hours for this Task: ");
            tmpTotalHours = MyToys.getAnInteger("Input Task's total hours: ", "Invalid number of hours!", 0);
            x.setTotalHours(tmpTotalHours);
            System.out.println("The total hours info is updated successfully!");
        }
    }

    //Remove a Task
    public void removeTask() {
        int id;
        id = MyToys.getAnInteger("Input Task's ID: (integer only)", "Invalid ID!", 0);
        if (searchTaskObjectByID(id) != null) {
            taskList.remove(searchTaskObjectByID(id));
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Task not found");
        }
    }

    public void printAscendingByID() {
        if (taskList.isEmpty()) {
            System.out.println("The Task list is empty. Nothing to print");
            return;
        }

        Comparator ascID = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getId() - o2.getId();
            }
        };
        Collections.sort(taskList, ascID);

        String show = String.format("|%-10s|%-5s|%-20s|%-15s|%-15s|%-11s|",
                "Task", "ID", "Title", "BeginDate", "EndDate", "Total hours");
        System.out.println(show);
        System.out.println("-----------------------------------------------------------------------------------");
        for (Task o : taskList) {
            o.outputTask();
        }
    }
}
