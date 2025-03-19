package contoso.gasolinera.contoso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import contoso.gasolinera.contoso.models.Surtidor;
import contoso.gasolinera.contoso.services.SurtidorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/surtidores")
@RequiredArgsConstructor
public class SurtidorController {

   private final SurtidorService surtidorService;

   @PostMapping()
   public ResponseEntity<Surtidor> create(@RequestBody Surtidor surtidor) {
      return ResponseEntity.ok(surtidorService.create(surtidor));
   }

   @PutMapping("/{id}")
   public ResponseEntity<Surtidor> update(@PathVariable Long id, @RequestBody Surtidor surtidor) {
      return ResponseEntity.ok(surtidorService.update(id, surtidor));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Surtidor> delete(@PathVariable Long id) {
      surtidorService.delete(id);
      return ResponseEntity.noContent().build();
   }
}
