package Controllers;
import Models.Laptop;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LaptopViewController  implements Initializable {
    @FXML private TextField name;
    @FXML private ListView<Laptop> detail;
    private ObservableList<Laptop> laptopList = FXCollections.observableArrayList();;
    @FXML private Label numberOfRows;
    @FXML private Label helpUsers;

    /**
     * this method will call updateScene method when action is done
     * @param event
     * @throws IOException
     */
    @FXML void search(ActionEvent event) throws IOException {
         updateScene(name.getText());
    }

    /**
     * this method will chc=eck if laptop list is empty or not
     * @param laptop
     */
    public void intDataList(ObservableList<Laptop> laptop){
        laptopList = laptop;
        if (!laptop.isEmpty()){
            detail.setItems(laptop);
            numberOfRows.setText("Number of rows: "+String.valueOf(detail.getItems().size()));
        }
    }

    /**
     * this method will read json file and filter according to user enter value
     * @param search
     * @throws FileNotFoundException
     */
    private void  updateScene(String search) throws FileNotFoundException {
        Gson gson = new Gson();
         Reader reader = new FileReader("src/Utilities/laptops.json");
        Laptop[] thing = gson.fromJson(reader, Laptop[].class);
        detail.getItems().clear();
        for (int i =0; i< thing.length; i++){
            if (search.equalsIgnoreCase(thing[i].getCompany())){
                laptopList.add(thing[i]);
                detail.setItems(laptopList);
            }
            else if (search.equalsIgnoreCase(thing[i].getOpSys())){
                laptopList.add(thing[i]);
                detail.setItems(laptopList);
            }
            else if (search.equalsIgnoreCase(thing[i].getTypeName())){
                laptopList.add(thing[i]);
                detail.setItems(laptopList);
            }
        }
        numberOfRows.setText("Number of rows: "+String.valueOf(detail.getItems().size()));
    }

    /**
     * this method will launch if laplist list is not empty
     * @param event
     * @throws IOException
     */
    @FXML
    void change(MouseEvent event) throws IOException {
        if (!laptopList.isEmpty()){
            viewLaptop(event);
        }
    }

    /**
     * this method launch when fxml file is loaded
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numberOfRows.setText("");
        helpUsers.setText("Hi Welcome to our laptop Store. Here You can search laptop based on 1) Company name like: apple, hp etc. " +
                "2) Based on operating system like: windows 10, macos etc. 3) based on laptop type: ultrabook , gaming, netbook, notebook ..\n\n" +
                " When you get the list of laptops you can click on particular laptop to see more details");
        if (!laptopList.isEmpty()){
            detail.setItems(laptopList);
            numberOfRows.setText(String.valueOf(detail.getItems().size()));
        }
    }

    /**
     * This method will take to another fxml file
     * @param actionEvent
     * @throws IOException
     */
    public void viewLaptop(MouseEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/laptopDetailsView.fxml"));
        Parent activitiesView = loader.load();
        Scene activitiesScene = new Scene(activitiesView);
        LaptopDetailsViewController controller = loader.getController();
        controller.intData(detail.getSelectionModel().getSelectedItem());
        controller.intDataList(laptopList);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(activitiesScene);
        window.getIcons().add(new Image("/Views/laptop.jpeg"));
        window.setTitle("View Laptop Detail");
        window.show();
    }
}
