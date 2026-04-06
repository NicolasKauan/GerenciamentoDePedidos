package com.nika.GerenciamentoDePedidos.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "ProdutosModel")
@Table(name = "tb_pedidos")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DataHoraPedido")
    private LocalDateTime data;

    @Column(name = "ValorTotalPedido")
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "StatusPedido")
    private PedidoEnum status;

    public PedidoEnum getStatus() {
        return status;
    }

    public void setStatus(PedidoEnum status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

}
