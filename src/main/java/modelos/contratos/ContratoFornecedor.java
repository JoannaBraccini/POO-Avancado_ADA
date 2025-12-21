package modelos.contratos;

import enums.Acao;
import lombok.ToString;

import java.util.List;
@ToString
public class ContratoFornecedor extends Contrato{
    private final String cnpj;
    private final String nomeFantasia;

    public ContratoFornecedor(String cnpj,
                              String nomeFantasia,
                              List<String> pessoasEnvolvidas) {
        super(pessoasEnvolvidas);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }
    @Override
    public void executarAcao(Acao acao) {
        System.out.println("Ação " + acao.getValor() + " para o contrato de fornecedor " + nomeFantasia + " executada. Interessados: " + pessoasEnvolvidas);
    }
}
