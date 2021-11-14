package Formularios;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;



/**
 *
 * @author Usuario
 */
public class TestGrid02 {
    public TestGrid02(int filas, int[] fil, int []colum) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                //TestPane testpane=new TestPane();
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(840,560);
                frame.setLayout(new BorderLayout());                                
                frame.add(new TestPane(filas,fil,colum));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                
                 
            }
        });
    }
    
   

    public class TestPane extends JPanel {

        //Constructor vacio
       
        
        public TestPane(int filas,int[] fil,int[]colu) {
            setLayout(new GridBagLayout());
            //CellPane cellPane[]=new CellPane[filas];
            int x=fil.length;
            int y=colu.length;
            GridBagConstraints gbc = new GridBagConstraints();
            for (int row = 0; row < filas; row++) {
                for (int col = 0; col < 100; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;

                    CellPane cellPane = new CellPane();
                    Border border = null;
                    border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                     
                    for (int p=0;p<x;p++){                        
                    if (row==fil[p]&col==colu[p]){                        
                        cellPane.setBackground(Color.BLUE);
                        //JOptionPane.showMessageDialog(null,"solo estamos configurando..");                        
                    }
                    
                    }
                    cellPane.setBorder(border);
                    add(cellPane, gbc);
                    
                }
                
            }
            
            
        }
        
        public void pintar(){
               
            
        }
        
        
    }

    
    
    public class CellPane extends JPanel {

        private Color defaultBackground;

        public CellPane() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    defaultBackground = getBackground();
                    setBackground(Color.BLUE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackground);
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }
}
       