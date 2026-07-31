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
    
    
    @GetMapping("/animes")
    public List<Anime> listarCatologo() {
        return animeRepository.findAll();
    }

    @PostMapping("/animes")
    public Anime cadastrarAnime(@RequestBody Anime anime) {
        return animeRepository.save(anime);
    }

    
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
            existente.setNota(novaAvaliacao.getNota()); 
            avaliacaoRepository.save(existente);
        } else {
            avaliacaoRepository.save(novaAvaliacao); 
        }
        return ResponseEntity.ok().build();
    }
    
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
    
    @Autowired
    private ListaPersonalizadaRepository listaRepository;

    @Autowired
    private ItemListaRepository itemListaRepository;

    @PostMapping("/listas")
    public ListaPersonalizada criarLista(@RequestBody ListaPersonalizada lista) {
        return listaRepository.save(lista);
    }

    @GetMapping("/listas/usuario/{idUsuario}")
    public List<ListaPersonalizada> listarPorUsuario(@PathVariable Long idUsuario) {
        return listaRepository.findByIdUsuario(idUsuario);
    }

    @PostMapping("/listas/adicionar")
    public ItemLista adicionarAnimeNaLista(@RequestBody ItemLista item) {
        return itemListaRepository.save(item);
    }

    @GetMapping("/listas/{idLista}/itens")
    public List<ItemLista> listarItensDaLista(@PathVariable Long idLista) {
        return itemListaRepository.findByIdLista(idLista);
    }
}