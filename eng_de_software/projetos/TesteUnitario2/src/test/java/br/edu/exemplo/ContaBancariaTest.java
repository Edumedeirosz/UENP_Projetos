package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    @Test
    void exemploCriacaoConta() {
        ContaBancaria conta = new ContaBancaria("João");
        assertEquals("João", conta.getTitular());
        assertEquals(BigDecimal.ZERO, conta.getSaldo());
    }

    @Test
    void exemploDeposito() {
        ContaBancaria conta = new ContaBancaria("Maria");
        conta.depositar(new BigDecimal("100.00"));
        assertEquals(new BigDecimal("100.00"), conta.getSaldo());
    }

    @Test
    void exemploSaqueSaldoSuficiente() {
        ContaBancaria conta = new ContaBancaria("Pedro");
        conta.depositar(new BigDecimal("200.00"));
        conta.sacar(new BigDecimal("50.00"));

        assertEquals(new BigDecimal("150.00"), conta.getSaldo());
    }

    @Test
    void titularInvalido() {

        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(""));

    }

    @Test
    void adicionarSaldo() {
        ContaBancaria conta = new ContaBancaria("Eduardo Medeiros");
        conta.depositar(BigDecimal.valueOf(2006.00));

        assertEquals(BigDecimal.valueOf(2006.00), conta.getSaldo());
    }

    @Test
    void depositoNegativo () {
        ContaBancaria conta = new ContaBancaria("Pedro");

        assertThrows(IllegalArgumentException.class, () -> conta.depositar(BigDecimal.valueOf(-17)));

    }

    @Test
    void saldoInsuficiente () {
        ContaBancaria conta = new ContaBancaria("Eddy");
        conta.depositar(BigDecimal.valueOf(10));

        assertEquals(BigDecimal.valueOf(10), conta.getSaldo());
        assertThrows(IllegalStateException.class, () -> conta.sacar(BigDecimal.valueOf(20)));
    }

    @Test
    void transferenciaValida () {
        ContaBancaria conta = new ContaBancaria("Eduardo");
        ContaBancaria conta2 = new ContaBancaria("Pedro");

        conta.depositar(BigDecimal.valueOf(1000));
        conta.transferir(conta2, BigDecimal.valueOf(700));
        //
        assertEquals(BigDecimal.valueOf(700), conta2.getSaldo());
        assertEquals(BigDecimal.valueOf(300), conta.getSaldo());

    }

    @Test
    void transferenciaMesmaConta () {

        ContaBancaria conta = new ContaBancaria("João");
        conta.depositar(BigDecimal.valueOf(70));
        // BUG encontrado --> Você pode fazer transferência para a mesma conta.
        assertThrows(IllegalArgumentException.class, () -> conta.transferir(conta, BigDecimal.valueOf(60)));
    }

    @Test
    void transferenciaInvalida () {

        ContaBancaria conta = new ContaBancaria("Paulo");
        ContaBancaria conta2 = new ContaBancaria("Pedro");
        conta.depositar(BigDecimal.valueOf(100));
        //BUG --> Titular vazio funciona corretamente.
        assertThrows(IllegalStateException.class, () -> conta.transferir(conta2, BigDecimal.valueOf(101)));

    }

    @Test
    void transferenciaInvalida2 () {

        ContaBancaria conta = new ContaBancaria("Paula");
        ContaBancaria conta2 = new ContaBancaria("Maurício");

        conta.depositar(BigDecimal.valueOf(100));
        assertThrows(IllegalStateException.class, () -> conta.transferir(conta2, BigDecimal.valueOf(200)));
    }

    @Test
    void transferenciaNula () {

        ContaBancaria conta = new ContaBancaria("Miranda");

        conta.depositar(BigDecimal.valueOf(100));
        assertThrows(IllegalArgumentException.class, () -> conta.transferir(null, BigDecimal.valueOf(100)));
    }

    @Test
    void saldoEscalasDiferentes () {

        ContaBancaria conta = new ContaBancaria("Pedro");
        conta.depositar(BigDecimal.valueOf(100.7777777777));
        conta.depositar(BigDecimal.valueOf(2.19));

        assertEquals(BigDecimal.valueOf(102.9677777777), conta.getSaldo());

    }

    @Test
    void transferenciaEncadeada () {

        ContaBancaria conta = new ContaBancaria("Pedro");
        ContaBancaria conta2 = new ContaBancaria("Eduardo");
        ContaBancaria conta3 = new ContaBancaria("Guilherme");
        ContaBancaria conta4 = new ContaBancaria("Gustavo");

        conta.depositar(BigDecimal.valueOf(100));
        conta.transferir(conta2, BigDecimal.valueOf(75));
        conta2.transferir(conta3, BigDecimal.valueOf(50));
        conta3.transferir(conta4, BigDecimal.valueOf(25));

        assertAll(

                () ->   assertEquals(BigDecimal.valueOf(25), conta.getSaldo()),
                () ->   assertEquals(BigDecimal.valueOf(25), conta2.getSaldo()),
                () ->  assertEquals(BigDecimal.valueOf(25), conta3.getSaldo()),
                () ->   assertEquals(BigDecimal.valueOf(25), conta4.getSaldo())

                );
    }

    @Test
    void mensagensDeErro() {

        assertAll (

                () -> assertThrows(IllegalArgumentException.class, () -> new ContaBancaria("")),

                () -> {

                    ContaBancaria conta = new ContaBancaria("Henrique");
                    conta.depositar(BigDecimal.valueOf(100));
                    assertThrows(IllegalStateException.class, () -> conta.sacar(BigDecimal.valueOf(101)));
                },

                () -> {

                    ContaBancaria conta = new ContaBancaria("Maria");
                    conta.depositar(BigDecimal.valueOf(100));

                    assertThrows(IllegalArgumentException.class, () -> conta.transferir(null, BigDecimal.valueOf(50)));

                },

                () -> {

                    ContaBancaria conta = new ContaBancaria("Carol");
                    assertThrows(IllegalArgumentException.class, () -> conta.transferir(conta, BigDecimal.valueOf(-1)));
                }

        );



    }

}
