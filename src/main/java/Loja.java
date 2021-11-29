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

    /*
     *   MUDANÇA NO CÓDIGO:
     *   USO DO MÉTODO Busca PARA ACHAR O PRODUTO A SER REMOVIDO
     */
    public boolean RemoveProduto(String nomeProduto) throws NotFound {
        Produto p = this.Busca(nomeProduto);
        if (p != null) {
            this.produtos.remove(p);
            return true;
        }
        throw new NotFound();
    }

    /*
     *   MUDANÇA NO CÓDIGO:
     *   USO DO MÉTODO Busca PARA IDENTIFICAR O PRODUTO
     */
    public boolean MostraProdutos(String nome) throws NotFound {
        Produto p = this.Busca(nome);
        if (p != null) {
            System.out.println(p);
            return true;
        }
        throw new NotFound();
    }

    public int Quantidade() {
        return this.produtos.size();
    }

    // MUDANÇA DO CÓDIGO:
    // O MÉTODO Busca AGORA RETORNA UM PRODUTO OU NULL
    public Produto Busca(String nomeProduto) throws NotFound {
        for (Produto p : this.produtos) {
            if (p.getName().equals(nomeProduto)) {
                return p;
            }
        }
        throw new NotFound();
    }

    public void ListaTudo() {
        if (this.Quantidade() > 0) {
            for (Produto p : this.produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("Nenhum produto cadastrado.\n");
        }
    }

    public boolean AtualizaProduto(String nomeProduto) throws NotFound {
        Produto p = this.Busca(nomeProduto);
        Scanner in = new Scanner(System.in);
        if (p != null) {
            System.out.println("Insira o novo nome para o produto: ");
            String nome = in.nextLine();
            if (!nome.isEmpty()) {
                p.setName(nome);
            }
            System.out.println("Insira o novo nome para o preço: ");
            float preco = in.nextFloat();
            if (preco != p.getPreco()) {
                p.setPreco(preco);
            }
            System.out.println("Insira o novo nome para o quantidade: ");
            int qtd = in.nextInt();
            if (qtd != p.getQuant()) {
                p.setQuant(qtd);
            }
            return true;
        }
        throw new NotFound();
    }

}