package com.sql_test;

import java.sql.*;
import java.util.Objects;

/**
 * SqliteDemo
 */
public class sql_test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("org.sqlite.JDBC");
        //SQLite 数据库文件
        String dbFile = "E:\\JAVA_API\\sqlite\\test.db";
        String url = "jdbc:sqlite:" + dbFile;
        Connection conn = DriverManager.getConnection(url);
        //项目任务
        select_wrong_users(conn);
        //添加
        //insert(conn);
        //查询
        //select(conn);
        //修改
        //update(conn);
        //删除
        //delete(conn);
        //关闭连接
        conn.close();
    }

    private static void select_wrong_users(Connection connection) throws SQLException {
        String sql1 =
                //email 格式问题提取
                "select userid from users where CHARINDEX('@', email) = 0 or " +
                "(CHARINDEX('@', email) = 1 OR " +
                "RIGHT(email, LEN(email) - CHARINDEX('@', email)) = '@') or " +
                "(CHARINDEX('.com', email) = 0 OR RIGHT(email, 4) <> '.com') OR " +
                "email LIKE '%..%' OR " +
                "email LIKE '%,%' OR email LIKE '%,' OR " +
                //phone 格式问题提取
                "phone not like '+86-%' or " +
                "phone NOT LIKE '+86-[0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]' or " +
                "phone like '%[^0-9-]%' or " +
                "LEN(REPLACE(phone, '-', '')) <> 11 or LEN(phone) <> 15";
        String sql2 = "select * from vip_records where userid in (" + sql1 +") order by userid";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql2);
        while (rs.next()) {
            //比较，当id不等时写入文件
            String id = rs.getString("userid");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            System.out.println(id);
            System.out.println(email);
            System.out.println(phone);
        }
        rs.close();
        statement.close();
    }

    private static void insert(Connection connection) throws SQLException {
        String sql = "insert into users( email, phone) values('123456@123.com', '1234567890')";
        Statement stat = connection.createStatement();
        stat.executeUpdate(sql);
        stat.close();
    }

    private static void select(Connection connection) throws SQLException {
        String sql = "select * from users";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("userid");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            System.out.println(id);
            System.out.println(email);
            System.out.println(phone);
        }
        rs.close();
        statement.close();
    }

    private static void update(Connection connection) throws SQLException {
        String sql = "update user set name = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, "小雪花");
        ps.setObject(2, 1);
        ps.executeUpdate();
        ps.close();
    }

    private static void delete(Connection connection) throws SQLException {
        String sql = "delete from user where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, 1);
        ps.executeUpdate();
        ps.close();
    }

}