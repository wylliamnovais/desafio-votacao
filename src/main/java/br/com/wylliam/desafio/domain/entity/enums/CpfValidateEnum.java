package br.com.wylliam.desafio.domain.entity.enums;

public enum CpfValidateEnum {

    PODE_VOTAR("ABLE_TO_VOTE"),
    NAO_PODE_VOTAR("UNABLE_TO_VOTE");

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    CpfValidateEnum(String flag) {
        this.descricao = flag;
    }

    public static CpfValidateEnum valueOfDescricao(String valor) {
        for (CpfValidateEnum status : values()) {
            if (status.getDescricao().equals(valor)) {
                return status;
            }
        }
        return null;
    }
}
