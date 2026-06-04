package chess;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanelComponents(60));
        //add(new GamePanelDraw(60));
        setVisible(true);
    }
}
