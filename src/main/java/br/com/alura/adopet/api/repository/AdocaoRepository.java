package br.com.alura.adopet.api.repository;

import br.com.alura.adopet.api.model.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

}
