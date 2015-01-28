package view;

import domain.Producer;
import service.GoodsProducerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PaHod on 24.01.2015.
 */
public class View {
private GoodsProducerService goodsProducerService;


    public View(GoodsProducerService goodsProducerService) {
        this.goodsProducerService = goodsProducerService;
    }

    public  void doSome(){
        goodsProducerService.addNewProducer("ASUS", "Asusland, Note str. 1", "www.ASUS.com");
        goodsProducerService.addNewProducer("DELL", "Dellland, Note str. 1", "www.Dell.com.eu");
        goodsProducerService.addNewProducer("APPLE", "California, Apple ofice 1", "www.APPLE.us");

        List<Producer> producers= goodsProducerService.getProducerByName("ASUS");
        if (producers!=null&& producers.size()>0) {
          for(Producer el:producers){
              System.out.println(el);
          }
        }


    }



}
