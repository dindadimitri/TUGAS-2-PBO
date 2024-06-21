package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.datatransfer.DataFlavor;
import java.sql.*;

public class Data {
    public JSONObject selectDatabase(String[] path, String query) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Tugas 2\\untitled\\Sistem.db");
            Statement statement = connection.createStatement();
            System.out.println("connection berhasil");
            if (path[1].equals("customer")) {
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                if (path.length == 2) {
                    ResultSet rs = statement.executeQuery("select * from " + path[1]);
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("First_Name", rs.getString("first_name"));
                        record.put("Last_Name", rs.getString("last_name"));
                        record.put("Email", rs.getString("email"));
                        record.put("Phone Number", rs.getString("phone_number"));
                        array.add(record);
                    }
                    jsonObject.put("Customer Information", array);
                    return jsonObject;
                }
                if (path.length == 3) {
                    ResultSet rs = statement.executeQuery("SELECT * FROM customer WHERE id = " + path[2]);
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("Id", rs.getInt("id"));
                        record.put("First_Name", rs.getString("first_name"));
                        record.put("Last_Name", rs.getString("last_name"));
                        record.put("Email", rs.getString("email"));
                        record.put("Phone Number", rs.getString("phone_number"));
                        array.add(record);
                    }
                    jsonObject.put("Customer Information", array);
                    return jsonObject;
                }
            } else if (path[1].equals("items")) {
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                System.out.println(query);
                if (path.length == 2) {
                    ResultSet rs = statement.executeQuery("select * from " + path[1]);
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("Name", rs.getString("name"));
                        record.put("Price", rs.getString("price"));
                        record.put("Type", rs.getString("type"));
                        record.put("Is_active", rs.getInt("is_active"));
                        array.add(record);
                    }
                    jsonObject.put("Items Information", array);
                    return jsonObject;
                }else if (path.length == 3) {
                    ResultSet rs = statement.executeQuery("SELECT * FROM Items  WHERE id = " + path[2]);
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("Name", rs.getString("name"));
                        record.put("Price", rs.getString("price"));
                        record.put("Type", rs.getString("type"));
                        record.put("Is_active", rs.getInt("is_active"));
                        array.add(record);
                    }
                    jsonObject.put("Items Information", array);
                    return jsonObject;
                }

            }
            else if (path[1].equals("items_is_active?is_active=true")) {
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                System.out.println(query);
                DataFlavor request = null;
                String isActiveParam = request.getParameter("is_active");

                if (path.length == 2) {
                    String sql = "SELECT * FROM " + path[1];
                    if (isActiveParam != null && isActiveParam.equals("true")) {
                        sql += " WHERE is_active = 1";
                    }
                    ResultSet rs = statement.executeQuery(sql);
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("Name", rs.getString("name"));
                        record.put("Price", rs.getString("price"));
                        record.put("Type", rs.getString("type"));
                        record.put("Is_active", rs.getInt("is_active"));
                        array.add(record);
                    }
                    jsonObject.put("Items Information", array);
                    return jsonObject;
                } else if (path.length == 3) {
                    ResultSet rs = statement.executeQuery("SELECT * FROM Items WHERE id = " + path[2]);
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("Name", rs.getString("name"));
                        record.put("Price", rs.getString("price"));
                        record.put("Type", rs.getString("type"));
                        record.put("Is_active", rs.getInt("is_active"));
                        array.add(record);
                    }
                    jsonObject.put("Items Information", array);
                    return jsonObject;
                }
            }

            else if (path[1].equals("subscriptions")) {
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                if (path.length == 2) {
                    ResultSet rs = statement.executeQuery("SELECT * FROM subscriptions");
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("customer", rs.getInt("customer"));
                        record.put("billing_period", rs.getInt("billing_period"));
                        record.put("billing_period_unit", rs.getString("billing_period_unit"));
                        record.put("total_due", rs.getInt("total_due"));
                        record.put("activated_at", rs.getString("activated_at"));
                        record.put("current_term_start", rs.getString("current_term_start"));
                        record.put("current_term_end", rs.getString("current_term_end"));
                        record.put("status", rs.getString("status"));
                        array.add(record);
                    }
                    jsonObject.put("Subscriptions Information", array);
                    return jsonObject;
                }else if (path.length == 3) {
                    ResultSet rs = statement.executeQuery("SELECT * FROM subscriptions WHERE id=" + path[2]);
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("customer", rs.getInt("customer"));
                        record.put("billing_period", rs.getInt("billing_period"));
                        record.put("billing_period_unit", rs.getString("billing_period_unit"));
                        record.put("total_due", rs.getInt("total_due"));
                        record.put("activated_at", rs.getString("activated_at"));
                        record.put("current_term_start", rs.getString("current_term_start"));
                        record.put("current_term_end", rs.getString("current_term_end"));
                        record.put("status", rs.getString("status"));
                        array.add(record);
                    }
                    jsonObject.put("Subscriptions Information", array);
                    return jsonObject;
                }
            }else if (path[1].equals("subscriptions_current_term_end")) {
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                if (path.length == 2) {
                    ResultSet rs = statement.executeQuery("SELECT * FROM subscriptions ORDER BY current_term_end DESC");
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("customer", rs.getInt("customer"));
                        record.put("billing_period", rs.getInt("billing_period"));
                        record.put("billing_period_unit", rs.getString("billing_period_unit"));
                        record.put("total_due", rs.getInt("total_due"));
                        record.put("activated_at", rs.getString("activated_at"));
                        record.put("current_term_start", rs.getString("current_term_start"));
                        record.put("current_term_end", rs.getString("current_term_end"));
                        record.put("status", rs.getString("status"));
                        array.add(record);
                    }
                    jsonObject.put("Subscriptions Information", array);
                    return jsonObject;
                } else if (path.length == 3) {
                    ResultSet rs = statement.executeQuery("SELECT * FROM subscriptions WHERE id=" + path[2]);
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("customer", rs.getInt("customer"));
                        record.put("billing_period", rs.getInt("billing_period"));
                        record.put("billing_period_unit", rs.getString("billing_period_unit"));
                        record.put("total_due", rs.getInt("total_due"));
                        record.put("activated_at", rs.getString("activated_at"));
                        record.put("current_term_start", rs.getString("current_term_start"));
                        record.put("current_term_end", rs.getString("current_term_end"));
                        record.put("status", rs.getString("status"));
                        array.add(record);
                    }
                    jsonObject.put("Subscriptions Information", array);
                    return jsonObject;
                }
            }

            else if (path[1].equals("customer_subscriptions")) {
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                if (path.length == 2) {
                    ResultSet rs = statement.executeQuery(
                            "SELECT c.id AS customer_id, c.first_name, c.last_name, c.email, c.phone_number, " +
                                    "s.id AS subscription_id, s.billing_period, s.billing_period_unit, s.total_due, " +
                                    "s.activated_at, s.current_term_start, s.current_term_end, s.status " +
                                    "FROM customer c " +
                                    "JOIN subscriptions s ON c.id = s.customer " +
                                    "ORDER BY c.id, s.id"
                    );
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("customer_id", rs.getInt("customer_id"));
                        record.put("first_name", rs.getString("first_name"));
                        record.put("last_name", rs.getString("last_name"));
                        record.put("email", rs.getString("email"));
                        record.put("phone_number", rs.getString("phone_number"));
                        record.put("subscription_id", rs.getInt("subscription_id"));
                        record.put("billing_period", rs.getInt("billing_period"));
                        record.put("billing_period_unit", rs.getString("billing_period_unit"));
                        record.put("total_due", rs.getInt("total_due"));
                        record.put("activated_at", rs.getString("activated_at"));
                        record.put("current_term_start", rs.getString("current_term_start"));
                        record.put("current_term_end", rs.getString("current_term_end"));
                        record.put("status", rs.getString("status"));
                        array.add(record);
                    }
                    jsonObject.put("Customer and Subscriptions Information", array);
                    return jsonObject;
                } else if (path.length == 3) {
                    int customerId = Integer.parseInt(path[2]);
                    ResultSet rs = statement.executeQuery(
                            "SELECT c.id AS customer_id, c.first_name, c.last_name, c.email, c.phone_number, " +
                                    "s.id AS subscription_id, s.billing_period, s.billing_period_unit, s.total_due, " +
                                    "s.activated_at, s.current_term_start, s.current_term_end, s.status " +
                                    "FROM customer c " +
                                    "JOIN subscriptions s ON c.id = s.customer " +
                                    "WHERE c.id = " + customerId + " " +
                                    "ORDER BY s.id"
                    );
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("customer_id", rs.getInt("customer_id"));
                        record.put("first_name", rs.getString("first_name"));
                        record.put("last_name", rs.getString("last_name"));
                        record.put("email", rs.getString("email"));
                        record.put("phone_number", rs.getString("phone_number"));
                        record.put("subscription_id", rs.getInt("subscription_id"));
                        record.put("billing_period", rs.getInt("billing_period"));
                        record.put("billing_period_unit", rs.getString("billing_period_unit"));
                        record.put("total_due", rs.getInt("total_due"));
                        record.put("activated_at", rs.getString("activated_at"));
                        record.put("current_term_start", rs.getString("current_term_start"));
                        record.put("current_term_end", rs.getString("current_term_end"));
                        record.put("status", rs.getString("status"));
                        array.add(record);
                    }
                    jsonObject.put("Customer and Subscriptions Information", array);
                    return jsonObject;
                }
            }

            else if (path[1].equals("cards")) {
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                if (path.length==2){
                    ResultSet rs = statement.executeQuery("SELECT * FROM cards");
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("customer", rs.getInt("customer"));
                        record.put("card_type", rs.getString("card_type"));
                        record.put("masked_number", rs.getString("masked_number"));
                        record.put("expiry_month", rs.getInt("expiry_month"));
                        record.put("expiry_year", rs.getInt("expiry_year"));
                        record.put("status", rs.getString("status"));
                        record.put("is_primary", rs.getInt("is_primary"));
                        array.add(record);
                    }
                    jsonObject.put("Cards Information", array);
                    return jsonObject;
                } else if (path.length == 3) {
                    ResultSet rs = statement.executeQuery("SELECT * FROM cards WHERE id = " + path[2]);
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("customer", rs.getInt("customer"));
                        record.put("card_type", rs.getString("card_type"));
                        record.put("masked_number", rs.getString("masked_number"));
                        record.put("expiry_month", rs.getInt("expiry_month"));
                        record.put("expiry_year", rs.getInt("expiry_year"));
                        record.put("status", rs.getString("status"));
                        record.put("is_primary", rs.getInt("is_primary"));
                        array.add(record);
                    }
                    jsonObject.put("Cards Information", array);
                    return jsonObject;
                }
            }
            if (path[1].equals("customer_cards")) {
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                if (path.length == 2) {
                    ResultSet rs = statement.executeQuery(
                            "SELECT c.id AS customer_id, c.first_name, c.last_name, c.email, c.phone_number, " +
                                    "ca.id AS card_id, ca.card_type, ca.masked_number, ca.expiry_month, ca.expiry_year, ca.status, ca.is_primary " +
                                    "FROM customer c " +
                                    "JOIN cards ca ON c.id = ca.customer " +
                                    "ORDER BY c.id, ca.id"
                    );
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("customer_id", rs.getInt("customer_id"));
                        record.put("first_name", rs.getString("first_name"));
                        record.put("last_name", rs.getString("last_name"));
                        record.put("email", rs.getString("email"));
                        record.put("phone_number", rs.getString("phone_number"));
                        record.put("card_id", rs.getInt("card_id"));
                        record.put("card_type", rs.getString("card_type"));
                        record.put("masked_number", rs.getString("masked_number"));
                        record.put("expiry_month", rs.getInt("expiry_month"));
                        record.put("expiry_year", rs.getInt("expiry_year"));
                        record.put("status", rs.getString("status"));
                        record.put("is_primary", rs.getInt("is_primary"));
                        array.add(record);
                    }
                    jsonObject.put("Customer and Cards Information", array);
                    return jsonObject;
                } else if (path.length == 3) {
                    int customerId = Integer.parseInt(path[2]);
                    ResultSet rs = statement.executeQuery(
                            "SELECT c.id AS customer_id, c.first_name, c.last_name, c.email, c.phone_number, " +
                                    "ca.id AS card_id, ca.card_type, ca.masked_number, ca.expiry_month, ca.expiry_year, ca.status, ca.is_primary " +
                                    "FROM customer c " +
                                    "JOIN cards ca ON c.id = ca.customer " +
                                    "WHERE c.id = " + customerId + " " +
                                    "ORDER BY ca.id"
                    );
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("customer_id", rs.getInt("customer_id"));
                        record.put("first_name", rs.getString("first_name"));
                        record.put("last_name", rs.getString("last_name"));
                        record.put("email", rs.getString("email"));
                        record.put("phone_number", rs.getString("phone_number"));
                        record.put("card_id", rs.getInt("card_id"));
                        record.put("card_type", rs.getString("card_type"));
                        record.put("masked_number", rs.getString("masked_number"));
                        record.put("expiry_month", rs.getInt("expiry_month"));
                        record.put("expiry_year", rs.getInt("expiry_year"));
                        record.put("status", rs.getString("status"));
                        record.put("is_primary", rs.getInt("is_primary"));
                        array.add(record);
                    }
                    jsonObject.put("Customer and Cards Information", array);
                    return jsonObject;
                }
            }

            else if (path[1].equals("subscription_items")) {
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                if (path.length == 2){
                    ResultSet rs = statement.executeQuery("SELECT * FROM subscription_items");
                    while (rs.next()){
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("subscriptions", rs.getInt("subscriptions"));
                        record.put("item", rs.getInt("item"));
                        record.put("quantity", rs.getInt("quantity"));
                        record.put("price", rs.getInt("price"));
                        record.put("amount", rs.getInt("amount"));
                        array.add(record);
                    }
                    jsonObject.put("subscription_items Information", array);
                    return jsonObject;
                } else if (path.length == 2) {
                    ResultSet rs = statement.executeQuery("SELECT * FROM subscription_items WHERE id = " + path[2]);
                    while (rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("id", rs.getInt("id"));
                        record.put("subscriptions", rs.getInt("subscriptions"));
                        record.put("item", rs.getInt("item"));
                        record.put("quantity", rs.getInt("quantity"));
                        record.put("price", rs.getInt("price"));
                        record.put("amount", rs.getInt("amount"));
                        array.add(record);
                    }
                    jsonObject.put("subscription_items Information", array);
                    return jsonObject;
                }

            } else if (path[1].equals("shipping_addresses")) {
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                if (path.length == 3){
                    ResultSet rs = statement.executeQuery("SELECT * FROM shipping_addresses");
                    JSONObject record = new JSONObject();
                    record.put("id", rs.getInt("id"));
                    record.put("customer", rs.getInt("customer"));
                    record.put("title", rs.getString("title"));
                    record.put("line1", rs.getString("line1"));
                    record.put("line2", rs.getInt("line2"));
                    record.put("city", rs.getInt("city"));
                    record.put("province", rs.getString("province"));
                    record.put("postcode", rs.getInt("postcode"));
                    array.add(record);
                }
                jsonObject.put("shipping_addresses Information", array);
                return jsonObject;
            } else if (path.length == 3) {
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                ResultSet rs = statement.executeQuery("SELECT * FROM shipping_addresses" + path[2]);
                while (rs.next()) {
                    JSONObject record = new JSONObject();
                    record.put("id", rs.getInt("id"));
                    record.put("customer", rs.getInt("customer"));
                    record.put("title", rs.getString("title"));
                    record.put("line1", rs.getString("line1"));
                    record.put("line2", rs.getInt("line2"));
                    record.put("city", rs.getInt("city"));
                    record.put("province", rs.getString("province"));
                    record.put("postcode", rs.getInt("postcode"));
                    array.add(record);
                }
                jsonObject.put("shipping_addresses Information", array);
                return jsonObject;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public String postData(JSONObject requestBodyJson, String[] path) {
        if (path[1].equals("customer")) {
            String first_name = (String) requestBodyJson.get("First_Name");
            String last_name = (String) requestBodyJson.get("Last_Name");
            String email = (String) requestBodyJson.get("Email");
            String phone_number = (String) requestBodyJson.get("Phone_Number");
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "INSERT INTO customer(first_name, last_name, email, phone_number) VALUES(?,?,?,?)";
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Tugas 2\\untitled\\Sistem.db");
                statement = connection.prepareStatement(query);
                statement.setString(1, first_name);
                statement.setString(2, last_name);
                statement.setString(3, email);
                statement.setString(4, phone_number);
                rowsAffected = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows inserted!");
            return rowsAffected + " rows inserted!";
        } else if (path[1].equals("subscriptions")) {
            int id_customer = Integer.parseInt(requestBodyJson.get("id").toString());
            int billing_period = Integer.parseInt(requestBodyJson.get("billing_period").toString());
            String billing_period_unit = requestBodyJson.get("billing_period_unit").toString();
            int total_due = Integer.parseInt(requestBodyJson.get("total_due").toString());
            String activated_at = requestBodyJson.get("activated_at").toString();
            String current_term_start = requestBodyJson.get("current_term_start").toString();
            String current_term_end = requestBodyJson.get("current_term_end").toString();
            String status = requestBodyJson.get("status").toString();
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "INSERT INTO subscriptions(id, billing_period, billing_period_unit, total_due, activated_at, current_term_start, current_term_end, status) VALUES(?,?,?,?,?,?,?,?)";
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Tugas 2\\untitled\\Sistem.db");
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_customer);
                statement.setInt(2, billing_period);
                statement.setString(3, billing_period_unit);
                statement.setInt(4, total_due);
                statement.setString(5, activated_at);
                statement.setString(6, current_term_start);
                statement.setString(7, current_term_end);
                statement.setString(8, status);
                rowsAffected = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows inserted!");
            return rowsAffected + " rows inserted!";
        } else if (path[1].equals("items")) {
            int id_items = Integer.parseInt(requestBodyJson.get("id").toString());
            String name = requestBodyJson.get("name").toString();
            int price = Integer.parseInt(requestBodyJson.get("price").toString());
            String type = requestBodyJson.get("type").toString();
            int is_active = Integer.parseInt(requestBodyJson.get("is_active").toString());
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "INSERT INTO item(id, name, price, type, is_active) VALUES(?,?,?,?,?)";
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Tugas 2\\untitled\\Sistem.db");
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_items);
                statement.setString(2,name);
                statement.setInt(3, price);
                statement.setString(4,type);
                statement.setInt(5, is_active);
                rowsAffected = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows inserted!");
            return rowsAffected + " rows inserted!";
        }
        return null;
    }

    public String putData(JSONObject requestBodyJson, String[] path) {
        if (path[1].equals("customer")) {
            String first_name = (String) requestBodyJson.get("First_Name");
            String last_name = (String) requestBodyJson.get("Last_Name");
            String email = (String) requestBodyJson.get("Email");
            String phone_number = (String) requestBodyJson.get("Phone_Number");
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "UPDATE customer SET first_name = ?, last_name = ?, email = ?, phone_number = ? WHERE id= " + path[2];
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Tugas 2\\untitled\\Sistem.db");
                statement = connection.prepareStatement(query);
                statement.setString(1, first_name);
                statement.setString(2, last_name);
                statement.setString(3, email);
                statement.setString(4, phone_number);
                rowsAffected = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows updated!");
            return rowsAffected + " rows updated!";
        } else if (path[1].equals("subscriptions")) {
            int id_customer = Integer.parseInt(requestBodyJson.get("id").toString());
            int billing_period = Integer.parseInt(requestBodyJson.get("billing_period").toString());
            String billing_period_unit = requestBodyJson.get("billing_period_unit").toString();
            int total_due = Integer.parseInt(requestBodyJson.get("total_due").toString());
            String activated_at = requestBodyJson.get("activated_at").toString();
            String current_term_start = requestBodyJson.get("current_term_start").toString();
            String current_term_end = requestBodyJson.get("current_term_end").toString();
            String status = requestBodyJson.get("status").toString();
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "UPDATE orders SET id = ?, billing_period = ?, billing_period_unit = ?, total_due = ?, activated_at = ?, current_term_start = ?, current_term_end = ?, status = ?  WHERE id_subscriptions=\" + path[2]) VALUES(?,?,?,?,?,?,?,?)";
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Tugas 2\\untitled\\Sistem.db");
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_customer);
                statement.setInt(2, billing_period);
                statement.setString(3, billing_period_unit);
                statement.setInt(4, total_due);
                statement.setString(5, activated_at);
                statement.setString(6, current_term_start);
                statement.setString(7, current_term_end);
                statement.setString(8, status);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows updated!");
            return rowsAffected + " rows updated!";
        } else if (path[1].equals("items")) {
            int id_items = Integer.parseInt(requestBodyJson.get("Id").toString());
            String name = requestBodyJson.get("name").toString();
            int price = Integer.parseInt(requestBodyJson.get("Price").toString());
            String type = requestBodyJson.get("type").toString();
            int is_activated = Integer.parseInt(requestBodyJson.get("is_activated").toString());
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "UPDATE items SET id = ?, name = ?, price = ?,  type = ?, is_activated = ? WHERE id_product=\" + path[2]";
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Tugas 2\\untitled\\Sistem.db");
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_items);
                statement.setString(2, name);
                statement.setInt(3, price);
                statement.setString(4, type);
                statement.setInt(5, is_activated);
                rowsAffected = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows updated!");
            return rowsAffected + " rows updated!";
        }
        return null;
    }

    public String deleteData(String[] path) {
        PreparedStatement statement = null;
        int rowsAffected = 0;
        try {
            String query = "DELETE FROM " + path[1] + " WHERE id=" + path[2];
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Tugas 2\\untitled\\Sistem.db");
            statement = connection.prepareStatement(query);
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rowsAffected + " rows deleted!";
    }
}