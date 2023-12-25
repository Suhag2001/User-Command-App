package com.bootcoding.user.command.impl;

import com.bootcoding.user.command.Command;
import com.bootcoding.user.command.validator.CommandValidator;
import com.bootcoding.user.model.Result;
import com.bootcoding.user.model.User;
import com.bootcoding.user.model.UserData;

import java.util.UUID;

public class CreateCommand implements Command, CommandValidator {

    @Override
    public Result execute(String[] attributes) throws Exception {

        if(validate(attributes)){
            // start processing
            User user = User.builder()
                    .id(UUID.randomUUID().toString())
                    .build();
            for(int i = 0; i < attributes.length ; i = i + 2) {
                String attrName = attributes[i];
                setAttributeValue(user, attrName, attributes[i + 1]);
            }
            UserData.userList.add(user);
            return Result.builder().message("SUCCESS").users(UserData.userList).build();
        }
        return Result.builder().message("Invalid command arguments").build();
        }




    private void setAttributeValue(User user, String attrName, String value) throws Exception{
        switch (attrName){
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
                throw new Exception("Invalid command attribute format!");

        }
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



    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(attributes.length != 8){
            throw new Exception("Please provide all attributes: " +
                    "\nFor ex: create -n suhag -a nagpur -e suhag@gmail.com -p 9865245678");
        }
        boolean isValid = true;
        int i = 0;
        while(isValid && i < attributes.length){
            String attrName = attributes[i];
            isValid = validateAttributes(attrName);
            i = i + 2;
        }
        return isValid;
    }

}
