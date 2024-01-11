import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.net.http.WebSocket.Listener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Params extends JFrame implements ActionListener {
    public boolean start_Sim = false;
    public JTextField text_dim_W, text_dim_H, text_nbr_User, text_Speed, text_SIM_Duration, text_min_transmission_range, text_max_transmission_range, text_CQI_Threshold, text_update_rate ;
    public JSlider slider_Speed;
    public Params() {
        JFrame frame = new JFrame("Simulation Params");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Container contentPane = frame.getContentPane();
    
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);
    
        Component lab_display_dim = new JLabel("Simulation Area Size:  Width and Hight (meters):");
                
        text_dim_W = new JTextField(4);
        text_dim_W.setText(String.valueOf(Simul.Area_Width));
        text_dim_H = new JTextField(4);
        text_dim_H.setText(String.valueOf(Simul.Area_Height));

        Component lab_nbr_User = new JLabel("Maximum number of user:");
        text_nbr_User= new JTextField(4);
        text_nbr_User.setText(String.valueOf(Simul.nbr_User));
     
        Component lab_Speed = new JLabel("Simulation Speed (m/s):");
        text_Speed= new JTextField(4);
        text_Speed.setText(String.valueOf(Simul.Speed));
        slider_Speed = new JSlider(JSlider.HORIZONTAL, 0, 500, 250); 
           
        Component lab_Duration = new JLabel("Simulation Duration (seconds):");
        text_SIM_Duration= new JTextField(4);
        text_SIM_Duration.setText(String.valueOf(Simul.SIM_DURATION));
        
        Component lab_transmission_range = new JLabel("Minimum and Maximum Transmission Range (meters):");
        text_min_transmission_range= new JTextField(4);
        text_min_transmission_range.setText(String.valueOf(Simul.transmission_range_min));
        text_max_transmission_range= new JTextField(4);
        text_max_transmission_range.setText(String.valueOf(Simul.transmission_range_max));

        Component lab_CQI_Threshold = new JLabel("CQI Threshold : 0 (Optimized Tree) to 15 (Less Cost):");
        text_CQI_Threshold= new JTextField(4);
        text_CQI_Threshold.setText(String.valueOf(Simul.CQI_Threshold));

        Component lab_update_rate = new JLabel("Optimization Update Rates in seconds (1 to 10 is suggested):");
        text_update_rate= new JTextField(4);
        text_update_rate.setText(String.valueOf(Simul.update_rate));  
     
        JButton start= new JButton("let's go ! ");
        start.addActionListener((ActionEvent ae) ->  addBtnClicked());
        //start.addActionListener((ActionEvent ae) ->  addFocusListener(ActionListener l));
    
        // Layout Position
        contentPane.add(lab_display_dim); contentPane.add(text_dim_W); contentPane.add(text_dim_H);
        contentPane.add(lab_nbr_User); contentPane.add(text_nbr_User);
        contentPane.add(lab_Speed); contentPane.add(text_Speed); contentPane.add(slider_Speed);
        contentPane.add(lab_Duration);  contentPane.add(text_SIM_Duration); 
        contentPane.add(lab_transmission_range) ; contentPane.add(text_min_transmission_range);contentPane.add(text_max_transmission_range);
        contentPane.add(lab_CQI_Threshold); contentPane.add(text_CQI_Threshold); 
        contentPane.add(lab_update_rate); contentPane.add(text_update_rate);    contentPane.add(start);

        // display size
        layout.putConstraint(SpringLayout.WEST, lab_display_dim, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, lab_display_dim, 10, SpringLayout.NORTH, contentPane); 
        layout.putConstraint(SpringLayout.WEST, text_dim_W, 20, SpringLayout.EAST, lab_display_dim);
        layout.putConstraint(SpringLayout.WEST, text_dim_H, 20, SpringLayout.EAST, text_dim_W);
        layout.putConstraint(SpringLayout.NORTH, text_dim_W, 10, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, text_dim_H, 10, SpringLayout.NORTH, contentPane);

        // nbr_User
        layout.putConstraint(SpringLayout.WEST, lab_nbr_User, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, lab_nbr_User, 40, SpringLayout.NORTH, contentPane);     
        layout.putConstraint(SpringLayout.WEST, text_nbr_User, 20, SpringLayout.EAST, lab_nbr_User);
        layout.putConstraint(SpringLayout.NORTH, text_nbr_User, 40, SpringLayout.NORTH, contentPane);

        // SIM_Duration
        layout.putConstraint(SpringLayout.WEST, lab_Duration, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, lab_Duration, 70, SpringLayout.NORTH, contentPane);     
        layout.putConstraint(SpringLayout.WEST, text_SIM_Duration, 20, SpringLayout.EAST, lab_Duration);
        layout.putConstraint(SpringLayout.NORTH, text_SIM_Duration, 70, SpringLayout.NORTH, contentPane);

        // transmission_Range
        layout.putConstraint(SpringLayout.WEST, lab_transmission_range, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, lab_transmission_range, 100, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, text_min_transmission_range, 20, SpringLayout.EAST, lab_transmission_range);
        layout.putConstraint(SpringLayout.WEST, text_max_transmission_range, 20, SpringLayout.EAST, text_min_transmission_range);
        layout.putConstraint(SpringLayout.NORTH, text_min_transmission_range, 100, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, text_max_transmission_range, 100, SpringLayout.NORTH, contentPane);

        // text_CQI_Threshold
        layout.putConstraint(SpringLayout.WEST, lab_CQI_Threshold, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, lab_CQI_Threshold, 130, SpringLayout.NORTH, contentPane);     
        layout.putConstraint(SpringLayout.WEST, text_CQI_Threshold, 20, SpringLayout.EAST, lab_CQI_Threshold);
        layout.putConstraint(SpringLayout.NORTH, text_CQI_Threshold, 130, SpringLayout.NORTH, contentPane);

        // text_update_rate
        layout.putConstraint(SpringLayout.WEST, lab_update_rate, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, lab_update_rate, 160, SpringLayout.NORTH, contentPane);     
        layout.putConstraint(SpringLayout.WEST, text_update_rate, 20, SpringLayout.EAST, lab_update_rate);
        layout.putConstraint(SpringLayout.NORTH, text_update_rate, 160, SpringLayout.NORTH, contentPane);

        //text_Speed, 
        layout.putConstraint(SpringLayout.WEST, lab_Speed, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, lab_Speed, 190, SpringLayout.NORTH, contentPane);     
        layout.putConstraint(SpringLayout.WEST, text_Speed, 20, SpringLayout.EAST, lab_Speed);
        layout.putConstraint(SpringLayout.NORTH, text_Speed, 190, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, slider_Speed, 20, SpringLayout.EAST, text_Speed);
        layout.putConstraint(SpringLayout.NORTH, slider_Speed, 190, SpringLayout.NORTH, contentPane);          

        text_Speed.setEditable(false);
        slider_Speed.setMinorTickSpacing(50);  
        slider_Speed.setMajorTickSpacing(100);  
        slider_Speed.setPaintTicks(true); 
        slider_Speed.setPaintLabels(true);
        slider_Speed.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e) {
         //System.out.println("Slider2: " + slider_Speed.getValue());
         text_Speed.setText(Integer.toString(slider_Speed.getValue()));
         Simul.Speed = Integer.parseInt(text_Speed.getText());
      }
    });  

// Btn Start
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, start, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, start, -30, SpringLayout.SOUTH, contentPane);  
        frame.setSize(600, 400);
        frame.setVisible(true);
      }
     
   
      public void addBtnClicked()
    {
        Simul.Area_Height = Integer.parseInt(text_dim_H.getText());
        Simul.Area_Width = Integer.parseInt(text_dim_W.getText());
        Simul.Speed = Integer.parseInt(text_Speed.getText());
        Simul.SIM_DURATION = Integer.parseInt(text_SIM_Duration.getText());
        Simul.transmission_range_min = Integer.parseInt(text_min_transmission_range.getText());
        Simul.transmission_range_max = Integer.parseInt(text_max_transmission_range.getText());
        Simul.CQI_Threshold = Integer.parseInt(text_CQI_Threshold.getText());
        Simul.update_rate = Integer.parseInt(text_update_rate.getText());

        Simul.start_Sim = true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Hellooooo");
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    }

        
 
