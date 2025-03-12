package br.com.fiap.ms_produto.service;

import br.com.fiap.ms_produto.dto.CategoriaDTO;
import br.com.fiap.ms_produto.entities.Categoria;
import br.com.fiap.ms_produto.repositories.CategoriaRepository;
import br.com.fiap.ms_produto.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Transactional(readOnly = true)
    public List<CategoriaDTO> findAll(){
        return repository.findAll().stream().map(CategoriaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CategoriaDTO findById(Long id){
        Categoria entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. Id" + id)
        );
        return new CategoriaDTO(entity);
    }

    @Transactional
    public CategoriaDTO create(CategoriaDTO dto){
        Categoria entity = new Categoria();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new CategoriaDTO(entity);
    }

    private void copyDtoToEntity(CategoriaDTO dto, Categoria entity){
        entity.setNome(dto.getNome());
    }

    @Transactional
    public CategoriaDTO update(Long id, CategoriaDTO dto){
        try{
        Categoria entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new CategoriaDTO(entity);
        }catch (EntityNotFoundException ex ){
        throw new ResourceNotFoundException("Recuso não encontrado. ID" + id);
        }
    }

    @Transactional
    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Recuso não encontrado. ID" + id);
        }
        repository.deleteById(id);
    }
}
