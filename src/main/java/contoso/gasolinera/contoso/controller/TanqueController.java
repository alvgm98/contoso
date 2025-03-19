package contoso.gasolinera.contoso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import contoso.gasolinera.contoso.models.Tanque;
import contoso.gasolinera.contoso.services.TanqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tanques")
@RequiredArgsConstructor
public class TanqueController {

   private final TanqueService tanqueService;

   @GetMapping("/{id}")
   public ResponseEntity<Tanque> getTangueById(@PathVariable Long id) {
      Tanque tanque = tanqueService.findById(id);
      return ResponseEntity.ok(tanque);
   }

   @GetMapping()
   public ResponseEntity<Tanque> getTangueByTipoCombustible(@RequestParam String tipoCombustible, @RequestParam Long idEstacion) {
      Tanque tanque = tanqueService.findByTipoCombustible(idEstacion, tipoCombustible);
      return ResponseEntity.ok(tanque);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Tanque> rellenarTanque(@PathVariable Long id, @RequestBody Tanque tanque) {
      return ResponseEntity.ok(tanqueService.update(id, tanque));
   }
}
