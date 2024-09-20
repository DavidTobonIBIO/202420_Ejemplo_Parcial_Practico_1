package co.edu.uniandes.dse.parcialprueba.repositories;

import co.edu.uniandes.dse.parcialprueba.entities.EspecialidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<EspecialidadEntity, Long> {

}
