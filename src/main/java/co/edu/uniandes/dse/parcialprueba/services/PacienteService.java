package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public PacienteEntity createPaciente(PacienteEntity paciente) throws IllegalOperationException{
        log.info("Inicia proceso de creación del paciente");
        if (paciente.getNombre()==null || paciente.getCorreo()==null||paciente.getTelefono()==null)
            throw new IllegalOperationException("El paciente tiene que tener un nombre, un correo y un telefono para ser creado");
        if (paciente.getTelefono().length()!=11|| (!paciente.getTelefono().startsWith("311")|| (!paciente.getTelefono().startsWith("601"))))
            throw new IllegalOperationException("El telefono del paciente debe ser de 11 digitos y debe empezar por 311 o 601");

        log.info("Termina proceso de creación del paciente");
        return pacienteRepository.save(paciente);

    } 

    @Transactional
    public PacienteEntity AsociarAcudiente(PacienteEntity paciente, PacienteEntity acudiente, HistoriaClinicaEntity historiaClinica)throws IllegalOperationException{
        log.info("Inicia proceso de asociar acudiente al paciente");
        if (paciente.getAcudiente()!=null)
            throw new IllegalOperationException("El paciente ya tiene un acudiente asociado");
        if (acudiente.getAcudiente()!=null)
            throw new IllegalOperationException("El acudiente no puede tener un acudiente asociado");
        if (acudiente.getHistoriaClinica()==null)     
            throw new IllegalOperationException("El acudiente debe tener al menos una historia clínica creada");
        
        paciente.setAcudiente(acudiente);
        log.info("Termina proceso de asociar acudiente al paciente");
        return pacienteRepository.save(paciente);
    }
}