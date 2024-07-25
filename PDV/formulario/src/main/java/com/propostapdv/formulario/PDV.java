package com.propostapdv.formulario;


import java.sql.SQLException;
import java.util.ArrayList;

public class PDV {
    static ArrayList<Produto> ListaProdutos = new ArrayList<>();
    static ArrayList<String> ListaProdutosStr = new ArrayList<>();

    public static void AddProduto(String nome, int preco, int quantidade) throws SQLException{
        ListaProdutos.add(new Produto(nome, preco, quantidade));
        BancoDeDadosControl.AddProdutoDB();
        AtualizarListaString();
    }

    
    public static void AtualizarListaString(){
        try {
            BancoDeDadosControl.AtualizarProdutosLocal();
        } catch (SQLException e) {
            System.out.println("Falha na atualização SQL da lista local: " + e.getMessage());
        }
        ListaProdutosStr.clear();
        for(int n = 0; n < ListaProdutos.size(); n++){
            ListaProdutosStr.add("<div style=\"font-size: 20px; color: black;\"> <div id=\"nomeProduto\" style=\"font-size: 30px; color: green;\">Nome: " + ListaProdutos.get(n).Nome + "</div><div id=\"precoProduto\"> Preço: " + ListaProdutos.get(n).Preco + "</div><div id=\"quantidadeProduto\"> Quantidade: " + ListaProdutos.get(n).Quantidade + "</div></div>");
        }
    }

    public static void RemoverProduto(String nome){
        for(int n = 0; n < ListaProdutos.size(); n++){
            if(ListaProdutos.get(n).Nome.equals(nome)){
                BancoDeDadosControl.RemoverProdutoDB(nome);
                ListaProdutos.remove(n);
            }
        }
    }
    public static void VenderProduto(String produto, int quantidade){
        for(int n = 0; n < ListaProdutos.size(); n++){
            String nomeProduto = ListaProdutos.get(n).Nome;
            if(nomeProduto.equals(produto)){
                 if((ListaProdutos.get(n).Quantidade) - quantidade == 0){
                    RemoverProduto(produto);
                }
                else if((ListaProdutos.get(n).Quantidade) - quantidade < 0){
                    // Implementar mensagem de que não existe essa quantidade
                }
                else{
                    SubtrairQuantidade(n, quantidade);
                   
                }
                
                
            }
        }
        AtualizarListaString();
    }
    public static void SubtrairQuantidade(int id, int quantidade){
        (ListaProdutos.get(id).Quantidade) -= quantidade;
    }
    //public static String ProdutoEmString(int n){
    //    return ListaProdutos.get(n).Nome + ListaProdutos.get(n).Preco + ListaProdutos.get(n).Quantidade;
    //}
}
