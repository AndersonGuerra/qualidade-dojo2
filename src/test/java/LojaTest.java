import org.junit.jupiter.api.Test;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class LojaTest {

    @Test
    void addProduto() {
        Loja lojaTeste = new Loja();
        Produto produtoTeste = new Produto("Nome", 10, 10);
        // VERIFICA SE O PRODUTO NÃO É NULO
        assertNotNull(produtoTeste);
        lojaTeste.addProduto(produtoTeste);
        // VERIFICA SE A LOJA TEM 1 PRODUTO
        assertEquals(1, lojaTeste.Quantidade());
    }

    @Test
    void removeProduto() throws NotFound {
        Loja lojaTeste = new Loja();
        Produto produtoTeste = new Produto("Nome", 10, 10);
        // VERIFICA SE O PRODUTO NÃO É NULO
        assertNotNull(produtoTeste);
        lojaTeste.addProduto(produtoTeste);
        // VERIFICA SE A LOJA TEM 1 PRODUTO
        assertEquals(1, lojaTeste.Quantidade());
        lojaTeste.RemoveProduto("Nome");
        // VERIFICA SE A LOJA TEM 0 PRODUTOS
        assertEquals(0, lojaTeste.Quantidade());
    }


    @Test
    void busca() throws NotFound {
        Loja lojaTeste = new Loja();
        Produto produtoTeste = new Produto("Produto 1", 10, 15);
        lojaTeste.addProduto(produtoTeste);
        // VERIFICA SE ACHOU O PRODUTO
        assertEquals(produtoTeste, lojaTeste.Busca("Produto 1"));
    }

    @Test
    void listaTudo() {
        Loja lojaTeste = new Loja();
        Produto produtoTeste1 = new Produto("Produto 1", 10, 15);
        Produto produtoTeste2 = new Produto("Produto 2", 32, 178);
        lojaTeste.addProduto(produtoTeste1);
        lojaTeste.addProduto(produtoTeste2);
        assertNotNull(lojaTeste.produtos);
        // VERIFICA SE A LOJA TEM 2 PRODUTOS
        assertEquals(2, lojaTeste.Quantidade());
    }

    @Test
    void atualizaProduto() throws NotFound {
        Loja lojaTeste = new Loja();
        Produto produtoTeste1 = new Produto("Produto 1", 10, 15);
        lojaTeste.addProduto(produtoTeste1);
        assertEquals(true, lojaTeste.AtualizaProduto(produtoTeste1, "Produto nome novo", 15, 12));
    }
}