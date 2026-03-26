import java.util.ArrayList;
import java.util.List;

public class Banco {
    private final List<Conta> contas;
    private long transacoes;

    public Banco(int quantidadeContas, long saldoInicialCentavos) {
        contas = new ArrayList<>();
        for (int i = 0; i < quantidadeContas; i++) {
            contas.add(new Conta(saldoInicialCentavos));
        }
    }

    public synchronized void transferencia(int contaDebito, int contaCredito, long valorCentavos) {
        contas.get(contaDebito).saque(valorCentavos);
        contas.get(contaCredito).deposito(valorCentavos);
        transacoes++;
    }

    public synchronized long getSaldoTotalCentavos() {
        long saldoTotal = 0;
        for (Conta conta : contas) {
            saldoTotal += conta.getSaldoCentavos();
        }
        return saldoTotal;
    }

    public synchronized long getTransacoes() {
        return transacoes;
    }
}