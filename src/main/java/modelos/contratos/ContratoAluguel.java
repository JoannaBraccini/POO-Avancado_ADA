package modelos.contratos;

import enums.Acao;
import lombok.ToString;
import modelos.pessoas.GerenciadorPessoas;

import java.util.List;
@ToString
public class ContratoAluguel extends Contrato implements GerenciadorPessoas {
    private final String endereco;
    private final String tipoMoradia;

    public ContratoAluguel(String endereco, String tipoMoradia, List<String> pessoasEnvolvidas) {
        super(pessoasEnvolvidas);
        this.endereco = endereco;
        this.tipoMoradia = tipoMoradia;
    }

    @Override
    public void executarAcao(Acao acao) {
        System.out.println("Ação " + acao.getValor() + " para o contrato de aluguel " + numeroContrato + " executada. Interessados: " + pessoasEnvolvidas);
    }

    @Override
    public void adicionarPessoas(String novaPessoa) {
        this.pessoasEnvolvidas.add(novaPessoa);
    }
}
