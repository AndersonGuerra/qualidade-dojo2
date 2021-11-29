import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Loja {
    protected List<Produto> produtos;

    public Loja() {
        this.produtos = new ArrayList<>();
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }


    //    MUDANÇA NO CÓDIGO:
//    USO DO MÉTODO Busca PARA ACHAR O PRODUTO A SER REMOVIDO
    public boolean RemoveProduto(String nomeProduto) throws NotFound {
        Produto produto = this.Busca(nomeProduto);
        if (produto != null) {
            this.produtos.remove(produto);
            return true;
        }
        throw new NotFound();
    }

    //    MUDANÇA NO CÓDIGO:
//    USO DO MÉTODO Busca PARA IDENTIFICAR O PRODUTO
    public boolean MostraProdutos(String nome) throws NotFound {
        Produto produto = this.Busca(nome);
        if (produto != null) {
            System.out.println(produto);
            return true;
        }
        throw new NotFound();
    }

    public int Quantidade() {
        return this.produtos.size();
    }

    // MUDANÇA DO CÓDIGO:
    // O MÉTODO Busca AGORA RETORNA UM Produto OU null
    public Produto Busca(String nomeProduto) throws NotFound {
        for (Produto produto : this.produtos) {
            if (produto.getName().equals(nomeProduto.toLowerCase())) {
                return produto;
            }
        }
        throw new NotFound();
    }

    public void ListaTudo() {
        if (this.Quantidade() > 0) {
            for (Produto produto : this.produtos) {
                System.out.println(produto);
            }
        } else {
            System.out.println("Nenhum produto cadastrado.\n");
        }
    }

    public boolean AtualizaProduto(Produto produto, String nomeNovo, float precoNovo, int qtdNovo) throws NotFound {
        if (produto != null) {
            produto.setName(nomeNovo);
            produto.setPreco(precoNovo);
            produto.setQuant(qtdNovo);
            return true;
        } else {
            throw new NotFound();
        }
    }
}