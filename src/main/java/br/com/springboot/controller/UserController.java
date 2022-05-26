package br.com.springboot.controller;

import br.com.springboot.model.User;
import br.com.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final List<User> users = new ArrayList<>();
    //@Autowired
    //private UserRepository userRepository;

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
        Optional<User> userFind = users.stream().filter(user -> user.getId().equals(id)).findFirst();

        return userFind.orElse(null);

    }

    @PostMapping("/")
    public User user(@RequestBody User user){
        //this.userRepository.save(user);
        users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> list(){
        return users;
    }

}
