package org.java.dev.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.java.dev.entity.Note;
import org.java.dev.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public Note getById(long id) {
        return noteRepository.getReferenceById(id);
    }

    public void deleteAll() {
        noteRepository.deleteAll();
    }

    public void generateNotes(int numberOfNotes) {
        for (int i = 1; i <= numberOfNotes; i++) {
            String contentPhrase = "The quick brown fox jumps over the lazy dog... ";
            noteRepository.save(new Note(null, "Note " + i, contentPhrase));
        }
    }
}