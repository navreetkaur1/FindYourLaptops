import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main  extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method will help us to launch our first scene which is related to laptopView.fxml file
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/laptopView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Laptop Store");
        stage.getIcons().add(new Image("/Views/Store.png"));
        stage.show();
    }
}
