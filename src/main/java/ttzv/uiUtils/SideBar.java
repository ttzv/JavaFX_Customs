package ttzv.uiUtils;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class SideBar extends AnchorPane {


    private boolean expanded;
    private SimpleDoubleProperty animationSpeed = new SimpleDoubleProperty(250.0);
    private SimpleDoubleProperty targetWidth = new SimpleDoubleProperty();
    private boolean animateNodes = false;
    private Node toggler;

    public SideBar() {
        super();
        this.expanded = false;
        childrenVisible(false);
        targetWidth.addListener((observableValue, number, t1) -> SideBar.this.setPrefWidth(t1.doubleValue()));
    }

    public void childrenVisible(boolean visible){
        for (Node n : this.getChildren()) {
            n.setManaged(visible);
            n.setVisible(visible);
        }
    }

    public double getTargetWidth() {
        return targetWidth.get();
    }

    public SimpleDoubleProperty targetWidthProperty() {
        return targetWidth;
    }

    public void setTargetWidth(double targetWidth) {
        this.targetWidth.set(targetWidth);
    }

    public double getAnimationSpeed() {
        return animationSpeed.get();
    }

    public SimpleDoubleProperty animationSpeedProperty() {
        return animationSpeed;
    }

    public void setAnimationSpeed(double animationSpeed) {
        this.animationSpeed.set(animationSpeed);
    }

    public boolean isAnimateNodes() {
        return animateNodes;
    }

    public void setAnimateNodes(boolean animateNodes) {
        this.animateNodes = animateNodes;
    }

    public Node getToggler() {
        return toggler;
    }

    /**
     * Convenience setter for node that fires animatePane method.
     * When node is set it will be disabled for duration of animation to prevent breaking it.
     * This is completely optional.
     * @param toggler Node that fires animation
     */
    public void setToggler(Node toggler) {
        this.toggler = toggler;
    }

    private void lockToggler(){
        if(toggler!=null){
            Task task = new Task() {
                @Override
                protected Object call() throws Exception {
                    toggler.setDisable(true);
                    Thread.sleep(animationSpeed.longValue());
                    toggler.setDisable(false);
                    return null;
                }
            };
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    /**
     * Use this method in action listener of some other node
     */
    public void animatePane(){
        lockToggler();
        final Animation hideSidebar = new Transition() {
            {
                setCycleDuration(Duration.millis(animationSpeed.doubleValue()));
            }
            protected void interpolate(double frac) {
                final double curWidth = targetWidth.doubleValue() * (1.0 - frac);
                setPrefWidth(curWidth);
            }
        };
        hideSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                expanded = false;
            }
        });

        final Animation showSidebar = new Transition() {
            {
                setCycleDuration(Duration.millis(animationSpeed.doubleValue()));
            }

            protected void interpolate(double frac) {
                final double curWidth = targetWidth.doubleValue() * frac;
                setPrefWidth(curWidth);
            }
        };
        showSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                childrenVisible(true);
            }
        });

        if (showSidebar.statusProperty().get() == Animation.Status.STOPPED && hideSidebar.statusProperty().get() == Animation.Status.STOPPED) {
            if (expanded) {
                hideSidebar.play();
                childrenVisible(false);
                expanded = false;
            } else {
                showSidebar.play();
                expanded = true;
            }

        }

    }

    /**
     * Set all anchors for Node inside this pane.
     * This will work only for first node added to this pane so it is recommended to wrap multiple nodes in one parent when using this method
     * @param val anchor offset value for each side
     */
    public void applyAnchors(double val){
        Node childNode = this.getChildren().get(0);
        AnchorPane.setTopAnchor(childNode,val);
        AnchorPane.setBottomAnchor(childNode,val);
        AnchorPane.setLeftAnchor(childNode,val);
        AnchorPane.setRightAnchor(childNode,val);
    }
}
