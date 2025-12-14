package pedidos;

public class PedidoEspecial extends Pedido{
    private Double descontoEspecial;

    public Double aplicarDesconto(Double valor) {
        return descontoEspecial * valor;
    }
    public Double getDescontoEspecial() {
        return descontoEspecial;
    }
    public void setDescontoEspecial(Double descontoEspecial) {
        this.descontoEspecial = descontoEspecial;
    }
}
