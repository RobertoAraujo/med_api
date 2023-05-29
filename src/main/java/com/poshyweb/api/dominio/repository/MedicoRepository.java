package com.poshyweb.api.dominio.repository;

import com.poshyweb.api.constants.Expecializacao;
import com.poshyweb.api.dominio.entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MedicoRepository extends PagingAndSortingRepository<MedicoEntity, Long>, JpaRepository<MedicoEntity, Long> {
    List<MedicoEntity> findAll();

    @Query("""
            select m from MedicoEntity m where m.ativo= 1 
            and m.expecializacao = :expecializacao and m.id 
            not in(select c.medico.id from consulta c where c.data = :data)
            order by round() limit 1
            """)
    MedicoEntity ChooseFreeAleatyorioDoctorOnDate(Expecializacao expecializacao, LocalDateTime data);

    @Query("""
            select m.ativo from MedicoEntity m where m.id = :id
            """)
    Boolean findAtivoById(Long id);
}
