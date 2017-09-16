package fxmlexample;

/**
 * Created by deepak_shingan on 9/16/2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringFxmlEXample extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent root;

    public static void main(String[] args) {
        launch(SpringFxmlEXample.class, args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(SpringFxmlEXample.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml_example.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        root = fxmlLoader.load();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root, 950, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }
}