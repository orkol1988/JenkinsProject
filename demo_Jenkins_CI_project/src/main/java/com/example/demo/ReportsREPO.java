package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class ReportsREPO {
    private String m_conn;

    public ReportsREPO(String m_conn) {
        this.m_conn = m_conn;
    }


    public ArrayList<ReportsDTO> getAllReports() {
        ArrayList<ReportsDTO> ReportsDTO = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {
                String sql = "SELECT * FROM Reports";

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    ReportsDTO r = new ReportsDTO(
                            rs.getInt("ID"),
                            rs.getString("License_plate"),
                            rs.getInt("Driver_ID"),
                            rs.getInt("Speed"));
                    ReportsDTO.add(r);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ReportsDTO;
    }


    public ReportsDTO getReportById(int id) {
        ArrayList<ReportsDTO> results = getAllReports();
        if (results.size() > 0) {
            return results.get(id-1);
        }
        else {
            return null;
        }
    }


    public void updateReport(String query) {
        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {
                String sql = query;

                Statement stmt = conn.createStatement();

                int result = stmt.executeUpdate(sql);
                System.out.println(result + " record updated.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
