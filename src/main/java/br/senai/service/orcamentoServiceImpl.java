package br.senai.service;

import br.senai.model.orcamento;
import br.senai.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orcamentoServiceImpl implements OrcamentoService{

    @Autowired
    OrcamentoRepository orcamentoRepository;

    @Override
    public List<orcamento> findAll() {
        return orcamentoRepository.findAll();
    }

    @Override
    public orcamento findById(Long id){
        orcamento findEvento = orcamentoRepository.findById(id).get();
        if (findEvento != null){
            return findEvento;
        } else {
            return new orcamento();
        }
    }

    @Override
    public orcamento save(orcamento evento) {
        try{
            return orcamentoRepository.save(evento);
        }catch (Exception e){
            throw (e);
        }
    }

    @Override
    public void deleteById(Long id){
        try{
            orcamentoRepository.deleteById(id);
        }catch (Exception e){
            throw  e;
        }
    }
}
