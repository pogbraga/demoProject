package com.braga.demoProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CadastrarCliente {
    @GetMapping("/cadastrar")
    public String cadastrarCliente(@RequestParam String[] dadosCliente){
        String message;
        if (dadosCliente.length != 3){
            message = "Cliente não cadastrado, favor checar quantidade de dados informados";
        }
        else message = "Cliente cadastrado!";

        return message;
    }
}
