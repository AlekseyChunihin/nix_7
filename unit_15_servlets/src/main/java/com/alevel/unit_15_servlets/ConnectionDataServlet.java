package com.alevel.unit_15_servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "connection-data-servlet", urlPatterns = "/list")
public class ConnectionDataServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(ConnectionDataServlet.class);

    private static final Set<String> userConnectionData = ConcurrentHashMap.newKeySet();

    @Override
    public void init() {
        log.info(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ipAddress = req.getRemoteAddr();
        String userAgent = req.getHeader("User-Agent");
        String userData = ipAddress + " :: " + userAgent;
        userConnectionData.add(userData);
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");
        responseBody.println("<h1 align=\"center\">Your IP and User-agent</h1>");
        responseBody.println("<ul>");
        for (String data : userConnectionData) {
            if (data.equals(userData)) {
                responseBody.println("<li><b>Ip : " + userData + "</b></li>");
            } else {
                responseBody.println("<li>Ip : " + userData + "</li>");
            }
            responseBody.println("----------------------------------------------------------------------------------------------------------------------------------");
        }
        responseBody.println("</ul>");
    }

    @Override
    public void destroy() {
        log.info(getServletName() + " destroyed");
    }
}

