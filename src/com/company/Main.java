package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main extends CRUD {
    public Main() {
    }

    public static void clearScreen() {
        for(int i = 0; i < 24000; ++i) {
            System.out.println("\b");
        }

    }

    public static void main(String[] args) {
        Connection connect = null;
        Statement statement = null;
        ResultSet rs = null;

        Scanner in = new Scanner(System.in);

        try {
            connect = DriverManager.getConnection("jdbc:mariadb://192.168.64.2/School", "MaxDB", "localhostdb");
            statement = connect.createStatement();

            int answer;
            do {
                System.out.println("1 - Create \n2 - Retrive/Read \n3 - Update \n4 - Delete \n5 - LEFT JOIN \n6 - RIGHT JOIN \n7 - Exclude LEFT JOIN \n8 - Exclude RIGHT JOIN \n9 - FULL OUTER JOIN \n10 - Exclude FULL OUTER JOIN \n11 - Inner Join \n12 - Select Max Mark\n0 - Exit");
                System.out.print("Choose the operation : ");

                do {
                    answer = in.nextInt();
                    if (answer < 0 || answer > 12) {
                        System.out.println(answer + " Не входит в список функций! " + "Повторите ввод: ");
                    }
                } while(answer < 0 || answer > 12);

                switch(answer) {
                    case 1:
                        clearScreen();
                        InsertCreate(connect);
                        System.out.println("Запись успешно добавлена!");
                        break;
                    case 2:
                        clearScreen();
                        Read(connect);
                        System.out.println("Данные успешно выведены!");
                        break;
                    case 3:
                        clearScreen();
                        Update(connect);
                        System.out.println("Данные успешно изменены!");
                        break;
                    case 4:
                        clearScreen();
                        Delete(connect);
                        System.out.println("Данные успешно удалены!");
                        break;
                    case 5:
                        clearScreen();
                        LEFTJOIN(connect);
                        break;
                    case 6:
                        clearScreen();
                        RIGHTJOIN(connect);
                        break;
                    case 7:
                        clearScreen();
                        LEFTJOINNull(connect);
                        break;
                    case 8:
                        clearScreen();
                        RIGHTJOINNull(connect);
                        break;
                    case 9:
                        clearScreen();
                        FullOuterJOIN(connect);
                        break;
                    case 10:
                        clearScreen();
                        FullOuterJOINnull(connect);
                        break;
                    case 11:
                        clearScreen();
                        InnerJOIN(connect);
                        break;
                    case 12:
                        clearScreen();
                        MaxUcenik(connect);
                        System.out.print("\n");
                }
            } while(answer != 0);
        } catch (SQLException var23) {
            var23.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    ((ResultSet)rs).close();
                }
            } catch (SQLException var22) {
                var22.printStackTrace();
            }

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException var21) {
                var21.printStackTrace();
            }

            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException var20) {
                var20.printStackTrace();
            }

        }

    }
}
