package ru.gb.SpringData.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.SpringData.models.Note;
import ru.gb.SpringData.services.NoteServiceImpl;

import java.util.List;

/**
 * Класс контроллера заметок
 */
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
@Log
public class NoteController {
    /**
     * Сервис заметок
     */
    private final NoteServiceImpl noteService;

    /**
     * Метод получения всех заметок
     * @return Возвращает все заметки в формате List
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        log.info("Run NoteController.getAllNotes");
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    /**
     * Метод получения заметки по её ID
     * @param id ID заметки для поиска
     * @return Возвращает искомую заметку
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        log.info("Run NoteController.getNoteById");
        Note note;
        try {
            note = noteService.getNoteById(id).get();
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    /**
     * Метод создания новой заметки
     * @param note Новая заметка
     * @return Новую заметку
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        log.info("Run NoteController.createNote");
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    /**
     * Метод обновляющий заметку
     * @param id ID заметки
     * @param newNote Изменённая заметка
     * @return Возвращает изменённую заметку
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note newNote){
        log.info("Run NoteController.updateNote");
        Note note;
        try {
            note = noteService.updateNote(id, newNote);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    /**
     * Метод удаления заметки
     * @param id ID заметки для удаления
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        log.info("Run NoteController.deleteNote");
        try {
            noteService.getNoteById(id).get();
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
