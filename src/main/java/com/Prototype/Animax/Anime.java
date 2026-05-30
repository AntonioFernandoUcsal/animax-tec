package com.Prototype.Animax;
import jakarta.persistence.*;

@Entity
@Table(name = "animes")
public class Anime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String genero;
    private String sinopse;
    private String urlImagem;
    private Double avaliacao; // RF002 - Avaliação por Estrelas

    // Construtores, Getters e Setters
    public Anime() {}

    public Anime(String titulo, String genero, String sinopse, String urlImagem, Double avaliacao) {
        this.titulo = titulo;
        this.genero = genero;
        this.sinopse = sinopse;
        this.urlImagem = urlImagem;
        this.avaliacao = avaliacao;
    }

    // (Gere os Getters e Setters aqui...)
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    // ...
    
}

