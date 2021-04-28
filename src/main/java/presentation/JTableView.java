package presentation;

import javax.swing.*;
import java.awt.*;

public class JTableView extends JFrame {
    public JTableView(JTable jt){
        this.setTitle("Table");

        this.setSize(450,450);
        JPanel jp = new JPanel();
        //new JScrollPane(jt)
        jp.add(jt);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(245, 255, 255, 111));
        this.setContentPane(jp);
    }
}
