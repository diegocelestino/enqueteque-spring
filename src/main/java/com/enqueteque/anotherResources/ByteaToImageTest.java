package com.enqueteque.anotherResources;

import jakarta.xml.bind.DatatypeConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

public class ByteaToImageTest {
    public static void main(String[] args) throws IOException {

        //loads an image and transforms it to bytea
        BufferedImage bImage = ImageIO.read(new File("C:/Users/diego/Pictures/EnqueteQue/dedao_do_pe.jpg"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        byte [] data = bos.toByteArray();

        //get a bytea image and transforms it into a base64 image
        String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(data);
        System.out.println(encodeImage);

        //transform a base64 back into a bytea
        byte[] dataFromBase64ToBytea = DatatypeConverter.parseBase64Binary(encodeImage);

        //write the bytea into a file
        String path = "C:/Users/diego/Pictures/EnqueteQue/" + "01.jpg";
        File file = new File(path);
        try(OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))){
            outputStream.write(dataFromBase64ToBytea);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
