package com.bootcoding.user.command.impl;

import com.bootcoding.user.command.Command;
import com.bootcoding.user.command.validator.CommandValidator;
import com.bootcoding.user.model.Result;
import com.bootcoding.user.model.User;
import com.bootcoding.user.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class ReadCommand implements Command, CommandValidator {

    // -n suhag
    @Override
    public Result execute(String[] attributes) throws Exception{
        if(validate(attributes)){
             List<User> userList= searchData(attributes);
             if (userList==null){
                 return Result.builder().message("User Not Found !").build();
             }else if(userList.isEmpty()){
                 return Result.builder().message("User List is Empty !").build();
            }
          return  Result.builder().message("SUCCESS").users(userList).build();
        }
        return Result.builder().message("Invalid command arguments").build();
    }

    private List<User>  searchData(String[] attributes) {
        List<User> users = new ArrayList<>();
        if (attributes[0].equals("-n")) {
            for (User user : UserData.userList) {
                if (user.getName().equals(attributes[1] )) {
                    users.add(user);
                    return users;
                }
            }
        }
        if (attributes[0].equals("-i")) {
            for (User user : UserData.userList) {
                if (user.getId().equals(attributes[1])) {
                    users.add(user);
                    return users;
                }
            }

        }
        if (attributes[0].equals("-all")) {
            return UserData.userList;

        }
return null;
    }
    @Override
    public boolean validate(String[] attributes) throws Exception{
        if(attributes.length <1 && attributes.length>2){
            throw new Exception("Please provide proper attributes: " +
                    "\nFor ex: read -n suhag or read -i id_number or read -all ");
        }
        if (attributes[0].equals("-n")) {
            return true;
        } else if (attributes[0].equals("-i")) {
            return true;
        }else if (attributes[0].equals("-all")){
            return true;
        }
        return false;
    }
}
