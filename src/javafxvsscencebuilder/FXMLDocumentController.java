package javafxvsscencebuilder;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
//import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
//import javafx.animation.RotateTransition;
//import javafx.animation.RotateTransitionBuilder;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
//import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
//import javafx.event.Event;
//import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
//import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author tranv
 */
public class FXMLDocumentController implements Initializable {

    private static Integer iStart = 0;                  //Bien process
    private static Integer iRotate = 0;
    private float AngelElevation = 0;
    private boolean YNRotate = false;
    private boolean YNLowPWR = false;
    private boolean YNRun = false;
    private boolean YNSelect = false;
    private boolean YNMode1 =false;
    private boolean YNMode2 = false;
    private boolean YNOutput = false;
    private boolean YNSelectO = false;
    private boolean YNTransmit = false;
    private boolean YNSH6 = false;
    private boolean YNSector = false;
    private boolean YNRatio1 = false;
    private boolean YNRatio2 = false;
    private boolean YNPower = false;
    private boolean YNNormal = true;
    private boolean YNSlow =false;
    private boolean YNSLC=false;
    private boolean YNPWS=false;
    private boolean YNPlots=false;
    private boolean YNTracks=true;
    private boolean EnSelect = false;

    @FXML
    private Circle LED24;
    @FXML
    private Circle fuse;
    @FXML
    private Button BtnDown;
    @FXML
    private Circle LED12;
    @FXML
    private Button BtnControl;
    @FXML
    private Button BtnSelect;
    @FXML
    private Button BtnSelectO;
    @FXML
    private Button BtnPark;
    @FXML
    private Button BtnRotate;
    @FXML
    private Button BtnLow;
    @FXML
    private Button BtnOutput;
    @FXML
    private StackPane STT_MODE;
    @FXML
    private StackPane STT_Recoder;
    @FXML
    private StackPane STT_LMCC;   
    @FXML
    private StackPane STT_Antena;
    @FXML
    private StackPane STT_Transmit;
    @FXML
    private StackPane STT_Process;
    @FXML
    private StackPane STT_Output;
    @FXML
    private StackPane STT_IFF;
    @FXML
    private StackPane STT_Supply;
    @FXML
    private StackPane STT_RHF;    
    @FXML
    private StackPane STT_SRCC;
    @FXML
    private StackPane STT_Receiver;
    @FXML
    private StackPane STT_PV;    
    @FXML
    private StackPane STT_CL;
    @FXML
    private StackPane STT_Radar;   
    @FXML
    private StackPane STT_Time;
    @FXML
    private Button BtnUp;
    @FXML
    private Button BtnSh6;

    @FXML
    private Button BtnTransmit;

    @FXML
    private Button BtnMode1;

    @FXML
    private Text TextMODE;

    @FXML
    private Button BtnMode2;

    @FXML
    private Button BtnRatio2;

    @FXML
    private Button BtnRatio1;

    @FXML
    private Button BtnSector;

    @FXML
    private StackPane ControlTable;

    @FXML
    private Button BtnPWR;

    @FXML
    private Button BtnRun;

    @FXML
    private Button BtnStart;
    @FXML
    private Button BtnStop;
    @FXML
    private Button BtnSlow;
    @FXML
    private Button BtnTracks;
    @FXML
    private Button BtnPWS;
    @FXML
    private Button BtnSLC;    
    @FXML
    private Button BtnPlots;
    @FXML
    private Button BtnNormal;
    @FXML
    private Text TextElevation;
    @FXML
    private Text TextTempCAB;
    @FXML
    private Text TextTempSTX;
    @FXML
    private Line AntenRotate;
    @FXML
    private Text TextVSWR;
    @FXML
    private Text TextPower;
    @FXML
    private Text TextPV;
     @FXML
    private Text TextCL;
    @FXML
    private Text TextTime;
    @FXML
    private Text TextAzimuth;
    @FXML
    private Text TextNoise;
    @FXML
    private Text TextNoise1;
    @FXML
    private Text TextNoise2;
    @FXML
    private Text TextNoise3;
    @FXML
    private Text TextNoise4;
    @FXML
    private Text TextSP;
    @FXML
    private Text TextLP;
    @FXML
    private Label TextProtection;
    @FXML
    private Label TextDisplays;
    @FXML
    private Label TextTrans;    
    @FXML
    private Label TextPlots;
    @FXML
    private Label TextTracks;
    @FXML
    private Label LebelInfo;
    @FXML
    private Rectangle RectRadar;
    @FXML
    private Rectangle RectConsole;
    @FXML
    private Rectangle RectAntenna;
    @FXML
    private Rectangle RectOutput;           
    @FXML
    private Rectangle RectInterrogator;    
    @FXML
    private Rectangle RectTransmit;
    @FXML
    private StackPane StackSP;
    @FXML
    private StackPane StackLP;
    @FXML
    private ScrollBar ScrollSP;
    @FXML
    private ScrollBar ScrollLP;
    //KHI NÚT NGUỒN ĐƯỢC NHẤN

    @FXML
    void click(ActionEvent event) {
        YNPower=!YNPower;
                Timeline timeline=new Timeline(new KeyFrame(
                Duration.millis(70), //Thời gian hệ thống ở chế độ khởi tạo
                ae -> {
                    BtnControl.setStyle("-fx-background-color:#64ff00"); //Control xanh một lúc mới điều khiển đc..chưa làm
                    BtnStart.setStyle("-fx-background-color:#caff95");      //Xanh nhạt:có thể nhấn
                    iStart = 1;                                            //Phím Start có thể nhấn
                    BtnDown.setStyle("-fx-background-color:#caff95");
                    BtnUp.setStyle("-fx-background-color:#caff95");
                    BtnPark.setStyle("-fx-background-color:#caff95");
                    TextMODE.setText("StandBy");
                    
                    STT_Radar.setStyle("-fx-background-color:green");
                    STT_Transmit.setStyle("-fx-background-color:green");
                    STT_Receiver.setStyle("-fx-background-color:green");
                    STT_Output.setStyle("-fx-background-color:green");
                    STT_SRCC.setStyle("-fx-background-color:green");
                }
        ));
                
        if (YNPower==true) {
        BtnPWR.setStyle("-fx-background-color:#64ff00");
        LED24.setFill(Color.GREEN);                             //Sáng đèn +24V
        LED12.setFill(Color.GREEN);                             //Sáng đèn +12V
        BtnControl.setStyle("-fx-background-color:red");      //Nút CONTROL sáng dor
        STT_MODE.setStyle("-fx-background-color:green");        //Đèn nền màn hình mở
        TextMODE.setFill(Color.WHITE);                          //Hệ thống được khởi tạo INIT
        TextCL.setFill(Color.WHITE);
        TextPV.setFill(Color.WHITE);
        TextTime.setFill(Color.WHITE);
        STT_Radar.setStyle("-fx-border-color: black;-fx-background-color:#ff00ee");
        STT_Supply.setStyle("-fx-border-color: black;-fx-background-color:green");
        
        STT_Antena.setStyle("-fx-border-color: black;-fx-background-color:green");
        STT_Transmit.setStyle("-fx-border-color: black;-fx-background-color:#ff00ee");
        STT_Receiver.setStyle("-fx-border-color: black;-fx-background-color:pink");
        STT_Process.setStyle("-fx-border-color: black;-fx-background-color:green");
        STT_Output.setStyle("-fx-border-color: black;-fx-background-color:red");
        STT_Recoder.setStyle("-fx-border-color: black;-fx-background-color:green");
        STT_Receiver.setStyle("-fx-border-color: black;-fx-background-color:green");
        STT_LMCC.setStyle("-fx-border-color: black;-fx-background-color:green");
        STT_SRCC.setStyle("-fx-border-color: black;-fx-background-color:yellow");
        STT_IFF.setStyle("-fx-border-color: black;-fx-background-color:green");
        STT_RHF.setStyle("-fx-border-color: black;-fx-background-color:grey");
        STT_CL.setStyle("-fx-border-color: white;-fx-background-color:#434343");
        STT_PV.setStyle("-fx-border-color: white;-fx-background-color:#434343");
        STT_Time.setStyle("-fx-border-color: white;-fx-background-color:#434343");
//        new Timeline(new KeyFrame(
//                Duration.millis(5000), //Thời gian hệ thống ở chế độ khởi tạo
//                ae -> {
//                    BtnControl.setStyle("-fx-background-color:#64ff00"); //Control xanh một lúc mới điều khiển đc..chưa làm
//                    BtnStart.setStyle("-fx-background-color:#caff95");
//                    iStart = 1;                                            //Phím Start có thể nhấn
//                    BtnDown.setStyle("-fx-background-color:#caff95");
//                    BtnUp.setStyle("-fx-background-color:#caff95");
//                    BtnPark.setStyle("-fx-background-color:#caff95");
//                    TextMODE.setText("StandBy");
//                    
//                    STT_Radar.setStyle("-fx-background-color:green");
//                    STT_Transmit.setStyle("-fx-background-color:green");
//                    STT_Receiver.setStyle("-fx-background-color:green");
//                    STT_Output.setStyle("-fx-background-color:green");
//                    STT_SRCC.setStyle("-fx-background-color:green");
//                }
//        )) //ae: ActionEvent event
                timeline.play();                //""""Nếu đang đợi mà nhấn Power thì sẽ bị lỗi""""
        //hiển thị nhiệt độ
        TextTempCAB.setText("35\u00b0C");
        TextTempSTX.setText("40\u00b0C");
    }else {                                     //Tắt nguồn
        YNRotate = false;
        YNLowPWR = false;
        YNRun = false;
        YNSelect = false;
        YNMode1 =false;
        YNMode2 = false;
        YNOutput = false;
        YNSelectO = false;
        YNTransmit = false;
        YNPower = false;
        EnSelect = false;
        timeline.stop();
        BtnPWR.setStyle("-fx-background-color:3c7fb1");
        LED24.setFill(Color.GREY);                             //Sáng đèn +24V
        LED12.setFill(Color.GREY);                             //Sáng đèn +12V
        BtnControl.setStyle("-fx-background-color:3c7fb1");      //Nút CONTROL sáng dor
        BtnStart.setStyle("-fx-background-color:3c7fb1");
        BtnUp.setStyle("-fx-background-color:3c7fb1");
        BtnDown.setStyle("-fx-background-color:3c7fb1");
        BtnTransmit.setStyle("-fx-background-color:3c7fb1");
        BtnSh6.setStyle("-fx-background-color:#640202");
        BtnRatio1.setStyle("-fx-background-color:#640202");
        BtnRatio2.setStyle("-fx-background-color:#640202");
        BtnSector.setStyle("-fx-background-color:#640202");
        BtnLow.setStyle("-fx-background-color:#640202");
        BtnRun.setStyle("-fx-background-color:3c7fb1");
        BtnSelect.setStyle("-fx-background-color:#640202");
        BtnMode1.setStyle("-fx-background-color:#640202");
        BtnMode2.setStyle("-fx-background-color:#640202");
        BtnOutput.setStyle("-fx-background-color:3c7fb1");
        BtnSelectO.setStyle("-fx-background-color:#640202");
        BtnRotate.setStyle("-fx-background-color:3c7fb1");
        STT_MODE.setStyle("-fx-background-color:black");        //Đèn nền màn hình mở
        TextMODE.setFill(Color.BLACK);                          //Hệ thống được khởi tạo INIT
        TextCL.setFill(Color.BLACK);
        TextPV.setFill(Color.BLACK);
        TextTime.setFill(Color.BLACK);
        TextTrans.setText("Trans: 0");
        TextPlots.setText("Plots: 0");
        TextTracks.setText("Tracks: 0");
        TextPower.setText("--");
        TextVSWR.setText("--");
        TextTempCAB.setText("--");
        TextTempSTX.setText("--");
        TextSP.setText("0");
        TextLP.setText("0");
        
        STT_Radar.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_Supply.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        
        STT_Antena.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_Transmit.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_Receiver.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_Process.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_Output.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_Recoder.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_Receiver.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_LMCC.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_SRCC.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_IFF.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_RHF.setStyle("-fx-border-color: black;-fx-background-color:BLACK");
        STT_CL.setStyle("-fx-border-color: BLACK;-fx-background-color:BLACK");
        STT_PV.setStyle("-fx-border-color: BLACK;-fx-background-color:BLACK");
        STT_Time.setStyle("-fx-border-color: BLACK;-fx-background-color:BLACK"); 
        }
    }

    //NHẤN NÚT STARTd
    @FXML
    void clickStart(ActionEvent event) {
        if (iStart == 1) {
            iStart = 2;                                           //phím Start đã đc nhấn
            BtnStart.setStyle("-fx-background-color:#64ff00");      //SANG XANH RO          
            TextMODE.setText("Ready");
            BtnRotate.setStyle("-fx-background-color:#caff95");
            BtnPark.setStyle("-fx-background-color:3c7fb1");        //TRẠNG THÁI BAN ĐẦU
            BtnRun.setStyle("-fx-background-color:#caff95");        //NÚT XANH SÁNG MỜ
            BtnMode1.setStyle("-fx-background-color:#aaff00");      //nÚT ĐỎ SÁNG RÕ
            YNMode1=true;
            BtnOutput.setStyle("-fx-background-color:#caff95");

            BtnSh6.setStyle("-fx-background-color:#ffbf76");        //NÚT ĐỎ SÁNG MỜ
            BtnRatio1.setStyle("-fx-background-color:#ffbf76");
            BtnRatio2.setStyle("-fx-background-color:#ffbf76");
            BtnSector.setStyle("-fx-background-color:#ffbf76");
            BtnLow.setStyle("-fx-background-color:#ffbf76");
            BtnMode2.setStyle("-fx-background-color:#ffbf76");

            BtnSelectO.setStyle("-fx-background-color:#ffbf76");

        }
    }

    //NHẤP PHÍM ROTATE
    @FXML
    void clickRotate(ActionEvent event) {

        if (iStart >= 2) {
            YNRotate = !YNRotate;
            TextMODE.setText("RotateInit");

            if (YNRotate == true) {
                BtnRotate.setStyle("-fx-background-color:#64ff00");
                iRotate=1;
            } else {
                iRotate=0;
                
                BtnRotate.setStyle("-fx-background-color:#ffbb00");             //NHÁY MÀU CAM
                BtnTransmit.setStyle("-fx-background-color:3c7fb1");                //CẤM PHÁT
                TextPower.setText("--");
                TextVSWR.setText("--");
                iStart=2;
            }
            FadeTransition flashRotate = new FadeTransition(Duration.millis(1000), BtnRotate);
            flashRotate.setFromValue(1.0);
            flashRotate.setToValue(0.2);
            flashRotate.setCycleCount(6);
            flashRotate.setAutoReverse(true);
            flashRotate.play();
            
            ////
//QUAY 1

//QUAY 2
            Timeline timeRotate= new Timeline(new KeyFrame(Duration.millis(30), ae -> {
                    System.out.println(iRotate);
                    Rotate rotation =new Rotate();
                    rotation.pivotXProperty().bind(AntenRotate.startXProperty());
                    rotation.pivotYProperty().bind(AntenRotate.startYProperty());
//                    if (YNRotate!=true) {
//                    rotation.setAngle(1);
//                } else {
//                    rotation.setAngle(1);
//                    }
                    rotation.setAngle(1);
                    AntenRotate.getTransforms().addAll(rotation); 
                    iRotate=iRotate+1;
                    System.out.println(iRotate);                   
            }
            ));
            if (YNRotate!=true) {
                System.out.println("STOP");
                System.out.println(iRotate);
                timeRotate.setCycleCount(10);
                timeRotate.setAutoReverse(false);       //Khong quay ve vi tri ban dau
                timeRotate.play();
            } else {
                System.out.println("quay");
                System.out.println(iRotate);
            timeRotate.setCycleCount(100);
            timeRotate.setAutoReverse(false);
            timeRotate.play();
            }
//QUAY 3
//            RotateTransition RotateAnten = new RotateTransition();
//            RotateAnten.setDuration(Duration.millis(20));
//            RotateAnten.setNode(AntenRotate);
//            RotateAnten.setByAngle(30);
//            RotateAnten.setCycleCount(2);
//            RotateAnten.setAutoReverse(false);
//            RotateAnten.play();
//QUAY 4

            

            


            ///
            new Timeline(new KeyFrame(Duration.millis(7000), ae -> {
                if (YNRotate == true) {
                    BtnRotate.setStyle("-fx-background-color:#64ff00");
                    TextMODE.setText("Rotate");
                    BtnTransmit.setStyle("-fx-background-color:#caff95");               //CÓ THỂ PHÁT
                    iStart = 3;                                                           //aNTEN ĐÃ QUAY, CÓ THỂ PHÁT

                } else {
                    BtnRotate.setStyle("-fx-background-color:#caff95");
                    TextMODE.setText("Ready");                                       
                }
            }
            )).play();
        }
    }

    //PHÁT
    @FXML
    void clickLowPWR(ActionEvent event) {

        if (iStart >= 3) {
            YNLowPWR = !YNLowPWR;                                 //Lần đầu nhấn chuyển sang true=công suất thấp   
            if (YNLowPWR == true) {
                BtnLow.setStyle("-fx-background-color:#aaff00");
                if (iStart == 5) {
                    TextPower.setText("4.0kW");
                    TextVSWR.setText("1.4");
                    TextTrans.setText("Trans: 25");
                    TextPlots.setText("Plots: 29");
                    TextTracks.setText("Tracks: 25");
                    TextSP.setText("144");
                    TextLP.setText("90");
                }
            } else {
                BtnLow.setStyle("-fx-background-color:#ffbf76");
                if (iStart == 5) {
                    TextPower.setText("8.0kW");
                    TextVSWR.setText("1.3");
                    TextTrans.setText("Trans: 27");
                    TextPlots.setText("Plots: 28");
                    TextTracks.setText("Tracks: 27");
                    TextSP.setText("152");
                    TextLP.setText("97");
                }
            }
        }
    }

    @FXML
    void clickTransmit(ActionEvent event) {
        if (iStart>=3 && YNTransmit==false) {
            YNTransmit=true;
        if (YNLowPWR == false) {
            BtnTransmit.setStyle("-fx-background-color:#64ff00");
            TextPower.setText("8.0kW");
            TextVSWR.setText("1.3");
            TextMODE.setText("Operate");
                    TextTrans.setText("Trans: 25");
                    TextPlots.setText("Plots: 29");
                    TextTracks.setText("Tracks: 25");
                    TextSP.setText("162");
                    TextLP.setText("137");
            iStart = 5;
        } else {
                BtnTransmit.setStyle("-fx-background-color:#64ff00");
                TextPower.setText("4.0kW");
                TextVSWR.setText("1.4");
                TextMODE.setText("Operate");
                iStart = 5;
                    TextTrans.setText("Trans: 29");
                    TextPlots.setText("Plots: 30");
                    TextTracks.setText("Tracks: 29");
                    TextSP.setText("159");
                    TextLP.setText("132");
            }            
        } else {
            if (iStart>=3 && YNTransmit==true) {
                YNTransmit=false;
                BtnTransmit.setStyle("-fx-background-color:#caff95");
                TextPower.setText("--");
                TextVSWR.setText("--");
                    TextTrans.setText("Trans: 0");
                    TextPlots.setText("Plots: 0");
                    TextTracks.setText("Tracks: 0");
                    TextSP.setText("0");
                    TextLP.setText("0");
                TextMODE.setText("Ready");
            }
        }

        
    }
     @FXML
    void clickSH6(ActionEvent event) {
        if (iStart>=2&&YNSH6==false) {
            BtnSh6.setStyle("-fx-background-color:#aaff00");
            YNSH6=true;
        } else if (iStart>=2&&YNSH6==true) {
                BtnSh6.setStyle("-fx-background-color:#ffbf76");
                YNSH6=false;        
        }
    }

    @FXML
    void clickRatio1(ActionEvent event) {
        if (iStart>=2&&YNRatio1==false) {
            BtnRatio1.setStyle("-fx-background-color:#aaff00");
            BtnRatio2.setStyle("-fx-background-color:#ffbf76");
            BtnSector.setStyle("-fx-background-color:#ffbf76");
            YNRatio1=true;
            YNRatio2=false;
            YNSector=false;
        } else if (iStart>=2&&YNRatio1==true) {
            BtnRatio1.setStyle("-fx-background-color:#ffbf76");
            YNRatio1=false;
            
        }
    }

    @FXML
    void clickSetor(ActionEvent event) {
        if (iStart>=2&&YNSector==false) {
            BtnSector.setStyle("-fx-background-color:#aaff00");
            BtnRatio1.setStyle("-fx-background-color:#ffbf76");
            BtnRatio2.setStyle("-fx-background-color:#ffbf76");
            YNSector=true;
            YNRatio1=false;
            YNRatio2=false;
        } else if (iStart>=2&&YNSector==true) {
                BtnSector.setStyle("-fx-background-color:#ffbf76");
                YNSector=false;        
        }
    }

    @FXML
    void clickRatio2(ActionEvent event) {
        if (iStart>=2&&YNRatio2==false) {
            BtnRatio2.setStyle("-fx-background-color:#aaff00");
            BtnRatio1.setStyle("-fx-background-color:#ffbf76");
            BtnSector.setStyle("-fx-background-color:#ffbf76");
            YNRatio2=true;
            YNRatio1=false;
            YNSector=false;
    } else if (iStart>=2&&YNRatio2==true) {
            BtnRatio2.setStyle("-fx-background-color:#ffbf76");
            YNRatio2=false;
            
        }
    }

    //MAY HOI

    @FXML
    void clickRun(ActionEvent event) {

        if (iStart >= 2) {
            YNRun = !YNRun;
            BtnRun.setStyle("-fx-background-color:#64ff00");
            FadeTransition flashRun = new FadeTransition(Duration.millis(1000), BtnRun);
            flashRun.setFromValue(1.0);
            flashRun.setToValue(0.2);
            flashRun.setCycleCount(6);
            flashRun.setAutoReverse(true);
            flashRun.play();
            new Timeline(new KeyFrame(Duration.millis(7000), ae -> {
                if (YNRun == true) {
                    BtnRun.setStyle("-fx-background-color:#64ff00");					//sang xanh ro
                    BtnSelect.setStyle("-fx-background-color:#ffbf76");               	//sang do mo
                    EnSelect = true;
                } else {
                    BtnRun.setStyle("-fx-background-color:#caff95");
                    BtnSelect.setStyle("-fx-background-color:#640202");                //trang thai tat
                    EnSelect = false;
                }

            }
            )).play();

        }
    }

    //HOI TRONG VUNG DUOC CHON
    @FXML
    void clickSelect(ActionEvent event) {
        if (YNRun == true) {
            YNSelect = !YNSelect;
            if (YNSelect == true && EnSelect == true) {
                BtnSelect.setStyle("-fx-background-color:#aaff00");
            } else if (YNSelect == false && EnSelect == true) {
                BtnSelect.setStyle("-fx-background-color:#ffbf76");
            }
        }
    }

    @FXML
    void clickMode1(ActionEvent event) {
        if (iStart>=2&&YNMode1==false) {
            BtnMode1.setStyle("-fx-background-color:#aaff00");
            BtnMode2.setStyle("-fx-background-color:#ffbf76");
            YNMode1=true;
            YNMode2=false;
        }
    }

    @FXML
    void clickMode2(ActionEvent event) {
        if (iStart>=2&&YNMode2==false) {
            BtnMode2.setStyle("-fx-background-color:#aaff00");
            BtnMode1.setStyle("-fx-background-color:#ffbf76");
            YNMode2=true;
            YNMode1=false;
    }
    }
    @FXML
    void clickNormal(ActionEvent event) {
        if (YNRotate==false&&YNNormal==false) {         //Tắt quay và Normal chưa được nhấn
            BtnNormal.setStyle("-fx-background-color:grey");
            BtnSlow.setStyle("-fx-background-color:3c7fb1");
            YNNormal=true;
            YNSlow=false;
        }
    }
        @FXML
    void clickSlow(ActionEvent event) {
        if (YNRotate==false&&YNSlow==false) {         //Tắt quay và Normal chưa được nhấn
            BtnSlow.setStyle("-fx-background-color:grey");
            BtnNormal.setStyle("-fx-background-color:3c7fb1");
            YNNormal=false;
            YNSlow=true;
        }
    }
    @FXML
    void clickOutput(ActionEvent event) {
        if (iStart>=2&&YNOutput==false) {
            BtnOutput.setStyle("-fx-background-color:#64ff00");
            YNOutput=true;
        } else if (iStart>=2&&YNOutput==true) {
                BtnOutput.setStyle("-fx-background-color:#caff95");
                YNOutput=false;        
        }
    }
    @FXML
    void clickSLC(ActionEvent event) {
        if (YNSLC==false) {
            BtnSLC.setStyle("-fx-background-color:grey");
            YNSLC=true;
        } else {
                BtnSLC.setStyle("-fx-background-color:3c7fb1");
                YNSLC=false;        
        }
    }
    @FXML
    void clickPWS(ActionEvent event) {
        if (YNPWS==false) {
            BtnPWS.setStyle("-fx-background-color:grey");
            YNPWS=true;
        } else {
                BtnPWS.setStyle("-fx-background-color:3c7fb1");
                YNPWS=false;        
        }
    }
        @FXML
    void clickPlots(ActionEvent event) {
        if (YNPlots==false) {
            BtnPlots.setStyle("-fx-background-color:grey");
            YNPlots=true;
        } else {
                BtnPlots.setStyle("-fx-background-color:3c7fb1");
                YNPlots=false;        
        }
    }
            @FXML
    void clickTracks(ActionEvent event) {
        if (YNTracks==false) {
            BtnTracks.setStyle("-fx-background-color:grey");
            YNTracks=true;
        } else {
                BtnTracks.setStyle("-fx-background-color:3c7fb1");
                YNTracks=false;        
        }
    }
    @FXML
    void clickSelectO(ActionEvent event) {
        if (iStart>=2&&YNSelectO==false) {
            BtnSelectO.setStyle("-fx-background-color:#aaff00");
            YNSelectO=true;
        } else if (iStart>=2&&YNSelectO==true) {
                BtnSelectO.setStyle("-fx-background-color:#ffbf76");
                YNSelectO=false;        
        }
    }
    private StringProperty LabelString = new SimpleStringProperty();
    ///////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //
        
        ScrollLP.valueProperty().addListener((observable,oldvalue,newvalue) -> {
            if (YNTransmit==true) {
            int i = newvalue.intValue();
            TextLP.setText(Integer.toString((8-i)*10+87));                
            }

        });
        ScrollSP.valueProperty().addListener((observable,oldvalue,newvalue) -> {
            if (YNTransmit==true) {
            int i = newvalue.intValue();
            TextSP.setText(Integer.toString((8-i)*15+87));
            }
        });
        
        BtnStop.setOnMousePressed((event) -> {
            if (iStart!=0) {
                BtnStop.setStyle("-fx-background-color:red");
                iStart=1;
                BtnStart.setStyle("-fx-background-color:#caff95");
                BtnPark.setStyle("-fx-background-color:#caff95");
                TextMODE.setText("StandBy");
                BtnRotate.setStyle("-fx-background-color:3c7fb1");
                BtnTransmit.setStyle("-fx-background-color:3c7fb1");            //Tắt phát
                TextPower.setText("--");
                TextVSWR.setText("--");
                TextTrans.setText("Trans: 0");
                TextPlots.setText("Plots: 0");
                TextTracks.setText("Tracks: 0");
                TextSP.setText("0");
                TextLP.setText("0");
                BtnLow.setStyle("-fx-background-color:#640202");
                BtnSh6.setStyle("-fx-background-color:#640202");
                BtnRatio1.setStyle("-fx-background-color:#640202");
                BtnRatio2.setStyle("-fx-background-color:#640202");
                BtnSector.setStyle("-fx-background-color:#640202");
                BtnRun.setStyle("-fx-background-color:3c7fb1");
                BtnSelect.setStyle("-fx-background-color:#640202");
                BtnMode1.setStyle("-fx-background-color:#640202");
                BtnMode2.setStyle("-fx-background-color:#640202");
                BtnOutput.setStyle("-fx-background-color:3c7fb1");
                BtnSelectO.setStyle("-fx-background-color:#640202");
            }
        });
        BtnStop.setOnMouseReleased((event) -> {
            if (iStart!=0) {
                BtnStop.setStyle("-fx-background-color: #640202");
            }
        });
        //NGẨNG ANTEN    
        BtnUp.setOnMousePressed((event) -> {
            if (iStart >= 1) {
                BtnUp.setStyle("-fx-background-color:#64ff00");
                AngelElevation = (float) (AngelElevation + 0.1);
                DecimalFormat twoDFormat = new DecimalFormat("0.0");
                TextElevation.setText(twoDFormat.format(AngelElevation));
            }
        });
        BtnUp.setOnMouseReleased((event) -> {
            if (iStart >= 1) {
                BtnUp.setStyle("-fx-background-color:#caff95");
            }
        });
        //CHÚC ANTEN
        BtnDown.setOnMousePressed((event) -> {
            if (iStart >= 1) {
                BtnDown.setStyle("-fx-background-color:#64ff00");
                AngelElevation = (float) (AngelElevation - 0.1);
                DecimalFormat twoDFormat = new DecimalFormat("0.0");
//                TextElevation.setText("Elevation:   " + twoDFormat.format(AngelElevation));
                TextElevation.setText(twoDFormat.format(AngelElevation));
            }
        });
        BtnDown.setOnMouseReleased((event) -> {
            if (iStart >= 1) {
                BtnDown.setStyle("-fx-background-color:#caff95");
            }

        });        
        BtnStart.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'START' đưa đài ra đa vào chế độ làm việc 'Ready'");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        ); 
        BtnStop.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'STOP' chuyển đài ra đa về chế độ trực ban 'Stand By' và khẩn cấp dừng hoạt động của toàn hệ thống đài ra đa");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );               
        BtnRotate.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'ROTATE' dùng để bật và tắt chế độ hoạt động quay ăng ten");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnPark.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'PARK' dùng để xoay ăng ten về vị trí dành cho thu hồi ăng ten");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnUp.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'ELEVATION UP' dùng để điều khiển ngẩng ăng ten");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnDown.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'ELEVATION UP' dùng để điều khiển chúc ăng ten");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnTransmit.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'TRANSMIT' dùng để bật và tắt phát sóng");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnSh6.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'SH6' dùng để chọn chế độ chuyển tần thích ứng (linh hoạt tần số mang và mã hóa tần số) (SL6<Theo nhóm xung> hoặc SH6<Theo mỗi xung>)");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnRatio1.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn SCAN LIMIT 'RATIO 1' dùng để chọn chế độ phát sóng gián đoạn 1 vòng phát/1 vòng tắt");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnRatio2.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn SCAN LIMIT 'RATIO 2' dùng để chọn chế độ phát sóng gián đoạn 2 vòng phát/2 vòng tắt");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnSector.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'SECTOR' dùng để bật và tắt phát sóng theo cung dẻ quạt ");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnLow.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'LOW PWR' dùng để giảm công suất phát ");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnRun.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'RUN' dùng để bật và tắt máy hỏi ");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnSelect.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'SELECT' dùng để phát hỏi trong các cung dẻ quạt đã chọn");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnMode1.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'MODE 1' dùng để chọn chế độ của máy hỏi là chế độ chiến đấu");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnMode2.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'MODE 2' dùng để chọn chế độ của máy hỏi là chế độ máy tập");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnOutput.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'OUTPUT' dùng để bật và tắt đầu ra các dữ liệu ra đa");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnSelectO.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'SELECT' dùng để kết xuất dữ liệu ra đa của mục tiêu từ các vùng dẻ quạt được chọn");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnPWR.setOnMouseMoved((event) ->{        
        LabelString.setValue("Công tắc 'POWER' dùng để bật nguồn cho các bàn điều khiển");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        LED24.setOnMouseMoved((event) ->{        
        LabelString.setValue("Đèn LED +24V báo nguồn cấp bàn điều khiển LMCC");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        LED12.setOnMouseMoved((event) ->{        
        LabelString.setValue("Đèn LED +12V báo nguồn cấp bàn điều khiển LMCC");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnControl.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'CONTROL' dùng để chuyển quyền chủ động điều khiển đài ra đa");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        fuse.setOnMouseMoved((event) ->{        
        LabelString.setValue("Cầu chì +24V với đèn báo nguồn cấp của bàn điều khiển LMCC ");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        RectConsole.setOnMouseMoved((event) ->{        
        LabelString.setValue("Ô cửa 'CONSOLE' trên bảng điều khiển của các bàn la các phần tử bảo vệ và báo hiệu");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        RectRadar.setOnMouseMoved((event) ->{        
        LabelString.setValue("Ô cửa 'RADAR' trên bảng điều khiển của các bàn là các nút bấm điều khiển và báo hiệu chính của ra đa");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        RectAntenna.setOnMouseMoved((event) ->{        
        LabelString.setValue("Ô cửa 'ANTENNA' trên bảng điều khiển của các bàn là các nút bấm điều khiển và báo hiệu chính của hệ thống động lực ăng ten");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        RectTransmit.setOnMouseMoved((event) ->{        
        LabelString.setValue("Ô cửa 'TRANSMITTER' trên bảng điều khiển của các bàn là các nút bấm điều khiển và báo hiệu chính của hệ thống phát sóng");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        RectInterrogator.setOnMouseMoved((event) ->{        
        LabelString.setValue("Ô cửa 'INTERROGATOR' trên bảng điều khiển của các bàn là các nút bấm điều khiển và báo hiệu chính của giao diện máy hỏi");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        RectOutput.setOnMouseMoved((event) ->{        
        LabelString.setValue("Ô cửa 'OUTPUTS' trên bảng điều khiển của các bàn là các nút bấm điều khiển và báo hiệu chính của đầu ra dữ liệu");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnNormal.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'NORMAL' để chọn tốc độ quay anten 6 vòng/phút");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnSlow.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'SLOW' để chọn tốc độ quay anten 3 vòng/phút");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnPlots.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'Plots' để chọn phương pháp hiển thị 'Điểm dấu'");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnTracks.setOnMouseMoved((event) ->{        
        LabelString.setValue("Nút ấn 'Tracks' để chọn phương pháp hiển thị 'Quỹ đạo'");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnSLC.setOnMouseMoved((event) ->{        
        LabelString.setValue("Điều khiển 'SLC' để chế áp nhiễu không đổi tần có hệ số lấp đầy cao thu được từ cánh sóng bên của ăng ten");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        BtnPWS.setOnMouseMoved((event) ->{        
        LabelString.setValue("Điều khiển 'PWS' để chế áp nhiễu xung với hệ số lấp đầy thấp thu được từ cánh sóng bên của anten");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextAzimuth.setOnMouseMoved((event) ->{        
        LabelString.setValue("AZIMUTH: Hiển thị giá trị phương vị hiện thời của anten đài ra đa");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextElevation.setOnMouseMoved((event) ->{        
        LabelString.setValue("ELEVATION: Hiển thị giá trị góc chúc ngẩng hiện thời của anten đài ra đa");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextPower.setOnMouseMoved((event) ->{        
        LabelString.setValue("POWER: Hiển thị công suất phát của đài ra đa");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextVSWR.setOnMouseMoved((event) ->{        
        LabelString.setValue("VSWR: Hiển thị hệ số sóng đứng của anten hoặc tải tương đương đài ra đa");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextTempSTX.setOnMouseMoved((event) ->{        
        LabelString.setValue("Temp.STX: Hiển thị nhiệt độ cao nhất các phần tử tủ phát");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextTempCAB.setOnMouseMoved((event) ->{        
        LabelString.setValue("TempCAB: Hiển thị nhiệt độ cao cabin");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextNoise.setOnMouseMoved((event) ->{        
        LabelString.setValue("Noise: Hiển thị Hệ số tạp kênh chính máy thu");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextNoise1.setOnMouseMoved((event) ->{        
        LabelString.setValue("Hiển thị Hệ số tạp kênh chế áp 1");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextNoise2.setOnMouseMoved((event) ->{        
        LabelString.setValue("Hiển thị Hệ số tạp kênh chế áp 2");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextNoise3.setOnMouseMoved((event) ->{        
        LabelString.setValue("Hiển thị Hệ số tạp kênh chế áp 3");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextNoise4.setOnMouseMoved((event) ->{        
        LabelString.setValue("Hiển thị Hệ số tạp kênh chế áp 4");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextProtection.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chọn phương pháp bảo vệ SLC/PWS");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextDisplays.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chọn phương pháp hiển thị 'Điểm dấu' hay 'Quỹ đạo'");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextTrans.setOnMouseMoved((event) ->{        
        LabelString.setValue("Hiển thị Số lượng mục tiêu được gửi đi trong một vòng quét");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextPlots.setOnMouseMoved((event) ->{        
        LabelString.setValue("Hiển thị Số lượng điểm dấu trong một vòng quét");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        TextTracks.setOnMouseMoved((event) ->{        
        LabelString.setValue("Hiển thị Số lượng quỹ đạo trong một vòng quét");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        StackLP.setOnMouseMoved((event) ->{        
        LabelString.setValue("Hiển thị tổng số phát hiện trong một vòng quét của kênh xung dài");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        StackSP.setOnMouseMoved((event) ->{        
        LabelString.setValue("Hiển thị tổng số phát hiện trong một vòng quét của kênh xung ngắn");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        ScrollLP.setOnMouseMoved((event) ->{        
        LabelString.setValue("Thanh kéo LP để thiết lập độ nhạy kênh xung dài");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        ScrollSP.setOnMouseMoved((event) ->{        
        LabelString.setValue("Thanh kéo SP để thiết lập độ nhạy kênh xung ngắn");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_Radar.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị RADAR: Trạng thái chuẩn đoán toàn đài ");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_Antena.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị ANTENA: Trạng thái, chuẩn đoán hệ thống Anten ");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_CL.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị vị trí con trỏ chuột theo trục x/theo cự ly/theo vĩ độ ");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_PV.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị vị trí con trỏ chuột theo trục y/theo phương vị/theo kinh độ ");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_IFF.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị IFF: Trạng thái, chuẩn đoán hệ thống máy hỏi");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_LMCC.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị SRCC: Trạng thái, chuẩn đoán bàn điều khiển LMCC");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_MODE.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị MODE: Trạng thái, bộ điều khiển chế độ làm việc của đài");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_Output.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị OUTPUT: Trạng thái, chuẩn đoán hệ thống xuất dữ liệu");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_Process.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị PROCESS: Trạng thái, chuẩn đoán hệ thống xử lý tín hiệu");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_Receiver.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị RECEIVER: Trạng thái, chuẩn đoán hệ thống thu");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_Recoder.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị RECODER: Trạng thái, chuẩn đoán hệ thống sao lưu dữ liệu");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_Supply.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị SUPPLY: Trạng thái, chuẩn đoán hệ thống nguồn");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_Time.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị Time: hiển thị thời gian hiện tại");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_SRCC.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị SRCC: Trạng thái, chuẩn đoán bàn điều khiển SRCC");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
        STT_Transmit.setOnMouseMoved((event) ->{        
        LabelString.setValue("Chỉ thị TRANSMIT: Trạng thái, chuẩn đoán hệ thống phát");
        LebelInfo.textProperty().bind(LabelString); //DÙNG DẠNG TEXT CHẮC DỄ HƠN :d
        LebelInfo.setWrapText(true);
        }
        );
    }
    

//    private int toString(float AngelElevation) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}

