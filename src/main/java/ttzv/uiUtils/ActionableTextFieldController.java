package ttzv.uiUtils;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ActionableTextFieldController {

    private final double invisible = 0.0;
    private final double semivisible = 0.4;
    private final double visible = 1.0;

    @FXML
    TextField textField;

    @FXML
    private HBox buttonsHBox;

    @FXML
    private ImageView button1;

    @FXML
    private ImageView button2;



    @FXML
    public void initialize() {

    }

    @FXML
    void btn1Hide(MouseEvent event) {
        this.buttonsHBox.setOpacity(semivisible);
        button1.setOpacity(visible);
        button2.setOpacity(visible);
    }

    @FXML
    void btn1Show(MouseEvent event) {
        this.buttonsHBox.setOpacity(visible);
        button1.setOpacity(visible);
        button2.setOpacity(semivisible);
    }

    @FXML
    void btn2Hide(MouseEvent event) {
        this.buttonsHBox.setOpacity(semivisible);
        button1.setOpacity(visible);
        button2.setOpacity(visible);
    }

    @FXML
    void btn2Show(MouseEvent event) {
        this.buttonsHBox.setOpacity(visible);
        button2.setOpacity(visible);
        button1.setOpacity(semivisible);
    }

    @FXML
    void hideButtons(MouseEvent event) {
        this.buttonsHBox.setOpacity(invisible);
    }

    @FXML
    void showButtons(MouseEvent event) {
        this.buttonsHBox.setOpacity(semivisible);
    }

    public ImageView getButton1() {
        return button1;
    }

    public ImageView getButton2() {
        return button2;
    }

    public HBox getButtonsHBox() {
        return buttonsHBox;
    }

    public TextField getTextField() {
        return textField;
    }
}
