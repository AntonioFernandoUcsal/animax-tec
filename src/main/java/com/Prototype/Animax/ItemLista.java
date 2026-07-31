package com.Prototype.Animax;
import jakarta.persistence.*;

@Entity
@Table(name = "itens_lista")
public class ItemLista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idLista;
    private Long idAnime;

    public ItemLista() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getIdLista() { return idLista; }
    public void setIdLista(Long idLista) { this.idLista = idLista; }
    public Long getIdAnime() { return idAnime; }
    public void setIdAnime(Long idAnime) { this.idAnime = idAnime; }
}