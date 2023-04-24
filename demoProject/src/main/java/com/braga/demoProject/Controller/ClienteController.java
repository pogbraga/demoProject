package com.braga.demoProject.controller;

import com.braga.demoProject.model.Cliente;
import com.braga.demoProject.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/cadastrar")
    @RolesAllowed("ADMIN")
    public void cadastrarCliente(@RequestParam String nome,
                                 @RequestParam Integer numero,
                                 @RequestParam String endereco){
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setNumero(numero);
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @GetMapping("/buscar")
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }
}
