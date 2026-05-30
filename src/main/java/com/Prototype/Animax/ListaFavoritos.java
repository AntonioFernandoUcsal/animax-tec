package com.Prototype.Animax;
import jakarta.persistence.*;

@Entity
@Table(name = "listas_favoritos")
public class ListaFavoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idUsuario; // Simulação de um utilizador logado
    
    @ManyToOne
    @JoinColumn(name = "anime_id")
    public Anime anime;

    // Construtores, Getters e Setters
    public ListaFavoritos() {}

    public ListaFavoritos(Long idUsuario, Anime anime) {
        this.idUsuario = idUsuario;
        this.anime = anime;
    }
    // (Gere os Getters e Setters aqui...)
}