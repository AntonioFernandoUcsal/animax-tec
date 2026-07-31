package com.Prototype.Animax;
import jakarta.persistence.*;

@Entity
@Table(name = "listas_favoritos")
public class ListaFavoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idUsuario;
    
    @ManyToOne
    @JoinColumn(name = "anime_id")
    private Anime anime;

    public ListaFavoritos() {}

    public ListaFavoritos(Long idUsuario, Anime anime) {
        this.idUsuario = idUsuario;
        this.anime = anime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Anime getAnime() { return anime; }
    public void setAnime(Anime anime) { this.anime = anime; }

    
}