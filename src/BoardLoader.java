import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Jordan on 3/14/2016.
 */
public class BoardLoader {

    private final String location;

    public BoardLoader(final String location) {
        this.location = location;
    }

    private String readFile() {
        try {
            final File file = new File(this.location);
            final FileInputStream fin = new FileInputStream(file);
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fin));
            String str, returnString = "";
            while ((str = bufferedReader.readLine()) != null) {
                returnString += str;
            }
            return returnString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SBoard toBoard() {
        final SBoard board = new SBoard();
        final String data;
        if ((data = this.readFile()) != null) {
            for (int i = 0; i < data.length(); i++) {
                board.getBoard()[i / 9][i % 9] = Character.getNumericValue(data.toCharArray()[i]);
                board.getInitBoard()[i / 9][i % 9] = Character.getNumericValue(data.toCharArray()[i]);
            }
        }
        return board;
    }

}
