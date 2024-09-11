package com.projetointegrador.alugacarro.service;

import com.projetointegrador.alugacarro.model.Caracteristica;
import com.projetointegrador.alugacarro.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicaService {

    @Autowired
    CaracteristicaRepository caracteristicaRepository;

    public Caracteristica save(Caracteristica caracteristica) {
        return caracteristicaRepository.save(caracteristica);
    }

    public List<Caracteristica> findAll() {
        return caracteristicaRepository.findAll();
    }
}
