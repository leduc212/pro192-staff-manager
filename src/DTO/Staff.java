/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import util.MyToys;

/**
 *
 * @author HP
 */
public class Staff {

    int staffID;
    String name;
    String gender;
    long basicSalary;
    int managerID;
    public ArrayList<Task> staffTask = new ArrayList<Task>();
    //constructors

    public Staff() {
    }

    public Staff(int staffID, String name, String gender, long basicSalary) {
        this.staffID = staffID;
        this.name = name;
        this.gender = gender;
        this.basicSalary = basicSalary;
    }

    public Staff(int staffID, String name, String gender, long basicSalary, int managerID) {
        this.staffID = staffID;
        this.name = name;
        this.gender = gender;
        this.basicSalary = basicSalary;
        this.managerID = managerID;
    }

    //getters&setters
    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(long basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int ManagerID) {
        this.managerID = ManagerID;
    }

    //methods
    public void inputStaff() {
        staffID = MyToys.getAnInteger("Input staff's ID: (integer only)", "Invalid ID!", 0);
        name = MyToys.getString("Input staff's name: ", "Invalid name!");
        gender = MyToys.getId("Input staff's gender: (M/F)", "Invalid gender!", "^[M|F|m|f]$");
        basicSalary = MyToys.getAnInteger("Input staff's basic salary: ", "Invalid salary number!", 0);
        managerID = MyToys.getAnInteger("Input the ID of the this Staff's Manager: (integer only)", "Invalid ID!", 0);
    }

    public void outputStaff() {
        String show = String.format("|%-10s|%-5d|%-20s|%-6s|%-15d|%-26d|",
                "Staff", getStaffID(), getName(), getGender(), getBasicSalary(), getManagerID());
        System.out.println(show);
    }

    public void outputStaffSearch() {
        String show = String.format("|%-10s|%-5d|%-20s|%-6s|%-15d|",
                "Staff", getStaffID(), getName(), getGender(), getBasicSalary());
        System.out.println(show);
    }
}
