package contoso.gasolinera.contoso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import contoso.gasolinera.contoso.models.Servicio;
import contoso.gasolinera.contoso.services.ServicioService;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/servicios")
@RequiredArgsConstructor
public class ServicioController {

   private final ServicioService servicioService;

   @GetMapping("/{estacionId}")
   public ResponseEntity<List<ServicioDto>> getAllServicios(@PathVariable Long estacionId) {
      List<Servicio> servicios = servicioService.findAllByEstacionId(estacionId);
      return ResponseEntity.ok(servicios.stream().map(this::toServicioDto).collect(Collectors.toList()));  
   }

   @PostMapping()
   public ResponseEntity<ServicioDto> createService(@RequestBody Servicio servicio) {
      Servicio createdServicio = servicioService.create(servicio);
      return ResponseEntity.ok(toServicioDto(createdServicio));
   }

   private ServicioDto toServicioDto(Servicio servicio) {
      return ServicioDto.builder()
            .Id(servicio.getId())
            .fecha(servicio.getFecha())
            .cantidad(servicio.getCantidad())
            .precio(servicio.getPrecio())
            .build();
   }

   @Data
   @Builder
   private static class ServicioDto {
      private Long Id;
      private LocalDateTime fecha;
      private Double cantidad;
      private Double precio;
   }
}
