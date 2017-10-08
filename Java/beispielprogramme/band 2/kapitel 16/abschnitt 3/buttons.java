import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class buttons implements de.hamster.model.HamsterProgram {class VorAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        Hamster.getStandardHamster().vor();
    }

}

class LinksUmAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        Hamster.getStandardHamster().linksUm();
    }
}

public void main() {
    JFrame fenster = new JFrame("Hamster-Steuerung");
    fenster
            .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    fenster.setLayout(new FlowLayout());

    JButton vorButton = new JButton("vor");
    vorButton.addActionListener(new VorAction());
    fenster.add(vorButton);

    JButton linksUmButton = new JButton("linksUm");
    linksUmButton.addActionListener(new LinksUmAction());
    fenster.add(linksUmButton);

    fenster.setLocation(100, 200);
    fenster.pack();
    fenster.setVisible(true);
}}