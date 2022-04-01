package com.cg.apps.tataskyapp.service;

import com.cg.apps.tataskyapp.dto.UsersDto;
import com.cg.apps.tataskyapp.entities.Users;

public interface UsersService {

    void registerUsers(UsersDto usr);

    void updateUsers(UsersDto usr);

    Users findUsersById(Long id);

    Users findUsersByUsername(String username);

    void deleteUsersByUserId(Long id);


}