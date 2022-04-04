package com.cg.apps.tataskyapp.service;

import com.cg.apps.tataskyapp.dao.AccountDao;
import com.cg.apps.tataskyapp.dao.UsersDao;
import com.cg.apps.tataskyapp.dto.UsersDto;
import com.cg.apps.tataskyapp.entities.Users;
import com.cg.apps.tataskyapp.utils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDao usersDao;

    @Autowired
    UsersService usersService;

    @Autowired
    AccountDao accountDao;


    // give the newly created account id//
    @Override
    public void registerUsers(UsersDto usr) {
        Users usrs = new Users();
        usrs.setUsername(usr.getUsername());
        usrs.setFirstName(usr.getFirstName());
        usrs.setLastName(usr.getLastName());
        usrs.setPassword(usr.getPassword());
        usrs.setRole(usr.getRole());
        usersDao.save(usrs);
    }

    //must give same account and users id as before record... if not you will get error//
    @Override
    public void updateUsers(UsersDto usr) {

        Optional<Users> opt = usersDao.findById(usr.getId());
        Users upd_usrs = opt.get();
        upd_usrs.setUsername(usr.getUsername());
        upd_usrs.setFirstName(usr.getFirstName());
        upd_usrs.setLastName(usr.getLastName());
        upd_usrs.setPassword(usr.getPassword());
        upd_usrs.setRole(usr.getRole());
        upd_usrs = usersDao.save(upd_usrs);

    }


    @Override
    public void deleteUsersByUserId(Long id) {
        Users user = usersDao.findById(id).orElse(null);
        if (user == null)
            throw new UserNotFoundException();
        usersDao.delete(user);
    }


    @Override
    public Users findUsersById(Long id) {
        Users usr = usersDao.findById(id).orElse(null);
        return usr;
    }


    @Override
    public Optional<Users> findUsersByUsername(String username) {
        Optional<Users> opt = usersDao.findByUsername(username);
        //Users usr = opt.get();
        return opt;

    }


}