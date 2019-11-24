package br.com.ktrak.Utils;

public abstract class EstadoUtil {
    public static String getBySigla(String sigla) {
        switch (sigla) {
            case "RJ":
                return "Rio de Janeiro";
            case "ES":
                return "Espirito Santos";
            case "SP":
                return "São Paulo";
            case "MG":
                return "Minas Gerais";
            default:
                throw new IllegalArgumentException("Não foi possível encontrar o estado");
        }
    }
}
