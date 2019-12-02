package sample;
import java.net.ConnectException;
import java.sql.*;

import Connectivity.DbHelper;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


//import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button btnAc;//butonu algılaması için java.awt  yi kaldırdık

    @FXML
     Button btn_kaydet;

    @FXML
    TextField tf_ad;
    TextField tf_soyad;
    TextField tf_numara;
    TextField tf_mail;
    TextField tf_bolum;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnAc.setOnAction(event -> {

            try {
                Parent rootNode = FXMLLoader.load(getClass().getResource("yenisayfa.fxml"));
                Stage stage=new Stage();
                Scene scene=new Scene(rootNode);
                stage.setScene(scene);
                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }


        });




    }

  /*  public void insert_student(){

        String query="insert into registers values('"+tf_ad.getText()+",'"+tf_soyad.getText()+"','"+tf_bolum.getText()+"','"+tf_mail.getText()+"','"+tf_numara.getText()+"')";
        executeQuery(query);

    }*/

   /* private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    */

  /*  private Connection getConnection() {


        Connection conn;
        try {
            DbHelper helper=new DbHelper();
            conn=helper.getConnection();

           // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","admin");
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
*/

}
