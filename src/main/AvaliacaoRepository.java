package com.Prototype.Animax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    // Procura se o usuário já avaliou aquele anime específico
    Avaliacao findByIdUsuarioAndIdAnime(Long idUsuario, Long idAnime);
}