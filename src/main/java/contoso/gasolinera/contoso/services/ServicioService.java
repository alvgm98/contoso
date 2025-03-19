package contoso.gasolinera.contoso.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contoso.gasolinera.contoso.models.Producto;
import contoso.gasolinera.contoso.models.Servicio;
import contoso.gasolinera.contoso.models.Tanque;
import contoso.gasolinera.contoso.repositories.ProductoRepository;
import contoso.gasolinera.contoso.repositories.ServicioRepository;
import contoso.gasolinera.contoso.repositories.TanqueRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioService {
   
   private final ServicioRepository servicioRepository;
   private final TanqueRepository tanqueRepository;
   private final ProductoRepository productoRepository;

   public List<Servicio> findAllByEstacionId(Long estacionId) {
      return servicioRepository.findAllByEstacionId(estacionId);
   }
   
   @Transactional
   public Servicio create(Servicio servicio) {
      Tanque tanque = tanqueRepository.findById(servicio.getTanque().getId()).orElseThrow();
      Producto producto = productoRepository.findById(tanque.getProducto().getId()).orElseThrow();

      // Reduzco la cantidad de combustible en el tanque
      tanque.setCantidad(tanque.getCantidad() - servicio.getCantidad());
      tanqueRepository.save(tanque);

      // Calculo el precio del servicio
      servicio.setPrecio(servicio.getCantidad() * producto.getPrecio());
      
      // Creo el servicio
      return servicioRepository.save(servicio);
   }
}
