package com.DraftOneCRUD.DraftOne.Controller;

import com.DraftOneCRUD.DraftOne.Mapper.UserMapper;
import com.DraftOneCRUD.DraftOne.Model.Users;
import com.DraftOneCRUD.DraftOne.Repository.UserRepository;
import com.DraftOneCRUD.DraftOne.dto.Userdto;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }

    //Post Mapping
    @PostMapping
    public Userdto createUser(@RequestBody Userdto userdto){
        Users user = UserMapper.toEntity(userdto);
        return UserMapper.toDto(repository.save(user));
    }

    //Get Mapping
    @GetMapping
    public List<Userdto> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }
    //get mapping
    @GetMapping("/{id}")
    public Userdto getUserById(@PathVariable long id) {
        Users users = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
        return UserMapper.toDto(users);
    }
    //Put Mapping
    @PutMapping("/{id}")
    public Userdto updateUser (@PathVariable long id, @RequestBody Userdto userdto){
        Users users = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not found"));
        users.setName(userdto.getName());
        users.setEmail(userdto.getEmail());
        return UserMapper.toDto(repository.save(users));
    }
    //Delete Mapping
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){

//        repository.findById(id)
//                        .orElseThrow(() -> new RuntimeException("User Not found"));

        repository.deleteById(id);
    }


}
