package com.bootcoding.user.command.impl;

import com.bootcoding.user.command.Command;
import com.bootcoding.user.model.Result;

public class ExitCommand implements Command {
    @Override
    public Result execute(String[] attributes) {
        // write logic for exit system
        return Result.builder().message("Exiting User Management System. Goodbye!").build();

    }

}
