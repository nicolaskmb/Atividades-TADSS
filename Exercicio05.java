public class Exercicio05 {
    private static final int TRES_MINUTOS = 3 * 60 * 1000;

    public static void main(String[] args) throws InterruptedException {
        Banco firmeza = new Banco(100, 100_000);
        Movimento[] sistemas = new Movimento[5];

        System.out.printf("Saldo do banco: R$ %,.2f | Transações: %,d%n",
                firmeza.getSaldoTotalCentavos() / 100.0,
                firmeza.getTransacoes());

        for (int i = 0; i < sistemas.length; i++) {
            sistemas[i] = new Movimento(firmeza);
            sistemas[i].start();
        }

        long inicio = System.currentTimeMillis();
        while (System.currentTimeMillis() - inicio < TRES_MINUTOS) {
            Thread.sleep(5000);
            System.out.printf("Saldo do banco: R$ %,.2f | Transações: %,d%n",
                    firmeza.getSaldoTotalCentavos() / 100.0,
                    firmeza.getTransacoes());
        }

        for (Movimento sistema : sistemas) {
            sistema.interrupt();
        }
        for (Movimento sistema : sistemas) {
            sistema.join();
        }

        long saldoFinalCentavos = firmeza.getSaldoTotalCentavos();
        System.out.println("\n===== RESULTADO FINAL =====");
        System.out.printf("Transações executadas: %,d%n", firmeza.getTransacoes());
        System.out.printf("Saldo final no cofre: R$ %,.2f%n", saldoFinalCentavos / 100.0);
        System.out.printf("Valor esperado: R$ %,.2f%n", 100_000.0);

        if (saldoFinalCentavos == 10_000_000) {
            System.out.println("Integridade OK: total do banco permanece em R$ 100.000,00.");
        } else {
            System.out.println("ERRO: total do banco foi alterado.");
        }
    }
}