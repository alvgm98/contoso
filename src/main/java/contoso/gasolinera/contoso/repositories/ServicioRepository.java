package contoso.gasolinera.contoso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import contoso.gasolinera.contoso.models.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

   @Query("SELECT s FROM Servicio s JOIN s.tanque t JOIN t.estacion e WHERE e.id = ?1")
   List<Servicio> findAllByEstacionId(Long estacionId);
}
