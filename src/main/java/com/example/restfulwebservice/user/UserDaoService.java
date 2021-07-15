package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private  static int userCount = 1;

    static {
        users.add(new User(1, "Kenneth", new Date()));
        users.add(new User(2, "Alice", new Date()));
        users.add(new User(2, "Elena", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        return users.stream()
                .filter((object -> object.getId() == id))
                .findAny()
                .orElseThrow(() -> new UserNotFoundException(String.format("ID[%s] not found", id)));
    }

    public User deleteById(int id){
        User user = users.stream()
                .filter(object -> object.getId() == id)
                .findAny()
                .orElseThrow(() -> new UserNotFoundException(String.format("ID[%s] not found", id)));
        users.remove(user);
        return user;
    }
}
