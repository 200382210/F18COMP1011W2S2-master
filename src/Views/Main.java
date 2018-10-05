package Views;

import Models.DBConnect;
import Models.MobilePhone;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    public static void main(String[] args)
    {
       /* MobilePhone newPhone = new MobilePhone("Apple","Jdub","iOS",10.1,512.0,12.2,24,1000);

        try {
            DBConnect.insertPhoneIntoDB(newPhone);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PhoneCreatorView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Create Mobile Phone");
        primaryStage.show();
    }
}
