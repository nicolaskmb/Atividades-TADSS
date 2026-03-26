import java.util.Random;

public class Movimento extends Thread {
    private final Banco banco;
    private final Random random;

    public Movimento(Banco banco) {
        this.banco = banco;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int contaDebito = random.nextInt(100);
            int contaCredito = random.nextInt(100);
            long valorCentavos = random.nextInt(250_000) + 1L;
            banco.transferencia(contaDebito, contaCredito, valorCentavos);
        }
    }
}
