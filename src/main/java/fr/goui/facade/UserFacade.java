package fr.goui.facade;

import fr.goui.dto.NoteDTO;
import fr.goui.dto.UserDTO;
import fr.goui.exception.EmptyNoteException;
import fr.goui.exception.NicknameAlreadyExistsException;
import fr.goui.exception.NicknameNotFoundException;
import fr.goui.exception.WrongCredentialsException;
import fr.goui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public UserDTO createAccount(@Validated @RequestBody UserDTO userDTO) throws NicknameAlreadyExistsException {
        return userService.createAccount(userDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signIn")
    public UserDTO signIn(@RequestParam("nickname") String nickname, @RequestParam("password") String password) throws WrongCredentialsException, NicknameNotFoundException {
        return userService.signIn(nickname, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addNote")
    public boolean addNote(@RequestParam("nickname") String nickname, @RequestBody NoteDTO noteDTO) throws NicknameNotFoundException, EmptyNoteException {
        return userService.addNote(nickname, noteDTO);
    }
}
