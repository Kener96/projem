package sample;

import Connectivity.DbHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class YeniSayfa <Registers> implements Initializable {

    public TextField texf_soyad;
    public TextField textf_numara;
    public TextField textf_mail;
    public TextField textf_bolum;
    public Button btn_kaydet;
    public TextField textf_ad;
   // public TableColumn mailColumn;

    @FXML
    Button geriDon;
    @FXML
    TextField tf_ad;
    TextField tf_soyad;
    TextField tf_numara;
    TextField tf_mail;
    TextField tf_bolum;
    @FXML
    Label lbl_deneme;


    @FXML
    private TableView<Registers> TableView;

    @FXML
    private TableColumn<Registers, String> adColumn;

    @FXML
    private TableColumn<Registers, String> soyadColumn;

    @FXML
    private TableColumn<Registers, String> numaraColumn;

    @FXML
    private TableColumn<Registers, String> bolumColumn;

    @FXML
    private TableColumn<Registers, String> mailColumn;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        geriDon.setOnAction(event -> {
            Stage stage=(Stage)geriDon.getScene().getWindow();
            //stage.setTitle("Yeni Pencere");
            stage.close();
        });


  /*      btn_kaydet.setOnAction(event -> {
            lbl_deneme.setText(textf_ad.getText());
        });

        */
        btn_kaydet.setOnAction(event -> {
            insert_student();
        });
       //
        showRegisters();
        //
    }

    private void insert_student() {

        String query="insert into registers values('"+tf_ad.getText()+",'"+tf_soyad.getText()+"','"+tf_bolum.getText()+"','"+tf_mail.getText()+"','"+tf_numara.getText()+"')";
        executeQuery(query);
     showRegisters();

    }






    private ObservableList<Registers> getRegistersList() {
        ObservableList<Registers> registersList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM registers ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Registers registers;
            while(rs.next()) {
               // registers = new Registers(rs.getString("ogrenci_ad"),rs.getString("ogrenci_soyad"),rs.getString("ogrenci_numara"),rs.getString("ogrenci_mail"),rs.getString("ogrenci_bolum"));
                //registersList.add(registers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registersList;
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Connection getConnection() {
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

    public void showRegisters() {
        ObservableList<Registers> list = getRegistersList();

        adColumn.setCellValueFactory(new PropertyValueFactory<Registers,String>("ogrenci_ad"));
        soyadColumn.setCellValueFactory(new PropertyValueFactory<Registers,String>("ogrenci_soyad"));
        bolumColumn.setCellValueFactory(new PropertyValueFactory<Registers,String>("ogrenci_bolum"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<Registers,String>("ogrenci_mail"));
        numaraColumn.setCellValueFactory(new PropertyValueFactory<Registers,String>("ogrenci_numara"));

        TableView.setItems(list);

    }

}
