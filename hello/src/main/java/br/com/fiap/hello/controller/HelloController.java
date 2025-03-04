package br.com.fiap.hello.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    //private String nome = "Arthur";

    @GetMapping
    public ResponseEntity<String> getHello(@RequestParam String nome){

        String response =  "Hello - " + nome + " - Application ResFull";
        return ResponseEntity.ok(response);
    }
}
