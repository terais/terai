package terai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import terai.controller.loader.TeraiSpringFXMLLoader;
/**
 * TeraiApplication.
 * @author terai. 2019/06/10.
 */
@SpringBootApplication
public class TeraiApplication extends Application {
    /**
     * context.
     */
    private static ConfigurableApplicationContext context;
    public static void main(String[] args) {
        context = SpringApplication.run(TeraiApplication.class, args);
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        TeraiSpringFXMLLoader loader = context.getBean(TeraiSpringFXMLLoader.class);
        Parent root = loader.load("terai/controller/terai.fxml");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void stop() throws Exception {
        context.close();
    }
}
