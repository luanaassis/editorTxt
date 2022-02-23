import javax.swing.*;
import java.util.Objects;

public class Documentacao {
    JFrame frameDoc;
    public Documentacao() {
        frameDoc = new JFrame("Documentação");
        JPanel painel = new JPanel();
        ImageIcon imagemDoc = new ImageIcon(Objects.requireNonNull(getClass().getResource("./doc.png")));
        JLabel labelIcon = new JLabel(imagemDoc);
        painel.add(labelIcon);
        frameDoc.add(painel);
        frameDoc.setResizable(false);
        frameDoc.setSize(1080, 680);
    }
    public void AbrirDocumentacao() {
        frameDoc.setVisible(true);
    }
}
