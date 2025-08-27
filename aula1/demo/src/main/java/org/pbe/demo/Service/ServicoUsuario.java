package org.pbe.demo.Service;

import java.util.List;

import org.pbe.demo.Model.Usuario;
import org.pbe.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class ServicoUsuario {

    @Autowired
    UsuarioRepository usuarioRepository;

    public long cria(String nome, String sobrenome) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);

        usuario = usuarioRepository.save(usuario);
        return usuario.getId();
    }

    public Usuario buscaPorNome(String nome) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        Example<Usuario> exemplo = Example.of(usuario);

        return usuarioRepository.findOne(exemplo).orElse(null);
    }

    public List<Usuario> buscaTodosComNome(String nome) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        Example<Usuario> exemplos = Example.of(usuario);

        return usuarioRepository.findAll(exemplos);
    }
}
