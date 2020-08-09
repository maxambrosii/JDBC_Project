package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD {
    public CRUD() {
    }

    public static void main(String[] args) {
    }

    public static void InsertCreate(Connection connect) {
        try {
            Statement statement = connect.createStatement();
            String strInfo = "";
            new Scanner(System.in);
            Scanner inStr = new Scanner(System.in);
            String Create = "INSERT INTO `Teacher`(`Familia_Teacher`,`Name_Teacher`,`Otcestvo_Teacher`) VALUES (";
            System.out.println("Ввод информации в таблицу Учитель...");
            System.out.print("Введите Фамилию учителя : ");
            strInfo = inStr.nextLine();
            Create = Create + "'" + strInfo + "'" + ",";
            System.out.print("Введите Имя учителя : ");
            strInfo = inStr.nextLine();
            Create = Create + "'" + strInfo + "'" + ",";
            System.out.print("Введите Отчество учителя : ");
            strInfo = inStr.nextLine();
            Create = Create + "'" + strInfo + "'" + ");";
            statement.executeQuery(Create);
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

    }

    public static void Read(Connection connect) {
        try {
            Statement statement = connect.createStatement();
            ResultSet rs = null;
            rs = statement.executeQuery("SELECT * FROM Teacher");

            while(rs.next()) {
                System.out.format("%10s", rs.getInt("Cod_Teacher") + " ");
                System.out.format("%10s", rs.getString("Familia_Teacher") + " ");
                System.out.format("%10s", rs.getString("Name_Teacher") + " ");
                System.out.format("%10s", rs.getString("Otcestvo_Teacher") + "\n");
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static void Update(Connection connect) {
        try {
            Statement statement = connect.createStatement();
            ResultSet rs = null;
            String Update = "UPDATE Teacher SET Name_Teacher = 'Francuz' WHERE Cod_Teacher = 30;";
            statement.executeQuery(Update);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static void LEFTJOIN(Connection connect) {
        ResultSet rs = null;

        try {
            Statement statement = connect.createStatement();
            rs = statement.executeQuery("Select * From \nClass\nLEFT JOIN \nUcenik on (Class.Cod_cl=Ucenik.Cod_cl);");

            while(rs.next()) {
                System.out.format("%5s", rs.getInt("N_Cl") + " ");
                System.out.format("%5s", rs.getString("Razdel") + " ");
                System.out.format("%15s", rs.getString("Familia_uc") + " ");
                System.out.format("%15s", rs.getString("Name_Uc") + " ");
                System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
                System.out.format("%15s", rs.getString("Data_r") + " ");
                System.out.format("%15s", rs.getString("IDNP") + "\n");
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static void RIGHTJOIN(Connection connect) {
        ResultSet rs = null;

        try {
            Statement statement = connect.createStatement();
            rs = statement.executeQuery("Select * From \nClass\nRIGHT JOIN \nUcenik on (Class.Cod_cl=Ucenik.Cod_cl);");

            while(rs.next()) {
                System.out.format("%5s", rs.getInt("N_Cl") + " ");
                System.out.format("%5s", rs.getString("Razdel") + " ");
                System.out.format("%15s", rs.getString("Familia_uc") + " ");
                System.out.format("%15s", rs.getString("Name_Uc") + " ");
                System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
                System.out.format("%15s", rs.getString("Data_r") + " ");
                System.out.format("%15s", rs.getString("IDNP") + "\n");
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static void LEFTJOINNull(Connection connect) {
        ResultSet rs = null;

        try {
            Statement statement = connect.createStatement();
            rs = statement.executeQuery("Select * From \nClass\nLEFT JOIN \nUcenik on (Class.Cod_cl=Ucenik.Cod_cl) \nWHERE Ucenik.Cod_cl IS NULL;");

            while(rs.next()) {
                System.out.format("%5s", rs.getInt("N_Cl") + " ");
                System.out.format("%5s", rs.getString("Razdel") + " ");
                System.out.format("%15s", rs.getString("Familia_uc") + " ");
                System.out.format("%15s", rs.getString("Name_Uc") + " ");
                System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
                System.out.format("%15s", rs.getString("Data_r") + " ");
                System.out.format("%15s", rs.getString("IDNP") + "\n");
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static void RIGHTJOINNull(Connection connect) {
        ResultSet rs = null;

        try {
            Statement statement = connect.createStatement();
            rs = statement.executeQuery("Select * From \nClass\nRIGHT JOIN \nUcenik on (Class.Cod_cl=Ucenik.Cod_cl) \nWHERE Ucenik.Cod_cl IS NULL;");

            while(rs.next()) {
                System.out.format("%5s", rs.getInt("N_Cl") + " ");
                System.out.format("%5s", rs.getString("Razdel") + " ");
                System.out.format("%15s", rs.getString("Familia_uc") + " ");
                System.out.format("%15s", rs.getString("Name_Uc") + " ");
                System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
                System.out.format("%15s", rs.getString("Data_r") + " ");
                System.out.format("%15s", rs.getString("IDNP") + "\n");
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static void MaxUcenik(Connection connect) {
        try {
            Statement statement = connect.createStatement();
            ResultSet rs = null;
            String MaxUc = "SELECT Ucenik.Name_Uc,Ucenik.Familia_uc,Ucenik.Otcestvo_uc,Jurnal.Ocenka_Pas \n  From Ucenik INNER JOIN Jurnal On Ucenik.Cod_uc = Jurnal.Cod_uc    \n    WHERE  Jurnal.Ocenka_Pas = \n                                (SELECT MAX(Jurnal.Ocenka_Pas) \n                                  FROM Jurnal \n                                  WHERE Jurnal.Ocenka_Pas<11);";
            rs = statement.executeQuery(MaxUc);

            while(rs.next()) {
                System.out.format("%10s", rs.getString("Name_Uc") + " ");
                System.out.format("%10s", rs.getString("Familia_uc") + " ");
                System.out.format("%10s", rs.getString("Otcestvo_Uc") + " ");
                System.out.format("%2s", rs.getInt("Ocenka_Pas") + "\n");
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static void FullOuterJOIN(Connection connect) {
        ResultSet rs = null;

        try {
            Statement statement = connect.createStatement();
            rs = statement.executeQuery("Select * From \nClass\nLEFT JOIN \nUcenik on (Class.Cod_cl=Ucenik.Cod_cl)\nUNION\nSelect * From \nClass\nRIGHT JOIN \nUcenik on (Class.Cod_cl=Ucenik.Cod_cl);");

            while(rs.next()) {
                System.out.format("%5s", rs.getInt("N_Cl") + " ");
                System.out.format("%5s", rs.getString("Razdel") + " ");
                System.out.format("%15s", rs.getString("Familia_uc") + " ");
                System.out.format("%15s", rs.getString("Name_Uc") + " ");
                System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
                System.out.format("%15s", rs.getString("Data_r") + " ");
                System.out.format("%15s", rs.getString("IDNP") + "\n");
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static void FullOuterJOINnull(Connection connect) {
        ResultSet rs = null;

        try {
            Statement statement = connect.createStatement();
            rs = statement.executeQuery("Select * From \nClass\nLEFT JOIN \nUcenik on (Class.Cod_cl=Ucenik.Cod_cl) \nWHERE Ucenik.Cod_cl IS NULL\nUNION\nSelect * From \nClass\nRIGHT JOIN \nUcenik on (Class.Cod_cl=Ucenik.Cod_cl) \nWHERE Ucenik.Cod_cl IS NULL;");

            while(rs.next()) {
                System.out.format("%5s", rs.getInt("N_Cl") + " ");
                System.out.format("%5s", rs.getString("Razdel") + " ");
                System.out.format("%15s", rs.getString("Familia_uc") + " ");
                System.out.format("%15s", rs.getString("Name_Uc") + " ");
                System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
                System.out.format("%15s", rs.getString("Data_r") + " ");
                System.out.format("%15s", rs.getString("IDNP") + "\n");
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static void InnerJOIN(Connection connect) {
        ResultSet rs = null;

        try {
            Statement statement = connect.createStatement();
            rs = statement.executeQuery("Select * From Class\nINNER JOIN \nUcenik ON (Class.Cod_cl=Ucenik.Cod_cl) \n");

            while(rs.next()) {
                System.out.format("%5s", rs.getInt("N_Cl") + " ");
                System.out.format("%5s", rs.getString("Razdel") + " ");
                System.out.format("%15s", rs.getString("Familia_uc") + " ");
                System.out.format("%15s", rs.getString("Name_Uc") + " ");
                System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
                System.out.format("%15s", rs.getString("Data_r") + " ");
                System.out.format("%15s", rs.getString("IDNP") + "\n");
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static void Delete(Connection connect) {
        try {
            Statement statement = connect.createStatement();
            ResultSet rs = null;
            String Delete = "Delete from `Teacher` where `Cod_Teacher` = 30; ";
            statement.executeQuery(Delete);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }
}
