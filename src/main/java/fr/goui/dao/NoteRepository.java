package fr.goui.dao;

import fr.goui.entity.Note;
import org.springframework.data.repository.CrudRepository;

/**
 * The data access object for the Note table.
 */
public interface NoteRepository extends CrudRepository<Note, Long> {
}
