import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.LibraryLoader;
import com.sun.jna.Library;
import com.sun.jna.Native;
import java.io.File;


public class ActiveXExample {
    public interface MyCOMLibrary extends Library {
       // File file = new File("lib", "DrvLP.dll");

        MyCOMLibrary INSTANCE = (MyCOMLibrary) Native.loadLibrary("\\DrvLP", MyCOMLibrary.class);

        // COM metodlarini e'lon qilish
    }
    public static void main(String[] args) {
        File file = new File("lib", "DrvLP.dll");
//        System.load(file.getAbsoluteFile().toString());
//        System.loadLibrary("tesseract");
//        System.setProperty(LibraryLoader.JACOB_DLL_PATH, "D:\\JavaProjects\\TscPrinterLabel\\lib\\jacob-1.19-x64.dll"); // DLL faylining to'liq yo'lini kiriting
//        LibraryLoader.loadJacobLibrary();
        MyCOMLibrary instance = MyCOMLibrary.INSTANCE;
//        Dispatch ax = new ActiveXComponent("AddIn.DrvLP"); // ProgID ni ActiveX komponentingizning ProgID si bilan almashtiring
//        System.out.println(ax.getProgramId());
//        Dispatch test = new ActiveXComponent("AddIn.DrvLP");
//        // JACOB kutubxonasini yuklash
//        System.setProperty(LibraryLoader.JACOB_DLL_PATH, "/lib/jacob-1.19-x64"); // DLL faylining to'liq yo'lini kiriting
//        LibraryLoader.loadJacobLibrary();
//
//        // ActiveX komponentini yaratish
//        ActiveXComponent ax = new ActiveXComponent("ProgID"); // ProgID ni ActiveX komponentingizning ProgID si bilan almashtiring
//
//        // ActiveX komponentiga metod chaqiruvini amalga oshirish
//        Dispatch.call(ax, "MethodName", "Parameter1", "Parameter2"); // MethodName va parametrlarni o'zgartiring
    }
}