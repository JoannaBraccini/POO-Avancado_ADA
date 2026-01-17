package repository.interfaces;

import excecao.ContratoInvalidoException;
import modelos.contratos.Contrato;

public interface ContratoValidator {
    default void validarContrato(Contrato contrato) throws ContratoInvalidoException {
        if (contrato == null || contrato.getPessoasEnvolvidas().size() < 3) {
            throw new ContratoInvalidoException("Contrato inválido!", contrato);
        }    }
}
