package UIpkg;
import java.io.*;
import java.net.*;
import DBpkg.dbConnection;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
/**
 *
 * @author Banu Nissanka
 */


public class clientFrame extends javax.swing.JFrame
{
    Connection conn;
    String userRequest;
    int i=0;
    int quesno=1; //To display question number
    String[] writeQuestion = new String[5]; //array to store 5 random questions out of the 10 questions @ db
    String[] opt1 = new String[5]; //array to store option 1 of 5 randomly selected questions
    String[] opt2 = new String[5]; //array to store option 2 of 5 randomly selected questions
    String[] opt3 = new String[5]; //array to store option 3 of 5 randomly selected questions
    String[] opt4 = new String[5]; //array to store option 4 of 5 randomly selected questions
    String[] ans = new String[5]; //array to store correct answers for 5 randomly selected questions
    String[] StudentAns = new String[6]; //array to store user answers for the five questions(index 1-6)

    /** Creates new form clientFrame */
    public clientFrame() throws ClassNotFoundException, SQLException
    {
        requestQuestion();
        displayQuestion();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">


    private void displayQuestion()//**displays the question sent by the RUSL database
    {
	if(i<5){
        question = new javax.swing.JLabel();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        question.setText(quesno +")  "+writeQuestion[i]);
		

        option1.setText(opt1[i]);
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });

        option2.setText(opt2[i]);

        option3.setText(opt3[i]);

        option4.setText(opt4[i]);

        btnNext.setText("Next");

        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(option4,javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(option3,javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(option2,javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(option1,javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnNext)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(option1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnNext)
                .addGap(42, 42, 42))
        );


        pack();
		i++;
                quesno++;
        }
    }// </editor-fold>





    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         if (option1.isSelected()) {
                    StudentAns[i] = option1.getText();
                    }
         else if (option2.isSelected()) {
                    StudentAns[i] = option2.getText();
                    }
         else if (option3.isSelected()) {
                    StudentAns[i] = option3.getText();
                    }
         else if(option4.isSelected()) {
                    StudentAns[i] = option4.getText();
                    }
        String result;

// submit after 5 questions
if(i!=5){


                                //clear previous question & answer set
				remove(question);
                                remove(option1);
                                remove(option2);
                                remove(option3);
                                remove(option4);
                                remove(btnNext);

				displayQuestion();// call for the next question
}

else{

                btnNext.setText("Submit");
try
{

/*create a socket to connect to the user*/
BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
Socket clientSocket = new Socket("localhost", 3012);
/*get input and output stream*/
DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
/*communicating with the server*/
//**forward the student’s answer to the particular question to the central server
userRequest =StudentAns[1];
outToServer.writeBytes(userRequest + '\n');
userRequest =StudentAns[2];
outToServer.writeBytes(userRequest + '\n');
userRequest =StudentAns[3];
outToServer.writeBytes(userRequest + '\n');
userRequest =StudentAns[4];
outToServer.writeBytes(userRequest + '\n');
userRequest =StudentAns[5];
outToServer.writeBytes(userRequest + '\n');

userRequest =ans[0];
outToServer.writeBytes(userRequest + '\n');
userRequest =ans[1];
outToServer.writeBytes(userRequest + '\n');
userRequest =ans[2];
outToServer.writeBytes(userRequest + '\n');
userRequest =ans[3];
outToServer.writeBytes(userRequest + '\n');
userRequest =ans[4];
outToServer.writeBytes(userRequest + '\n');


//**request the final mark and display it.
result = inFromServer.readLine();
JOptionPane.showMessageDialog(null,"You have scored "+ result +" out of 5","Result", JOptionPane.INFORMATION_MESSAGE);
clientSocket.close();
}
catch (Exception e)
{
// TODO add your handling code here:
}
}
    }


    public void requestQuestion()//**request randomly selected 5 questions from the db
    {
        int x = 0;
        //creating an array with Random 5 question ID`s
        int[] qno = new int[5];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int no=1; no<11; no++) {
            list.add(new Integer(no));
        }
        Collections.shuffle(list);
        for (int num=0; num<5; num++) {
            qno[num]=list.get(num);//Array qno holds the randomly selected question ID`s
        }

       //fill arrays by fetching database
       while(x<5){
            try {
            conn =(Connection) dbConnection.createDatabaseConnection();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM questionsstore WHERE qid=" + qno[x]);

                    while (res.next())
                    {
                    writeQuestion[x] = res.getString("question");
                    opt1[x] = res.getString("op1");
                    opt2[x] = res.getString("op2");
                    opt3[x] = res.getString("op3");
                    opt4[x] = res.getString("op4");
                    ans[x] = res.getString("answer");
                    }
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
        x++;
       }
    }



    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new clientFrame().setVisible(true);
                    }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(clientFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                catch (SQLException ex) {
                    Logger.getLogger(clientFrame.class.getName()).log(Level.SEVERE, null, ex);
                                        }
            }
        });


    }



    // Variables declaration - do not modify
    private javax.swing.JButton btnNext;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private javax.swing.JLabel question;
    // End of variables declaration

}
