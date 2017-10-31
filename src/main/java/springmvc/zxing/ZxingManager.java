package springmvc.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;

public class ZxingManager {

    public static String createQRcode(String content,String path){

        int width = 300;
        int height = 300;

        String format = "png";

        HashMap hints= new HashMap();

        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// 字符集
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);// 纠错级别
        hints.put(EncodeHintType.MARGIN, 2);// 空白
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                    BarcodeFormat.QR_CODE, width, height, hints);



            Path file = new File(path).toPath();


            MatrixToImageWriter.writeToPath(bitMatrix, format, file);

        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/img/zxing.png";
    }



}
