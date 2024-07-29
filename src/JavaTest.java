import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import com.sun.jna.Library;
import com.sun.jna.Native;
public class JavaTest 
{

	public interface TscLibDll extends Library
	{		
		TscLibDll INSTANCE = (TscLibDll) Native.loadLibrary("\\TSCLIB", TscLibDll.class);
        int about ();
        int openport (String pirnterName);
        int closeport ();
        int sendcommand (String printerCommand);
        int sendBinaryData (byte[] printerCommand, int CommandLength);
        int setup (String width,String height,String speed,String density,String sensor,String vertical,String offset);
        int downloadpcx (String filename,String image_name);
        int barcode (String x,String y,String type,String height,String readable,String rotation,String narrow,String wide,String code);
        int qrCode (String x,String y,String type,String height,String readable,String rotation,String narrow,String wide,String code);
        int printerfont (String x,String y,String fonttype,String rotation,String xmul,String ymul,String text);
        int clearbuffer ();
        int printlabel (String set, String copy);        
        int windowsfont (int x, int y, int fontheight, int rotation, int fontstyle, int fontunderline, String szFaceName, String content);
        int windowsfontUnicode(int x, int y, int fontheight, int rotation, int fontstyle, int fontunderline, String szFaceName, byte[] content);
        int windowsfontUnicodeLengh(int x, int y, int fontheight, int rotation, int fontstyle, int fontunderline, String szFaceName, byte[] content, int length);
        byte usbportqueryprinter();
        
	}
    public static void main(String[] args)
    {

        String WT1 = "Xprinter XP 365B";
        String B1 = "20080101";

    	//unicode format
    	byte[] result_unicode = new byte[1024];
    	String word_unicode = "Xprinter XP 365B";
    	result_unicode = word_unicode.getBytes(StandardCharsets.UTF_16LE);

    	//utf-8 format
    	byte[] result_utf8 = new byte[1024];
    	String word_utf8 = "TEXT 40,620,\"ARIAL.TTF\",0,12,12,\"utf8 test Wörter auf Deutsch\"";
    	result_utf8 = word_utf8.getBytes(StandardCharsets.UTF_8);

    	
        //TSCLIB_DLL.about();
        byte status = TscLibDll.INSTANCE.usbportqueryprinter();//0 = idle, 1 = head open, 16 = pause, following <ESC>!? command of TSPL manual
        TscLibDll.INSTANCE.openport("Xprinter XP-365B");
        TscLibDll.INSTANCE.sendcommand("SIZE 40 mm, 39.5 mm");
        TscLibDll.INSTANCE.sendcommand("SPEED 4");
        TscLibDll.INSTANCE.sendcommand("DENSITY 12");
        TscLibDll.INSTANCE.sendcommand("DIRECTION 0");
        TscLibDll.INSTANCE.sendcommand("SET TEAR ON");
        TscLibDll.INSTANCE.sendcommand("CODEPAGE UTF-8");
        TscLibDll.INSTANCE.clearbuffer();
//        TscLibDll.INSTANCE.downloadpcx("\\UL.PCX", "UL.PCX");
        TscLibDll.INSTANCE.windowsfont(40, 70 , 48, 0, 0, 0, "Arial", "Windows Font Test");
        TscLibDll.INSTANCE.windowsfontUnicodeLengh(40, 50, 30, 0, 0, 0, "Arial", result_unicode,word_unicode.length());
        TscLibDll.INSTANCE.sendcommand("PUTPCX 40,40,\"UL.PCX\"");
        TscLibDll.INSTANCE.sendBinaryData(result_utf8, result_utf8.length);
        TscLibDll.INSTANCE.barcode("40", "100", "128", "80", "1", "0", "2", "2", B1);
        //TscLibDll.INSTANCE.qrcode("40", "100", "128", "80", "1", "0", "2", "2", B1);
        TscLibDll.INSTANCE.printerfont("40", "440", "0", "0", "15", "15", WT1);
        TscLibDll.INSTANCE.printlabel("1", "1");
        TscLibDll.INSTANCE.closeport();
    	
    	
    	
    	
    	
    }
    

}


