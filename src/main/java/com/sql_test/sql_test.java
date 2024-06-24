package com.sql_test;

import java.sql.*;

/**
 * SqliteDemo
 */
public class sql_test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("org.sqlite.JDBC");
        //SQLite 数据库文件
        String dbFile = "E:\\BaiduNetdiskDownload\\sqlite\\test.db";
        String url = "jdbc:sqlite:" + dbFile;
        Connection conn = DriverManager.getConnection(url);

        //添加
        insert(conn);
        //查询
        select(conn);
        //修改
        update(conn);
        //删除
        delete(conn);
        //关闭连接
        conn.close();
    }

    private static void select(Connection connection) throws SQLException {
        String sql = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");

            System.out.println(id);
            System.out.println(name);
        }
        rs.close();
        statement.close();
    }

    private static void insert(Connection connection) throws SQLException {
        String sql = "insert into user( name) values('小丽')";
        Statement stat = connection.createStatement();
        stat.executeUpdate(sql);
        stat.close();
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