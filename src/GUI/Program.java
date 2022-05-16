/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Manager;
import DTO.ManagerList;
import DTO.Staff;
import DTO.StaffList;
import DTO.Task;
import DTO.TaskList;
import DTO.TimeSheet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import util.MyToys;

/**
 *
 * @author HP
 */
public class Program {

    public static void main(String[] args) throws ParseException {

        StaffList a = new StaffList();
        ManagerList b = new ManagerList();
        TaskList c = new TaskList();
        ArrayList<TimeSheet> timeSheet = new ArrayList<>();

        a.staffList = initStaff();
        b.managerList = initManager();
        c.taskList = initTask();
        timeSheet = initTimeSheet();

        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            menu();
            choice = MyToys.getAnInteger("", "Input a valid option, please!", 1, 5);

            switch (choice) {
                case 1:
                    boolean flag = true;
                    do {
                        menu1();
                        int choice1 = MyToys.getAnInteger("", "Input a valid option, please!", 1, 7);
                        switch (choice1) {
                            case 1:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Add a Staff!");
                                a.addNewStaff(b);
                                break;
                            case 2:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Update salary information of a Staff");
                                a.updateSalary();
                                break;
                            case 3:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Update the Manager of a Staff");
                                a.updateManager(b);
                                break;
                            case 4:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Remove a Staff!");
                                a.removeStaff();
                                break;
                            case 5:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Show the list of Staff!");
                                a.printAscendingByID();
                                break;
                            case 6:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Search a Staff with ID and show the Tasks they are doing");
                                int id;
                                id = MyToys.getAnInteger("Input staff's ID: (integer only)", "Invalid ID!", 0);
                                if (a.searchStaffObjectByID(id) != null) {
                                    String show = String.format("|%-10s|%-5s|%-20s|%-6s|%-15s|%-20s|",
                                            "Position", "ID", "Name", "Gender", "Basic Salary", "ID of this Staff's Manager");
                                    System.out.println(show);
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    a.searchStaffObjectByID(id).outputStaff();
                                    System.out.println("");
                                    for (TimeSheet log : timeSheet) {
                                        int staffID = log.getStaff().getStaffID();
                                        if (staffID == id) {
                                            String show1 = String.format("|%-10s|%-5s|%-20s|%-15s|%-15s|%-11s|",
                                                    "Task", "ID", "Title", "BeginDate", "EndDate", "Total hours");
                                            System.out.println(show1);
                                            System.out.println("-----------------------------------------------------------------------------------");
                                            break;
                                        }
                                    }
                                    for (TimeSheet log : timeSheet) {
                                        int staffID = log.getStaff().getStaffID();
                                        Task task = log.getTask();

                                        if (staffID == id) {
                                            task.outputTask();
                                        }
                                    }
                                } else {
                                    System.out.println("Staff not found");
                                }
                                break;
                            case 7:
                                System.out.println("Return to main menu!");
                                flag = false;
                                break;
                        }
                    } while (flag);
                    break;
                case 2:
                    flag = true;
                    do {
                        menu2();
                        int choice2 = MyToys.getAnInteger("", "Input a valid option, please!", 1, 6);
                        switch (choice2) {
                            case 1:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Add a Manager!");
                                b.addNewManager();
                                break;
                            case 2:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Update salary information of a Manager");
                                b.updateSalary();
                                break;
                            case 3:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Remove a Manager!");
                                b.removeManager();
                                break;
                            case 4:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Show the list of Manager!");
                                b.printAscendingByID();
                                break;
                            case 5:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Search a Manager with ID and show their staff");
                                int id;
                                id = MyToys.getAnInteger("Input Manager's ID: (integer only)", "Invalid ID!", 0);
                                if (b.searchManagerObjectByID(id) != null) {
                                    String show = String.format("|%-10s|%-5s|%-20s|%-6s|%-15s|%-15s|",
                                            "Position", "ID", "Name", "Gender", "Basic Salary", "Bonus Salary");
                                    System.out.println(show);
                                    System.out.println("------------------------------------------------------------------------------");
                                    b.searchManagerObjectByID(id).outputStaff();
                                } else {
                                    System.out.println("Manager not found");
                                }
                                for (Staff o : a.staffList) {
                                    if (o.getManagerID() == id) {
                                        o.outputStaffSearch();
                                    }
                                }
                                break;
                            case 6:
                                System.out.println("Return to main menu!");
                                flag = false;
                                break;
                        }
                    } while (flag);
                    break;
                case 3:
                    flag = true;
                    do {
                        menu3();
                        int choice3 = MyToys.getAnInteger("", "Input a valid option, please!", 1, 6);
                        switch (choice3) {
                            case 1:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Add a new Task!");
                                c.addNewTask();
                                break;
                            case 2:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Update the total hours of a Task");
                                c.updateTask();
                                break;
                            case 3:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Remove a Task!");
                                c.removeTask();
                                break;
                            case 4:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Show the list of Tasks!");
                                c.printAscendingByID();
                                break;
                            case 5:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Search a Task with ID and show which staff is doing this Task");
                                int id;
                                id = MyToys.getAnInteger("Input Task's ID: (integer only)", "Invalid ID!", 0);
                                if (c.searchTaskObjectByID(id) != null) {
                                    String show = String.format("|%-10s|%-5s|%-20s|%-15s|%-15s|%-11s|",
                                            "Task", "ID", "Title", "BeginDate", "EndDate", "Total hours");
                                    System.out.println(show);
                                    System.out.println("-----------------------------------------------------------------------------------");
                                    c.searchTaskObjectByID(id).outputTask();
                                    System.out.println("");
                                    for (TimeSheet log : timeSheet) {
                                        int taskID = log.getTask().getId();
                                        if (taskID == id) {
                                            String show1 = String.format("|%-10s|%-5s|%-20s|%-6s|%-15s|%-20s|",
                                                    "Position", "ID", "Name", "Gender", "Basic Salary", "ID of this Staff's Manager");
                                            System.out.println(show1);
                                            System.out.println("-----------------------------------------------------------------------------------------");
                                            break;
                                        }
                                    }
                                    for (TimeSheet log : timeSheet) {
                                        int taskID = log.getTask().getId();
                                        Staff staff = log.getStaff();

                                        if (taskID == id) {
                                            staff.outputStaff();
                                        }
                                    }
                                } else {
                                    System.out.println("Task not found");
                                }
                                break;
                            case 6:
                                System.out.println("Return to main menu!");
                                flag = false;
                                break;
                        }
                    } while (flag);
                    break;
                case 4:
                    flag = true;
                    do {
                        menu4();
                        int choice3 = MyToys.getAnInteger("", "Input a valid option, please!", 1, 4);
                        switch (choice3) {
                            case 1:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Add a new working hours log to the time sheet!");
                                System.out.println("Input a staff and a task!");
                                //Tim staff
                                int staffID,
                                 taskID;
                                staffID = MyToys.getAnInteger("Input Staff's ID: (integer only)", "Invalid ID!", 0);
                                if (a.searchStaffObjectByID(staffID) != null) {
                                    String show = String.format("|%-10s|%-5s|%-20s|%-6s|%-15s|%-20s|",
                                            "Position", "ID", "Name", "Gender", "Basic Salary", "ID of this Staff's Manager");
                                    System.out.println(show);
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    a.searchStaffObjectByID(staffID).outputStaff();
                                } else {
                                    System.out.println("Staff not found");
                                    break;
                                }
                                //Tim task
                                taskID = MyToys.getAnInteger("Input Task's ID: (integer only)", "Invalid ID!", 0);
                                if (c.searchTaskObjectByID(taskID) != null) {
                                    String show = String.format("|%-10s|%-5s|%-20s|%-15s|%-15s|%-11s|",
                                            "Task", "ID", "Title", "BeginDate", "EndDate", "Total hours");
                                    System.out.println(show);
                                    System.out.println("-----------------------------------------------------------------------------------");
                                    c.searchTaskObjectByID(taskID).outputTask();
                                } else {
                                    System.out.println("Task not found");
                                    break;
                                }
                                //Dien working hours
                                int workingHours = MyToys.getAnInteger("Input the working hour of the staff on this task!", "Invalid number of hours! "
                                        + "(working hours must be fewer than the total hours of a task", 1, c.searchTaskObjectByID(taskID).getTotalHours()); //Add vao 1 list
                                timeSheet.add(new TimeSheet(a.searchStaffObjectByID(staffID), c.searchTaskObjectByID(taskID), workingHours));
                                System.out.println("Added a new log successfully!");
                                break;
                            case 2:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Show the time sheet!");
                                int n = 0;
                                if (timeSheet.isEmpty()) {
                                    System.out.println("The time sheet is empty. Nothing to print");
                                    break;
                                }
                                String show = String.format("|%-8s|%-8s|%-20s|%-8s|%-20s|%-15s|",
                                        "Log", "Staff ID", "Staff name", "Task ID", "Task title", "Working hours");
                                System.out.println(show);
                                System.out.println("--------------------------------------------------------------------------------------");
                                for (TimeSheet log : timeSheet) {
                                    n += 1;
                                    int tmpStaffID = log.getStaff().getStaffID();
                                    String tmpStaffName = log.getStaff().getName();
                                    int tmpTaskID = log.getTask().getId();
                                    String tmpTaskTitle = log.getTask().getTitle();
                                    int tmpTotalHours = log.getTask().getTotalHours();

                                    show = String.format("|%-8d|%-8d|%-20s|%-8d|%-20s|%-15d|",
                                            n, tmpStaffID, tmpStaffName, tmpTaskID, tmpTaskTitle, tmpTotalHours);
                                    System.out.println(show);
                                }
                                break;
                            case 3:
                                System.out.println("===============================================================");
                                System.out.println("You have chosen to: Remove a log!");
                                if (timeSheet.isEmpty()) {
                                    System.out.println("The time sheet is empty. Nothing to remove!");
                                    break;
                                }
                                System.out.println("Input a staff's ID and choose which task you want to remove!");
                                int sID;
                                Staff staffObj = null;
                                sID = MyToys.getAnInteger("Input Staff's ID: (integer only)", "Invalid ID!", 0);

                                for (int i = 0; i < timeSheet.size(); i++) {
                                    if (timeSheet.get(i).getStaff().getStaffID() == sID) {
                                        staffObj = timeSheet.get(i).getStaff();
                                        break;
                                    }
                                }
                                if (staffObj != null) {
                                    String show1 = String.format("|%-10s|%-5s|%-20s|%-6s|%-15s|%-20s|",
                                            "Position", "ID", "Name", "Gender", "Basic Salary", "ID of this Staff's Manager");
                                    System.out.println(show1);
                                    System.out.println("-----------------------------------------------------------------------------------------");
                                    a.searchStaffObjectByID(sID).outputStaff();
                                    System.out.println("This staff is working on these tasks:");
                                    for (TimeSheet log : timeSheet) {
                                        staffID = log.getStaff().getStaffID();
                                        if (staffID == sID) {
                                            String show2 = String.format("|%-10s|%-5s|%-20s|%-15s|%-15s|%-11s|",
                                                    "Task", "ID", "Title", "BeginDate", "EndDate", "Total hours");
                                            System.out.println(show2);
                                            System.out.println("-----------------------------------------------------------------------------------");
                                            break;
                                        }
                                    }
                                    for (TimeSheet log : timeSheet) {
                                        staffID = log.getStaff().getStaffID();
                                        Task task = log.getTask();

                                        if (staffID == sID) {
                                            task.outputTask();
                                        }
                                    }

                                    int tID;
                                    TimeSheet ts = null;
                                    tID = MyToys.getAnInteger("Input ID of the task that you want to remove from this staff: (integer only)", "Invalid ID!", 0);
                                    for (TimeSheet timeSheet1 : timeSheet) {
                                        if ((timeSheet1.getStaff().getStaffID() == sID) && (timeSheet1.getTask().getId() == tID)) {
                                            ts = timeSheet1;
                                        }
                                    }
                                    if (ts != null) {
                                        timeSheet.remove(ts);
                                        System.out.println("Remove successfully!");
                                    } else {
                                        System.out.println("There is no task with this ID that the staff above is working on!");
                                    }

                                } else {
                                    System.out.println("There is no staff with this ID in the time sheet!");
                                }

                                break;
                            case 4:
                                System.out.println("Return to main menu!");
                                flag = false;
                                break;
                        }
                    } while (flag);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;
            }
        } while (true);
    }

    static void menu() {
        System.out.println("===========================MainMenu============================");
        System.out.println("**       1. Staff management                                 **");
        System.out.println("**       2. Manager management                               **");
        System.out.println("**       3. Task management                                  **");
        System.out.println("**       4. Time sheet management                            **");
        System.out.println("**       5. Exit                                             **");
        System.out.println("===============================================================");
        System.out.println(">Input your choice: ");
    }

    static void menu1() {
        System.out.println("========================StaffManagement========================");
        System.out.println("**1. Add a new Staff                                         **");
        System.out.println("**2. Update the salary of a Staff                            **");
        System.out.println("**3. Update the Manager of a Staff                           **");
        System.out.println("**4. Remove a Staff                                          **");
        System.out.println("**5. Show the list of Staff                                  **");
        System.out.println("**6. Search a Staff with ID and show the Tasks they are doing**");
        System.out.println("**7. Return to main menu                                     **");
        System.out.println("===============================================================");
        System.out.println(">Input your choice: ");
    }

    static void menu2() {
        System.out.println("=======================ManagerManagement=======================");
        System.out.println("**  1. Add a new Manager                                     **");
        System.out.println("**  2. Update the salary of a Manager                        **");
        System.out.println("**  3. Remove a Manager                                      **");
        System.out.println("**  4. Show the list of Manager                              **");
        System.out.println("**  5. Search a Manager with ID and show their staff         **");
        System.out.println("**  6. Return to main menu                                   **");
        System.out.println("===============================================================");
        System.out.println(">Input your choice: ");
    }

    static void menu3() {
        System.out.println("============================TaskManagement===========================");
        System.out.println("**1. Add a new Task                                                **");
        System.out.println("**2. Update the total hours of a Task                              **");
        System.out.println("**3. Remove a Task                                                 **");
        System.out.println("**4. Show the list of Task                                         **");
        System.out.println("**5. Search a Task with ID and show which Staff is doing this task **");
        System.out.println("**6. Return to main menu                                           **");
        System.out.println("=====================================================================");
        System.out.println(">Input your choice: ");
    }

    static void menu4() {
        System.out.println("=======================TimeSheetManagement=======================");
        System.out.println("**1. Assign a staff to do a task (add a new working hours log) **");
        System.out.println("**2. Show all of the working hours log                         **");
        System.out.println("**3. Remove a log                                              **");
        System.out.println("**4. Return to main menu                                       **");
        System.out.println("=================================================================");
        System.out.println(">Input your choice: ");
    }

    static ArrayList<Staff> initStaff() {
        ArrayList<Staff> ds = new ArrayList<>();
        ds.add(new Staff(1, "Le Duc", "M", 2000000, 1));
        ds.add(new Staff(2, "Nguyen Hoai Nam", "M", 1000000, 2));
        ds.add(new Staff(3, "Tran Thuong", "F", 1500000, 1));
        ds.add(new Staff(5, "Nguyen Kiem", "M", 3000000, 2));
        ds.add(new Staff(10, "Mike Tyson", "M", 2500000, 5));
        ds.add(new Staff(20, "Mayweather Floyd", "F", 1400000, 3));
        return ds;
    }

    static ArrayList<Manager> initManager() {
        ArrayList<Manager> ds = new ArrayList<>();
        ds.add(new Manager(150000, 1, "Pham Nhat Vuong", "M", 2000000));
        ds.add(new Manager(200000, 2, "Elon Musk", "M", 1000000));
        ds.add(new Manager(250000, 3, "Jack Ma", "F", 1500000));
        ds.add(new Manager(450000, 4, "Jeff Bezos", "M", 3000000));
        ds.add(new Manager(600000, 5, "Warren Buffet", "M", 2500000));
        ds.add(new Manager(800000, 10, "Ly Duc", "F", 1400000));
        return ds;
    }

    static ArrayList<Task> initTask() {
        ArrayList<Task> ds = new ArrayList<>();
        ds.add(new Task(1, "Sweep the floor", "25/12/2020", "3/1/2021", 20));
        ds.add(new Task(2, "Mop the floor", "23/8/2020", "25/9/2020", 14));
        ds.add(new Task(3, "Clean the glass", "3/8/2019", "3/1/2020", 6));
        ds.add(new Task(4, "Wash the dishes", "2/7/2021", "5/7/2021", 38));
        ds.add(new Task(5, "Take out the trash", "6/9/2021", "7/9/2021", 15));
        ds.add(new Task(10, "Cook meals", "17/8/2020", "3/1/2021", 31));
        ds.add(new Task(20, "Do the laundry", "10/6/2021", "12/7/2021", 26));
        return ds;
    }

    static ArrayList<TimeSheet> initTimeSheet() {
        ArrayList<TimeSheet> timeSheet = new ArrayList<>();

        StaffList a = new StaffList();
        a.staffList = initStaff();

        TaskList c = new TaskList();
        c.taskList = initTask();

        timeSheet.add(new TimeSheet(a.searchStaffObjectByID(1), c.searchTaskObjectByID(1), 10));
        timeSheet.add(new TimeSheet(a.searchStaffObjectByID(1), c.searchTaskObjectByID(2), 6));
        timeSheet.add(new TimeSheet(a.searchStaffObjectByID(2), c.searchTaskObjectByID(1), 12));
        timeSheet.add(new TimeSheet(a.searchStaffObjectByID(3), c.searchTaskObjectByID(3), 4));
        timeSheet.add(new TimeSheet(a.searchStaffObjectByID(5), c.searchTaskObjectByID(4), 20));
        timeSheet.add(new TimeSheet(a.searchStaffObjectByID(10), c.searchTaskObjectByID(1), 15));
        return timeSheet;
    }

}
