package com.bootcoding.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class Result {
    public String message;
    public List<User> users;
}
