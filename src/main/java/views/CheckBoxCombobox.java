/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.accessibility.Accessible;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.ComboPopup;

/**
 *
 * @author Admin
 * @param <E>
 */
class CheckableItem {

    private int id;
    private String text;

    private boolean selected;

    protected CheckableItem(int id, String text, boolean selected) {
        this.id = id;
        this.text = text;
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

public class CheckBoxCombobox<E extends CheckableItem> extends JComboBox<E> {

    protected boolean keepOpen;
    private final JPanel panel = new JPanel(new BorderLayout());

    //  protected CheckedComboBox() {
    //    super();
    //  }
    protected CheckBoxCombobox(ComboBoxModel<E> model) {
        super(model);
    }

    // protected CheckedComboBox(E[] m) {
    //   super(m);
    // }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 20);
    }

    @Override
    public void updateUI() {
        setRenderer(null);
        super.updateUI();

        Accessible a = getAccessibleContext().getAccessibleChild(0);
        if (a instanceof ComboPopup) {
            ((ComboPopup) a).getList().addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    JList<?> list = (JList<?>) e.getComponent();
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        keepOpen = true;
                        updateItem(list.locationToIndex(e.getPoint()));
                    }
                }
            });
        }

        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        JCheckBox check = new JCheckBox();
        check.setOpaque(false);
        setRenderer((list, value, index, isSelected, cellHasFocus) -> {
            panel.removeAll();
            Component c = renderer.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            if (index < 0) {
                String txt = getCheckedItemString(list.getModel());
                JLabel l = (JLabel) c;
                l.setText(txt.isEmpty() ? " " : txt);
                l.setOpaque(false);
                l.setForeground(list.getForeground());
                panel.setOpaque(false);
            } else {
                check.setSelected(value.isSelected());
                panel.add(check, BorderLayout.WEST);
                panel.setOpaque(true);
                panel.setBackground(c.getBackground());
            }
            panel.add(c);
            return panel;
        });
        initActionMap();
    }

    protected void initActionMap() {
        KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0);
        getInputMap(WHEN_FOCUSED).put(ks, "checkbox-select");
        getActionMap().put("checkbox-select", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accessible a = getAccessibleContext().getAccessibleChild(0);
                if (a instanceof ComboPopup) {
                    updateItem(((ComboPopup) a).getList().getSelectedIndex());
                }
            }
        });
    }

    protected void updateItem(int index) {
        if (isPopupVisible() && index >= 0) {
            E item = getItemAt(index);
            item.setSelected(!item.isSelected());
            // item.selected ^= true;
            // ComboBoxModel m = getModel();
            // if (m instanceof CheckableComboBoxModel) {
            //   ((CheckableComboBoxModel) m).fireContentsChanged(index);
            // }
            // removeItemAt(index);
            // insertItemAt(item, index);
            setSelectedIndex(-1);
            setSelectedItem(item);
        }
    }

    @Override
    public void setPopupVisible(boolean v) {
        if (keepOpen) {
            keepOpen = false;
        } else {
            super.setPopupVisible(v);
        }
    }

    protected static <E extends CheckableItem> String getCheckedItemString(ListModel<E> model) {
        return IntStream.range(0, model.getSize())
                .mapToObj(model::getElementAt)
                .filter(CheckableItem::isSelected)
                .map(Objects::toString)
                .sorted()
                .collect(Collectors.joining(", "));
    }
}

class WindowsCheckedComboBox<E extends CheckableItem> extends CheckBoxCombobox<E> {

    private transient ActionListener listener;

    protected WindowsCheckedComboBox(ComboBoxModel<E> model) {
        super(model);
    }

    @Override
    public void updateUI() {
        setRenderer(null);
        removeActionListener(listener);
        super.updateUI();
        listener = e -> {
            if ((e.getModifiers() & AWTEvent.MOUSE_EVENT_MASK) != 0) {
                keepOpen = true;
                updateItem(getSelectedIndex());
            }
        };
        addActionListener(listener);

        JLabel label = new JLabel(" ");
        JCheckBox check = new JCheckBox(" ");
        setRenderer((list, value, index, isSelected, cellHasFocus) -> {
            if (index < 0) {
                String txt = getCheckedItemString(list.getModel());
                label.setText(txt.isEmpty() ? " " : txt);
                return label;
            } else {
                check.setText(Objects.toString(value, ""));
                check.setSelected(value.isSelected());
                if (isSelected) {
                    check.setBackground(list.getSelectionBackground());
                    check.setForeground(list.getSelectionForeground());
                } else {
                    check.setBackground(list.getBackground());
                    check.setForeground(list.getForeground());
                }
                return check;
            }
        });
        initActionMap();
    }
}
