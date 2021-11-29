import java.util.Locale;

public class Produto {

    protected String nome;

    protected int quant;

    protected float preco;

    public static int ID = 1;

    public Produto(String nome, int quantidade, float preco) {
        super();
        // PRODUTO É CADASTRADO COM O nome EM lowerCase()
        this.nome = nome.toLowerCase();
        this.quant = quantidade;
        this.preco = preco;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quantidade) {
        this.quant = quantidade;
    }


    @Override
    public String toString() {
        // MELHORIAS NA EXIBIÇÃO
        return "Nome do Produto = " + nome + "\nQuantidade = " + quant + "\nPreço = " + preco;
    }


}