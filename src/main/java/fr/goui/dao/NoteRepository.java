package fr.goui.dao;

import fr.goui.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The data access object for the Note table.
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
}
