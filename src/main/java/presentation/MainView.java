package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JButton clientButton = new JButton("Client Operations") ;
    private JButton productButton= new JButton("Product Operations") ;
    private JButton orderButton = new JButton("Order Operations") ;

   public MainView(){
        this.setTitle("Order Management");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,450);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(245, 255, 255, 111));

        JPanel panelOne = new JPanel() ;
        panelOne.setBounds(0 , 100-50 , 450 , 50);
        panelOne.add(clientButton);

       JPanel panelTwo = new JPanel() ;
       panelTwo.setBounds(0 , 200-50 , 450 , 50);
       panelTwo.add(productButton);

       JPanel panelThree = new JPanel() ;
       panelThree.setBounds(0 , 300-50 , 450 , 50);
       panelThree.add(orderButton);

       JPanel allPanels = new JPanel();
       allPanels.add(panelOne);
       allPanels.add(panelTwo);
       allPanels.add(panelThree);
       allPanels.setLayout(null);
       this.setContentPane(allPanels);
    }
    public void addClientButtonListener(ActionListener adder){    clientButton.addActionListener(adder); }
    public void addProductButtonListener(ActionListener mul){ productButton.addActionListener(mul); }
    public void addOrderButtonListener(ActionListener sub){      orderButton.addActionListener(sub); }

}
