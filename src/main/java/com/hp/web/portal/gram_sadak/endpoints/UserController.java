package com.hp.web.portal.gram_sadak.endpoints;

import com.hp.web.portal.gram_sadak.dto.UserDto;
import com.hp.web.portal.gram_sadak.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value="/addOrUpdateUser")
    public ResponseEntity<Boolean> addOrUpdateUser(@RequestParam UserDto userDto) {
        return new ResponseEntity<>(userService.addOrUpdateUser(userDto), HttpStatus.OK);
    }

    @GetMapping(value="/getUser/{userId}")
    public ResponseEntity<UserDto> getUpdateUserDetails(@PathParam(value = "userId") Integer userId) {
        return new ResponseEntity<>(userService.getUserDetails(userId), HttpStatus.OK);
    }

    @GetMapping(value="/getUserList")
    public ResponseEntity<List<UserDto>> getUpdateDetailsList() {
        return new ResponseEntity<>(userService.getUserDetailsList(), HttpStatus.OK);
    }

}