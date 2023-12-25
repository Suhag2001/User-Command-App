package com.bootcoding.user.command;

import com.bootcoding.user.model.Result;

public interface Command {
     Result execute(String[] attributes) throws Exception;
}
