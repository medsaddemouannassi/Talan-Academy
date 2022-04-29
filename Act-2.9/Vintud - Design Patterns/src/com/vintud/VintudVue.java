package com.vintud;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;

public class VintudVue extends JFrame {
    private JPanel vintudPanel;
    private JButton displayAllAnnouncementsButton;
    private JButton searchAnnouncementButton;
    private JButton filterAnnouncementsByPriceButton;
    private JButton filterAnnouncementsByLocalisationButton;
    private JButton displayViewNumberButton;
    private JTextField minPriceTextField;
    private JTextField titleTextField;
    private JTextField categoryTextField;
    private JTextField maxPriceTextField;
    private JTextField priceTextField;
    private JTextField localisationTextField;
    private JTextField announcementIDTextField;
    private JTextField userIDTextField;
    private JButton displayPostedAnnouncementsButton;
    private JTextField userIDTextField1;
    private JButton displayFavoriteAnnouncementsButton;
    private JTable table1;

    public VintudVue(AnnouncementController announcementController) {
        displayAllAnnouncementsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(DbUtils.resultSetToTableModel(announcementController.getAnnouncements()));
            }
        });
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        VintudVue vintudVue = new VintudVue(new AnnouncementController());
        vintudVue.setContentPane(vintudVue.vintudPanel);
        vintudVue.setTitle("Vintud");
        vintudVue.setSize(700, 500);
        vintudVue.setVisible(true);
        vintudVue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


}
