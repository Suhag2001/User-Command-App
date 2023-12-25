package com.bootcoding.user.command.impl;

import com.bootcoding.user.command.Command;
import com.bootcoding.user.command.validator.CommandValidator;
import com.bootcoding.user.model.Result;
import com.bootcoding.user.model.User;
import com.bootcoding.user.model.UserData;


public class UpdateCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] attributes) throws Exception{
        //  logic for update user
        if(validate(attributes)) {
           if(checkAndUpdateUser(attributes)){
               return Result.builder().message("User Updated Successfully !").build();
           }else{
               return Result.builder().message("User Not Found !").build() ;
           }
        }

        return Result.builder().message("Invalid command arguments").build();
    }

    private boolean checkAndUpdateUser(String[] attributes) {

        for (User user : UserData.userList){
            if (user.getId().equals(attributes[1])){
                for (int i = 2 ; i < attributes.length; i=i+2 ){
                   updateUser(attributes[i], attributes[i+1],user);
                }
                return true;
            }
        }
        return false;
    }

    private void updateUser(String  attribute, String value,User user) {
        switch (attribute){
            case "-n":
                user.setName(value);
                break;
            case "-p":
                user.setPhone(Long.valueOf(value));
                break;
            case "-a":
                user.setAddress(value);
                break;
            case "-e":
                user.setEmailId(value);
                break;
            default:
               System.err.println("Invalid attribute !");
        }
    }

    @Override
    public boolean validate(String[] attributes) throws Exception{
        if(attributes.length <4 && attributes.length>8){
            throw new Exception("Please provide proper attributes: " +
                    "\nFor ex: read -n suhag or read -i id_number or read -all ");
        }
            if (attributes[0].equals("-i") ) {
                boolean isValid = true;
                int i = 2;
                while(isValid && i < attributes.length){
                    String attrName = attributes[i];
                    isValid = validateAttributes(attrName);
                    i = i + 2;
                }
                return isValid;
        }
            return false;
    }
    private boolean validateAttributes(String attrName) {
        switch (attrName){
            case "-n":
                return true;
            case "-p":
                return true;
            case "-a":
                return true;
            case "-e":
                return true;
            default:
                return false;
        }
    }
}
