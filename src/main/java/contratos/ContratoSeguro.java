package contratos;

public class ContratoSeguro extends Contrato{
    private double valorSeguro;
    private String riscoSeguro;

    public ContratoSeguro() {
        super();
    }

    @Override
    public void assinar() {
        System.out.println("Contrato de seguro assinado!");
    }
    @Override
    public void cancelar() {
        System.out.println("Contrato de seguro cancelado!");
    }
}
