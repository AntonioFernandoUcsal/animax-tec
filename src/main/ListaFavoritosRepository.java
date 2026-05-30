package com.Prototype.Animax;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface ListaFavoritosRepository extends JpaRepository<ListaFavoritos, Long> {
    
    
    List<ListaFavoritos> findByIdUsuario(Long idUsuario);

    
    @Transactional
    void deleteByIdUsuarioAndAnime_Id(Long idUsuario, Long idAnime);
}