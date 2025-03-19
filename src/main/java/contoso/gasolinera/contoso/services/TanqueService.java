package contoso.gasolinera.contoso.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contoso.gasolinera.contoso.models.Tanque;
import contoso.gasolinera.contoso.repositories.TanqueRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TanqueService {

   private final TanqueRepository tanqueRepository;

   public Tanque findById(Long id) {
      return tanqueRepository.findById(id).orElseThrow();
   }

   public Tanque findByTipoCombustible(Long idEstacion, String tipoCombustible) {
      return tanqueRepository.findByEstacionIdAndTipoCombustible(idEstacion, tipoCombustible);
   }

   @Transactional
   public Tanque update(Long id, Tanque tanqueActualizado) {
      tanqueActualizado.setId(id);
      return tanqueRepository.save(tanqueActualizado);
   }
}
