package co.edu.uniandes.dse.parcialprueba.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoEspecialidadService {

    @Autowired
    EspecialidadRepository especialidadRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Transactional
    public EspecialidadEntity addEspecialidad(Long medicoId, Long especilidadId) throws EntityNotFoundException {
        log.info("Inicia proceso de agregar una especialidad a un medico");
        Optional<MedicoEntity> medicoEntity = medicoRepository.findById(medicoId);
        Optional<EspecialidadEntity> especialidadEntity = especialidadRepository.findById(especilidadId);

        if (medicoEntity.isEmpty()) {
            throw new EntityNotFoundException("El medico con id = " + medicoId + " no existe");
        }
        if (especialidadEntity.isEmpty()) {
            throw new EntityNotFoundException("La especialidad con id = " + especilidadId + " no existe");
        }

        especialidadEntity.get().getMedicos().add(medicoEntity.get());
        return especialidadEntity.get();
    }

}
