package mariangelamarasciuolo.BlogdayOne.controllers;

import mariangelamarasciuolo.BlogdayOne.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.UtenteService;

import java.util.List;

@RestController
@RequestMapping("/utente")
public class UtenteController {
@Autowired
private UtenteService utenteService;
    @GetMapping("")
    public List<Utente> getUtente(){
       return utenteService.getUtente();
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public Utente saveUtente(@RequestBody Utente body){
        return utenteService.save(body);
    }
}
