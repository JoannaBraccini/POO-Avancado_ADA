package contratos;

public class NotificadorContratos {
    public void envioEmailConfirmacao(Contrato contrato) {
        System.out.println("Enviando e-mail de confirmação do contrato: " + contrato.getNumeroContrato());
    }
    public void envioEmailCancelamento(Contrato contrato) {
        System.out.println("Enviando e-mail de cancelamento do contrato: " + contrato.getNumeroContrato());
    }
}
