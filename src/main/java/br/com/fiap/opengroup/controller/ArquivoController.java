package br.com.fiap.opengroup.controller;

import br.com.fiap.opengroup.dto.ControllerDTO;
import br.com.fiap.opengroup.dto.request.ArquivoRequest;
import br.com.fiap.opengroup.dto.response.ArquivoResponse;
import br.com.fiap.opengroup.entity.Arquivo;
import br.com.fiap.opengroup.entity.DadosCliente;
import br.com.fiap.opengroup.service.ArquivoService;
import br.com.fiap.opengroup.service.DadosClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/arquivo")
public class ArquivoController implements ControllerDTO<ArquivoRequest, ArquivoResponse> {

    @Autowired
    private ArquivoService arquivoService;
    @Autowired
    private DadosClienteService dadosService;

    @GetMapping()
    public ResponseEntity<Collection<ArquivoResponse>> findAll(
            @RequestParam(name = "nome", required = false) String nomeArquivo,
            @RequestParam(name = "dadosCliente", required = false) String dadosCliente
    ){
        var arquivoBuilder = Arquivo.builder().nome(nomeArquivo);

        if (dadosCliente != null) {
            arquivoBuilder.dadosCliente(DadosCliente.builder().nome(dadosCliente).build());
        }

        Arquivo arquivo = arquivoBuilder.build();
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withMatcher("dadosCliente.nome", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Arquivo> example = Example.of(arquivo, matcher);

        List<Arquivo> arquivos = arquivoService.findAll(example);

        return ResponseEntity.ok(arquivos.stream().map(arquivoService::toResponse).toList());
    }


    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<ArquivoResponse> findById(@PathVariable Long id) {
        Arquivo arquivo = arquivoService.findById(id);
        System.out.println(arquivo);
        if (arquivo == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(arquivoService.toResponse(arquivo));
    }

    @Transactional
    @PostMapping
    @Override
    public ResponseEntity<ArquivoResponse> save(@RequestBody @Valid ArquivoRequest r) {
        if (Objects.isNull(dadosService.findById(r.dadosClienteId()))) return ResponseEntity.badRequest().build();
        Arquivo saved = arquivoService.save(r);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(arquivoService.toResponse(saved));
    }

}
