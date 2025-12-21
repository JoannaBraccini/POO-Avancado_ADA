package enums;

import lombok.Getter;

@Getter
public enum Acao {
    ACT("Aceitar"), RCR("Recusar"), CNL("Cancelar");

    private final String valor;

    Acao(String valor) {
        this.valor = valor;
    }
}
