package com.switfcart.productservice.utils;

import com.switfcart.productservice.controller.ProductController;
import com.switfcart.productservice.models.ProductImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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

    static Logger logger = LoggerFactory.getLogger(ProductController.class);

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

        logger.info("Path of image " + pathOfImage);

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
