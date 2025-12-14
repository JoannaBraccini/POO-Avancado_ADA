package pedidos;

import java.util.List;

public class Pedido {
    private Integer numeroPedido;
//    Na composição o itemPedido é dependente do pedido
    private List<ItemPedido> itensPedidoList;

    public Integer getNumeroPedido() {
        return numeroPedido;
    }
    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    public List<ItemPedido> getItensPedidoList() {
        return itensPedidoList;
    }
    public void setItensPedidoList(List<ItemPedido> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }
}
