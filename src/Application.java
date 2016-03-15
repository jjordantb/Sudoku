import javax.swing.*;
import java.awt.*;

/**
 * Created by Jordan on 3/14/2016.
 */
public class Application {

    public static final String BOARD_LOCATION = "./boards/board2.brd";

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        centerFrame(frame);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout(0, 0));

        final BoardRenderer boardRenderer = new BoardRenderer(new BoardLoader(BOARD_LOCATION));
        frame.add(boardRenderer, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void centerFrame(final JFrame frame) {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final int x = (toolkit.getScreenSize().width / 2) - (frame.getWidth() / 2);
        final int y = (toolkit.getScreenSize().height / 2) - (frame.getHeight() / 2);
        frame.setLocation(x, y);
    }

}
