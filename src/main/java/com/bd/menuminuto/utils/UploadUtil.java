package com.bd.menuminuto.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadUtil {

    private static String pastaUploadImagem = "src/main/resources/static/uploads";
    
        public static boolean fazerUploadImagem(MultipartFile imagem) { 
            boolean sucessoUpload = false;
            if (!imagem.isEmpty()) {
                String nomeArquivo = imagem.getOriginalFilename();
                try {
                    File dir = new File(pastaUploadImagem); //criar diretorio 
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + nomeArquivo);
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                        stream.write(imagem.getBytes());
                        sucessoUpload = true;
                    } catch (IOException e) { 
                        System.out.println("Imagem não encontrada! " + e.getMessage());
                    }
                } catch (Exception e) {
                System.out.println("Falha na criação do diretório! " + e.getMessage());
                }
            } else {
                    System.out.println("Sem imagem!");
                    }
        return sucessoUpload;
    }
}