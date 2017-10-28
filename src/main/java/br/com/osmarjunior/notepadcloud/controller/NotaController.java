package br.com.osmarjunior.notepadcloud.controller;

import br.com.osmarjunior.notepadcloud.component.NotaComponent;
import br.com.osmarjunior.notepadcloud.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "nota")
public class NotaController {

    @Autowired
    public NotaComponent notaComponent;

    @GetMapping("/titulo/{titulo}")
    public Nota buscarNota(@PathVariable(value = "titulo") String titulo){
        return notaComponent.buscarNota(titulo);
    }

    @GetMapping()
    public List<Nota> buscarTodos(){
        return notaComponent.findAll();
    }

    @DeleteMapping("/titulo/{titulo}")
    public void apagar(@PathVariable(value = "titulo") String titulo){
        notaComponent.apagar(titulo);
    }

    @DeleteMapping()
    public void apagarTodos(){
        notaComponent.deleteAll();
    }

    @PostMapping
    public void salvar(@RequestBody Nota nota){
        notaComponent.salvar(nota);
    }
}
