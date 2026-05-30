package com.Prototype.Animax;

import com.animaxtec.backend.models.ListaFavoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ListaFavoritosRepository extends JpaRepository<ListaFavoritos, Long> {
    List<ListaFavoritos> findByIdUsuario(Long idUsuario);
}
