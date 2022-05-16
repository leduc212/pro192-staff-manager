/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author HP
 */
public class TimeSheet {
    Staff staff;
    Task task;
    int workingHours;
    
    //constructors

    public TimeSheet(Staff staff, Task task, int workingHours) {
        this.staff = staff;
        this.task = task;
        this.workingHours = workingHours;
    }
    
    //getters&setters

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
    
    //methods
    
}
