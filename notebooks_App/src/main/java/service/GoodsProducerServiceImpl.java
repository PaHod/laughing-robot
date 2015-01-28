package service;

import dao.ProducerDAO;
import domain.Producer;

import java.util.List;

/**
 * Created by PaHod on 25.01.2015.
 */
public class GoodsProducerServiceImpl implements GoodsProducerService {

    private ProducerDAO producerDAO;

    public GoodsProducerServiceImpl(ProducerDAO producerDAO) {
        this.producerDAO = producerDAO;
    }

    @Override
    public void addNewProducer(String name, String address, String wedSite) {
        if (name != null && address != null && wedSite != null) {
            Producer producer = new Producer(name, address, wedSite);
            producerDAO.create(producer);
        }
    }

    @Override
    public List<Producer> getProducerByName(String name) {
        if (name != null) {

            return producerDAO.findByName(name);
        }

        return null;
    }

    @Override
    public List<Producer> FindAllProducers() {
        return null;
    }


}
