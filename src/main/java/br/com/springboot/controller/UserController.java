package br.com.springboot.controller;

import br.com.springboot.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
        Optional<User> userFind = users.stream().filter(user -> user.getId().equals(id)).findFirst();

        if(userFind.isPresent()){
            return userFind.get();
        }

        return null;
    }

    @PostMapping("/")
    public User user(@RequestBody User user){
        users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> list(){
        return users;
    }

}