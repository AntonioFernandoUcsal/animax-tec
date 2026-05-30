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
    private Double avaliacao;

    public Anime() {}

    public Anime(String titulo, String genero, String sinopse, String urlImagem, Double avaliacao) {
        this.titulo = titulo;
        this.genero = genero;
        this.sinopse = sinopse;
        this.urlImagem = urlImagem;
        this.avaliacao = avaliacao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getSinopse() { return sinopse; }
    public void setSinopse(String sinopse) { this.sinopse = sinopse; }

    public String getUrlImagem() { return urlImagem; }
    public void setUrlImagem(String urlImagem) { this.urlImagem = urlImagem; }

    public Double getAvaliacao() { return avaliacao; }
    public void setAvaliacao(Double avaliacao) { this.avaliacao = avaliacao; }
}