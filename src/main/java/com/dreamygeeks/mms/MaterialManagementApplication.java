package com.dreamygeeks.mms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MaterialManagementApplication extends Application {
    private ConfigurableApplicationContext springContext;
    private Parent root;

	public static void main(String[] args) {
        launch(MaterialManagementApplication.class, args);
	}

	@Override
	public void init() throws Exception {
        springContext = SpringApplication.run(MaterialManagementApplication.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dashboard.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        root = fxmlLoader.load();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(root,800,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
	}
}