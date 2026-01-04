package modelos.pagamentos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import modelos.pagamentos.interfaces.Pagamento;
import modelos.pagamentos.interfaces.Parcelavel;

@Getter
@Setter
@AllArgsConstructor
public class PagamentoCartao implements Pagamento, Parcelavel {

    @Override
    public void processarPagamento() {
        System.out.println("Pagamento com cartão processado com sucesso!");
    }

    @Override
    public void parcelarPagamento(Integer numeroParcelas) {

        if(numeroParcelas > 1) {
            System.out.println("Pagamento parcelado em " + numeroParcelas + " vezes.");
        } else {
            System.out.println("Pagamento à vista.");
        }
    }
}
