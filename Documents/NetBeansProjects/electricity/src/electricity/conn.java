 package electricity;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class conn {
    Connection c;
    Statement s;
    conn(){
        try{
            c = DriverManager.getConnection("jdbc:Mysql://localhost:3306/ebs","root","");
            s =c.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
