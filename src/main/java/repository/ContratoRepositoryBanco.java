package repository;

import modelos.contratos.Contrato;
import repository.interfaces.ContratoRepository;

public class ContratoRepositoryBanco implements ContratoRepository {

    @Override
    public void salvar(Contrato contrato) {
        System.out.println("Contrato salvo no banco de dados: " + contrato);
    }
}
