package service;

import dao.PriceDataDAO;
import model.PriceData;
import utils.readExcel.ReadExcel;

import java.io.IOException;
import java.util.List;

public class ServicePriceData {
    private PriceDataDAO priceDataDAO = new PriceDataDAO();

    public ServicePriceData() {
    }

    public PriceData findPriceDataFromId(int id) {
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

    public void addAllProductsInPriceFromExcel() throws IOException {
        ReadExcel readExel = new ReadExcel();
        readExel.getProducts();
    }

    public void addAllProductsInPriceFromRestJson(List<PriceData> priceDataList) throws IOException {
        for (PriceData priceData: priceDataList) {
            PriceDataDAO priceDataDAO = new PriceDataDAO();
            priceDataDAO.save(priceData);
        }
    }

}
