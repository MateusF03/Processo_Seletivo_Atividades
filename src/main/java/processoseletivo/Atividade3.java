package processoseletivo;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Atividade3 {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final List<DiaFaturamento> faturamentos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File file = new File("faturamento.json");
        Atividade3 at;
        if (!file.exists()) {
            at = new Atividade3();
            String content = gson.toJson(at);
            Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8));
        } else {
            try (FileReader reader = new FileReader(file)) {
                at = gson.fromJson(reader, Atividade3.class);
            }
        }

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        DiaFaturamento faturamentoMax = null;
        DiaFaturamento faturamentoMin = null;
        double sum = 0.0;
        for (DiaFaturamento faturamento : at.faturamentos) {
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
        double avg = sum / at.faturamentos.size();
        int count = 0;
        for (DiaFaturamento faturamento : at.faturamentos) {
            if (faturamento.valor > avg) {
                count++;
            }
        }
        System.out.println("Menor faturamento: " + faturamentoMin + "\nMaior faturamento: " + faturamentoMax + "\nNúmero de dias no mês em que o valor de faturamento diário foi superior à média mensal: " + count);
    }

    private static class DiaFaturamento {
        private final Date data;
        private final double valor;

        public DiaFaturamento(Date data, double valor) {
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
