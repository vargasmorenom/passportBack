package com.apiRest.passport.controller;

import com.apiRest.passport.models.Cliente;
import com.apiRest.passport.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/consulta")
    public ResponseEntity<?> consultarCliente(
            @RequestParam String tipoDocumento,
            @RequestParam String numeroDocumento) {

        // Validación de tipo de documento
        if (!"C".equals(tipoDocumento) && !"P".equals(tipoDocumento)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Tipo de documento inválido. Use 'C' para cédula o 'P' para pasaporte.");
        }

        // Obtener el cliente mockeado
        Cliente cliente = clienteService.obtenerCliente(tipoDocumento, numeroDocumento);

        // Si no se encuentra el cliente
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente no encontrado.");
        }

        // Respuesta exitosa con el cliente encontrado
        return ResponseEntity.ok(cliente);
    }
}
