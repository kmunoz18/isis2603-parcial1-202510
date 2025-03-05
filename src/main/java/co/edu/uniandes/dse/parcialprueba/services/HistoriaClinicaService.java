package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.HistoriaClinicaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HistoriaClinicaService {
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Transactional
    public HistoriaClinicaEntity CrearHistoriaClinica(HistoriaClinicaEntity historiaClinica) throws IllegalOperationException{
        
}
}
