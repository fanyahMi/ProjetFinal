package com.spring.models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

public class Photo {
    private String data;
    private String contentType;

    public Photo() {

    }
    
    public Photo(String data, String contentType) {
        this.data = data;
        this.contentType = contentType;
    }

    public Photo(MultipartFile file) {
            // Convertir le fichier en base64
            byte[] fileBytes = toOptimizedFormat(file);
            String base64EncodedImageData = Base64.getEncoder().encodeToString(fileBytes);

            this.data = base64EncodedImageData;
            this.contentType = file.getContentType();

            System.out.println("** Img-Data success **");
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public static byte[]  resizeTo360p(byte[] fileBytes) {
        // Assuming you have the original byte array in fileBytes
        byte[] resizedBytes = null;

        try {
            // Convert the byte array to an InputStream
            ByteArrayInputStream inputStream = new ByteArrayInputStream(fileBytes);

            // Resize the image to 360p
            BufferedImage resizedImage = Thumbnails.of(inputStream)
                    .size(640, 360)
                    .outputFormat("jpg")
                    .asBufferedImage();

            // Convert the resized BufferedImage back to a byte array
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(resizedImage, "jpg", outputStream);
            resizedBytes = outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resizedBytes;
    }

    public static byte[]  toOptimizedFormat(MultipartFile file) {
        long fileSize = file.getSize();

        try {
            if (fileSize >= 1 * 1024 * 1024) { // Vérifier si la taille est supérieure ou égale à 1 Mo (en octets)
                return Photo.resizeTo360p(IOUtils.toByteArray(file.getInputStream()));
            } 
            return IOUtils.toByteArray(file.getInputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
}
