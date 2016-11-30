package fr.goui.facade;

import fr.goui.dto.UserDTO;
import fr.goui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * All the endpoints for the users.
 */
@RestController
@RequestMapping("/user")
public class UserFacade {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createAccount")
    public String createAccount(@Validated @RequestBody UserDTO userDTO) {
        return userService.createAccount(userDTO);
    }
}
