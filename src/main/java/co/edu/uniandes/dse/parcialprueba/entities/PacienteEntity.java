package co.edu.uniandes.dse.parcialprueba.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity 
public class PacienteEntity {
    private String nombre;
    private String correo;
    private String telefono;

    @PodamExclude
    @ManyToOne
    private HistoriaClinicaEntity historiaClinica;

    @PodamExclude
    @OneToOne
    private PacienteEntity acudiente;
}
