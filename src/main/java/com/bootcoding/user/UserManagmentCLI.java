package com.bootcoding.user;


import com.bootcoding.user.command.Command;
import com.bootcoding.user.command.impl.CreateCommand;
import com.bootcoding.user.command.impl.DeleteCommand;
import com.bootcoding.user.command.impl.ReadCommand;
import com.bootcoding.user.command.impl.UpdateCommand;
import com.bootcoding.user.model.Result;
import com.bootcoding.user.model.User;

import java.util.Scanner;

public class UserManagmentCLI {
    public static void main(String[] args)  {
        System.out.println("~~~~~ Welcome to User Managment Command Terminal ~~~~~\n" +
                "***** Please Enter Proper Attributes and Fields as per Your Operation *****\n"+
                "````` Like : create , read , update and delete with small case `````"
           );
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String commandLine = scanner.nextLine();

            String[] commandParts = commandLine.split(" ");
            String action = commandParts[0];

            Command command = null;

            switch (action.toLowerCase()) {
                case "create":
                    command = new CreateCommand();
                    break;
                case "read":
                    command = new ReadCommand();
                    break;
                case "delete":
                    command = new DeleteCommand();
                    break;
                case "update":
                    command = new UpdateCommand();
                    break;
                case "exit":
                    System.out.println("Exiting User Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    continue;
            }


            String[] attributes = new String[commandParts.length - 1];

            System.arraycopy(commandParts, 1, attributes, 0, attributes.length);

            try{
                Result result = command.execute(attributes);
                // Process and display the result as needed
                System.out.println(result.message);

                if (result.users != null) {
                    for (User user : result.users) {
                        System.out.println(user.toString());
                    }
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }


        }
    }
}
