package com.braga.demoProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClienteController {

    private ClienteRepository clienteRepository;
    @PostMapping("/cadastrar")
    public String cadastrarCliente(@RequestParam Integer id,
                                   @RequestParam String nome,
                                   @RequestParam Integer numero,
                                   @RequestParam String endereco){
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setNumero(numero);
        cliente.setEndereco(endereco);
        ClienteRepository.saveCliente(cliente);
        return "Cliente cadastrado com sucesso!";
    }
    @GetMapping("/buscar")
    public static String buscarCliente(@RequestParam String nome){
        String resultado = ClienteRepository.getClienteByNome(nome);
        return  resultado;
    }
}
