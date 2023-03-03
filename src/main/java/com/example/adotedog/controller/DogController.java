package com.example.adotedog.controller;


import com.example.adotedog.model.DogModel;
import com.example.adotedog.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/dog")
@CrossOrigin(origins = "http://localhost:4200")
public class DogController {

    @Autowired
    private DogService service;

    @PostMapping
    public DogModel create( MultipartFile file, String dog) {
        return service.create(file, dog);
    }

    @GetMapping("nao-adotados")
    public List<DogModel> getAllNaoAdotados() {
        return service.getAllNaoAdotados();
    }

    @GetMapping("adotados")
    public List<DogModel> getAllAdotados() {
        return service.getAllAdotados();
    }

    @GetMapping("id/{id}")
    public DogModel getAllAdotados(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("id/{id}")
    public void alterarEstadoAdocaoDog(@PathVariable Long id) {
        service.alterarEstadoAdocaoDog(id);
    }
}
