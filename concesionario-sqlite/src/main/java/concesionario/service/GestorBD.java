package concesionario.service;

import concesionario.dto.Coche;

import java.sql.*;

public class GestorBD {
    private static final String URL = "jdbc:mysql://localhost:8889/concesionario_db";
    private static final String USER = "root";
    private static final String PASS = "root";

    public void registrarVenta(Coche coche, String nombreCliente, String dniCliente) {
        String sql = "INSERT INTO coches_vendidos (marca, modelo, anio, precio, nombre_cliente, dni_cliente) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, coche.getMarca());
            pst.setString(2, coche.getModelo());
            pst.setInt(3, coche.getAnio());
            pst.setDouble(4, coche.getPrecio());
            pst.setString(5, nombreCliente);
            pst.setString(6, dniCliente);

            pst.executeUpdate();
            System.out.println("Venta registrada en base de datos correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al conectar con la BD: " + e.getMessage());
        }
    }

    public void verVentas() {
        String sql = "SELECT * FROM coches_vendidos";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("--- COCHES VENDIDOS ---");
            while (rs.next()) {
                System.out.printf("Cliente: %s (%s) - Coche: %s %s (%d) - %.2f€%n",
                        rs.getString("nombre_cliente"),
                        rs.getString("dni_cliente"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}