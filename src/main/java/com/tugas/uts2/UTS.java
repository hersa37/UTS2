/*
 * Made by:Bernardus Hersa Galih Prakoso
 * Informatika Sanata Dharma 215314018
 */

package com.tugas.uts2;

import javax.swing.*;//imports swing elements (JLabel, etc)
import java.awt.*;//enables use of gridbaglayout
import java.awt.event.ActionEvent;//enables actions
import java.awt.event.ActionListener;
import java.io.BufferedWriter;//enables writing to file
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 *
 * @author echa
 */
public class UTS{
    //declare each gui component    
    JFrame frame;//GUI window
    JButton save;//button to save data
    JPanel panel;//creates panel for elements
    JLabel nameLabel,addressLabel,phoneLabel;
    JLabel redLabel,blueLabel,sizeLabel;
    //declared as static so can be accessed by in other methods
    static JTextField nameTF,addressTF,phoneTF;
    //text field for each color and size
    static JTextField redTFS,redTFM,redTFL;
    static JTextField blueTFS,blueTFM,blueTFL;
    //dropdown menu for region
    static JComboBox regionCB;
    //used for list counter
    int order=0;
    
    //gui constructor

    /**
     * Constructor to make GUI.
     * Uses swing objects for label, text field/box, drop down/combo box
     * menu.
     * <p>
     * For panel composition, uses GridBagLayout. The values are determined using
     * GridBagConstraints as called in the {@link #gridPlace(int, int, double)} method.
     * <p>
     * Save button uses ActionEvent and Listener to trigger an inner class if button is clicked.
     * 
     */
    public UTS(){
        //array for dropdown menu
        String[] reg={"","Kota Yogyakarta","Kulon Progo","Sleman",
            "Bantul","Gunungkidul"};
        //declare variable a & b for gbc weightx value
        double a=0,b=1;
        //creates panel as JPanel
        panel=new JPanel();
        //use gridbaglayout for panel layout
        panel.setLayout(new GridBagLayout());
        //create label with defined text
        //start of objects for personal details
        nameLabel=new JLabel("Nama: ");
        //adds object to panel using .add
        //use gridPlace() method for .add parameter
        panel.add(nameLabel,gridPlace(0,0,a));
        
        nameTF=new JTextField();
        panel.add(nameTF,gridPlace(1,0,b));
        
        addressLabel=new JLabel("Alamat:");
        panel.add(addressLabel,gridPlace(0,1,a));
        
        regionCB=new JComboBox(reg);//use reg array for dropdown menu
        panel.add(regionCB,gridPlace(1,1,a));
        
        addressTF=new JTextField();
        panel.add(addressTF,gridPlace(1,2,a));
        
        phoneLabel=new JLabel("No. Telp:");
        panel.add(phoneLabel,gridPlace(0,3,a));        
        
        phoneTF=new JTextField();
        panel.add(phoneTF,gridPlace(1,3,a));   
        //end of objects for personal details
        //start of objects for shirt size inputs
        sizeLabel=new JLabel("Ukuran");
        panel.add(sizeLabel,gridPlace(0,4,a));
        
        redLabel=new JLabel("Merah");
        panel.add(redLabel,gridPlace(1,4,b));
        
        blueLabel=new JLabel("Biru");
        panel.add(blueLabel,gridPlace(2,4,b));
                
        sizeLabel=new JLabel("S");
        panel.add(sizeLabel,gridPlace(0,5,a));
        
        redTFS=new JTextField("0");
        panel.add(redTFS,gridPlace(1,5,a));
        
        blueTFS=new JTextField("0");
        panel.add(blueTFS,gridPlace(2,5,b));
        
        sizeLabel=new JLabel("M");
        panel.add(sizeLabel,gridPlace(0,6,a));
        
        redTFM=new JTextField("0");
        panel.add(redTFM,gridPlace(1,6,a));
        
        blueTFM=new JTextField("0");
        panel.add(blueTFM,gridPlace(2,6,b));

        sizeLabel=new JLabel("L");
        panel.add(sizeLabel,gridPlace(0,7,a));
        
        redTFL=new JTextField("0");
        panel.add(redTFL,gridPlace(1,7,a));
        
        blueTFL=new JTextField("0");
        panel.add(blueTFL,gridPlace(2,7,b));      
        //end of objects for shirt size inputs
        //button used to save all inputs
        save=new JButton("Save");
        //creates action listener that activates when button is clicked
        save.addActionListener(new ActionListener(){
            //creates inner class to respond to this particular click
            public void actionPerformed(ActionEvent e){
                //calls writer() with textFieldInput()
                //adds ++order to textFieldInput() so it adds with each click
                writer(textFieldInput());
                //calls resetTF() to reset the textfields                
                resetTF();         
            }});
        panel.add(save,gridPlace(0,8,a));
        
        //creates window and give name UTS
        frame=new JFrame("UTS");
        //adds panel to frame
        frame.add(panel);
        //makes window visible
        frame.setVisible(true);
        //sets window dimensions
        frame.setSize(400,300);
        //stops program when window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    /**method to define the GridBagConstraint of a GridBagLayout object.
    The parameters used are to determine the placement of the objects.<p>
    * @param x x Axis
    * @param y y Axis
    * @param weight x Axis weight
    * <p>
    * Method is called every time an object is put into panel
    * @return gbc GridBagConstraints
    **/
    public static GridBagConstraints gridPlace(int x, int y, double weight){
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridx=x;
        gbc.gridy=y;
        gbc.weightx=weight;
        return gbc;
    }
    /**Method used to reset the values of every text field and combo box to its
     * original value.  
     */
    public static void resetTF(){
        //default for name,address,phone is blank
        nameTF.setText("");
        addressTF.setText("");
        phoneTF.setText("");
        //default for order number is 0
        redTFS.setText("0");
        redTFM.setText("0");
        redTFL.setText("0");
        blueTFS.setText("0");
        blueTFM.setText("0");
        blueTFL.setText("0");
    }
    /** Method to sum number of red shirts ordered
     * 
     * @return red - total number of red shirts
     */
    public static int redTotal(){
        int red=Integer.parseInt(redTFS.getText())+Integer.parseInt(redTFM.getText())
                +Integer.parseInt(redTFL.getText());
        return red;
    }
    /** Method to sum number of blue shirts ordered
     * 
     * @return blue - total number of blue shirts
     */
    public static int blueTotal(){
        int blue=Integer.parseInt(blueTFS.getText())+Integer.parseInt(blueTFM.getText())
                +Integer.parseInt(blueTFL.getText());
        return blue;
    }
    /** Calculates total shirt price
     * 
     * @return total - total shirt price for both colors
     */
    public static int shirtPrice(){
        int total=(redTotal()*100000)+(blueTotal()*120000);
        return total;
    }
    /**
     * Determines regional shipping price
     * @return regionShip - region shipping price
     */
    public static int regionShipPrice(){        
        String region=regionCB.getSelectedItem().toString();
        int regionShip;
        //switch condition for each region
        switch(region){
            case "Kota Yogyakarta":regionShip=5000;break;
            case "Kulon Progo":
            case "Gunung Kidul":regionShip=10000;break;
            case "Bantul":regionShip=8000;break;
            case "Sleman":regionShip=7000;break;
            //no shipping price if region isn't chosen
            default:regionShip=0;
        }
        return regionShip;
    }
    /**
     * Calculates total shipping price
     * @return shipTotal
     */
    public static int shipTotalPrice(){        
        int shipTotal=0;
        //iteration to add shipping cost for every 3 shirts
        for(int i=0;i<=(redTotal()+blueTotal());i+=3){
            shipTotal+=regionShipPrice();
        }
        return shipTotal;
    }
    /**
     * Calculates total price
     * @return payment
     */
    public static int totalPayment(){
        int payment;
        payment=shipTotalPrice()+shirtPrice();
        return payment;
    }
    //method to write into file

    /**
     * Writes String into CSV file
     * @param x String to be written into file
     */
    static public void writer(String x){
        //outputs to file in root called "output.csv"
        //writer appends the file to add new data each time
        //tries writer block for error
        try(Writer writer=new FileWriter("output.csv",true);
                //buffers text before writing to file
            BufferedWriter buffer=new BufferedWriter(writer);
            PrintWriter out=new PrintWriter(buffer))
        {
            //object out streams out parameter x
            out.println(x);
            System.out.println(x);
        //catch any error event    
        }catch(Exception e){
            //writes "error" in console if error is found
            System.out.println("error");
        }
    }

    /**
     * Compiles text field entries for each size into a String with CSV format
     * @return size 
     */
    static public String sizeFieldInput(){
        String size=redTFS.getText()+","
                +redTFM.getText()+","
                +redTFL.getText()+","
                +blueTFS.getText()+","
                +blueTFM.getText()+","
                +blueTFL.getText();
        return size;
    }
    //Turn method returns and variables into CSV format
    //Separates each value called by using a comma

    /**
     * Compiles all of text field inputs into one string
     * @param order Number to determine the order of the string input
     * @return data - String output
     */
    static public String textFieldInput(){
        //string of data to write
        String data="1,"+nameTF.getText()+","
                +addressTF.getText()+","
                //add ' to phoneTF cause phones start with 0
                +"'"+phoneTF.getText()+","
                +sizeFieldInput()+","
                //get String value of shipping and price method
                +String.valueOf(shipTotalPrice()+",")
                +String.valueOf(shirtPrice())+","
                +String.valueOf(totalPayment());
        //returns a String of all the values separated by a comma
        return data;
    }    
            
    /*@param args the command line arguments*/

    /**
     * Main method to call constructor
     * @param args
     */

    public static void main(String[] args) {
        //calls constructor
        new UTS();
    }

}
