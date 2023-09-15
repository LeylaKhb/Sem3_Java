package itis.khabibullina.net.server;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "myServlet", urlPatterns = "/hello")

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printMethodInfo("GET", req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printMethodInfo("POST", req);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printMethodInfo("POST", req);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printMethodInfo("POST", req);
    }

    private void printMethodInfo(String method, HttpServletRequest req) {
        System.out.println(method + ":");
        printHeaders(req);
        printParameters(req);
        printBody(req);
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("Headers:");
        List<String> headerValuesList = Collections.list(req.getHeaderNames());
        for (String name : headerValuesList) {
            System.out.println(name + ": " + req.getHeader(name));
        }
        System.out.println();
    }

    private void printParameters(HttpServletRequest req) {
        System.out.println("Parameters:");
        for (Map.Entry<String, String[]> pair : req.getParameterMap().entrySet()) {
            System.out.print(pair.getKey() + ": " + String.join(", ", pair.getValue()));
        }
        System.out.println();
    }

    private void printBody(HttpServletRequest req) {
        System.out.println("Body:");
        try {
            System.out.println(req.getReader().lines().collect(Collectors.joining("\n")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }
}

