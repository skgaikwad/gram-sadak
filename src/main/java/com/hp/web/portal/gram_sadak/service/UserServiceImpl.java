package com.hp.web.portal.gram_sadak.service;

import com.hp.web.portal.gram_sadak.dto.UserDto;
import com.hp.web.portal.gram_sadak.entity.Users;
import com.hp.web.portal.gram_sadak.repository.UsersRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    Logger LOG = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Boolean addOrUpdateUser(UserDto userDto) {
        try {
            Users user = null;
            if (userDto.getId() > 0) {
                // Update User Details
                user = usersRepository.findById(userDto.getId()).get();
                user.setFirstName(userDto.getFirstName());
                user.setLastName(userDto.getLastName());
                user.setIsActive(true);
                user.setEmail(userDto.getEmail());
                user.setUpdatedBy("");
                user.setUpdatedDate(new Date());
                usersRepository.save(user);
            } else {
                // Insert User Details
                user = new Users();
                user = usersRepository.findById(userDto.getId()).get();
                user.setFirstName(userDto.getFirstName());
                user.setLastName(userDto.getLastName());
                user.setIsActive(true);
                user.setEmail(userDto.getEmail());
                user.setCreatedBy("");
                user.setCreatedDate(new Date());
                user.setUpdatedBy("");
                user.setUpdatedDate(new Date());
                user.setIsFirstLogin(true);
                usersRepository.save(user);
            }

        } catch (Exception e) {
            LOG.error("Exception UserServiceImpl.addOrUpdateUser() " + e);
        }
        return true;
    }

    @Override
    public UserDto getUserDetails(Integer userId) {
        UserDto userDto = new UserDto();
        try {
            LOG.error("Exception UserServiceImpl.getUserDetails() ");
            Optional<Users> user = usersRepository.findById(userId);
            Users users = user.get();
            userDto.setFirstName(users.getFirstName());
            userDto.setLastName(users.getLastName());
            userDto.setEmail(users.getEmail());
            userDto.setMobileNumber(users.getMobileNumber());
            userDto.setEmail(users.getEmail());
            userDto.setIsActive(users.getIsActive());
        } catch (Exception e) {
            LOG.error("Exception UserServiceImpl.getUserDetails() " + e);
        }
        return userDto;
    }

    @Override
    public List<UserDto> getUserDetailsList() {
        List<UserDto> userList = new ArrayList<UserDto>();
        try {
            LOG.info("Exception UserServiceImpl.getUserDetailsList() ");
            List<Users> usersList = usersRepository.findAll();
            LOG.info("Exception UserServiceImpl.getUserDetailsList() usersList" + usersList);
            for (Users users : usersList) {
                UserDto userDto = new UserDto();
                userDto.setFirstName(users.getFirstName());
                userDto.setLastName(users.getLastName());
                userDto.setEmail(users.getEmail());
                userDto.setMobileNumber(users.getMobileNumber());
                userDto.setEmail(users.getEmail());
                userDto.setIsActive(users.getIsActive());
                userList.add(userDto);
            }
        } catch (Exception e) {
            LOG.error("Exception UserServiceImpl.getUserDetailsList() " + e);
        }
        return userList;
    }

}