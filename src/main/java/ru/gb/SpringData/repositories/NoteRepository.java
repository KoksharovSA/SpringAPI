package ru.gb.SpringData.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.SpringData.models.Note;

/**
 * Класс JPA репозитория для общения с базой данных
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
