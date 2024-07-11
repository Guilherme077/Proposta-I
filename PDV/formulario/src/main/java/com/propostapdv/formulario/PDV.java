package com.propostapdv.formulario;

import java.util.ArrayList;

public class PDV {
    static ArrayList<Produto> ListaProdutos = new ArrayList<>();
    static ArrayList<String> ListaProdutosStr = new ArrayList<>();

    public static void AddProduto(String nome, int preco, int quantidade){
        ListaProdutos.add(new Produto(nome, preco, quantidade));
        //ListaProdutosStr.add(nome + " " + preco + " " + quantidade);
        AtualizarListaString();
    }

    public static void AtualizarListaString(){
        ListaProdutosStr.clear();
        for(int n = 0; n < ListaProdutos.size(); n++){
            ListaProdutosStr.add(ListaProdutos.get(n).Nome + " " + ListaProdutos.get(n).Preco + " " + ListaProdutos.get(n).Quantidade);
        }
        
    }

    public static void RemoverProduto(String nome){
        for(int n = 0; n < ListaProdutos.size(); n++){
            if(ListaProdutos.get(n).Nome == nome){
                ListaProdutos.remove(n);
            }
        }
    }
    //public static String ProdutoEmString(int n){
    //    return ListaProdutos.get(n).Nome + ListaProdutos.get(n).Preco + ListaProdutos.get(n).Quantidade;
    //}
}
