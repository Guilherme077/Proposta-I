package PDV;

public class Produto {
    public String Nome = null;
    public double Valor = 0.0;
    public int Quantidade = 0;
    public Produto (String nome, double valor, int quantidade){
        Nome = nome;
        Valor = valor;
        Quantidade = quantidade;
    }
    public Produto (String nome, double valor){
        Nome = nome;
        Valor = valor;

    }

    public void Venda(int quantidade){
        Quantidade -= quantidade;
    }

}