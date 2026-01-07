package org.example;

import java.sql.*;
import java.util.Scanner;


public class Main
{
    static String url = "jdbc:mysql://localhost:3306/college_db";
    static String user = "root";
    static String pass = "newpassword";
    static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Main() throws SQLException {
    }


    public static void main(String[] args) throws SQLException {


        String name = "", email = "", course = "";
        int age = 0;
        boolean t=true;
        Main ob = new Main();
        Scanner sc = new Scanner(System.in);
        while(t)
        {
            System.out.println("ENTER 1 TO ADD NEW STUDENT \n ENTER 2 TO VIEW ALL STUDENTS\n ENTER 3 TO UPDATE STUDENT\n ENTER 4 TO DELETE A STUDENT\nENTER 5 TO SEARCH STUDENT BY NAME\nENTER 6 TO EXIT ");
            System.out.println("ENTER YOUR CHOICE : ");
            int choice = sc.nextInt();
            //Connection connection = DriverManager.getConnection(url, user, pass);
            switch (choice)
            {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter Student Details : ");
                    System.out.println("Enter Student Name : ");
                    name = sc.nextLine();
                    System.out.println("Enter Student Email ID : ");
                    email = sc.nextLine();
                    System.out.println("Enter Student Age : ");
                    age = sc.nextInt();
                    System.out.println("Enter Student's Course : ");
                    course = sc.next();
                    ob.addStudent(name, email, age, course);
                    break;
                case 2:
                    ob.viewAllStudent();
                    break;
                case 3:
                    ob.updateStudent();
                    break;
                case 4:
                    ob.deleteStudent();
                    break;
                case 5:
                    ob.searchStudentById();
                    break;
                case 6:
                    t=false;
                    break;
            }
        }
    }

    public void addStudent(String name, String email, int age, String course)
    {
        try
        {
            String sql = "INSERT INTO students (name, email, age, course) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, age);
            ps.setString(4, course);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAllStudent()
    {
        try
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next())
            {
                System.out.println(rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("email") + " | " +
                rs.getInt("age") + " | " +
                rs.getString("course"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent()
    {
        try
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next())
            {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("course"));
            }
            Scanner sc=new Scanner(System.in);
            System.out.println("ENTER THE STUDENT ID TO UPDATE : ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.println("Enter New Name: ");
            String name = sc.nextLine();

            System.out.println("Enter New Email: ");
            String email = sc.nextLine();

            System.out.println("Enter New Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter New Course: ");
            String course = sc.nextLine();

            String sql = "UPDATE students SET name = ?, email = ?, age = ?, course = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, age);
            ps.setString(4, course);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent()
    {
        try
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next())
            {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("course"));
            }
            Scanner sc=new Scanner(System.in);
            System.out.println("ENTER THE STUDENT ID TO UPDATE : ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchStudentById()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("ENTER THE STUDENT ID TO SEARCH : ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            String sql = "SELECT  FROM students WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            System.out.println(rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getInt("age") + " | " +
                    rs.getString("course"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

