package co.edu.uniandes.dse.parcialprueba.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import jakarta.transaction.Transactional;

@Slf4j
@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Transactional
    public MedicoEntity createMedico(MedicoEntity medico) throws IllegalOperationException {
        log.info("Incia proceso de creacion de un medico");
        // El registro debe empezar con los caracteres "RM"
        if (!medico.getRegistroMedico().substring(0, 2).equals("RM")) {
            throw new IllegalOperationException("El registro medico debe empezar con RM");
        }
        return medicoRepository.save(medico);
    }
}
