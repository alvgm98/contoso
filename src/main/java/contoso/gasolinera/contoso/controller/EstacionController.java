package contoso.gasolinera.contoso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import contoso.gasolinera.contoso.models.Estacion;
import contoso.gasolinera.contoso.services.EstacionService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/estaciones")
@RequiredArgsConstructor
public class EstacionController {

    private final EstacionService estacionService;

    @GetMapping("/{id}")
    public ResponseEntity<Estacion> getMethodName(@PathVariable Long id) {
        return ResponseEntity.ok(estacionService.findById(id));
    }

}
