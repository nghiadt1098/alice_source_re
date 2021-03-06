package edu.cmu.cs.stage3.alice.authoringtool.editors.keymappingeditor;

import edu.cmu.cs.stage3.alice.authoringtool.AuthoringTool;
import edu.cmu.cs.stage3.alice.authoringtool.Editor;
import edu.cmu.cs.stage3.alice.authoringtool.event.AuthoringToolStateChangedEvent;
import edu.cmu.cs.stage3.alice.core.navigation.KeyMapping;
import edu.cmu.cs.stage3.alice.core.property.IntArrayProperty;
import edu.cmu.cs.stage3.lang.Messages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;






















public class KeyMappingEditor
  extends JPanel
  implements Editor
{
  public static String viewerName = Messages.getString("KeyMapping_Editor");
  private KeyMapping keyMap;
  private int[] reverseKeyMap;
  
  public KeyMappingEditor()
  {
    jbInit();
  }
  


  public void setAuthoringTool(AuthoringTool at) {}
  


  public void setObject(KeyMapping element)
  {
    reverseKeyMap = new int[18];
    


    keyMap = element;
    
    if (element != null)
    {
      loadKeyMap();
    }
    updateFields();
  }
  
  public Object getObject() {
    return keyMap;
  }
  
  public JComponent getJComponent() {
    return this;
  }
  
  private void loadKeyMap() {
    for (int i = 0; i < keyMap.keyFunction.size(); i++)
      if (keyMap.keyFunction.getIntArrayValue()[i] != 0)
        if (keyMap.keyFunction.getIntArrayValue()[i] == -1) {
          reverseKeyMap[17] = i;
        } else
          reverseKeyMap[((int)(Math.log(keyMap.keyFunction.getIntArrayValue()[i]) / Math.log(2.0D)))] = i;
  }
  
  private void saveKeyMap() {
    if (keyMap == null) { return;
    }
    keyMap.keyFunction.set(new int['ƒ']);
    for (int i = 0; i < 17; i++)
      if (reverseKeyMap[i] != 0)
        keyMap.setFunction(reverseKeyMap[i], 1 << i);
    if (reverseKeyMap[17] != 0)
      keyMap.setFunction(reverseKeyMap[17], -1);
  }
  
  private void updateFields() {
    if (reverseKeyMap[0] == 0) {
      MF_key.setText(Messages.getString("_NONE_"));
    } else
      MF_key.setText(KeyEvent.getKeyText(reverseKeyMap[0]));
    if (reverseKeyMap[1] == 0) {
      MB_key.setText(Messages.getString("_NONE_"));
    } else
      MB_key.setText(KeyEvent.getKeyText(reverseKeyMap[1]));
    if (reverseKeyMap[2] == 0) {
      ML_key.setText(Messages.getString("_NONE_"));
    } else
      ML_key.setText(KeyEvent.getKeyText(reverseKeyMap[2]));
    if (reverseKeyMap[3] == 0) {
      MR_key.setText(Messages.getString("_NONE_"));
    } else
      MR_key.setText(KeyEvent.getKeyText(reverseKeyMap[3]));
    if (reverseKeyMap[4] == 0) {
      MU_key.setText(Messages.getString("_NONE_"));
    } else
      MU_key.setText(KeyEvent.getKeyText(reverseKeyMap[4]));
    if (reverseKeyMap[5] == 0) {
      MD_key.setText(Messages.getString("_NONE_"));
    } else
      MD_key.setText(KeyEvent.getKeyText(reverseKeyMap[5]));
    if (reverseKeyMap[6] == 0) {
      TL_key.setText(Messages.getString("_NONE_"));
    } else
      TL_key.setText(KeyEvent.getKeyText(reverseKeyMap[6]));
    if (reverseKeyMap[7] == 0) {
      TR_key.setText(Messages.getString("_NONE_"));
    } else
      TR_key.setText(KeyEvent.getKeyText(reverseKeyMap[7]));
    if (reverseKeyMap[8] == 0) {
      TU_key.setText(Messages.getString("_NONE_"));
    } else
      TU_key.setText(KeyEvent.getKeyText(reverseKeyMap[8]));
    if (reverseKeyMap[9] == 0) {
      TD_key.setText(Messages.getString("_NONE_"));
    } else
      TD_key.setText(KeyEvent.getKeyText(reverseKeyMap[9]));
    if (reverseKeyMap[10] == 0) {
      RL_key.setText(Messages.getString("_NONE_"));
    } else
      RL_key.setText(KeyEvent.getKeyText(reverseKeyMap[10]));
    if (reverseKeyMap[11] == 0) {
      RR_key.setText(Messages.getString("_NONE_"));
    } else
      RR_key.setText(KeyEvent.getKeyText(reverseKeyMap[11]));
    if (reverseKeyMap[16] == 0) {
      HU_key.setText(Messages.getString("_NONE_"));
    } else
      HU_key.setText(KeyEvent.getKeyText(reverseKeyMap[16]));
    if (reverseKeyMap[17] == 0) {
      SM_key.setText(Messages.getString("_NONE_"));
    } else {
      SM_key.setText(KeyEvent.getKeyText(reverseKeyMap[17]));
    }
  }
  
  private void setKey(int action, int key) {
    for (int i = 0; i < 18; i++)
      if (reverseKeyMap[i] == key)
        reverseKeyMap[i] = 0;
    reverseKeyMap[action] = key;
    saveKeyMap();
    updateFields();
  }
  
  public void stateChanging(AuthoringToolStateChangedEvent ev) {}
  
  public void worldLoading(AuthoringToolStateChangedEvent ev) {}
  
  public void worldUnLoading(AuthoringToolStateChangedEvent ev) {}
  
  public void worldStarting(AuthoringToolStateChangedEvent ev) {}
  
  public void worldStopping(AuthoringToolStateChangedEvent ev) {}
  
  public void worldPausing(AuthoringToolStateChangedEvent ev) {}
  
  public void worldSaving(AuthoringToolStateChangedEvent ev) {}
  
  public void stateChanged(AuthoringToolStateChangedEvent ev) {}
  
  public void worldLoaded(AuthoringToolStateChangedEvent ev) {}
  
  public void worldUnLoaded(AuthoringToolStateChangedEvent ev) {}
  
  public void worldStarted(AuthoringToolStateChangedEvent ev) {}
  
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel MF_label = new JLabel();
  TitledBorder titledBorder1;
  JPanel jPanel1 = new JPanel();
  GridLayout gridLayout2 = new GridLayout();
  BorderLayout borderLayout1 = new BorderLayout();
  JButton MF_key = new JButton();
  JLabel MB_label = new JLabel();
  JButton MB_key = new JButton();
  JLabel ML_label = new JLabel();
  JButton ML_key = new JButton();
  JLabel MR_label = new JLabel();
  JButton MR_key = new JButton();
  JLabel MU_label = new JLabel();
  
  public void worldStopped(AuthoringToolStateChangedEvent ev) {}
  
  JButton MU_key = new JButton();
  
  JLabel MD_label = new JLabel();
  JButton MD_key = new JButton();
  JLabel TL_label = new JLabel();
  JButton TL_key = new JButton();
  JLabel TR_label = new JLabel();
  JButton TR_key = new JButton();
  JLabel TU_label = new JLabel();
  JButton TU_key = new JButton();
  JLabel TD_label = new JLabel();
  JButton TD_key = new JButton();
  JLabel RL_label = new JLabel();
  JButton RL_key = new JButton();
  JLabel RR_label = new JLabel();
  JButton RR_key = new JButton();
  JLabel HU_label = new JLabel();
  JButton HU_key = new JButton();
  JLabel SM_label = new JLabel();
  public void worldPaused(AuthoringToolStateChangedEvent ev) {} JButton SM_key = new JButton();
  public void worldSaved(AuthoringToolStateChangedEvent ev) {}
  private void jbInit() { titledBorder1 = new TitledBorder("");
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(0);
    jLabel1.setText(Messages.getString("Action"));
    jLabel2.setBorder(BorderFactory.createEtchedBorder());
    jLabel2.setHorizontalAlignment(0);
    jLabel2.setText(Messages.getString("Key"));
    MF_label.setForeground(Color.blue);
    MF_label.setHorizontalAlignment(0);
    MF_label.setText(Messages.getString("Move_Forward"));
    jPanel1.setLayout(gridLayout2);
    gridLayout2.setRows(19);
    gridLayout2.setColumns(2);
    setLayout(borderLayout1);
    borderLayout1.setHgap(10);
    borderLayout1.setVgap(10);
    MF_key.setText(Messages.getString("_NONE_"));
    MF_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 0);
      }
    });
    MB_label.setText(Messages.getString("Move_Backward"));
    MB_label.setHorizontalAlignment(0);
    MB_label.setForeground(Color.blue);
    MB_label.setToolTipText("");
    MB_key.setText(Messages.getString("_NONE_"));
    MB_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 1);
      }
    });
    ML_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 2);
      }
    });
    MR_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 3);
      }
    });
    MU_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 4);
      }
    });
    MD_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 5);
      }
    });
    TL_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 6);
      }
    });
    TR_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 7);
      }
    });
    TU_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 8);
      }
    });
    TD_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 9);
      }
    });
    RL_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 10);
      }
    });
    RR_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 11);
      }
    });
    HU_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 16);
      }
      
    });
    TL_label.setText(Messages.getString("Turn_Left"));
    TL_label.setHorizontalAlignment(0);
    TL_label.setForeground(Color.blue);
    TL_label.setToolTipText("");
    TL_key.setText(Messages.getString("_NONE_"));
    
    TR_label.setText(Messages.getString("Turn_Right"));
    TR_label.setHorizontalAlignment(0);
    TR_label.setForeground(Color.blue);
    TR_label.setToolTipText("");
    TR_key.setText(Messages.getString("_NONE_"));
    
    TD_label.setText(Messages.getString("Turn_Forward"));
    TD_label.setHorizontalAlignment(0);
    TD_label.setForeground(Color.blue);
    TD_label.setToolTipText("");
    TD_key.setText(Messages.getString("_NONE_"));
    
    TU_label.setText(Messages.getString("Turn_Backward"));
    TU_label.setHorizontalAlignment(0);
    TU_label.setForeground(Color.blue);
    TU_label.setToolTipText("");
    TU_key.setText(Messages.getString("_NONE_"));
    
    ML_label.setText(Messages.getString("Move_Left"));
    ML_label.setHorizontalAlignment(0);
    ML_label.setForeground(Color.blue);
    ML_label.setToolTipText("");
    ML_key.setText(Messages.getString("_NONE_"));
    
    MR_label.setText(Messages.getString("Move_Right"));
    MR_label.setHorizontalAlignment(0);
    MR_label.setForeground(Color.blue);
    MR_label.setToolTipText("");
    MR_key.setText(Messages.getString("_NONE_"));
    
    MU_label.setText(Messages.getString("Move_Up"));
    MU_label.setHorizontalAlignment(0);
    MU_label.setForeground(Color.blue);
    MU_label.setToolTipText("");
    MU_key.setText(Messages.getString("_NONE_"));
    
    MD_label.setText(Messages.getString("Move_Down"));
    MD_label.setHorizontalAlignment(0);
    MD_label.setForeground(Color.blue);
    MD_label.setToolTipText("");
    MD_key.setText(Messages.getString("_NONE_"));
    




    HU_label.setText(Messages.getString("Stand_Up"));
    HU_label.setHorizontalAlignment(0);
    HU_label.setForeground(Color.blue);
    HU_label.setToolTipText("");
    HU_key.setText(Messages.getString("_NONE_"));
    
    RL_label.setText(Messages.getString("Roll_Left"));
    RL_label.setHorizontalAlignment(0);
    RL_label.setForeground(Color.blue);
    RL_label.setToolTipText("");
    RL_key.setText(Messages.getString("_NONE_"));
    
    RR_label.setText(Messages.getString("Roll_Right"));
    RR_label.setHorizontalAlignment(0);
    RR_label.setForeground(Color.blue);
    RR_label.setToolTipText("");
    RR_key.setText(Messages.getString("_NONE_"));
    
    jPanel1.setPreferredSize(new Dimension(294, 430));
    setMinimumSize(new Dimension(294, 500));
    setPreferredSize(new Dimension(294, 500));
    SM_label.setToolTipText("");
    SM_label.setForeground(Color.blue);
    SM_label.setHorizontalAlignment(0);
    SM_label.setText(Messages.getString("Strafe_Modifier"));
    SM_key.setText(Messages.getString("_NONE_"));
    SM_key.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        key_mouseClicked(e, 17);
      }
    });
    add(jPanel1, "North");
    jPanel1.add(jLabel1, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(MF_label, null);
    jPanel1.add(MF_key, null);
    jPanel1.add(MB_label, null);
    jPanel1.add(MB_key, null);
    jPanel1.add(TL_label, null);
    jPanel1.add(TL_key, null);
    jPanel1.add(TR_label, null);
    jPanel1.add(TR_key, null);
    jPanel1.add(TD_label, null);
    jPanel1.add(TD_key, null);
    jPanel1.add(TU_label, null);
    jPanel1.add(TU_key, null);
    jPanel1.add(ML_label, null);
    jPanel1.add(ML_key, null);
    jPanel1.add(MR_label, null);
    jPanel1.add(MR_key, null);
    jPanel1.add(MU_label, null);
    jPanel1.add(MU_key, null);
    jPanel1.add(MD_label, null);
    jPanel1.add(MD_key, null);
    jPanel1.add(HU_label, null);
    jPanel1.add(HU_key, null);
    jPanel1.add(RL_label, null);
    jPanel1.add(RL_key, null);
    jPanel1.add(RR_label, null);
    jPanel1.add(RR_key, null);
    jPanel1.add(SM_label, null);
    jPanel1.add(SM_key, null);
  }
  
  void key_mouseClicked(final MouseEvent e, final int action) {
    ((JButton)e.getSource()).setText(Messages.getString("Press_a_key___"));
    ((JButton)e.getSource()).addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == 27) {
          KeyMappingEditor.this.setKey(action, 0);
        } else {
          KeyMappingEditor.this.setKey(action, ke.getKeyCode());
        }
        ((JButton)e.getSource()).removeKeyListener(this);
      }
    });
    ((JButton)e.getSource()).addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent fe) {
        KeyMappingEditor.this.updateFields();
        ((JButton)e.getSource()).removeFocusListener(this);
      }
    });
  }
  
  void SM_key_mouseClicked(MouseEvent e) {}
  
  void SM_key_mousePressed(MouseEvent e) {}
  
  void SM_key_mouseReleased(MouseEvent e) {}
  
  void SM_key_mouseEntered(MouseEvent e) {}
  
  void SM_key_mouseExited(MouseEvent e) {}
}
