package contoso.gasolinera.contoso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import contoso.gasolinera.contoso.models.Producto;
import contoso.gasolinera.contoso.services.ProductoService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

   private final ProductoService productoService;

   @GetMapping()
   public ResponseEntity<Producto> getMethodName(@RequestBody ProductoRequest productoRequest) {
      Producto producto = productoService.getByTipo(productoRequest.getEstacionId(),
            productoRequest.getTipoCombustible());
      return ResponseEntity.ok(producto);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Producto> putMethodName(@PathVariable Long id, @RequestBody Producto entity) {
      return ResponseEntity.ok(productoService.updatePrecio(id, entity));
   }

   @Data
   @Builder
   @NoArgsConstructor
   @AllArgsConstructor
   private static class ProductoRequest {
      private Long estacionId;
      private String tipoCombustible;
   }

}
