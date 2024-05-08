package com.cruzeiro.livro.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cruzeiro.livro.config.DBConfig;
import com.cruzeiro.livro.model.entity.Livro;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class LivroDAO implements IDAO{
    @Override
    public void cadastrar(Object obj) {

        Livro livro = Livro.class.cast(obj);
        try{
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "INSERT INTO LIVRO (titulo, autor, numeroPaginas, ISBN) VALUES ('" +
                    livro.getTitulo() +
                    "','" +
                    livro.getAutor() +
                    "'," +
                    livro.getNumeroPaginas() +
                    ",'" +
                    livro.getISBN() +
                    "');";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void atualizar(Object obj) {
        Livro livro = Livro.class.cast(obj);
        try{
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "UPDATE LIVRO SET titulo = '" +
                    livro.getTitulo() +
                    "', autor ='" +
                    livro.getAutor() +
                    "', numeroPaginas =" +
                    livro.getNumeroPaginas() +
                    ",ISBN='" +
                    livro.getISBN() +
                    "' WHERE id = " +
                    livro.getId()
                    +";";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(int id) {
        try{
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "DELETE FROM LIVRO WHERE id =" + id+";";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object buscar(int id) {
        Livro resultado;
        try{
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM LIVRO where id=" + id +";";

            ResultSet rs = statement.executeQuery(queryBuilder);

            if(rs.next()) {
                resultado = new Livro(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));
                resultado.setId(rs.getInt(1));
                statement.close();
                return resultado;
            }else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List listar() {
        List<Livro> resultados = new ArrayList<>();
        try{
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM LIVRO;";

            ResultSet rs = statement.executeQuery(queryBuilder);

            while (rs.next()) {
                Livro temp =
                new Livro(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));
                temp.setId(rs.getInt(1));
                resultados.add(temp);
            }
            statement.close();
            return resultados;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
