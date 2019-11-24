module ttzv.uiUtils {
    requires javafx.controls;
    requires javafx.fxml;

    opens ttzv.uiUtils to javafx.fxml;

    exports ttzv.uiUtils;
}