package contoso.gasolinera.contoso.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contoso.gasolinera.contoso.models.Surtidor;
import contoso.gasolinera.contoso.repositories.SurtidorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SurtidorService {

   private final SurtidorRepository surtidorRepository;

   @Transactional
   public Surtidor create(Surtidor surtidor) {
      return surtidorRepository.save(surtidor);
   }

   @Transactional
   public Surtidor update(Long id, Surtidor surtidorActualizado) {
      Surtidor surtidor = surtidorRepository.findById(id).orElseThrow();
      surtidor.setEstado(surtidorActualizado.getEstado());
      surtidor.setNumero(surtidorActualizado.getNumero());
      return surtidorRepository.save(surtidor);
   }

   @Transactional
   public void delete(Long id) {
      surtidorRepository.deleteById(id);
   }
}
