import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.Color;
import java.io.FileNotFoundException;


public class Menu extends JFrame {

    //Gets morning weather from method
    public static String weatherType = getWeatherType();

    public static void main(String args[]) {
        //Welcome message
        System.out.println("Welcome to the Autonomous Devices Simulator");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
    }


    private Menu() {
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new GridBagLayout());
        newPanel.setBackground(Color.LIGHT_GRAY);
        newPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        newPanel.setPreferredSize(new Dimension(800, 200));
        this.setTitle("MENU");

        JButton buttonRunSim = new JButton("RUN SIMULATION");
        buttonRunSim.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        buttonRunSim.setPreferredSize(new Dimension(160, 80));
        buttonRunSim.setBackground(Color.gray);

        JButton buttonConfig = new JButton("CONFIGURE DEVICES");
        buttonConfig.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        buttonConfig.setPreferredSize(new Dimension(160, 80));
        buttonConfig.setBackground(Color.gray);

        JButton buttonDevice = new JButton("VIEW DEVICES");
        buttonDevice.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        buttonDevice.setPreferredSize(new Dimension(160, 80));
        buttonDevice.setBackground(Color.gray);

        JButton buttonClean = new JButton("FILE CLEANER");
        buttonClean.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        buttonClean.setPreferredSize(new Dimension(160, 80));
        buttonClean.setBackground(Color.gray);


        buttonRunSim.addActionListener(e -> {
            Simulator.main();
            Runnable runnable = Simulator::runSimulator;
            Thread t = new Thread(runnable);
            t.start();

        });

        buttonConfig.addActionListener(e -> TabConfig.main());

        buttonDevice.addActionListener(e -> {
            House.main();
            Runnable runnable = House::viewHouseDevices;
            Thread t = new Thread(runnable);
            t.start();
        });

        buttonClean.addActionListener(e -> {
            Runnable runnable = () -> {
                try {
                    Clean.cleanUserInputs();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            };
            Thread t = new Thread(runnable);
            t.start();
        });

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        newPanel.add(buttonRunSim, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        newPanel.add(buttonConfig, constraints);

        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        newPanel.add(buttonDevice, constraints);

        constraints.gridx = 6;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        newPanel.add(buttonClean, constraints);

        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));

        // add the panel to this frame
        add(newPanel);

        pack();
        setLocationRelativeTo(null);
    }

    static String getWeatherType() {
        int weatherValue;
        String weatherType;
        weatherValue = Weather.getWeather();

        if (weatherValue >= 1 && weatherValue <= 5) {
            weatherType = "SUNNY";
        } else if (weatherValue >= 6 && weatherValue <= 8) {
            weatherType = "CLOUDY";
        } else {
            weatherType = "RAINY";
        }

        System.out.println('\n' + "Current weather: " + weatherType);

        return weatherType;
    }
}

