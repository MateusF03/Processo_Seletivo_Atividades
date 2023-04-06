package processoseletivo;

import java.util.HashMap;
import java.util.Map;

public class Atividade4 {

    private static final Map<String, Double> faturamentoMental = new HashMap<>();
    static {
        faturamentoMental.put("SP", 67836.43);
        faturamentoMental.put("RJ", 36678.66);
        faturamentoMental.put("MG", 29229.88);
        faturamentoMental.put("ES", 27165.48);
        faturamentoMental.put("Outros", 19849.53);
    }
    public static void main(String[] args) {
        double valorTotal = 0.0;
        for (double valor : faturamentoMental.values()) {
            valorTotal += valor;
        }
        System.out.println("Valor total: " + valorTotal);
        for (Map.Entry<String, Double> entry : faturamentoMental.entrySet()) {
            String dist = entry.getKey();
            double valor = entry.getValue();
            double percentual = (valor / valorTotal) * 100;
            System.out.println("O valor percentual de \"" + dist + "\" é: " + String.format("%.2f", percentual) + "%");
        }
    }
}
