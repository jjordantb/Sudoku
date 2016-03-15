import javax.swing.*;
import java.awt.*;

/**
 * Created by Jordan on 3/15/2016.
 */
public class BoardRenderer extends JPanel {

    private final BoardLoader boardLoader;
    private final SBoard board;

    public BoardRenderer(final BoardLoader boardLoader) {
        this.boardLoader = boardLoader;
        this.board = boardLoader.toBoard();
        this.board.solveBoard(0, 0);
    }

    @Override
    public void paintComponent(final Graphics g ){
        super.paintComponent(g);
        final Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.BLACK);
        final Rectangle rectangle = new Rectangle(10, 10, this.getWidth() - 20, this.getHeight() - 20);
        g2.setStroke(new BasicStroke(3));
        g2.draw(rectangle);
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) {
                g2.setStroke(new BasicStroke(3));
            } else {
                g2.setStroke(new BasicStroke(1));
            }
            g.drawLine(rectangle.x, rectangle.y + (r * (rectangle.height / 9)), rectangle.width + rectangle.x, rectangle.y + (r * (rectangle.height / 9)));
            g.drawLine(rectangle.x + (r * (rectangle.width / 9)), rectangle.y, rectangle.x + (r * (rectangle.width / 9)), rectangle.height + rectangle.y);
            for (int c = 0; c < 9; c++) {
                if (this.board.getInitBoard()[r][c] != 0) {
                    g2.setFont(new Font("default", Font.BOLD, 24));
                    g2.setColor(new Color(227, 73, 69));
                    g2.drawString(Integer.toString(this.board.getInitBoard()[r][c]), rectangle.x + (c * (rectangle.width / 9)) + 20, rectangle.y + (r * (rectangle.height / 9)) + 35);
                    g2.setColor(Color.BLACK);
                }
                if (this.board.getInitBoard()[r][c] != this.board.getBoard()[r][c]) {
                    g2.setFont(new Font("default", Font.PLAIN, 24));
                    g2.setColor(Color.BLACK);
                    g2.drawString(Integer.toString(this.board.getBoard()[r][c]), rectangle.x + (c * (rectangle.width / 9)) + 20, rectangle.y + (r * (rectangle.height / 9)) + 35);
                    g2.setColor(Color.BLACK);
                }
            }
        }

    }

}
