
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Harun Serkan Metin
 */
public class userPanel extends javax.swing.JFrame {
    ArrayList<user> userInfo;
    ArrayList<ticket> ticketInfo;
    ArrayList<Flight> FlightInfo ;
    ArrayList<airport> AirportInfo;
    ArrayList<airplane> AirplaneInfo;
    ArrayList<seat> SeatInfo;    
    
    DefaultTableModel model;
    DefaultTableModel YolcuAramodel;
    DefaultTableModel UcusAraModel;

    
    String TC;
    String TCArama,isimArama,soyisimArama;
    
    public userPanel(String Name,String tc) {
        initComponents();
        TC=tc;
        model=(DefaultTableModel)tableYaklasan.getModel();
        YolcuAramodel=(DefaultTableModel)tableYolcuAra.getModel();
        UcusAraModel = (DefaultTableModel)tableUcusAra.getModel();
        labelAdChange.setText(Name);
        try{
            userInfo   = getUserInfo();
            ticketInfo = getTicketInfo();
            FlightInfo = getFlightInfo();
            AirportInfo = getAirportInfo();
            AirplaneInfo  = getAirplaneInfo();
            SeatInfo=       getSeatInfo();

            comboNereden.removeAllItems();
            comboNereye.removeAllItems();
            for(airport a:AirportInfo) {comboNereden.addItem(a.getAirport_loc());comboNereye.addItem(a.getAirport_loc());}

            for (Flight f:FlightInfo){
                for(ticket t:ticketInfo){
                        if(t.getAirplane_id().equals(f.getAirplane_id())&&TC.equals(t.getPass_ssn())){
                            Object[] row={t.getSeat_num(),f.getWhere_from(),f.getWhere_to(),f.getAirport_name()};
                            model.addRow(row);   
                        }               
                 }   
             }
        }catch(SQLException e){}
       setVisible(true);
    }
    public ArrayList<ticket> getTicketInfo() throws SQLException{
        Connection connection = null;
        
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<ticket> res=null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from flightapp.ticket");
            res=new ArrayList<ticket>() ;
            while (resultSet.next()) {
               res.add(new ticket(
                       resultSet.getString("pnr"),
                       resultSet.getString("seat_num"),
                       resultSet.getString("flight_id"),
                       resultSet.getString("airplane_id"),
                       resultSet.getString("airport_id"),
                       resultSet.getString("airport_name"),
                       resultSet.getString("pas_ssn")
               ));
            }

        } catch (SQLException e) {dbHelper.showError(e);}
        finally{
            statement.close();
            connection.close();
        }
        return res;
    }
    
    public ArrayList<airport> getAirportInfo() throws SQLException{
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<airport> res=null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from flightapp.airport");
            res=new ArrayList<airport>() ;
            while (resultSet.next()) {
               res.add(new airport(
                       resultSet.getString("airport_id"),
                       resultSet.getString("airport_name"),
                       resultSet.getString("airport_loc")
               ));
            }

        } catch (SQLException e) {
            dbHelper.showError(e);
            
        }
        finally{
            
            statement.close();
            connection.close();
        }
        return res;
    }
    public ArrayList<airplane> getAirplaneInfo() throws SQLException{
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<airplane> res=null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from flightapp.airplane");
            res=new ArrayList<airplane>() ;
            while (resultSet.next()) {
               res.add(new airplane(
                       resultSet.getString("airplane_id"),
                       resultSet.getInt("seat_count"),
                       resultSet.getString("airport_id")
               ));
            }

        } catch (SQLException e) {
            dbHelper.showError(e);
            
        }
        finally{
            
            statement.close();
            connection.close();
        }
        return res;
    }
    public ArrayList<seat> getSeatInfo() throws SQLException{
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<seat> res=null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from flightapp.seat");
            res=new ArrayList<seat>() ;
            while (resultSet.next()) {
               res.add(new seat(
                       resultSet.getString("seat_num"),
                       resultSet.getInt("is_booked"),
                       resultSet.getString("airplane_id")
               ));
            }

        } catch (SQLException e) {
            dbHelper.showError(e);
            
        }
        finally{
            
            statement.close();
            connection.close();
        }
        return res;
    }    
    public ArrayList<user> getUserInfo() throws SQLException{
        Connection connection = null;
       
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<user> res=null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from flightapp.user");
            res=new ArrayList<user>() ;
            while (resultSet.next()) {
               res.add(new user(
                       resultSet.getString("user_ssn"),
                       resultSet.getString("user_password"),
                       resultSet.getString("user_mail"),
                       resultSet.getString("user_tel"),
                       resultSet.getString("user_adress"),
                       resultSet.getString("fname"),
                       resultSet.getString("lname"),
                       resultSet.getInt("acceslevel"),
                       resultSet.getString("user_birthdate"),
                       resultSet.getString("user_age")
               ));
            }

        } catch (SQLException e) {
            dbHelper.showError(e);
            
        }
        finally{
            
            statement.close();
            connection.close();
        }
        return res;
    }
    public ArrayList<Flight> getFlightInfo() throws SQLException{
        Connection connection = null;
        
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Flight> res=null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from flightapp.flightinfo");
            res=new ArrayList<Flight>() ;
            while (resultSet.next()) {
               res.add(new Flight(
                       resultSet.getString("flight_id"),
                       resultSet.getString("plane_gate"),
                       resultSet.getString("departure_date"),
                       resultSet.getString("departure_time"),
                       resultSet.getString("where_from"),
                       resultSet.getString("where_to"),
                       resultSet.getString("airport_id"),
                       resultSet.getString("airport_name"),
                       resultSet.getString("airplane_id")
               ));
            }

        } catch (SQLException e) {
            dbHelper.showError(e);
            
        }
        finally{
            
            statement.close();
            connection.close();
        }
        
        
        return res;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelAdChange = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableYaklasan = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textTCAra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textIsimAra = new javax.swing.JTextField();
        textSoyisimAra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        buttonYolcuArama = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableYolcuAra = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        comboNereden = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dateGidis = new com.toedter.calendar.JDateChooser();
        comboNereye = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        buttonUcusAra = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableUcusAra = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        buttonGeri = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel2.setText("Fligth App'e Hoşgeldiniz");

        labelAdChange.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        labelAdChange.setText("ADINIZ");

        tableYaklasan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Seat Num", "From", "To", "Airport Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableYaklasan);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 153));
        jTextField1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Yaklaşan Uçuşlarınız");
        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAdChange, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelAdChange))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setText("TCKN:");

        textTCAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTCAraActionPerformed(evt);
            }
        });

        jLabel6.setText("İsim");

        jLabel7.setText("Soyisim");

        textIsimAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIsimAraActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("sansserif", 2, 10)); // NOI18N
        jLabel8.setText("TCKN Biliniyorsa İsim Soyisim yazılmasına gerek yoktur.");

        buttonYolcuArama.setBackground(new java.awt.Color(204, 255, 204));
        buttonYolcuArama.setText("Arama");
        buttonYolcuArama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYolcuAramaActionPerformed(evt);
            }
        });

        tableYolcuAra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "PNR", "Seat Num", "Gate Num", "Departure", "Arrival", "Date", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableYolcuAra.setColumnSelectionAllowed(true);
        tableYolcuAra.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tableYolcuAra);
        tableYolcuAra.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(buttonYolcuArama, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textTCAra, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5))
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textIsimAra)
                                .addComponent(textSoyisimAra, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(textIsimAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textSoyisimAra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textTCAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(buttonYolcuArama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Yolcu Ara", jPanel2);

        comboNereden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Nereden:");

        jLabel9.setText("Gidiş Tarihi:");

        comboNereye.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboNereye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNereyeActionPerformed(evt);
            }
        });

        jLabel12.setText("Nereye:");

        buttonUcusAra.setBackground(new java.awt.Color(204, 255, 204));
        buttonUcusAra.setText("Uçuş Ara");
        buttonUcusAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUcusAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(comboNereden, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateGidis, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboNereye, 0, 205, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUcusAra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboNereden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNereye, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateGidis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonUcusAra))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tableUcusAra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Departure Time", "Airport Name", "Avaliable Seats"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tableUcusAra);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Uçuş Ara", jPanel3);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buttonGeri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo_1.png"))); // NOI18N
        buttonGeri.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        buttonGeri.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonGeri.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonGeri.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        buttonGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGeriActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 2, 12)); // NOI18N
        jLabel3.setText("Login Ekranına Dön");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("tab");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void textTCAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTCAraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTCAraActionPerformed

    private void textIsimAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIsimAraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIsimAraActionPerformed

    private void buttonYolcuAramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYolcuAramaActionPerformed
        TCArama=textTCAra.getText();
        isimArama=textIsimAra.getText();
        soyisimArama=textSoyisimAra.getText();
        YolcuAramodel.setRowCount(0);     

        if(TCArama.equals("")){
            for(user i:userInfo){
                if(i.getFname().equals(isimArama.trim())&&i.getLname().equals(soyisimArama.trim())){
                    TCArama=i.getUser_ssn();
                    for (ticket t:ticketInfo){
                        Object[] row=new Object[7];
                        if(TCArama.equals(t.getPass_ssn())){
                            row[0]=t.getPnr();
                            row[1]=t.getSeat_num();
                            row[2]=t.getAirport_name();
                            String id = t.getAirport_id();
                            for (Flight f:FlightInfo){
                               if(id.equals(f.getAirport_id())){
                                   row[3]=f.getWhere_to();
                                   row[4]=f.getPlane_gate();
                                   row[5]=f.getDeparture_date();
                                   row[6]=f.getDeparture_time();
                                   break;
                                }
                            }
                            YolcuAramodel.addRow(row);
                        }
                        
                    }  
                }
            }
        }else{
                    for (ticket t:ticketInfo){
                        Object[] row=new Object[7];
                        if(TCArama.equals(t.getPass_ssn())){
                            row[0]=t.getPnr();
                            row[1]=t.getSeat_num();
                            row[2]=t.getAirport_name();
                            String id=t.getAirport_id();
                            for (Flight f:FlightInfo){
                                if(id.equals(f.getAirport_id())){
                                    row[3]=f.getWhere_to();
                                    row[4]=f.getPlane_gate();
                                    row[5]=f.getDeparture_date();
                                    row[6]=f.getDeparture_time();
                                }
                            }
                        }
                      YolcuAramodel.addRow(row);  
                    }
                    
        
        }
        textTCAra.setText("");
        textIsimAra.setText("");
        textSoyisimAra.setText("");
        
        
    }//GEN-LAST:event_buttonYolcuAramaActionPerformed

    private void buttonUcusAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUcusAraActionPerformed
        UcusAraModel.setRowCount(0);
        String nereden = (String) comboNereden.getSelectedItem();
        String nereye = (String) comboNereye.getSelectedItem();
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String date = dcn.format(dateGidis.getDate() );
        Object[] row=new Object[3];
        for(Flight f:FlightInfo){
            if(f.getDeparture_date().equals(date)&&f.getWhere_from().equals(nereden)&&f.getWhere_to().equals(nereye)){
                row[0]=f.getDeparture_time();
                row[1]=f.getAirport_name();
                int total=0;
                for(seat s:SeatInfo){
                    if(f.getAirplane_id().equals(s.getAirplane_id())&&s.getIs_booked()==0){
                        total++;
                    }
                }
                row[2]=total;
            }
        }
        UcusAraModel.addRow(row);
    }//GEN-LAST:event_buttonUcusAraActionPerformed

    private void comboNereyeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNereyeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboNereyeActionPerformed

    private void buttonGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGeriActionPerformed
        enter e=new enter();
        e.main(null);
        setVisible(false);
    }//GEN-LAST:event_buttonGeriActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(userPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGeri;
    private javax.swing.JButton buttonUcusAra;
    private javax.swing.JButton buttonYolcuArama;
    private javax.swing.JComboBox<String> comboNereden;
    private javax.swing.JComboBox<String> comboNereye;
    private com.toedter.calendar.JDateChooser dateGidis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelAdChange;
    private javax.swing.JTable tableUcusAra;
    private javax.swing.JTable tableYaklasan;
    private javax.swing.JTable tableYolcuAra;
    private javax.swing.JTextField textIsimAra;
    private javax.swing.JTextField textSoyisimAra;
    private javax.swing.JTextField textTCAra;
    // End of variables declaration//GEN-END:variables
}
