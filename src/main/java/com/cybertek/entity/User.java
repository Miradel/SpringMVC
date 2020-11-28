package com.cybertek.model;

import com.cybertek.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private String firstName;
    private String lastName;
    private Gender gender;
    private int batchNumber;
    private String email;
    private String streetName;
    private String city;
    private String province;
    private String postalCode;

}
