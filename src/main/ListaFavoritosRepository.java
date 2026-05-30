package com.Prototype.Animax;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface ListaFavoritosRepository extends JpaRepository<ListaFavoritos, Long> {
    
    // Busca os favoritos do utilizador
    List<ListaFavoritos> findByIdUsuario(Long idUsuario);

    // NOVO: Apaga um favorito específico cruzando o ID do Utilizador com o ID do Anime
    @Transactional
    void deleteByIdUsuarioAndAnime_Id(Long idUsuario, Long idAnime);
}