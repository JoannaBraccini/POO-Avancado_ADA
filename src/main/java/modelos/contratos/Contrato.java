package modelos.contratos;

import enums.Acao;

import java.util.List;

public abstract class Contrato {
    private static int contadorContratos = 0;
    protected Integer numeroContrato;
    protected List<String> pessoasEnvolvidas;

    public Contrato(List<String> pessoasEnvolvidas) {
        this.numeroContrato = ++contadorContratos;
        this.pessoasEnvolvidas = pessoasEnvolvidas;
    }

    public abstract void executarAcao(Acao acao);
   }
