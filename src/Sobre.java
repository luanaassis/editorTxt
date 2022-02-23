import javax.swing.*;
import java.util.Objects;

public class Sobre {
    JFrame frameSobre;
    public Sobre() {
        frameSobre = new JFrame("Sobre");
        JPanel painel = new JPanel();
        ImageIcon imagemSobre = new ImageIcon(Objects.requireNonNull(getClass().getResource("./sobre.png")));
        JLabel labelIcon = new JLabel(imagemSobre);
        painel.add(labelIcon);
        frameSobre.add(painel);
        frameSobre.setResizable(false);
        frameSobre.setSize(1080, 680);
    }
    public void AbrirSobre() {
        frameSobre.setVisible(true);
    }
}
