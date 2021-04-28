package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductView extends  JFrame {
    private JTextField idJT = new JTextField();
    private JTextField nameJT = new JTextField();
    private JTextField priceJT = new JTextField();
    private JTextField quantityJT = new JTextField();


    private JButton addProductButton = new JButton("Add a new Product") ;
    private JButton editProductButton = new JButton("Edit Product") ;
    private JButton deleteProductButton = new JButton("Delete Product") ;
    private JButton viewAllProductsButton = new JButton("Display Product Table") ;
    private JButton backButton = new JButton("Back") ;


    public ProductView() {
        this.setTitle("Order Management Products");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,750);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(245, 255, 255, 111));
        idJT.setPreferredSize(new Dimension(100,30));
        nameJT.setPreferredSize(new Dimension(100,30));
        priceJT.setPreferredSize(new Dimension(100,30));
        quantityJT.setPreferredSize(new Dimension(100,30));

        JPanel panelId = new JPanel() ;
        panelId.setBounds(0 , 100-50 , 450 , 50);
        panelId.add(new JLabel("ID"));
        panelId.add(idJT);

        JPanel panelname = new JPanel() ;
        panelname.setBounds(0 , 150-50 , 450 , 50);
        panelname.add(new JLabel("Name"));
        panelname.add(nameJT);

        JPanel panelEmail = new JPanel();
        panelEmail.setBounds(0 , 200-50 , 450 , 50);
        panelEmail.add(new JLabel("Price"));
        panelEmail.add(priceJT);

        JPanel panelTelephone = new JPanel();
        panelTelephone.setBounds(0 , 250-50 , 450 , 50);
        panelTelephone.add(new JLabel("Quantity"));
        panelTelephone.add(quantityJT);

        JPanel panelOne = new JPanel() ;
        panelOne.setBounds(0 , 350-50 , 450 , 50);
        panelOne.add(addProductButton);

        JPanel panelTwo = new JPanel() ;
        panelTwo.setBounds(0 , 400-50 , 450 , 50);
        panelTwo.add(editProductButton);

        JPanel panelThree = new JPanel() ;
        panelThree.setBounds(0 , 450-50 , 450 , 50);
        panelThree.add(deleteProductButton);

        JPanel panel4= new JPanel() ;
        panel4.setBounds(0 , 500-50 , 450 , 50);
        panel4.add(viewAllProductsButton);

        JPanel panel5 = new JPanel() ;
        panel5.setBounds(0 , 650-50 , 450 , 50);
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
    public String getNameJT() {
        return nameJT.getText();
    }
    public String getPriceJT() {
        return priceJT.getText();
    }
    public String getQuantityJT() {
        return quantityJT.getText();
    }

    public void addInsertButtonListener(ActionListener a){ addProductButton.addActionListener( a);}
    public void addEditButtonListener(ActionListener e){ editProductButton.addActionListener( e);}
    public void addDeleteButtonListener(ActionListener d){ deleteProductButton.addActionListener( d);}
    public void addViewButtonListener(ActionListener s){ viewAllProductsButton.addActionListener( s);}
    public void addBackButtonListener (ActionListener b){
        backButton.addActionListener(b);
    }
}
