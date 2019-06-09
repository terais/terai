package terai.controller;

import org.springframework.stereotype.Controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

@Controller
public class ErrorController {
    public void error(String msg) throws Exception {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Label label = new Label(msg);
        Parent root = new ScrollPane(label);
        Scene scene = new Scene(root,200,200);
        stage.setScene(scene);
        stage.show();
    }
}
