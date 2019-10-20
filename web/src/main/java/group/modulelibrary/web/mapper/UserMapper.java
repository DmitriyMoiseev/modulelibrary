package group.modulelibrary.web.mapper;

import group.modulelibrary.web.dto.UserDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserDetails toUser(UserDto userDto) {
        return User.builder().username(userDto.getUsername())
                .password(userDto.getPassword())
                .authorities("USER", "ADMIN", "COOL_DUDE")
                .passwordEncoder(passwordEncoder::encode)
                .build();
    }
}
