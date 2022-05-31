package com.oof.crudsample.controller;

import com.oof.crudsample.domain.Person;
import com.oof.crudsample.repository.PersonRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hr/persons")
public class PersonController {
    
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping("list")
    public String listAll(Model model){
        model.addAttribute("listPersons", this.personRepository.findAll());
        return "hr/persons/index";
    }

    @GetMapping("new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "hr/persons/form";
    }

    @PostMapping("save")
    public String savePerson(@ModelAttribute("person") Person person){
        personRepository.save(person);
        return "redirect:hr/persons/list";
    }
}
