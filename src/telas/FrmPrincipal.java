/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import DAO.Conexao;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pdf.GeraOficioxxxx;
import pdf.Oficio;

/**
 *
 * @author f7057419
 */
public final class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     *
     * @throws java.io.IOException
     */
    public FrmPrincipal() throws IOException, Exception {
        Integer mes;
        String mesExtenso = null;

        //Para o form ficar no meio da tela    
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        Integer largura;
        Integer altura;

        largura = d.width;
        largura = (largura / 2) - (740 / 2);
        altura = d.height;
        altura = (altura / 2) - (920 / 2);

        initComponents();

        setBounds(largura, altura, 727, 920);
        Color corDoformulario = new Color(240, 240, 240);
        getContentPane().setBackground(corDoformulario);

        LocalDate hoje = new LocalDate();//hoje

        //tratamento mês por extenso
        mes = hoje.getMonthOfYear();

        switch (mes) {
            case 1:
                mesExtenso = "Janeiro";
                break;
            case 2:
                mesExtenso = "Fevereiro";
                break;
            case 3:
                mesExtenso = "Março";
                break;
            case 4:
                mesExtenso = "Abril";
                break;
            case 5:
                mesExtenso = "Maio";
                break;
            case 6:
                mesExtenso = "Junho";
                break;
            case 7:
                mesExtenso = "Julho";
                break;
            case 8:
                mesExtenso = "Agosto";
                break;
            case 9:
                mesExtenso = "Setembro";
                break;
            case 10:
                mesExtenso = "Outubro";
                break;
            case 11:
                mesExtenso = "Novembro";
                break;
            case 12:
                mesExtenso = "Dezembro";
                break;
        }
        txtData.setText("São Paulo, " + hoje.getDayOfMonth() + " de " + mesExtenso + " de " + hoje.getYear());
        fecharMeiaNoite();

        // Copiar arquivos de logo LogoRetangular.png e AR.pdf da rede para temp
        //File arIN = new File("c:/temp/AR.pdf");  
        File arIN = new File("\\\\Srispo02525\\cso1981servjudfunci$\\Publica\\INFORMACOES A TERCEIROS\\OFÍCIO\\OFICIO_PROG\\AR.pdf");
        //     \\Srispo02525\cso1981servjudfunci$\Publica\INFORMACOES A TERCEIROS\OFÍCIO\OFICIO_PROG

        File arOUT = new File("c:/temp/AR.pdf");
        copyFile(arIN, arOUT);

        // File logoIN = new File("c:/temp/LogoRetangular.png");  
        File logoIN = new File("\\\\Srispo02525\\cso1981servjudfunci$\\Publica\\INFORMACOES A TERCEIROS\\OFÍCIO\\OFICIO_PROG\\LogoRetangular.png");

        File logoOUT = new File("c:/temp/LogoRetangular.png");
        copyFile(logoIN, logoOUT);

        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Logo.png"));

        String gsv;
        String tipo;
        gsv = buscaGsv(System.getProperty("user.name"));
     //---------------   buscaDadosCabeçalho(gsv);
        
             
        
        tipo= SelecionaTipodeOficio(gsv);
        
        
        crioCorpoOficio("1",gsv);
        

 // apagalinha(System.getProperty("user.name"));
    }

    public void copyFile(File in, File out) throws Exception {
        FileChannel destinationChannel;
        try (FileChannel sourceChannel = new FileInputStream(in).getChannel()) {
            destinationChannel = new FileOutputStream(out).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
        }
        destinationChannel.close();
    }

    public void fecharMeiaNoite() {
        new Thread() {
            @Override
            public void run() {

                DateTime dateTime1 = new DateTime();
                //     System.out.println(dateTime1.getMinuteOfDay());

                int dateTime3 = dateTime1.getDayOfMonth();
                dateTime3 = dateTime3 + 1;
                System.out.println(dateTime3);

                int dateTime4 = 0;
                while (dateTime3 != dateTime4) {
                    dateTime4 = dateTime1.getDayOfMonth();
                }
                System.exit(0);

            }
        }.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtData = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAbc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnOficio = new javax.swing.JButton();
        btnAR = new javax.swing.JButton();
        btnLimpar = new javax.swing.JToggleButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCorpo = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtEndereco = new javax.swing.JTextPane();
        txtOficio = new javax.swing.JTextField();
        txtAOF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtProcesso = new javax.swing.JTextField();
        txtEnvolvido = new javax.swing.JTextField();
        txtOficioN = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtReu = new javax.swing.JTextField();
        txtDestinatário = new javax.swing.JTextField();
        txtInquerito1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLinhas = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel10.setFont(new java.awt.Font("Verdana", 3, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/nome2.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 745, 70);

        jLabel13.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 255));
        jLabel13.setText("Endereço:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 570, 110, 26);

        txtData.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        txtData.setForeground(new java.awt.Color(0, 96, 168));
        txtData.setText("São Paulo, 22 de xxxxx de xxxx");
        txtData.setToolTipText("");
        getContentPane().add(txtData);
        txtData.setBounds(10, 76, 310, 20);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 240, 0));
        jLabel11.setText("AOF : ");
        jLabel11.setToolTipText("");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(130, 129, 40, 14);

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 9)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("Desenvolvido por: F7057419 Maurício da Silva Luiz");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(450, 870, 270, 17);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(10, 210, 697, 2);

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 240, 0));
        jLabel14.setText("OFICIO CENOP SJ N.º : ");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 108, 160, 17);

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel15.setText("_______________________________________________________________________________________");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 810, 710, 17);

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 9)); // NOI18N
        jLabel16.setText("CENOP- Serviços Judiciais São Paulo/SP");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(250, 830, 210, 17);

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setText("BANCO BRASIL S.A.");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(270, 553, 140, 17);

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jLabel18.setText("CENOP SERVIÇOS SÃO PAULO/SP");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(240, 570, 200, 17);

        jLabel19.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 255));
        jLabel19.setText("Resposta:");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(10, 220, 140, 26);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("Digite as iniciaios do seu nome:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(430, 230, 210, 16);

        txtAbc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtAbc.setForeground(new java.awt.Color(51, 51, 255));
        txtAbc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAbc.setText("ABC");
        txtAbc.setToolTipText("");
        txtAbc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAbcActionPerformed(evt);
            }
        });
        getContentPane().add(txtAbc);
        txtAbc.setBounds(650, 230, 60, 18);

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jLabel20.setText("Rua Boa Vista, 254, 14º andar - Centro - CEP 01014-000 - São Paulo-SP");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(180, 850, 390, 17);

        btnOficio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnOficio.setText("OFICIO");
        btnOficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOficioActionPerformed(evt);
            }
        });
        getContentPane().add(btnOficio);
        btnOficio.setBounds(10, 760, 150, 30);

        btnAR.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAR.setText("Corrigir BacenJud Solicitação");
        btnAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnARActionPerformed(evt);
            }
        });
        getContentPane().add(btnAR);
        btnAR.setBounds(350, 760, 240, 30);

        btnLimpar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(600, 760, 105, 30);

        txtCorpo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCorpo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(txtCorpo);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 250, 700, 300);

        txtEndereco.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtEndereco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jScrollPane4.setViewportView(txtEndereco);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 640, 700, 110);

        txtOficio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtOficio.setToolTipText("");
        txtOficio.setBorder(null);
        getContentPane().add(txtOficio);
        txtOficio.setBounds(170, 108, 200, 15);

        txtAOF.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtAOF.setToolTipText("");
        txtAOF.setBorder(null);
        txtAOF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAOFActionPerformed(evt);
            }
        });
        getContentPane().add(txtAOF);
        txtAOF.setBounds(170, 129, 200, 15);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel2.setText("Processo Nº :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 160, 90, 15);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel3.setText("Inquerito Policial Nº :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 180, 140, 15);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel4.setText("Ofício Nº : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(430, 120, 70, 15);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel6.setText("Autor :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(450, 140, 50, 15);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel7.setText("Réu :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(460, 160, 40, 15);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel8.setText("Envolvido :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(420, 180, 80, 15);

        txtProcesso.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtProcesso.setToolTipText("");
        txtProcesso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtProcesso);
        txtProcesso.setBounds(170, 160, 200, 15);

        txtEnvolvido.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtEnvolvido.setToolTipText("");
        txtEnvolvido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtEnvolvido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnvolvidoActionPerformed(evt);
            }
        });
        getContentPane().add(txtEnvolvido);
        txtEnvolvido.setBounds(500, 180, 200, 15);

        txtOficioN.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtOficioN.setToolTipText("");
        txtOficioN.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtOficioN);
        txtOficioN.setBounds(500, 120, 200, 15);

        txtAutor.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtAutor.setToolTipText("");
        txtAutor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });
        getContentPane().add(txtAutor);
        txtAutor.setBounds(500, 140, 200, 15);

        txtReu.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtReu.setToolTipText("");
        txtReu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtReu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReuActionPerformed(evt);
            }
        });
        getContentPane().add(txtReu);
        txtReu.setBounds(500, 160, 200, 15);

        txtDestinatário.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDestinatário.setText("Ao Excelentíssimo Dr.: ");
        txtDestinatário.setToolTipText("");
        txtDestinatário.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDestinatário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinatárioActionPerformed(evt);
            }
        });
        getContentPane().add(txtDestinatário);
        txtDestinatário.setBounds(10, 605, 220, 20);

        txtInquerito1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtInquerito1.setToolTipText("");
        txtInquerito1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtInquerito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInquerito1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtInquerito1);
        txtInquerito1.setBounds(170, 180, 200, 15);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel9.setText("Inserir linhas:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(570, 560, 100, 15);

        txtLinhas.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtLinhas.setText("0");
        txtLinhas.setToolTipText("");
        txtLinhas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtLinhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLinhasActionPerformed(evt);
            }
        });
        getContentPane().add(txtLinhas);
        txtLinhas.setBounds(680, 560, 30, 20);

        jPanel1.setBackground(new java.awt.Color(0, 96, 168));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 100, 370, 50);

        jLabel1.setText("                          ");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 830, 80, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAbcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAbcActionPerformed

    private void btnOficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOficioActionPerformed
        // TODO add your handling code here:
        //    GeraOficioxxxx G = new GeraOficioxxxx();

        Oficio oficio = new Oficio();

       try {
            oficio.setLinhas(Integer.parseInt(txtLinhas.getText()));
        } catch (Exception e) {
            oficio.setLinhas(1);
        }
        try {
            oficio.setOficio(txtOficio.getText());
        } catch (Exception e) {
            oficio.setOficio("");
        }
        try {
     //       oficio.setAof(txtAOF.getText());
        } catch (Exception e) {
      //      oficio.setAof("");
        }
        try {
            oficio.setOficio(txtOficio.getText());
        } catch (Exception e) {
            oficio.setOficio("");
        }
        try {
            oficio.setProcesso(txtProcesso.getText());
        } catch (Exception e) {
            oficio.setProcesso("");
        }
        try {
            oficio.setCorpo(txtCorpo.getText());
        } catch (Exception e) {
            oficio.setCorpo("");
        }
        try {
            oficio.setDestinario(txtDestinatário.getText());
        } catch (Exception e) {
            oficio.setDestinario("");
        }
        try {
            oficio.setEndereco(txtEndereco.getText());
        } catch (Exception e) {
            oficio.setEndereco("");
        }
        try {
       //     oficio.setInquerito(txtInquerito1.getText());
        } catch (Exception e) {
       //     oficio.setInquerito("");
        }
        try {
       //     oficio.setOficion(txtOficioN.getText());
        } catch (Exception e) {
        //    oficio.setOficion("");
        }
        try {
         //   oficio.setAutor(txtAutor.getText());
        } catch (Exception e) {
         //   oficio.setAutor("");
        }
        try {
            oficio.setReu(txtReu.getText());
        } catch (Exception e) {
            oficio.setReu("");
        }
        try {
        //    oficio.setEnvolvido(txtEnvolvido.getText());
        } catch (Exception e) {
         //   oficio.setEnvolvido("");
        }
        try {
            oficio.setAbc(txtAbc.getText());
        } catch (Exception e) {
            oficio.setAbc("");
        }
        try {
            oficio.setData(txtData.getText());
        } catch (Exception e) {
            oficio.setData("");
        }
        //  JOptionPane.showMessageDialog(txtOficio,"Dentro do form" +  txtOficio.getText());     
        GeraOficioxxxx GO = new GeraOficioxxxx();
//  teste2 Gd = new teste2();
        if ("".equals(txtOficio.getText())) {
            JOptionPane.showMessageDialog(txtOficio, "Favor digitar o número do Ofício");
        } else {
            if ("ABC".equals(txtAbc.getText())) {
                JOptionPane.showMessageDialog(txtAbc, "Favor digitar as iniciais do seu nome");
            } else {
                if ("".equals(txtCorpo.getText())) {
                    JOptionPane.showMessageDialog(txtCorpo, "Favor digitar a resposta");
                } else {
                    if ("".equals(txtEndereco.getText())) {
                        JOptionPane.showMessageDialog(txtEndereco, "Favor digitar o endereço");
                    } else {
                        try {
                            GO.Gerar(oficio);
                            //  GO.colocaLogo();
                        } catch (IOException | DocumentException | InterruptedException ex) {
                            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                        
                            // Salvar na rede
                        try {
                            PdfReader pdfComLogo = new PdfReader("c:\\temp\\OficioComLogo.pdf");
                            //--   PdfReader pdfComLogo = new PdfReader("OficioComLogo.pdf");
                            int number_of_pages = pdfComLogo.getNumberOfPages();
                            //  PdfStamper stamp = new PdfStamper(pdfComLogo, new FileOutputStream("c:\\temp\\OficioComLogo.pdf"));
                            LocalDate hoje = new LocalDate();//hoje
                            System.out.println(hoje + "dentro");
                            PdfStamper stamp;
                        //    if (!"aaa".equals(oficio.getAbc())) {//Usar aaa nas inicias para não gravar na pasta--testar o programa                         

                          //      stamp = new PdfStamper(pdfComLogo, new FileOutputStream("c:\\temp\\Oficio_" + oficio.getOficio() + "_" + hoje + "_" + System.getProperty("user.name").toUpperCase() + ".pdf"));

                                
                                
                                
                                try {
                                   //stamp = new PdfStamper(pdfComLogo, new FileOutputStream("G:\\Publica\\INFORMACOES A TERCEIROS\\OFÍCIO\\OFICIO_PROG\\Oficio_"+Oficio+"_"+hoje+"_"+Abc+".pdf"));
                                    stamp = new PdfStamper(pdfComLogo, new FileOutputStream("G:\\FUNCI\\Publica\\INFORMACOES A TERCEIROS\\OFÍCIO\\OFICIO_PROG\\Oficio_" + oficio.getOficio() + "_" + hoje + "_" + System.getProperty("user.name").toUpperCase().replaceAll("/", "").replaceAll("-", "") + ".pdf"));

                                } catch (DocumentException | IOException e) {
                                    stamp = new PdfStamper(pdfComLogo, new FileOutputStream("G:\\Publica\\INFORMACOES A TERCEIROS\\OFÍCIO\\OFICIO_PROG\\Oficio_" + oficio.getOficio() + "_" + hoje + "_" + System.getProperty("user.name").toUpperCase().replaceAll("/", "").replaceAll("-", "") + ".pdf"));
                                    //   stamp = new PdfStamper(pdfComLogo, new FileOutputStream("G:\\FUNCI\\Publica\\INFORMACOES A TERCEIROS\\OFÍCIO\\OFICIO_PROG\\Oficio_"+Oficio+"_"+hoje+"_"+Abc+".pdf"));
                                }
                                stamp.close();
                                pdfComLogo.close();
                           // }
                        } catch (DocumentException | IOException i1) {
                        }
                        
                          GeraOficioxxxx Ga = new GeraOficioxxxx();
        try {
                Ga.GerarAR(oficio);
            } catch (DocumentException | IOException e) {
            }
        //Criar aequivo com oficio e ar juntos
        ArrayList<InputStream> list = new ArrayList<>();
        try {
            list.add(new FileInputStream(new File("c:\\temp\\OficioComLogo.pdf")));
             list.add(new FileInputStream(new File("c:\\temp\\ARF.pdf")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
    String caminho="c:\\temp\\OficioJunto.pdf";
        try {
            OutputStream out = new FileOutputStream(new File(caminho));
            doMerge(list, out); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Process k = Runtime.getRuntime().exec("cmd.exe /C c:\\temp\\OficioJunto.pdf");
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);    
        }
                    
                        
                    }
                }
            }
        }
    }//GEN-LAST:event_btnOficioActionPerformed

    private String buscaGsv(String chave) throws SQLException {//metódo para buscar os dados do programa do henrique e carregar o oficio
        Connection cn = (Connection) new Conexao().conectar();
        // String sqlVai = "select oficio_load.egt,oficio_load.oficio,oficio_load.processo,oficio_load.inquerito,oficio_load.oficion,oficio_load.autor,oficio_load.envolvido  from bdjudicial.oficio_load where chave = " + "'" + chave + "'";     
        String gsv = null;
        String sqlVai = "select BLOQJUD_load.gsv,BLOQJUD_load.iniciais  from bdjudicial.BLOQJUD_load where chave = " + "'" + chave + "'";

        java.sql.Statement stm = cn.createStatement();
        ResultSet rs = stm.executeQuery(sqlVai);

      //  int linhas = 0;//Contador registros no banco para a data pesquisada
        while (rs.next()) {
            System.out.println(chave);
            System.out.println(rs.getString("gsv"));
            System.out.println(rs.getString("iniciais"));

       // txtOficio.setText("2014/"+ rs.getString("gsv"));
            //  txtAbc.setText(rs.getString("iniciais").toUpperCase());
            //txtAutor.setText(rs.getString("autor"));
            gsv = rs.getString("gsv");

        }

        return gsv;
    }

    private String SelecionaTipodeOficio(String gsv) throws SQLException {
        Connection cn = (Connection) new Conexao().conectar();
       // String sqlVai = "select oficio_load.egt,oficio_load.oficio,oficio_load.processo,oficio_load.inquerito,oficio_load.oficion,oficio_load.autor,oficio_load.envolvido  from bdjudicial.oficio_load where chave = " + "'" + chave + "'";     
        String tipodoOficio = null;
        double valor = 0;
        String tipo;
        String egt = null;
        String desbloqueio = null;

        String sqlVai = "SELECT * FROM BLOQJUD_PRINCIPAL WHERE GSV = " + gsv;

        java.sql.Statement stm = cn.createStatement();
        ResultSet rs = stm.executeQuery(sqlVai);

      //  int linhas = 0;//Contador registros no banco para a data pesquisada
        while (rs.next()) {
            System.out.println(gsv);
            System.out.println(rs.getString("VALOR_BLOQ"));
            System.out.println(rs.getString("TIPO_BLOQ"));
            System.out.println(rs.getString("EGT_BOO"));
            System.out.println(rs.getString("DESBLOQ_BOO"));

            valor = Double.parseDouble(rs.getString("VALOR_BLOQ"));
            tipo = rs.getString("TIPO_BLOQ");
            egt = rs.getString("EGT_BOO");
            desbloqueio = rs.getString("DESBLOQ_BOO");            
            System.out.println(valor +" *  " +" * " + tipo+" * "+ egt + " * "+ desbloqueio);  
       // txtOficio.setText("2014/"+ rs.getString("gsv"));
            //  txtAbc.setText(rs.getString("iniciais").toUpperCase());
            //txtAutor.setText(rs.getString("autor"));
            gsv = rs.getString("gsv");
        } 

        if (valor > 0 && (egt==null)) {
            tipodoOficio="1";//SÓ BLOQUEIO
        }else if(valor > 0 && (egt!=null)){
            tipodoOficio="2";//SÓ BLOQUEIO e TRASNEFERÊNCIA
        }else if(valor == 0 && (egt!=null)){
            tipodoOficio="3";//SÓ  TRASNEFERÊNCIA
        }else if(desbloqueio == null && (egt!=null)){
             tipodoOficio="3";//SÓ DESBLOQUEIO
        }
        
   return tipodoOficio;
    }

    private void buscaDadosCabeçalho(String gsv) throws SQLException {//metódo para buscar os dados do programa do henrique e carregar o oficio
        Connection cn = (Connection) new Conexao().conectar();

        String sqlVai = "SELECT * from BLOQJUD_PRINCIPAL LEFT JOIN BLOQJUD_CEP on BLOQJUD_PRINCIPAL.CEP=BLOQJUD_CEP.CEP LEFT join BLOQJUD_DJO_ORGAO on BLOQJUD_PRINCIPAL.DJO=BLOQJUD_DJO_ORGAO.NDJO  WHERE BLOQJUD_PRINCIPAL.GSV= " + gsv;
        //  String sqlVai = "SELECT * from BLOQJUD_PRINCIPAL LEFT JOIN BLOQJUD_CEP on BLOQJUD_PRINCIPAL.CEP=BLOQJUD_CEP.CEP LEFT join BLOQJUD_DJO_ORGAO on BLOQJUD_PRINCIPAL.DJO=BLOQJUD_DJO_ORGAO.NDJO  WHERE BLOQJUD_PRINCIPAL.GSV= 10";  
        java.sql.Statement stm = cn.createStatement();
        ResultSet rs = stm.executeQuery(sqlVai);

      //  int linhas = 0;//Contador registros no banco para a data pesquisada
        while (rs.next()) {
            System.out.println(gsv);
            System.out.println(rs.getString("nome"));
            System.out.println(rs.getString("processo").toUpperCase());

            txtOficio.setText("2014/" + rs.getString("gsv"));
            //txtAbc.setText(rs.getString("iniciais").toUpperCase());
            txtAutor.setText(rs.getString("nome"));
            txtAOF.setText(rs.getString("gsv"));
            txtProcesso.setText(rs.getString("processo"));
            txtReu.setText(rs.getString("AUTOR_PRINC"));
            txtDestinatário.setText("");
            txtOficioN.setText(rs.getString("n_ofic_orig"));
            txtEnvolvido.setText("");
            /*/   txtCorpo.setText("Meritíssimo Juiz, \n" +
             "\n" +
             "	Em atendimento à requisição de Vossa Excelência, por meio do ofício expedido nos autos do processo em epígrafe, informamos que Agnaldo Terra Rocha, CPF 247.687.258-05, não possui cartão de crédito VISA ou MASTERCARD nesta instituição. \n" +
             "\n" +
             "       As informações contidas neste ofício são confidenciais e estão sendo encaminhadas à Autoridade competente e requisitante com o devido amparo da Lei Complementar nº 105, de 10 de janeiro de 2001, que dispõe sobre o sigilo das operações e serviços prestados pelas Instituições Financeiras.\n" +
             "\n" +
             "       Colocamo-nos à disposição para eventuais  esclarecimentos e informações porventura necessários, aproveitando o ensejo para enviar protestos de elevada estima e consideração.\n" +
             "\n" +
             "Respeitosamente,");*/
            txtDestinatário.setText("Ao Excelentíssimo Dr.:");
            txtEndereco.setText(rs.getString("juiz") + "\n"
                    + rs.getString("orgao") + "\n"
                    + rs.getString("endereco") + ", " + rs.getString("numero") + "\n"
                    + rs.getString("bairro") + "\n"
                    + "CEP: " + rs.getString("uf"));

        }
    }

    public static void doMerge(ArrayList<InputStream> list, OutputStream outputStream)
            throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfContentByte cb = writer.getDirectContent();
        
        for (InputStream in : list) {
            PdfReader reader = new PdfReader(in);
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                document.newPage();
                //import the page from source pdf
                PdfImportedPage page = writer.getImportedPage(reader, i);
                //add the page to the destination pdf
                cb.addTemplate(page, 0, 0);
            }
        }
        
        outputStream.flush();
        document.close();
        outputStream.close();
    }
    
    
    
    
    
    
    

    
        private void crioCorpoOficio(String tipoDoOficio,String gsv) throws SQLException {//metódo para buscar os dados do programa do henrique e carregar o oficio
        Connection cn = (Connection) new Conexao().conectar();
               
        switch( tipoDoOficio ){
    case "1"://SÓ BLOQUEIO
        String sqlVai="SELECT * FROM BLOQJUD_PRINCIPAL LEFT JOIN BLOQJUD_PRINC_CONTAS ON BLOQJUD_PRINC_CONTAS.GSV = BLOQJUD_PRINCIPAL.GSV WHERE BLOQJUD_PRINCIPAL.GSV = '" + gsv + "' AND (IsNull(BLOQJUD_PRINC_CONTAS.DATA_BLOQ) = False) AND (IsNull(BLOQJUD_PRINC_CONTAS.PROT_BLOQ) = False);";
        java.sql.Statement stm = cn.createStatement();
        ResultSet rs = stm.executeQuery(sqlVai);
        
        while (rs.next()) {
            String dataBloqueio;
            String nome;
            dataBloqueio = rs.getString("DATA_BLOQ");
            nome= rs.getString("nome");
            
            txtCorpo.setText("SÓ BLOQUEIO");
            
       /*   txtCorpo.setText("Meritíssimo Juiz, \n"
                + "\n"
                + "	 Em atenção aos termos do ofício supra, expedido nos autos do Processo em epígrafe, informamos que efetuamos em " + dataBloqueio + ", o bloqueio dos saldos existentes em nome de " +  nome +" \n"
                + "\n"
                + "       As informações contidas neste ofício são confidenciais e estão sendo encaminhadas à Autoridade competente e requisitante com o devido amparo da Lei Complementar nº 105, de 10 de janeiro de 2001, que dispõe sobre o sigilo das operações e serviços prestados pelas Instituições Financeiras.\n"
                + "\n"
                + "       Colocamo-nos à disposição para eventuais  esclarecimentos e informações porventura necessários, aproveitando o ensejo para enviar protestos de elevada estima e consideração.\n"
                + "\n"
                + "Respeitosamente,");*/
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
          //comandos caso a opção 1 tenha sido escolhida
            break;    
    case "2"://SÓ BLOQUEIO e TRASFERÊNCIA
        
        txtCorpo.setText("SÓ BLOQUEIO e TRASFERÊNCIA ");
          //comandos caso a opção 2 tenha sido escolhida
            break;    
    case "3"://SÓ  TRASFERÊNCIA
        txtCorpo.setText("SÓ  TRASFERÊNCIA ");
        
        
        
        
        
        
        
        
          //comandos caso a opção 3 tenha sido escolhida
            break;        
   case "4": //SÓ DESBLOQUEIO    
       txtCorpo.setText("SÓ desBLOQUEIO");
          //comandos caso a opção 4 tenha sido escolhida
            break;    
    default:
          //comandos caso nenhuma das opções anteriores tenha sido escolhida
}
        
        
        
        
   /*    String sqlVai = "SELECT * from BLOQJUD_PRINCIPAL LEFT JOIN BLOQJUD_CEP on BLOQJUD_PRINCIPAL.CEP=BLOQJUD_CEP.CEP LEFT join BLOQJUD_DJO_ORGAO on BLOQJUD_PRINCIPAL.DJO=BLOQJUD_DJO_ORGAO.NDJO  WHERE BLOQJUD_PRINCIPAL.GSV= " + tipoDoOficio;
        //String sqlVai = "SELECT * from BLOQJUD_PRINCIPAL LEFT JOIN BLOQJUD_CEP on BLOQJUD_PRINCIPAL.CEP=BLOQJUD_CEP.CEP LEFT join BLOQJUD_DJO_ORGAO on BLOQJUD_PRINCIPAL.DJO=BLOQJUD_DJO_ORGAO.NDJO  WHERE BLOQJUD_PRINCIPAL.GSV= 10";  
        java.sql.Statement stm = cn.createStatement();
        ResultSet rs = stm.executeQuery(sqlVai);

      //int linhas = 0;//Contador registros no banco para a data pesquisada
        while (rs.next()) {
            System.out.println(tipoDoOficio);
            System.out.println(rs.getString("nome"));
            System.out.println(rs.getString("processo").toUpperCase());

            txtOficio.setText("2014/" + rs.getString("gsv"));
            //txtAbc.setText(rs.getString("iniciais").toUpperCase());
            txtAutor.setText(rs.getString("nome"));
            txtAOF.setText(rs.getString("gsv"));
            txtProcesso.setText(rs.getString("processo"));
            txtReu.setText(rs.getString("AUTOR_PRINC"));
            txtDestinatário.setText("");
            txtOficioN.setText(rs.getString("n_ofic_orig"));
            txtEnvolvido.setText("");
            /   txtCorpo.setText("Meritíssimo Juiz, \n" +
             "\n" +
             "	Em atendimento à requisição de Vossa Excelência, por meio do ofício expedido nos autos do processo em epígrafe, informamos que Agnaldo Terra Rocha, CPF 247.687.258-05, não possui cartão de crédito VISA ou MASTERCARD nesta instituição. \n" +
             "\n" +
             "       As informações contidas neste ofício são confidenciais e estão sendo encaminhadas à Autoridade competente e requisitante com o devido amparo da Lei Complementar nº 105, de 10 de janeiro de 2001, que dispõe sobre o sigilo das operações e serviços prestados pelas Instituições Financeiras.\n" +
             "\n" +
             "       Colocamo-nos à disposição para eventuais  esclarecimentos e informações porventura necessários, aproveitando o ensejo para enviar protestos de elevada estima e consideração.\n" +
             "\n" +
             "Respeitosamente,");
            txtDestinatário.setText("Ao Excelentíssimo Dr.:");
            txtEndereco.setText(rs.getString("juiz") + "\n"
                    + rs.getString("orgao") + "\n"
                    + rs.getString("endereco") + ", " + rs.getString("numero") + "\n"
                    + rs.getString("bairro") + "\n"
                    + "CEP: " + rs.getString("uf"));*/
        
        
    }
    
    
    
    
    private void apagalinha(String chave) throws SQLException {//metódo para buscar os dados do programa do henrique e carregar o oficio
        Connection cn = (Connection) new Conexao().conectar();
        //   String rsqlApagar = "Delete   from bdjudicial.BLOQJUD_load where chave = " + "'" + chave + "'";        
        java.sql.Statement stm = cn.createStatement();
        try {
            stm.executeUpdate("Delete   from bdjudicial.BLOQJUD_load where chave = " + "'" + chave + "'");

// ResultSet rs = stm.executeUpdate(rsqlApagar );  
        } catch (SQLException e) {
            System.out.println(e);
        }

    }


    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        txtOficio.setText("");
        txtAbc.setText("ABC");
        txtAutor.setText("");
        txtAOF.setText("");
        txtProcesso.setText("");
        txtReu.setText("");
        txtDestinatário.setText("");
        txtOficioN.setText("");
        txtEnvolvido.setText("");
        txtCorpo.setText("");
        txtDestinatário.setText("");
        txtEndereco.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtAOFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAOFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAOFActionPerformed

    private void txtEnvolvidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnvolvidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnvolvidoActionPerformed

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void txtDestinatárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinatárioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinatárioActionPerformed

    private void txtInquerito1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInquerito1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInquerito1ActionPerformed

    private void txtReuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReuActionPerformed

    private void txtLinhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLinhasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLinhasActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:

        /*  FrmPrincipalTeste frmFilho2 = null;      
         try {
         frmFilho2 = new FrmPrincipalTeste();
         } catch (Exception ex) {
         Logger.getLogger(frmPrincipal1.class.getName()).log(Level.SEVERE, null, ex);
         }
         frmFilho2.show();*/
        txtOficio.setText("2014/14551687");
        txtAbc.setText("aaa");
        txtAutor.setText("Agnaldo Terra Rocha");
        txtAOF.setText("2014/10120");
        txtProcesso.setText("0004853-70.2013.8.26.0269");
        txtReu.setText("Paloma Martins Rocha e outros");
        txtDestinatário.setText("");
        txtOficioN.setText("");
        txtEnvolvido.setText("");
        txtCorpo.setText("Meritíssimo Juiz, \n"
                + "\n"
                + "	Em atendimento à requisição de Vossa Excelência, por meio do ofício expedido nos autos do processo em epígrafe, informamos que Agnaldo Terra Rocha, CPF 247.687.258-05, não possui cartão de crédito VISA ou MASTERCARD nesta instituição. \n"
                + "\n"
                + "       As informações contidas neste ofício são confidenciais e estão sendo encaminhadas à Autoridade competente e requisitante com o devido amparo da Lei Complementar nº 105, de 10 de janeiro de 2001, que dispõe sobre o sigilo das operações e serviços prestados pelas Instituições Financeiras.\n"
                + "\n"
                + "       Colocamo-nos à disposição para eventuais  esclarecimentos e informações porventura necessários, aproveitando o ensejo para enviar protestos de elevada estima e consideração.\n"
                + "\n"
                + "Respeitosamente,");
        txtDestinatário.setText("Ao Excelentíssimo Dr.:");
        txtEndereco.setText("Trazibulo José Ferreira da Silva\n"
                + "Tribunal de Justiça do Estado de São Paulo \n"
                + "1ª Vara da Família e das Sucessões – Comarca de Itapetininga \n"
                + "Rua Carlos Cardoso, s/n – Jardim Mesquita\n"
                + "CEP 18213-540 – Itapetininga/SP");


    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnARActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

        //  Ler o Oficio

        try{

            String local = System.getProperty("user.dir");
            JFileChooser cx_caminho = new JFileChooser(local);
            int caminho = cx_caminho.showOpenDialog(jLabel1);

            //System.out.println(cx_caminho.getSelectedFile().getAbsolutePath());

            PdfReader reader = new PdfReader(cx_caminho.getSelectedFile().getAbsolutePath());
            int n = reader.getNumberOfPages();
            //     System.out.println("Total de páginas para este pdf: "+n);

            //extraindo o conteúdo de uma página específica
            String str=PdfTextExtractor.getTextFromPage(reader, 1);
            System.out.println("Conteudo: "+str);

            //   JOptionPane.showMessageDialog(txtCorpo, str);

            //NÚMERO DO OFICIO
            String A[] = str.split("SJ N.º :");
            String nOfiocio = (A[1]);
            String B[] = nOfiocio.split("\n");
            nOfiocio = (B[0]).trim();
            //      System.out.println(nOfiocio);
            txtOficio.setText(nOfiocio);
            txtAbc.setText("ABC");

            //NÚMERO DO PROCESSO
            String C[] = str.split("Processo Nº            :");
            String nProcesso = (C[1]);
            String D[] = nProcesso.split("\n");
            nProcesso = (D[0]).trim();
            //     System.out.println(nProcesso);
            txtProcesso.setText(nProcesso);

            //AUTOR
            String E[] = str.split("Autor                        :");
            String autor = (E[1]);
            String F[] = autor.split("\n");
            autor = (F[0]).trim();
            //    System.out.println(autor);
            txtAutor.setText(autor);

            //REU
            String G[] = str.split("Réu                          :");
            String reu = (G[1]);
            String H[] = reu.split("\n");
            reu = (H[0]).trim();
            //    System.out.println(reu);
            txtReu.setText(reu);

            //CPF
            String c[] = str.split("CPF/CNPJ:");
            String cpf = (c[1]);
            String d[] = cpf.split("\n");
            cpf = (d[0]).trim();

            //AGENCIA
            String e[] = str.split("Réu:");
            String agencia = (e[1]);
            String f[] = agencia.split("\n");
            agencia = (f[0]).trim();

            //VALOR
            String g[] = str.split("Valor:");
            String valor = (g[1]);
            String h[] = valor.split("\n");
            valor = (h[0]).trim();

            //PROTOCOLO
            String i[] = str.split("Protocolo:");
            String protocolo = (i[1]);
            String j[] = protocolo.split("\n");
            protocolo = (j[0]).trim();

            //ID
            String l[] = str.split("ID:");
            String id = (l[1]);
            String kk[] = id.split("\n");
            id = (kk[0]).trim();

            //BANCO
            String p[] = str.split("Banco:");
            String banco = (p[1]);
            String o[] = banco.split("\n");
            banco = (o[0]).trim();
            
               //DATA
         String y[] = str.split("Data: ");
         String data = (y[1]);      
         String u[] = data.split("\n");
         data = (u[0]).trim(); 
//            //AGENCIA
//            String q[] = str.split("Autor:");
//            String agenciaa = (q[1]);
//            String r[] = agenciaa.split("\n");
//            agenciaa = (r[0]).trim();

            //DOCUMENTO
            String s[] = str.split("Documento:");
            String documento = (s[1]);
            String t[] = documento.split("\n");
            documento = (t[0]).trim();
            //    System.out.println(reu);
            txtReu.setText(reu);

            String corpo;
            corpo ="Meritíssimo(a) Juiz(a),"
            //  + " " + "\n"
            + " " + "\n"
            + "         Em atenção à solicitação de Vossa Excelência, por meio do ofício expedido nos autos do Processo em epígrafe, informamos:"
            //    + " " + "\n"
            + " " + "\n"
            + "Dados do remetente: "
            ///      + " " + "\n"
            + " "+ "\n"
            +"CPF/CNPJ: "+cpf+ "\n"
            + "Agência: "+agencia+"\n"
            //     + " " + "\n"
            //  + " " + "\n"
            + "Dados da transferência: "
            //           + " " + "\n"
            + " " + "\n"
            +"Valor: R$ "+valor+"\n"
            +"Protocolo: "+protocolo+"\n"
            +"ID: "+id+"\n"
            +"Banco: "+banco+"\n"
           // + "Agência: "+agenciaa+"\n"
            +"Documento: "+documento+"\n"
                     +"Data: "+data+"\n"

            //       + " " + "\n"
            //  + " " + "\n"
            + "         Essas informações são confidenciais e são encaminhadas com amparo na lei Complementar nº105/2001 que dispõe sobre o sigilo das operações e serviços prestados pelas instituições financeiras."
            + ""+"\n"
            + "         Colocamo-nos à disposição para maiores esclarecimentos porventura necessários."

            //     + " "+"\n"
            + " "+"\n"
            + "         Respeitosamente,";

            txtDestinatário.setText("Ao (A) Excelentissimo (A) Dr(a):");
            //   txtOficioN.setText("");
            //   txtEnvolvido.setText("");
            txtCorpo.setText(corpo);

            //endereço
            String K[] = str.split("CENOP SERVIÇOS SÃO PAULO/SP");
            String endereco = (K[1].trim());
            //  System.out.println("/////////// \n"+endereco);
            String k[] = endereco.split(":");
            endereco = (k[1]);

            String kv[] = str.split("CEP:");
            String endereco2 = (kv[1].trim());
            String tt[] = endereco2.split("\n");
            endereco2 = (tt[0]).trim();

            System.out.println("*************"+endereco+endereco2);

            //         String L[] = endereco.split("______________________________________________________________________________");
            //         endereco = (L[0]).trim();
            //         System.out.println(endereco);
            txtEndereco.setText(endereco.trim()+": "+endereco2.trim());

        }catch(IOException x){
        }

        /*   Oficio oficio = new Oficio();

        oficio.setOficio(txtOficio.getText());
        oficio.setAof(txtAOF.getText());
        oficio.setProcesso(txtProcesso.getText());
        oficio.setCorpo(txtCorpo.getText());
        oficio.setDestinario(txtDestinatário.getText());
        oficio.setEndereco(txtEndereco.getText());
        oficio.setAbc(txtAOF.getText());
        oficio.setLinhas(txtLinhas.getText());
        GeraOficioxxxx Ga = new GeraOficioxxxx();

        if ("".equals(txtEndereco.getText())) {
            JOptionPane.showMessageDialog(txtCorpo, "Favor digitar o endereço");
        } else {
            try {
                Ga.GerarAR(oficio);
            } catch (DocumentException | IOException e) {
            }

            ////             try {
                ////                Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c/temp", "start", "ARF.pdf"});
                ////            } catch (IOException e) {
                ////            }
        }

        */
    }//GEN-LAST:event_btnARActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FrmPrincipal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAR;
    private javax.swing.JToggleButton btnLimpar;
    private javax.swing.JButton btnOficio;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txtAOF;
    private javax.swing.JTextField txtAbc;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextPane txtCorpo;
    private javax.swing.JLabel txtData;
    private javax.swing.JTextField txtDestinatário;
    private javax.swing.JTextPane txtEndereco;
    private javax.swing.JTextField txtEnvolvido;
    private javax.swing.JTextField txtInquerito1;
    private javax.swing.JTextField txtLinhas;
    private javax.swing.JTextField txtOficio;
    private javax.swing.JTextField txtOficioN;
    private javax.swing.JTextField txtProcesso;
    private javax.swing.JTextField txtReu;
    // End of variables declaration//GEN-END:variables

    private void EXIT_ON_CLOSE(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
