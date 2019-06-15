package terai.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import terai.dto.TeraiDto;
import terai.logic.TeraiLogic;

/**
 * main controller.
 * @author terai. 2019/06/10.
 */
@Controller
public class TeraiController implements Initializable {
    /**
     * logic.
     */
    @Autowired
    private TeraiLogic teraiLogic;
    /**
     * error handle.
     */
    @Autowired
    private ErrorController errorController;
    /**
     * input cretae path.
     */
    @FXML
    private TextField textFieldCretaePath;
    /**
     * select create schema.
     */
    @FXML
    private TextField textFieldCreateScema;
    /**
     * input insert path.
     */
    @FXML
    private TextField textFieldInsertPath;
    /**
     * select insert schema.
     */
    @FXML
    private TextField textFieldInsertScema;
    /**
     * click exec create quey.
     * @param evt event.
     * @throws Exception exception.
     */
    @FXML
    public void onCreateBtnClick(ActionEvent evt)
        throws Exception {
        this.execQuery("CREATE");
    	}
    /**
     * click refer create path.
     * @param evt event.
     */
    @FXML
    public void refCreatePathBtnClick(ActionEvent evt) {
        this.execRefer();
    }
    /**
     * click exec insert quey.
     * @param evt event.
     * @throws Exception exception.
     */
    @FXML
    public void onInsertBtnClick(ActionEvent evt)
        throws Exception {
        this.execQuery("INSERT");
    	}
    /**
     * click refer insert path.
     * @param evt event.
     */
    @FXML
    public void refInsertPathBtnClick(ActionEvent evt) {
        this.execRefer();
    }
    /**
     * exec query.
     * @param type event type.
     * @throws Exception exception.
     */
    private void execQuery(String type)  throws Exception {
        if (this.textFieldCretaePath.getText() != null) {
            int resultCode = 0;
            TeraiDto getFileNameDto
                = this.teraiLogic.getFileNameList(
                this.textFieldCretaePath.getText() + "/"
                + this.textFieldCreateScema.getText() + "/", type);
            if (!getFileNameDto.getErrorFlag()) {
                resultCode = this.teraiLogic.getQueryContents(
                    getFileNameDto.getNameList()
                    , this.textFieldCreateScema.getText(), type);
            } else {
                resultCode = 0;
            }
            if (resultCode == 0) {
                this.errorController.error("no target file!");
            }
        }
    }
    /**
     * exec refer.
     */
    private void execRefer() {
        DirectoryChooser fc = new DirectoryChooser();
        fc.setTitle("select folder");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        File file = fc.showDialog(null);
        if (file != null) {
            this.textFieldCretaePath.setText(file.getPath());
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
//test
