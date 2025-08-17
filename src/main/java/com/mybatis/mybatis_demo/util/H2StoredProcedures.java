package com.mybatis.mybatis_demo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2StoredProcedures {

    // H2 calls must be static
    public static ResultSet getBooksByPublisher(Connection conn, String publisher) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "SELECT TITLE, AUTHOR_FIRST_NAME, AUTHOR_LAST_NAME, PRICE FROM BOOKS WHERE PUBLISHER = ?"
        );
        ps.setString(1, publisher);
        return ps.executeQuery();  // return ResultSet directly
    }
}