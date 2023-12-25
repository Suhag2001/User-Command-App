package com.bootcoding.user.command.validator;

public interface CommandValidator {
     boolean validate(String[] attributes) throws Exception;
}
