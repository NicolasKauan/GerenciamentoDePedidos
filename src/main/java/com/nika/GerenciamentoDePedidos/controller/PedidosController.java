package com.nika.GerenciamentoDePedidos.controller;

import com.nika.GerenciamentoDePedidos.model.PedidoModel;
import com.nika.GerenciamentoDePedidos.repositories.PedidoRepositories;
import com.nika.GerenciamentoDePedidos.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidoServices services;
    @Autowired
    private PedidoRepositories pedidoRepositories;

    //201 foi criado, ta tudo certo
    @PostMapping
    public ResponseEntity<PedidoModel> criar(@RequestBody PedidoModel pedidos){
        PedidoModel salvo = services.salvar(pedidos);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidos);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<PedidoModel> atualizar(@PathVariable Long id, @RequestBody PedidoModel pedidoAtualizado){
        try{
            PedidoModel pedido = services.atualizar(id, pedidoAtualizado);
            return ResponseEntity.ok(pedido);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }

    }

    //200 ta aqui a sua lista
    @GetMapping
    public ResponseEntity<List<PedidoModel>> listar(){
        List<PedidoModel> pedidos = services.listar();
        return ResponseEntity.ok(pedidos);
    }

    //200 ta aqui o que tu ta procurando, 404 aqui ferrou
    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> buscar(@PathVariable Long id){
        try{
            PedidoModel pedidos = services.buscar(id);
            return ResponseEntity.ok(pedidos);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    //204 ta apagado chefe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        try{
            services.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
