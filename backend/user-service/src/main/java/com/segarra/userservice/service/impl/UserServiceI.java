package com.segarra.userservice.service.impl;

import com.segarra.userservice.controller.dto.FriendDTO;
import com.segarra.userservice.controller.dto.UserDTO;
import com.segarra.userservice.enums.Platform;
import com.segarra.userservice.model.Friend;
import com.segarra.userservice.model.OwnedGame;
import com.segarra.userservice.model.User;
import com.segarra.userservice.repository.FriendRepository;
import com.segarra.userservice.repository.UserRepository;
import com.segarra.userservice.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceI implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRepository friendRepository;

    @Override
    public Long createUser(UserDTO user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        Optional<User> optionalUserEmail = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username " + user.getUsername() + " taken!");
        }
        if (optionalUserEmail.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email " + user.getEmail() + " is already in use");
        }
        User createdUser = new User(user.getUsername(), user.getEmail());
        userRepository.save(createdUser);
        return createdUser.getId();
    }

    @Override
    public String updateUser(UserDTO user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return optionalUser.get();
    }

    @Override
    public Long findIdByName(String username) {
        User findUserIdByName = userRepository.findByUsername(username).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );
        return findUserIdByName.getId();    }

    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            return new ArrayList<>();
        }

        return userList;
    }

    public void addFriend(FriendDTO friendDTO, Long id) {
        User friendToAdd = userRepository.findByUsername(friendDTO.getUsername()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );

            List<Friend> friends= user.getFriends();
            Friend friendship = new Friend(friendToAdd.getId(), user.getId(), friendToAdd.getUsername());
            friends.add(friendship);
            System.out.println(friendship);
            friendRepository.save(friendship);
            List<Friend> friends2 = friendToAdd.getFriends();
            friends2.add(new Friend(user.getId(), friendToAdd.getId(), user.getUsername()));
            userRepository.save(user);
            userRepository.save(friendToAdd);


    }

    @Override
    public List<Friend> showFriends(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );
        return user.getFriends();

    }

    @Override
    public List<OwnedGame> addGame(String game, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );
        List<OwnedGame> games = user.getGames();
        games.add(new OwnedGame(game));
        return games;
    }

    @Override
    public List<OwnedGame> showGames(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );
        return user.getGames();
    }

}


