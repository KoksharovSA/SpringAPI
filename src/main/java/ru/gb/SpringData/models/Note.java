package ru.gb.SpringData.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


/**
 * Класс заметки
 */
@Entity
@Table(name = "note")
@Data
public class Note {
    /**
     * ID заметки
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    /**
     * Заголовок заметки
     */
    @Column(nullable = false)
    private String header;

    /**
     * Текст заметки
     */
    @Column(nullable = false, length = 2000)
    private String text;


    /**
     * Дата создания заметки, генерируется автоматически
     */
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime dateCreate;
}
