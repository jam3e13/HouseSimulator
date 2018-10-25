import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class SimGUI extends javax.swing.JFrame {

    SimGUI() {
        initComponents();
    }


    public void updateDisplays() {
        final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("hh:mm a");

        //

        //timeStatus.setText(Simulator.time.format(TIME_FORMAT));
        //tempStatusDisplay.setText(String.format("%.1f°C", Simulator.temperature));
    }

    private void initComponents() {

        elementDisplay = new javax.swing.JPanel();

        time1 = new javax.swing.JPanel();
        timeName = new javax.swing.JPanel();
        timeStatus = new javax.swing.JPanel();

        temp = new javax.swing.JPanel();
        tempName = new javax.swing.JPanel();
        tempStatus = new javax.swing.JPanel();

        light = new javax.swing.JPanel();
        lightName = new javax.swing.JPanel();
        lightStatus = new javax.swing.JPanel();

        water = new javax.swing.JPanel();
        waterName = new javax.swing.JPanel();
        waterStatus = new javax.swing.JPanel();

        energy = new javax.swing.JPanel();
        energyName = new javax.swing.JPanel();
        energyStatus = new javax.swing.JPanel();

        behaviourDisplay = new javax.swing.JPanel();
        roomDisplay = new javax.swing.JPanel();

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BorderLayout());
        newPanel.setBackground(Color.LIGHT_GRAY);
        newPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        newPanel.setPreferredSize(new Dimension(600, 600));
        this.setTitle("Simulation");

        JPanel content = new JPanel(new GridBagLayout());
        content.setOpaque(false);

        //Top panel
        elementDisplay.setPreferredSize(new Dimension(500, 0));
        elementDisplay.setBackground(Color.lightGray);

        //Top panel - Time
        time1.setPreferredSize(new Dimension(90, 80));
        time1.setBackground(Color.lightGray);

        timeName.setPreferredSize(new Dimension(80, 35));
        timeName.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        timeName.setBackground(Color.white);

        timeStatus.setPreferredSize(new Dimension(80, 35));
        timeStatus.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        timeStatus.setBackground(Color.white);

        time1.add(timeName);
        time1.add(timeStatus);

        //Top panel - Temp
        temp.setPreferredSize(new Dimension(90, 80));
        temp.setBackground(Color.lightGray);

        tempName.setPreferredSize(new Dimension(80, 35));
        tempName.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        tempName.setBackground(Color.white);

        tempStatus.setPreferredSize(new Dimension(80, 35));
        tempStatus.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        tempStatus.setBackground(Color.white);

        temp.add(tempName);
        temp.add(tempStatus);

        //Top panel - Light
        light.setPreferredSize(new Dimension(90, 80));
        light.setBackground(Color.lightGray);

        lightName.setPreferredSize(new Dimension(80, 35));
        lightName.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        lightName.setBackground(Color.white);

        lightStatus.setPreferredSize(new Dimension(80, 35));
        lightStatus.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        lightStatus.setBackground(Color.white);

        light.add(lightName);
        light.add(lightStatus);

        //Top panel - Water
        water.setPreferredSize(new Dimension(90, 80));
        water.setBackground(Color.lightGray);

        waterName.setPreferredSize(new Dimension(80, 35));
        waterName.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        waterName.setBackground(Color.white);

        waterStatus.setPreferredSize(new Dimension(80, 35));
        waterStatus.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        waterStatus.setBackground(Color.white);

        water.add(waterName);
        water.add(waterStatus);

        //Top panel - Energy
        energy.setPreferredSize(new Dimension(90, 80));
        energy.setBackground(Color.lightGray);

        energyName.setPreferredSize(new Dimension(80, 35));
        energyName.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        energyName.setBackground(Color.white);

        energyStatus.setPreferredSize(new Dimension(80, 35));
        energyStatus.setBorder(new BasicBorders.ToggleButtonBorder(Color.LIGHT_GRAY, Color.gray, Color.DARK_GRAY, Color.gray));
        energyStatus.setBackground(Color.white);

        energy.add(energyName);
        energy.add(energyStatus);

        //TODO make center labels for device status updates
        //Center panel
        behaviourDisplay.setPreferredSize(new Dimension(100, 100));
        behaviourDisplay.setBackground(Color.lightGray);

        //TODO make bottom labels for rooms and the devices on in each room
        //Bottom panel
        roomDisplay.setPreferredSize(new Dimension(100, 100));
        roomDisplay.setBackground(Color.lightGray);

        //Border
        JPanel top = new JPanel(new GridLayout(0, 1));
        top.setBorder(new EmptyBorder(10, 10, 5, 10));
        top.add(elementDisplay);

        JPanel center = new JPanel(new GridLayout(0, 1));
        center.setBorder(new EmptyBorder(5, 10, 5, 10));
        center.add(behaviourDisplay);

        JPanel bottom = new JPanel(new GridLayout(0, 1));
        bottom.setBorder(new EmptyBorder(5, 10, 10, 10));
        bottom.add(roomDisplay);
        //end border config

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weighty = 0.5f;
        gbc.weightx = 1f;
        gbc.fill = GridBagConstraints.BOTH;

        content.add(top, gbc);
        content.add(center, gbc);
        content.add(bottom, gbc);

        newPanel.add(content);

        //Add to Top panel
        elementDisplay.add(time1);
        elementDisplay.add(temp);
        elementDisplay.add(light);
        elementDisplay.add(water);
        elementDisplay.add(energy);

        //top panel labels
        //Time name
        timeName.setFont(new Font("Serif", Font.BOLD, 28));
        timeName.add(new JLabel("Time"), BorderLayout.NORTH);

        //add pm instance for time
        timeStatus.add(new JLabel(String.valueOf(Simulator.time) + " am"), BorderLayout.NORTH);


        tempName.add(new JLabel("Temp"), BorderLayout.NORTH);
        tempStatus.add(new JLabel(String.valueOf(Simulator.temperature) + " °"), BorderLayout.SOUTH);


        lightName.add(new JLabel("Light"), BorderLayout.NORTH);
        lightName.setFont(new Font("Sans Serif", Font.BOLD, 12));
        lightStatus.add(new JLabel("58%"), BorderLayout.SOUTH);

        waterName.add(new JLabel("Water"), BorderLayout.NORTH);
        waterName.setFont(new Font("Sans Serif", Font.BOLD, 12));
        waterStatus.add(new JLabel("68L"), BorderLayout.SOUTH);

        energyName.add(new JLabel("Energy"), BorderLayout.NORTH);
        energyName.setFont(new Font("Sans Serif", Font.BOLD, 12));
        energyStatus.add(new JLabel("1300kw"), BorderLayout.SOUTH);

        //center panel labels
        behaviourDisplay.add(new JLabel("Status"), BorderLayout.NORTH);

        //bottom panel labels
        roomDisplay.add(new JLabel("Rooms"), BorderLayout.NORTH);

        add(newPanel);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimGUI().setVisible(true);
            }
        });
    }


    private javax.swing.JPanel elementDisplay;
    private javax.swing.JPanel time1;
    private javax.swing.JPanel timeName;
    private javax.swing.JPanel timeStatus;
    private javax.swing.JPanel temp;
    private javax.swing.JPanel tempName;
    private javax.swing.JPanel tempStatus;
    private javax.swing.JPanel light;
    private javax.swing.JPanel lightName;
    private javax.swing.JPanel lightStatus;
    private javax.swing.JPanel water;
    private javax.swing.JPanel waterName;
    private javax.swing.JPanel waterStatus;
    private javax.swing.JPanel energy;
    private javax.swing.JPanel energyName;
    private javax.swing.JPanel energyStatus;
    private javax.swing.JPanel behaviourDisplay;
    private javax.swing.JPanel roomDisplay;


}
