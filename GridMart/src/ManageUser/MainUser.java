package ManageUser;

import Main.RunHere;
import MainManagement.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;


public class MainUser extends javax.swing.JFrame {


    public MainUser() {
        initComponents();
        setTitle("GridMart");
        addUsername();
        addLog();
        GlassPanePopup.install(this);
    }
    
    public void addUsername(){
        StorageUserPassPo.loadFromFile();

        ArrayList<UserPassPo> allUser = StorageUserPassPo.getAllUserPass();
        for (int i = 0; i < allUser.size(); i++) {
            UserPoPanel p = new UserPoPanel(allUser.get(i).getUsername(), allUser.get(i).getPosition());
            UserPoPanel x = new UserPoPanel(allUser.get(i).getUsername(), allUser.get(i).getPosition());
            UserPoEditPanel y = new UserPoEditPanel(allUser.get(i).getUsername(), allUser.get(i).getPosition());
            UserPoEditPanel z = new UserPoEditPanel(allUser.get(i).getUsername(), allUser.get(i).getPosition());
            
            PanelMain.add(p);
            PanelAdd.add(x);
            PanelEdit.add(y);
            PanelEditUser.add(z);
        }
    }

    public void addLog(){
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < Table.getColumnCount(); i++) {
            Table.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }

        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);

        StorageLog x = new StorageLog();
        x.clearStorage();

        StorageLog.loadFromFile();
        ArrayList<LoginLogout> allLog = StorageLog.getAllLog();
        for (int i = 0; i < allLog.size(); i++) {
            model.addRow(new Object[]{allLog.get(i).getDate(),allLog.get(i).getName(),allLog.get(i).getLogin(),allLog.get(i).getLogout()});
        }
         
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        UserMain = new Background.backgrounduser();
        PanelMain = new Rectangle.Rectangle();
        BackMain = new button.Button1();
        User = new CustomFont.LabelText();
        Iconuser = new javax.swing.JLabel();
        EditMain = new button.ButtonClear();
        AddMain = new button.ButtonClear();
        HistoryMain = new button.ButtonClear();
        UserEdit = new Background.backgrounduser();
        PanelEdit = new Rectangle.Rectangle();
        BackEdit = new button.Button1();
        AddEdit = new button.ButtonClear();
        User1 = new CustomFont.LabelText();
        Iconuser1 = new javax.swing.JLabel();
        EditEdit = new button.Button1();
        HistoryEdit = new button.ButtonClear();
        UserHistory = new Background.backgrounduser();
        Iconuser2 = new javax.swing.JLabel();
        AddHistory = new button.ButtonClear();
        EditHistory = new button.ButtonClear();
        BackHistory = new button.Button1();
        HistoryHistory = new button.Button1();
        User2 = new CustomFont.LabelText();
        scrollPaneWin112 = new Scroll.ScrollPaneWin11();
        Table = new javax.swing.JTable();
        UserAddUser = new Background.backgrounduser();
        PanelAdd = new Rectangle.Rectangle();
        BackAddUser = new button.Button1();
        EditAddUser = new button.ButtonClear();
        User3 = new CustomFont.LabelText();
        Iconuser3 = new javax.swing.JLabel();
        AddAddUser = new button.Button1();
        HistoryAddUser = new button.ButtonClear();
        UserEditUser = new Background.backgrounduser();
        PanelEditUser = new Rectangle.Rectangle();
        BackEditUser = new button.Button1();
        AddEditUser = new button.ButtonClear();
        User4 = new CustomFont.LabelText();
        Iconuser4 = new javax.swing.JLabel();
        EditEditUser = new button.Button1();
        HistoryEditUser = new button.ButtonClear();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1440, 1024));
        setResizable(false);

        MainPanel.setMaximumSize(new java.awt.Dimension(1440, 1024));
        MainPanel.setMinimumSize(new java.awt.Dimension(1440, 1024));
        MainPanel.setLayout(new java.awt.CardLayout());

        UserMain.setPreferredSize(new java.awt.Dimension(1440, 1024));

        PanelMain.setPreferredSize(new java.awt.Dimension(1237, 767));
        PanelMain.setRadius(80);
        PanelMain.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 60, 100));

        BackMain.setForeground(new java.awt.Color(54, 54, 54));
        BackMain.setText("Back");
        BackMain.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        BackMain.setPreferredSize(new java.awt.Dimension(130, 50));
        BackMain.setRadius(50);
        BackMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackMainMouseEntered(evt);
            }
        });
        BackMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackMainActionPerformed(evt);
            }
        });

        User.setText("User");
        User.setFont(new java.awt.Font("Afacad", 0, 65)); // NOI18N

        Iconuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Iconuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User.png"))); // NOI18N

        EditMain.setText("Edit");
        EditMain.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        EditMain.setPreferredSize(new java.awt.Dimension(130, 50));
        EditMain.setRadius(55);
        EditMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditMainMouseEntered(evt);
            }
        });
        EditMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMainActionPerformed(evt);
            }
        });

        AddMain.setText("Add");
        AddMain.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        AddMain.setPreferredSize(new java.awt.Dimension(130, 50));
        AddMain.setRadius(55);
        AddMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddMainMouseEntered(evt);
            }
        });
        AddMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMainActionPerformed(evt);
            }
        });

        HistoryMain.setText("History");
        HistoryMain.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        HistoryMain.setPreferredSize(new java.awt.Dimension(130, 50));
        HistoryMain.setRadius(55);
        HistoryMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HistoryMainMouseEntered(evt);
            }
        });
        HistoryMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryMainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UserMainLayout = new javax.swing.GroupLayout(UserMain);
        UserMain.setLayout(UserMainLayout);
        UserMainLayout.setHorizontalGroup(
            UserMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserMainLayout.createSequentialGroup()
                .addGroup(UserMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UserMainLayout.createSequentialGroup()
                        .addContainerGap(102, Short.MAX_VALUE)
                        .addComponent(PanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UserMainLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(Iconuser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HistoryMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(EditMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(AddMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101))
            .addGroup(UserMainLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(BackMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UserMainLayout.setVerticalGroup(
            UserMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserMainLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(UserMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UserMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EditMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AddMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(HistoryMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UserMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Iconuser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addComponent(PanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(BackMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        MainPanel.add(UserMain, "card2");

        PanelEdit.setPreferredSize(new java.awt.Dimension(1237, 767));
        PanelEdit.setRadius(80);
        PanelEdit.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 60, 100));

        BackEdit.setForeground(new java.awt.Color(54, 54, 54));
        BackEdit.setText("Back");
        BackEdit.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        BackEdit.setPreferredSize(new java.awt.Dimension(130, 50));
        BackEdit.setRadius(50);
        BackEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackEditMouseEntered(evt);
            }
        });
        BackEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackEditActionPerformed(evt);
            }
        });

        AddEdit.setText("Add");
        AddEdit.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        AddEdit.setPreferredSize(new java.awt.Dimension(130, 50));
        AddEdit.setRadius(55);
        AddEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddEditMouseEntered(evt);
            }
        });
        AddEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEditActionPerformed(evt);
            }
        });

        User1.setText("User");
        User1.setFont(new java.awt.Font("Afacad", 0, 65)); // NOI18N

        Iconuser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Iconuser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User.png"))); // NOI18N

        EditEdit.setText("Edit");
        EditEdit.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        EditEdit.setPreferredSize(new java.awt.Dimension(130, 50));
        EditEdit.setRadius(50);
        EditEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditEditMouseEntered(evt);
            }
        });
        EditEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditEditActionPerformed(evt);
            }
        });

        HistoryEdit.setText("History");
        HistoryEdit.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        HistoryEdit.setPreferredSize(new java.awt.Dimension(130, 50));
        HistoryEdit.setRadius(55);
        HistoryEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HistoryEditMouseEntered(evt);
            }
        });
        HistoryEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UserEditLayout = new javax.swing.GroupLayout(UserEdit);
        UserEdit.setLayout(UserEditLayout);
        UserEditLayout.setHorizontalGroup(
            UserEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserEditLayout.createSequentialGroup()
                .addGroup(UserEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UserEditLayout.createSequentialGroup()
                        .addContainerGap(102, Short.MAX_VALUE)
                        .addComponent(PanelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UserEditLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(Iconuser1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(User1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HistoryEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(EditEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(AddEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101))
            .addGroup(UserEditLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(BackEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UserEditLayout.setVerticalGroup(
            UserEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserEditLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(UserEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(UserEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EditEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(HistoryEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AddEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(User1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Iconuser1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(PanelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(BackEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        MainPanel.add(UserEdit, "card3");

        UserHistory.setFont(new java.awt.Font("Afacad", 0, 12)); // NOI18N

        Iconuser2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Iconuser2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User.png"))); // NOI18N

        AddHistory.setText("Add");
        AddHistory.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        AddHistory.setPreferredSize(new java.awt.Dimension(130, 50));
        AddHistory.setRadius(55);
        AddHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddHistoryMouseEntered(evt);
            }
        });
        AddHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddHistoryActionPerformed(evt);
            }
        });

        EditHistory.setText("Edit");
        EditHistory.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        EditHistory.setPreferredSize(new java.awt.Dimension(130, 50));
        EditHistory.setRadius(55);
        EditHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditHistoryMouseEntered(evt);
            }
        });
        EditHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditHistoryActionPerformed(evt);
            }
        });

        BackHistory.setForeground(new java.awt.Color(54, 54, 54));
        BackHistory.setText("Back");
        BackHistory.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        BackHistory.setPreferredSize(new java.awt.Dimension(130, 50));
        BackHistory.setRadius(50);
        BackHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackHistoryMouseEntered(evt);
            }
        });
        BackHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackHistoryActionPerformed(evt);
            }
        });

        HistoryHistory.setText("History");
        HistoryHistory.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        HistoryHistory.setPreferredSize(new java.awt.Dimension(130, 50));
        HistoryHistory.setRadius(50);
        HistoryHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HistoryHistoryMouseEntered(evt);
            }
        });
        HistoryHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryHistoryActionPerformed(evt);
            }
        });

        User2.setText("User");
        User2.setFont(new java.awt.Font("Afacad", 0, 65)); // NOI18N

        scrollPaneWin112.setBorder(null);
        scrollPaneWin112.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneWin112.setPreferredSize(new java.awt.Dimension(1237, 767));

        Table.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Name", "Log in", "Log out"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setCellSelectionEnabled(true);
        Table.setEnabled(false);
        Table.setShowGrid(true);
        Table.getTableHeader().setReorderingAllowed(false);
        scrollPaneWin112.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setPreferredWidth(50);
            Table.getColumnModel().getColumn(1).setPreferredWidth(50);
            Table.getColumnModel().getColumn(2).setPreferredWidth(50);
            Table.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        javax.swing.GroupLayout UserHistoryLayout = new javax.swing.GroupLayout(UserHistory);
        UserHistory.setLayout(UserHistoryLayout);
        UserHistoryLayout.setHorizontalGroup(
            UserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserHistoryLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(BackHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserHistoryLayout.createSequentialGroup()
                .addGroup(UserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UserHistoryLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UserHistoryLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(Iconuser2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(User2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 549, Short.MAX_VALUE)
                        .addComponent(HistoryHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(EditHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(AddHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101))
        );
        UserHistoryLayout.setVerticalGroup(
            UserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserHistoryLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(UserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(UserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HistoryHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EditHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AddHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(User2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Iconuser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(BackHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        Table.getTableHeader().setFont(new java.awt.Font("Afacad", 0, 24));
        Table.setRowHeight(40);
        Table.getTableHeader().setBackground(new java.awt.Color(150, 150, 150));
        Table.getTableHeader().setForeground(Color.WHITE);
        Table.setBackground(new java.awt.Color(255, 255, 255,30));

        MainPanel.add(UserHistory, "card4");

        PanelAdd.setPreferredSize(new java.awt.Dimension(1237, 767));
        PanelAdd.setRadius(80);
        PanelAdd.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 60, 100));

        BackAddUser.setForeground(new java.awt.Color(54, 54, 54));
        BackAddUser.setText("Back");
        BackAddUser.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        BackAddUser.setPreferredSize(new java.awt.Dimension(130, 50));
        BackAddUser.setRadius(50);
        BackAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackAddUserMouseEntered(evt);
            }
        });
        BackAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackAddUserActionPerformed(evt);
            }
        });

        EditAddUser.setText("Edit");
        EditAddUser.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        EditAddUser.setPreferredSize(new java.awt.Dimension(130, 50));
        EditAddUser.setRadius(55);
        EditAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditAddUserMouseEntered(evt);
            }
        });
        EditAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditAddUserActionPerformed(evt);
            }
        });

        User3.setText("User");
        User3.setFont(new java.awt.Font("Afacad", 0, 65)); // NOI18N

        Iconuser3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Iconuser3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User.png"))); // NOI18N

        AddAddUser.setText("Add");
        AddAddUser.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        AddAddUser.setPreferredSize(new java.awt.Dimension(130, 50));
        AddAddUser.setRadius(50);
        AddAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddAddUserMouseEntered(evt);
            }
        });
        AddAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAddUserActionPerformed(evt);
            }
        });

        HistoryAddUser.setText("History");
        HistoryAddUser.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        HistoryAddUser.setPreferredSize(new java.awt.Dimension(130, 50));
        HistoryAddUser.setRadius(55);
        HistoryAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HistoryAddUserMouseEntered(evt);
            }
        });
        HistoryAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryAddUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UserAddUserLayout = new javax.swing.GroupLayout(UserAddUser);
        UserAddUser.setLayout(UserAddUserLayout);
        UserAddUserLayout.setHorizontalGroup(
            UserAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserAddUserLayout.createSequentialGroup()
                .addGroup(UserAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UserAddUserLayout.createSequentialGroup()
                        .addContainerGap(102, Short.MAX_VALUE)
                        .addComponent(PanelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UserAddUserLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(Iconuser3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(User3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HistoryAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(EditAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(AddAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101))
            .addGroup(UserAddUserLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(BackAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UserAddUserLayout.setVerticalGroup(
            UserAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserAddUserLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(UserAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(UserAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(HistoryAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EditAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(User3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Iconuser3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(PanelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(BackAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        MainPanel.add(UserAddUser, "card5");

        PanelEditUser.setPreferredSize(new java.awt.Dimension(1237, 767));
        PanelEditUser.setRadius(80);
        PanelEditUser.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 60, 100));

        BackEditUser.setForeground(new java.awt.Color(54, 54, 54));
        BackEditUser.setText("Back");
        BackEditUser.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        BackEditUser.setPreferredSize(new java.awt.Dimension(130, 50));
        BackEditUser.setRadius(50);
        BackEditUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackEditUserMouseEntered(evt);
            }
        });
        BackEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackEditUserActionPerformed(evt);
            }
        });

        AddEditUser.setText("Add");
        AddEditUser.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        AddEditUser.setPreferredSize(new java.awt.Dimension(130, 50));
        AddEditUser.setRadius(55);
        AddEditUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddEditUserMouseEntered(evt);
            }
        });
        AddEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEditUserActionPerformed(evt);
            }
        });

        User4.setText("User");
        User4.setFont(new java.awt.Font("Afacad", 0, 65)); // NOI18N

        Iconuser4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Iconuser4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User.png"))); // NOI18N

        EditEditUser.setText("Edit");
        EditEditUser.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        EditEditUser.setPreferredSize(new java.awt.Dimension(130, 50));
        EditEditUser.setRadius(50);
        EditEditUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditEditUserMouseEntered(evt);
            }
        });

        HistoryEditUser.setText("History");
        HistoryEditUser.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        HistoryEditUser.setPreferredSize(new java.awt.Dimension(130, 50));
        HistoryEditUser.setRadius(55);
        HistoryEditUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HistoryEditUserMouseEntered(evt);
            }
        });
        HistoryEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryEditUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UserEditUserLayout = new javax.swing.GroupLayout(UserEditUser);
        UserEditUser.setLayout(UserEditUserLayout);
        UserEditUserLayout.setHorizontalGroup(
            UserEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserEditUserLayout.createSequentialGroup()
                .addGroup(UserEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UserEditUserLayout.createSequentialGroup()
                        .addContainerGap(102, Short.MAX_VALUE)
                        .addComponent(PanelEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UserEditUserLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(Iconuser4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(User4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HistoryEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(EditEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(AddEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101))
            .addGroup(UserEditUserLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(BackEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UserEditUserLayout.setVerticalGroup(
            UserEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserEditUserLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(UserEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(UserEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EditEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(HistoryEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AddEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(User4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Iconuser4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(PanelEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(BackEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        MainPanel.add(UserEditUser, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EditMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMainActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserEdit);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_EditMainActionPerformed

    private void AddMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMainActionPerformed
        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        MainPanel.removeAll();
        MainPanel.add(UserAddUser);
        MainPanel.repaint();
        MainPanel.revalidate();
        GlassPanePopup.showPopup(new AddUser(), option);
    }//GEN-LAST:event_AddMainActionPerformed

    private void HistoryMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryMainActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserHistory);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_HistoryMainActionPerformed

    private void BackEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackEditActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserMain);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_BackEditActionPerformed

    private void AddEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEditActionPerformed
        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        MainPanel.removeAll();
        MainPanel.add(UserAddUser);
        MainPanel.repaint();
        GlassPanePopup.showPopup(new AddUser(),option);
        MainPanel.revalidate();
    }//GEN-LAST:event_AddEditActionPerformed

    private void HistoryEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryEditActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserHistory);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_HistoryEditActionPerformed

    private void BackAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackAddUserActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserMain);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_BackAddUserActionPerformed

    private void EditAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditAddUserActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserEdit);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_EditAddUserActionPerformed

    private void AddAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAddUserActionPerformed
        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        MainPanel.removeAll();
        MainPanel.add(UserAddUser);
        MainPanel.repaint();
        GlassPanePopup.showPopup(new AddUser(),option);
        MainPanel.revalidate();
    }//GEN-LAST:event_AddAddUserActionPerformed

    private void HistoryAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryAddUserActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserHistory);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_HistoryAddUserActionPerformed

    private void BackEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackEditUserActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserMain);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_BackEditUserActionPerformed

    private void AddEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEditUserActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserAddUser);
        MainPanel.repaint();
        GlassPanePopup.showPopup(new AddUser());
        MainPanel.revalidate();
    }//GEN-LAST:event_AddEditUserActionPerformed

    private void HistoryEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryEditUserActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserHistory);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_HistoryEditUserActionPerformed

    private void BackMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackMainActionPerformed
        RunHere newFrame = new RunHere();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackMainActionPerformed

    private void HistoryMainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistoryMainMouseEntered
        HistoryMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_HistoryMainMouseEntered

    private void EditMainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMainMouseEntered
        EditMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_EditMainMouseEntered

    private void AddMainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMainMouseEntered
        AddMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_AddMainMouseEntered

    private void BackMainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMainMouseEntered
        BackMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BackMainMouseEntered

    private void HistoryEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistoryEditMouseEntered
        HistoryEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_HistoryEditMouseEntered

    private void EditEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditEditMouseEntered
        EditEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_EditEditMouseEntered

    private void AddEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddEditMouseEntered
        AddEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_AddEditMouseEntered

    private void BackEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackEditMouseEntered
        BackEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BackEditMouseEntered

    private void HistoryAddUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistoryAddUserMouseEntered
        HistoryAddUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_HistoryAddUserMouseEntered

    private void EditAddUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditAddUserMouseEntered
        EditAddUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_EditAddUserMouseEntered

    private void AddAddUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddAddUserMouseEntered
        AddAddUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_AddAddUserMouseEntered

    private void BackAddUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackAddUserMouseEntered
        BackAddUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BackAddUserMouseEntered

    private void HistoryEditUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistoryEditUserMouseEntered
        HistoryEditUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_HistoryEditUserMouseEntered

    private void EditEditUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditEditUserMouseEntered
        EditEditUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_EditEditUserMouseEntered

    private void AddEditUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddEditUserMouseEntered
        AddEditUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_AddEditUserMouseEntered

    private void BackEditUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackEditUserMouseEntered
        BackEditUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BackEditUserMouseEntered

    private void HistoryHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HistoryHistoryActionPerformed

    private void HistoryHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistoryHistoryMouseEntered
        HistoryHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_HistoryHistoryMouseEntered

    private void BackHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackHistoryActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserMain);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_BackHistoryActionPerformed

    private void BackHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackHistoryMouseEntered
        BackHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BackHistoryMouseEntered

    private void EditHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditHistoryActionPerformed
        MainPanel.removeAll();
        MainPanel.add(UserEdit);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_EditHistoryActionPerformed

    private void EditHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditHistoryMouseEntered
        EditHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_EditHistoryMouseEntered

    private void AddHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddHistoryActionPerformed
        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        MainPanel.removeAll();
        MainPanel.add(UserAddUser);
        MainPanel.repaint();
        //GlassPanePopup.showPopup(new AddUser(username),option);
        MainPanel.revalidate();
    }//GEN-LAST:event_AddHistoryActionPerformed

    private void AddHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddHistoryMouseEntered
        AddHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_AddHistoryMouseEntered

    private void EditEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditEditActionPerformed

    public static void main(String args[]) {
        FlatLightLaf.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button1 AddAddUser;
    private button.ButtonClear AddEdit;
    private button.ButtonClear AddEditUser;
    private button.ButtonClear AddHistory;
    private button.ButtonClear AddMain;
    private button.Button1 BackAddUser;
    private button.Button1 BackEdit;
    private button.Button1 BackEditUser;
    private button.Button1 BackHistory;
    private button.Button1 BackMain;
    private button.ButtonClear EditAddUser;
    private button.Button1 EditEdit;
    private button.Button1 EditEditUser;
    private button.ButtonClear EditHistory;
    private button.ButtonClear EditMain;
    private button.ButtonClear HistoryAddUser;
    private button.ButtonClear HistoryEdit;
    private button.ButtonClear HistoryEditUser;
    private button.Button1 HistoryHistory;
    private button.ButtonClear HistoryMain;
    private javax.swing.JLabel Iconuser;
    private javax.swing.JLabel Iconuser1;
    private javax.swing.JLabel Iconuser2;
    private javax.swing.JLabel Iconuser3;
    private javax.swing.JLabel Iconuser4;
    private javax.swing.JPanel MainPanel;
    private Rectangle.Rectangle PanelAdd;
    private Rectangle.Rectangle PanelEdit;
    private Rectangle.Rectangle PanelEditUser;
    private Rectangle.Rectangle PanelMain;
    private javax.swing.JTable Table;
    private CustomFont.LabelText User;
    private CustomFont.LabelText User1;
    private CustomFont.LabelText User2;
    private CustomFont.LabelText User3;
    private CustomFont.LabelText User4;
    private Background.backgrounduser UserAddUser;
    private Background.backgrounduser UserEdit;
    private Background.backgrounduser UserEditUser;
    private Background.backgrounduser UserHistory;
    private Background.backgrounduser UserMain;
    private Scroll.ScrollPaneWin11 scrollPaneWin112;
    // End of variables declaration//GEN-END:variables
}
