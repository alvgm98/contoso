package contoso.gasolinera.contoso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import contoso.gasolinera.contoso.models.Surtidor;

public interface SurtidorRepository extends JpaRepository<Surtidor, Long> {
   
}
