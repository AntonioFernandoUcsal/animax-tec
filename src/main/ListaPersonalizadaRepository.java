package com.Prototype.Animax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ListaPersonalizadaRepository extends JpaRepository<ListaPersonalizada, Long> {
    List<ListaPersonalizada> findByIdUsuario(Long idUsuario);
}