package com.BlogApp.Blogz.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String password;
    private String about;


}