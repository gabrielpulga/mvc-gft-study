package com.gft.mvc.service;

import com.gft.mvc.model.Titulo;
import com.gft.mvc.repo.TitulosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CadastroTituloService {

    @Autowired
    private TitulosRepository titulosRepository;

    public void salvar(Titulo titulo){
        try {
            titulosRepository.save(titulo);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Formato de data inválido!");
        }
    }

    public void excluir(Long codigo){
        titulosRepository.deleteById(codigo);
    }
}
