/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profiler.wrks;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;
import java.io.FileOutputStream;
import profiler.beans.Compte;

/**
 *
 * @author skyid
 */
public class WrkQR {

    public void generateQR(Compte compte) {

        // encode
        BitMatrix bitMatrix = generateMatrix(formatCompte(compte), 200);
        String imageFormat = "png";
        String outputFileName = "c:/code/qrcode-01." + imageFormat;

        // write in a file
        writeImage(outputFileName, imageFormat, bitMatrix);
    }

    private static void writeImage(String outputFileName, String imageFormat, BitMatrix bitMatrix) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFileName));
            MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, fileOutputStream);
            fileOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String formatCompte(Compte compte) {
        return compte.getPkCompte() + ";" + compte.getNom() + ";" + compte.getPrenom() + ";" + compte.getTelPrive() + ";" + compte.getTelProf() + ";" + compte.getEntreprise();
    }

    private static BitMatrix generateMatrix(String data, int size) {
        try {
            BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
            return bitMatrix;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
