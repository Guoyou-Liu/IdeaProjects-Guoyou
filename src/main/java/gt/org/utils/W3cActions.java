package gt.org.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.util.Collections;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class W3cActions {

    private final static PointerInput FINGER = new PointerInput(TOUCH, "finger");

    public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(FINGER.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }

    public static void doTap(AppiumDriver driver, Point point, int duration) {
        Sequence tap = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), point.getX(), point.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(FINGER, ofMillis(duration)))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));
    }

    //usage: AppiumActions.doMoveTo(driver, startPoint, endPoint, 1000);
//    public static void doMoveTo(AppiumDriver driver, Point startPoint, Point endPoint, int duration) {
//        // Create a new pointer input instance
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        // Create a sequence of actions
//        Sequence dragAndDrop = new Sequence(finger, 1);
//        // Add actions to the sequence
//        dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startPoint.x, startPoint.y))
//                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//                .addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), endPoint.x, endPoint.y))
//                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        // Perform the sequence
//        driver.perform(List.of(dragAndDrop));
//    }

}