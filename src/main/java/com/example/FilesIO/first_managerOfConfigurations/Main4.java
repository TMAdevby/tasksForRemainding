package com.example.FilesIO.first_managerOfConfigurations;

import java.io.*;

public class Main4 {
    public static void main(String[] args) {
        copyPhoto("C:\\Users\\mtipu\\OneDrive\\Desktop","photo.jpg");
    }

    public static void copyPhoto(String path, String photoName){
        File file = new File(path,photoName);

        if(file.exists()) {
            byte[] buffer = new byte[8192];
            int read;
            String copyPhotoName = "copy_" + photoName;
            String fullPath = path + "\\" + photoName;
            String copyFullPath = path + "\\" + copyPhotoName;

            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fullPath));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copyFullPath))) {

                while ((read = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0 , read);
                }
                System.out.println("Файл " + photoName + " скопирован.");
            } catch (FileNotFoundException e) {
                System.out.println("Ошибка при копировании файла " + photoName);
                throw new RuntimeException(e);
            } catch (IOException e) {
                System.out.println("Ошибка при копировании файла " + photoName);
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Файла не существует");
        }
    }
}
