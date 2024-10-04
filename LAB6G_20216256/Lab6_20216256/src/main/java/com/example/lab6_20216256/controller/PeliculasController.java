package com.example.lab6_20216256.controller;


import com.example.lab6_20216256.entity.Pelicula;
import com.example.lab6_20216256.repository.PeliculasRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/movieMaster")
public class PeliculasController {

    final PeliculasRepository peliculasRepository;

    public PeliculasController(PeliculasRepository peliculasRepository) {
        this.peliculasRepository = peliculasRepository;
    }


    @GetMapping("/pagina")
    public String redirigirPaginaPrinmcipal(Model model) {

        return "paginaPrincipal";
    }

    @GetMapping("/list")
    public String listarPeliculas(Model model) {
        model.addAttribute("listaPeliculas", peliculasRepository.findAll());
        return "Peliculas/list";
    }

    @GetMapping("/new")
    public String agregarNuevaPeli(Model model, @ModelAttribute("pelicula") Pelicula pelicula) {

        return "Peliculas/NewForm";
    }

    @PostMapping("/save")
    public String guardarPelicula(RedirectAttributes attr, Model model,
                                   @ModelAttribute("pelicula") @Valid Pelicula pelicula, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal
            peliculasRepository.save(pelicula);
            return "redirect:/movieMaster/list";
        }
        else { //hay al menos 1 error
            return "Peliculas/NewForm";
        }
    }

    @GetMapping("/edit")
    public String editarTransportista(@ModelAttribute("pelicula") Pelicula pelicula,
                                      Model model, @RequestParam("id") int id) {

        Optional<Pelicula> optPelicula = peliculasRepository.findById(id);

        if (optPelicula.isPresent()) {
            pelicula = optPelicula.get();
            model.addAttribute("pelicula", pelicula);

            return "Peliculas/NewForm";
        } else {
            return "redirect:/movieMaster/list";
        }
    }













}
