package ttzv.uiUtils;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ActionableTextField extends AnchorPane {

    private ActionableTextFieldController controller;
    private SimpleBooleanProperty showButton1 = new SimpleBooleanProperty(true);
    private SimpleBooleanProperty showButton2 = new SimpleBooleanProperty(true);
    private ObjectProperty<Image> button1Image = new SimpleObjectProperty<>();
    private ObjectProperty<Image> button2Image = new SimpleObjectProperty<>();

    public ActionableTextField() {
        super();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ActionableTextField.fxml"));
            controller = new ActionableTextFieldController();
            fxmlLoader.setController(controller);
            Node n = fxmlLoader.load();
            this.getChildren().add(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
        controller.getButton1().visibleProperty().bind(showButton1);
        controller.getButton2().visibleProperty().bind(showButton2);
        controller.getButton1().imageProperty().bind(button1Image);
        controller.getButton2().imageProperty().bind(button2Image);
    }

    public void showButton1(boolean show){
        controller.getButton1().setVisible(show);
    }

    public void showButton2(boolean show){
        controller.getButton2().setVisible(show);
    }

    public void addButton1Image (ImageView img){

    }

    public void addButton2Image (ImageView img){

    }

    public void addButton1Action(ChangeListener<EventHandler<? super MouseEvent>> listener){
        controller.getButton1().onMouseClickedProperty().addListener(listener);
    }

    public void addButton2Action(ChangeListener<EventHandler<? super MouseEvent>> listener){
        controller.getButton2().onMouseClickedProperty().addListener(listener);
    }


    public boolean isShowButton1() {
        return showButton1.get();
    }

    public SimpleBooleanProperty showButton1Property() {
        return showButton1;
    }

    public void setShowButton1(boolean showButton1) {
        this.showButton1.set(showButton1);
    }

    public boolean isShowButton2() {
        return showButton2.get();
    }

    public SimpleBooleanProperty showButton2Property() {
        return showButton2;
    }

    public void setShowButton2(boolean showButton2) {
        this.showButton2.set(showButton2);
    }

    public Image getButton1Image() {
        return button1Image.get();
    }

    public ObjectProperty<Image> button1ImageProperty() {
        return button1Image;
    }

    public void setButton1Image(Image button1Image) {
        this.button1Image.set(button1Image);
    }

    public Image getButton2Image() {
        return button2Image.get();
    }

    public ObjectProperty<Image> button2ImageProperty() {
        return button2Image;
    }

    public void setButton2Image(Image button2Image) {
        this.button2Image.set(button2Image);
    }
}
