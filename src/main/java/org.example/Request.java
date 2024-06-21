package org.example;

import com.sun.net.httpserver.HttpExchange;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.InputStream;

import java.io.IOException;

public  class Request {
    public void handleGetRequest(HttpExchange exchange, String[] path, String query) throws IOException{
        Response response = new Response();
        Data data = new Data();
        if ("customer".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(),200);
        } else if ("subscriptions".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(), 200);
        } else if ("items".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(), 200);
        } else if ("cards".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(), 200);
        } else if ("subscription_items".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(), 200);
        } else if ("shipping_addresses".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(), 200);
        } else if ("customer_cards".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(), 200);
        }else if ("customer_subscriptions".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(), 200);
        }else if ("subscriptions_current_term_end".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(), 200);
        }else if ("items_is_active?is_active=true".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(), 200);
        }
        {response.sendResponse(exchange, "\n<h1><center>404</center></h1>\n<h3><center>Not Found!</center></h3>");
        }
    }

    public void handlePostRequest(HttpExchange exchange, String[] path, String query) throws IOException, ParseException{
        Response response = new Response();
        Data data = new Data();
        if(path[1].equals("customer")){
            JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
            response.getResponse(exchange, data.postData(requestBody, path), 200);
        }else if(path[1].equals("items")){
            JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
            response.getResponse(exchange, data.postData(requestBody, path), 200);
        }else if(path[1].equals("subscription")){
            JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
            response.getResponse(exchange, data.postData(requestBody, path), 200);
        } else if (path[1].equals("subscription_items")) {
            JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
            response.getResponse(exchange, data.postData(requestBody, path), 200);
        } else if (path[1].equals("shipping_addresses")) {
            JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
            response.getResponse(exchange, data.postData(requestBody, path), 200);
        }
    }

    public void handlePutRequest(HttpExchange exchange, String[] path, String query) throws IOException, ParseException{
        Response response = new Response();
        Data data = new Data();
        if(path.length != 3){
            response.getResponse(exchange, "URL Anda Tidak Tepat", 0);
        }else {
            if(path[1].equals("customer")){
                JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
                response.getResponse(exchange, data.putData(requestBody, path), 200);
            }else if(path[1].equals("items")){
                JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
                response.getResponse(exchange, data.putData(requestBody, path), 200);
            }else if(path[1].equals("subscription")){
                JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
                response.getResponse(exchange, data.putData(requestBody, path), 200);
            } else if (path[1].equals("subscription_items")) {
                JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
                response.getResponse(exchange, data.putData(requestBody, path), 200);
            }else if (path[1].equals("shipping_addresses")) {
                JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
                response.getResponse(exchange, data.putData(requestBody, path), 200);

            }
        }
    }
    public void handleDeleteRequest(HttpExchange exchange, String[] path, String query) throws IOException, ParseException{
        Response response = new Response();
        Data data = new Data();
        if(path.length != 3){
            response.getResponse(exchange, "MAAF URL ANDA SALAH", 0);
        }else {
            if(path[1].equals("customer")){
                response.getResponse(exchange, data.deleteData(path), 200);
            }else if(path[1].equals("items")){
                response.getResponse(exchange, data.deleteData(path), 200);
            }else if(path[1].equals("subscription")){
                response.getResponse(exchange, data.deleteData(path), 200);
            }else if(path[1].equals("subscription_items")) {
                response.getResponse(exchange, data.deleteData(path), 200);
            }else if(path[1].equals("shipping_addresses")) {
                response.getResponse(exchange, data.deleteData(path), 200);
            }
        }
    }
    private static JSONObject parseRequestBody(InputStream reqBody) throws ParseException,IOException{
        JSONParser jsonParser = new JSONParser();

        byte[] requestBodyBytes = reqBody.readAllBytes();
        String reqBodyString = new String(requestBodyBytes);
        return (JSONObject) jsonParser.parse(reqBodyString);
    }

}