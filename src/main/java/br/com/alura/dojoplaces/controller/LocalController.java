package br.com.alura.dojoplaces.controller;

import br.com.alura.dojoplaces.dto.CreateLocalForm;
import br.com.alura.dojoplaces.dto.LocalListDto;
import br.com.alura.dojoplaces.dto.UpdateLocalForm;
import br.com.alura.dojoplaces.exceptions.NotFoundException;
import br.com.alura.dojoplaces.repository.LocalRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LocalController {

    private final LocalRepository localRepository;

    public LocalController(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @GetMapping("/local/list")
    public String getLocalList(Model model) {
        List<LocalListDto> localListDto = localRepository.findAll().stream().map(LocalListDto::new).toList();
        model.addAttribute("places", localListDto);
        return "local/list";
    }

    @GetMapping("/local/create")
    public String localCreateForm() {
        return "local/create-form";
    }

    @PostMapping("/local/create")
    public String createLocal(@Valid CreateLocalForm form) {
        if(!localRepository.existsByCode(form.code())){
            localRepository.save(form.localCreator());
        }
        return "redirect:/local/list";
    }

    @GetMapping("/local/update/{id}")
    public String localUpdateForm(@PathVariable Long id, Model model) {
        var local = localRepository.findById(id).orElseThrow(() -> new NotFoundException("Local não encontrado!"));
        model.addAttribute("place", local);
        return "local/update-form";
    }

    @PostMapping("/local/update/{id}")
    public String updateLocal(@Valid UpdateLocalForm form, @PathVariable Long id) {
        var local = localRepository.findById(id).orElseThrow(() -> new NotFoundException("Local não encontrado!"));
        if(!localRepository.existsByCode(form.code()) || local.getCode().equals(form.code())){
            localRepository.save(local.edit(form));
        }
        return "redirect:/local/list";
    }

    @GetMapping("/local/delete/{id}")
    public String deleteLocal(@PathVariable Long id) {
        localRepository.deleteById(id);
        return "redirect:/local/list";
    }
}
