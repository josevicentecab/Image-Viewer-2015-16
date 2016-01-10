package IV.Application;

/*
 * @author josevicentecabanas
 */
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.ABORT;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import IV.Model.Image;
import IV.View.Display;
import IV.Control.Command;
import IV.Control.Next;
import IV.Control.Prev;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

public class Application extends JFrame {

    private final Map<String, Command> commands = new HashMap<>();
    private Display display;

    public static void main(String[] args) {
        new Application().setVisible(true);
    }
    public Application() {      
        this.deployComponents();
        this.createCommands();
    }
    private void deployComponents() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(Panel());
        this.getContentPane().add(toolbar(), BorderLayout.SOUTH);
    }
    private void createCommands() {
        commands.put("next", new Next(display));
        commands.put("prev", new Prev(display));
    }
    private Panel Panel() {
        Panel panel = new Panel(firstImage());
        this.display = panel;
        return panel;
    }
    private Image firstImage() {
        return new FileViewer(this.getFolderPath()).read();
    }
    private String getFolderPath() {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);       
        if (fileChooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) System.exit(ABORT);
        return fileChooser.getSelectedFile().getAbsolutePath();
    }
    private JPanel toolbar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }
    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(doCommand("prev"));
        return button;
    }
    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(doCommand("next"));
        return button;
    }
    private ActionListener doCommand(String operation) {
        return (ActionEvent event) -> Application.this.commands.get(operation).execute();
    }
}
