package org.java.dev.repository;

import org.java.dev.entity.Note;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
}
