package com.bootcoding.user.command.impl;

import com.bootcoding.user.command.Command;
import com.bootcoding.user.command.validator.CommandValidator;
import com.bootcoding.user.model.Result;
import com.bootcoding.user.model.User;
import com.bootcoding.user.model.UserData;

import java.util.List;

public class DeleteCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] attributes) throws Exception{
        //  logic for delete user
        if(validate(attributes)){
            if (checkUser(attributes)){
                return  Result.builder().message("User Deleted Successfully !").build();
            }else {
                return  Result.builder().message("User Not Found !").build();
            }
        }
        return Result.builder().message("Invalid command arguments").build();
    }

    private boolean checkUser(String[] attributes) {
        for (User user : UserData.userList){
            if (user.getId().equals(attributes[1])){
                UserData.userList.remove(user);
                for (int i = 2 ; i<attributes.length ; i++){

                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validate(String[] attributes)throws Exception {
        if(attributes.length != 2){
            throw  new Exception("Please provide proper attributes: " +
                    "\nFor ex: delete -i id_number ");
        }
        if (attributes[0].equals("-i")) return true;
        return false;
    }
}
