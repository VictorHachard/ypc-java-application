package ypc.model;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import ypc.vget.SyncPipe;

import java.io.PrintWriter;

public class Downloader {

    @FXML
    TextArea taLog;

    public void Download(String url) {
        String downloadPath="C:\\Users\\delelte\\Desktop";
        String[] command = { "cmd" };
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("cd \""+downloadPath+"\"");
            stdin.println(downloadPath+"\\youtube-dl "+url);
            stdin.close();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
