package fr.goui.facade;

import fr.goui.dto.NoteDTO;
import fr.goui.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * All the endpoints for the notes.
 */
@RestController
@RequestMapping("/note")
public class NoteFacade {

    @Autowired
    private NoteService noteService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllNotes")
    public List<NoteDTO> getAllNotes() {
        return noteService.getAllNotes();
    }
}
