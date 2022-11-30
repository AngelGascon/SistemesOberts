<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Database SQL Load</title>
    </head>
    <style>
        .error {
            color: red;
        }
        pre {
            color: green;
        }
    </style>
    <body>
        <h2>Database SQL Load</h2>
        <%
            /* How to customize:
             * 1. Update the database name on dbname.
             * 2. Create the list of tables, under tablenames[].
             * 3. Create the list of table definition, under tables[].
             * 4. Create the data into the above table, under data[]. 
             * 
             * If there is any problem, it will exit at the very first error.
             */
            String dbname = "homework1";
            String schema = "ROOT";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            /* this will generate database if not exist */
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbname, "root", "root");
            Statement stmt = con.createStatement();
            
            /* inserting data */
            /* you have to exclude the id autogenerated from the list of columns if you have use it. */
            String data[] = new String[]{
                //Base64 client: angelgascmail@gmail.com:password == YW5nZWxnYXNjbWFpbEBnbWFpbC5jb206cGFzc3dvcmQ=
                "INSERT INTO " + schema + ".CLIENT VALUES (NEXT VALUE FOR CLIENT_GEN, 'angelgascmail@gmail.com', 'Angel', '607223456')",
                "INSERT INTO " + schema + ".CREDENTIALS VALUES (NEXT VALUE FOR CREDENTIALS_GEN, 'password', 1)",
                "INSERT INTO " + schema + ".CLIENT VALUES (NEXT VALUE FOR CLIENT_GEN, 'sob@gmail.com', 'sob', '600100200')",
                "INSERT INTO " + schema + ".CREDENTIALS VALUES (NEXT VALUE FOR CREDENTIALS_GEN, 'sob', 2)",
                "INSERT INTO " + schema + ".COIN VALUES (NEXT VALUE FOR COIN_GEN, '2016-03-02 11:24:00.772000000', 'Generic description.', 500000.0, 'Bitcoin')",
                "INSERT INTO " + schema + ".COIN VALUES (NEXT VALUE FOR COIN_GEN, '2021-07-02 8:24:00.772000000', 'Generic description 2.', 4000.0, 'Ethereum')",
                "INSERT INTO " + schema + ".PURCHASE VALUES (NEXT VALUE FOR PURCHASE_GEN, 6000.0, '2021-05-02 09:30:00.222000000',1,1)"
            };
            for (String datum : data) {
                if (stmt.executeUpdate(datum)<=0) {
                    out.println("<span class='error'>Error inserting data: " + datum + "</span>");
                    return;
                }
                out.println("<pre> -> " + datum + "<pre>");
            }
        %>
        <button onclick="window.location='<%=request.getSession().getServletContext().getContextPath()%>'">Go home</button>
    </body>
</html>
