package gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Relogio;

public class RelogioXadrezGUI extends Application {
    
    private Label labelTempo1;
    private Label labelTempo2;
    private Button btnIniciar1;
    private Button btnIniciar2;
    private Button btnPausar1;
    private Button btnPausar2;
    private Button btnReiniciar1;
    private Button btnReiniciar2;
    private Timeline timeline1;
    private Timeline timeline2;
    
    
    Relogio relogio1 = new Relogio(60);
    Relogio relogio2 = new Relogio(60);
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Relógio para Xadrez");
        
        // Criar os componentes da interface
        labelTempo1 = new Label("Tempo do jogador 1: " + relogio1.getTempoRestante());
        labelTempo2 = new Label("Tempo do jogador 2: " + relogio2.getTempoRestante());
        
        btnIniciar1 = new Button("Iniciar jogador 1");
        btnIniciar1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                relogio1.iniciar();
                timeline1.play();
            }
        });
        btnIniciar2 = new Button("Iniciar o jogador 2");
        btnIniciar2.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		relogio2.iniciar();
        		timeline2.play();
        	}
		});
        
        
        btnPausar1 = new Button("Pausar jogador 1");
        btnPausar1.setOnAction(new EventHandler<ActionEvent>() {
           @Override
            public void handle(ActionEvent event) {
                relogio1.pausar();
                timeline1.pause();
            }
        });
        
        btnPausar2 = new Button("Pausar jogador 2");
        btnPausar2.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		relogio2.pausar();
        		timeline2.pause();
        	}
		});
        
        
        btnReiniciar1 = new Button("Reiniciar jogador 1");
        btnReiniciar1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                relogio1.reiniciar();
                timeline1.stop();
                labelTempo1.setText("Tempo do jogador 1: " + relogio1.getTempoRestante());
            }
        });
        
        btnReiniciar2 = new Button("Reiniciar jogador 2");
        btnReiniciar2.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		relogio2.reiniciar();
        		timeline2.stop();
        		labelTempo2.setText("Tempo do jogador 2: " + relogio2.getTempoRestante());
        	}
		});
        
        // Criar o layout da interface
        VBox vbox = new VBox(labelTempo1, labelTempo2, btnIniciar1, btnIniciar2, btnPausar1, btnPausar2, btnReiniciar1, btnReiniciar2);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        
        // Criar o timeline para atualizar o tempo restante dos jogadores
        timeline1 = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelTempo1.setText("Tempo do jogador 1: " + relogio1.getTempoRestante());
               
            }
        }));
        timeline1.setCycleCount(Timeline.INDEFINITE);
        
        timeline2 = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelTempo2.setText("Tempo do jogador 2: " + relogio2.getTempoRestante());
               
            }
        }));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}

