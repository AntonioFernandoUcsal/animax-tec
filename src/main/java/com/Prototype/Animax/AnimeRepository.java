package com.Prototype.Animax;

import com.Animax.backend.models.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
    // Pode adicionar buscas personalizadas, ex: procurar por género
}