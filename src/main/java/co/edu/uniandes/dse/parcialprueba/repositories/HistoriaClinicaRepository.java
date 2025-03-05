package co.edu.uniandes.dse.parcialprueba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinicaEntity, Long>{
    List<HistoriaClinicaEntity> findByDiagnostico(String diagnostico);
    List<HistoriaClinicaEntity> findByTratamiento(String tratamiento);
    List<HistoriaClinicaEntity> findByFechaDeCreacion(String fechaDeCreacion);

}
