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
public class ManagerList {

    public ArrayList<Manager> managerList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    //Tim manager theo ID
    public int searchManagerByID(int ID) {
        if (managerList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < managerList.size(); i++) {
            if (managerList.get(i).getStaffID() == ID) {
                return i;
            }
        }
        return -1;
    }

    //Tim manager theo ID tra ve object
    public Manager searchManagerObjectByID(int ID) {
        if (managerList.isEmpty()) {
            return null;
        }
        for (Manager o : managerList) {
            if (o.getStaffID() == ID) {
                return o;
            }
        }
        return null;
    }

    //Input Manager
    public void addNewManager() {
        int id;
        String name, gender;
        long basicSalary, bonusSalary;
        int pos;

        do {
            id = MyToys.getAnInteger("Input manager's ID: (integer only)", "Invalid ID!", 0);
            pos = searchManagerByID(id);
            if (pos >= 0) {
                System.out.println("The manager ID is already existed! "
                        + "Input another one!");
            }
        } while (pos != -1);

        name = MyToys.getString("Input manager's name: ", "Invalid name!");
        gender = MyToys.getId("Input manager's gender: (M/F)", "Invalid gender!", "^[M|F|m|f]$");
        basicSalary = MyToys.getAnInteger("Input manager's basic salary: ", "Invalid salary number!", 0);
        bonusSalary = MyToys.getAnInteger("Input manager's bonus salary: ", "Invalid salary number!", 0);
        managerList.add(new Manager(bonusSalary, id, name, gender, basicSalary));
        System.out.println("A Manager profile is added successfully.");
    }

    //Update manager
    public void updateSalary() {
        int id;
        int tmpBasicSalary;
        int tmpBonusSalary;
        Manager x;
        id = MyToys.getAnInteger("Input manager's ID: (integer only)", "Invalid ID!", 0);
        x = searchManagerObjectByID(id);
        System.out.println("===========================================");
        if (x == null) {
            System.out.println("Not Found!!!!");
        } else {
            System.out.println("Here is the Manager before updating");
            x.outputStaff();
            System.out.println("You are required to input a new basic salary: ");
            tmpBasicSalary = MyToys.getAnInteger("Input manager's basic salary: ", "Invalid salary number!", 0);
            x.setBasicSalary(tmpBasicSalary);
            System.out.println("You are required to input a new bonus salary: ");
            tmpBonusSalary = MyToys.getAnInteger("Input staff's bonus salary: ", "Invalid salary number!", 0);
            x.setBonusSalary(tmpBonusSalary);
            System.out.println("The salary info is updated successfully!");
        }
    }

    //Remove a manager
    public void removeManager() {
        int id;
        id = MyToys.getAnInteger("Input manager's ID: (integer only)", "Invalid ID!", 0);
        if (searchManagerObjectByID(id) != null) {
            managerList.remove(searchManagerObjectByID(id));
            System.out.println("Manager removed successfully!");
        } else {
            System.out.println("Manager not found");
        }
    }

    public void printAscendingByID() {
        if (managerList.isEmpty()) {
            System.out.println("The Manager list is empty. Nothing to print");
            return;
        }

        Comparator ascID = new Comparator<Manager>() {
            @Override
            public int compare(Manager o1, Manager o2) {
                return (o1.getStaffID() - o2.getStaffID());
            }
        };
        Collections.sort(managerList, ascID);

        String show = String.format("|%-10s|%-5s|%-20s|%-6s|%-15s|%-15s|",
                "Position", "ID", "Name", "Gender", "Basic Salary", "Bonus Salary");
        System.out.println(show);
        System.out.println("------------------------------------------------------------------------------");
        for (Staff o : managerList) {
            o.outputStaff();
        }
    }
}
