package ttzv.uiUtils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CommandNode extends AnchorPane {

    String content;
    Button btnCopy;
    Button btnUpdate;
    Button btnDelete;
    String title;
    TextField titleField;
    TextField tagsField;

    public CommandNodeController controller;

    public CommandNode() {
        super();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/CommandNode.fxml"));
            controller = new CommandNodeController();
            fxmlLoader.setController(controller);
            Node n = fxmlLoader.load();
            this.getChildren().add(n);
        } catch (IOException e) {
            e.printStackTrace();
        }

        controller.getBtnCopy().setOnAction(actionEvent -> {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(this.controller.getContent().getText());
            clipboard.setContent(content);
        });

        this.controller.getTitle().textProperty().bind(this.controller.getTitle().textProperty());
    }

    public Button getBtnCopy() {
        return this.controller.getBtnCopy();
    }

    public Button getBtnUpdate() {
        return this.controller.getBtnUpdate();
    }

    public Button getBtnDelete() {
        return this.controller.getBtnDelete();
    }

    public String getContent() {
        return this.controller.getContent().getText();
    }

    public void setContent(String content) {
        this.controller.getContent().setText(content);
    }

    public String getTitle() {
        return this.controller.getTitle().getText();
    }

    public void setTitle(String title) {
        this.controller.getTitle().setText(title);
    }

    public TextField getTitleField() {
        return this.controller.getTitleField();
    }

    public void setTitleField(String text) {
        this.controller.getTitleField().setText(text);
    }

    public String getTagsFieldText() {
        return this.controller.getTagsField().getText();
    }

    public void setTagsField(String text) {
        this.controller.getTagsField().setText(text);
    }
}
