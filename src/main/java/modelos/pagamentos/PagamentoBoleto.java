package modelos.pagamentos;

public class PagamentoBoleto implements Pagamento{
    @Override
    public void processarPagamento() {
        System.out.println("Boleto gerado com sucesso!");
    }
}
