package group.modulelibrary.web.controller;

import group.modulelibrary.web.dto.UserDto;
import group.modulelibrary.web.mapper.UserMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserDetailsManager userDetailsManager;
    private final UserMapper userMapper;

    public UserController(UserDetailsManager userDetailsManager, UserMapper userMapper) {
        this.userDetailsManager = userDetailsManager;
        this.userMapper = userMapper;
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('COOL_DUDE')")
    public void createUser(UserDto userDto) {
        userDetailsManager.createUser(userMapper.toUser(userDto));
    }

    @PutMapping("/update")
    public void updateUser(UserDto userDto) {
        userDetailsManager.updateUser(userMapper.toUser(userDto));
    }
}
