package modelos.pagamentos;

import modelos.pagamentos.interfaces.Pagamento;

public class PagamentoBoleto implements Pagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Boleto gerado com sucesso!");
    }
}
