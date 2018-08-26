package project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class View extends Application {
    
    ListView<String> list;
    
    public View() {
        list = new ListView<String>();
    }

    @Override
    public void start(Stage stage) {
        BorderPane borderPane = new BorderPane();
        
        borderPane.setTop(paneTop());
        borderPane.setLeft(paneLateral());
        borderPane.setCenter(paneCentral());

        Scene scene = new Scene(borderPane, 700, 600);
        stage.setScene(scene);
        stage.setTitle("Redutor de Perdas");
        stage.setResizable(false);
        stage.show();
    }
    
    private Pane paneTop() {
        Pane pane = new Pane();
        
        Label label = new Label("INTERFACE PARA REDUÇÃO DE PERDAS");
        label.setStyle("-fx-font: 26px \"Georgia\"; -fx-text-fill: white");

        HBox title = new HBox(label);
        title.setAlignment(Pos.CENTER);
        title.setStyle("-fx-background-color: black; -fx-padding: 40.0;");
        title.setMinWidth(710);
        
        pane.getChildren().add(title);
        
        return pane;
    }

    private Pane paneCentral() {
        Pane pane = new Pane();
        
        Label produto = new Label("PRODUTO: Abacaxi");
        produto.setStyle("-fx-font: 26px \"Georgia\"; -fx-text-fill: black");
        
        Label msg1 = new Label("Quantia estimada para compra:");
        msg1.setStyle("-fx-font: 18px \"Georgia\"; -fx-text-fill: black");
        Label msg2 = new Label("1234");
        msg2.setStyle("-fx-font: 24px \"Georgia\"; -fx-text-fill: black");
        
        String str = "nada";
        Label msg3 = new Label("OBSERVAÇÕES: " + str);
        msg3.setStyle("-fx-font: 16px \"Georgia\"; -fx-text-fill: black; -fx-padding: 20px");
        
        HBox p = new HBox();
        p.setSpacing(10);
        p.setAlignment(Pos.CENTER);
        p.getChildren().addAll(msg1, msg2);
        p.setStyle("-fx-padding: 40.0;");
        
        
        VBox botoes = new VBox();
        botoes.setSpacing(10);
        botoes.setAlignment(Pos.CENTER);
        botoes.getChildren().addAll(produto, p, msg3, new Separator(), getGrafico());
        botoes.setStyle("-fx-padding: 40.0;");
        
        
        pane.getChildren().add(botoes);
        
        return pane;
    }
    
    private LineChart getGrafico() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("");
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
       
        //lineChart.setTitle("Stock Monitoring, 2010");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Portfolio 1");
        
        series1.getData().add(new XYChart.Data("Jan", 23));
        series1.getData().add(new XYChart.Data("Feb", 14));
        series1.getData().add(new XYChart.Data("Mar", 15));
        series1.getData().add(new XYChart.Data("Apr", 24));
        series1.getData().add(new XYChart.Data("May", 34));
        series1.getData().add(new XYChart.Data("Jun", 36));
        series1.getData().add(new XYChart.Data("Jul", 22));
        series1.getData().add(new XYChart.Data("Aug", 45));
        series1.getData().add(new XYChart.Data("Sep", 43));
        series1.getData().add(new XYChart.Data("Oct", 17));
        series1.getData().add(new XYChart.Data("Nov", 29));
        series1.getData().add(new XYChart.Data("Dec", 25));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Portfolio 2");
        series2.getData().add(new XYChart.Data("Jan", 33));
        series2.getData().add(new XYChart.Data("Feb", 34));
        series2.getData().add(new XYChart.Data("Mar", 25));
        series2.getData().add(new XYChart.Data("Apr", 44));
        series2.getData().add(new XYChart.Data("May", 39));
        series2.getData().add(new XYChart.Data("Jun", 16));
        series2.getData().add(new XYChart.Data("Jul", 55));
        series2.getData().add(new XYChart.Data("Aug", 54));
        series2.getData().add(new XYChart.Data("Sep", 48));
        series2.getData().add(new XYChart.Data("Oct", 27));
        series2.getData().add(new XYChart.Data("Nov", 37));
        series2.getData().add(new XYChart.Data("Dec", 29));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Portfolio 3");
        series3.getData().add(new XYChart.Data("Jan", 44));
        series3.getData().add(new XYChart.Data("Feb", 35));
        series3.getData().add(new XYChart.Data("Mar", 36));
        series3.getData().add(new XYChart.Data("Apr", 33));
        series3.getData().add(new XYChart.Data("May", 31));
        series3.getData().add(new XYChart.Data("Jun", 26));
        series3.getData().add(new XYChart.Data("Jul", 22));
        series3.getData().add(new XYChart.Data("Aug", 25));
        series3.getData().add(new XYChart.Data("Sep", 43));
        series3.getData().add(new XYChart.Data("Oct", 44));
        series3.getData().add(new XYChart.Data("Nov", 45));
        series3.getData().add(new XYChart.Data("Dec", 44));
        
        lineChart.getData().addAll(series1, series2, series3);
        
        lineChart.setPrefWidth(400);
        lineChart.setPrefHeight(200);
        
        lineChart.setStyle("-fx-margin-bottom: 140.0;");
        
        return lineChart;
    }
    
    private Pane paneLateral() {
        Pane central = new Pane();
        
        ObservableList<String> items =FXCollections.observableArrayList (
            "Cenoura", "Carne", "Batata", "Presunto");
        list.setItems(items);
        
        System.out.println(list.getFocusModel().getFocusedIndex());
        
        list.setPrefWidth(150);
        list.setPrefHeight(370);
        
        
        Label label1 = new Label("Data desejada:");
        label1.setStyle("-fx-font: 16px \"Georgia\"; -fx-text-fill: black");
        TextField dia = new TextField();
        dia.setPromptText("Dia");
        TextField mes = new TextField();
        mes.setPromptText("Mes");
        TextField ano = new TextField();
        ano.setPromptText("Ano");
        
        
        dia.setMaxWidth(38);
        mes.setMaxWidth(38);
        ano.setMaxWidth(55);
        
        HBox data = new HBox();
        data.setSpacing(10);
        data.setAlignment(Pos.CENTER);
        data.getChildren().addAll(dia, mes, ano);
        
        
        Button btnData = new Button("Enviar");
        btnData.setStyle("-fx-font: 14px Georgia; -fx-padding: 7 53px;");
        btnData.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("Data: " + dia.getText() + ' ' + mes.getText() + ' ' + ano.getText());
                System.out.println("Selecionado: " + list.getFocusModel().getFocusedIndex());
            }
        });
        
        
        VBox vb = new VBox();
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(label1, data, btnData, list);
        vb.setStyle("-fx-padding: 10.0;");
        
        central.getChildren().add(vb);
        
        return central;
    }

    public static void main(String[] args) {
        launch(args);
    }
}