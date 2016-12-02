package fr.goui.service;

import fr.goui.dao.NoteRepository;
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

    @Autowired
    private NoteRepository noteRepository;

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
                noteDTO.setNickname(userDTO.getNickname());
                notesDTO.add(noteDTO);
            });
            userDTO.setNotes(notesDTO);
            usersDTO.add(userDTO);
        });
        return usersDTO;
    }

    public UserDTO createAccount(UserDTO userDTO) {
        User user = new User();
        user.setNickname(userDTO.getNickname());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return userDTO;
    }

    public UserDTO signIn(String nickname, String password) {
        User user = userRepository.findByNicknameAndPassword(nickname, password);
        if(user != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setNickname(user.getNickname());
            userDTO.setPassword(user.getPassword());
            List<NoteDTO> notesDTO = new ArrayList<>();
            List<Note> notes = user.getNotes();
            notes.forEach(note -> {
                NoteDTO noteDTO = new NoteDTO();
                noteDTO.setDate(note.getDate());
                noteDTO.setContent(note.getContent());
                noteDTO.setNickname(userDTO.getNickname());
                notesDTO.add(noteDTO);
            });
            userDTO.setNotes(notesDTO);
            return userDTO;
        } else {
            return null;
        }
    }

    public boolean addNote(String nickname, NoteDTO noteDTO) {
        User user = userRepository.findByNickname(nickname);
        Note note = new Note();
        note.setContent(noteDTO.getContent());
        note.setDate(noteDTO.getDate());
        note.setUser(user);
        noteRepository.save(note);
        user.getNotes().add(note);
        return true;
    }
}
