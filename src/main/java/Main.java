import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws NotFound {

        Loja loja = new Loja();
        int opcao = 0;
        String confirm;
        Scanner in = new Scanner(System.in);
        String nomeProduto;

        System.out.println("Loja XPTO online \n\n");
        System.out.println("Logado como: Operdador Teste\n\n");
        while (opcao != 6) {
            System.out.println("Pressione:\n 1 - Adicionar produtos\n\t2 - Excluir Produtos\n\t3 - Exibir produtos\n\t4 - Procurar produto\n\t5 - Atualizar\n\t6 - Sair\nopcao: \nopcao: ");
            opcao = in.nextByte();
            switch (opcao) {
                case 1:
                    String nome;
                    int quantidade;
                    float preco;
                    System.out.println("Nome do Produto a ser Adicionado: ");
                    nome = in.next();
                    System.out.println("Quantidade do produto:");
                    quantidade = in.nextInt();
                    System.out.println("Preco unitario: ");
                    preco = in.nextFloat();
                    Produto p = new Produto(nome, quantidade, preco);
                    loja.addProduto(p);
                    System.out.println("Produto Adicionado");
                    break;
                case 2:
                    System.out.println("Nome do Produto a ser Removido: ");
                    nomeProduto = in.next();
                    if (loja.Busca(nomeProduto) != null) {
                        System.out.println("\n (y/n) Realmente deseja remover esse produto?" + nomeProduto);
                        confirm = in.next();
                        if (confirm.equals("y")) {
                            if (loja.RemoveProduto(nomeProduto)) {
                                System.out.println("Produto" + nomeProduto + "Removido");
                            }
                        } else {
                            System.out.println("Operacao Cancelada\n");
                        }
                    } else {
                        System.out.println("Produto: " + nomeProduto + "nao encontrado");
                    }
                    break;

                case 3:
                    System.out.println("A loja XPTO tem os Seguintes Produtos:\n");
                    loja.ListaTudo();
                    break;
                case 4:
                    System.out.println("Qual o nome do produto a ser buscado: ");
                    nomeProduto = in.next();
                    if (loja.Busca(nomeProduto) != null) {
                        System.out.println("Produto" + nomeProduto + "encontrado");
                        loja.MostraProdutos(nomeProduto);
                    } else {
                        System.out.println("Produto" + nomeProduto + "n�o encontado");
                    }
                    break;
            }
        }
    }
}