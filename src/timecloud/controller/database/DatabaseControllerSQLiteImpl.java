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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import timecloud.dao.episode.EpisodeDaoImpl;

public class DatabaseControllerSQLiteImpl extends DatabaseController {

    public DatabaseControllerSQLiteImpl(String DB_LOCATION) throws ClassNotFoundException, SQLException, IOException {
        super(DB_LOCATION);
        DB_DRIVER = "org.sqlite.JDBC";
        DB_CONNECTION = "jdbc:sqlite:";
        Class.forName(DB_DRIVER);
    }

    @Override
     void createDatabase() throws SQLException, IOException {
        long startTime = System.nanoTime();
        if (!DB_LOCATION.toLowerCase().endsWith(".sqlite")) {
            DB_LOCATION += ".sqlite";
        }
        //create the file
        File test = new File(DB_LOCATION);
        test.createNewFile();

        //load the table create sql statements
        Statement statement = null;

        String line;
        StringBuilder queryBuilder = new StringBuilder();

        //build the episode table creation query
        try {
            statement = createStatement();
            //build the episode table creation query
            FileReader fileReader = new FileReader("./database/sqlite/table/CreateEpisodeTable.sql");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                queryBuilder.append(line);
            }

            statement.executeUpdate(queryBuilder.toString());

            //build the transfer table creation query
            fileReader = new FileReader("./database/sqlite/table/CreateTransferTable.sql");
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                queryBuilder.append(line);
            }

            statement.executeUpdate(queryBuilder.toString());
            
            //build the request table creation query
            fileReader = new FileReader("./database/sqlite/table/CreateRequestTable.sql");
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                queryBuilder.append(line);
            }

            statement.executeUpdate(queryBuilder.toString());
            
            System.out.println("Database created in " + (System.nanoTime() - startTime) / 1000000 + " miliseconds");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseControllerSQLiteImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
