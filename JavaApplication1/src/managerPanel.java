
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class managerPanel extends javax.swing.JFrame {
 
    ArrayList<user> userInfo;
    ArrayList<airplane> airplaneInfo; 
    ArrayList<crew> crewInfo;
    
    DefaultTableModel userModel;
    DefaultTableModel planeModel;
    DefaultTableModel crewModel;    
    DefaultTableModel crewInfoModel;
    
    public managerPanel() {
        initComponents();
        refreshUserTable();
        refreshPlaneTable();
        refreshCrewTable();
    }
    public void refreshCrewTable(){
        crewModel=(DefaultTableModel)tableCrew.getModel();
        crewModel.setRowCount(0);
        try{
            crewInfo=getCrewInfo();
            for (crew c:crewInfo){
                Object[] row={c.getCrew_id(),c.getAirplane_id()};
                crewModel.addRow(row); 
             }
        }catch(SQLException e){}
    }
    public void refreshPlaneTable(){
        planeModel=(DefaultTableModel)tableAirplane.getModel();
        planeModel.setRowCount(0);
        try{
            airplaneInfo=getAirplaneInfo();
            for (airplane a:airplaneInfo){
                Object[] row={a.getAirplane_id(),a.getSeat_count(),a.getAirport_id()};
                planeModel.addRow(row); 
             }
        }catch(SQLException e){}
    }
    public void refreshUserTable(){
        userModel=(DefaultTableModel)tableUserInfo.getModel();
        userModel.setRowCount(0);
        try{
            userInfo   = getUserInfo();
            for (user u:userInfo){
                Object[] row={u.getUser_ssn(),u.getUser_password(),u.getUser_tel(),u.getUser_adress(),
                u.getFname(),u.getLname(),u.getAcceslevel(),u.getUser_birthdate(),u.getUser_age()};
                userModel.addRow(row); 
             }
        }catch(SQLException e){}
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
        } catch (SQLException e) {dbHelper.showError(e);}
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
     public ArrayList<crew> getCrewInfo() throws SQLException{
        Connection connection = null;
        
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<crew> res=null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from flightapp.crew");
            res=new ArrayList<crew>() ;
            while (resultSet.next()) {
               res.add(new crew(
                       resultSet.getString("crew_id"),
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textTelAra = new javax.swing.JTextField();
        textTCAraUser = new javax.swing.JTextField();
        checkTC = new javax.swing.JCheckBox();
        checkTel = new javax.swing.JCheckBox();
        textSoyadAra = new javax.swing.JTextField();
        textIsimAra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        checkIsim = new javax.swing.JCheckBox();
        checkSoyisim = new javax.swing.JCheckBox();
        buttonUserAra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUserInfo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textTelEkle = new javax.swing.JTextField();
        textSoyadEkle = new javax.swing.JTextField();
        textIsimEkle = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textTCEkle = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        buttonUserSil = new javax.swing.JButton();
        textTCSil = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textPassEkle = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textEmailEkle = new javax.swing.JTextField();
        textAdressEkle = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        textAccesLevelEkle = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        DateChooserEkle = new com.toedter.calendar.JDateChooser();
        buttonUserEkle = new javax.swing.JButton();
        labelSonuc = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAirplane = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCrew = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        textIdCrew = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        checkIdCrew = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        textAdCrew = new javax.swing.JTextField();
        checkSoyadCrew = new javax.swing.JCheckBox();
        textSoyadCrew = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableCrewInfo = new javax.swing.JTable();
        checkAdCrew = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        buttonCrewAra = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        textAreaQuery = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        btnQuery = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        textAreaResult = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        buttonClear = new javax.swing.JButton();

        jLabel19.setText("jLabel19");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("MANAGER INTERFACE");

        jLabel5.setFont(new java.awt.Font("sansserif", 2, 10)); // NOI18N
        jLabel5.setText("Hangi filtreye göre arama yapmak istiyorsanız işartleyiniz");

        jLabel2.setText("TCKN:");

        jLabel3.setText("Telefon:");

        checkTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTCActionPerformed(evt);
            }
        });

        checkTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTelActionPerformed(evt);
            }
        });

        jLabel6.setText("İsim");

        jLabel7.setText("Soyisim");

        checkIsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkIsimActionPerformed(evt);
            }
        });

        checkSoyisim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSoyisimActionPerformed(evt);
            }
        });

        buttonUserAra.setText("User Ara");
        buttonUserAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textTelAra, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkTel))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textTCAraUser, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkTC)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textIsimAra)
                            .addComponent(textSoyadAra, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(checkSoyisim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addComponent(buttonUserAra, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(checkIsim)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel5))
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkTC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(textTCAraUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(6, 6, 6))
                            .addComponent(textTelAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkTel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textIsimAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textSoyadAra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(checkIsim, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonUserAra)
                            .addComponent(checkSoyisim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tableUserInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "user_ssn", "user_password", "user_tel", "user_adress", "fname", "lname", "acceslevel", "user_birthdate", "user_age"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableUserInfo);
        if (tableUserInfo.getColumnModel().getColumnCount() > 0) {
            tableUserInfo.getColumnModel().getColumn(1).setHeaderValue("user_password");
            tableUserInfo.getColumnModel().getColumn(6).setHeaderValue("acceslevel");
            tableUserInfo.getColumnModel().getColumn(7).setHeaderValue("user_birthdate");
            tableUserInfo.getColumnModel().getColumn(8).setHeaderValue("user_age");
        }

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setText("Telefon:");

        jLabel9.setText("İsim");

        jLabel10.setText("Soyisim");

        jLabel11.setText("TCKN:");

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));

        buttonUserSil.setText("User Sil");
        buttonUserSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserSilActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TCKN:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonUserSil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textTCSil)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textTCSil, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonUserSil)
                .addGap(26, 26, 26))
        );

        jLabel12.setText("Password:");

        jLabel13.setText("Email:");

        jLabel14.setText("Adress:");

        jLabel15.setText("Acces Level:");

        jLabel16.setText("Doğum Tarihi");

        buttonUserEkle.setText("User Ekle");
        buttonUserEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserEkleActionPerformed(evt);
            }
        });

        labelSonuc.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSonuc, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textTCEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textTelEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textPassEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(42, 42, 42)
                                .addComponent(textEmailEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42)
                                    .addComponent(textIsimEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(33, 33, 33)
                                    .addComponent(textSoyadEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAdressEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textAccesLevelEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(buttonUserEkle, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateChooserEkle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(labelSonuc, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(textIsimEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)
                                .addComponent(textTCEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(DateChooserEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textEmailEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(textPassEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(textSoyadEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textTelEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(textAdressEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textAccesLevelEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonUserEkle)
                                .addComponent(jLabel15)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Users Info", jPanel1);

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        tableAirplane.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "airplane_id", "seat_count", "airport_id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableAirplane);
        if (tableAirplane.getColumnModel().getColumnCount() > 0) {
            tableAirplane.getColumnModel().getColumn(1).setResizable(false);
            tableAirplane.getColumnModel().getColumn(2).setResizable(false);
            tableAirplane.getColumnModel().getColumn(2).setHeaderValue("airport_id");
        }

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("ALL AIRPLANES");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

        tableCrew.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "crew_id", "airplane_id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableCrew);
        if (tableCrew.getColumnModel().getColumnCount() > 0) {
            tableCrew.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ALL CREWS");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        jLabel20.setText("Search Crew Member");

        jLabel21.setText("Crew Id:");

        checkIdCrew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkIdCrewActionPerformed(evt);
            }
        });

        jLabel22.setText("Ad:");

        checkSoyadCrew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSoyadCrewActionPerformed(evt);
            }
        });

        tableCrewInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "crew_id", "user_ssn", "user_tel", "user_adress", "fname", "lname"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableCrewInfo);

        checkAdCrew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAdCrewActionPerformed(evt);
            }
        });

        jLabel23.setText("Soyad:");

        buttonCrewAra.setText("Crew Ara");
        buttonCrewAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrewAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textSoyadCrew, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkSoyadCrew))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textAdCrew, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkAdCrew)))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textIdCrew, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkIdCrew))
                                    .addComponent(buttonCrewAra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(textAdCrew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(checkAdCrew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(textIdCrew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(checkIdCrew, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textSoyadCrew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addComponent(checkSoyadCrew, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCrewAra))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Crew Info", jPanel2);

        textAreaQuery.setColumns(20);
        textAreaQuery.setRows(5);
        jScrollPane5.setViewportView(textAreaQuery);

        jLabel24.setText("Query Area:");

        btnQuery.setBackground(new java.awt.Color(255, 255, 204));
        btnQuery.setText("Query");
        btnQuery.setToolTipText("");
        btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueryActionPerformed(evt);
            }
        });

        textAreaResult.setColumns(20);
        textAreaResult.setRows(5);
        jScrollPane6.setViewportView(textAreaResult);

        jLabel25.setText("Result:");

        buttonClear.setBackground(new java.awt.Color(255, 153, 153));
        buttonClear.setText("Clear");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(597, 770, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuery)
                    .addComponent(buttonClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );

        jTabbedPane1.addTab("Query", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("tab2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUserAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUserAraActionPerformed
        String Query="SELECT * FROM user where ";
        if(durumTC) Query+="user_ssn='"+textTCAraUser.getText()+"' and ";
        if(durumTel) Query+="user_tel='"+textTelAra.getText()+"' and ";
        if(durumIsim) Query+="fname='"+textIsimAra.getText()+"' and ";
        if(durumSoyisim) Query+="lname='"+textSoyadAra.getText()+"' and ";
        Query=Query.substring(0, Query.length() - 4);
        Query+=";";
        textTCAraUser.setText("");
        textTelAra.setText("");
        textIsimAra.setText("");
        textSoyadAra.setText("");      
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<user> res=null;
          try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Query);
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
            statement.close();
            connection.close();
        } catch (SQLException e) {
            dbHelper.showError(e);
            
        }
        userModel=(DefaultTableModel)tableUserInfo.getModel();
        userModel.setRowCount(0);

        for (user u:res){
            Object[] row={u.getUser_ssn(),u.getUser_password(),u.getUser_tel(),u.getUser_adress(),
                u.getFname(),u.getLname(),u.getAcceslevel(),u.getUser_birthdate(),u.getUser_age()};
             userModel.addRow(row); 
        }
        if(!durumTC&&!durumTel&&!durumIsim&&!durumSoyisim){
            refreshUserTable();
        }
        

    }//GEN-LAST:event_buttonUserAraActionPerformed
    boolean durumTC=false;
    boolean durumTel=false;
    boolean durumIsim=false;
    boolean durumSoyisim=false;
    private void checkTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTCActionPerformed
       durumTC=!durumTC;
    }//GEN-LAST:event_checkTCActionPerformed

    private void checkTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTelActionPerformed
        durumTel=!durumTel;
    }//GEN-LAST:event_checkTelActionPerformed

    private void checkIsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkIsimActionPerformed
        durumIsim=!durumIsim;
    }//GEN-LAST:event_checkIsimActionPerformed

    private void checkSoyisimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSoyisimActionPerformed
        durumSoyisim=!durumSoyisim;
    }//GEN-LAST:event_checkSoyisimActionPerformed

    private void buttonUserSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUserSilActionPerformed
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        String TC = textTCSil.getText();
         try {
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                statement.executeUpdate("DELETE FROM user WHERE user_ssn='"+TC+"';");
                statement.close();
                connection.close();
                labelSonuc.setText("Başarıyla SİLİNDİ");
                refreshUserTable();
                textTCSil.setText("");
            } catch (SQLException e) {
                dbHelper.showError(e);
                labelSonuc.setText("Database HATASI");
            }
    }//GEN-LAST:event_buttonUserSilActionPerformed
   public static int calculateAge(String date)   
    {  
        LocalDate dob = LocalDate.parse(date);  
        LocalDate curDate = LocalDate.now();  
        if ((dob != null) && (curDate != null)) return Period.between(dob, curDate).getYears();  
        else return 0;  
    }  
    private void buttonUserEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUserEkleActionPerformed
       
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
     


        if(!(textTCEkle.getText().equals("")&&textPassEkle.getText().equals("")&&textEmailEkle.getText().equals("")&&textTelEkle.getText().equals("")&&textAdressEkle.getText().equals("")&&textIsimEkle.getText().equals("")&&textSoyadEkle.getText().equals("")&&DateChooserEkle.getDateFormatString()!=null)){
                    SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
                    String date = dcn.format(DateChooserEkle.getDate() );
                    String q="INSERT INTO user VALUES ('"+textTCEkle.getText()+"' , '"+ textPassEkle.getText()+"' , ' "+ textEmailEkle.getText()+"' , '"+textTelEkle.getText()+"' , '"+
                         textAdressEkle.getText()+"' , '" +textIsimEkle.getText()+"' , '"+textSoyadEkle.getText() +"' , "+0+" , '"+date+"' , '"+calculateAge(date)+"');";
                System.out.println(q);
            try {
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                statement.executeUpdate(q);
                statement.close();
                connection.close();
                labelSonuc.setText("Başarıyla Eklendi");
                refreshUserTable();
            } catch (SQLException e) {
                dbHelper.showError(e);
                labelSonuc.setText("Database HATASI");
            }
            textTCEkle.setText("");
            textPassEkle.setText("");
            textEmailEkle.setText("");
            textTelEkle.setText("");
            textAdressEkle.setText("");
            textAccesLevelEkle.setText("");
            textIsimEkle.setText("");
            textSoyadEkle.setText("");
        }
        else{
            labelSonuc.setText("Lütfen Bilgileri Eksiksiz Girin ");
        }
    }//GEN-LAST:event_buttonUserEkleActionPerformed

    private void checkIdCrewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkIdCrewActionPerformed
        CId=!CId;
    }//GEN-LAST:event_checkIdCrewActionPerformed

    private void checkSoyadCrewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSoyadCrewActionPerformed
        CSoyad=!CSoyad;
    }//GEN-LAST:event_checkSoyadCrewActionPerformed

    private void checkAdCrewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAdCrewActionPerformed
      CAd=!CAd;
    }//GEN-LAST:event_checkAdCrewActionPerformed
    Boolean CId=false;
    Boolean CAd=false;
    Boolean CSoyad=false;
    private void buttonCrewAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrewAraActionPerformed
        String Query="SELECT c.crew_id,u.user_ssn,u.user_tel,u.user_adress,u.fname,u.lname FROM user as u,crew AS c ,pilot as p,copilot as cp,hostess as h WHERE ";
        if(CId) Query+="(p.crew_id='"+textIdCrew.getText()+"' and u.user_ssn=p.pilot_ssn )or(cp.crew_id='"+textIdCrew.getText()+"' and u.user_ssn=cp.co_pilot_ssn ) or(h.crew_id='"+textIdCrew.getText()+"' and u.user_ssn=h.hostess_ssn)";
        if(CAd) Query+="fname='"+textAdCrew.getText()+"' and ";
        if(CSoyad) Query+="Lname='"+textSoyadCrew.getText()+"' and ";
        Query=Query.substring(0, Query.length() - 4);
        Query+=";";
        textIdCrew.setText("");
        textAdCrew.setText("");
        textSoyadCrew.setText("");
        
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;

          try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Query);
            crewInfoModel=(DefaultTableModel)tableCrewInfo.getModel();
            crewInfoModel.setRowCount(0);
            while (resultSet.next()) {
                   Object[] row={resultSet.getString("crew_id"),
                       resultSet.getString("user_ssn"),
                       resultSet.getString("user_tel"),
                       resultSet.getString("user_adress"),
                       resultSet.getString("fname"),
                       resultSet.getString("lname")};
                   crewInfoModel.addRow(row); 
               
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            dbHelper.showError(e);
        }
    }//GEN-LAST:event_buttonCrewAraActionPerformed

    private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryActionPerformed
        String QUERY=textAreaQuery.getText();
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Object> res=null;

        String result="";
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(QUERY);
            ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            res=new ArrayList<Object>() ;
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) result+=", \n";
                    String columnValue = resultSet.getString(i);
                    result+=("|  "+columnValue + "\t" + rsmd.getColumnName(i)+"\t|");
                }
                result+=("\n---------------------------------------------------------\n");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            dbHelper.showError(e);

        }
        textAreaResult.setText(result);

    }//GEN-LAST:event_btnQueryActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
           textAreaResult.setText("");
           textAreaQuery.setText("");
    }//GEN-LAST:event_buttonClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(managerPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managerPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managerPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managerPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managerPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooserEkle;
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonCrewAra;
    private javax.swing.JButton buttonUserAra;
    private javax.swing.JButton buttonUserEkle;
    private javax.swing.JButton buttonUserSil;
    private javax.swing.JCheckBox checkAdCrew;
    private javax.swing.JCheckBox checkIdCrew;
    private javax.swing.JCheckBox checkIsim;
    private javax.swing.JCheckBox checkSoyadCrew;
    private javax.swing.JCheckBox checkSoyisim;
    private javax.swing.JCheckBox checkTC;
    private javax.swing.JCheckBox checkTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelSonuc;
    private javax.swing.JTable tableAirplane;
    private javax.swing.JTable tableCrew;
    private javax.swing.JTable tableCrewInfo;
    private javax.swing.JTable tableUserInfo;
    private javax.swing.JTextField textAccesLevelEkle;
    private javax.swing.JTextField textAdCrew;
    private javax.swing.JTextField textAdressEkle;
    private javax.swing.JTextArea textAreaQuery;
    private javax.swing.JTextArea textAreaResult;
    private javax.swing.JTextField textEmailEkle;
    private javax.swing.JTextField textIdCrew;
    private javax.swing.JTextField textIsimAra;
    private javax.swing.JTextField textIsimEkle;
    private javax.swing.JTextField textPassEkle;
    private javax.swing.JTextField textSoyadAra;
    private javax.swing.JTextField textSoyadCrew;
    private javax.swing.JTextField textSoyadEkle;
    private javax.swing.JTextField textTCAraUser;
    private javax.swing.JTextField textTCEkle;
    private javax.swing.JTextField textTCSil;
    private javax.swing.JTextField textTelAra;
    private javax.swing.JTextField textTelEkle;
    // End of variables declaration//GEN-END:variables
}
