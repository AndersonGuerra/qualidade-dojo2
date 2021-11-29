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

    public boolean AtualizaProduto(String nomeProduto) throws NotFound {
        Produto produto = this.Busca(nomeProduto);
        Scanner in = new Scanner(System.in);
        if (produto != null) {
            System.out.println("Insira o novo nome para o produto: ");
            String nome = in.nextLine();
            if (!nome.isEmpty()) {
                produto.setName(nome.toLowerCase());
            }
            System.out.println("Insira o novo nome para o preço: ");
            float preco = in.nextFloat();
            if (preco != produto.getPreco()) {
                produto.setPreco(preco);
            }
            System.out.println("Insira o novo nome para o quantidade: ");
            int qtd = in.nextInt();
            if (qtd != produto.getQuant()) {
                produto.setQuant(qtd);
            }
            return true;
        }
        throw new NotFound();
    }

}