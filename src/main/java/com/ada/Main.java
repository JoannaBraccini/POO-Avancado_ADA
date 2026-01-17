package com.ada;

import enums.Acao;
import modelos.contratos.*;
import modelos.pagamentos.PagamentoBoleto;
import modelos.pagamentos.PagamentoCartao;
import modelos.pessoas.Pessoa;
import pedidos.ItemPedido;
import pedidos.Pedido;
import pedidos.PedidoEspecial;
import repository.ContratoRepositoryArquivo;
import repository.ContratoRepositoryBanco;
import repository.interfaces.ContratoRepository;
import repository.interfaces.ContratoValidator;
import services.ContratoService;
import services.PagamentoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
     * ========================================
     * TESTES ANTERIORES DE PEDIDOS E CONTRATOS
     * ========================================
     * Este código foi mantido como referência histórica do projeto.
     * Os testes ativos estão no método main() atual.
     *
    private static void testaPedidos() {
        System.out.println("🛒 TESTE: Gerenciamento de Pedidos");
        System.out.println();

        // Teste 1: Pedido normal
        System.out.println("✓ Teste 1: Criando pedido normal");
        Pedido pedido = new Pedido();
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setNomeItem("Panela");
        itemPedido.setValorItem(100.0);
        pedido.setNumeroPedido(1);
        pedido.setItensPedidoList(List.of(itemPedido));

        System.out.println("Pedido Nº: " + pedido.getNumeroPedido());
        System.out.println("Item: " + pedido.getItensPedidoList().getFirst().getNomeItem());
        System.out.println("Valor: R$ " + pedido.getItensPedidoList().getFirst().getValorItem());

        // Teste 2: Pedido especial com desconto
        System.out.println();
        System.out.println("✓ Teste 2: Criando pedido especial com desconto");
        PedidoEspecial pedidoEspecial = new PedidoEspecial();
        ItemPedido itemPedidoEspecial = new ItemPedido();
        pedidoEspecial.setDescontoEspecial(0.8); // 20% de desconto
        itemPedidoEspecial.setNomeItem("Panela Especial");
        // Aplica o desconto no valor do item já existente
        itemPedidoEspecial.setValorItem(pedidoEspecial.aplicarDesconto(itemPedido.getValorItem()));
        pedidoEspecial.setNumeroPedido(2);
        pedidoEspecial.setItensPedidoList(List.of(itemPedidoEspecial));

        System.out.println("Pedido Especial Nº: " + pedidoEspecial.getNumeroPedido());
        System.out.println("Item: " + pedidoEspecial.getItensPedidoList().getFirst().getNomeItem());
        System.out.println("Valor com desconto: R$ " + pedidoEspecial.getItensPedidoList().getFirst().getValorItem());
    }

    private static void testaContratosAntigo() {
        System.out.println("📄 TESTE: Contratos (Versão Antiga)");
        System.out.println();

        // Teste 1: Assinar contratos
        System.out.println("✓ Teste 1: Assinando contratos de aluguel e seguro");
        ContratoAluguel contratoAluguel = new ContratoAluguel();
        ContratoSeguro contratoSeguro = new ContratoSeguro();

        contratoAluguel.assinar();
        System.out.println("Contrato de aluguel nº: " + contratoAluguel.getNumeroContrato());
        contratoSeguro.assinar();
        System.out.println("Contrato de seguro nº: " + contratoSeguro.getNumeroContrato());

        // Teste 2: Cancelar contrato
        System.out.println();
        System.out.println("✓ Teste 2: Cancelando contrato de aluguel");
        ContratoAluguel contratoAluguel2 = new ContratoAluguel();
        contratoAluguel2.assinar();
        System.out.println("Contrato de aluguel nº: " + contratoAluguel2.getNumeroContrato());
        contratoAluguel2.cancelar();
        System.out.println("Contrato cancelado nº: " + contratoAluguel2.getNumeroContrato());

        // Teste 3: Notificações
        System.out.println();
        System.out.println("✓ Teste 3: Enviando notificações");
        NotificadorContratos notificadorContratos = new NotificadorContratos();
        notificadorContratos.envioEmailConfirmacao(contratoAluguel);
        notificadorContratos.envioEmailCancelamento(contratoAluguel2);
    }
    */

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("          DEMONSTRAÇÃO POO AVANÇADO - ADA ELAS+ TECH");
        System.out.println("=".repeat(60));
        System.out.println();

        testaAcoesContratos();
        imprimeSeparador();

        testaRescisaoContrato();
        imprimeSeparador();

        testaContratoAluguel();
        imprimeSeparador();

        testaContratoFornecedor();
        imprimeSeparador();

        testaNotificadorContratos();
        imprimeSeparador();

        testaPessoas();
        imprimeSeparador();

        testaPedidos();
        imprimeSeparador();

        testaPagamentosParcelados();
        imprimeSeparador();

        testaPagamentoService();
        imprimeSeparador();

        testaSalvarContratos();

        System.out.println();
        System.out.println("=".repeat(60));
        System.out.println("                  FIM DOS TESTES");
        System.out.println("=".repeat(60));
    }

    private static void imprimeSeparador() {
        System.out.println();
        System.out.println("-".repeat(60));
        System.out.println();
    }

    private static void testaSalvarContratos() {
        System.out.println("📋 TESTE: Salvar Contratos com Validação");
        System.out.println();

        // Instanciando o validador (usando classe anônima pois a interface tem método default)
        ContratoValidator validator = new ContratoValidator() {};

        // Preparando os repositórios e services
        ContratoRepository repositoryArquivo = new ContratoRepositoryArquivo();
        ContratoRepository repositoryBanco = new ContratoRepositoryBanco();
        ContratoService serviceBanco = new ContratoService(repositoryBanco, validator);
        ContratoService serviceArquivo = new ContratoService(repositoryArquivo, validator);

        // Teste 1: Contrato válido (3 ou mais pessoas)
        System.out.println("✓ Teste 1: Salvando contrato VÁLIDO (3 pessoas)");
        List<String> pessoas = Arrays.asList("Alice", "Bob", "Charlie");
        Contrato contratoValido = new ContratoTrabalho(pessoas);

        serviceBanco.salvarContrato(contratoValido);
        serviceArquivo.salvarContrato(contratoValido);

        // Teste 2: Contrato inválido (menos de 3 pessoas)
        System.out.println();
        System.out.println("✗ Teste 2: Tentando salvar contrato INVÁLIDO (2 pessoas)");
        Contrato contratoInvalido = new ContratoTrabalho(Arrays.asList("Alice", "Bill"));
        serviceBanco.salvarContrato(contratoInvalido);
        serviceArquivo.salvarContrato(contratoInvalido);
    }

    private static void testaPagamentosParcelados() {
        System.out.println("💳 TESTE: Pagamentos e Parcelamento");
        System.out.println();

        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
        PagamentoCartao pagamentoCartao = new PagamentoCartao();

        // Teste 1: Pagamento à vista com boleto
        System.out.println("✓ Teste 1: Processando pagamento com BOLETO");
        pagamentoBoleto.processarPagamento();

        // Teste 2: Parcelamento no cartão
        System.out.println();
        System.out.println("✓ Teste 2: Parcelando pagamento em 10x no CARTÃO");
        pagamentoCartao.parcelarPagamento(10);

        // Teste 3: Pagamento sem parcelamento no cartão
        System.out.println();
        System.out.println("✓ Teste 3: Processando pagamento com CARTÃO (sem parcelamento)");
        pagamentoCartao.processarPagamento();
    }

    private static void testaPagamentoService() {
        System.out.println("💰 TESTE: Pagamento Service (Polimorfismo)");
        System.out.println();

        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
        PagamentoCartao pagamentoCartao = new PagamentoCartao();

        PagamentoService pagamentoService = new PagamentoService();

        // Teste 1: Processando boleto através do service
        System.out.println("✓ Teste 1: Processando BOLETO via Service");
        pagamentoService.processarPagamento(pagamentoBoleto);

        // Teste 2: Processando cartão através do service
        System.out.println();
        System.out.println("✓ Teste 2: Processando CARTÃO via Service");
        pagamentoService.processarPagamento(pagamentoCartao);
    }

    private static void testaPessoas() {
        System.out.println("👤 TESTE: Gerenciamento de Pessoas");
        System.out.println();

        System.out.println("✓ Teste 1: Criando uma pessoa");
        Pessoa pessoa = new Pessoa("Joanna", "123.456.789-00");
        System.out.println("Pessoa criada: " + pessoa);
    }

    private static void testaAcoesContratos() {
        System.out.println("📝 TESTE: Ações de Contratos");
        System.out.println();

        System.out.println("✓ Teste 1: Executando ação ACEITAR em contrato de seguro");
        ContratoSeguro contratoSeguro = new ContratoSeguro(1500, List.of("Joanna", "José"));
        executarAcaoContrato(contratoSeguro, Acao.ACT);

        System.out.println();
        System.out.println("✓ Teste 2: Executando ação RECUSAR em contrato de trabalho");
        ContratoTrabalho contratoTrabalho = new ContratoTrabalho(Arrays.asList("Ana", "Carlos", "Maria"));
        executarAcaoContrato(contratoTrabalho, Acao.RCR);

        System.out.println();
        System.out.println("✓ Teste 3: Executando ação CANCELAR em contrato de seguro");
        executarAcaoContrato(contratoSeguro, Acao.CNL);
    }

    private static void executarAcaoContrato(Contrato contrato, Acao acaoContrato) {
        contrato.executarAcao(acaoContrato);
    }

    private static void testaRescisaoContrato() {
        System.out.println("⚖️ TESTE: Rescisão de Contratos");
        System.out.println();

        System.out.println("✓ Teste 1: Rescindindo contrato de trabalho por justa causa");
        ContratoTrabalho contratoTrabalho = new ContratoTrabalho(Arrays.asList("Gabriel", "Daniel"));

        contratoTrabalho.rescindirPorJustaCausa();
    }

    private static void testaContratoAluguel() {
        System.out.println("🏠 TESTE: Contrato de Aluguel");
        System.out.println();

        // Teste 1: Criar contrato de aluguel
        System.out.println("✓ Teste 1: Criando contrato de aluguel");
        List<String> inquilinos = new ArrayList<>(Arrays.asList("Maria", "João"));
        ContratoAluguel contratoAluguel = new ContratoAluguel(
                "Rua das Flores, 123",
                "Apartamento",
                inquilinos
        );
        System.out.println(contratoAluguel);

        // Teste 2: Adicionar nova pessoa ao contrato (GerenciadorPessoas)
        System.out.println();
        System.out.println("✓ Teste 2: Adicionando nova pessoa ao contrato");
        contratoAluguel.adicionarPessoas("Pedro");
        System.out.println(contratoAluguel);

        // Teste 3: Executar ação no contrato
        System.out.println();
        System.out.println("✓ Teste 3: Executando ação ACEITAR no contrato");
        contratoAluguel.executarAcao(Acao.ACT);
    }

    private static void testaContratoFornecedor() {
        System.out.println("🏢 TESTE: Contrato de Fornecedor");
        System.out.println();

        // Teste 1: Criar contrato de fornecedor
        System.out.println("✓ Teste 1: Criando contrato de fornecedor");
        ContratoFornecedor contratoFornecedor = new ContratoFornecedor(
                "12.345.678/0001-90",
                "Tech Solutions LTDA",
                Arrays.asList("Diretor Comercial", "Gerente de TI")
        );
        System.out.println(contratoFornecedor);

        // Teste 2: Executar ação no contrato
        System.out.println();
        System.out.println("✓ Teste 2: Executando ação ACEITAR no contrato");
        contratoFornecedor.executarAcao(Acao.ACT);

        // Teste 3: Cancelar contrato
        System.out.println();
        System.out.println("✓ Teste 3: Cancelando contrato de fornecedor");
        contratoFornecedor.executarAcao(Acao.CNL);
    }

    private static void testaNotificadorContratos() {
        System.out.println("📧 TESTE: Notificador de Contratos");
        System.out.println();

        NotificadorContratos notificador = new NotificadorContratos();

        // Teste 1: Notificação de confirmação
        System.out.println("✓ Teste 1: Enviando email de confirmação");
        ContratoSeguro contratoConfirmado = new ContratoSeguro(2000, Arrays.asList("Ana", "Bruno"));
        notificador.envioEmailConfirmacao(contratoConfirmado);

        // Teste 2: Notificação de cancelamento
        System.out.println();
        System.out.println("✓ Teste 2: Enviando email de cancelamento");
        ContratoTrabalho contratoCancelado = new ContratoTrabalho(Arrays.asList("Carlos", "Diana"));
        notificador.envioEmailCancelamento(contratoCancelado);
    }

    private static void testaPedidos() {
        System.out.println("🛒 TESTE: Gerenciamento de Pedidos");
        System.out.println();

        // Teste 1: Pedido normal
        System.out.println("✓ Teste 1: Criando pedido normal");
        Pedido pedido = new Pedido();
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setNomeItem("Panela");
        itemPedido.setValorItem(100.0);
        pedido.setNumeroPedido(1);
        pedido.setItensPedidoList(List.of(itemPedido));

        System.out.println("Pedido Nº: " + pedido.getNumeroPedido());
        System.out.println("Item: " + pedido.getItensPedidoList().getFirst().getNomeItem());
        System.out.println("Valor: R$ " + pedido.getItensPedidoList().getFirst().getValorItem());

        // Teste 2: Pedido especial com desconto
        System.out.println();
        System.out.println("✓ Teste 2: Criando pedido especial com 20% de desconto");
        PedidoEspecial pedidoEspecial = new PedidoEspecial();
        ItemPedido itemPedidoEspecial = new ItemPedido();
        pedidoEspecial.setDescontoEspecial(0.8); // 20% de desconto
        itemPedidoEspecial.setNomeItem("Panela Especial");
        // Aplica o desconto no valor do item
        itemPedidoEspecial.setValorItem(pedidoEspecial.aplicarDesconto(itemPedido.getValorItem()));
        pedidoEspecial.setNumeroPedido(2);
        pedidoEspecial.setItensPedidoList(List.of(itemPedidoEspecial));

        System.out.println("Pedido Especial Nº: " + pedidoEspecial.getNumeroPedido());
        System.out.println("Item: " + pedidoEspecial.getItensPedidoList().getFirst().getNomeItem());
        System.out.println("Valor com desconto: R$ " + pedidoEspecial.getItensPedidoList().getFirst().getValorItem());
    }

}
