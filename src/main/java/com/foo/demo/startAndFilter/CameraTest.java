package com.foo.demo.startAndFilter;

import org.bytedeco.javacv.*;
import org.bytedeco.javacv.Frame;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
public class CameraTest {

    @RequestMapping("/getPic")
    public void getPic() throws Exception {
        OpenCVFrameGrabber openCVFrameGrabber = new OpenCVFrameGrabber(0);
        openCVFrameGrabber.start();
        CanvasFrame canvasFrame = new CanvasFrame("摄像头");
        System.out.println("摄像头 已开启");
        //设置关闭窗口时销毁窗口
        canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvasFrame.setAlwaysOnTop(true);
        int i = 0;
        while(true){
            if(canvasFrame.isEnabled()){
                System.out.println("摄像头已关闭");
                openCVFrameGrabber.stop();
                System.exit(-1);
            }
            //在canvas窗口上显示frame代表的图像
            canvasFrame.showImage(openCVFrameGrabber.grab());
            Date date = new Date();
            String name = "pic" + String.valueOf(date.getTime());
//            boolean imwrite = Imgcodecs.imwrite("C:\\Users\\hu\\Desktop\\" + name, mat);
            doExecuteFrame(openCVFrameGrabber.grabFrame(), "name");
            Thread.sleep(50);
            i++;
        }
//        return imwrite  ? "保存成功" : "保存失败";
    }


    public static void doExecuteFrame(Frame f, String targetFileName) {
        if (null ==f ||null ==f.image) {
            return;
        }
        Java2DFrameConverter converter =new Java2DFrameConverter();
        BufferedImage bi =converter.getBufferedImage(f);
        File output =new File(targetFileName);
        try {
            ImageIO.write(bi,"jpg",output);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
