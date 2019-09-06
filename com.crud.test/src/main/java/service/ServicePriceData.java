package service;

import dao.PriceDataDAO;
import model.PriceData;
import readExcel.ReadExcel;

import java.io.IOException;
import java.util.List;

public class ServicePriceData {
    private PriceDataDAO priceDataDAO = new PriceDataDAO();

    public ServicePriceData() {
    }

    public PriceData findPriceData(int id) {
        return priceDataDAO.findById(id);
    }

    public void savePriceData(PriceData priceData) {
        priceDataDAO.save(priceData);
    }

    public void deletePriceData(PriceData priceData) {
        priceDataDAO.delete(priceData);
    }

    public void deleteAllPriceData() {
        priceDataDAO.deleteAll();
    }

    public void updatePriceData(PriceData priceData) {
        priceDataDAO.update(priceData);
    }

    public List<PriceData> findAllProducts() {
        return priceDataDAO.findAll();
    }

    public void addAllProductsFromPrice () throws IOException {
        ReadExcel readExel = new ReadExcel();
        readExel.getProducts();
    }
}
