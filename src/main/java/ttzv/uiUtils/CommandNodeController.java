package ttzv.uiUtils;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CommandNodeController {

    @FXML
    private TextArea content;

    @FXML
    private Button btnCopy;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Label title;

    @FXML
    private TextField titleField;

    @FXML
    private TextField tagsField;

    @FXML
    public void initialize(){}

    public TextArea getContent() {
        return content;
    }

    public Button getBtnCopy() {
        return btnCopy;
    }

    public Button getBtnUpdate() {
        return btnUpdate;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public Label getTitle() {
        return title;
    }

    public TextField getTitleField() {
        return titleField;
    }

    public TextField getTagsField() {
        return tagsField;
    }
}
