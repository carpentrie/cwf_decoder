import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Decoder {

    private static final String CHARSET_UTF8 = "UTF-8";
    private static final String CHARSET_CP1251 = "CP1251";

    private String readFile(String filePath, String charset){
        try {
            return FileUtils.readFileToString(new File(filePath), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeFile(String fileContent, String filePath, String charset){
        try {
            FileUtils.writeStringToFile(new File(filePath), fileContent, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Decoder d = new Decoder();
        String basePath = "/home/nanomonk/dev/workspace/cwf/";
        String cp1251 = "text_cp1251.txt";
        String utf8 = "text_utf8.txt";
        String result = "result_";


        d.writeFile(d.readFile(basePath+cp1251, CHARSET_CP1251), basePath+result+cp1251, CHARSET_CP1251);
        d.writeFile(d.readFile(basePath+utf8, CHARSET_UTF8), basePath+result+utf8, CHARSET_UTF8);



    }
}
