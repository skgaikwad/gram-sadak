package com.hp.web.portal.gram_sadak.service;

import com.hp.web.portal.gram_sadak.dto.UserDto;

import java.util.List;

public interface IUserService {

    Boolean addOrUpdateUser(UserDto userDto);

    UserDto getUserDetails(Integer userId);

    List<UserDto> getUserDetailsList();
}
