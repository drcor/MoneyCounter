package com.drcor.moneycounter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class MoneyCounter extends JFrame{
    private JPanel panel;
    private JSpinner cent1Spinner;
    private JSpinner cent2Spinner;
    private JSpinner cent5Spinner;
    private JSpinner cent10Spinner;
    private JSpinner cent20Spinner;
    private JSpinner cent50Spinner;
    private JSpinner euro1Spinner;
    private JSpinner euro2Spinner;
    private JSpinner euro5Spinner;
    private JSpinner euro10Spinner;
    private JSpinner euro20Spinner;
    private JSpinner euro50Spinner;
    private JSpinner euro100Spinner;
    private JSpinner euro200Spinner;
    private JFormattedTextField totalFormattedTextField;
    private final HashMap<Float, Integer> countTable = new HashMap<Float, Integer>();

    public MoneyCounter() {
        setLayout(new GridLayout());

        // Insert Money references in HashMap
        countTable.put(0.01f, 0);
        countTable.put(0.02f, 0);
        countTable.put(0.05f, 0);
        countTable.put(0.1f, 0);
        countTable.put(0.2f, 0);
        countTable.put(0.5f, 0);
        countTable.put(1.0f, 0);
        countTable.put(2.0f, 0);
        countTable.put(5.0f, 0);
        countTable.put(10.0f, 0);
        countTable.put(20.0f, 0);
        countTable.put(50.0f, 0);
        countTable.put(100.0f, 0);
        countTable.put(200.0f, 0);

        ChangeListener listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner spinner = ( JSpinner ) e.getSource();
                SpinnerModel spinnerModel = spinner.getModel();
                String spinnerName = spinner.getName();

                switch (spinnerName) {
                    case "cent1" -> countTable.put(0.01f, (Integer) spinnerModel.getValue());
                    case "cent2" -> countTable.put(0.02f, (Integer) spinnerModel.getValue());
                    case "cent5" -> countTable.put(0.05f, (Integer) spinnerModel.getValue());
                    case "cent10" -> countTable.put(0.1f, (Integer) spinnerModel.getValue());
                    case "cent20" -> countTable.put(0.2f, (Integer) spinnerModel.getValue());
                    case "cent50" -> countTable.put(0.5f, (Integer) spinnerModel.getValue());
                    case "euro1" -> countTable.put(1.0f, (Integer) spinnerModel.getValue());
                    case "euro2" -> countTable.put(2.0f, (Integer) spinnerModel.getValue());
                    case "euro5" -> countTable.put(5.0f, (Integer) spinnerModel.getValue());
                    case "euro10" -> countTable.put(10.0f, (Integer) spinnerModel.getValue());
                    case "euro20" -> countTable.put(20.0f, (Integer) spinnerModel.getValue());
                    case "euro50" -> countTable.put(50.0f, (Integer) spinnerModel.getValue());
                    case "euro100" -> countTable.put(100.0f, (Integer) spinnerModel.getValue());
                    case "euro200" -> countTable.put(200.0f, (Integer) spinnerModel.getValue());
                    default -> throw new IllegalStateException("Unexpected value: " + spinnerName);
                }

                // Update total value
                totalFormattedTextField.setValue(calculateTotal());
            }
        };

        // Add text change listeners to spinners
        cent1Spinner.addChangeListener(listener);
        euro5Spinner.addChangeListener(listener);
        cent2Spinner.addChangeListener(listener);
        euro10Spinner.addChangeListener(listener);
        cent5Spinner.addChangeListener(listener);
        euro20Spinner.addChangeListener(listener);
        cent10Spinner.addChangeListener(listener);
        euro50Spinner.addChangeListener(listener);
        cent20Spinner.addChangeListener(listener);
        euro100Spinner.addChangeListener(listener);
        cent50Spinner.addChangeListener(listener);
        euro200Spinner.addChangeListener(listener);
        euro1Spinner.addChangeListener(listener);
        euro2Spinner.addChangeListener(listener);

        createUIComponents();
        validate();
    }

    private void createUIComponents() {
        // Set spinner for numeric input
        cent1Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        cent2Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        cent5Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        cent10Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        cent20Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        cent50Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        euro1Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));

        euro2Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        euro5Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        euro10Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        euro20Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        euro50Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        euro100Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
        euro200Spinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
    }

    private float calculateTotal() {
        // Calculate total sum of coins and notes
        float total = 0f;
        for (Map.Entry<Float, Integer> entry: countTable.entrySet()) {
            total += entry.getKey() * entry.getValue();
        }

        return total;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Money Counter");
        frame.setContentPane(new MoneyCounter().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
   }
}
