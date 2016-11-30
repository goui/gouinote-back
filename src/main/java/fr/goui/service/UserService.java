package fr.goui.service;

import fr.goui.dao.UserRepository;
import fr.goui.dto.NoteDTO;
import fr.goui.dto.UserDTO;
import fr.goui.entity.Note;
import fr.goui.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The service for everything linked to the users.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<UserDTO> usersDTO = new ArrayList<>();
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setNickname(user.getNickname());
            userDTO.setPassword(user.getPassword());
            List<NoteDTO> notesDTO = new ArrayList<>();
            List<Note> notes = user.getNotes();
            notes.forEach(note -> {
                NoteDTO noteDTO = new NoteDTO();
                noteDTO.setDate(note.getDate());
                noteDTO.setContent(note.getContent());
                notesDTO.add(noteDTO);
            });
            userDTO.setNotes(notesDTO);
            usersDTO.add(userDTO);
        });
        return usersDTO;
    }
}
