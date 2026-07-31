package com.Prototype.Animax;

import jakarta.persistence.*;

@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idAnime;
    private String nomeUsuario;
    private String texto;

    public Comentario() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getIdAnime() { return idAnime; }
    public void setIdAnime(Long idAnime) { this.idAnime = idAnime; }
    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
}
