/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import util.MyToys;

/**
 *
 * @author HP
 */
public class StaffList {

    public ArrayList<Staff> staffList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    //Tim staff theo ID
    public int searchStaffByID(int ID) {
        if (staffList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getStaffID() == ID) {
                return i;
            }
        }
        return -1;
    }

    //Tim staff theo ID tra ve object
    public Staff searchStaffObjectByID(int ID) {
        if (staffList.isEmpty()) {
            return null;
        }
        for (Staff o : staffList) {
            if (o.getStaffID() == ID) {
                return o;
            }
        }
        return null;
    }

    //Input Staff
    public void addNewStaff(ManagerList a) {
        int id;
        String name, gender;
        long basicSalary;
        int managerID;
        int pos;

        do {
            id = MyToys.getAnInteger("Input staff's ID: (integer only)", "Invalid ID!", 0);
            pos = searchStaffByID(id);
            if (pos >= 0) {
                System.out.println("The staff ID is already existed! "
                        + "Input another one!");
            }
        } while (pos != -1);

        managerID = MyToys.getAnInteger("Input the ID of the this Staff's Manager: (integer only)", "Invalid ID!", 0);
        pos = a.searchManagerByID(managerID);
        if (pos >= 0) {
            System.out.println("Added the Manager of this Staff!");
        } else {
            System.out.println("Can't find the Manager with this ID! Please add a new Manager in the Manager Menu first!");
            return;
        }

        name = MyToys.getString("Input staff's name: ", "Invalid name!");
        gender = MyToys.getId("Input staff's gender: (M/F)", "Invalid gender!", "^[M|F|m|f]$");
        basicSalary = MyToys.getAnInteger("Input staff's basic salary: ", "Invalid salary number!", 0);

        staffList.add(new Staff(id, name, gender, basicSalary, managerID));
        System.out.println("A Staff profile is added successfully.");
    }

    //Update staff
    public void updateSalary() {
        int id;
        int tmpBasicSalary;
        Staff x;
        id = MyToys.getAnInteger("Input staff's ID: (integer only)", "Invalid ID!", 0);
        x = searchStaffObjectByID(id);
        System.out.println("===========================================");
        if (x == null) {
            System.out.println("Not Found!!!!");
        } else {
            System.out.println("Here is the Staff before updating");
            x.outputStaff();
            System.out.println("You are required to input a new basic salary: ");
            tmpBasicSalary = MyToys.getAnInteger("Input staff's basic salary: ", "Invalid salary number!", 0);
            x.setBasicSalary(tmpBasicSalary);
            System.out.println("The salary info is updated successfully!");
        }
    }

    //Remove a staff
    public void removeStaff() {
        int id;
        id = MyToys.getAnInteger("Input staff's ID: (integer only)", "Invalid ID!", 0);
        if (searchStaffObjectByID(id) != null) {
            staffList.remove(searchStaffObjectByID(id));
            System.out.println("Staff removed successfully!");
        } else {
            System.out.println("Staff not found");
        }
    }

    public void printAscendingByID() {
        if (staffList.isEmpty()) {
            System.out.println("The Staff list is empty. Nothing to print");
            return;
        }

        Comparator ascID = new Comparator<Staff>() {
            @Override
            public int compare(Staff s1, Staff s2) {
                return (s1.getStaffID()) - (s2.getStaffID());
            }
        };
        Collections.sort(staffList, ascID);

        String show = String.format("|%-10s|%-5s|%-20s|%-6s|%-15s|%-25s|",
                "Position", "ID", "Name", "Gender", "Basic Salary", "ID of this Staff's Manager");
        System.out.println(show);
        System.out.println("-----------------------------------------------------------------------------------------");
        for (Staff o : staffList) {
            o.outputStaff();
        }
    }

    public void updateManager(ManagerList a) {
        int id;
        int managerID;
        Staff x;
        id = MyToys.getAnInteger("Input staff's ID: (integer only)", "Invalid ID!", 0);
        x = searchStaffObjectByID(id);
        System.out.println("===========================================");
        if (x == null) {
            System.out.println("Not Found!!!!");
        } else {
            System.out.println("Here is the Staff before updating");
            x.outputStaff();
            System.out.println("You are required to input a new Manager's ID for this staff (input 0 if this staff haven't got a manager): ");
            managerID = MyToys.getAnInteger("Input manager's ID: ", "Invalid ID!", -1);
            x.setManagerID(managerID);
            System.out.println("The manager info of this staff is updated successfully!");
        }
    }
}
