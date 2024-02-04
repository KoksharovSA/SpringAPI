package ru.gb.SpringData.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.SpringData.models.Note;
import ru.gb.SpringData.repositories.NoteRepository;

import java.util.List;
import java.util.Optional;

/**
 * Класс сервиса заметок
 */
@Service
@AllArgsConstructor
public class NoteServiceImpl implements INoteService {
    /**
     * Репозиторий заметок
     */
    private final NoteRepository repository;

    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Override
    public Note createNote(Note note) {
        return repository.save(note);
    }

    @Override
    public Note updateNote(Long id, Note newNote) {
        Optional<Note> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Note note = optionalTask.get();
            note.setHeader(newNote.getHeader());
            note.setText(newNote.getText());
            note.setDateCreate(newNote.getDateCreate());
            return repository.save(note);
        } else {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
    }

    @Override
    public void deleteNote(Long id) {
        repository.deleteById(id);
    }
}
