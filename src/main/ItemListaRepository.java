package com.Prototype.Animax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemListaRepository extends JpaRepository<ItemLista, Long> {
    List<ItemLista> findByIdLista(Long idLista);
}