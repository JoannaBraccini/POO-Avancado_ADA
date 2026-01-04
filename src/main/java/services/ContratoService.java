package services;

import modelos.contratos.Contrato;
import repository.interfaces.ContratoRepository;

public class ContratoService {

    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public void salvarContrato(Contrato contrato){
        contratoRepository.salvar(contrato);
    }
}
