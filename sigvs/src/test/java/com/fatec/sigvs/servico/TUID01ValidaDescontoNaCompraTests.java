package com.fatec.sigvs.servico;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TUID01ValidaDescontoNaCompraTests {
    private DescontoNaVenda descontoNaVenda;

    @BeforeEach
    void setUp() {
        this.descontoNaVenda = new DescontoNaVenda();
    }

    @Test
    void ct01_quando_data_nao_promocional_e_primeira_compra_true_deveAplicarDesconto() {
        // DADO que a compra não foi realizada em mês promocional, primeira compra true
        // e valor da compra menor que 200
        String primeiraCompra = "true";
        String dataCompra = "15/01/2026";
        String valorCompra = "100.00";

        // QUANDO o usuário confirma a operação de compra
        BigDecimal valorDePagamentoObtido = descontoNaVenda.regraDeDesconto(primeiraCompra, dataCompra, valorCompra);
        BigDecimal valorDePagamentoEsperado = new BigDecimal("115.00").setScale(2, RoundingMode.HALF_UP);

        // ENTÃO aplica 5% de desconto e soma o frete de 20,00
        assertEquals(valorDePagamentoEsperado, valorDePagamentoObtido);
    }

    @Test
    void ct02_quando_data_nao_promocional_e_primeira_compra_false_deveAplicarDesconto() {
        // DADO que a compra não foi realizada em mês promocional, primeira compra false
        // e valor da compra menor que 200
        String primeiraCompra = "false";
        String dataCompra = "15/01/2026";
        String valorCompra = "100.00";

        // QUANDO o usuário confirma a operação de compra
        BigDecimal valorDePagamentoObtido = descontoNaVenda.regraDeDesconto(primeiraCompra, dataCompra, valorCompra);
        BigDecimal valorDePagamentoEsperado = new BigDecimal("120.00").setScale(2, RoundingMode.HALF_UP);

        // ENTÃO aplica 5% de desconto e soma o frete de 20,00
        assertEquals(valorDePagamentoEsperado, valorDePagamentoObtido);
    }

    @Test
    void ct03_quando_data_nao_promocional_e_primeira_compra_true_deveAplicarDesconto() {
        // DADO que a compra não foi realizada em mês promocional, primeira compra true
        // e valor da compra menor que 200
        String primeiraCompra = "true";
        String dataCompra = "15/01/2026";
        String valorCompra = "250.00";

        // QUANDO o usuário confirma a operação de compra
        BigDecimal valorDePagamentoObtido = descontoNaVenda.regraDeDesconto(primeiraCompra, dataCompra, valorCompra);
        BigDecimal valorDePagamentoEsperado = new BigDecimal("237.50").setScale(2, RoundingMode.HALF_UP);

        // ENTÃO aplica 5% de desconto e soma o frete de 20,00
        assertEquals(valorDePagamentoEsperado, valorDePagamentoObtido);
    }

    @Test
    void ct04_quando_primeira_compra_vazio_retorna_msg_de_erro() {
        // DADO que o atributo primeira compra está vazio
        String primeiraCompra = "";
        String dataCompra = "15/01/2026";
        String valorCompra = "100.00";

        // QUANDO o usuário confirma a operação de compra, ENTÃO ocorre erro de validação
        try {
            descontoNaVenda.regraDeDesconto(primeiraCompra, dataCompra, valorCompra);
            fail("Deveria falhar com atributo inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("Primeira compra não pode estar em branco ou vazia.", e.getMessage());
        }
    }

    @Test
    void ct05_quando_primeira_compra_vazio_retorna_msg_de_erro() {
        // DADO que o atributo primeira compra está vazio
        String primeiraCompra = " ";
        String dataCompra = "15/01/2026";
        String valorCompra = "100.00";

        // QUANDO o usuário confirma a operação de compra, ENTÃO ocorre erro de validação
        try {
            descontoNaVenda.regraDeDesconto(primeiraCompra, dataCompra, valorCompra);
            fail("Deveria falhar com atributo inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("Primeira compra não pode estar em branco ou vazia.", e.getMessage());
        }
    }

    @Test
    void ct06_quando_primeira_compra_vazio_retorna_msg_de_erro() {
        // DADO que o atributo primeira compra está vazio
        String primeiraCompra = "aaa";
        String dataCompra = "15/01/2026";
        String valorCompra = "100.00";

        // QUANDO o usuário confirma a operação de compra, ENTÃO ocorre erro de validação
        try {
            descontoNaVenda.regraDeDesconto(primeiraCompra, dataCompra, valorCompra);
            fail("Deveria falhar com atributo inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("Primeira compra não pode estar em branco ou vazia.", e.getMessage());
        }
    }

    @Test
    void ct07_quando_primeira_compra_vazio_retorna_msg_de_erro() {
        // DADO que o atributo primeira compra está vazio
        String primeiraCompra = null;
        String dataCompra = "15/01/2026";
        String valorCompra = "100.00";

        // QUANDO o usuário confirma a operação de compra, ENTÃO ocorre erro de validação
        try {
            descontoNaVenda.regraDeDesconto(primeiraCompra, dataCompra, valorCompra);
            fail("Deveria falhar com atributo inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("Primeira compra não pode estar em branco ou vazia.", e.getMessage());
        }
    }

    @Test
    void ct08_quando_primeira_compra_vazio_retorna_msg_de_erro() {
        // DADO que o atributo primeira compra está vazio
        String primeiraCompra = "True";
        String dataCompra = "15/01/2026";
        String valorCompra = "100.00";

        // QUANDO o usuário confirma a operação de compra, ENTÃO ocorre erro de validação
        try {
            descontoNaVenda.regraDeDesconto(primeiraCompra, dataCompra, valorCompra);
            fail("Deveria falhar com atributo inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("Primeira compra não pode estar em branco ou vazia.", e.getMessage());
        }
    }

    @Test
    void ct09_quando_primeira_compra_vazio_retorna_msg_de_erro() {
        // DADO que o atributo primeira compra está vazio
        String primeiraCompra = "False";
        String dataCompra = "15/01/2026";
        String valorCompra = "100.00";

        // QUANDO o usuário confirma a operação de compra, ENTÃO ocorre erro de validação
        try {
            descontoNaVenda.regraDeDesconto(primeiraCompra, dataCompra, valorCompra);
            fail("Deveria falhar com atributo inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("Primeira compra não pode estar em branco ou vazia.", e.getMessage());
        }
    }
}
