package services;

import excecao.ContratoInvalidoException;
import modelos.contratos.Contrato;
import repository.interfaces.ContratoRepository;
import repository.interfaces.ContratoValidator;

public class ContratoService {

    private final ContratoRepository contratoRepository;
    private final ContratoValidator contratoValidator;

    public ContratoService(ContratoRepository contratoRepository, ContratoValidator contratoValidator) {
        this.contratoRepository = contratoRepository;
        this.contratoValidator = contratoValidator;
    }

    public void salvarContrato(Contrato contrato){
        try {
            contratoValidator.validarContrato(contrato);
            contratoRepository.salvar(contrato);
        } catch (ContratoInvalidoException e){
            System.out.println("Erro ao salvar contrato: " + e.getMessage());
        }
    }
}
