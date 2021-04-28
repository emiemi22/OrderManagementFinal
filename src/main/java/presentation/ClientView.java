package presentation;

import model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientView extends  JFrame{
    private JTextField idJT = new JTextField();
    private JTextField nameJT = new JTextField();
    private JTextField emailJT = new JTextField();
    private JTextField addressJT = new JTextField();
    private JTextField telephoneJT = new JTextField();

    private JButton addClientButton = new JButton("Add a new client") ;
    private JButton editClientButton = new JButton("Edit Client") ;
    private JButton deleteClientButton = new JButton("Delete Client") ;
    private JButton viewAllClientsButton = new JButton("Display Client Table") ;
    private JButton backButton = new JButton("Back") ;


    public ClientView() {
        this.setTitle("Order Management Clients");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,750);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(245, 255, 255, 111));
        idJT.setPreferredSize(new Dimension(100,30));
        nameJT.setPreferredSize(new Dimension(100,30));
        emailJT.setPreferredSize(new Dimension(100,30));
        telephoneJT.setPreferredSize(new Dimension(100,30));
        addressJT.setPreferredSize(new Dimension(100,30));


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
        panelEmail.add(new JLabel("Email"));
        panelEmail.add(emailJT);

        JPanel panelTelephone = new JPanel();
        panelTelephone.setBounds(0 , 250-50 , 450 , 50);
        panelTelephone.add(new JLabel("Telephone"));
        panelTelephone.add(telephoneJT);

        JPanel panelAddress = new JPanel();
        panelAddress.setBounds(0 , 300-50 , 450 , 50);
        panelAddress.add(new JLabel("Address"));
        panelAddress.add(addressJT);

        JPanel panelOne = new JPanel() ;
        panelOne.setBounds(0 , 350-50 , 450 , 50);
        panelOne.add(addClientButton);

        JPanel panelTwo = new JPanel() ;
        panelTwo.setBounds(0 , 400-50 , 450 , 50);
        panelTwo.add(editClientButton);

        JPanel panelThree = new JPanel() ;
        panelThree.setBounds(0 , 450-50 , 450 , 50);
        panelThree.add(deleteClientButton);

        JPanel panel4= new JPanel() ;
        panel4.setBounds(0 , 500-50 , 450 , 50);
        panel4.add(viewAllClientsButton);

        JPanel panel5 = new JPanel() ;
        panel5.setBounds(0 , 650-50 , 450 , 50);
        panel5.add(backButton);

        JPanel allPanels = new JPanel();
        allPanels.add(panelname);
        allPanels.add(panelAddress);
        allPanels.add(panelId);
        allPanels.add(panelTelephone);
        allPanels.add(panelEmail);
        allPanels.add(panelOne);
        allPanels.add(panelTwo);
        allPanels.add(panelThree);
        allPanels.add(panel4);
        allPanels.add(panel5);
        //allPanels.add(panelThree);
        allPanels.setLayout(null);
        this.setContentPane(allPanels);

    }

    public String getIdJT() {
        return idJT.getText();
    }

    public String getNameJT() {
        return nameJT.getText();
    }

    public String getEmailJT() {
        return emailJT.getText();
    }

    public String getTelephoneJT() {
        return telephoneJT.getText();
    }

    public String getAddressJT() {
        return addressJT.getText();
    }
    public void addInsertButtonListener(ActionListener a){ addClientButton.addActionListener( a);}
    public void addEditButtonListener(ActionListener e){ editClientButton.addActionListener( e);}
    public void addDeleteButtonListener(ActionListener d){ deleteClientButton.addActionListener( d);}
    public void addViewButtonListener(ActionListener s){ viewAllClientsButton.addActionListener( s);}
    public void addBackButtonListener (ActionListener b){
            backButton.addActionListener(b);
        }


}
