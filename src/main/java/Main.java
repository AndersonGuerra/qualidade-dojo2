import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.Scanner;

//CUMPRIDOS:
//* Casos de teste:
//    - Adicionar produto
//    - Realizar remoção de produto
//    - Verificar lista de todos os produtos
//    - Encontrar produto específico
//    - Verificar exceção de produto não encontrado
//* Correção de defeitos no código
//* Nova funcionalidade (atualizar produto)
//* Realizar refatoraçõs


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
            // CORREÇÃO DA OPÇÃO DE SAIR DO PROGRAMA:
            // ANTES O PROGRAMA EXECUTAVA ETERNAMENTE, AGORA ELE SAI :D
            System.out.println("Pressione:\n\t1 - Adicionar produtos\n\t2 - Excluir Produtos\n\t3 - Exibir produtos\n\t4 - Procurar produto\n\t5 - Atualizar produto\n\t6 - Sair\nopcao: ");
            opcao = in.nextByte();
            switch (opcao) {
                case 1:
                    String nome;
                    int quantidade;
                    float preco;
                    System.out.println("Nome do Produto a ser Adicionado: ");
                    // TODOS OS PRODUTOS AGORA SÃO CADASTRADOS COM lowerCase()
                    // PARA FINS DE UNIFORMIDADE
                    nome = in.next().toLowerCase();
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
                    // TODOS OS PRODUTOS AGORA SÃO BUSCADOS COM lowerCase()
                    // PARA FINS DE UNIFORMIDADE
                    nomeProduto = in.next().toLowerCase();
                    // ADEQUAÇÃO DO IF PARA NOVA IMPLEMENTAÇÃO DO MÉTODO loja.Busca
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
                    // TODOS OS PRODUTOS AGORA SÃO BUSCADOS COM lowerCase()
                    // PARA FINS DE UNIFORMIDADE
                    nomeProduto = in.next().toLowerCase();
                    // ADEQUAÇÃO DO IF PARA NOVA IMPLEMENTAÇÃO DO MÉTODO loja.Busca
                    if (loja.Busca(nomeProduto) != null) {
                        // MUDANÇA NO TEXTO DE EXIBIÇÃO
                        System.out.println("Produto " + nomeProduto + " encontrado");
                        loja.MostraProdutos(nomeProduto);
                    } else {
                        // MUDANÇA NO TEXTO DE EXIBIÇÃO
                        System.out.println("Produto " + nomeProduto + "não encontado");
                    }
                    break;
                case 5:
                    System.out.println("Qual o nome do produto a ser atualizado: ");
                    // TODOS OS PRODUTOS AGORA SÃO BUSCADOS COM lowerCase()
                    // PARA FINS DE UNIFORMIDADE
                    nomeProduto = in.next().toLowerCase();
                    Produto produto = loja.Busca(nomeProduto);
                    if (produto != null) {
                        System.out.println("Insira o novo nome para o produto: ");
                        String nomeNovo = in.next();
                        System.out.println("Insira o novo nome para o preço: ");
                        float precoNovo = in.nextFloat();
                        System.out.println("Insira o novo nome para o quantidade: ");
                        int qtdNovo = in.nextInt();
                        loja.AtualizaProduto(produto, nomeNovo, precoNovo, qtdNovo);
                    }
                    break;
            }
        }
    }
}