package ru.gb.SpringData.services;


import ru.gb.SpringData.models.Note;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервиса заметок
 */
public interface INoteService {
    /**
     * Метод получения всех заметок
     * @return Все заметки в формате List
     */
    List<Note> getAllNotes();


    /**
     * Метод поиска заметки по ID
     * @param id ID заметку
     * @return Возвращает заметку по её ID в формате Optional
     */
    Optional<Note> getNoteById(Long id);

    /**
     * Метод создания заметки
     * @param note Новая заметка для создания
     * @return Возвращает созданную заметку
     */
    Note createNote(Note note);

    /**
     * Метод изменения заметки
     * @param id ID заметки для изменения
     * @param note Изменённая заметка
     * @return Возвращает изменённую заметку
     */
    Note updateNote(Long id, Note note);

    /**
     * Метод для удаления заметки по её ID
     * @param id ID заметки для удаления
     */
    void deleteNote(Long id);
}
