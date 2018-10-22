import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JOptionPane;

public class TabConfig extends JFrame {
    final static String LIVINGROOMPANEL = "LIVING ROOM";
    final static String MAINBEDROOMPANEL = "MAIN BEDROOM";
    final static String SECONDBEDROOMPANEL = "SECOND BEDROOM";
    final static String KITCHENPANEL = "KITCHEN";
    final static String GARAGEPANEL = "GARAGE";
    final static String GARDENPANEL = "GARDEN";
    static String first_name = "", full_name, data, x1, x2, x3, x4, x5, x6, updatedList, updatedList1, updatedList2, updatedList3, updatedList4, updatedList5, livingRoomLightMode, livingRoomMotionSensorMode;
    static int livingRoomTvInput, livingRoomAirConInput, livingRoomLightsInput, livingRoomMotionSensorInput, livingRoomFanInput;
    static String[] displayLine1, displayLine2, values, displayLine3, displayLine4, displayLine5, displayLine6;

    private final static int extraWindowWidth = 100;

    private void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();

        //Create the "cards".
        JPanel card1 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };

        //LIVING ROOM
        JButton livingRoomMotionSensor = new JButton("Motion Sensors");
        livingRoomMotionSensor.setBackground(Color.lightGray);
        card1.add(livingRoomMotionSensor);
        livingRoomMotionSensor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/motionSensorConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                            String continueSetUp;
                            continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                            continueSetUp = continueSetUp.toUpperCase();
                            if (continueSetUp.equals("Y")) {
                                String livingRoomMSensorInputString;
                                livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                                livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);
                                while (livingRoomMotionSensorInput > 2) {
                                    livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                                    livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);
                                }
                                while (livingRoomMotionSensorInput <= 0) {
                                    livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                                    livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);
                                }

                                if (livingRoomMotionSensorInput == 1) {
                                    livingRoomMotionSensorMode = "Comfort Mode";
                                } else if (livingRoomMotionSensorInput == 2) {
                                    livingRoomMotionSensorMode = "Economy Mode";
                                }
                            }

                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
                            String livingRoomMSensorInputString;
                            livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                            livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);

                            while (livingRoomMotionSensorInput > 2) {
                                livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                                livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);
                            }

                            while (livingRoomMotionSensorInput <= 0) {
                                livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                                livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);
                            }

                            if (livingRoomMotionSensorInput == 1) {
                                livingRoomMotionSensorMode = "Comfort Mode";
                            } else if (livingRoomMotionSensorInput == 2) {
                                livingRoomMotionSensorMode = "Economy Mode";
                            }
                        }
                        if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                            displayLine2 = data.split(", ");
                        } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");
                        }
                        if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                            displayLine3 = data.split(", ");
                        } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                            displayLine3 = data.split(", ");
                        }
                        if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                            displayLine4 = data.split(", ");
                        } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                            displayLine4 = data.split(", ");
                        }
                        if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                            displayLine5 = data.split(", ");
                        } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                            displayLine5 = data.split(", ");
                        }
                        if (values[0].equals("GARDEN") && values[2].equals("ON")) {
                            displayLine6 = data.split(", ");
                        } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                            displayLine6 = data.split(", ");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "LIVING ROOM";
                        saveMotionSensor(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton livingRoomLights = new JButton("Lights");
        livingRoomLights.setBackground(Color.lightGray);
        card1.add(livingRoomLights);
        livingRoomLights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (livingRoomLightsInput == 0) {
                    String livingRoomLightsInputString;
                    livingRoomLightsInputString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below.\n1) Economy Mode - Lights only turn on after 6pm and sunlight under 10%.\n2) Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.\n3) Entertainment Mode - Lights always turn on.");
                    livingRoomLightsInput = Integer.parseInt(livingRoomLightsInputString);
                    while (livingRoomLightsInput > 3) {
                        livingRoomLightsInputString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below.\n1) Economy Mode - Lights only turn on after 6pm and sunlight under 10%.\n2) Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.\n3) Entertainment Mode - Lights always turn on.");
                        livingRoomLightsInput = Integer.parseInt(livingRoomLightsInputString);
                    }
                    while (livingRoomLightsInput <= 0) {
                        livingRoomLightsInputString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below.\n1) Economy Mode - Lights only turn on after 6pm and sunlight under 10%.\n2) Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.\n3) Entertainment Mode - Lights always turn on.");
                        livingRoomLightsInput = Integer.parseInt(livingRoomLightsInputString);
                    }

                    if (livingRoomLightsInput == 1) {
                        livingRoomLightMode = "Economy Mode";
                    } else if (livingRoomLightsInput == 2) {
                        livingRoomLightMode = "Neutral Mode";
                    } else if (livingRoomLightsInput == 3) {
                        livingRoomLightMode = "Entertainment Mode";
                    }
                    JOptionPane.showMessageDialog(null, "The Living Room Lights have been set to: " + livingRoomLightMode);
                } else {
                    String continueSetUp;
                    continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                    continueSetUp = continueSetUp.toUpperCase();
                    if (continueSetUp.equals("Y")) {
                        String livingRoomLightsInputString;
                        livingRoomLightsInputString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below.\n1) Economy Mode - Lights only turn on after 6pm and sunlight under 10%.\n2) Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.\n3) Entertainment Mode - Lights always turn on.");
                        livingRoomLightsInput = Integer.parseInt(livingRoomLightsInputString);
                        while (livingRoomLightsInput > 3) {
                            livingRoomLightsInputString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below.\n1) Economy Mode - Lights only turn on after 6pm and sunlight under 10%.\n2) Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.\n3) Entertainment Mode - Lights always turn on.");
                            livingRoomLightsInput = Integer.parseInt(livingRoomLightsInputString);
                        }
                        while (livingRoomLightsInput <= 0) {
                            livingRoomLightsInputString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below.\n1) Economy Mode - Lights only turn on after 6pm and sunlight under 10%.\n2) Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.\n3) Entertainment Mode - Lights always turn on.");
                            livingRoomLightsInput = Integer.parseInt(livingRoomLightsInputString);
                        }

                        if (livingRoomLightsInput == 1) {
                            livingRoomLightMode = "Economy Mode";
                        } else if (livingRoomLightsInput == 2) {
                            livingRoomLightMode = "Neutral Mode";
                        } else if (livingRoomLightsInput == 3) {
                            livingRoomLightMode = "Entertainment Mode";
                        }
                        JOptionPane.showMessageDialog(null, "The Living Room Lights have been set to: " + livingRoomLightMode);
                    }
                }
            }
        });

        JButton livingRoomAirCon = new JButton("Air Conditioner");
        livingRoomAirCon.setBackground(Color.lightGray);
        card1.add(livingRoomAirCon);
        livingRoomAirCon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (livingRoomAirConInput == (0)) {
                    String livingRoomAirConInputString;
                    livingRoomAirConInputString = JOptionPane.showInputDialog("Set Temperature for Living Room: 16° - 26°");
                    livingRoomAirConInput = Integer.parseInt(livingRoomAirConInputString);
                    while (livingRoomAirConInput > 26) {
                        livingRoomAirConInputString = JOptionPane.showInputDialog("Set Temperature for Living Room: 16° - 26°");
                        livingRoomAirConInput = Integer.parseInt(livingRoomAirConInputString);
                    }
                    while (livingRoomAirConInput < 16) {
                        livingRoomAirConInputString = JOptionPane.showInputDialog("Set Temperature for Living Room: 16° - 26°");
                        livingRoomAirConInput = Integer.parseInt(livingRoomAirConInputString);
                    }

                    String fullAcDisplay;
                    fullAcDisplay = "The Living Room Air Conditioner has been set to: " + livingRoomAirConInputString + "°";
                    JOptionPane.showMessageDialog(null, fullAcDisplay);
                } else {
                    String continueSetUp;
                    continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                    continueSetUp = continueSetUp.toUpperCase();
                    if (continueSetUp.equals("Y")) {
                        String livingRoomAirConInputString;
                        livingRoomAirConInputString = JOptionPane.showInputDialog("Set Temperature for Living Room: 16° - 26°");
                        livingRoomAirConInput = Integer.parseInt(livingRoomAirConInputString);
                        while (livingRoomAirConInput > 26) {
                            livingRoomAirConInputString = JOptionPane.showInputDialog("Set Temperature for Living Room: 16° - 26°");
                            livingRoomAirConInput = Integer.parseInt(livingRoomAirConInputString);
                        }
                        while (livingRoomAirConInput < 16) {
                            livingRoomAirConInputString = JOptionPane.showInputDialog("Set Temperature for Living Room: 16° - 26°");
                            livingRoomAirConInput = Integer.parseInt(livingRoomAirConInputString);
                        }

                        String fullAcDisplay;
                        fullAcDisplay = "The Living Room Air Conditioner has been set to: " + livingRoomAirConInputString + "°";
                        JOptionPane.showMessageDialog(null, fullAcDisplay);
                    }
                }
            }
        });

        JButton livingRoomFan = new JButton("Ceiling Fan");
        livingRoomFan.setBackground(Color.lightGray);
        card1.add(livingRoomFan);
        livingRoomFan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (livingRoomFanInput == (0)) {
                    String livingRoomFanInputString;
                    livingRoomFanInputString = JOptionPane.showInputDialog("Set Temperature for Living Room Fan: 22° - 30°");
                    livingRoomFanInput = Integer.parseInt(livingRoomFanInputString);
                    while (livingRoomFanInput > 30) {
                        livingRoomFanInputString = JOptionPane.showInputDialog("Set Temperature for Living Room Fan: 22° - 30°");
                        livingRoomFanInput = Integer.parseInt(livingRoomFanInputString);
                    }
                    while (livingRoomFanInput < 22) {
                        livingRoomFanInputString = JOptionPane.showInputDialog("Set Temperature for Living Room Fan: 22° - 30°");
                        livingRoomFanInput = Integer.parseInt(livingRoomFanInputString);
                    }

                    JOptionPane.showMessageDialog(null, "The Living Room Ceiling Fan has been set to: " + livingRoomFanInput + "°");
                } else {
                    String continueSetUp;
                    continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                    continueSetUp = continueSetUp.toUpperCase();
                    if (continueSetUp.equals("Y")) {
                        String livingRoomFanInputString;
                        livingRoomFanInputString = JOptionPane.showInputDialog("Set Temperature for Living Room Fan: 22° - 30°");
                        livingRoomFanInput = Integer.parseInt(livingRoomFanInputString);
                        while (livingRoomFanInput > 30) {
                            livingRoomFanInputString = JOptionPane.showInputDialog("Set Temperature for Living Room Fan: 22° - 30°");
                            livingRoomFanInput = Integer.parseInt(livingRoomFanInputString);
                        }
                        while (livingRoomFanInput < 22) {
                            livingRoomFanInputString = JOptionPane.showInputDialog("Set Temperature for Living Room Fan: 22° - 30°");
                            livingRoomFanInput = Integer.parseInt(livingRoomFanInputString);
                        }

                        JOptionPane.showMessageDialog(null, "The Living Room Ceiling Fan has been set to: " + livingRoomFanInput + "°");
                    }
                }
            }
        });
        JButton livingRoomTv = new JButton("Tv");
        livingRoomTv.setBackground(Color.lightGray);
        card1.add(livingRoomTv);
        livingRoomTv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (livingRoomTvInput == (0)) {
                    String livingRoomFanInputString;
                    livingRoomFanInputString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                    livingRoomTvInput = Integer.parseInt(livingRoomFanInputString);


                    while (livingRoomTvInput > 30) {
                        livingRoomFanInputString = JOptionPane.showInputDialog("Set Temperature for Living Room Fan: 22° - 30°");
                        livingRoomTvInput = Integer.parseInt(livingRoomFanInputString);
                    }
                    while (livingRoomTvInput < 22) {
                        livingRoomFanInputString = JOptionPane.showInputDialog("Set Temperature for Living Room Fan: 22° - 30°");
                        livingRoomTvInput = Integer.parseInt(livingRoomFanInputString);
                    }

                    JOptionPane.showMessageDialog(null, "The Living Room Ceiling Fan has been set to: " + livingRoomTvInput + "°");
                } else {
                    String continueSetUp;
                    continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                    continueSetUp = continueSetUp.toUpperCase();
                    if (continueSetUp.equals("Y")) {

                    }
                }
            }
        });

        //MAIN BEDROOM
        JPanel card2 = new JPanel();
        JButton mainBedroomMotionSensor = new JButton("Motion Sensors");
        mainBedroomMotionSensor.setBackground(Color.lightGray);
        card2.add(mainBedroomMotionSensor);
        mainBedroomMotionSensor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/motionSensorConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                            displayLine2 = data.split(", ");
                            String continueSetUp;
                            continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                            continueSetUp = continueSetUp.toUpperCase();
                            if (continueSetUp.equals("Y")) {
                                String livingRoomMSensorInputString;
                                livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                                livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);
                                while (livingRoomMotionSensorInput > 2) {
                                    livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                                    livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);
                                }
                                while (livingRoomMotionSensorInput <= 0) {
                                    livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                                    livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);
                                }

                                if (livingRoomMotionSensorInput == 1) {
                                    livingRoomMotionSensorMode = "Comfort Mode";
                                } else if (livingRoomMotionSensorInput == 2) {
                                    livingRoomMotionSensorMode = "Economy Mode";
                                }
                            }

                        } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");
                            String livingRoomMSensorInputString;
                            livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                            livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);

                            while (livingRoomMotionSensorInput > 2) {
                                livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                                livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);
                            }

                            while (livingRoomMotionSensorInput <= 0) {
                                livingRoomMSensorInputString = JOptionPane.showInputDialog("Enter either; 1 OR 2 below.\n1) Comfort Mode - Turns on other fixtures/appliances when person enters room.\n2) Economy Mode - Set Limits to certain fixture/appliance control.");
                                livingRoomMotionSensorInput = Integer.parseInt(livingRoomMSensorInputString);
                            }

                            if (livingRoomMotionSensorInput == 1) {
                                livingRoomMotionSensorMode = "Comfort Mode";
                            } else if (livingRoomMotionSensorInput == 2) {
                                livingRoomMotionSensorMode = "Economy Mode";
                            }
                        }
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
                        }
                        if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                            displayLine3 = data.split(", ");
                        } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                            displayLine3 = data.split(", ");
                        }
                        if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                            displayLine4 = data.split(", ");
                        } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                            displayLine4 = data.split(", ");
                        }
                        if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                            displayLine5 = data.split(", ");
                        } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                            displayLine5 = data.split(", ");
                        }
                        if (values[0].equals("GARDEN") && values[2].equals("ON")) {
                            displayLine6 = data.split(", ");
                        } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                            displayLine6 = data.split(", ");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "MAIN BEDROOM";
                        saveMotionSensor(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton mainBedroomLights = new JButton("Lights");
        mainBedroomLights.setBackground(Color.lightGray);
        card2.add(mainBedroomLights);

        JButton mainBedroomAirCon = new JButton("Air Conditioner");
        mainBedroomAirCon.setBackground(Color.lightGray);
        card2.add(mainBedroomAirCon);

        JButton mainBedroomFan = new JButton("Ceiling Fan");
        mainBedroomFan.setBackground(Color.lightGray);
        card2.add(mainBedroomFan);

        JButton mainBedroomTv = new JButton("Tv");
        mainBedroomTv.setBackground(Color.lightGray);
        card2.add(mainBedroomTv);

        JButton mainBedroomAlarm = new JButton("Alarm Clock");
        mainBedroomAlarm.setBackground(Color.lightGray);
        card2.add(mainBedroomAlarm);

        //SECOND BEDROOM
        JPanel card3 = new JPanel();

        JButton secondBedroomMotionSensor = new JButton("Motion Sensors");
        secondBedroomMotionSensor.setBackground(Color.lightGray);
        card3.add(secondBedroomMotionSensor);

        JButton secondBedroomLights = new JButton("Lights");
        secondBedroomLights.setBackground(Color.lightGray);
        card3.add(secondBedroomLights);


        JButton secondBedroomFan = new JButton("Ceiling Fan");
        secondBedroomFan.setBackground(Color.lightGray);
        card3.add(secondBedroomFan);


        JButton secondBedroomAlarm = new JButton("Alarm Clock");
        secondBedroomAlarm.setBackground(Color.lightGray);
        card3.add(secondBedroomAlarm);

        //KITCHEN
        JPanel card4 = new JPanel();

        JButton kitchenMotionSensor = new JButton("Motion Sensors");
        kitchenMotionSensor.setBackground(Color.lightGray);
        card4.add(kitchenMotionSensor);

        JButton kitchenLights = new JButton("Lights");
        kitchenLights.setBackground(Color.lightGray);
        card4.add(kitchenLights);

        JButton kitchenOven = new JButton("Oven");
        kitchenOven.setBackground(Color.lightGray);
        card4.add(kitchenOven);

        JButton kitchenKettle = new JButton("Kettle");
        kitchenKettle.setBackground(Color.lightGray);
        card4.add(kitchenKettle);

        JButton kitchenCoffee = new JButton("Coffee Machine");
        kitchenCoffee.setBackground(Color.lightGray);
        card4.add(kitchenCoffee);

        //GARAGE
        JPanel card5 = new JPanel();

        JButton garageMotionSensor = new JButton("Motion Sensors");
        garageMotionSensor.setBackground(Color.lightGray);
        card5.add(garageMotionSensor);

        JButton garageLights = new JButton("Lights");
        garageLights.setBackground(Color.lightGray);
        card5.add(garageLights);

        JButton garageGarage = new JButton("Garage Door");
        garageGarage.setBackground(Color.lightGray);
        card5.add(garageGarage);

        JButton garageCar = new JButton("Car");
        garageCar.setBackground(Color.lightGray);
        card5.add(garageCar);


        //GARDEN
        JPanel card6 = new JPanel();

        JButton gardenMotionSensor = new JButton("Motion Sensors");
        gardenMotionSensor.setBackground(Color.lightGray);
        card6.add(gardenMotionSensor);

        JButton gardenMotionLights = new JButton("Lights");
        gardenMotionLights.setBackground(Color.lightGray);
        card6.add(gardenMotionLights);

        JButton gardenMotionSprinklers = new JButton("Sprinklers");
        gardenMotionSprinklers.setBackground(Color.lightGray);
        card6.add(gardenMotionSprinklers);

        tabbedPane.addTab(LIVINGROOMPANEL, card1);
        tabbedPane.addTab(MAINBEDROOMPANEL, card2);
        tabbedPane.addTab(SECONDBEDROOMPANEL, card3);
        tabbedPane.addTab(KITCHENPANEL, card4);
        tabbedPane.addTab(GARAGEPANEL, card5);
        tabbedPane.addTab(GARDENPANEL, card6);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }

    private void saveMotionSensor(String roomName) throws FileNotFoundException {
        //saves to user chosen room
        Devices motionSensorTemp = new Devices();
        motionSensorTemp.setMotionSensorTemp(livingRoomMotionSensorInput);

        //Add to a list to be called in sim
        switch (roomName) {
            case "LIVING ROOM": {
                Devices location = new Devices();
                location.setLocation("LIVING ROOM");
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                //Location
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
                //Device
                list.add(new Devices.allMotionSensors("Motion Sensor"));
                //Calibration
                list.add(new Devices.allMotionSensors("ON"));
                //User Settings
                list.add(new Devices.allMotionSensors(String.valueOf(motionSensorTemp.getMotionSensorTemp())));
                //Set list
                allMotionSensors.setListMotionSensors(list);

                updatedList = list.toString();
                x1 = String.valueOf((updatedList));

                updatedList1 = Arrays.toString(displayLine2);
                x2 = String.valueOf((updatedList1));

                updatedList2 = Arrays.toString(displayLine3);
                x3 = String.valueOf((updatedList2));

                updatedList3 = Arrays.toString(displayLine4);
                x4 = String.valueOf((updatedList3));

                updatedList4 = Arrays.toString(displayLine5);
                x5 = String.valueOf((updatedList4));

                updatedList5 = Arrays.toString(displayLine6);
                x6 = String.valueOf((updatedList5));

                //Display The Change
                JOptionPane.showMessageDialog(null, updatedList + "\nThe Living Room Motion Sensor have been set to: " + livingRoomMotionSensorMode);
                break;
            }
            case "MAIN BEDROOM": {
                Devices location = new Devices();
                location.setLocation("MAIN BEDROOM");
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                //Location
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
                //Device
                list.add(new Devices.allMotionSensors("Motion Sensor"));
                //Calibration
                list.add(new Devices.allMotionSensors("ON"));
                //User Settings
                list.add(new Devices.allMotionSensors(String.valueOf(motionSensorTemp.getMotionSensorTemp())));
                //Set list
                allMotionSensors.setListMotionSensors(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));

                updatedList1 = list.toString();
                x2 = String.valueOf((updatedList1));

                updatedList2 = Arrays.toString(displayLine3);
                x3 = String.valueOf((updatedList2));

                updatedList3 = Arrays.toString(displayLine4);
                x4 = String.valueOf((updatedList3));

                updatedList4 = Arrays.toString(displayLine5);
                x5 = String.valueOf((updatedList4));

                updatedList5 = Arrays.toString(displayLine6);
                x6 = String.valueOf((updatedList5));

                //Display The Change
                JOptionPane.showMessageDialog(null, updatedList1 + "\nThe Living Room Motion Sensor have been set to: " + livingRoomMotionSensorMode);
                break;
            }
            case "SECOND BEDROOM": {
                Devices location = new Devices();
                location.setLocation("SECOND BEDROOM");
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                //Location
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
                //Device
                list.add(new Devices.allMotionSensors("Motion Sensor"));
                //Calibration
                list.add(new Devices.allMotionSensors("ON"));
                //User Settings
                list.add(new Devices.allMotionSensors(String.valueOf(motionSensorTemp.getMotionSensorTemp())));
                //Set list
                allMotionSensors.setListMotionSensors(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));

                updatedList1 = Arrays.toString(displayLine2);
                x2 = String.valueOf((updatedList1));

                updatedList2 = list.toString();
                x3 = String.valueOf((updatedList2));

                updatedList3 = Arrays.toString(displayLine4);
                x4 = String.valueOf((updatedList3));

                updatedList4 = Arrays.toString(displayLine5);
                x5 = String.valueOf((updatedList4));

                updatedList5 = Arrays.toString(displayLine6);
                x6 = String.valueOf((updatedList5));
                break;
            }
            case "KITCHEN": {
                Devices location = new Devices();
                location.setLocation("KITCHEN");
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                //Location
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
                //Device
                list.add(new Devices.allMotionSensors("Motion Sensor"));
                //Calibration
                list.add(new Devices.allMotionSensors("ON"));
                //User Settings
                list.add(new Devices.allMotionSensors(String.valueOf(motionSensorTemp.getMotionSensorTemp())));
                //Set list
                allMotionSensors.setListMotionSensors(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));

                updatedList1 = Arrays.toString(displayLine2);
                x2 = String.valueOf((updatedList1));

                updatedList2 = Arrays.toString(displayLine3);
                x3 = String.valueOf((updatedList2));

                updatedList3 = list.toString();
                x4 = String.valueOf((updatedList3));

                updatedList4 = Arrays.toString(displayLine5);
                x5 = String.valueOf((updatedList4));

                updatedList5 = Arrays.toString(displayLine6);
                x6 = String.valueOf((updatedList5));
                break;
            }
            case "GARAGE": {
                Devices location = new Devices();
                location.setLocation("GARAGE");
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                //Location
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
                //Device
                list.add(new Devices.allMotionSensors("Motion Sensor"));
                //Calibration
                list.add(new Devices.allMotionSensors("ON"));
                //User Settings
                list.add(new Devices.allMotionSensors(String.valueOf(motionSensorTemp.getMotionSensorTemp())));
                //Set list
                allMotionSensors.setListMotionSensors(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));

                updatedList1 = Arrays.toString(displayLine2);
                x2 = String.valueOf((updatedList1));

                updatedList2 = Arrays.toString(displayLine3);
                x3 = String.valueOf((updatedList2));

                updatedList3 = Arrays.toString(displayLine4);
                x4 = String.valueOf((updatedList3));

                updatedList4 = list.toString();
                x5 = String.valueOf((updatedList4));

                updatedList5 = Arrays.toString(displayLine6);
                x6 = String.valueOf((updatedList5));
                break;
            }
            case "GARDEN": {
                Devices location = new Devices();
                location.setLocation("GARDEN");
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                //Location
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
                //Device
                list.add(new Devices.allMotionSensors("Motion Sensor"));
                //Calibration
                list.add(new Devices.allMotionSensors("ON"));
                //User Settings
                list.add(new Devices.allMotionSensors(String.valueOf(motionSensorTemp.getMotionSensorTemp())));
                //Set list
                allMotionSensors.setListMotionSensors(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));

                updatedList1 = Arrays.toString(displayLine2);
                x2 = String.valueOf((updatedList1));

                updatedList2 = Arrays.toString(displayLine3);
                x3 = String.valueOf((updatedList2));

                updatedList3 = Arrays.toString(displayLine4);
                x4 = String.valueOf((updatedList3));

                updatedList4 = Arrays.toString(displayLine5);
                x5 = String.valueOf((updatedList4));

                updatedList5 = list.toString();
                x6 = String.valueOf((updatedList5));

                break;
            }
        }

        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles/motionSensorConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        //x1 = insert full updated list here
        sb.append(x1).append("\n");
        sb.append(System.lineSeparator());
        //x2 = insert full updated list here
        sb.append(x2).append("\n");
        sb.append(System.lineSeparator());
        //x2 = insert full updated list here
        sb.append(x3).append("\n");
        sb.append(System.lineSeparator());
        //x2 = insert full updated list here
        sb.append(x4).append("\n");
        sb.append(System.lineSeparator());
        //x2 = insert full updated list here
        sb.append(x5).append("\n");
        sb.append(System.lineSeparator());
        //x2 = insert full updated list here
        sb.append(x6).append("\n");


        try {
            Files.write(Paths.get("ConfigFiles/motionSensorConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Device Config");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        TabConfig demo = new TabConfig();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main() {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(TabConfig::createAndShowGUI);
    }
}