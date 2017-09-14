package com.dreamygeeks.mms;

import com.dreamygeeks.mms.view.MaterialView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MaterialManagementApplication extends Application {

    private Parent root;
	public static void main(String[] args) {
        System.out.println("I am in main");
        launch(MaterialManagementApplication.class, args);
	}

	private ConfigurableApplicationContext springContext;

	@Override
	public void init() throws Exception {
        System.out.println("I am in init");

        springContext = SpringApplication.run(MaterialManagementApplication.class);
        root = new MaterialView().asParent();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World");
		Scene scene = new Scene(root,800,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
	}



}