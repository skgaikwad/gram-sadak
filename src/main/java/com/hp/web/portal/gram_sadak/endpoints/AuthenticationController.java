package com.hp.web.portal.gram_sadak.endpoints;

import com.hp.web.portal.gram_sadak.config.security.JwtTokenProvider;
import com.hp.web.portal.gram_sadak.dto.ApiResponse;
import com.hp.web.portal.gram_sadak.dto.UserDto;
import com.hp.web.portal.gram_sadak.dto.login.LoginDto;
import com.hp.web.portal.gram_sadak.dto.registration.SignUpRegistrationDto;
import com.hp.web.portal.gram_sadak.entity.Users;
import com.hp.web.portal.gram_sadak.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.Objects;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @GetMapping(value="/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("userDto",new LoginDto());
        return modelAndView;
    }

    /**
     * Login API for existing users
     * 
     * @param loginRequest
     * @return
     */
    @PostMapping(value="/login")
    public String authenticateUser(@Valid @ModelAttribute("") LoginDto loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), passwordEncoder.encode(loginRequest.getPassword())));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        if(Objects.nonNull(authentication)) {
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
        //return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {
        return "redirect:/login";
    }


    /**
     * Register New User
     * 
     * @param signUpRequest
     * @return
     */

    @PostMapping(value="/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRegistrationDto signUpRequest) {
        if (userRepository.existsByUserName(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        UserDto userDto = new UserDto(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
                signUpRequest.getPassword());

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Users user = new Users();
        user.setFirstName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserName(signUpRequest.getUsername());
        Users result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUserName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

}
