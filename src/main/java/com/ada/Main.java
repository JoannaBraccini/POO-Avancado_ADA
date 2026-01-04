package com.ada;

import enums.Acao;
import modelos.contratos.Contrato;
import modelos.contratos.ContratoSeguro;
import modelos.contratos.ContratoTrabalho;
import modelos.pagamentos.PagamentoBoleto;
import modelos.pagamentos.PagamentoCartao;
import modelos.pessoas.Pessoa;

import java.util.Arrays;
import java.util.List;

public class Main {
    /*public static void main(String[] args) {
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

        NotificadorContratos notificadorContratos = new NotificadorContratos();
        notificadorContratos.envioEmailConfirmacao(contratoAluguel);
        notificadorContratos.envioEmailCancelamento(contratoAluguel2);

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

    }*/ //Main testes de pedidos

    public static void main(String[] args) {
        gerenciaContratos();
        System.out.println("-=".repeat(30));
        gerenciaRescisaoContrato();
        System.out.println("-=".repeat(30));
        gerenciaPessoas();
//        System.out.println("-=".repeat(30));
//        gerenciaPagamentos();
        System.out.println("-=".repeat(30));
        gerenciaPagamentosParcelados();
    }

    private static void gerenciaPagamentosParcelados() {
        System.out.println("Serviço de Pagamentos Parcelados!");

        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
        PagamentoCartao pagamentoCartao = new PagamentoCartao();

        pagamentoBoleto.processarPagamento();
        pagamentoCartao.parcelarPagamento(10);

        pagamentoCartao.processarPagamento();//sem parcelamento
    }

//    public static void gerenciaPagamentos() {
//        System.out.println("Serviço de Pagamento!");
//
//        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
//        PagamentoCartao pagamentoCartao = new PagamentoCartao(6);
//
//        PagamentoService pagamentoService = new PagamentoService();
//        pagamentoService.processarPagamento(pagamentoBoleto);
//        pagamentoService.processarPagamento(pagamentoCartao);
//    }

    public static void gerenciaPessoas() {
        System.out.println("Serviço de pessoas!");
        Pessoa pessoa = new Pessoa("Joanna", "123.456.789-00");
        System.out.println(pessoa);
    }

    public static void gerenciaContratos() {
        System.out.println("Gerenciamento de contratos!");
        gerenciaAcaoContratos();
    }

    private static void gerenciaAcaoContratos() {
        System.out.println("Serviço de Ação de Contratos!");

        ContratoSeguro contratoSeguro = new ContratoSeguro(1500, List.of("Joanna, José"));

        executarAcaoContrato(contratoSeguro, Acao.ACT);
    }

    private static void executarAcaoContrato(Contrato contrato, Acao acaoContrato) {
        contrato.executarAcao(acaoContrato);
    }

    private static void gerenciaRescisaoContrato() {
        System.out.println("Serviço de Rescisão de Contratos!");

        ContratoTrabalho contratoTrabalho = new ContratoTrabalho(Arrays.asList("Gabriel", "Daniel"));

        contratoTrabalho.rescindirPorJustaCausa();
    }

}
