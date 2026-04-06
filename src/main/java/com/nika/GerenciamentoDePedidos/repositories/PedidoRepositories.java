package com.nika.GerenciamentoDePedidos.repositories;

import com.nika.GerenciamentoDePedidos.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositories extends JpaRepository<PedidoModel, Long> {
}
