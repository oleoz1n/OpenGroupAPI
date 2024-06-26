package br.com.fiap.opengroup.service;

import br.com.fiap.opengroup.dto.ServiceDTO;
import br.com.fiap.opengroup.dto.request.UsuarioRequest;
import br.com.fiap.opengroup.dto.response.UsuarioResponse;
import br.com.fiap.opengroup.entity.Usuario;
import br.com.fiap.opengroup.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService implements ServiceDTO<Usuario, UsuarioRequest, UsuarioResponse> {

    @Autowired
    private UsuarioRepository repo;
    @Autowired
    private DadosClienteService dadosClienteService;

    @Override
    public Usuario toEntity(UsuarioRequest r) {
        if (Objects.isNull(r)) return null;
        var dados = dadosClienteService.findById(r.dadosId());
        if (Objects.isNull(dados)) return null;
        return Usuario.builder()
                .nome(r.nome())
                .dataCriacao(LocalDate.now())
                .identificacao(r.identificacao())
                .telefone(r.telefone())
                .senha(r.senha())
                .status(r.status())
                .dados(dados)
                .build();
    }

    @Override
    public UsuarioResponse toResponse(Usuario e) {
        if (Objects.isNull(e)) return null;
        return UsuarioResponse.builder()
                .nome(e.getNome())
                .identificacao(e.getIdentificacao())
                .status(e.getStatus())
                .build();
    }

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Usuario> findAll(Example<Usuario> example) {
        return repo.findAll(example);
    }

    @Override
    public Usuario findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Usuario save(UsuarioRequest r) {
        return repo.save(toEntity(r));
    }
}
