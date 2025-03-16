package com.project.servlets.services;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletUtil {
    public static void writeJson(HttpServletResponse response, String json) throws IOException{
        if(json != null){
            PrintWriter writer = response.getWriter();
            response.setContentType("apllication/json;charset=UTF-8");
            writer.write(json);
            writer.close();
        }
    }
}
