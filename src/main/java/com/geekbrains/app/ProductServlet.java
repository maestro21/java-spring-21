package com.geekbrains.app;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.ArrayList;

public class ProductServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Log: GET");
        response.setContentType("text/html");

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1,"Bread", 0.10));
        products.add(new Product(2,"Milk", 0.49));
        products.add(new Product(3,"TV", 500.00));
        products.add(new Product(4,"Car", 34000.00));
        products.add(new Product(5,"Vodka", 1.15));
        products.add(new Product(6,"Water", 0.35));
        products.add(new Product(7,"Pineaple", 2.40));
        products.add(new Product(8,"Water", 1.05));
        products.add(new Product(9,"Notebook", 999.00));
        products.add(new Product(10,"Ticket", 10));
        /*
        PrintWriter out = response.getWriter();
        out.printf("<html>" +
                "<head>" +
                "   <meta charset=\"utf-8\" />" +
                "</head>" +
                "<body>" +
                "   <h1>Products</h1>" +
                "   <table>" +
                "       <tr>" +
                "           <th>ID</th>" +
                "           <th>Title</th>" +
                "           <th>Price</th>" +
                "       </tr>");
        for(int i = 0; i < 10; i++) {
            Product product = products.get(i);
            out.printf("<tr>" +
                    "<td>" + product.getId() + "</td>" +
                    "<td>" + product.getTitle() + "</td>" +
                    "<td>" + product.getCost() + "</td>" +
                    "</tr>");
        }
        out.printf("</table></body></html>");
        out.close(); */

        request.setAttribute("products", products);
        request.getRequestDispatcher("products.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Log: POST");
        resp.getWriter().printf("<html><body><h1>New POST request</h1></body></html>");
    }

    @Override
    public void destroy() {
        logger.debug("Destroy");
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}