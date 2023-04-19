package com.braga.demoProject.Controller;
import com.braga.demoProject.Model.Cliente;
import com.braga.demoProject.Repository.ClienteRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @PostMapping("/cadastrar")
    @Transactional
    public String cadastrarCliente(@RequestParam String nome,
                                   @RequestParam Integer numero,
                                   @RequestParam String endereco){
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setNumero(numero);
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
        return "Cliente cadastrado com sucesso!";
    }

    @GetMapping("/buscar")
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }
}
