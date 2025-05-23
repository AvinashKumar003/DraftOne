package com.DraftOneCRUD.DraftOne.Mapper;

import com.DraftOneCRUD.DraftOne.Model.Users;
import com.DraftOneCRUD.DraftOne.dto.Userdto;

public class UserMapper {

    public static Userdto toDto (Users users){
        Userdto dto = new Userdto();
       dto.setId(users.getId());
       dto.setName(users.getName());
       dto.setEmail(users.getEmail());   //getId(), getName(), and getEmail() are assumed to be getter methods in the Users class.

                                         //setId(), setName(), and setEmail() are the setter methods in the Userdto class.

        return  dto;
    }

    public static  Users toEntity(Userdto dto){
        Users users = new Users();
        users.setId(dto.getId());
        users.setName(dto.getName());
        users.setEmail(dto.getEmail());
        return users;

    }
}
