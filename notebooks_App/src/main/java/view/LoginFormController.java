package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by PaHod on 25.01.2015.
 */
public class LoginFormController {
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancel;

    @FXML
    public void onClickMethod(){
        System.out.println("1");
        if(btnLogin.getText()=="Cancel"){
            System.out.println("2");

            btnLogin.setText("Login");
            btnCancel.setText("Cancel");

        }else {

            btnLogin.setText("Cancel");
            btnCancel.setText("Login");
        }
    }

}
