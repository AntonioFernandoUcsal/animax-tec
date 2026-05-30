package com.Prototype.Animax;

import com.animaxtec.backend.models.Anime;
import com.animaxtec.backend.models.ListaFavoritos;
import com.animaxtec.backend.repositories.AnimeRepository;
import com.animaxtec.backend.repositories.ListaFavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Permite que o seu HTML (Front-end) chame a API
public class AnimaxController {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private ListaFavoritosRepository favoritosRepository;

    // ==========================================
    // REQUISITO PRIMÁRIO: CATÁLOGO (RF001/RF025)
    // ==========================================
    
    @GetMapping("/animes")
    public List<Anime> listarCatologo() {
        return animeRepository.findAll();
    }

    @PostMapping("/animes")
    public Anime cadastrarAnime(@RequestBody Anime anime) {
        return animeRepository.save(anime);
    }

    // ==========================================
    // REQUISITO SECUNDÁRIO: FAVORITOS (RF004/RF005)
    // ==========================================

    @GetMapping("/favoritos/{idUsuario}")
    public List<ListaFavoritos> listarFavoritos(@PathVariable Long idUsuario) {
        return favoritosRepository.findByIdUsuario(idUsuario);
    }

    @PostMapping("/favoritos/{idUsuario}/{idAnime}")
    public ListaFavoritos adicionarFavorito(@PathVariable Long idUsuario, @PathVariable Long idAnime) {
        Anime anime = animeRepository.findById(idAnime).orElseThrow();
        ListaFavoritos novoFavorito = new ListaFavoritos(idUsuario, anime);
        return favoritosRepository.save(novoFavorito);
    }
}
