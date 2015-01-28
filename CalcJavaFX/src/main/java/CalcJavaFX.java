import android.hardware.GeomagneticField;
import javafx.animation.RotateTransition;
import javafx.event.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.PointLight;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by PaHod on 25.01.2015.
 */
public class CalcJavaFX {
    private static final String defaultFldInput="0";
    private static final String defaultLblTask="";
    private static final String defaultLblResult="result";
    private final DecimalFormat f;
    private String lasOperation;
    private String lastMathOperation;
    private Double lastResult;
    private Double secondSummand;


@FXML
    private PointLight point3D;
    @FXML
    private TextField fldInput;
    @FXML
    private Label lblResult;
    @FXML
    private Label lblTask;
    @FXML
    private Button btn00;
    @FXML
    private Button btn0;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btnDot;
    @FXML
    private Button btnPlus;
    @FXML
    private Button btnMinus;
    @FXML
    private Button btnMulti;
    @FXML
    private Button btnDedvide;
    @FXML
    private Button btnResult;
    @FXML
    private Button btnPercenr;
    @FXML
    private Button btnSquare;
    @FXML
    private Button btnSqrt;
    @FXML
    private GridPane gridPaneCalc;  //объявление полей и кнопок

    public CalcJavaFX() {
        DecimalFormatSymbols s = new DecimalFormatSymbols();
        s.setDecimalSeparator('.');
        DecimalFormat f = new DecimalFormat("#,##0.00", s);
        this.f = f;
    }

    private void shakeButtons(Button shakeBtn) {



        RotateTransition rt = new RotateTransition(Duration.millis(50), shakeBtn);
//        rt.setFromAngle(-5d); //
        rt.setByAngle(10);
//        rt.setToAngle(5d);
        rt.setCycleCount(4);
        rt.setAutoReverse(true);
        rt.play();
//        rt.setOnFinished();
//        rt.getOnFinished(shakeBtn.setRotate(0d));

    }

    // for numbers buttons
    @FXML
    public void onClickNumbers(Event event) {
        Button clickedBtn = (Button) event.getTarget();
        shakeButtons(clickedBtn);
        String curBtnText = clickedBtn.getText();
        String curFldInputText = fldInput.getText();
if (lasOperation!=null){
    if(lasOperation.equals("=")){
        return;}
}


    if (curFldInputText.equals(defaultFldInput)&&!curBtnText.equals(".")) {
        if (!curBtnText.equals("00")){
            fldInput.setText(curBtnText);
        }
    } else if(curFldInputText.contains(".")&&curBtnText.equals(".")){
        return;

    }  else {
        fldInput.setText(curFldInputText + curBtnText);
    }
}

    //!!!!!!!!!!!!!!!!! точка перед плюсом

    @FXML
    // for 4 operation ( + , - , * , / )
    public void onClickOperations(ActionEvent actionEvent) {
        Button clickedBtn = (Button) actionEvent.getTarget();
        String curFldInputText = fldInput.getText();
        shakeButtons(clickedBtn);
        if (!curFldInputText.equals(defaultFldInput) || lasOperation!=null && lasOperation.equals("=")) {
            String curOperation = clickedBtn.getText();
            String curLblTaskText = lblTask.getText();
            if (curLblTaskText.equals(defaultLblTask)) {
                lblTask.setText(curFldInputText + curOperation);
                lastResult = Double.valueOf(curFldInputText);
            } else if(lasOperation.equals("=")){
                if(curOperation.equals("=")){
                    lblTask.setText(f.format(lastResult)+lastMathOperation+f.format(secondSummand)+"=");
                    mathOperations(lastMathOperation);
                }else {
                    lblTask.setText(f.format(lastResult) + curOperation );
                }
            }else {
                secondSummand = Double.valueOf(curFldInputText);
                mathOperations(lasOperation);

                switch (curOperation) {
                    case "*":
                        lblTask.setText("(" + curLblTaskText + curFldInputText + ")" + curOperation);
                        break;
                    case "/":
                        lblTask.setText("(" + curLblTaskText + curFldInputText + ")" + curOperation);
                        break;
                    case "+":
                        lblTask.setText(curLblTaskText + curFldInputText + curOperation);
                        break;
                    case "-":
                        lblTask.setText(curLblTaskText + curFldInputText + curOperation);
                        break;
                    case "=":
                        lblTask.setText(curLblTaskText + curFldInputText + curOperation + f.format(lastResult));
                        break;

                }

            }



            lasOperation = curOperation;
            if(!curOperation.equals("=")){
                lastMathOperation = curOperation;
            }
            lblResult.setText(String.valueOf(lastResult));
            fldInput.setText(defaultFldInput);
        }


    }
private void mathOperations(String operation){
    switch (operation) {
        case "*":
            lastResult = lastResult * secondSummand;
            break;
        case "/":
            lastResult = lastResult / secondSummand;
            break;
        case "+":
            lastResult = lastResult + secondSummand;
            break;
        case "-":
            lastResult = lastResult - secondSummand;
            break;


    }}

    public void onClickBtnC(ActionEvent actionEvent) {
        fldInput.setText(defaultFldInput);
        lblTask.setText(defaultLblTask);
        lblResult.setText(defaultLblResult);
        lastResult=null;
        secondSummand =null;
        lasOperation=null;
    }

    public void onClickBtnBackspace(ActionEvent actionEvent) {

        String curFldInputText = fldInput.getText();
        if(!curFldInputText.equals(defaultFldInput)){
            if(curFldInputText.length()<=1){
                fldInput.setText(defaultFldInput);
            }else {

                fldInput.setText(curFldInputText.substring(0, curFldInputText.length()-1));
            }

        }



    }


    public void onClick(ActionEvent actionEvent) {
    }

    public void onClickGoTo(ActionEvent actionEvent) {

    }


}
