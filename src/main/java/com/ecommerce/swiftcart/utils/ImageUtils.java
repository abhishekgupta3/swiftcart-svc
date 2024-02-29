package com.ecommerce.swiftcart.utils;

import com.ecommerce.swiftcart.models.ProductImage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtils {
    public static final String IMAGES_DIR_BASE_PATH;

    static {
        try {
            IMAGES_DIR_BASE_PATH = new ClassPathResource("/static/image/").getFile().getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    public final static String IMAGES_DIR_BASE_PATH = "/static/image/";
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (Exception error) {
            System.out.println(error);
        }
        return outputStream.toByteArray();
    }

    public static ProductImage generateProductImageFromFile(MultipartFile file) throws IOException {
        ProductImage productImage = new ProductImage();
        productImage.setName(file.getOriginalFilename());
        productImage.setType(file.getOriginalFilename());
        productImage.setTimestamp(new Timestamp(System.currentTimeMillis()));

        StringBuilder pathOfImage = new StringBuilder(IMAGES_DIR_BASE_PATH + File.separator + file.getOriginalFilename());
        for (int i = 0; i < pathOfImage.length(); i++) {
            if (pathOfImage.charAt(i) == '\\') {
                pathOfImage.setCharAt(i, '/');
            }
        }

        System.out.println(pathOfImage);

        productImage.setPath(pathOfImage.toString());
        saveImageToPath(pathOfImage.toString(), file);
        return productImage;
    }

    public static void saveImageToPath(String path, MultipartFile file) throws IOException {
        file.transferTo(new File(path));
    }

//    public static Path createFileWithDir(String directory, MultipartFile file) {
//        File dir = new File(directory);
//        if (!dir.exists()) dir.mkdirs();
//        return Paths.get(directory + File.separatorChar + file);
//    }
}
