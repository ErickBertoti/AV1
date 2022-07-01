package br.senai.controller;

import br.senai.model.orcamento;
import br.senai.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
    @Autowired
    ClienteServiceImpl orcamentoService;

    @GetMapping("/orcamento/list")
    public String findAll(Model model){
        model.addAttribute("orcamentos", orcamentoService.findAll());
        return "orcamento/list";
    }

    @GetMapping("/orcamento/add")
    public String add(Model model){
        model.addAttribute("orcamento", new orcamento());
        return "orcamento/add";
    }

    @GetMapping("/orcamento/edit/{id}")
    public String edit(Model model, @PathVariable long id){
        model.addAttribute("orcamento", orcamentoService.findById(id));
        return "orcamento/edit";
    }

    @PostMapping("/orcamento/save")
    public String save(orcamento orcamento, Model model){
        try{
            orcamentoService.save(orcamento);
            model.addAttribute("orcamento", orcamento);
            model.addAttribute("isSave", true);
            return "orcamento/add";
        }catch (Exception e){
            model.addAttribute("orcamento", orcamento);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());

            return "orcamento/add";
        }
    }

    @GetMapping("/orcamento/delete/{id}")
    public String delete(@PathVariable long id){
        try{
            orcamentoService.deleteById(id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return "redirect:/orcamento/list";
    }
}