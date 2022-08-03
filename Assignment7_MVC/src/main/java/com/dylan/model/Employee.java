package com.dylan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    public int id;
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public String address;
    public String contact;
}
