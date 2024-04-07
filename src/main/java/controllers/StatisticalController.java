/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.PnlStatistical;

/**
 *
 * @author Admin
 */
public class StatisticalController implements ActionListener {

    private PnlStatistical statistical;

    public StatisticalController(PnlStatistical statistical) {
        this.statistical = statistical;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("Tìm kiếm")) {

        }

    }

}
