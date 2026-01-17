package excecao;

import modelos.contratos.Contrato;

public class ContratoInvalidoException extends RuntimeException{
    public ContratoInvalidoException(Contrato contrato) {
        super(String.format("[ERRO] Contrato inválido! Dados: " + contrato));
    }
}
