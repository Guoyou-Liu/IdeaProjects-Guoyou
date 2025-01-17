package gt.org.utils;

import io.appium.java_client.AppiumDriver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralMethods {

    public static void scrolling(@NotNull String scrollDirection, int duration){
        Point point = new Point(0,0);
        int x = point.x;
        int y = point.y;
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        switch (scrollDirection.toLowerCase()){
            case "left":
                startX = x + (width * 4/5);
                startY = y +(height / 2);
                endX = x + (width /10);
                endY = y +(height / 2);
                break;
            case "down":
                startX = x +(width / 2);
                startY = y + (height * 4/5);
                endX = x +(width / 2);
                endY = y + (height /2);
                break;
            case "right":
                startX = x + (width /10);
                startY = y +(height / 2);
                endX = x + (width * 4/5);
                endY = y +(height / 2);
                break;
            case "up":
                startX = x +(width / 2);
                startY = y + (height /3);
                endX = x +(width / 2);
                endY = y + (height * 4/5);
                break;
            default:
                break;
        }
        Point start =new Point(startX,startY);
        Point end = new Point(endX,endY);
        W3cActions.doSwipe(DriverManager.getDriver(),start,end,duration);
    }

    public static void scrollingElement(@NotNull String direction, @NotNull WebElement webElement, int duration){
        Rectangle rectangle = webElement.getRect();
        int x = rectangle.getX();
        int y = rectangle.getY();
        int width = rectangle.getWidth();
        int height = rectangle.getHeight();
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        switch (direction.toLowerCase()){
            case "left":
                startX = x + (width * 4/5);
                startY = y +(height / 2);
                endX = x + (width /5);
                endY = y +(height / 2);
                break;
            case "down":
                startX = x +(width / 2);
                startY = y + (height * 4/5);
                endX = x +(width / 2);
                endY = y + (height /2);
                break;
            case "right":
                startX = x + (width /10);
                startY = y +(height / 2);
                endX = x + (width * 4/5);
                endY = y +(height / 2);
                break;
            case "up":
                startX = x +(width / 2);
                startY = y + (height /3);
                endX = x +(width / 2);
                endY = y + (height * 4/5);
                break;
            default:
                break;
        }
        Point start =new Point(startX,startY);
        Point end = new Point(endX,endY);
        W3cActions.doSwipe(DriverManager.getDriver(),start,end,duration);

    }

    public static boolean timeComparison(@NotNull LocalDate currentTime, LocalDate comparisonTime){
        boolean Validity;
        if (currentTime.isEqual(comparisonTime)){
            Validity =true;
        }else {
            Validity = currentTime.isBefore(comparisonTime);
        }
        return Validity;
    }

    public static String regexMethod(String regexTimeContent, String regex,int regexNumber){
        String regexData = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =  pattern.matcher(regexTimeContent);
        if (matcher.find()) {
            regexData = matcher.group(regexNumber);
        }
        return regexData;
    }

    public static long calculationTimeDays(String date,String dateFormatter){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatter);
        LocalDate dateTime = LocalDate.parse(date,formatter);
        LocalDate currentTime = LocalDate.now();
        return ChronoUnit.DAYS.between(currentTime, dateTime);
    }

    public static void saveText(String content,String fileName){
        try(FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Saved uccessfully: " +content);
        }catch (IOException e){
            System.err.println("Save failed");}
    }

    public static String getTextContent(String fileName){
        String fullContent = "";
        try {
            fullContent = Files.readString(Paths.get(fileName));
            System.out.println("Successful to obtain: " + fullContent);
        } catch (IOException e) {
            System.err.println("Failed to obtain");
        }
        return fullContent;
    }

    public static BufferedImage getElementImage(WebElement element) throws IOException {
            String elementBase64 = element.getScreenshotAs(OutputType.BASE64);
            elementBase64 = elementBase64.replaceAll("[\n\r]","");
            byte [] elementImage = Base64.getDecoder().decode(elementBase64);
            return ImageIO.read(new ByteArrayInputStream(elementImage));
    }

    public static boolean viewImageIsNotNull(BufferedImage image){
        for (int x = 0; x < image.getWidth(); x++){
            for (int y = 0; y < image.getHeight(); y++){
                int rgb = image.getRGB(x,y);
                Color color = new Color(rgb);
                if (color.getRed() != 255 || color.getGreen() != 255 || color.getBlue() != 255){
                    return true;
                }
            }
        }
        return false;
    }

    public static void saveElementImage(BufferedImage image, String imageName) throws IOException {
        File outputFile = new File("target/imageSave/"+ imageName + ".png");
        outputFile.getParentFile().mkdirs();
        ImageIO.write(image,"PNG",outputFile);
    }

    public static BufferedImage getPathImage(String imageName) throws IOException {
        File ImageFile = new File("target/imageSave/"+ imageName + ".png");
        return ImageIO.read(ImageFile);
    }

    public static boolean ImageComparison(BufferedImage image1, BufferedImage image2){
        if (image1.getWidth() != image2.getWidth() || image1.getHeight() != image2.getHeight()){
            return false;
        }
        for (int x = 0; x < image1.getWidth(); x++){
            for (int y = 0; y < image1.getHeight(); y++){
                int rgb1 = image1.getRGB(x,y);
                int rgb2 = image2.getRGB(x,y);
                if (rgb1 != rgb2){
                    return false;
                }
            }
        }
        return true;
    }

    public static void longPress(AppiumDriver driver, WebElement element, long duration){
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .clickAndHold()
                .pause(Duration.ofSeconds(duration)) // 长按
                .release()
                .perform();
    }
}
