import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    final private static int nrCatalog = 9;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Graficul functiei");

        // Sub groups for different graphs
        Pane logGraphGroup = new Pane();
        Pane cosGraphGroup = new Pane();
        Pane tanGraphGroup = new Pane();
        Pane infoGroup = new Pane();

        // Clipping
        Rectangle topLeftClip = new Rectangle(500, 500);
        topLeftClip.setLayoutX(0);
        topLeftClip.setLayoutY(0);

        Rectangle topRightClip = new Rectangle(500, 500);
        topRightClip.setLayoutX(500);
        topRightClip.setLayoutY(0);

        Rectangle bottomLeftClip = new Rectangle(500, 500);
        bottomLeftClip.setLayoutX(0);
        bottomLeftClip.setLayoutY(500);

        Rectangle bottomRightClip = new Rectangle(500, 500);
        bottomRightClip.setLayoutX(500);
        bottomRightClip.setLayoutY(500);

        // Set clipping for everything
        logGraphGroup.setClip(topLeftClip);
        cosGraphGroup.setClip(topRightClip);
        tanGraphGroup.setClip(bottomLeftClip);
        infoGroup.setClip(bottomRightClip);

        // Draw separating lines
        Line verticalSeparatorLine = new Line(500, 0, 500, 1000);
        verticalSeparatorLine.setStroke(Color.BLACK);
        verticalSeparatorLine.setStrokeWidth(5.0f);

        Line horizontalSeparatorLine = new Line(0, 500, 1000, 500);
        horizontalSeparatorLine.setStroke(Color.BLACK);
        horizontalSeparatorLine.setStrokeWidth(5.0f);

        // Main group
        Group root = new Group();
        root.getChildren().addAll(logGraphGroup, cosGraphGroup, tanGraphGroup, infoGroup,
                verticalSeparatorLine, horizontalSeparatorLine);

        // Main scene
        Scene scene = new Scene(root, 1000, 1000, Color.BISQUE);

        // Function value
        double y;

        //drawing axes
        // Top left coordinate system
        for (int i = 10; i < 480; i++) {
            Text osx = new Text(i, 250, "-");
            logGraphGroup.getChildren().add(osx);
            Text osy = new Text(250, i + 5, "|");
            logGraphGroup.getChildren().add(osy);
        }

        // Top right coordinate system
        for (int i = 515; i < 985; i++) {
            Text osx = new Text(i, 250, "-");
            cosGraphGroup.getChildren().add(osx);
            Text osy = new Text(750, i - 500, "|");
            cosGraphGroup.getChildren().add(osy);
        }

        // Bottom left coordinate system
        for (int i = 10; i < 480; i++) {
            Text osx = new Text(i, 750, "-");
            tanGraphGroup.getChildren().add(osx);
            Text osy = new Text(250, i + 510, "|");
            tanGraphGroup.getChildren().add(osy);
        }

        // Bottom right group
        // Text
        Label textLabel0 = new Label("Laboratorul nr. 4");
        textLabel0.setFont(Font.font("Times New Roman", FontWeight.BOLD, 48));
        textLabel0.setLayoutX(515);
        textLabel0.setLayoutY(590);
        Label textLabel1 = new Label("efectuat de");
        textLabel1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 48));
        textLabel1.setLayoutX(580);
        textLabel1.setLayoutY(640);
        Label textLabel2 = new Label("Curchi Mihail");
        textLabel2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 48));
        textLabel2.setLayoutX(580);
        textLabel2.setLayoutY(690);
        Label textLabel3 = new Label("IA-171");
        textLabel3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 48));
        textLabel3.setLayoutX(580);
        textLabel3.setLayoutY(740);

        infoGroup.getChildren().addAll(textLabel0, textLabel1, textLabel2, textLabel3);

        double i = -20;
        //drawing function for top left coordinate system
        while (i < 30) {
            //function to draw
            y = Math.log(i);
            // *40 is making graph larger, increase or decrease
            Text txt = new Text(250 + i * nrCatalog, 250 - y * 60, "o");

            logGraphGroup.getChildren().add(txt);
            //precision. how dense is graph, smaller is denser
            i += 0.0003;
        }

        //drawing function for top right coordinate system
        i = -20;
        while (i < 60) {
            //function to draw
            y = Math.cos(i);
            // *40 is making graph larger, increase or decrease
            Text txt = new Text(479 + i * nrCatalog, 250 - y * 60, "o");

            cosGraphGroup.getChildren().add(txt);
            //precision. how dense is graph, smaller is denser
            i += 0.01;
        }

        //drawing function for bottom right coordinate system
        i = -20;
        while (i < 70) {
            //function to draw
            y = Math.tan(i);
            // *40 is making graph larger, increase or decrease
            Text txt = new Text(i * nrCatalog, 722 - y * 40, "o");

            tanGraphGroup.getChildren().add(txt);
            //precision. how dense is graph, smaller is denser
            i += 0.0005;
        }

        // Set up the main stage
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
