package br.edu.ifpb.kramerclothing.backend.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.kramerclothing.backend.DTO.DataUserCreateDTO;
import br.edu.ifpb.kramerclothing.backend.model.User;
import br.edu.ifpb.kramerclothing.backend.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> read(@RequestParam(value="id", required = false) Long id) {
        if(id != null) {
            User userSearched = this.userService.getUserById(id);
            if(userSearched != null) {
                return Collections.singletonList(userSearched);
            }

            return null;
        }

        return this.userService.readAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping
    public User create(@RequestBody @Valid DataUserCreateDTO user) {
        User userToCreate = new User(user.nome(), user.CPF(), user.idade());

        return this.userService.createOrUpdate(userToCreate);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return this.userService.createOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.userService.delete(id);
    }
} 
