package com.Prototype.Animax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
public class AnimaxController {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private ListaFavoritosRepository favoritosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    // ==========================================
    // CATÁLOGO DE ANIMES
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
    // LISTA DE FAVORITOS
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
// ==========================================
    // COMENTÁRIOS E AVALIAÇÕES REAIS (BANCO H2)
    // ==========================================
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @GetMapping("/comentarios/{idAnime}")
    public List<Comentario> listarComentarios(@PathVariable Long idAnime) {
        return comentarioRepository.findByIdAnimeOrderByIdDesc(idAnime);
    }

    @PostMapping("/comentarios")
    public Comentario postarComentario(@RequestBody Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @PostMapping("/avaliacoes")
    public ResponseEntity<Void> avaliarEpisodio(@RequestBody Avaliacao novaAvaliacao) {
        Avaliacao existente = avaliacaoRepository.findByIdUsuarioAndIdAnime(novaAvaliacao.getIdUsuario(), novaAvaliacao.getIdAnime());
        if (existente != null) {
            existente.setNota(novaAvaliacao.getNota()); // Atualiza a nota se já existir
            avaliacaoRepository.save(existente);
        } else {
            avaliacaoRepository.save(novaAvaliacao); // Cria nova nota
        }
        return ResponseEntity.ok().build();
    }
    // ==========================================
    // REGISTO E AUTENTICAÇÃO DE UTILIZADORES
    // ==========================================
    @PostMapping("/usuarios/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            return ResponseEntity.badRequest().body("Erro: Este e-mail já está cadastrado!");
        }
        Usuario novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PostMapping("/usuarios/login")
    public ResponseEntity<?> loginUsuario(@RequestBody Usuario dadosLogin) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(dadosLogin.getEmail());
        if (usuario.isPresent() && usuario.get().getSenha().equals(dadosLogin.getSenha())) {
            return ResponseEntity.ok(usuario.get()); 
        }
        return ResponseEntity.status(401).body("Erro: E-mail ou senha inválidos!");
    }

    @DeleteMapping("/favoritos/{idUsuario}/{idAnime}")
    public ResponseEntity<Void> removerFavorito(@PathVariable Long idUsuario, @PathVariable Long idAnime) {
        favoritosRepository.deleteByIdUsuarioAndAnime_Id(idUsuario, idAnime);
        return ResponseEntity.ok().build();
    }
    
}