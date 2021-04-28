package presentation;

import model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OrderView extends JFrame {

    private JTextField idJT = new JTextField();
    private JTextField clientIdJT = new JTextField();
    private JTextField productIdJT = new JTextField();
    private JTextField quantityJT = new JTextField();

    private JButton addOrderButton = new JButton("Add a new Order") ;
    private JButton editOrderButton = new JButton("Edit Order") ;
    private JButton deleteOrderButton = new JButton("Delete Order") ;
    private JButton viewAllOrdersButton = new JButton("Display Order Table") ;
    private JButton backButton = new JButton("Back") ;
    public OrderView(){
        this.setTitle("Order Management Orders");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,750);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(245, 255, 255, 111));
        idJT.setPreferredSize(new Dimension(100,30));
        clientIdJT.setPreferredSize(new Dimension(100,30));
        productIdJT.setPreferredSize(new Dimension(100,30));
        quantityJT.setPreferredSize(new Dimension(100,30));

        JPanel panelId = new JPanel() ;
        panelId.setBounds(0 , 100-50 , 450 , 50);
        panelId.add(new JLabel("ID"));
        panelId.add(idJT);

        JPanel panelname = new JPanel() ;
        panelname.setBounds(0 , 150-50 , 450 , 50);
        panelname.add(new JLabel("ClientID"));
        panelname.add(clientIdJT);

        JPanel panelEmail = new JPanel() ;
        panelEmail.setBounds(0 , 150 , 450 , 50);
        panelEmail.add(new JLabel("ProductID"));
        panelEmail.add(productIdJT);

        JPanel panelTelephone = new JPanel();
        panelTelephone.setBounds(0 , 200 , 450 , 50);
        panelTelephone.add(new JLabel("Quantity"));
        panelTelephone.add(quantityJT);

        JPanel panelOne = new JPanel() ;
        panelOne.setBounds(0 , 300 , 450 , 50);
        panelOne.add(addOrderButton);

        JPanel panelTwo = new JPanel() ;
        panelTwo.setBounds(0 , 350 , 450 , 50);
        panelTwo.add(editOrderButton);

        JPanel panelThree = new JPanel() ;
        panelThree.setBounds(0 , 450 , 450 , 50);
        panelThree.add(deleteOrderButton);

        JPanel panel4= new JPanel() ;
        panel4.setBounds(0 , 500 , 450 , 50);
        panel4.add(viewAllOrdersButton);

        JPanel panel5 = new JPanel() ;
        panel5.setBounds(0 , 650 , 450 , 50);
        panel5.add(backButton);

        JPanel allPanels = new JPanel();
        allPanels.add(panelname);
        allPanels.add(panelId);
        allPanels.add(panelTelephone);
        allPanels.add(panelEmail);
        allPanels.add(panelOne);
        allPanels.add(panelTwo);
        allPanels.add(panelThree);
        allPanels.add(panel4);
        allPanels.add(panel5);
        allPanels.setLayout(null);
        this.setContentPane(allPanels);
    }
    public String getIdJT() {
        return idJT.getText();
    }
    public String getClientIdJT() {
        return clientIdJT.getText();
    }
    public String getProductIDJT() {
        return productIdJT.getText();
    }
    public String getQuantityJT() {
        return quantityJT.getText();
    }

    public void addInsertButtonListener(ActionListener a){ addOrderButton.addActionListener( a);}
    public void addEditButtonListener(ActionListener e){ editOrderButton.addActionListener( e);}
    public void addDeleteButtonListener(ActionListener d){ deleteOrderButton.addActionListener( d);}
    public void addViewButtonListener(ActionListener s){ viewAllOrdersButton.addActionListener( s);}
    public void addBackButtonListener (ActionListener b){
        backButton.addActionListener(b);
    }

}
