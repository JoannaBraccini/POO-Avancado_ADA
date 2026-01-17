package services;

import excecao.ContratoInvalidoException;
import modelos.contratos.Contrato;
import repository.interfaces.ContratoRepository;

public class ContratoService {

    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public void salvarContrato(Contrato contrato){
        try {
            if(contrato == null) {
                throw new ContratoInvalidoException(contrato);
            }
            contratoRepository.salvar(contrato);
        } catch (ContratoInvalidoException e){
            System.out.println("Erro ao salvar contrato: " + e.getMessage());
        }
    }
}
