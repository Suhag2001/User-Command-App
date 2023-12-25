package com.bootcoding.user.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@Builder
public class UserData {
    public static List<User> userList = new ArrayList<>();
}
