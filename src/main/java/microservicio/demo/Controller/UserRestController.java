package microservicio.demo.Controller;

import microservicio.demo.Dto.UserDto;
import microservicio.demo.Models.User;
import microservicio.demo.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200/")
public class UserRestController {

    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserRestController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto){
        var user = this.modelMapper.map(userDto, User.class);
        user = this.userService.create(user);
        return new ResponseEntity<>(modelMapper.map(user, UserDto.class), HttpStatus.CREATED);
    }
}
