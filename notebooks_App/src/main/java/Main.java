/*import dao.ProducerDAO;
import dao.ProducerDAOImpl;
import org.hibernate.SessionFactory;
import service.GoodsProducerService;
import service.GoodsProducerServiceImpl;
import utils.HibernateUtil;
import view.View;*/


import dao.ProducerDAO;
import dao.ProducerDAOImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import service.GoodsProducerService;
import service.GoodsProducerServiceImpl;
import utils.HibernateUtil;
import view.View;

/**
 * Created by PaHod on 24.01.2015.
 */
public class Main  /*extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getHeight()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/
{
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //    ClientDao clientDao = new ClientHibernateDaoImpl(sessionFactory);
//    DoctorDao doctorDao = new DoctorDaoImpl(sessionFactory);
//    ClientService clientService = new ClientServiceImpl(clientDao, doctorDao);
        ProducerDAO producerDAO = new ProducerDAOImpl(sessionFactory);
        GoodsProducerService goodsProducerService = new GoodsProducerServiceImpl(producerDAO);
        View menuView = new View(goodsProducerService);
        menuView.doSome();
    }


}
