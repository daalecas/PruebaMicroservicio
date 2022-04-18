package microservicio.demo.Service.impl;

import lombok.extern.slf4j.Slf4j;
import microservicio.demo.Models.User;
import microservicio.demo.Repository.UserRepository;
import microservicio.demo.Service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Validator;

@Service
@Transactional
@Slf4j
public class UserServiceImpl  implements UserService {

    private UserRepository userRepository;
    private Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public User create(User user) {
        this.userRepository.save(user);
        return user;
    }

}
