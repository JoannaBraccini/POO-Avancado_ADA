package com.ada;

import contratos.ContratoAluguel;
import contratos.ContratoSeguro;
import pedidos.ItemPedido;
import pedidos.Pedido;
import pedidos.PedidoEspecial;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("==== Contratos ====");

        ContratoAluguel contratoAluguel = new ContratoAluguel();
        ContratoSeguro contratoSeguro = new ContratoSeguro();

        contratoAluguel.assinar();
        System.out.println("Contrato de aluguel nº: " + contratoAluguel.getNumeroContrato());
        contratoSeguro.assinar();
        System.out.println("Contrato de seguro nº: " + contratoSeguro.getNumeroContrato());

        ContratoAluguel contratoAluguel2 = new ContratoAluguel();
        contratoAluguel2.assinar();
        System.out.println("Contrato de aluguel nº: " + contratoAluguel2.getNumeroContrato());
        contratoAluguel2.cancelar();
        System.out.println("Contrato de aluguel nº: " + contratoAluguel2.getNumeroContrato());

        System.out.println();
        System.out.println("==== Pedidos ====");

        Pedido pedido = new Pedido();
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setNomeItem("Panela");
        itemPedido.setValorItem(100.0);
        pedido.setNumeroPedido(1);
        pedido.setItensPedidoList(List.of(itemPedido));

        System.out.println("Pedido Nº: " + pedido.getNumeroPedido());
        System.out.println("Itens do pedido: " + pedido.getItensPedidoList().getFirst().getNomeItem());
        System.out.println("Valor do pedido: " + pedido.getItensPedidoList().getFirst().getValorItem());
        System.out.println();

        PedidoEspecial pedidoEspecial = new PedidoEspecial();
        ItemPedido itemPedidoEspecial = new ItemPedido();
        pedidoEspecial.setDescontoEspecial(0.8);
        itemPedidoEspecial.setNomeItem("Panela Especial");
//        Aplica o desconto no valor do item já existente
        itemPedidoEspecial.setValorItem(pedidoEspecial.aplicarDesconto(
                itemPedido.getValorItem()
        ));
        pedidoEspecial.setNumeroPedido(2);
        pedidoEspecial.setItensPedidoList(List.of(itemPedidoEspecial));

        System.out.println("Pedido Especial Nº: " + pedidoEspecial.getNumeroPedido());
        System.out.println("Itens do pedido especial: " + pedidoEspecial.getItensPedidoList().getFirst().getNomeItem());
        System.out.println("Valor do pedido especial: " + pedidoEspecial.getItensPedidoList().getFirst().getValorItem());

    }
}
