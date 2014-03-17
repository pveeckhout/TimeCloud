/*
 *   The MIT License (MIT)
 *
 *   Copyright (c) 2014 Pieter Van Eeckhout
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy of
 *   this software and associated documentation files (the "Software"), to deal in
 *   the Software without restriction, including without limitation the rights to
 *   use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 *   the Software, and to permit persons to whom the Software is furnished to do so,
 *   subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 *   FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 *   COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 *   IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *   CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package timecloud.controller.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseControllerSQLiteImpl implements DatabaseController {

    private static final String DB_DRIVER = "org.sqlite.JDBC";
    private static final String DB_CONNECTION = "jdbc:sqlite:";
    private String DB_LOCATION = "";
    private Connection connection = null;

    public DatabaseControllerSQLiteImpl(String DB_LOCATION) throws ClassNotFoundException {
        Class.forName(DB_DRIVER);
        this.DB_LOCATION = DB_LOCATION;
    }

    private Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(DB_CONNECTION + DB_LOCATION);
        }
        return connection;
    }

    @Override
    public Statement createStatement() throws SQLException {
        Statement statement = getConnection().createStatement();
        statement.setQueryTimeout(30);
        return statement;
    }

    @Override
    public void closeConnection() throws SQLException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            Logger.getLogger(DatabaseControllerSQLiteImpl.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
    }
}
