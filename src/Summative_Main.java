/* Summative_Main.java
 * ICS3U1 Final Summative
 * Goal: Create a program to read in course data, assign courses to classrooms, and save finished data
 * Authors: Roger Chen, Cathy Meng, Nancy Wang
 */

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*; 
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Summative_Main extends JFrame implements ActionListener{
  
  //............THE GUI.............................................................................................
  
  //............Images..................
  
  ImageIcon yrdsbIcon = new ImageIcon("YRDSBlogo.gif");
  ImageIcon rightarrowIcon = new ImageIcon("rightarrow.gif");
  ImageIcon leftarrowIcon = new ImageIcon("leftarrow.gif");
  ImageIcon homeIcon = new ImageIcon("home.gif");
  ImageIcon openIcon = new ImageIcon("open.gif");
  ImageIcon saveIcon = new ImageIcon("save.gif");
  
  //..............Buttons...............
  JButton startButton = new JButton("Start");
  JButton helpButton = new JButton("Instructions");
  JButton acknowledgementsButton = new JButton("Acknowledgements");
  JButton openButton = new JButton("Load",openIcon);
  JButton saveButton = new JButton ("Save",saveIcon);
  
  //----------Arrow_Buttons------------
  
  JButton rightarrowButton0 = new JButton(rightarrowIcon);
  JButton leftarrowButton0 = new JButton(leftarrowIcon);
  JButton rightarrowButton1 = new JButton(rightarrowIcon);
  JButton leftarrowButton1 = new JButton(leftarrowIcon);
  JButton rightarrowButton2 = new JButton(rightarrowIcon);
  JButton leftarrowButton2 = new JButton(leftarrowIcon);
  JButton rightarrowButton3 = new JButton(rightarrowIcon);
  JButton leftarrowButton3 = new JButton(leftarrowIcon);
  
  //----------Home_Buttons..................
  
  JButton homeButton0 = new JButton(homeIcon);
  JButton homeButton1 = new JButton(homeIcon);
  JButton homeButton2 = new JButton(homeIcon);
  JButton homeButton3 = new JButton(homeIcon);
  JButton homeButton4 = new JButton(homeIcon);
  JButton homeButton5 = new JButton(homeIcon);
  
  //.............Labels......................
  
  JLabel main_menu_Title = new JLabel("Classroom Assignment");
  JLabel image_1 = new JLabel(yrdsbIcon);
  JLabel help_menu_0 = new JLabel("<html>Hello!<br>Thank you for using the newest and most advanced version of Classroom Assignment.<br>We aim to provide you with maximum convenience in course-room assigning.<br>This program takes into account available equipment, room capacity, course blocks, and a number of other important factors.<br>To start navigating instructions, please click on the arrows on the left and right.<br>Thank you for your patience and support. If you have any questions, we are glad to take them at bssclassroomassignment@gmail.com or (647)984-0168.<br>Enjoy!");
  JLabel help_menu_Title_0 = new JLabel("Instructions");

  JLabel help_menu_1 = new JLabel("<html>To use this software:<br>1. On the home screen, select \"Start\".<br>2. Once you have formatted your file (see the slide to the right), select \"Open\"." +
                                  "<br>3. Select \"Save\". This may take several minutes. The program will automatically create a text file with the classroom assignments.");
  JLabel help_menu_Title_1 = new JLabel("Use");
  JLabel help_menu_2 = new JLabel("<html>Input for this software from Excel:<br>1. Format your data in the following manner:<br><&nbsp> Your data should be aligned in three columns: course code, number of students in the class, " +
                                  "and the period the class will run in.<br><&nbsp> Periods are numbered 1-5 for Semester 1, and 6-10 for Semester 2.<br><&nbsp> Every class must have its data in its own row.<br>2. Examples:<br><&nbsp> " + 
                                  "Grade 11 College-level Chemistry with 30 students, running Period 3, Sem 2: SCH3C1-03,30,8<br>3. Save your Excel file as CourseList.txt or CourseList.csv (File > Save As... > Save as type: " +
                                  "\"Text (Tab-delimited)\" or \"CSV (Comma-delimited)\").<br>4. The file MUST be named \"CourseList\" EXACTLY and placed in the SAME FOLDER as this software.");
  JLabel help_menu_Title_2 = new JLabel("Input");
  JLabel help_menu_3 = new JLabel("<html>Output of this software:<br>1. A text file, named \"CoursesFinished.txt\", will be created, containing a formatted list of courses, their periods, and their assigned classrooms.<br>" +
                                  "2. To view this data in Microsoft Excel, copy the entire contents of the file to the top-left cell (A1) of a blank spreadsheet. The data will be formatted automatically.");
  JLabel help_menu_Title_3 = new JLabel("Output");
  JLabel acknowledgement_Title = new JLabel("Credits");
  JLabel acknowledgement_menu_1 = new JLabel("<html>Roger Chen - Algorithm, Code integration<br>Cathy Meng - File interaction, logistics, code readability <br>Nancy Wang - User interface, structural design<br>Mr. Mangat - Strategy/technology consultation<br>Ms. Steel - Data information");
  JLabel start_menu_Title_1 = new JLabel("Upload");

  //.............Misc...............
  
  JTextArea log = new JTextArea(7,28);
  JScrollPane logScrollPane = new JScrollPane(log);
  
  //............Panels...............
  
  //********HELP MENU 0********//
  JPanel panel_00 = new JPanel();
  JPanel panel_01 = new JPanel();
  JPanel panel_02 = new JPanel();
  JPanel panel_03 = new JPanel();
  
  //********HOME PAGE ********//
  JPanel panel_0 = new JPanel();
  JPanel panel_1 = new JPanel();
  JPanel panel_2 = new JPanel();
  
  //********HELP MENU 1********//
  JPanel panel_3 = new JPanel();
  JPanel panel_4 = new JPanel();
  JPanel panel_5 = new JPanel();
  JPanel panel_6 = new JPanel();
  
  //********HELP MENU 2********//
  JPanel panel_7 = new JPanel();
  JPanel panel_8 = new JPanel();
  JPanel panel_9 = new JPanel();
  JPanel panel_10 = new JPanel();
  
  //********HELP MENU 3********//
  JPanel panel_11 = new JPanel();
  JPanel panel_12 = new JPanel();
  JPanel panel_13 = new JPanel();
  JPanel panel_14 = new JPanel();
  
  //********ACKNOWLEDGEMENTS********//
  JPanel panel_15 = new JPanel();
  JPanel panel_16 = new JPanel();
  JPanel panel_17 = new JPanel();
  
  //********START MENU********//
  JPanel panel_18 = new JPanel();
  JPanel panel_19 = new JPanel();
  JPanel panel_20 = new JPanel();
  JPanel panel_21 = new JPanel();
  JPanel panel_22 = new JPanel();
    
  //...........Layout...........
  
  FlowLayout flow = new FlowLayout();
  
  BoxLayout box_0 = new BoxLayout(panel_00, BoxLayout.Y_AXIS);
  BoxLayout box_1 = new BoxLayout(panel_0, BoxLayout.Y_AXIS);
  BoxLayout box_2 = new BoxLayout(panel_1, BoxLayout.Y_AXIS);
  BoxLayout box_3 = new BoxLayout(panel_3, BoxLayout.Y_AXIS);
  BoxLayout box_4 = new BoxLayout(panel_7, BoxLayout.Y_AXIS);
  BoxLayout box_5 = new BoxLayout(panel_11, BoxLayout.Y_AXIS);
  BoxLayout box_6 = new BoxLayout(panel_15, BoxLayout.Y_AXIS);
  BoxLayout box_7 = new BoxLayout(panel_16, BoxLayout.Y_AXIS);
  BoxLayout box_8 = new BoxLayout(panel_18, BoxLayout.Y_AXIS);
  
  
  
  //.............VARIABLES...................
  
  String [] courseCode = new String[1000];
  int [] students = new int[1000];
  int [] period = new int[1000];
  
  File readfile = new File("CourseList.txt");
  File roomdistribution = new File ("CoursesFinished.txt");
  
  //********OTHER ARRAYS********//
  
  String[] compReqd = {"BTT","BTA","ICS","TDJ","TGJ","TIJ","TEJ","TGI","TGP","TGV"};   // courses with computer requirements
  byte[] courseSubject = new byte[courseCode.length];      // byte array to store subject codes
  boolean[] computers = new boolean[courseCode.length];    // array to store which courses require computers
  String[] assignedRoom;
  
  String slotNotFound = "";    // variable to hold courses without slots
  
  //********ROOM DATA********//
  

  String[] room = {"101","107","108","111","112","113","119","121","122","124","125","126","128","129","130","131","132","133","134","201","202","206","208","209","20N","20S","210","211","212","213","214","217","218","219","221","222","223",
    "224","226","233","235","236","29","30","50","51","52","53","54","56","57","58","71","72","75","81","83","84","85","86","87","G03","G04","G12","G15","G16","PORT1","PORT2","PORT3","PORT4","PORT5","PORT6","PORT7","PORT8","WGTRM"};
  byte[] roomSubject = {15,9,5,5,5,5,5,15,13,13,15,13,13,13,13,13,13,13,13,6,6,6,6,6,11,11,4,4,4,3,3,3,7,3,3,8,8,7,14,8,8,8,15,15,11,11,15,15,15,2,2,2,1,13,14,0,1,15,15,14,14,12,12,12,12,12,10,10,10,10,10,10,15,15,16};
  int[] compNum = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,218,0,221,0,0,28,22,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,30,0,0,0,0,23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    
  
  String[][] inUse = new String[room.length][10];    // 2d array to store which rooms have classes assigned to them during which period

  //.........Gui_Constructor...................
  
  public Summative_Main (){
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(flow);
    setTitle("Classroom Assignment");
    setSize(650,450);
    
    //...........Main_Menu..........
    
    //Panel_0("Frame" of main menu)
    
    panel_0.setLayout(box_1);
    panel_0.setBackground(Color.WHITE);
    
    panel_0.add(panel_1); 
    panel_0.add(panel_2);
    
    panel_0.add(main_menu_Title);
    main_menu_Title.setFont(new Font("Calibri", Font.BOLD, 30));
    
    add(panel_0);
    
    //Panel_1(Image)
    
    panel_1.setLayout(box_2);

    panel_1.add(image_1);
    
    //Panel_2(Buttons)
    
    panel_2.setLayout(flow);
    panel_2.setBackground(Color.WHITE);  
    
    panel_2.add(helpButton);
    helpButton.setPreferredSize(new Dimension(150,40));
    helpButton.addActionListener(this);
    
    panel_2.add(startButton);
    startButton.setPreferredSize(new Dimension(150,40));
    startButton.addActionListener(this);
    
    panel_2.add(acknowledgementsButton);
    acknowledgementsButton.setPreferredSize(new Dimension(150,40));
    acknowledgementsButton.addActionListener(this);
    
    
    //.........Help_Menu..............
 
    //********Panel_00(Help_Menu_0)********// ROGR THIS ISNT WORKING
    
    panel_00.setLayout(box_0);
    panel_00.setBackground(Color.WHITE);
    
    panel_00.add(panel_01);
    panel_00.add(panel_02);
    panel_00.add(panel_03);
    
    add(panel_00);
    panel_00.setVisible(false);
    
    //Panel_01(Title)
    
    panel_01.setBackground(Color.WHITE);
    
    panel_01.add(help_menu_Title_0);
    help_menu_Title_0.setFont(new Font("Segoe UI", Font.ITALIC, 60));
    help_menu_Title_0.setForeground(new Color(4, 180, 218));
    
    //Panel_02(Content)
    
    panel_02.setLayout(flow);
    panel_02.setBackground(Color.WHITE);
    
    
    panel_02.add(leftarrowButton0);
    leftarrowButton0.setPreferredSize(new Dimension(100,50));
    leftarrowButton0.addActionListener(this);
    
    panel_02.add(help_menu_0);
    help_menu_0.setPreferredSize(new Dimension(400,190));
  
      
    panel_02.add(rightarrowButton0);
    rightarrowButton0.setPreferredSize(new Dimension(100,50));
    rightarrowButton0.addActionListener(this);
    
    //Panel_03(Home_Button)
    
    panel_03.setBackground(Color.WHITE);
    
    panel_03.add(homeButton0);
    homeButton0.setPreferredSize(new Dimension(100,100));
    homeButton0.addActionListener(this); 
    
    //********Panel_3(Help_Menu_0)********//
    
    panel_3.setLayout(box_3);
    panel_3.setBackground(Color.WHITE);
    
    panel_3.add(panel_4);
    panel_3.add(panel_5);
    panel_3.add(panel_6);
    
    add(panel_3);
    panel_3.setVisible(false);
    
    //Panel_4(Title)
    
    panel_4.setBackground(Color.WHITE);
    
    panel_4.add(help_menu_Title_1);
    help_menu_Title_1.setFont(new Font("Segoe UI", Font.ITALIC, 60));
    help_menu_Title_1.setForeground(new Color(4, 180, 218));
    
    //Panel_5(Content)
    
    panel_5.setLayout(flow);
    panel_5.setBackground(Color.WHITE);
    
    
    panel_5.add(leftarrowButton1);
    leftarrowButton1.setPreferredSize(new Dimension(100,50));
    leftarrowButton1.addActionListener(this);
    
    panel_5.add(help_menu_1);
    help_menu_1.setPreferredSize(new Dimension(400,190));
  
      
    panel_5.add(rightarrowButton1);
    rightarrowButton1.setPreferredSize(new Dimension(100,50));
    rightarrowButton1.addActionListener(this);
    
    //Panel_6(Home_Button)
    
    panel_6.setBackground(Color.WHITE);
    
    panel_6.add(homeButton1);
    homeButton1.setPreferredSize(new Dimension(100,100));
    homeButton1.addActionListener(this); 
    
    
    //********Panel_7(Help_Menu_2)********//
    
    panel_7.setLayout(box_4);
    panel_7.setBackground(Color.WHITE);
    
    panel_7.add(panel_8);
    panel_7.add(panel_9);
    panel_7.add(panel_10);
    
    add(panel_7);
    panel_7.setVisible(false);
    
    //Panel_8(Title)
    
    panel_8.setBackground(Color.WHITE);
    
    panel_8.add(help_menu_Title_2);
    help_menu_Title_2.setFont(new Font("Segoe UI", Font.ITALIC, 60));
    help_menu_Title_2.setForeground(new Color(4, 180, 218));
    
    //Panel_9(Content)
    
    panel_9.setLayout(flow);
    panel_9.setBackground(Color.WHITE);
    
    panel_9.add(leftarrowButton2);
    leftarrowButton2.setPreferredSize(new Dimension(100,50));
    leftarrowButton2.addActionListener(this);
    
    panel_9.add(help_menu_2);
    help_menu_2.setPreferredSize(new Dimension(400,190));
    
    panel_9.add(rightarrowButton2);
    rightarrowButton2.setPreferredSize(new Dimension(100,50));
    rightarrowButton2.addActionListener(this);
    
    //Panel_10(Home_Button)
    
    panel_10.setBackground(Color.WHITE);
    
    panel_10.add(homeButton2);
    homeButton2.setPreferredSize(new Dimension(100,100));
    homeButton2.addActionListener(this); 
    
    //********Panel_11(Help_Menu_3)********//
    
    panel_11.setLayout(box_5);
    panel_11.setBackground(Color.WHITE);
    
    panel_11.add(panel_12);
    panel_11.add(panel_13);
    panel_11.add(panel_14);
    
    add(panel_11);
    panel_11.setVisible(false);
    
    //Panel_12(Title)
    
    panel_12.setBackground(Color.WHITE);
    
    panel_12.add(help_menu_Title_3);
    help_menu_Title_3.setFont(new Font("Segoe UI", Font.ITALIC, 60));
    help_menu_Title_3.setForeground(new Color(4, 180, 218));

    //Panel_13(Content)
    
    panel_13.setLayout(flow);
    panel_13.setBackground(Color.WHITE);
    
    panel_13.add(leftarrowButton3);
    leftarrowButton3.setPreferredSize(new Dimension(100,50));
    leftarrowButton3.addActionListener(this);
    
    panel_13.add(help_menu_3);
    help_menu_3.setPreferredSize(new Dimension(400,190));
    
    panel_13.add(rightarrowButton3);
    rightarrowButton3.setPreferredSize(new Dimension(100,50));
    rightarrowButton3.addActionListener(this);
    
    //Panel_14
    
    panel_14.setBackground(Color.WHITE);
    
    panel_14.add(homeButton3);
    homeButton3.setPreferredSize(new Dimension(100,100));
    homeButton3.addActionListener(this); 
    
    //............Acknowledgements_Menu.................
    
    //Panel_15("Frame" for acknowledgement menu")
    
    panel_15.setLayout(box_6);
    panel_15.setBackground(Color.WHITE); 
    
    panel_15.add(panel_16);
    panel_15.add(panel_17);
   
    add(panel_15);
    panel_15.setVisible(false);
    
    //Panel_16(Content)
    
    panel_16.setLayout(box_7);
    panel_16.setBackground(Color.WHITE);
    
    panel_16.add(acknowledgement_Title);
    acknowledgement_Title.setFont(new Font("Segoe UI", Font.ITALIC, 60));
    acknowledgement_Title.setForeground(new Color(4, 180, 218));
    
    panel_16.add(acknowledgement_menu_1);
    acknowledgement_menu_1.setPreferredSize(new Dimension(400,190));
    
    //Panel_17(Home_Button)
    
    panel_17.setBackground(Color.WHITE);
    
    panel_17.add(homeButton4);
    homeButton4.setPreferredSize(new Dimension(100,100));
    homeButton4.addActionListener(this); 

    //...........Start_Menu.................
    //Panel_18(Start_Menu_1)
    
    panel_18.setLayout(box_8);
    panel_18.setBackground(Color.WHITE);
    
    panel_18.add(panel_19);
    panel_18.add(panel_20);
    panel_18.add(panel_21);
    panel_18.add(panel_22);
    
    add(panel_18);
    panel_18.setVisible(false);
    
    //Panel_19(Title)
    
    panel_19.setBackground(Color.WHITE);
    panel_19.setPreferredSize(new Dimension(100,100));
    
    panel_19.add(start_menu_Title_1);
    start_menu_Title_1.setFont(new Font("Segoe UI", Font.ITALIC, 55));
    start_menu_Title_1.setForeground(new Color(4, 180, 218));
    
    //Panel_20(Buttons)
    
    panel_20.setLayout(flow);
    panel_20.setBackground(Color.WHITE);
    
    panel_20.add(openButton);
    openButton.addActionListener(this); 
    
    panel_20.add(saveButton);
    saveButton.addActionListener(this);
    
    //Panel_21(User_Interation)

    panel_21.setLayout(flow);
    panel_21.setBackground(Color.WHITE);
    
    panel_21.add(logScrollPane, BorderLayout.CENTER);
    log.setEditable(false);
    log.setMargin(new Insets(7,7,7,7));
    
    //Panel_22(Home Button)
    
    panel_22.setBackground(Color.WHITE);
    
    panel_22.add(homeButton5);
   
    homeButton5.setPreferredSize(new Dimension(100,100));
    homeButton5.addActionListener(this); 

    //..........Visibility and Resizability.............
    
    setVisible(true);
    setResizable(false);
    
  }
  
  
 //...............MAIN FILE I/O...........................................................................................
  public static void main(String[]args) throws Exception{
    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    new Summative_Main();
  }
  
  
  //********READING INITIAL DATA********//
  public void loadFile() {
    try{
      Scanner u = new Scanner(readfile);
      int count=0;
      while (u.hasNext()) {
        courseCode[count]=u.next();
        students[count]=u.nextInt();
        period[count]=u.nextInt() - 1;
        count++;
      }
      u.close();
      
      log.append("Opened " + readfile.getName() + " successfully.\n");
      log.setCaretPosition(log.getDocument().getLength());
      
    }catch(Exception E){
      log.append("Attempt to open " + readfile.getName() + " failed.\n");
      log.setCaretPosition(log.getDocument().getLength());
    }
  }
  
  public void process(){
    removeNullValues();
    // determines course subject of each course
    for(int i = 0; i < courseCode.length; i++){
      courseSubject[i] = determineSubject(courseCode[i]);
      for(int j = 0; j < compReqd.length; j++){
        if(courseCode[i].substring(0,3).equals(compReqd[j])){
          computers[i] = true;
          break;
        }
      }
    }
    // loops through course and room data; if room meets course requirements, occupy room slot with course
    for(int i = 0; i < courseCode.length; i++){
      for(int j = 0; j < room.length; j++){
        if(matchRoom(i, j)) break;
      }
      if(assignedRoom[i] == null) overflowSearch(i);
    }
  }
  
  public void overflowSearch(int i){
    for(int j = room.length - 1; j >= 0; j--){
      if(inUse[j][period[i]] == null){
        if(courseSubject[i] == 3 || courseSubject[i] == 5 || courseSubject[i] == 6 || courseSubject[i] == 8 || courseSubject[i] == 10 || courseSubject[i] == 12 || courseSubject[i] == 15){
          if(roomSubject[j] == 3 || roomSubject[j] == 5 || roomSubject[j] == 6 || roomSubject[j] == 8 || roomSubject[j] == 10 || roomSubject[j] == 12 || roomSubject[j] == 15){
            inUse[j][period[i]] = courseCode[i];
            assignedRoom[i] = room[j];
            break;
          }
        }
      }
    }
  }
  
  public boolean matchRoom(int i, int j){
    if(courseSubject[i] == roomSubject[j]){
      if(inUse[j][period[i]] == null){
        if(!computers[i]){
          inUse[j][period[i]] = courseCode[i];
          assignedRoom[i] = room[j];
          return true;
        }
        else{
          if(students[i] <= compNum[j]){
            inUse[j][period[i]] = courseCode[i];
            assignedRoom[i] = room[j];
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public byte determineSubject(String s){
    if(s.charAt(0) == 'M') return 12;
    else if(s.charAt(0) == 'E') return 8;
    else if(s.charAt(0) == 'S') return 13;
    else if(s.charAt(0) == 'T'){
      if(s.charAt(1) == 'E' || s.charAt(1) == 'G') return 4;
      return 14;
    }
    else if(s.charAt(0) == 'P'){
      if(s.charAt(1) == 'A') return 16;
      return 11;
    }
    else if(s.charAt(0) == 'B') return 3;
    else if(s.charAt(0) == 'F') return 10;
    else if(s.charAt(0) == 'L') return 10;
    else if(s.charAt(0) == 'H'){
      if(s.charAt(1) == 'I' || s.charAt(1) == 'F') return 9;
      return 6;
    }
    else if(s.charAt(0) == 'C'){
      if(s.charAt(1) == 'G') return 5;
      return 6;
    }
    else if(s.charAt(0) == 'A'){
      if(s.charAt(1) == 'D') return 0;
      else if(s.charAt(1) == 'M') return 1;
      return 2;
    }
    else if(s.charAt(0) == 'I'){
      if(s.charAt(1) == 'C') return 7;
      else if(s.charAt(1) == 'B') return 13;
      return 15;
    }
    return 15;
  }
  
  
  
  public void removeNullValues(){
    int i = courseCode.length - 1;
    while(courseCode[i] == null){
      i--;
    }
    String[] newCourseCode = new String[i + 1];
    int[] newStudents = new int[i + 1];
    int[] newPeriod = new int[i + 1];
    byte[] newCourseSubject = new byte[i + 1];
    boolean[] newComputers = new boolean[i + 1];
    System.arraycopy(courseCode, 0, newCourseCode, 0, i + 1);
    System.arraycopy(students, 0, newStudents, 0, i + 1);
    System.arraycopy(period, 0, newPeriod, 0, i + 1);
    System.arraycopy(courseSubject, 0, newCourseSubject, 0, i + 1);
    System.arraycopy(computers, 0, newComputers, 0, i + 1);
    courseCode = newCourseCode;
    students = newStudents;
    period = newPeriod;
    courseSubject = newCourseSubject;
    computers = newComputers;
    assignedRoom = new String[courseCode.length];
  }
  
  
  //********WRITING ROOM DATA TO FILE********//
  public void saveFile() {
    process();
    try{  
      PrintWriter output = new PrintWriter (roomdistribution);
      Scanner v = new Scanner (roomdistribution);
      int count2=0;
      output.print("Course Code");
      output.print("\t");
      output.print("Period");
      output.print("\t");
      output.println("Rm #");
      output.println("\n");
      
      for(int i = 0; i < courseCode.length; i++){
        output.print(courseCode[i]);
        output.print("\t");
        output.print(period[i] + 1);
        output.print("\t");
        output.println(assignedRoom[i]);
      }
      output.println();
      output.println("Room slots were not found for the following courses:");
      output.println();
      output.println(slotNotFound);
      output.close();
      v.close();
      
      log.append("Saved " + roomdistribution.getName() + " successfully.\n");
      log.setCaretPosition(log.getDocument().getLength());
      
    }catch(Exception E){
      E.printStackTrace();
      log.append("Attempt to save " + roomdistribution.getName() + " failed.\n");
      log.setCaretPosition(log.getDocument().getLength());
    };
  }
  
  // ActionPerformed method
  
  public void actionPerformed(ActionEvent event) {
    Object source = event.getSource();
    
    //..........Start_Button....................
    if(source == helpButton){
      panel_0.setVisible(false);
      panel_00.setVisible(true);
    }
    else if(source == acknowledgementsButton){
      panel_0.setVisible(false);
      panel_15.setVisible(true);
    }
    else if(source == startButton){
      panel_0.setVisible(false);
      panel_18.setVisible(true);
  }
    else if(source == leftarrowButton0){
       panel_00.setVisible(false);
      panel_11.setVisible(true);
    }
     else if(source == rightarrowButton0){
       panel_00.setVisible(false);
      panel_3.setVisible(true);
    }
    else if(source == leftarrowButton1){
      panel_3.setVisible(false);
      panel_00.setVisible(true);
    }
    else if(source == rightarrowButton1 ){
      panel_3.setVisible(false);
      panel_7.setVisible(true);
    }
    else if(source == leftarrowButton2){
      panel_7.setVisible(false);
      panel_3.setVisible(true);
    }
    else if(source == rightarrowButton2){
      panel_7.setVisible(false);
      panel_11.setVisible(true);
    }
    else if(source == leftarrowButton3){
      panel_11.setVisible(false);
      panel_7.setVisible(true);
    }
    else if(source == rightarrowButton3){
      panel_11.setVisible(false);
      panel_00.setVisible(true);
    }
    else if(source == homeButton1){
      panel_00.setVisible(false);
      panel_0.setVisible(true);
    }
    else if(source == homeButton1){
      panel_3.setVisible(false);
      panel_0.setVisible(true);
    }
    else if(source == homeButton2){
      panel_7.setVisible(false);
      panel_0.setVisible(true);
    }
    else if(source == homeButton3){
      panel_11.setVisible(false);
      panel_0.setVisible(true);
    }
    else if(source == homeButton4){
      panel_15.setVisible(false);
      panel_0.setVisible(true);
    }
    else if(source == homeButton5){
      panel_18.setVisible(false);
      panel_0.setVisible(true);
    }
    
    else if(source == openButton){
      log.append("Opening: " + readfile.getName() + ".\n");
      log.setCaretPosition(log.getDocument().getLength());
      loadFile();
    }
    else if(source == saveButton) {
      log.append("Saving: " + roomdistribution.getName() + ".\n");
      log.setCaretPosition(log.getDocument().getLength());
      saveFile();
    }
  }
}



