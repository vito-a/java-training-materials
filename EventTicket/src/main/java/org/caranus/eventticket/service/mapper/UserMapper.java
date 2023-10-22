package org.caranus.eventticket.service.mapper;

import org.caranus.eventticket.dto.UserDto;
import org.caranus.eventticket.model.User;
import org.caranus.eventticket.model.impl.UserImpl;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    UserImpl userDtoToUser(UserDto userDto);
}
