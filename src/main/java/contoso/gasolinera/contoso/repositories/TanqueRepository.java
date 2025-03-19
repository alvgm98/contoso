package contoso.gasolinera.contoso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import contoso.gasolinera.contoso.models.Tanque;

public interface TanqueRepository extends JpaRepository<Tanque, Long> {
   @Query("SELECT t FROM Tanque t JOIN t.producto p WHERE t.estacion.id = :estacionId AND p.tipoCombustible = :tipoCombustible")
   Tanque findByEstacionIdAndTipoCombustible(@Param("estacionId") Long estacionId, @Param("tipoCombustible") String tipoCombustible);
}
