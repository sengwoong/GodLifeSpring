package com.example.GodLife.module;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wordId;

    @ManyToOne
    @JoinColumn(name = "voca_vocaId", nullable = false)
    private Voca voca;

    private String word;
    private String meaning;

}
