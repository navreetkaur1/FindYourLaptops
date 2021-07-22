package Controllers;
import Models.Laptop;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This will help to connect fmxl to controller
 */
public class LaptopDetailsViewController implements Initializable {
    private ObservableList<Laptop> laptopList = FXCollections.observableArrayList();;
    private Laptop getLaptop;
    @FXML private Label companyName;
    @FXML  private Label productName;
    @FXML private Label type;
    @FXML private Label screenResolution;
    @FXML private Label cpu;
    @FXML private Label ram;
    @FXML private Label memory;
    @FXML private Label gpu;
    @FXML private Label operatingSystem;
    @FXML private Label weight;
    @FXML private Label inches;
    @FXML private Label price;

    /**
     * this class will take laptop from our laptopView controller and help to populate the labels in this view
     * @param laptop
     */
    public void intData(Laptop laptop){
        getLaptop = laptop;
        companyName.setText(laptop.getCompany());
        productName.setText(laptop.getProduct());
        type.setText(laptop.getTypeName());
        screenResolution.setText(laptop.getScreenResolution());
        cpu.setText(laptop.getCpu());
        ram.setText(laptop.getMemory());
        memory.setText(laptop.getMemory());
        gpu.setText(laptop.getGpu());
        operatingSystem.setText(laptop.getOpSys());
        weight.setText(String.valueOf(laptop.getInches()));
        inches.setText(String.valueOf(laptop.getInches()));
        price.setText(String.valueOf(laptop.getPriceError()));
    }

    /**
     * this method will store the list of laptops from laptopView view.
     * @param laptop
     */
    public void intDataList(ObservableList<Laptop> laptop){
        laptopList = laptop;
    }

    /**
     * this method will help to change the scene and take list to another view
     * @param event
     * @param viewName
     * @param title
     * @throws IOException
     */
    public void changeScene(MouseEvent event, String viewName, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(viewName));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        LaptopViewController controller = loader.getController();
        controller.intDataList(laptopList);
        stage.setTitle(title);
        stage.getIcons().add(new Image("Views/Store.png"));
        stage.show();
    }

    /**
     * when user will click on button it will call changeScene method
     * @param event
     */
        @FXML
    void back(MouseEvent event) {
        try {
            changeScene(event, "/Views/laptopView.fxml","Laptop Store");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
