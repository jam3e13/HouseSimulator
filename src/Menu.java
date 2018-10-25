import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

        SwingUtilities.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    private Menu() {
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new GridBagLayout());
        newPanel.setBackground(Color.LIGHT_GRAY);
        this.setTitle("MENU");

        JButton buttonRunSim = new JButton("RUN SIMULATION");
        buttonRunSim.setBackground(Color.BLUE);
        JButton buttonConfig = new JButton("CONFIGURE DEVICES");
        buttonConfig.setBackground(Color.BLUE);
        JButton buttonDevice = new JButton("DEVICE VIEW");
        buttonDevice.setBackground(Color.BLUE);


        buttonRunSim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getWeatherType();
                Simulator.main(weatherType);

            }
        });

        buttonConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TabConfig.main();
            }
        });

        buttonDevice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Device Display Not Done");
            }
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

