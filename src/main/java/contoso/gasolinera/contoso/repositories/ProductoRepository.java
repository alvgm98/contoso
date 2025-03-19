package contoso.gasolinera.contoso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import contoso.gasolinera.contoso.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

   @Query("SELECT p FROM Producto p JOIN Tanque t ON p.id = t.producto.id WHERE t.estacion.id = :estacionId AND p.tipoCombustible = :tipoCombustible")
   Producto findByEstacionIdAndTipoCombustible(@Param("estacionId") Long estacionId, @Param("tipoCombustible") String tipoCombustible);
}