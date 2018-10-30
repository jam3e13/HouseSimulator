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
import javax.swing.plaf.basic.BasicBorders;

public class TabConfig extends JFrame {
    private final static String LIVINGROOMPANEL = "LIVING ROOM";
    final static String MAINBEDROOMPANEL = "MAIN BEDROOM";
    final static String SECONDBEDROOMPANEL = "SECOND BEDROOM";
    final static String KITCHENPANEL = "KITCHEN";
    final static String GARAGEPANEL = "GARAGE";
    final static String GARDENPANEL = "GARDEN";
    static double livingRoomTvOffTime, livingRoomTvMinuteInput, secondBedroomAlarmMinInput, mainBedroomAlarmMinInput, ovenMorningAlarmMinute, ovenLunchAlarmMinute, ovenDinnerAlarmMinute, ovenAlarmMorning, ovenAlarmLunch, ovenAlarmDinner;
    public static double alarmClockTotal;
    static String morningAfternoon, carMode, kettleMode, coffeMachineMode, sprinklerMode, morningMode, lunchMode, dinnerMode, smartAlarmMode, data, x1, x2, x3, x4, x5, x6, updatedList, updatedList1, updatedList2, updatedList3, updatedList4, updatedList5, livingRoomLightMode, livingRoomMotionSensorMode;
    static int livingRoomTvHourInput, ovenMorningInput, coffeeMachineInput, kettleAlarm, ovenLunchInput, ovenDinnerInput, garageCarLightsInput, smartAlarmInput, mainBedroomAlarmInput, secondBedroomAlarmInput, sprinklerInput, garageDoorLightsInput, livingRoomAirConInput, livingRoomLightsInput, livingRoomMotionSensorInput, livingRoomFanInput, ovenMorningAlarmHour, ovenLunchAlarmHour, ovenDinnerAlarmHour;
    private static String[] displayLine1, displayLine2, values, displayLine3, displayLine4, displayLine5, displayLine6;

    private final static int extraWindowWidth = 100;

    private void addComponentToPane(Container pane) {
        //Motion Sensor
        livingRoomMotionSensor = new javax.swing.JButton();
        mainBedroomMotionSensor = new javax.swing.JButton();
        secondBedroomMotionSensor = new javax.swing.JButton();
        kitchenMotionSensor = new javax.swing.JButton();
        garageMotionSensor = new javax.swing.JButton();
        gardenMotionSensor = new javax.swing.JButton();

        //Lights
        livingRoomLights = new javax.swing.JButton();
        mainBedroomLights = new javax.swing.JButton();
        secondBedroomLights = new javax.swing.JButton();
        kitchenLights = new javax.swing.JButton();
        garageLights = new javax.swing.JButton();
        gardenLights = new javax.swing.JButton();

        //Air Conditioner
        livingRoomAirCon = new javax.swing.JButton();
        mainBedroomAc = new javax.swing.JButton();

        //Ceiling Fan
        livingRoomFan = new javax.swing.JButton();
        mainBedroomFan = new javax.swing.JButton();
        secondBedroomFan = new javax.swing.JButton();

        //Garage Door
        garageGarage = new javax.swing.JButton();

        //Sprinklers
        gardenMotionSprinklers = new javax.swing.JButton();

        //Car
        garageCar = new javax.swing.JButton();

        //Oven
        kitchenOven = new javax.swing.JButton();

        //Tv
        livingRoomTv = new javax.swing.JButton();
        mainBedroomTv = new javax.swing.JButton();

        //Kettle
        kitchenKettle = new javax.swing.JButton();

        //Coffee Machine
        kitchenCoffee = new javax.swing.JButton();

        //Alarm Clock
        mainBedroomAlarm = new javax.swing.JButton();
        secondBedroomAlarm = new javax.swing.JButton();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Color.gray);

        //Create the "cards".
        JPanel card1 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = new Dimension(800, 200);
                size.width += extraWindowWidth;
                return size;
            }
        };

        //LIVING ROOM
        card1.setBackground(Color.lightGray);
        card1.setBorder(new BasicBorders.ToggleButtonBorder(Color.white, Color.gray, Color.darkGray, Color.black));
        JButton livingRoomMotionSensor = new JButton("Motion Sensors");
        livingRoomMotionSensor.setPreferredSize(new Dimension(160, 80));
        livingRoomMotionSensor.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileMotionSensor = "ConfigFiles/motionSensorConfig.txt";
        File file = new File(fileMotionSensor);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    livingRoomMotionSensor.setBackground(Color.green);
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    livingRoomMotionSensor.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card1.add(livingRoomMotionSensor);
        livingRoomMotionSensor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileMotionSensor = "ConfigFiles/motionSensorConfig.txt";
                File file1 = new File(fileMotionSensor);
                try {
                    Scanner inputStream = new Scanner(file1);
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
        livingRoomLights.setPreferredSize(new Dimension(160, 80));
        livingRoomLights.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileLights = "ConfigFiles/lightConfig.txt";
        File file1 = new File(fileLights);
        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    livingRoomLights.setBackground(Color.green);
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    livingRoomLights.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card1.add(livingRoomLights);
        livingRoomLights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/lightConfig.txt";
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

                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");

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
                        saveLights(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton livingRoomAirCon = new JButton("Air Conditioner");
        livingRoomAirCon.setPreferredSize(new Dimension(160, 80));
        livingRoomAirCon.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileAirConditioner = "ConfigFiles/airConConfig.txt";
        File file2 = new File(fileAirConditioner);
        try {
            Scanner inputStream = new Scanner(file2);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    livingRoomAirCon.setBackground(Color.green);
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    livingRoomAirCon.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card1.add(livingRoomAirCon);
        livingRoomAirCon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/airConConfig.txt";
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

                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
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
                            }
                        }
                        if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                            displayLine2 = data.split(", ");
                        } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "LIVING ROOM";
                        saveAirCon(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton livingRoomFan = new JButton("Ceiling Fan");
        livingRoomFan.setPreferredSize(new Dimension(160, 80));
        livingRoomFan.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileCeilingFan = "ConfigFiles/ceilingFanConfig.txt";
        File file3 = new File(fileCeilingFan);
        try {
            Scanner inputStream = new Scanner(file3);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    livingRoomFan.setBackground(Color.green);
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    livingRoomFan.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card1.add(livingRoomFan);
        livingRoomFan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/ceilingFanConfig.txt";
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

                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
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
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "LIVING ROOM";
                        saveFan(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton livingRoomTv = new JButton("Tv");
        livingRoomTv.setPreferredSize(new Dimension(160, 80));
        livingRoomTv.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileTv = "ConfigFiles/tvConfig.txt";
        File file4 = new File(fileTv);
        try {
            Scanner inputStream = new Scanner(file4);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    livingRoomTv.setBackground(Color.green);
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    livingRoomTv.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card1.add(livingRoomTv);
        livingRoomTv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/tvConfig.txt";
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
                                String livingRoomFanInputString;
                                livingRoomFanInputString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);

                                if (livingRoomTvHourInput == 1) {
                                    livingRoomTvHourInput = 13;
                                } else if (livingRoomTvHourInput == 2) {
                                    livingRoomTvHourInput = 14;
                                } else if (livingRoomTvHourInput == 3) {
                                    livingRoomTvHourInput = 15;
                                } else if (livingRoomTvHourInput == 4) {
                                    livingRoomTvHourInput = 16;
                                } else if (livingRoomTvHourInput == 5) {
                                    livingRoomTvHourInput = 17;
                                } else if (livingRoomTvHourInput == 6) {
                                    livingRoomTvHourInput = 18;
                                } else if (livingRoomTvHourInput == 7) {
                                    livingRoomTvHourInput = 19;
                                } else if (livingRoomTvHourInput == 8) {
                                    livingRoomTvHourInput = 20;
                                } else if (livingRoomTvHourInput == 9) {
                                    livingRoomTvHourInput = 21;
                                } else if (livingRoomTvHourInput == 10) {
                                    livingRoomTvHourInput = 22;
                                } else if (livingRoomTvHourInput == 11) {
                                    livingRoomTvHourInput = 23;
                                } else if (livingRoomTvHourInput == 12) {
                                    livingRoomTvHourInput = 24;
                                }

                                while (livingRoomTvHourInput > 24) {
                                    livingRoomFanInputString = JOptionPane.showInputDialog("Please enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                    livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);
                                }
                                while (livingRoomTvHourInput < 12) {
                                    livingRoomFanInputString = JOptionPane.showInputDialog("Please enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                    livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);
                                }

                                //Minutes
                                String livingRoomFanMinuteString;
                                livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Minutes (00 - 60)\nMinutes: ");
                                livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);

                                while (livingRoomTvMinuteInput > 60.00) {
                                    livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Minutes (00 - 60)\nMinutes: ");
                                    livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);
                                }
                                while (livingRoomTvMinuteInput < 00.00) {
                                    livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Minutes (00 - 60)\nMinutes: ");
                                    livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);
                                }


                                livingRoomTvOffTime = livingRoomTvHourInput + livingRoomTvMinuteInput;

                                JOptionPane.showMessageDialog(null, "The Living Room Tv will automatically turn off at: " + livingRoomTvOffTime);
                            }

                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
                            if (livingRoomTvHourInput == (0)) {
                                String livingRoomFanInputString;
                                livingRoomFanInputString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);

                                if (livingRoomTvHourInput == 1) {
                                    livingRoomTvHourInput = 13;
                                } else if (livingRoomTvHourInput == 2) {
                                    livingRoomTvHourInput = 14;
                                } else if (livingRoomTvHourInput == 3) {
                                    livingRoomTvHourInput = 15;
                                } else if (livingRoomTvHourInput == 4) {
                                    livingRoomTvHourInput = 16;
                                } else if (livingRoomTvHourInput == 5) {
                                    livingRoomTvHourInput = 17;
                                } else if (livingRoomTvHourInput == 6) {
                                    livingRoomTvHourInput = 18;
                                } else if (livingRoomTvHourInput == 7) {
                                    livingRoomTvHourInput = 19;
                                } else if (livingRoomTvHourInput == 8) {
                                    livingRoomTvHourInput = 20;
                                } else if (livingRoomTvHourInput == 9) {
                                    livingRoomTvHourInput = 21;
                                } else if (livingRoomTvHourInput == 10) {
                                    livingRoomTvHourInput = 22;
                                } else if (livingRoomTvHourInput == 11) {
                                    livingRoomTvHourInput = 23;
                                } else if (livingRoomTvHourInput == 12) {
                                    livingRoomTvHourInput = 24;
                                }

                                while (livingRoomTvHourInput > 24) {
                                    livingRoomFanInputString = JOptionPane.showInputDialog("Please enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                    livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);
                                }
                                while (livingRoomTvHourInput < 12) {
                                    livingRoomFanInputString = JOptionPane.showInputDialog("Please enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                    livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);
                                }

                                //Minutes
                                String livingRoomFanMinuteString;
                                livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Alarm Clock Minutes (00 - 60)\nMinutes: ");
                                livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);

                                while (livingRoomTvMinuteInput > 60.00) {
                                    livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Alarm Clock Minutes (00 - 60)\nMinutes: ");
                                    livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);
                                }
                                while (livingRoomTvMinuteInput < 00.00) {
                                    livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Alarm Clock Minutes (00 - 60)\nMinutes: ");
                                    livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);
                                }


                                livingRoomTvOffTime = livingRoomTvHourInput + livingRoomTvMinuteInput;

                                JOptionPane.showMessageDialog(null, "The Living Room Tv will automatically turn off at: " + livingRoomTvOffTime);
                            }
                        }
                        if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                            displayLine2 = data.split(", ");
                        } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "LIVING ROOM";
                        saveTv(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //MAIN BEDROOM
        JPanel card2 = new JPanel();
        card2.setBackground(Color.lightGray);
        card2.setBorder(new BasicBorders.ToggleButtonBorder(Color.white, Color.gray, Color.darkGray, Color.black));
        JButton mainBedroomMotionSensor = new JButton("Motion Sensors");
        mainBedroomMotionSensor.setPreferredSize(new Dimension(160, 80));
        mainBedroomMotionSensor.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomMotionSensor.setBackground(Color.green);
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomMotionSensor.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card2.add(mainBedroomMotionSensor);
        mainBedroomMotionSensor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileMotionSensor = "ConfigFiles/motionSensorConfig.txt";
                File file2 = new File(fileMotionSensor);
                try {
                    Scanner inputStream = new Scanner(file2);
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
        mainBedroomLights.setPreferredSize(new Dimension(160, 80));
        mainBedroomLights.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomLights.setBackground(Color.green);
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomLights.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card2.add(mainBedroomLights);
        mainBedroomLights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/lightConfig.txt";
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
                                JOptionPane.showMessageDialog(null, "The Main Bedroom Lights have been set to: " + livingRoomLightMode);
                            }

                        } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");

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
                                JOptionPane.showMessageDialog(null, "The Main Bedroom Lights have been set to: " + livingRoomLightMode);
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
                        saveLights(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton mainBedroomAirCon = new JButton("Air Conditioner");
        mainBedroomAirCon.setPreferredSize(new Dimension(160, 80));
        mainBedroomAirCon.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file2);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomAirCon.setBackground(Color.green);
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomAirCon.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card2.add(mainBedroomAirCon);
        mainBedroomAirCon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/airConConfig.txt";
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
                                fullAcDisplay = "The Main Bedroom Air Conditioner has been set to: " + livingRoomAirConInputString + "°";
                                JOptionPane.showMessageDialog(null, fullAcDisplay);
                            }

                        } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");
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
                                fullAcDisplay = "The Main Bedroom Air Conditioner has been set to: " + livingRoomAirConInputString + "°";
                                JOptionPane.showMessageDialog(null, fullAcDisplay);
                            }
                        }
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "MAIN BEDROOM";
                        saveAirCon(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton mainBedroomFan = new JButton("Ceiling Fan");
        mainBedroomFan.setPreferredSize(new Dimension(160, 80));
        mainBedroomFan.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file3);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomFan.setBackground(Color.green);
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomFan.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card2.add(mainBedroomFan);
        mainBedroomFan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/ceilingFanConfig.txt";
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

                                JOptionPane.showMessageDialog(null, "The Main Bedroom Ceiling Fan has been set to: " + livingRoomFanInput + "°");
                            }

                        } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");
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

                                JOptionPane.showMessageDialog(null, "The Main Bedroom Ceiling Fan has been set to: " + livingRoomFanInput + "°");
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
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "MAIN BEDROOM";
                        saveFan(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton mainBedroomTv = new JButton("Tv");
        mainBedroomTv.setPreferredSize(new Dimension(160, 80));
        mainBedroomTv.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file4);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomTv.setBackground(Color.green);
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomTv.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card2.add(mainBedroomTv);
        mainBedroomTv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/tvConfig.txt";
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
                                String livingRoomFanInputString;
                                livingRoomFanInputString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);

                                if (livingRoomTvHourInput == 1) {
                                    livingRoomTvHourInput = 13;
                                } else if (livingRoomTvHourInput == 2) {
                                    livingRoomTvHourInput = 14;
                                } else if (livingRoomTvHourInput == 3) {
                                    livingRoomTvHourInput = 15;
                                } else if (livingRoomTvHourInput == 4) {
                                    livingRoomTvHourInput = 16;
                                } else if (livingRoomTvHourInput == 5) {
                                    livingRoomTvHourInput = 17;
                                } else if (livingRoomTvHourInput == 6) {
                                    livingRoomTvHourInput = 18;
                                } else if (livingRoomTvHourInput == 7) {
                                    livingRoomTvHourInput = 19;
                                } else if (livingRoomTvHourInput == 8) {
                                    livingRoomTvHourInput = 20;
                                } else if (livingRoomTvHourInput == 9) {
                                    livingRoomTvHourInput = 21;
                                } else if (livingRoomTvHourInput == 10) {
                                    livingRoomTvHourInput = 22;
                                } else if (livingRoomTvHourInput == 11) {
                                    livingRoomTvHourInput = 23;
                                } else if (livingRoomTvHourInput == 12) {
                                    livingRoomTvHourInput = 24;
                                }

                                while (livingRoomTvHourInput > 24) {
                                    livingRoomFanInputString = JOptionPane.showInputDialog("Please enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                    livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);
                                }
                                while (livingRoomTvHourInput < 12) {
                                    livingRoomFanInputString = JOptionPane.showInputDialog("Please enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                    livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);
                                }

                                //Minutes
                                String livingRoomFanMinuteString;
                                livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Alarm Clock Minutes (00 - 60)\nMinutes: ");
                                livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);

                                while (livingRoomTvMinuteInput > 60.00) {
                                    livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Alarm Clock Minutes (00 - 60)\nMinutes: ");
                                    livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);
                                }
                                while (livingRoomTvMinuteInput < 00.00) {
                                    livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Alarm Clock Minutes (00 - 60)\nMinutes: ");
                                    livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);
                                }


                                livingRoomTvOffTime = livingRoomTvHourInput + livingRoomTvMinuteInput;

                                JOptionPane.showMessageDialog(null, "The Main Bedroom Tv will automatically turn off at: " + livingRoomTvOffTime);
                            }

                        } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");
                            if (livingRoomTvHourInput == (0)) {
                                String livingRoomFanInputString;
                                livingRoomFanInputString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);

                                if (livingRoomTvHourInput == 1) {
                                    livingRoomTvHourInput = 13;
                                } else if (livingRoomTvHourInput == 2) {
                                    livingRoomTvHourInput = 14;
                                } else if (livingRoomTvHourInput == 3) {
                                    livingRoomTvHourInput = 15;
                                } else if (livingRoomTvHourInput == 4) {
                                    livingRoomTvHourInput = 16;
                                } else if (livingRoomTvHourInput == 5) {
                                    livingRoomTvHourInput = 17;
                                } else if (livingRoomTvHourInput == 6) {
                                    livingRoomTvHourInput = 18;
                                } else if (livingRoomTvHourInput == 7) {
                                    livingRoomTvHourInput = 19;
                                } else if (livingRoomTvHourInput == 8) {
                                    livingRoomTvHourInput = 20;
                                } else if (livingRoomTvHourInput == 9) {
                                    livingRoomTvHourInput = 21;
                                } else if (livingRoomTvHourInput == 10) {
                                    livingRoomTvHourInput = 22;
                                } else if (livingRoomTvHourInput == 11) {
                                    livingRoomTvHourInput = 23;
                                } else if (livingRoomTvHourInput == 12) {
                                    livingRoomTvHourInput = 24;
                                }

                                while (livingRoomTvHourInput > 24) {
                                    livingRoomFanInputString = JOptionPane.showInputDialog("Please enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                    livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);
                                }
                                while (livingRoomTvHourInput < 12) {
                                    livingRoomFanInputString = JOptionPane.showInputDialog("Please enter Turn Off Time for Tv; (12pm - 12am)\nHour: ");
                                    livingRoomTvHourInput = Integer.parseInt(livingRoomFanInputString);
                                }

                                //Minutes
                                String livingRoomFanMinuteString;
                                livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Alarm Clock Minutes (00 - 60)\nMinutes: ");
                                livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);

                                while (livingRoomTvMinuteInput > 60.00) {
                                    livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Alarm Clock Minutes (00 - 60)\nMinutes: ");
                                    livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);
                                }
                                while (livingRoomTvMinuteInput < 00.00) {
                                    livingRoomFanMinuteString = JOptionPane.showInputDialog("Enter Turn Off Time for TV\nPlease enter Alarm Clock Minutes (00 - 60)\nMinutes: ");
                                    livingRoomTvMinuteInput = Integer.parseInt(livingRoomFanMinuteString);
                                }


                                livingRoomTvOffTime = livingRoomTvHourInput + livingRoomTvMinuteInput;

                                JOptionPane.showMessageDialog(null, "The Main Bedroom Tv will automatically turn off at: " + livingRoomTvOffTime);
                            }
                        }
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "MAIN BEDROOM";
                        saveTv(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton mainBedroomAlarm = new JButton("Alarm Clock");
        mainBedroomAlarm.setPreferredSize(new Dimension(160, 80));
        mainBedroomAlarm.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileAlarmClock = "ConfigFiles/alarmClockConfig.txt";
        File file11 = new File(fileAlarmClock);
        try {
            Scanner inputStream = new Scanner(file11);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomAlarm.setBackground(Color.gray);

                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomAlarm.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card2.add(mainBedroomAlarm);
        mainBedroomAlarm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/alarmClockConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                            String continueSetUp;
                            continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                            continueSetUp = continueSetUp.toUpperCase();
                            if (continueSetUp.equals("Y")) {
                                String AlarmHourString;
                                AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                mainBedroomAlarmInput = Integer.parseInt(AlarmHourString);

                                while (mainBedroomAlarmInput > 12) {
                                    AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                    mainBedroomAlarmInput = Integer.parseInt(AlarmHourString);
                                }
                                while (mainBedroomAlarmInput < 5) {
                                    AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                    mainBedroomAlarmInput = Integer.parseInt(AlarmHourString);
                                }

                                String AlarmMinuteString;
                                AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                mainBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);

                                while (mainBedroomAlarmMinInput > 60.00) {
                                    AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                    mainBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);
                                }
                                while (mainBedroomAlarmMinInput < 00.00) {
                                    AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                    mainBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);
                                }

                                alarmClockTotal = mainBedroomAlarmMinInput / 100;
                                alarmClockTotal = alarmClockTotal + mainBedroomAlarmInput;

                                String smartAlarmString;
                                smartAlarmString = JOptionPane.showInputDialog("Please ENABLE Alarm Clock's Smart Ability;\n1) Morning Coffee always\n2) Morning Coffee never");
                                smartAlarmInput = Integer.parseInt(smartAlarmString);

                                while (smartAlarmInput > 2) {
                                    smartAlarmString = JOptionPane.showInputDialog("Please ENABLE Alarm Clock's Smart Ability;\n1) Morning Coffee always\n2) Morning Coffee never");
                                    smartAlarmInput = Integer.parseInt(smartAlarmString);
                                }

                                if (smartAlarmInput == 1) {
                                    smartAlarmMode = "Morning Coffee always";
                                } else if (smartAlarmInput == 2) {
                                    smartAlarmMode = "Morning Coffee never";
                                }

                                JOptionPane.showMessageDialog(null, "The Main Bedroom Alarm automatically turn on at: " + alarmClockTotal + "\nSmart Alarm settings: " + smartAlarmMode);

                            }

                        } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");

                            String AlarmHourString;
                            AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                            mainBedroomAlarmInput = Integer.parseInt(AlarmHourString);

                            while (mainBedroomAlarmInput > 12) {
                                AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                mainBedroomAlarmInput = Integer.parseInt(AlarmHourString);
                            }
                            while (mainBedroomAlarmInput < 5) {
                                AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                mainBedroomAlarmInput = Integer.parseInt(AlarmHourString);
                            }

                            String AlarmMinuteString;
                            AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                            mainBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);

                            while (mainBedroomAlarmMinInput > 60.00) {
                                AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                mainBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);
                            }
                            while (mainBedroomAlarmMinInput < 00.00) {
                                AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                mainBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);
                            }

                            alarmClockTotal = mainBedroomAlarmMinInput / 100;
                            alarmClockTotal = alarmClockTotal + mainBedroomAlarmInput;

                            String smartAlarmString;
                            smartAlarmString = JOptionPane.showInputDialog("Please ENABLE Alarm Clock's Smart Ability;\n1) Morning Coffee always\n2) Morning Coffee never");
                            smartAlarmInput = Integer.parseInt(smartAlarmString);

                            while (smartAlarmInput > 2) {
                                smartAlarmString = JOptionPane.showInputDialog("Please ENABLE Alarm Clock's Smart Ability;\n1) Morning Coffee always\n2) Morning Coffee never");
                                smartAlarmInput = Integer.parseInt(smartAlarmString);
                            }

                            if (smartAlarmInput == 1) {
                                smartAlarmMode = "Morning Coffee always";
                            } else if (smartAlarmInput == 2) {
                                smartAlarmMode = "Morning Coffee never";
                            }

                            JOptionPane.showMessageDialog(null, "The Main Bedroom Alarm automatically turn on at: " + alarmClockTotal + "\nSmart Alarm settings: " + smartAlarmMode);
                        }
                        if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                            displayLine2 = data.split(", ");
                        } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "MAIN BEDROOM";
                        saveAlarm(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //SECOND BEDROOM
        JPanel card3 = new JPanel();
        card3.setBackground(Color.lightGray);
        card3.setBorder(new BasicBorders.ToggleButtonBorder(Color.white, Color.gray, Color.darkGray, Color.black));
        JButton secondBedroomMotionSensor = new JButton("Motion Sensors");
        secondBedroomMotionSensor.setPreferredSize(new Dimension(160, 80));
        secondBedroomMotionSensor.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    secondBedroomMotionSensor.setBackground(Color.green);
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    secondBedroomMotionSensor.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card3.add(secondBedroomMotionSensor);
        secondBedroomMotionSensor.addActionListener(new ActionListener() {
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
                        if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
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

                        } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
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
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
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
                        String roomName = "SECOND BEDROOM";
                        saveMotionSensor(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton secondBedroomLights = new JButton("Lights");
        secondBedroomLights.setPreferredSize(new Dimension(160, 80));
        secondBedroomLights.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    secondBedroomLights.setBackground(Color.green);
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    secondBedroomLights.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card3.add(secondBedroomLights);
        secondBedroomLights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/lightConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                            displayLine3 = data.split(", ");
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
                                JOptionPane.showMessageDialog(null, "The Second Bedroom Lights have been set to: " + livingRoomLightMode);
                            }

                        } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                            displayLine3 = data.split(", ");

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
                                JOptionPane.showMessageDialog(null, "The Second Bedroom Lights have been set to: " + livingRoomLightMode);
                            }

                        }
                        if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                            displayLine2 = data.split(", ");
                        } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");
                        }
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
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
                        saveLights(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        JButton secondBedroomFan = new JButton("Ceiling Fan");
        secondBedroomFan.setPreferredSize(new Dimension(160, 80));
        secondBedroomFan.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file3);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    secondBedroomFan.setBackground(Color.green);
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    secondBedroomFan.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card3.add(secondBedroomFan);
        secondBedroomFan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/ceilingFanConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                            displayLine3 = data.split(", ");
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

                                JOptionPane.showMessageDialog(null, "The Second Bedrooom Ceiling Fan has been set to: " + livingRoomFanInput + "°");
                            }

                        } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                            displayLine3 = data.split(", ");
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

                                JOptionPane.showMessageDialog(null, "The Second Bedroom Ceiling Fan has been set to: " + livingRoomFanInput + "°");
                            }
                        }
                        if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                            displayLine2 = data.split(", ");
                        } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");
                        }
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "SECOND BEDROOM";
                        saveFan(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        JButton secondBedroomAlarm = new JButton("Alarm Clock");
        secondBedroomAlarm.setPreferredSize(new Dimension(160, 80));
        secondBedroomAlarm.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file11);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    secondBedroomAlarm.setBackground(Color.gray);
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    secondBedroomAlarm.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card3.add(secondBedroomAlarm);
        secondBedroomAlarm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/alarmClockConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                            displayLine2 = data.split(", ");
                            String continueSetUp;
                            continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                            continueSetUp = continueSetUp.toUpperCase();
                            if (continueSetUp.equals("Y")) {
                                String AlarmHourString;
                                AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                secondBedroomAlarmInput = Integer.parseInt(AlarmHourString);

                                while (secondBedroomAlarmInput > 12) {
                                    AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                    secondBedroomAlarmInput = Integer.parseInt(AlarmHourString);
                                }
                                while (secondBedroomAlarmInput < 5) {
                                    AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                    secondBedroomAlarmInput = Integer.parseInt(AlarmHourString);
                                }

                                String AlarmMinuteString;
                                AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                secondBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);

                                while (secondBedroomAlarmMinInput > 60.00) {
                                    AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                    secondBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);
                                }
                                while (secondBedroomAlarmMinInput < 00.00) {
                                    AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                    secondBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);
                                }

                                alarmClockTotal = secondBedroomAlarmMinInput / 100;
                                alarmClockTotal = alarmClockTotal + secondBedroomAlarmInput;

                                String smartAlarmString;
                                smartAlarmString = JOptionPane.showInputDialog("Please ENABLE Alarm Clock's Smart Ability;\n1) Morning Coffee always\n2) Morning Coffee never");
                                smartAlarmInput = Integer.parseInt(smartAlarmString);

                                while (smartAlarmInput > 2) {
                                    smartAlarmString = JOptionPane.showInputDialog("Please ENABLE Alarm Clock's Smart Ability;\n1) Morning Coffee always\n2) Morning Coffee never");
                                    smartAlarmInput = Integer.parseInt(smartAlarmString);
                                }

                                if (smartAlarmInput == 1) {
                                    smartAlarmMode = "Morning Coffee always";
                                } else if (smartAlarmInput == 2) {
                                    smartAlarmMode = "Morning Coffee never";
                                }

                                JOptionPane.showMessageDialog(null, "The Second Bedroom Alarm automatically turn on at: " + alarmClockTotal + "\nSmart Alarm settings: " + smartAlarmMode);
                            }

                        } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                            displayLine2 = data.split(", ");

                            String AlarmHourString;
                            AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                            secondBedroomAlarmInput = Integer.parseInt(AlarmHourString);

                            while (secondBedroomAlarmInput > 12) {
                                AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                secondBedroomAlarmInput = Integer.parseInt(AlarmHourString);
                            }
                            while (secondBedroomAlarmInput < 5) {
                                AlarmHourString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                secondBedroomAlarmInput = Integer.parseInt(AlarmHourString);
                            }

                            String AlarmMinuteString;
                            AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                            secondBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);

                            while (secondBedroomAlarmMinInput > 60.00) {
                                AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                secondBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);
                            }
                            while (secondBedroomAlarmMinInput < 00.00) {
                                AlarmMinuteString = JOptionPane.showInputDialog("Enter Alarm Settings \nPlease enter Alarm Clock alarm time; (5am - 12pm)\nHour: ");
                                secondBedroomAlarmMinInput = Integer.parseInt(AlarmMinuteString);
                            }

                            alarmClockTotal = secondBedroomAlarmMinInput / 100;
                            alarmClockTotal = alarmClockTotal + mainBedroomAlarmInput;

                            String smartAlarmString;
                            smartAlarmString = JOptionPane.showInputDialog("Please ENABLE Alarm Clock's Smart Ability;\n1) Morning Coffee always\n2) Morning Coffee never");
                            smartAlarmInput = Integer.parseInt(smartAlarmString);

                            while (smartAlarmInput > 2) {
                                smartAlarmString = JOptionPane.showInputDialog("Please ENABLE Alarm Clock's Smart Ability;\n1) Morning Coffee always\n2) Morning Coffee never");
                                smartAlarmInput = Integer.parseInt(smartAlarmString);
                            }

                            if (smartAlarmInput == 1) {
                                smartAlarmMode = "Morning Coffee always";
                            } else if (smartAlarmInput == 2) {
                                smartAlarmMode = "Morning Coffee never";
                            }

                            JOptionPane.showMessageDialog(null, "The Main Bedroom Alarm automatically turn on at: " + alarmClockTotal + "\nSmart Alarm settings: " + smartAlarmMode);
                        }
                        if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("MAIN BEDROO") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "SECOND BEDROOM";
                        saveAlarm(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //KITCHEN
        JPanel card4 = new JPanel();
        card4.setBackground(Color.lightGray);
        card4.setBorder(new BasicBorders.ToggleButtonBorder(Color.white, Color.gray, Color.darkGray, Color.black));
        JButton kitchenMotionSensor = new JButton("Motion Sensors");
        kitchenMotionSensor.setPreferredSize(new Dimension(160, 80));
        kitchenMotionSensor.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    kitchenMotionSensor.setBackground(Color.green);
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    kitchenMotionSensor.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card4.add(kitchenMotionSensor);
        kitchenMotionSensor.addActionListener(new ActionListener() {
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
                        if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
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

                        } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
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
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
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
                        String roomName = "KITCHEN";
                        saveMotionSensor(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton kitchenLights = new JButton("Lights");
        kitchenLights.setPreferredSize(new Dimension(160, 80));
        kitchenLights.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    kitchenLights.setBackground(Color.green);
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    kitchenLights.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card4.add(kitchenLights);
        kitchenLights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/lightConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                            displayLine4 = data.split(", ");
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
                                JOptionPane.showMessageDialog(null, "The Kitchen Lights have been set to: " + livingRoomLightMode);
                            }

                        } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                            displayLine4 = data.split(", ");

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
                                JOptionPane.showMessageDialog(null, "The Kitchen Lights have been set to: " + livingRoomLightMode);
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
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
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
                        String roomName = "KITCHEN";
                        saveLights(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton kitchenOven = new JButton("Oven");
        kitchenOven.setPreferredSize(new Dimension(160, 80));
        kitchenOven.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileName8 = "ConfigFiles/ovenConfig.txt";
        File file8 = new File(fileName8);
        try {
            Scanner inputStream = new Scanner(file8);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    kitchenOven.setBackground(Color.green);
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    kitchenOven.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card4.add(kitchenOven);
        kitchenOven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/ovenConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                            String continueSetUp;
                            continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                            continueSetUp = continueSetUp.toUpperCase();
                            if (continueSetUp.equals("Y")) {
                                //Morning
                                String ovenMorningInputString;
                                ovenMorningInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nMorning:\n1) Pancakes.\n2) Toast.\n3) Eggs and Bacon");
                                ovenMorningInput = Integer.parseInt(ovenMorningInputString);

                                while (ovenMorningInput > 3) {
                                    ovenMorningInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nMorning:\n1) Pancakes.\n2) Toast.\n3) Eggs and Bacon");
                                    ovenMorningInput = Integer.parseInt(ovenMorningInputString);
                                }

                                if (ovenMorningInput == 1) {
                                    //1
                                    morningMode = "Pancakes";
                                } else if (ovenMorningInput == 2) {
                                    //2
                                    morningMode = "Toast";
                                } else if (ovenMorningInput == 3) {
                                    //3
                                    morningMode = "Eggs and Bacon";
                                }

                                String ovenMorningAlarmString;
                                ovenMorningAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (6am - 9am)\nPlease enter Oven alarm time\nHour: ");
                                ovenMorningAlarmHour = Integer.parseInt(ovenMorningAlarmString);

                                while (ovenMorningAlarmHour > 9) {
                                    ovenMorningAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (6am - 9am)\nPlease enter Oven alarm time\nHour: ");
                                    ovenMorningAlarmHour = Integer.parseInt(ovenMorningAlarmString);
                                }
                                while (ovenMorningAlarmHour < 6) {
                                    ovenMorningAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (6am - 9am)\nPlease enter Oven alarm time\nHour: ");
                                    ovenMorningAlarmHour = Integer.parseInt(ovenMorningAlarmString);
                                }

                                String ovenMorningAlarmString1;
                                ovenMorningAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (00 - 60)\nHour: " + ovenMorningAlarmHour + "am\nPlease enter Oven alarm time\nMinutes: ");
                                ovenMorningAlarmMinute = Integer.parseInt(ovenMorningAlarmString1);

                                while (ovenMorningAlarmMinute > 60.00) {
                                    ovenMorningAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (00 - 60)\nHour: " + ovenMorningAlarmHour + "am\nPlease enter Oven alarm time\nMinutes: ");
                                    ovenMorningAlarmMinute = Integer.parseInt(ovenMorningAlarmString1);
                                }
                                while (ovenMorningAlarmMinute < 00.00) {
                                    ovenMorningAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (00 - 60)\nHour: " + ovenMorningAlarmHour + "am\nPlease enter Oven alarm time\nMinutes: ");
                                    ovenMorningAlarmMinute = Integer.parseInt(ovenMorningAlarmString1);
                                }

                                ovenAlarmMorning = ovenMorningAlarmMinute / 100;
                                ovenAlarmMorning = ovenAlarmMorning + ovenMorningAlarmHour;

                                //Lunch
                                String ovenLunchInputString;
                                ovenLunchInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nLunch:\n1) Muffins.\n2) Toasted Sandwich.\n3) Chicken and Rice Salad");
                                ovenLunchInput = Integer.parseInt(ovenLunchInputString);

                                while (ovenLunchInput > 3) {
                                    ovenLunchInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nLunch:\n1) Muffins.\n2) Toasted Sandwich.\n3) Chicken and Rice Salad");
                                    ovenLunchInput = Integer.parseInt(ovenLunchInputString);
                                }

                                if (ovenLunchInput == 1) {
                                    //1
                                    lunchMode = "Muffins";
                                } else if (ovenLunchInput == 2) {
                                    //2
                                    lunchMode = "Toasted Sandwich";
                                } else if (ovenLunchInput == 3) {
                                    //3
                                    lunchMode = "Chicken and Rice Salad";
                                }

                                String ovenLunchAlarmString;
                                ovenLunchAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (11am - 2pm)\nPlease enter Oven alarm time\nHour: ");
                                ovenLunchAlarmHour = Integer.parseInt(ovenLunchAlarmString);
                                morningAfternoon = "am";

                                if (ovenLunchAlarmHour == 1) {
                                    ovenLunchAlarmHour = 13;
                                    morningAfternoon = "pm";
                                } else if (ovenLunchAlarmHour == 2) {
                                    ovenLunchAlarmHour = 14;
                                    morningAfternoon = "pm";
                                } else if (ovenLunchAlarmHour == 12) {
                                    morningAfternoon = "pm";
                                }

                                while (ovenLunchAlarmHour > 14) {
                                    ovenLunchAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (11am - 2pm)\nPlease enter Oven alarm time\nHour: ");
                                    ovenLunchAlarmHour = Integer.parseInt(ovenLunchAlarmString);
                                }
                                while (ovenLunchAlarmHour < 11) {
                                    ovenLunchAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (11am - 2pm)\nPlease enter Oven alarm time\nHour: ");
                                    ovenLunchAlarmHour = Integer.parseInt(ovenLunchAlarmString);
                                }

                                String ovenLunchAlarmString1;
                                ovenLunchAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (00 - 60)\nHour: " + ovenLunchAlarmHour + morningAfternoon + "\nPlease enter Oven alarm time\nMinutes: ");
                                ovenLunchAlarmMinute = Integer.parseInt(ovenLunchAlarmString1);

                                while (ovenLunchAlarmMinute > 60.00) {
                                    ovenLunchAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (00 - 60)\nHour: " + ovenLunchAlarmHour + morningAfternoon + "\nPlease enter Oven alarm time\nMinutes: ");
                                    ovenLunchAlarmMinute = Integer.parseInt(ovenLunchAlarmString1);
                                }
                                while (ovenLunchAlarmMinute < 00.00) {
                                    ovenLunchAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (00 - 60)\nHour: " + ovenLunchAlarmHour + morningAfternoon + "\nPlease enter Oven alarm time\nMinutes: ");
                                    ovenLunchAlarmMinute = Integer.parseInt(ovenLunchAlarmString1);
                                }

                                ovenAlarmLunch = ovenLunchAlarmMinute / 100;
                                ovenAlarmLunch = ovenAlarmLunch + ovenLunchAlarmHour;

                                //Dinner
                                String ovenDinnerInputString;
                                ovenDinnerInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nDinner:\n1) Roast Pork & Veggies.\n2) Lasagna.\n3) Smoked Mackerel");
                                ovenDinnerInput = Integer.parseInt(ovenDinnerInputString);

                                while (ovenDinnerInput > 3) {
                                    ovenDinnerInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nDinner:\n1) Roast Pork & Veggies.\n2) Lasagna.\n3) Smoked Mackerel");
                                    ovenDinnerInput = Integer.parseInt(ovenDinnerInputString);
                                }

                                if (ovenDinnerInput == 1) {
                                    //1
                                    dinnerMode = "Roast Pork + Veggies";
                                } else if (ovenDinnerInput == 2) {
                                    //2
                                    dinnerMode = "Lasagna";
                                } else if (ovenDinnerInput == 3) {
                                    //3
                                    dinnerMode = "Smoked Mackerel";
                                }

                                String ovenDinnerAlarmString;
                                ovenDinnerAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (6pm - 9pm)\nPlease enter Oven alarm time\nHour: ");
                                ovenDinnerAlarmHour = Integer.parseInt(ovenDinnerAlarmString);

                                if (ovenDinnerAlarmHour == 6) {
                                    ovenDinnerAlarmHour = 18;
                                } else if (ovenDinnerAlarmHour == 7) {
                                    ovenDinnerAlarmHour = 19;
                                } else if (ovenDinnerAlarmHour == 8) {
                                    ovenDinnerAlarmHour = 20;
                                } else if (ovenDinnerAlarmHour == 9) {
                                    ovenDinnerAlarmHour = 21;
                                }

                                while (ovenDinnerAlarmHour > 21) {
                                    ovenDinnerAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (6pm - 9pm)\nPlease enter Oven alarm time\nHour: ");
                                    ovenDinnerAlarmHour = Integer.parseInt(ovenDinnerAlarmString);
                                }
                                while (ovenDinnerAlarmHour < 18) {
                                    ovenDinnerAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (6pm - 9pm)\nPlease enter Oven alarm time\nHour: ");
                                    ovenDinnerAlarmHour = Integer.parseInt(ovenDinnerAlarmString);
                                }

                                String ovenDinnerAlarmString1;
                                ovenDinnerAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (00 - 60)\nHour: " + ovenDinnerAlarmHour + "pm\nPlease enter Oven alarm time\nMinutes: ");
                                ovenDinnerAlarmMinute = Integer.parseInt(ovenDinnerAlarmString1);

                                while (ovenDinnerAlarmMinute > 60.00) {
                                    ovenDinnerAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (00 - 60)\nHour: " + ovenDinnerAlarmHour + "pm\nPlease enter Oven alarm time\nMinutes: ");
                                    ovenDinnerAlarmMinute = Integer.parseInt(ovenDinnerAlarmString1);
                                }
                                while (ovenDinnerAlarmMinute < 00.00) {
                                    ovenDinnerAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (00 - 60)\nHour: " + ovenDinnerAlarmHour + "pm\nPlease enter Oven alarm time\nMinutes: ");
                                    ovenDinnerAlarmMinute = Integer.parseInt(ovenDinnerAlarmString1);
                                }

                                ovenAlarmDinner = ovenDinnerAlarmMinute / 100;
                                ovenAlarmDinner = ovenAlarmDinner + ovenDinnerAlarmHour;

                                //Display oven items
                                JOptionPane.showMessageDialog(null, "Morning breakfast: " + morningMode + "\nReady at: " + ovenAlarmMorning + "am" + "\nLunch: " + lunchMode + "\nReady at: " + ovenAlarmLunch + morningAfternoon + "\nDinner: " + dinnerMode + "\nReady at: " + ovenAlarmDinner + "pm");

                            }

                        } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");

                            //Morning
                            String ovenMorningInputString;
                            ovenMorningInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nMorning:\n1) Pancakes.\n2) Toast.\n3) Eggs and Bacon");
                            ovenMorningInput = Integer.parseInt(ovenMorningInputString);

                            while (ovenMorningInput > 3) {
                                ovenMorningInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nMorning:\n1) Pancakes.\n2) Toast.\n3) Eggs and Bacon");
                                ovenMorningInput = Integer.parseInt(ovenMorningInputString);
                            }

                            if (ovenMorningInput == 1) {
                                //1
                                morningMode = "Pancakes";
                            } else if (ovenMorningInput == 2) {
                                //2
                                morningMode = "Toast";
                            } else if (ovenMorningInput == 3) {
                                //3
                                morningMode = "Eggs and Bacon";
                            }

                            String ovenMorningAlarmString;
                            ovenMorningAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (6am - 9am)\nPlease enter Oven alarm time\nHour: ");
                            ovenMorningAlarmHour = Integer.parseInt(ovenMorningAlarmString);

                            while (ovenMorningAlarmHour > 9) {
                                ovenMorningAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (6am - 9am)\nPlease enter Oven alarm time\nHour: ");
                                ovenMorningAlarmHour = Integer.parseInt(ovenMorningAlarmString);
                            }
                            while (ovenMorningAlarmHour < 6) {
                                ovenMorningAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (6am - 9am)\nPlease enter Oven alarm time\nHour: ");
                                ovenMorningAlarmHour = Integer.parseInt(ovenMorningAlarmString);
                            }

                            String ovenMorningAlarmString1;
                            ovenMorningAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (00 - 60)\nHour: " + ovenMorningAlarmHour + "am\nPlease enter Oven alarm time\nMinutes: ");
                            ovenMorningAlarmMinute = Integer.parseInt(ovenMorningAlarmString1);

                            while (ovenMorningAlarmMinute > 60.00) {
                                ovenMorningAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (00 - 60)\nHour: " + ovenMorningAlarmHour + "am\nPlease enter Oven alarm time\nMinutes: ");
                                ovenMorningAlarmMinute = Integer.parseInt(ovenMorningAlarmString1);
                            }
                            while (ovenMorningAlarmMinute < 00.00) {
                                ovenMorningAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + morningMode + " to be ready. (00 - 60)\nHour: " + ovenMorningAlarmHour + "am\nPlease enter Oven alarm time\nMinutes: ");
                                ovenMorningAlarmMinute = Integer.parseInt(ovenMorningAlarmString1);
                            }

                            ovenAlarmMorning = ovenMorningAlarmMinute / 100;
                            ovenAlarmMorning = ovenAlarmMorning + ovenMorningAlarmHour;

                            //Lunch
                            String ovenLunchInputString;
                            ovenLunchInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nLunch:\n1) Muffins.\n2) Toasted Sandwich.\n3) Chicken and Rice Salad");
                            ovenLunchInput = Integer.parseInt(ovenLunchInputString);

                            while (ovenLunchInput > 3) {
                                ovenLunchInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nLunch:\n1) Muffins.\n2) Toasted Sandwich.\n3) Chicken and Rice Salad");
                                ovenLunchInput = Integer.parseInt(ovenLunchInputString);
                            }

                            if (ovenLunchInput == 1) {
                                //1
                                lunchMode = "Muffins";
                            } else if (ovenLunchInput == 2) {
                                //2
                                lunchMode = "Toasted Sandwich";
                            } else if (ovenLunchInput == 3) {
                                //3
                                lunchMode = "Chicken and Rice Salad";
                            }

                            String ovenLunchAlarmString;
                            ovenLunchAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (11am - 2pm)\nPlease enter Oven alarm time\nHour: ");
                            ovenLunchAlarmHour = Integer.parseInt(ovenLunchAlarmString);
                            morningAfternoon = "am";

                            if (ovenLunchAlarmHour == 1) {
                                ovenLunchAlarmHour = 13;
                                morningAfternoon = "pm";
                            } else if (ovenLunchAlarmHour == 2) {
                                ovenLunchAlarmHour = 14;
                                morningAfternoon = "pm";
                            } else if (ovenLunchAlarmHour == 12) {
                                morningAfternoon = "pm";
                            }

                            while (ovenLunchAlarmHour > 14) {
                                ovenLunchAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (11am - 2pm)\nPlease enter Oven alarm time\nHour: ");
                                ovenLunchAlarmHour = Integer.parseInt(ovenLunchAlarmString);
                            }
                            while (ovenLunchAlarmHour < 11) {
                                ovenLunchAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (11am - 2pm)\nPlease enter Oven alarm time\nHour: ");
                                ovenLunchAlarmHour = Integer.parseInt(ovenLunchAlarmString);
                            }

                            String ovenLunchAlarmString1;
                            ovenLunchAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (00 - 60)\nHour: " + ovenLunchAlarmHour + morningAfternoon + "\nPlease enter Oven alarm time\nMinutes: ");
                            ovenLunchAlarmMinute = Integer.parseInt(ovenLunchAlarmString1);

                            while (ovenLunchAlarmMinute > 60.00) {
                                ovenLunchAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (00 - 60)\nHour: " + ovenLunchAlarmHour + morningAfternoon + "\nPlease enter Oven alarm time\nMinutes: ");
                                ovenLunchAlarmMinute = Integer.parseInt(ovenLunchAlarmString1);
                            }
                            while (ovenLunchAlarmMinute < 00.00) {
                                ovenLunchAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + lunchMode + " to be ready. (00 - 60)\nHour: " + ovenLunchAlarmHour + morningAfternoon + "\nPlease enter Oven alarm time\nMinutes: ");
                                ovenLunchAlarmMinute = Integer.parseInt(ovenLunchAlarmString1);
                            }

                            ovenAlarmLunch = ovenLunchAlarmMinute / 100;
                            ovenAlarmLunch = ovenAlarmLunch + ovenLunchAlarmHour;

                            //Dinner
                            String ovenDinnerInputString;
                            ovenDinnerInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nDinner:\n1) Roast Pork & Veggies.\n2) Lasagna.\n3) Smoked Mackerel");
                            ovenDinnerInput = Integer.parseInt(ovenDinnerInputString);

                            while (ovenDinnerInput > 3) {
                                ovenDinnerInputString = JOptionPane.showInputDialog("Please Follow and Select options to configure Smart Oven below.\nDinner:\n1) Roast Pork & Veggies.\n2) Lasagna.\n3) Smoked Mackerel");
                                ovenDinnerInput = Integer.parseInt(ovenDinnerInputString);
                            }

                            if (ovenDinnerInput == 1) {
                                //1
                                dinnerMode = "Roast Pork + Veggies";
                            } else if (ovenDinnerInput == 2) {
                                //2
                                dinnerMode = "Lasagna";
                            } else if (ovenDinnerInput == 3) {
                                //3
                                dinnerMode = "Smoked Mackerel";
                            }

                            String ovenDinnerAlarmString;
                            ovenDinnerAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (6pm - 9pm)\nPlease enter Oven alarm time\nHour: ");
                            ovenDinnerAlarmHour = Integer.parseInt(ovenDinnerAlarmString);

                            if (ovenDinnerAlarmHour == 6) {
                                ovenDinnerAlarmHour = 18;
                            } else if (ovenDinnerAlarmHour == 7) {
                                ovenDinnerAlarmHour = 19;
                            } else if (ovenDinnerAlarmHour == 8) {
                                ovenDinnerAlarmHour = 20;
                            } else if (ovenDinnerAlarmHour == 9) {
                                ovenDinnerAlarmHour = 21;
                            }

                            while (ovenDinnerAlarmHour > 21) {
                                ovenDinnerAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (6pm - 9pm)\nPlease enter Oven alarm time\nHour: ");
                                ovenDinnerAlarmHour = Integer.parseInt(ovenDinnerAlarmString);
                            }
                            while (ovenDinnerAlarmHour < 18) {
                                ovenDinnerAlarmString = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (6pm - 9pm)\nPlease enter Oven alarm time\nHour: ");
                                ovenDinnerAlarmHour = Integer.parseInt(ovenDinnerAlarmString);
                            }

                            String ovenDinnerAlarmString1;
                            ovenDinnerAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (00 - 60)\nHour: " + ovenDinnerAlarmHour + "pm\nPlease enter Oven alarm time\nMinutes: ");
                            ovenDinnerAlarmMinute = Integer.parseInt(ovenDinnerAlarmString1);

                            while (ovenDinnerAlarmMinute > 60.00) {
                                ovenDinnerAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (00 - 60)\nHour: " + ovenDinnerAlarmHour + "pm\nPlease enter Oven alarm time\nMinutes: ");
                                ovenDinnerAlarmMinute = Integer.parseInt(ovenDinnerAlarmString1);
                            }
                            while (ovenDinnerAlarmMinute < 00.00) {
                                ovenDinnerAlarmString1 = JOptionPane.showInputDialog("Enter Time you'd like the " + dinnerMode + " to be ready. (00 - 60)\nHour: " + ovenDinnerAlarmHour + "pm\nPlease enter Oven alarm time\nMinutes: ");
                                ovenDinnerAlarmMinute = Integer.parseInt(ovenDinnerAlarmString1);
                            }

                            ovenAlarmDinner = ovenDinnerAlarmMinute / 100;
                            ovenAlarmDinner = ovenAlarmDinner + ovenDinnerAlarmHour;

                            //Display oven items
                            JOptionPane.showMessageDialog(null, "Morning breakfast: " + morningMode + "\nReady at: " + ovenAlarmMorning + "am" + "\nLunch: " + lunchMode + "\nReady at: " + ovenAlarmLunch + morningAfternoon + "\nDinner: " + dinnerMode + "\nReady at: " + ovenAlarmDinner + "pm");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "KITCHEN";
                        saveOven(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton kitchenKettle = new JButton("Kettle");
        kitchenKettle.setPreferredSize(new Dimension(160, 80));
        kitchenKettle.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileName9 = "ConfigFiles/kettleConfig.txt";
        File file9 = new File(fileName9);
        try {
            Scanner inputStream = new Scanner(file9);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    kitchenKettle.setBackground(Color.gray);
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    kitchenKettle.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card4.add(kitchenKettle);
        kitchenKettle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/kettleConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                            String continueSetUp;
                            continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                            continueSetUp = continueSetUp.toUpperCase();
                            if (continueSetUp.equals("Y")) {
                                String kettleAlarmString;
                                kettleAlarmString = JOptionPane.showInputDialog("Enter either; 1 or 2 below \n1) Auto Boil - Kettle turns ON when you walk into kitchen.\n2) Manual Boil - Kettle turns ON when you want it to.");
                                kettleAlarm = Integer.parseInt(kettleAlarmString);

                                while (kettleAlarm > 2) {
                                    kettleAlarmString = JOptionPane.showInputDialog("Enter either; 1 or 2 below \n1) Auto Boil - Kettle turns ON when you walk into kitchen.\n2) Manual Boil - Kettle turns ON when you want it to.");
                                    kettleAlarm = Integer.parseInt(kettleAlarmString);
                                }

                                if (kettleAlarm == 1) {
                                    //1 Water - 6:00pm
                                    kettleMode = "Auto Boil";
                                } else if (kettleAlarm == 2) {
                                    //2 Water - 9:00am / 6:00pm
                                    kettleMode = "Manual Boil";
                                }

                                JOptionPane.showMessageDialog(null, "The Kitchen Kettle has been set to: " + kettleMode);

                            }

                        } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");

                            String kettleAlarmString;
                            kettleAlarmString = JOptionPane.showInputDialog("Enter either; 1 or 2 below \n1) Auto Boil - Kettle turns ON when you walk into kitchen.\n2) Manual Boil - Kettle turns ON when you want it to.");
                            kettleAlarm = Integer.parseInt(kettleAlarmString);

                            while (kettleAlarm > 2) {
                                kettleAlarmString = JOptionPane.showInputDialog("Enter either; 1 or 2 below \n1) Auto Boil - Kettle turns ON when you walk into kitchen.\n2) Manual Boil - Kettle turns ON when you want it to.");
                                kettleAlarm = Integer.parseInt(kettleAlarmString);
                            }

                            if (kettleAlarm == 1) {
                                //1 Water - 6:00pm
                                kettleMode = "Auto Boil";
                            } else if (kettleAlarm == 2) {
                                //2 Water - 9:00am / 6:00pm
                                kettleMode = "Manual Boil";
                            }

                            JOptionPane.showMessageDialog(null, "The Kitchen Kettle has been set to: " + kettleMode);
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "KITCHEN";
                        saveKettle(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton kitchenCoffee = new JButton("Coffee Machine");
        kitchenCoffee.setPreferredSize(new Dimension(160, 80));
        kitchenCoffee.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileName10 = "ConfigFiles/coffeeMachineConfig.txt";
        File file10 = new File(fileName10);
        try {
            Scanner inputStream = new Scanner(file10);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    kitchenCoffee.setBackground(Color.gray);
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    kitchenCoffee.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card4.add(kitchenCoffee);
        kitchenCoffee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/coffeeMachineConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                            String continueSetUp;
                            continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                            continueSetUp = continueSetUp.toUpperCase();
                            if (continueSetUp.equals("Y")) {

                            }

                        } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");

                            String coffeeMachineString;
                            coffeeMachineString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below\n1) Coffee Addiction - Wakes you up to the smell of fresh coffee; every morning.\n2) All day Coffee - Prepares; Breakfast, Lunch, Afternoon coffee.\n3) Fresh Blend - Starts making coffee when you enter Kitchen; During specified times.");
                            coffeeMachineInput = Integer.parseInt(coffeeMachineString);

                            //Makes sure use inputs are in range
                            while (coffeeMachineInput > 3) {
                                coffeeMachineString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below\n1) Coffee Addiction - Wakes you up to the smell of fresh coffee; every morning.\n2) All day Coffee - Prepares; Breakfast, Lunch, Afternoon coffee.\n3) Fresh Blend - Starts making coffee when you enter Kitchen; During specified times.");
                                coffeeMachineInput = Integer.parseInt(coffeeMachineString);
                            }

                            if (coffeeMachineInput == 1) {
                                coffeMachineMode = "Coffee Addiction";
                            } else if (coffeeMachineInput == 2) {
                                coffeMachineMode = "All day Coffee";
                            } else if (coffeeMachineInput == 3) {
                                coffeMachineMode = "Fresh Blend";
                            }

                            JOptionPane.showMessageDialog(null, "The Kitchen Coffee Machine has been set to: " + coffeMachineMode);
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "KITCHEN";
                        saveCoffeeMachine(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //GARAGE
        JPanel card5 = new JPanel();
        card5.setBackground(Color.lightGray);
        card5.setBorder(new BasicBorders.ToggleButtonBorder(Color.white, Color.gray, Color.darkGray, Color.black));
        JButton garageMotionSensor = new JButton("Motion Sensors");
        garageMotionSensor.setPreferredSize(new Dimension(160, 80));
        garageMotionSensor.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                    garageMotionSensor.setBackground(Color.green);
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    garageMotionSensor.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card5.add(garageMotionSensor);
        garageMotionSensor.addActionListener(new ActionListener() {
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
                        if (values[0].equals("GARAGE") && values[2].equals("ON")) {
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

                        } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
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
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
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
                        String roomName = "GARAGE";
                        saveMotionSensor(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton garageLights = new JButton("Lights");
        garageLights.setPreferredSize(new Dimension(160, 80));
        garageLights.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                    garageLights.setBackground(Color.green);
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    garageLights.setBackground(Color.gray);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card5.add(garageLights);
        garageLights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/lightConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                            displayLine5 = data.split(", ");
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
                                JOptionPane.showMessageDialog(null, "The Garage Lights have been set to: " + livingRoomLightMode);
                            }

                        } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                            displayLine5 = data.split(", ");

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
                                JOptionPane.showMessageDialog(null, "The Garage Lights have been set to: " + livingRoomLightMode);
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
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
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
                        String roomName = "GARAGE";
                        saveLights(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton garageGarage = new JButton("Garage Door");
        garageGarage.setPreferredSize(new Dimension(160, 80));
        garageGarage.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileGarageDoor = "ConfigFiles\\garageDoorConfig.txt";
        File file5 = new File(fileGarageDoor);
        try {
            Scanner inputStream = new Scanner(file5);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                    garageGarage.setBackground(Color.green);
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    garageGarage.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        card5.add(garageGarage);
        garageGarage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles\\garageDoorConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                            String continueSetUp;
                            continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                            continueSetUp = continueSetUp.toUpperCase();
                            if (continueSetUp.equals("Y")) {
                                String garageDoorInputString;
                                garageDoorInputString = JOptionPane.showInputDialog("Enter below \nTurn on Security Lock for Garage Door? \n1) - Yes \n2) - No.");
                                garageDoorLightsInput = Integer.parseInt(garageDoorInputString);

                                while (garageDoorLightsInput > 2) {
                                    garageDoorInputString = JOptionPane.showInputDialog("Enter below \nTurn on Security Lock for Garage Door? \n1) - Yes \n2) - No.");
                                    garageDoorLightsInput = Integer.parseInt(garageDoorInputString);
                                }
                            }

                        } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");

                            String garageDoorInputString;
                            garageDoorInputString = JOptionPane.showInputDialog("Enter below \nTurn on Security Lock for Garage Door? \n1) - Yes \n2) - No.");
                            garageDoorLightsInput = Integer.parseInt(garageDoorInputString);

                            while (garageDoorLightsInput > 2) {
                                garageDoorInputString = JOptionPane.showInputDialog("Enter below \nTurn on Security Lock for Garage Door? \n1) - Yes \n2) - No.");
                                garageDoorLightsInput = Integer.parseInt(garageDoorInputString);
                            }

                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "GARAGE";
                        saveGarageDoor(roomName);
                    }
                    inputStream.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton garageCar = new JButton("Car");
        garageCar.setPreferredSize(new Dimension(160, 80));
        garageCar.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileName7 = "ConfigFiles\\carConfig.txt";
        File file7 = new File(fileName7);
        try {
            Scanner inputStream = new Scanner(file7);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                    garageCar.setBackground(Color.green);
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    garageCar.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        card5.add(garageCar);
        garageCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles\\carConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                            String continueSetUp;
                            continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                            continueSetUp = continueSetUp.toUpperCase();
                            if (continueSetUp.equals("Y")) {

                            }
                        } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");

                            String garageCarInputString;
                            garageCarInputString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below.\n1) Auto Start - Warms up engine before you enter Garage.\n2) Economy Start - Car Starts up when you enter Garage.\n3) Manual Start - Car won't start when enter Garage.");
                            garageCarLightsInput = Integer.parseInt(garageCarInputString);

                            while (garageCarLightsInput > 3) {
                                garageCarInputString = JOptionPane.showInputDialog("1) Auto Start - Warms up engine before you enter Garage.\n2) Economy Start - Car Starts up when you enter Garage.\n3) Manual Start - Car won't start when enter Garage.");
                                garageCarLightsInput = Integer.parseInt(garageCarInputString);
                            }

                            if (garageCarLightsInput == 1) {
                                //1 Water - 6:00pm
                                carMode = "Auto Start";
                            } else if (garageCarLightsInput == 2) {
                                //2 Water - 9:00am / 6:00pm
                                carMode = "Economy Start";
                            } else if (garageCarLightsInput == 3) {
                                //3 Water - 9:00am / 6:00pm / 2:00am
                                carMode = "Manual Start";
                            }

                            JOptionPane.showMessageDialog(null, "The Garage Car has been set to: " + carMode);

                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "GARAGE";
                        saveCar(roomName);
                    }
                    inputStream.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });


        //GARDEN
        JPanel card6 = new JPanel();
        card6.setBackground(Color.lightGray);
        card6.setBorder(new BasicBorders.ToggleButtonBorder(Color.white, Color.gray, Color.darkGray, Color.black));
        JButton gardenMotionSensor = new JButton("Motion Sensors");
        gardenMotionSensor.setPreferredSize(new Dimension(160, 80));
        gardenMotionSensor.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARDEN") && values[2].equals("ON")) {
                    gardenMotionSensor.setBackground(Color.green);
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    gardenMotionSensor.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card6.add(gardenMotionSensor);
        gardenMotionSensor.addActionListener(new ActionListener() {
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
                        if (values[0].equals("GARDEN") && values[2].equals("ON")) {
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

                        } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
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
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "GARDEN";
                        saveMotionSensor(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton gardenMotionLights = new JButton("Lights");
        gardenMotionLights.setPreferredSize(new Dimension(160, 80));
        gardenMotionLights.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARDEN") && values[2].equals("ON")) {
                    gardenMotionLights.setBackground(Color.green);
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    gardenMotionLights.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card6.add(gardenMotionLights);
        gardenMotionLights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileName = "ConfigFiles/lightConfig.txt";
                File file = new File(fileName);
                try {
                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("GARDEN") && values[2].equals("ON")) {
                            displayLine6 = data.split(", ");
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
                                JOptionPane.showMessageDialog(null, "The Garden Lights have been set to: " + livingRoomLightMode);
                            }

                        } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                            displayLine6 = data.split(", ");

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
                                JOptionPane.showMessageDialog(null, "The Garden Lights have been set to: " + livingRoomLightMode);
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
                        if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                            displayLine1 = data.split(", ");
                        } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "GARDEN";
                        saveLights(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton gardenMotionSprinklers = new JButton("Sprinklers");
        gardenMotionSprinklers.setPreferredSize(new Dimension(160, 80));
        gardenMotionSprinklers.setBorder(new BasicBorders.ToggleButtonBorder(Color.darkGray, Color.black, Color.lightGray, Color.white));

        String fileSprinklers = "ConfigFiles/sprinklerConfig.txt";
        File file6 = new File(fileSprinklers);
        try {
            Scanner inputStream = new Scanner(file6);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARDEN") && values[2].equals("ON")) {
                    gardenMotionSprinklers.setBackground(Color.green);
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    gardenMotionSprinklers.setBackground(Color.gray);
                }
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card6.add(gardenMotionSprinklers);
        gardenMotionSprinklers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display rooms status
                String fileSprinklers1 = "ConfigFiles/sprinklerConfig.txt";
                File file21 = new File(fileSprinklers1);
                try {
                    Scanner inputStream = new Scanner(file21);
                    while (inputStream.hasNext()) {
                        data = inputStream.nextLine();
                        values = data.split(",");
                        if (values[0].equals("GARDEN") && values[2].equals("ON")) {
                            displayLine1 = data.split("S, ");
                            String continueSetUp;
                            continueSetUp = JOptionPane.showInputDialog("Already Set Up! Do you wish to edit? Y / N");
                            continueSetUp = continueSetUp.toUpperCase();
                            if (continueSetUp.equals("Y")) {
                                String sprinklerInputString;
                                sprinklerInputString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below.\n1) Extreme Water Saver Mode - Waters Garden Once a Day.\n2) Water Saver Mode - Waters Garden Twice a Day.\n3) Full Flow Mode - Waters Garden Three times a Day.");
                                sprinklerInput = Integer.parseInt(sprinklerInputString);

                                //Makes sure use inputs are in range
                                while (sprinklerInput > 3) {
                                    sprinklerInputString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below.\n1) Extreme Water Saver Mode - Waters Garden Once a Day.\n2) Water Saver Mode - Waters Garden Twice a Day.\n3) Full Flow Mode - Waters Garden Three times a Day.");
                                    sprinklerInput = Integer.parseInt(sprinklerInputString);
                                }

                                if (sprinklerInput == 1) {
                                    //1 Water - 6:00pm
                                    sprinklerMode = "Extreme Water Saver Mode";
                                } else if (sprinklerInput == 2) {
                                    //2 Water - 9:00am / 6:00pm
                                    sprinklerMode = "Water Saver Mode";
                                } else if (sprinklerInput == 3) {
                                    //3 Water - 9:00am / 6:00pm / 2:00am
                                    sprinklerMode = "Full Flow Mode";
                                }

                                JOptionPane.showMessageDialog(null, "The Garden Sprinklers has been set to: " + sprinklerMode);
                            }

                        } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                            displayLine1 = data.split(", ");

                            String sprinklerInputString;
                            sprinklerInputString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below.\n1) Extreme Water Saver Mode - Waters Garden Once a Day.\n2) Water Saver Mode - Waters Garden Twice a Day.\n3) Full Flow Mode - Waters Garden Three times a Day.");
                            sprinklerInput = Integer.parseInt(sprinklerInputString);

                            //Makes sure use inputs are in range
                            while (sprinklerInput > 3) {
                                sprinklerInputString = JOptionPane.showInputDialog("Enter either; 1, 2 or 3 below.\n1) Extreme Water Saver Mode - Waters Garden Once a Day.\n2) Water Saver Mode - Waters Garden Twice a Day.\n3) Full Flow Mode - Waters Garden Three times a Day.");
                                sprinklerInput = Integer.parseInt(sprinklerInputString);
                            }

                            if (sprinklerInput == 1) {
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                            } else if (sprinklerInput == 2) {
                                //2 Water - 9:00am / 6:00pm
                                sprinklerMode = "Water Saver Mode";
                            } else if (sprinklerInput == 3) {
                                //3 Water - 9:00am / 6:00pm / 2:00am
                                sprinklerMode = "Full Flow Mode";
                            }

                            JOptionPane.showMessageDialog(null, "The Garden Sprinklers has been set to: " + sprinklerMode);
                        }
                    }
                    int yesValue = JOptionPane.showConfirmDialog(null, "Save Changes");
                    if (yesValue == 0) {
                        //save
                        String roomName = "GARDEN";
                        saveSprinkler(roomName);
                    }
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

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

    private void saveLights(String roomName) throws FileNotFoundException {

        //saves to user chosen room
        Devices lightTemp = new Devices();
        lightTemp.setLightTemp(livingRoomLightsInput);

        //Add to a list to be called in sim
        switch (roomName) {
            case "LIVING ROOM": {
                Devices location = new Devices();
                location.setLocation("LIVING ROOM");
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                //Location
                list.add(new Devices.allLights(Devices.getLocation()));
                //Device
                list.add(new Devices.allLights("Light"));
                //Calibration
                list.add(new Devices.allLights("ON"));
                //User Settings
                list.add(new Devices.allLights(String.valueOf(lightTemp.getLightTemp())));
                //Set list
                allLights.setListLights(list);

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
                JOptionPane.showMessageDialog(null, updatedList + "\nThe Living Room Lights has been set to: " + livingRoomLightMode);
                break;
            }
            case "MAIN BEDROOM": {
                Devices location = new Devices();
                location.setLocation("MAIN BEDROOM");
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                //Location
                list.add(new Devices.allLights(Devices.getLocation()));
                //Device
                list.add(new Devices.allLights("Light"));
                //Calibration
                list.add(new Devices.allLights("ON"));
                //User Settings
                list.add(new Devices.allLights(String.valueOf(lightTemp.getLightTemp())));
                //Set list
                allLights.setListLights(list);

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
                JOptionPane.showMessageDialog(null, updatedList1 + "\nThe Living Room Lights has been set to: " + livingRoomLightMode);
                break;
            }
            case "SECOND BEDROOM": {
                Devices location = new Devices();
                location.setLocation("SECOND BEDROOM");
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                //Location
                list.add(new Devices.allLights(Devices.getLocation()));
                //Device
                list.add(new Devices.allLights("Light"));
                //Calibration
                list.add(new Devices.allLights("ON"));
                //User Settings
                list.add(new Devices.allLights(String.valueOf(lightTemp.getLightTemp())));
                //Set list
                allLights.setListLights(list);

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

                JOptionPane.showMessageDialog(null, updatedList2 + "\nThe Living Room Lights has been set to: " + livingRoomLightMode);

                break;
            }
            case "KITCHEN": {
                Devices location = new Devices();
                location.setLocation("KITCHEN");
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                //Location
                list.add(new Devices.allLights(Devices.getLocation()));
                //Device
                list.add(new Devices.allLights("Light"));
                //Calibration
                list.add(new Devices.allLights("ON"));
                //User Settings
                list.add(new Devices.allLights(String.valueOf(lightTemp.getLightTemp())));
                //Set list
                allLights.setListLights(list);

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

                JOptionPane.showMessageDialog(null, updatedList3 + "\nThe Living Room Lights has been set to: " + livingRoomLightMode);
                break;
            }
            case "GARAGE": {
                Devices location = new Devices();
                location.setLocation("GARAGE");
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                //Location
                list.add(new Devices.allLights(Devices.getLocation()));
                //Device
                list.add(new Devices.allLights("Light"));
                //Calibration
                list.add(new Devices.allLights("ON"));
                //User Settings
                list.add(new Devices.allLights(String.valueOf(lightTemp.getLightTemp())));
                //Set list
                allLights.setListLights(list);

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

                JOptionPane.showMessageDialog(null, updatedList4 + "\nThe Living Room Lights has been set to: " + livingRoomLightMode);
                break;
            }
            case "GARDEN": {
                Devices location = new Devices();
                location.setLocation("GARDEN");
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                //Location
                list.add(new Devices.allLights(Devices.getLocation()));
                //Device
                list.add(new Devices.allLights("Light"));
                //Calibration
                list.add(new Devices.allLights("ON"));
                //User Settings
                list.add(new Devices.allLights(String.valueOf(lightTemp.getLightTemp())));
                //Set list
                allLights.setListLights(list);

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

                JOptionPane.showMessageDialog(null, updatedList5 + "\nThe Living Room Lights has been set to: " + livingRoomLightMode);
                break;
            }
        }
        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles\\lightConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        //x1 = insert full updated list here
        sb.append(x1).append("\n");
        sb.append(System.lineSeparator());
        //x2 = insert full updated list here
        sb.append(x2).append("\n");
        sb.append(System.lineSeparator());
        //x3 = insert full updated list here
        sb.append(x3).append("\n");
        sb.append(System.lineSeparator());
        //x4 = insert full updated list here
        sb.append(x4).append("\n");
        sb.append(System.lineSeparator());
        //x5 = insert full updated list here
        sb.append(x5).append("\n");
        sb.append(System.lineSeparator());
        //x6 = insert full updated list here
        sb.append(x6).append("\n");


        try {
            Files.write(Paths.get("ConfigFiles\\lightConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void saveAirCon(String roomName) throws FileNotFoundException {
        //saves to user chosen room
        Devices acTemp = new Devices();
        acTemp.setAcTemp(livingRoomAirConInput);

        //Add to a list to be called in sim
        switch (roomName) {
            case "LIVING ROOM": {
                Devices location = new Devices();
                location.setLocation("LIVING ROOM");
                Devices acList = new Devices();
                List<Devices.airConditioner> list = new ArrayList<>();
                //Location
                list.add(new Devices.airConditioner(Devices.getLocation()));
                //Device
                list.add(new Devices.airConditioner("Air Conditioner"));
                //Calibration
                list.add(new Devices.airConditioner("ON"));
                //User Settings
                list.add(new Devices.airConditioner(String.valueOf(acTemp.getAcTemp())));
                //Set list
                acList.setListAirCon(list);

                updatedList = list.toString();
                x1 = String.valueOf((updatedList));

                updatedList1 = Arrays.toString(displayLine2);
                x2 = String.valueOf((updatedList1));

                //Display The Change
                JOptionPane.showMessageDialog(null, updatedList + "\nThe Living Room Motion Sensor have been set to: " + livingRoomMotionSensorMode);
                break;
            }
            case "MAIN BEDROOM": {
                Devices location = new Devices();
                location.setLocation("MAIN BEDROOM");
                Devices acList = new Devices();
                List<Devices.airConditioner> list = new ArrayList<>();
                //Location
                list.add(new Devices.airConditioner(Devices.getLocation()));
                //Device
                list.add(new Devices.airConditioner("Air Conditioner"));
                //Calibration
                list.add(new Devices.airConditioner("ON"));
                //User Settings
                list.add(new Devices.airConditioner(String.valueOf(acTemp.getAcTemp())));
                //Set list
                acList.setListAirCon(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));

                updatedList1 = list.toString();
                x2 = String.valueOf((updatedList1));

                //Display The Change
                JOptionPane.showMessageDialog(null, updatedList1 + "\nThe Living Room Motion Sensor have been set to: " + livingRoomMotionSensorMode);
                break;
            }
        }

        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles/airConConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        //x1 = insert full updated list here
        sb.append(x1).append("\n");
        sb.append(System.lineSeparator());
        //x2 = insert full updated list here
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles/airConConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFan(String roomName) throws FileNotFoundException {
        //saves to user chosen room
        Devices ceilingFanTemp = new Devices();
        ceilingFanTemp.setCeilingFanTemp(livingRoomFanInput);

        //Add to a list to be called in sim
        switch (roomName) {
            case "LIVING ROOM": {
                Devices location = new Devices();
                location.setLocation("LIVING ROOM");
                Devices ceilingFanList = new Devices();
                List<Devices.ceilingFan> list = new ArrayList<>();
                //Location
                list.add(new Devices.ceilingFan(Devices.getLocation()));
                //Device
                list.add(new Devices.ceilingFan("Ceiling Fan"));
                //Calibration
                list.add(new Devices.ceilingFan("ON"));
                //User Settings
                list.add(new Devices.ceilingFan(String.valueOf(ceilingFanTemp.getCeilingFanTemp())));
                //Set list
                ceilingFanList.setListCeilingFan(list);

                updatedList = list.toString();
                x1 = String.valueOf((updatedList));

                updatedList1 = Arrays.toString(displayLine2);
                x2 = String.valueOf((updatedList1));

                updatedList2 = Arrays.toString(displayLine3);
                x3 = String.valueOf((updatedList2));

                //Display The Change
                JOptionPane.showMessageDialog(null, updatedList + "\nThe Living Room Motion Sensor have been set to: " + livingRoomMotionSensorMode);
                break;
            }
            case "MAIN BEDROOM": {
                Devices location = new Devices();
                location.setLocation("MAIN BEDROOM");
                Devices ceilingFanList = new Devices();
                List<Devices.ceilingFan> list = new ArrayList<>();
                //Location
                list.add(new Devices.ceilingFan(Devices.getLocation()));
                //Device
                list.add(new Devices.ceilingFan("Ceiling Fan"));
                //Calibration
                list.add(new Devices.ceilingFan("ON"));
                //User Settings
                list.add(new Devices.ceilingFan(String.valueOf(ceilingFanTemp.getCeilingFanTemp())));
                //Set list
                ceilingFanList.setListCeilingFan(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));

                updatedList1 = list.toString();
                x2 = String.valueOf((updatedList1));

                updatedList2 = Arrays.toString(displayLine3);
                x3 = String.valueOf((updatedList2));

                //Display The Change
                JOptionPane.showMessageDialog(null, updatedList1 + "\nThe Living Room Motion Sensor have been set to: " + livingRoomMotionSensorMode);
                break;
            }
            case "SECOND BEDROOM": {
                Devices location = new Devices();
                location.setLocation("SECOND BEDROOM");
                Devices ceilingFanList = new Devices();
                List<Devices.ceilingFan> list = new ArrayList<>();
                //Location
                list.add(new Devices.ceilingFan(Devices.getLocation()));
                //Device
                list.add(new Devices.ceilingFan("Ceiling Fan"));
                //Calibration
                list.add(new Devices.ceilingFan("ON"));
                //User Settings
                list.add(new Devices.ceilingFan(String.valueOf(ceilingFanTemp.getCeilingFanTemp())));
                //Set list
                ceilingFanList.setListCeilingFan(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));

                updatedList1 = Arrays.toString(displayLine2);
                x2 = String.valueOf((updatedList1));

                updatedList2 = list.toString();
                x3 = String.valueOf((updatedList2));
                break;
            }
        }

        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles/ceilingFanConfig.txt");
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

        try {
            Files.write(Paths.get("ConfigFiles/ceilingFanConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveTv(String roomName) throws FileNotFoundException {
        //saves to user chosen room
        Devices tvTimer = new Devices();
        tvTimer.setTvTimer(livingRoomTvOffTime);

        //Add to a list to be called in sim
        switch (roomName) {
            case "LIVING ROOM": {
                Devices location = new Devices();
                location.setLocation("LIVING ROOM");
                Devices roomTv = new Devices();
                List<Devices.roomTv> list = new ArrayList<>();
                //Location
                list.add(new Devices.roomTv(Devices.getLocation()));
                //Device
                list.add(new Devices.roomTv("TV"));
                //Calibration
                list.add(new Devices.roomTv("ON"));
                //User Settings
                list.add(new Devices.roomTv(String.valueOf(tvTimer.getTvTimer())));
                //Set list
                roomTv.setListRoomTv(list);

                updatedList = list.toString();
                x1 = String.valueOf((updatedList));

                updatedList1 = Arrays.toString(displayLine2);
                x2 = String.valueOf((updatedList1));

                //Display The Change
                JOptionPane.showMessageDialog(null, updatedList + "\nThe Living Room Motion Sensor have been set to: " + livingRoomMotionSensorMode);
                break;
            }
            case "MAIN BEDROOM": {
                Devices location = new Devices();
                location.setLocation("MAIN BEDROOM");
                Devices roomTv = new Devices();
                List<Devices.roomTv> list = new ArrayList<>();
                //Location
                list.add(new Devices.roomTv(Devices.getLocation()));
                //Device
                list.add(new Devices.roomTv("TV"));
                //Calibration
                list.add(new Devices.roomTv("ON"));
                //User Settings
                list.add(new Devices.roomTv(String.valueOf(tvTimer.getTvTimer())));
                //Set list
                roomTv.setListRoomTv(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));

                updatedList1 = list.toString();
                x2 = String.valueOf((updatedList1));

                //Display The Change
                JOptionPane.showMessageDialog(null, updatedList1 + "\nThe Living Room Motion Sensor have been set to: " + livingRoomMotionSensorMode);
                break;
            }
        }

        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles/tvConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        //x1 = insert full updated list here
        sb.append(x1).append("\n");
        sb.append(System.lineSeparator());
        //x2 = insert full updated list here
        sb.append(x2).append("\n");


        try {
            Files.write(Paths.get("ConfigFiles/tvConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveCar(String roomName) throws FileNotFoundException {
        //saves to user chosen room
        Devices tvTimer = new Devices();
        tvTimer.setTvTimer(garageCarLightsInput);

        //Add to a list to be called in sim
        switch (roomName) {
            case "LIVING ROOM": {
                Devices location = new Devices();
                location.setLocation("LIVING ROOM");
                Devices roomTv = new Devices();
                List<Devices.roomTv> list = new ArrayList<>();
                //Location
                list.add(new Devices.roomTv(Devices.getLocation()));
                //Device
                list.add(new Devices.roomTv("TV"));
                //Calibration
                list.add(new Devices.roomTv("ON"));
                //User Settings
                list.add(new Devices.roomTv(String.valueOf(tvTimer.getTvTimer())));
                //Set list
                roomTv.setListRoomTv(list);

                updatedList = list.toString();
                x1 = String.valueOf((updatedList));

                updatedList1 = Arrays.toString(displayLine2);
                x2 = String.valueOf((updatedList1));

                //Display The Change
                JOptionPane.showMessageDialog(null, updatedList + "\nThe Living Room Motion Sensor have been set to: " + livingRoomMotionSensorMode);
                break;
            }
        }
        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles/carConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        //x1 = insert full updated list here
        sb.append(x1).append("\n");
        sb.append(System.lineSeparator());
        //x2 = insert full updated list here
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles/carConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveGarageDoor(String roomName) throws FileNotFoundException {

        //saves to user chosen room
        Devices garageTemp = new Devices();
        garageTemp.setGarageTemp(garageDoorLightsInput);

        //Add to a list to be called in sim
        switch (roomName) {
            case "GARAGE": {
                Devices location = new Devices();
                location.setLocation("GARAGE");
                Devices garageDoorList = new Devices();
                List<Devices.garageDoor> list = new ArrayList<>();
                //Location
                list.add(new Devices.garageDoor(Devices.getLocation()));
                //Device
                list.add(new Devices.garageDoor("Garage Door"));
                //Calibration
                list.add(new Devices.garageDoor("ON"));
                //User Settings
                list.add(new Devices.garageDoor(String.valueOf(garageTemp.getGarageTemp())));
                //Set list
                garageDoorList.setListGarageDoor(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));
                break;
            }
        }

        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles/garageDoorConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        //x1 = insert full updated list here
        sb.append(x1).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles/garageDoorConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveSprinkler(String roomName) throws FileNotFoundException {
        //saves to user chosen room
        Devices sprinklerTemp = new Devices();
        sprinklerTemp.setSprinklerTemp(sprinklerInput);

        //Add to a list to be called in sim
        switch (roomName) {
            case "GARDEN": {
                Devices location = new Devices();
                location.setLocation("GARDEN");
                Devices gardenSprinkler = new Devices();
                List<Devices.gardenSprinkler> list = new ArrayList<>();
                //Location
                list.add(new Devices.gardenSprinkler(Devices.getLocation()));
                //Device
                list.add(new Devices.gardenSprinkler("Sprinkler"));
                //Calibration
                list.add(new Devices.gardenSprinkler("ON"));
                //User Settings
                list.add(new Devices.gardenSprinkler(String.valueOf(sprinklerTemp.getSprinklerTemp())));
                //Set list
                gardenSprinkler.setListGardenSprinkler(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));
                break;
            }
        }

        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles/sprinklerConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        //x1 = insert full updated list here
        sb.append(x1).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles/sprinklerConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAlarm(String roomName) throws FileNotFoundException {
        //saves to user chosen room
        Devices alarmClockTemp = new Devices();
        alarmClockTemp.setAlarmClockTemp(alarmClockTotal);

        //saves smart choice
        Devices alarmClockSmart = new Devices();
        alarmClockSmart.setAlarmClockSmart(smartAlarmInput);

        //Add to a list to be called in sim
        switch (roomName) {
            case "MAIN BEDROOM": {
                Devices location = new Devices();
                location.setLocation("MAIN BEDROOM");
                Devices roomAlarmClock = new Devices();
                List<Devices.roomAlarmClock> list = new ArrayList<>();
                //Location
                list.add(new Devices.roomAlarmClock(Devices.getLocation()));
                //Device
                list.add(new Devices.roomAlarmClock("Alarm Clock"));
                //Calibration
                list.add(new Devices.roomAlarmClock("ON"));
                //User Settings
                list.add(new Devices.roomAlarmClock(String.valueOf(alarmClockTemp.getAlarmClockTemp())));
                //Smart Settings
                list.add(new Devices.roomAlarmClock(String.valueOf(alarmClockSmart.getAlarmClockSmart())));
                //Set list
                roomAlarmClock.setListRoomAlarmClock(list);

                updatedList = list.toString();
                x1 = String.valueOf((updatedList));

                updatedList1 = Arrays.toString(displayLine2);
                x2 = String.valueOf((updatedList1));

                //Display The Change
                JOptionPane.showMessageDialog(null, updatedList1 + "\nThe Living Room Motion Sensor have been set to: " + livingRoomMotionSensorMode);
                break;
            }
            case "SECOND BEDROOM": {
                Devices location = new Devices();
                location.setLocation("SECOND BEDROOM");
                Devices roomAlarmClock = new Devices();
                List<Devices.roomAlarmClock> list = new ArrayList<>();
                //Location
                list.add(new Devices.roomAlarmClock(Devices.getLocation()));
                //Device
                list.add(new Devices.roomAlarmClock("Alarm Clock"));
                //Calibration
                list.add(new Devices.roomAlarmClock("ON"));
                //User Settings
                list.add(new Devices.roomAlarmClock(String.valueOf(alarmClockTemp.getAlarmClockTemp())));
                //Smart Settings
                list.add(new Devices.roomAlarmClock(String.valueOf(alarmClockSmart.getAlarmClockSmart())));
                //Set list
                roomAlarmClock.setListRoomAlarmClock(list);

                updatedList = Arrays.toString(displayLine1);
                x1 = String.valueOf((updatedList));

                updatedList1 = list.toString();
                x2 = String.valueOf((updatedList1));
                break;
            }
        }

        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles/alarmClockConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        //x1 = insert full updated list here
        sb.append(x1).append("\n");
        sb.append(System.lineSeparator());
        //x2 = insert full updated list here
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles/alarmClockConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveOven(String roomName) throws FileNotFoundException {
        //saves to user chosen room
        Devices kitchenOvenMorning = new Devices();
        kitchenOvenMorning.setKitchenOvenMorning(ovenAlarmMorning);

        Devices kitchenOvenOptionMorning = new Devices();
        kitchenOvenOptionMorning.setKitchenOvenOptionMorning(ovenMorningInput);

        Devices kitchenOvenLunch = new Devices();
        kitchenOvenLunch.setKitchenOvenLunch(ovenAlarmLunch);

        Devices kitchenOvenOptionLunch = new Devices();
        kitchenOvenOptionLunch.setKitchenOvenOptionLunch(ovenLunchInput);

        Devices kitchenOvenDinner = new Devices();
        kitchenOvenDinner.setKitchenOvenDinner(ovenAlarmDinner);

        Devices kitchenOvenOptionDinner = new Devices();
        kitchenOvenOptionDinner.setKitchenOvenOptionDinner(ovenDinnerInput);

        //Add to a list to be called in sim
        switch (roomName) {
            case "KITCHEN": {
                Devices location = new Devices();
                location.setLocation("KITCHEN");
                Devices kitchenOven = new Devices();
                List<Devices.kitchenOven> list = new ArrayList<>();
                //Location
                list.add(new Devices.kitchenOven(Devices.getLocation()));
                //Device
                list.add(new Devices.kitchenOven("Oven"));
                //Calibration
                list.add(new Devices.kitchenOven("ON"));
                //User Settings
                list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenMorning.getKitchenOvenMorning())));
                list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenOptionMorning.getKitchenOvenOptionMorning())));
                //User Settings
                list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenLunch.getKitchenOvenLunch())));
                list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenOptionLunch.getKitchenOvenOptionLunch())));
                //User Settings
                list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenDinner.getKitchenOvenDinner())));
                list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenOptionDinner.getKitchenOvenOptionDinner())));
                //Set list
                kitchenOven.setListKitchenOven(list);

                updatedList = list.toString();
                x1 = String.valueOf((updatedList));
                break;
            }
        }

        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles/ovenConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        //x1 = insert full updated list here
        sb.append(x1).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles/ovenConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveKettle(String roomName) throws FileNotFoundException {
        //saves to user chosen room
        Devices kettleTemp = new Devices();
        kettleTemp.setKettleTemp(kettleAlarm);

        //Add to a list to be called in sim
        switch (roomName) {
            case "KITCHEN": {
                Devices location = new Devices();
                location.setLocation("KITCHEN");
                Devices kitchenKettle = new Devices();
                List<Devices.kitchenKettle> list = new ArrayList<>();
                //Location
                list.add(new Devices.kitchenKettle(Devices.getLocation()));
                //Device
                list.add(new Devices.kitchenKettle("Kettle"));
                //Calibration
                list.add(new Devices.kitchenKettle("ON"));
                //User Settings
                list.add(new Devices.kitchenKettle(String.valueOf(kettleTemp.getKettleTemp())));
                //Set list
                kitchenKettle.setListKitchenKettle(list);

                updatedList = list.toString();
                x1 = String.valueOf((updatedList));
                break;
            }
        }

        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles/kettleConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        //x1 = insert full updated list here
        sb.append(x1).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles/kettleConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveCoffeeMachine(String roomName) throws FileNotFoundException {
        //saves to user chosen room
        Devices coffeeMachineTemp = new Devices();
        coffeeMachineTemp.setCoffeeMachineTemp(coffeeMachineInput);

        //Add to a list to be called in sim
        switch (roomName) {
            case "KITCHEN": {
                Devices location = new Devices();
                location.setLocation("KITCHEN");
                Devices kitchenCoffeeMachine = new Devices();
                List<Devices.kitchenCoffeeMachine> list = new ArrayList<>();
                //Location
                list.add(new Devices.kitchenCoffeeMachine(Devices.getLocation()));
                //Device
                list.add(new Devices.kitchenCoffeeMachine("Coffee Machine"));
                //Calibration
                list.add(new Devices.kitchenCoffeeMachine("ON"));
                //User Settings
                list.add(new Devices.kitchenCoffeeMachine(String.valueOf(coffeeMachineTemp.getCoffeeMachineTemp())));
                //Set list
                kitchenCoffeeMachine.setListKitchenCoffeeMachine(list);

                updatedList = list.toString();
                x1 = String.valueOf((updatedList));
                break;
            }
        }

        //Updates any new AC fixtures into one list
        //Refreshes the list by erasing then recreating
        PrintWriter pw = new PrintWriter("ConfigFiles/coffeeMachineConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        //x1 = insert full updated list here
        sb.append(x1).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles/coffeeMachineConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
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

    //Motion Sensor
    public javax.swing.JButton livingRoomMotionSensor;
    public javax.swing.JButton mainBedroomMotionSensor;
    public javax.swing.JButton secondBedroomMotionSensor;
    public javax.swing.JButton kitchenMotionSensor;
    public javax.swing.JButton garageMotionSensor;
    public javax.swing.JButton gardenMotionSensor;

    //Lights
    public javax.swing.JButton livingRoomLights;
    public javax.swing.JButton mainBedroomLights;
    public javax.swing.JButton secondBedroomLights;
    public javax.swing.JButton kitchenLights;
    public javax.swing.JButton garageLights;
    public javax.swing.JButton gardenLights;

    //Air Conditioner
    public javax.swing.JButton livingRoomAirCon;
    public javax.swing.JButton mainBedroomAc;

    //Ceiling Fan
    public javax.swing.JButton livingRoomFan;
    public javax.swing.JButton mainBedroomFan;
    public javax.swing.JButton secondBedroomFan;

    //Garage Door
    public javax.swing.JButton garageGarage;

    //Sprinklers
    public javax.swing.JButton gardenMotionSprinklers;

    //Car
    public javax.swing.JButton garageCar;

    //Oven
    public javax.swing.JButton kitchenOven;

    //Tv
    public javax.swing.JButton livingRoomTv;
    public javax.swing.JButton mainBedroomTv;

    //Kettle
    public javax.swing.JButton kitchenKettle;

    //Coffee Machine
    public javax.swing.JButton kitchenCoffee;

    //Alarm Clock
    public javax.swing.JButton mainBedroomAlarm;
    public javax.swing.JButton secondBedroomAlarm;






}