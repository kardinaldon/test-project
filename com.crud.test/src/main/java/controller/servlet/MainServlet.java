package controller.servlet;

import model.PriceData;
import service.ServicePriceData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet ("/")
public class MainServlet extends HttpServlet {
    private ServicePriceData servicePriceData = new ServicePriceData ();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PriceData> priceDataList = servicePriceData.findAllProducts();
        req.setAttribute("priceDataList",priceDataList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("showproducts.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        PriceData priceData = new PriceData(name,code,price);
        servicePriceData.savePriceData(priceData);
        resp.sendRedirect("http://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/pricedata");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        PriceData priceData = servicePriceData.findPriceDataFromId(id);
        priceData.setCode(req.getParameter("code"));
        priceData.setName(req.getParameter("name"));
        priceData.setPrice(Double.parseDouble(req.getParameter("price")));
        servicePriceData.updatePriceData(priceData);
        resp.sendRedirect("http://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/pricedata");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        servicePriceData.deletePriceData(servicePriceData.findPriceDataFromId(id));
        resp.sendRedirect("http://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/pricedata");
    }
}
