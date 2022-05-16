/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import util.MyToys;

/**
 *
 * @author HP
 */
public class Task {

    int id;
    String title;
    String beginDate;
    String endDate;
    int totalHours;

    //constructors
    public Task() {
    }

    public Task(int id, String title, String beginDate, String endDate, int totalHours) {
        this.id = id;
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.totalHours = totalHours;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    //methods
    public void inputTask() {
        id = MyToys.getAnInteger("Input Task's ID: (integer only)", "Invalid ID!", 0);
        title = MyToys.getString("Input Task's title: ", "Invalid title!");
        beginDate = MyToys.getDate("Input begin date: (dd/mm/yyyy)", "Invalid date!");
        do {
            endDate = MyToys.getDate("Input end date: (dd/mm/yyyy)", "Invalid date!");
            if (!validEndDate(beginDate, endDate)) {
                System.out.println("Invalid end date!");
            }
        } while (!validEndDate(beginDate, endDate));
        totalHours = MyToys.getAnInteger("Input Task's total hours: (integer only)", "Invalid hours!", 0);
    }

    public void outputTask() {
        String show = String.format("|%-10s|%-5d|%-20s|%-15s|%-15s|%-11d|",
                "Task", getId(), getTitle(), getBeginDate(), getEndDate(), getTotalHours());
        System.out.println(show);
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

}
