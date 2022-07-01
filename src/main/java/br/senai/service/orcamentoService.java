package br.senai.service;

import br.senai.model.orcamento;

import java.util.List;

public interface OrcamentoService {

    public List<orcamento> findAll();
    public orcamento findById(Long id);
    public orcamento findByNome(String nome);
    public orcamento save(orcamento cliente);
    public void deleteById(Long id);
}