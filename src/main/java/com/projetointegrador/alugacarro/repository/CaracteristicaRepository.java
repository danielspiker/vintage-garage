package com.projetointegrador.alugacarro.repository;

import com.projetointegrador.alugacarro.model.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaRepository  extends JpaRepository<Caracteristica, Long> {

}
