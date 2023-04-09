package com.braga.demoProject;

import org.springframework.data.repository.CrudRepository;

import java.sql.*;


public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
        public static void saveCliente(Cliente cliente) {
            try (
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/demoProjectDB?useUnicode=true&characterEncoding=UTF-8&user=root&password=sabaoempoWaschpulver");
                    Statement stmt = conn.createStatement();
            ) {
                Integer id = cliente.getId();
                String nome = cliente.getNome();
                Integer numero = cliente.getNumero();
                String endereço = cliente.getEndereco();
                String sqlInsert = "INSERT INTO Cliente " +
                        "( id, nome, numero, endereco ) " +
                        "VALUES (" + id + ", '" + nome + "', " + numero +", '" + endereço + "' )";
                System.out.println("The SQL statement is: " + sqlInsert + "\n");
                int countInserted = stmt.executeUpdate(sqlInsert);
                System.out.println(countInserted + " records inserted.\n");

            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    public static String getClienteByNome(String nome) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/demoProjectDB?useUnicode=true&characterEncoding=UTF-8&user=root&password=sabaoempoWaschpulver");
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "SELECT * FROM Cliente " +
                    "WHERE Cliente.nome = '" + nome + "'";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            ResultSet rset = stmt.executeQuery(strSelect);

            Integer id = null;
            Integer numero = null;
            String endereco = null;
            while (rset.next()) {
                id = rset.getInt("id");
                nome = rset.getString("nome");
                numero = rset.getInt("numero");
                endereco = rset.getString("endereco");
            }
            return id + ", " + nome + ", " + numero + ", " + endereco;

        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return "Cliente não encontrado";
    }
}
