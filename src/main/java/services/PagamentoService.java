package services;

import modelos.pagamentos.Pagamento;

public class PagamentoService {

    public void processarPagamento(Pagamento pagamento) {
        pagamento.processarPagamento();
    }
}
