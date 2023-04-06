package processoseletivo;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Atividade3 {

    public static void main(String[] args) throws IOException {
        File file = new File("dados.json");
        List<DiaFaturamento> faturamentos = new ArrayList<>();
        try (FileReader reader = new FileReader(file)) {
            JsonArray array = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement element : array) {
                JsonObject object = element.getAsJsonObject();
                faturamentos.add(new DiaFaturamento(object.get("dia").getAsInt(), object.get("valor").getAsDouble()));
            }
        }

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        DiaFaturamento faturamentoMax = null;
        DiaFaturamento faturamentoMin = null;
        double sum = 0.0;
        for (DiaFaturamento faturamento : faturamentos) {
            sum += faturamento.valor;
            if (faturamento.valor < min) {
                faturamentoMin = faturamento;
                min = faturamentoMin.valor;
            }
            if (faturamento.valor > max) {
                faturamentoMax = faturamento;
                max = faturamentoMax.valor;
            }
        }
        double avg = sum / faturamentos.size();
        int count = 0;
        for (DiaFaturamento faturamento : faturamentos) {
            if (faturamento.valor > avg) {
                count++;
            }
        }
        System.out.println("Menor faturamento: " + faturamentoMin + "\nMaior faturamento: " + faturamentoMax + "\nNúmero de dias no mês em que o valor de faturamento diário foi superior à média mensal: " + count);
    }

    private static class DiaFaturamento {
        private final int data;
        private final double valor;

        public DiaFaturamento(int data, double valor) {
            this.data = data;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "DiaFaturamento{" +
                    "data=" + data +
                    ", valor=" + valor +
                    '}';
        }
    }
}
