package contoso.gasolinera.contoso.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contoso.gasolinera.contoso.models.Producto;
import contoso.gasolinera.contoso.repositories.ProductoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

   private final ProductoRepository productoRepository;

   public Producto getByTipo(Long estacionId, String tipoCombustible) {
      return productoRepository.findByEstacionIdAndTipoCombustible(estacionId, tipoCombustible);
   }

   @Transactional
   public Producto updatePrecio(Long id, Producto productoActualizado) {
      Producto producto = productoRepository.findById(id).orElseThrow();
      producto.setPrecio(productoActualizado.getPrecio());
      return productoRepository.save(producto);
   }
}
