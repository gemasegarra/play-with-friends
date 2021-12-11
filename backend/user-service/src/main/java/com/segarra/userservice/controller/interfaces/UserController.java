package com.segarra.userservice.controller.interfaces;

import com.segarra.userservice.controller.dto.FriendDTO;
import com.segarra.userservice.controller.dto.UserDTO;
import com.segarra.userservice.model.Friend;
import com.segarra.userservice.model.OwnedGame;
import com.segarra.userservice.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserController {
    Long createUser(UserDTO user);
    String updateUser(UserDTO user);
    void deleteUser(Long id);
    User findById(Long id);
    Long findIdByName(String username);
    List<User> findAll();
    void addFriend(FriendDTO friend, Long id);
    List<Friend> showFriends(Long id);
    List<OwnedGame> addGame(Long gameId, Long id);
    List<OwnedGame> showGames(Long id);
}
