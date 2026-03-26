public class Conta {
    private long saldoCentavos;

    public Conta(long saldoInicialCentavos) {
        this.saldoCentavos = saldoInicialCentavos;
    }

    public void deposito(long valorCentavos) {
        saldoCentavos += valorCentavos;
    }

    public void saque(long valorCentavos) {
        saldoCentavos -= valorCentavos;
    }

    public long getSaldoCentavos() {
        return saldoCentavos;
    }
}