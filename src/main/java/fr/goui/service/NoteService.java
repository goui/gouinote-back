package fr.goui.service;

import fr.goui.dao.NoteRepository;
import fr.goui.dto.NoteDTO;
import fr.goui.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The service for everything linked to the notes.
 */
@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<NoteDTO> getAllNotes() {
        List<NoteDTO> notesDTO = new ArrayList<>();
        List<Note> notes = noteRepository.findAll();
        notes.forEach(note -> {
            NoteDTO noteDTO = new NoteDTO();
            noteDTO.setDate(note.getDate());
            noteDTO.setNickname(note.getUser().getNickname());
            noteDTO.setContent(note.getContent());
            notesDTO.add(noteDTO);
        });
        return notesDTO;
    }
}
