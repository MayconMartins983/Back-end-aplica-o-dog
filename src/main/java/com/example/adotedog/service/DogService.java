package com.example.adotedog.service;

import com.example.adotedog.model.DogModel;
import com.example.adotedog.repository.DogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class DogService {

    @Autowired
    private DogRepository repository;

    public DogModel create(MultipartFile file, String dogModel) {
        var mapper = new ObjectMapper();
        var dog = new DogModel();

        try {
            dog = mapper.readValue(dogModel, DogModel.class);
            dog.setAdotado(false);
            dog.setFoto(file.getBytes());
            dog.setCodigo(gerarCodigo());

            if (dog.getNome().isBlank()) {
                dog.setNome("Ainda não possui nome");
            }
            return repository.save(dog);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível ler o json");
        }
    }

    private String gerarCodigo() {
        var codigo = Instant.now().toEpochMilli();
        var codigoEmString = String.valueOf(codigo);

        return codigoEmString;
    }

    public List<DogModel> getAllNaoAdotados() {
        return repository.buscarPorSituacao(false);
    }

    public List<DogModel> getAllAdotados() {
        return repository.buscarPorSituacao(true);
    }

    public DogModel findById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Dog não encontrado.");
        });
    }

    public void alterarEstadoAdocaoDog(Long id) {
        var dog = findById(id);
        dog.setAdotado(!dog.isAdotado());

        repository.save(dog);
    }
}
