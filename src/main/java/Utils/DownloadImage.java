package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DownloadImage {

    private final String downloadFileLocation = "src\\main\\java\\Files";
    private InputStream inputStream;
    private OutputStream fileOutputStream;
    private URL url;

    public void downloadImage(String urlImage) {

        try {
            
            int imageNumber = getAmountSavedPictures() + 1;
            String[] urlImageSplit = urlImage.split("\\.");
            url = new URL(urlImage);
            inputStream = url.openStream();
            fileOutputStream = new FileOutputStream(downloadFileLocation + "\\Dog Picture " + imageNumber +"." + urlImageSplit[urlImageSplit.length - 1]);

            int currentByte;
            while ((currentByte = inputStream.read()) != -1)
                fileOutputStream.write(currentByte);

            inputStream.close();
            fileOutputStream.close();
        } 
        catch (MalformedURLException ex) {
            Logger.getLogger(DownloadImage.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(DownloadImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int getAmountSavedPictures(){
        
        File imagesFolder = new File(downloadFileLocation);
        File[] imageFiles = imagesFolder.listFiles();
        return imageFiles.length;
    }
}
