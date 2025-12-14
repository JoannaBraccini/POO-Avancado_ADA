package contratos;

import java.util.List;

public abstract class Contrato {
    private static int contadorNumeroContrato = 0;
    private Integer numeroContrato;
    private List<String> pessoasEnvolvidas;

    public Contrato() {
        this.numeroContrato = ++contadorNumeroContrato;
    }

    public abstract void assinar();
    public abstract void cancelar();

    public Integer getNumeroContrato() {
        return numeroContrato;
    }
    public void setNumeroContrato(Integer numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public List<String> getPessoasEnvolvidas() {
        return pessoasEnvolvidas;
    }
    public void setPessoasEnvolvidas(List<String> pessoasEnvolvidas) {
        this.pessoasEnvolvidas = pessoasEnvolvidas;
    }
}
