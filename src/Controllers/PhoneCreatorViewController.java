package Controllers;

import Models.DBConnect;
import Models.MobilePhone;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class PhoneCreatorViewController implements Initializable {
    @FXML
    private ChoiceBox<String> makeChoiceBox;

    @FXML
    private TextField modelTextField;

    @FXML
    private ChoiceBox<String> osChoiceBox;

    @FXML
    private TextField screenSizeTextField;

    @FXML
    private Slider slider;

    @FXML
    private Label memorySlider;

    @FXML
    private TextField frontCameraTextField;

    @FXML
    private TextField rearCameraTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<String> osOptions =  Arrays.asList("iOS","Blackberry","Android");
        osChoiceBox.getItems().addAll(osOptions);

        //Preload the ChoiceBox with valid manufacturers
        try {
            makeChoiceBox.getItems().addAll(DBConnect.getPhoneManufacturers());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        makeChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)->
                {
                    try {
                        osChoiceBox.setValue(DBConnect.getOSForManufacturer(newValue));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        );


    }

    public void createPhoneButtonPushed() throws SQLException {

        MobilePhone newPhone = new MobilePhone(

                makeChoiceBox.getValue(),
                modelTextField.getText(),
                osChoiceBox.getValue(),
                Double.parseDouble(screenSizeTextField.getText()),
                        64,
                        Double.parseDouble(frontCameraTextField.getText()),
                                Double.parseDouble(rearCameraTextField.getText()),
                                        Double.parseDouble(priceTextField.getText()
                                ));
        DBConnect.insertPhoneIntoDB(newPhone);
    }



}
