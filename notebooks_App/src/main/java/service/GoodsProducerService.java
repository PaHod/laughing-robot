package service;

import domain.Producer;

import java.util.List;

/**
 * Created by PaHod on 25.01.2015.
 */
public interface GoodsProducerService {
    void addNewProducer(String name, String address, String wedSite);
    List<Producer> getProducerByName(String name);
    List<Producer> FindAllProducers();


}
