package co.edu.uniandes.dse.parcialprueba.repositories;

import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {

}
