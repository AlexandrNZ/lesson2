
package org.example;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        JSONObject params = new JSONObject("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");

        StringBuilder whereClause = new StringBuilder("select * from students where ");

        boolean isFirstParam = true;
        for (String key : params.keySet()) {
            String value = params.getString(key);
            if (!"null".equals(value)) {
                if (!isFirstParam) {
                    whereClause.append(", ");
                }
                whereClause.append(key).append("=").append(value);
                isFirstParam = false;
            }
        }

        String sqlQuery = whereClause.toString();
        System.out.println(sqlQuery);
    }
}