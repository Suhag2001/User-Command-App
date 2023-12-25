package com.bootcoding.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class User {
    private String id;
    private String name;
    private String address;
    private String emailId;
    private long phone ;
}
