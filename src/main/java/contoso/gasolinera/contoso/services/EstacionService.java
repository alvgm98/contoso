package contoso.gasolinera.contoso.services;

import org.springframework.stereotype.Service;

import contoso.gasolinera.contoso.models.Estacion;
import contoso.gasolinera.contoso.repositories.EstacionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstacionService {
   
   private final EstacionRepository estacionRepository;

   public Estacion findById(Long id) {
      return estacionRepository.findById(id).orElseThrow();
   }
}
