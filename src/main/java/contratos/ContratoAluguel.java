package contratos;

public class ContratoAluguel extends Contrato{
    private String endereco;
    private String tipoMoradia;

    public ContratoAluguel() {
        super();
    }

    @Override
    public void assinar() {
        System.out.println("Contrato de aluguel assinado!");
    }
    @Override
    public void cancelar() {
        System.out.println("Contrato de aluguel cancelado!");
    }
}
