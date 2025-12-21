package modelos.pagamentos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PagamentoCartao implements Pagamento{
    private int numeroParcelas;

    @Override
    public void processarPagamento() {
        System.out.println("Pagamento com cartão processado com sucesso!");

        if(numeroParcelas > 1) {
            System.out.println("Pagamento parcelado em " + numeroParcelas + " vezes.");
        } else {
            System.out.println("Pagamento à vista.");
        }
    }
}
