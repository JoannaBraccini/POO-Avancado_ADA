package modelos.contratos;

import enums.Acao;
import lombok.ToString;

import java.util.List;

@ToString
public class ContratoSeguro extends Contrato{
    private final double valorSeguro;
    private String riscoSeguro;

    public ContratoSeguro(double valorSeguro, List<String> pessoasEnvolvidas) {
        super(pessoasEnvolvidas);
        this.valorSeguro = valorSeguro;
    }

    @Override
    public void executarAcao(Acao acao) {
        System.out.println("Ação " + acao.getValor() + " para o contrato seguro " + numeroContrato + " executada. Interessados: " + pessoasEnvolvidas);
    }
}
