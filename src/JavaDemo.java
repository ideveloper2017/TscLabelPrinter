import com.sun.jna.Library;
import com.sun.jna.Native;

import java.text.SimpleDateFormat;
import java.util.Date;


public class JavaDemo {
    public interface TscLibDll extends Library {
        TscLibDll INSTANCE = (TscLibDll) Native.loadLibrary("\\TSCLIB", TscLibDll.class);
        int about();
        int openport(String pirnterName);
        int closeport();
        int sendcommand(String printerCommand);
        int setup(String width, String height, String speed, String density, String sensor, String vertical, String offset);
        int downloadpcx(String filename, String image_name);
        int barcode(String x, String y, String type, String height, String readable, String rotation, String narrow, String wide, String code);
        int printerfont(String x, String y, String fonttype, String rotation, String xmul, String ymul, String text);
        int clearbuffer();
        int printlabel(String set, String copy);
        int formfeed();
        int nobackfeed();
        int windowsfont(int x, int y, int fontheight, int rotation, int fontstyle, int fontunderline, String szFaceName, String content);
    }

    public interface DrvLP extends Library{
        DrvLP INSTANCE=(DrvLP) Native.loadLibrary("DrvLP",DrvLP.class);
        public void connect();
    }

    public  void print1(){
        System.setProperty("jna.encoding", "GBK");// Support Chinese
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        String qrCode = "PD102011";
        TscLibDll.INSTANCE.openport("Xprinter XP-365B");//Printer model
        TscLibDll.INSTANCE.setup("70","40","5","8","0","2","0");
        TscLibDll.INSTANCE.clearbuffer();
        String command = "QRCODE 20,90,Q,9,A,0,M1,S7,\"" + qrCode+"\""; //Print the parameters and contents of the QR code
        TscLibDll.INSTANCE.sendcommand (command);
        // TscLibDll.INSTANCE.sendcommand("TEXT 300 70 36 0 0 0 arial"+ "Office Supplies - Label Paper");
        TscLibDll.INSTANCE.windowsfont(230, 120, 48, 0, 0, 0, "arial", "Product_Code");
        TscLibDll.INSTANCE.windowsfont(230, 170, 68, 0, 0, 0, "arial", "6806");
        TscLibDll.INSTANCE.printlabel("1", "1");
        TscLibDll.INSTANCE.closeport();
    }

    public  void print2(){
        System.setProperty("jna.encoding", "GBK");// Support Chinese
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        String qrCode = "PD102011";
        TscLibDll.INSTANCE.openport("Xprinter XP-365B");//Printer model
        TscLibDll.INSTANCE.setup("30","20","5","8","0","2","0");
        TscLibDll.INSTANCE.clearbuffer();
        String command = "QRCODE 10,30,Q,5,A,0,M1,S7,\"" + qrCode+"\""; //Print the parameters and contents of the QR code
        TscLibDll.INSTANCE.sendcommand (command);
        // TscLibDll.INSTANCE.sendcommand("TEXT 300 70 36 0 0 0 arial"+ "Office Supplies - Label Paper");
        TscLibDll.INSTANCE.windowsfont(130, 25, 38, 0, 0, 0, "arial", "12$");
        TscLibDll.INSTANCE.windowsfont(130, 60, 38, 0, 0, 0, "arial", "Code");
        TscLibDll.INSTANCE.windowsfont(130, 100, 38, 0, 0, 0, "arial", "6806");
        TscLibDll.INSTANCE.printlabel("1", "1");
        TscLibDll.INSTANCE.closeport();
    }

    public  void print3(){
        System.setProperty("jna.encoding", "GBK");// Support Chinese
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        String qrCode = "PD102011";
        TscLibDll.INSTANCE.openport("Xprinter XP-365B");//Printer model
        TscLibDll.INSTANCE.setup("40","30","5","8","0","2","0");
        TscLibDll.INSTANCE.clearbuffer();
        String command = "QRCODE 15,40,Q,7,A,0,M1,S7,\"" + qrCode+"\""; //Print the parameters and contents of the QR code
        TscLibDll.INSTANCE.sendcommand (command);
        // TscLibDll.INSTANCE.sendcommand("TEXT 300 70 36 0 0 0 arial"+ "Office Supplies - Label Paper");
        TscLibDll.INSTANCE.windowsfont(170, 25, 55, 0, 0, 0, "arial", "12$");
        TscLibDll.INSTANCE.windowsfont(170, 80, 55, 0, 0, 0, "arial", "Code");
        TscLibDll.INSTANCE.windowsfont(170, 135, 55, 0, 0, 0, "arial", "6806");
        TscLibDll.INSTANCE.printlabel("1", "1");
        TscLibDll.INSTANCE.closeport();
    }

    public static void main(String[] args) {
        try {
//            System.load("D:\\JavaProjects\\TscPrinterLabel\\lib\\DrvLP.dll");
            DrvLP instance = DrvLP.INSTANCE;
            instance.connect();
        } catch (Exception e){
            e.printStackTrace();
        }
//        new JavaDemo().print3();
    }



}