package modelos.contratos;

import enums.Acao;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Contrato {
    private static int contadorContratos = 0;
    protected Integer numeroContrato;
    protected List<String> pessoasEnvolvidas;

    public Contrato(List<String> pessoasEnvolvidas) {
        this.numeroContrato = ++contadorContratos;
        this.pessoasEnvolvidas = new ArrayList<>(pessoasEnvolvidas);
    }

    public abstract void executarAcao(Acao acao);
}
