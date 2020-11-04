package com.gft.mvc.controller;

import com.gft.mvc.model.StatusTitulo;
import com.gft.mvc.model.Titulo;
import com.gft.mvc.repo.TitulosRepository;
import com.gft.mvc.service.CadastroTituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titulos")
public class TituloController {

    @Autowired
    private TitulosRepository titulosRepository;

    @Autowired
    private CadastroTituloService cadastroTituloService;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView modelAndView = new ModelAndView("CadastroTitulo");
        modelAndView.addObject(new Titulo());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            return "CadastroTitulo";
        }

        try {
            // TODO: Salvar no banco de dados
            cadastroTituloService.salvar(titulo);

            redirectAttributes.addFlashAttribute("mensagem", "Titulo salvo com sucesso.");
            return "redirect:/titulos/novo";
        } catch (IllegalArgumentException e) {
            errors.rejectValue("dataVencimento", null, e.getMessage());
            return "CadastroTitulo";
        }
    }

    @RequestMapping
    public ModelAndView pesquisar(@RequestParam(defaultValue = "" +
            "") String descricao) {
        List<Titulo> todosTitulos = titulosRepository.findTitulosByDescricaoContaining(descricao);

        ModelAndView modelAndView = new ModelAndView("PesquisaTitulos");
        modelAndView.addObject("titulos", todosTitulos);
        return modelAndView;
    }

    @RequestMapping("{codigo}")
    public ModelAndView edicao(@PathVariable Long codigo) {
        Titulo titulo = titulosRepository.getOne(codigo);

        ModelAndView modelAndView = new ModelAndView("CadastroTitulo");
        modelAndView.addObject(titulo);
        return modelAndView;

    }

    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Long codigo, RedirectAttributes redirectAttributes) {
        cadastroTituloService.excluir(codigo);

        redirectAttributes.addFlashAttribute("mensagem", "Título excluído com sucesso!");
        return "redirect:/titulos";
    }

    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo> todosStatusTitulo() {
        return Arrays.asList(StatusTitulo.values());
    }
}
