/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;

/**
 *
 * @author ThuanBui
 */
public class SetStyleComponentUtil <T> extends javax.swing.JFrame{
    public void setFrameStyle(T component, JSplitPane spltPane) {
   
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;

        setBounds((width - 1024) / 2, (height - 768) / 2, 1024, 768);

        setIconImage((new ImageIcon("wire_transfer.png")).getImage());

        setFont(new Font("Verdana", Font.BOLD, 10));
        spltPane.setRightComponent((Component) component);
    }
}
