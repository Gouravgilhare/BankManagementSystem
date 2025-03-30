package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class SignUpPage2 extends JFrame implements ActionListener {

    JLabel  additionalDetails, religion, income,catagory,edu,occ, pan,senior , aadhar,exist;
    JRadioButton Syes, Sno, Eyes, Eno;
    JComboBox religionBox,catagoryBox, incomeBox, educationBox, occupationBox;
    JTextField   aadharTextField, panTextField;
    JButton next;
    String formno;

    SignUpPage2(String formno){
        this.formno = formno;
        getContentPane().setBackground(Color.WHITE);
        setTitle("New Application Form - Page 2");
        setLayout(null);


        //additionalDetails
        additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Tahoma", Font.BOLD, 22));
        additionalDetails.setBounds(205, 80,400, 30);
        add(additionalDetails);

        //Religion :
        religion = new JLabel("Religion: ");
        religion.setBounds(50,130,200,30);
        religion.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(religion);

        //religion box
        String valReligion[] ={"HINDU","SIKH", "MUSLIM", "CHRISTIAN", "OTHER"};
        religionBox = new JComboBox(valReligion);
        religionBox.setBounds(300,130,400,30);
        religionBox.setFont(new Font("Verdana", Font.PLAIN, 15));
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        //Catagory
        catagory = new JLabel ("Catagory:  ");
        catagory.setBounds(50,180,200,30);
        catagory.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(catagory);

        //catagoryBox
        String valCatagory[] ={"GENERAL","OBC", "ST", "SC"};
        catagoryBox = new JComboBox(valCatagory);
        catagoryBox.setBounds(300,180,400,30);
        catagoryBox.setFont(new Font("Verdana", Font.PLAIN, 15));
        catagoryBox.setBackground(Color.WHITE);
        add(catagoryBox);


        //income
        income = new JLabel("Income: ");
        income.setBounds(50,230,200,30);
        income.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(income);

        //INCOMEBox
        String valIncome[] ={"NULL","< 1,50,000", "< 2,50,000", "< 5,00,000","up to 10,00,000"};
        incomeBox = new JComboBox(valIncome);
        incomeBox.setBounds(300,230,400,30);
        incomeBox.setFont(new Font("Verdana", Font.PLAIN, 15));
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);



        //Occupation
        occ= new JLabel("Occupation : ");
        occ.setBounds(50,280,300,30);
        occ.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(occ);

        //occupationBox
        //INCOMEBox
        String valOccupation[] ={"Accountant", "Actor", "Architect", "Artist", "Carpenter", "Chef", "Civil Engineer", "Content Writer", "Data Analyst", "Dentist", "Doctor", "Electrician", "Farmer", "Fashion Designer", "Financial Analyst", "Firefighter", "Graphic Designer", "HR Manager", "Journalist", "Lawyer","Cricketer", "Mechanic", "Musician", "Nurse", "Pharmacist", "Photographer", "Pilot", "Plumber", "Police Officer", "Professor", "Project Manager", "Real Estate Agent", "Scientist", "Software Developer", "Teacher", "Tour Guide", "Truck Driver", "Veterinarian", "Web Designer","others"};
        occupationBox = new JComboBox(valOccupation);
        occupationBox.setBounds(300,280,400,30);
        occupationBox.setFont(new Font("Verdana", Font.PLAIN, 15));
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);
        //gender
        edu= new JLabel("Educational Quailification:");
        edu.setBounds(50,330,300,30);
        edu.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(edu);

        //eduBox
        String valEducation[] ={"Graduate", "Post-Graduate","Doctrate","Matriculate","others"};
        educationBox = new JComboBox(valEducation);
        educationBox.setBounds(300,330,400,30);
        educationBox.setFont(new Font("Verdana", Font.PLAIN, 15));
        educationBox.setBackground(Color.WHITE);
        add(educationBox);





        //Adhar num
        aadhar = new JLabel("Aadhar Number: ");
        aadhar.setBounds(50,380,200,30);
        aadhar.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(aadhar);

        //AADHARTEXTFIELD
        aadharTextField = new JTextField();
        aadharTextField.setBounds(300,380,400,30);
        aadharTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(aadharTextField);


        //Pan
        pan= new JLabel("Pan Number: ");
        pan.setBounds(50,430,200,30);
        pan.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(pan);

        //PANTEXTFIELD
        panTextField = new JTextField();
        panTextField.setBounds(300,430,400,30);
        panTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(panTextField);

        //senior
        senior = new JLabel ("Senior Citizen: ");
        senior.setBounds(50,480,200,30);
        senior.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(senior);

        //senoir yes no
        Syes = new JRadioButton("Yes");
        Syes.setBounds(300,480,100,30);
        Syes.setFont(new Font("Verdana", Font.PLAIN, 18));
        Syes.setBackground(Color.WHITE);
        add(Syes);

        Sno = new JRadioButton("No");
        Sno.setBounds(400,480,100,30);
        Sno.setFont(new Font("Verdana", Font.PLAIN, 18));
        Sno.setBackground(Color.WHITE);
        add(Sno);
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(Sno);
        buttonGroup2.add(Syes);

        //existing account
        exist = new JLabel ("Existing Account: ");
        exist.setBounds(50,530,250,30);
        exist.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(exist);

        //exist yes no
        Eyes = new JRadioButton("Yes");
        Eyes.setBounds(300,530,100,30);
        Eyes.setFont(new Font("Verdana", Font.PLAIN, 18));
        Eyes.setBackground(Color.WHITE);
        add(Eyes);

        Eno = new JRadioButton("No");
        Eno.setBounds(400,530,100,30);
        Eno.setFont(new Font("Verdana", Font.PLAIN, 18));
        Eno.setBackground(Color.WHITE);
        add(Eno);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(Eno);
        buttonGroup1.add(Eyes);


        //Next BUtton
        next= new JButton("Next");
        next.setBounds(600,630,100,40);
        next.setFont(new Font("VERDANA", Font.BOLD, 22));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
    }


    public void actionPerformed(ActionEvent e){

        String reg = (String) religionBox.getSelectedItem();
        String cata = (String) catagoryBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String occup = (String) occupationBox.getSelectedItem();
        String educ = (String) educationBox.getSelectedItem();
        String Aadhar =(String) aadharTextField.getText();
        String pan = panTextField.getText();
        String seniorVal = null;
        if(Syes.isSelected()) seniorVal = "Yes";
        else if(Sno.isSelected()) seniorVal ="No";

        String existVal = null;
        if(Eyes.isSelected()) existVal = "Yes";
        else if(Eno.isSelected()) existVal ="No";

        try{
            conn c1 = new conn();
            String query = "INSERT INTO AdditionalDetails(Form_NO,Religion,Catagory,Income,Occupation,Educational_Qualification,Aadhar_Number,Pan_Details,Senior_Citizen,Existing_customer)  Values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c1.getConnection().prepareStatement(query);
            ps.setString(1,formno);
            ps.setString(2,reg);
            ps.setString(3,cata);
            ps.setString(4,income);
            ps.setString(5,occup);
            ps.setString(6,educ);
            ps.setString(7,Aadhar);
            ps.setString(8,pan);
            ps.setString(9,seniorVal);
            ps.setString(10,existVal);

            int rowInserted = ps.executeUpdate();

            if(rowInserted>0){
                System.out.println("Row Inserted Succesfuly");
            }else{
                System.out.println("No row is inserted , check query");
            }

            ps.close();
            new SignUpThree(formno).setVisible(true);
            setVisible(false);
        }catch(Exception e2){
            System.out.println(e2);
        }
    }

    public static void main(String [] args){
        new SignUpPage2("");
    }
}

