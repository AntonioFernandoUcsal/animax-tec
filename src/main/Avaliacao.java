package com.Prototype.Animax;
import jakarta.persistence.*;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idAnime;
    private Long idUsuario;
    private int nota;

    public Avaliacao() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getIdAnime() { return idAnime; }
    public void setIdAnime(Long idAnime) { this.idAnime = idAnime; }
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public int getNota() { return nota; }
    public void setNota(int nota) { this.nota = nota; }
}