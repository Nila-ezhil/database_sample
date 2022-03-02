import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        int res;
        do {
            System.out.println("To create table choose 1");
            System.out.println("To list table choose 2");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("enter Empid");
                    String EMPID = sc.next();
                    System.out.println("enter Firstname");
                    String Firstname = sc.next();
                    System.out.println("enter lastname");
                    String lastname = sc.next();
                    System.out.println("enter Address ");
                    sc.nextLine();
                    String Address = sc.nextLine();
                    System.out.println("enter City");
                    String City = sc.next();
                    System.out.println("enter doj");
                    String doj = sc.next();

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/employeedb", "root", "password");

                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("insert into emp" + " values(' "+EMPID+ "',' "+Firstname+ "',' "+lastname+ "',' "+Address+ "',' "+City+ "',' "+doj+ "')");
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/employeedb", "root", "password");

                        Statement stmt = con.createStatement();
                        ResultSet rs1 = stmt.executeQuery("select * from emp");
                        while (rs1.next())
                            System.out.println(rs1.getString(1) + "  " + rs1.getString(2) + "  " + rs1.getString(3)+ "  " + rs1.getString(4) + "  " + rs1.getString(5) + "  " + rs1.getString(
                                    6
                            ));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                default:
                    System.out.println("exit loop");
                    break;
            }
            System.out.println("Do want to continue print 1 else 0");
            res = sc.nextInt();
        } while (res == 1);
                try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeedb","root","password");

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

}