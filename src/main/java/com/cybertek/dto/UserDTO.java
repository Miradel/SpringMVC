package com.cybertek.dto;

import com.cybertek.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    /*
    DTO -> Data Transfer Object.
    In client-server projects, data is often structured differently by the client (presentation layer) and the server
     (domain layer). This allows the server to store its information in a database-friendly or performant way, while
      providing a user-friendly representation for the client. The server needs a way to translate between the two data
      formats. Different architectures do exist, but we are just considering this one for simplicity. DTO-like objects
      can be used between any two data representations.

    Dto is mostly fixed and related with UI and working with Controller , entity is related to the database.

      Controller send empty object to the View(HTML), and empty object is come from DTO, not entity object.

     */

    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private boolean enabled;
    private String phone;
    private RoleDTO role;
    private Gender gender;
}
