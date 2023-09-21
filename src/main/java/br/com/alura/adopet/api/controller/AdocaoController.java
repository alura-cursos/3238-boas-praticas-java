package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.service.AdocaoService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

    @Autowired
    private AdocaoService adocaoService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid Adocao adocao) {
        try {
            this.adocaoService.solicitar(adocao);
            return ResponseEntity.ok("Adoção solciitada com sucesso!");
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid Adocao adocao) {
        this.adocaoService.aprovar(adocao);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid Adocao adocao) {
        this.adocaoService.reprovar(adocao);
        return ResponseEntity.ok().build();
    }

}
