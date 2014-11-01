package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/10/29 0029.
 */
public class Bussiness {
    public final static String DRIVERNAME = "sun.jdbc.odbc.JdbcOdbcDriver";
    public final static String URL = "jdbc:odbc:db";
    private static Statement stmt;
    private static ResultSet rs;

    public Bussiness() {
        init();
    }

    public static void init() {
        try {
            Class.forName(DRIVERNAME);
            Connection conn = DriverManager.getConnection(URL);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Employee employee) {
        try {
            stmt.execute("INSERT  into Employee (Name,Type,WorkTime,Salary)values ('"
                    + employee.getName() + "','"
                    + employee.getType() + "','"
                    + employee.getWorkTime() + "','"
                    + employee.getSalary() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void delete(Employee employee) {
        String sql = "delete from Employee where Id =" + employee.getId();
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteById(int id) {
        boolean flag = true;
        String sql = "delete from Employee where Id =" + id;
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;

    }

    public void update(Employee employee) {
        try {
            String sql = "update Employee" +
                    " set Name = '" + employee.getName()
                    + "', Type = '" + employee.getType()
                    + "', WorkTime = '" + employee.getWorkTime()
                    + "', Salary = '" + employee.getSalary()
                    + "' where Id = " + employee.getId();
            System.out.print(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Employee findById(int id) {
        Employee employee = new Employee() {
            @Override
            public void calculateSalary() {

            }
        };
        try {
            rs = stmt.executeQuery("select * from Employee where Id = " + id);
            while (rs.next()) {
                employee.setId(rs.getInt("Id"));
                employee.setName(rs.getString("Name"));
                employee.setType(rs.getInt("Type"));
                employee.setWorkTime(rs.getFloat("WorkTime"));
                employee.setSalary(rs.getFloat("Salary"));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print(employee);
        return null;

    }

    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<Employee>();
        try {
            rs = stmt.executeQuery("select * from Employee");
            while (rs.next()) {
                Employee employee = new Employee() {
                    @Override
                    public void calculateSalary() {

                    }
                };
                employee.setId(rs.getInt("Id"));
                employee.setName(rs.getString("Name"));
                employee.setType(rs.getInt("Type"));
                employee.setWorkTime(rs.getFloat("WorkTime"));
                employee.setSalary(rs.getFloat("Salary"));
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
        return list;
    }

}

