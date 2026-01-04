package services;

import modelos.pagamentos.interfaces.Pagamento;

public class PagamentoService {

    public void processarPagamento(Pagamento pagamento) {
        pagamento.processarPagamento();
    }
}
