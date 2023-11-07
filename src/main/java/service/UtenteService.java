package service;

import mariangelamarasciuolo.BlogdayOne.entities.Utente;
import mariangelamarasciuolo.BlogdayOne.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UtenteService {
    private List<Utente> utente =new ArrayList<>();
    public Utente save(Utente body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 1000));
        this.utente.add(body);
        return body;
    }
    public List<Utente> getUtente() {
        return this.utente;
    }

    public Utente findById(int id) {
        Utente u = null;
        for (Utente utente: this.utente){
            if(utente.getId() == id ){
                u = utente;
            }
        }
        if(u == null ){
            throw new NotFoundException(id);
        } else {
            return u;
        }
    }

}
