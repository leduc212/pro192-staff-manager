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
public class Manager extends Staff {

    long bonusSalary;

    //construtors
    public Manager() {
    }

    public Manager(long bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public Manager(long bonusSalary, int staffID, String name, String gender, long basicSalary) {
        super(staffID, name, gender, basicSalary);
        this.bonusSalary = bonusSalary;
    }

    //getters&setters
    public long getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(long bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    //methods
    @Override
    public void outputStaff() {
        String show = String.format("|%-10s|%-5d|%-20s|%-6s|%-15d|%-15d|",
                "Manager", getStaffID(), getName(), getGender(), getBasicSalary(), getBonusSalary());
        System.out.println(show);
    }

    @Override
    public void inputStaff() {
        super.inputStaff();
        bonusSalary = MyToys.getAnInteger("Input manager's bonus salary: ", "Invalid salary number!", 0);
    }

}
