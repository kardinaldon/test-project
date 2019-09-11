package dao;

import org.hibernate.TypeHelper;
import org.hibernate.boot.model.source.spi.HibernateTypeSource;
import utils.HibernateSessionFactoryUtil;
import model.PriceData;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PriceDataDAO {
    public PriceData findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PriceData.class, id);
    }


    public void save(PriceData priceData) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(priceData);
        transaction.commit();
        session.close();
    }

    public void update(PriceData priceData) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(priceData);
        transaction.commit();
        session.close();
    }

    public void delete(PriceData priceData) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(priceData);
        transaction.commit();
        session.close();
    }

    public void deleteAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM model.PriceData").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public List<PriceData> findAll() {
        List<PriceData> priceDataList = (List<PriceData>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From model.PriceData").list();
        return priceDataList;
    }
}
