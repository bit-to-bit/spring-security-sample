package org.java.dev.mapper;

import lombok.RequiredArgsConstructor;
import org.java.dev.dto.UserDto;
import org.java.dev.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static java.util.Objects.isNull;
@Component
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserDto> {
    @Override
    public UserDto mapEntityToDto(User source) throws RuntimeException {
        if (isNull(source)) {
            return null;
        }
        UserDto target = new UserDto();
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setEnabled(source.isEnabled());
        target.setAccountNonLocked(source.isAccountNonLocked());
        target.setAccountNonExpired(source.isAccountNonExpired());
        target.setCredentialsNonExpired(source.isCredentialsNonExpired());
        target.setAuthorities(Collections.emptyList());
        return target;
    }

    @Override
    public User mapDtoToEntity(UserDto source) throws RuntimeException {
        if (isNull(source)) {
            return null;
        }
        User target = new User();
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setEnabled(source.isEnabled());
        target.setAccountNonLocked(source.isAccountNonLocked());
        target.setAccountNonExpired(source.isAccountNonExpired());
        target.setCredentialsNonExpired(source.isCredentialsNonExpired());
        return target;
    }
}
