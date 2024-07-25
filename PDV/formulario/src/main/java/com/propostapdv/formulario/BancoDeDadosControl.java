package com.propostapdv.formulario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDeDadosControl {
    public static void AtualizarProdutosLocal() throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "pdvapp", "2b@*[BCrXB/E]nt1");
            Class.forName("com.mysql.jdbc.Driver");
            ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM pdv.produtos");
            PDV.ListaProdutos.clear();           
            while (rsCliente.next()){
                PDV.ListaProdutos.add(new Produto(rsCliente.getString("nome"), rsCliente.getDouble("preco"), rsCliente.getInt("quantidade")));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão com o banco de dados: " + ex.getMessage());
        } finally{
            if(conexao != null){
                conexao.close();
            }
        }
    }
    public static void AddProdutoDB() throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "pdvapp", "2b@*[BCrXB/E]nt1");
            Class.forName("com.mysql.jdbc.Driver");
            Produto p = PDV.ListaProdutos.get(PDV.ListaProdutos.size()-1);
            conexao.createStatement().execute("INSERT INTO pdv.produtos (nome,preco,quantidade) VALUES ('" + p.Nome + "', " + p.Preco + ", " + p.Quantidade + ")");              
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão com o banco de dados: " + ex.getMessage());
        } finally{
            if(conexao != null){
                conexao.close();
            }
        }
    }
    public static void RemoverProdutoDB(String nome){
        // DELETE FROM produtos WHERE produtos.nome = 'cenoura'
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "pdvapp", "2b@*[BCrXB/E]nt1");
            Class.forName("com.mysql.jdbc.Driver");
            conexao.createStatement().execute("DELETE FROM pdv.produtos WHERE produtos.nome = '" + nome + "'");              
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão com o banco de dados: " + ex.getMessage());
        } finally{
            if(conexao != null){
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Falha ao fechar a conexao com o banco de dados: " + e.getMessage());
                }
            }
        }
    }


}
