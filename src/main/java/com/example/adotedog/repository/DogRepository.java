package com.example.adotedog.repository;

import com.example.adotedog.model.DogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DogRepository extends JpaRepository<DogModel, Long> {

    @Query(value = "select d from DogModel d where d.isAdotado = :adotado")
    List<DogModel> buscarPorSituacao(boolean adotado);
}
