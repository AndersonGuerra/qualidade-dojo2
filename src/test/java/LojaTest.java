import org.junit.jupiter.api.Test;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import static org.junit.jupiter.api.Assertions.*;

class LojaTest {

    @Test
    void addProduto() {
        Loja l = new Loja();
        Produto p = new Produto("Nome", 10, 10);
        // VERIFICA SE O PRODUTO NÃO É NULO
        assertNotNull(p);
        l.addProduto(p);
        // VERIFICA SE A LOJA TEM 1 PRODUTO
        assertEquals(1, l.Quantidade());
    }

    @Test
    void removeProduto() throws NotFound {
        Loja l = new Loja();
        Produto p = new Produto("Nome", 10, 10);
        // VERIFICA SE O PRODUTO NÃO É NULO
        assertNotNull(p);
        l.addProduto(p);
        // VERIFICA SE A LOJA TEM 1 PRODUTO
        assertEquals(1, l.Quantidade());
        l.RemoveProduto("Nome");
        // VERIFICA SE A LOJA TEM 0 PRODUTOS
        assertEquals(0, l.Quantidade());
    }

    @Test
    void mostraProdutos() {
        Loja l = new Loja();
        Produto p = new Produto("Produto 1", 10, 15);
        Produto p2 = new Produto("Produto 2", 32, 178);
        l.addProduto(p);
        l.addProduto(p2);
        // VERIFICA SE A LOJA TEM 2 PRODUTOS
        assertEquals(2, l.Quantidade());
    }

    @Test
    void quantidade() {
    }

    @Test
    void busca() throws NotFound {
        Loja l = new Loja();
        Produto p = new Produto("Produto 1", 10, 15);
        l.addProduto(p);
        // VERIFICA SE ACHOU O PRODUTO
        assertEquals(p, l.Busca("Produto 1"));
    }

    @Test
    void listaTudo() {
    }
}