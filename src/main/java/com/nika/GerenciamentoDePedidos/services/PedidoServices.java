package com.nika.GerenciamentoDePedidos.services;

import com.nika.GerenciamentoDePedidos.model.PedidoModel;
import com.nika.GerenciamentoDePedidos.repositories.PedidoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServices {
    //private final PedidoRepositories repositories;

    //public PedidoServices(PedidoRepositories repositories) {
    //    this.repositories = repositories;
    //}

    @Autowired
    private PedidoRepositories repositories;

    public PedidoModel salvar(PedidoModel pedidos){
        return repositories.save(pedidos);
    }

    public List<PedidoModel> listar(){
        return repositories.findAll();
    }

    public PedidoModel atualizar(Long id, PedidoModel pedidoAtualizado){
        Optional<PedidoModel> pedidoExistente = repositories.findById(id);

        if(pedidoExistente.isPresent()){
            PedidoModel pedido = pedidoExistente.get();
            pedido.setData(pedidoAtualizado.getData());
            pedido.setValorTotal(pedidoAtualizado.getValorTotal());
            pedido.setStatus(pedidoAtualizado.getStatus());

            return  repositories.save(pedido);
        }else{
            throw new RuntimeException("Pedido não encontrado com id " + id);
        }
    }

    public PedidoModel buscar(Long id){
        return repositories.findById(id).orElse(null);
    }

    public void deletar(Long id){
        repositories.deleteById(id);
    }


}
