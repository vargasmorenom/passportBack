package com.apiRest.passport.services;

import com.apiRest.passport.models.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    public Cliente obtenerCliente(String tipoDocumento, String numeroDocumento) {
        if ("C".equals(tipoDocumento) && "23445322".equals(numeroDocumento)) {
            Cliente cliente = new Cliente();
            cliente.setPrimerNombre("Juan");
            cliente.setSegundoNombre("Carlos");
            cliente.setPrimerApellido("Pérez");
            cliente.setSegundoApellido("Gómez");
            cliente.setTelefono("555-1234");
            cliente.setDireccion("Calle Falsa 123");
            cliente.setCiudadResidencia("Bogotá");
            return cliente;
        }
        return null; // Si no es el cliente mockeado, devuelve null
    }
}