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
import pdf.GeraOficio;
import pdf.Oficio;

/**
 *
 * @author f7057419
 */
public final class FrmPrincipal_Extratos extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame     *
     * @throws java.io.IOException
     */
    public FrmPrincipal_Extratos() throws IOException, Exception {
        Integer mes;
        String mesExtenso = null;
        
        buscaVersao("GeradorOficiosExtratos");
        
        

        //Para o form ficar no meio da tela    
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        Integer largura;
        Integer altura;

        largura = d.width;
        largura = (largura / 2) - (740 / 2);
        altura = d.height;
        altura = (altura / 2) - (880 / 2);

        initComponents();

        setBounds(largura, altura, 727, 880);
        
        
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
        txtProtocolo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSequencial = new javax.swing.JTextField();
        txtDatat = new javax.swing.JTextField();
        txtProcesso = new javax.swing.JTextField();
        txtDestinatário = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLinhas = new javax.swing.JTextField();
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
        jLabel13.setBounds(10, 540, 110, 26);

        txtData.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        txtData.setForeground(new java.awt.Color(0, 96, 168));
        txtData.setText("São Paulo, 22 de xxxxx de xxxx");
        txtData.setToolTipText("");
        getContentPane().add(txtData);
        txtData.setBounds(10, 76, 310, 20);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 0));
        jLabel11.setText("PROTOCOLO :");
        jLabel11.setToolTipText("");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 129, 150, 14);

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 9)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("Desenvolvido por: F7057419 Maurício da Silva Luiz");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(450, 820, 270, 17);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(10, 182, 697, 10);

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 0));
        jLabel14.setText("OFICIO CENOP SJ N.º : ");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 108, 160, 17);

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel15.setText("_______________________________________________________________________________________");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 760, 710, 17);

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 9)); // NOI18N
        jLabel16.setText("CENOP- Serviços Judiciais São Paulo/SP");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(250, 780, 210, 17);

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setText("BANCO BRASIL S.A.");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(270, 520, 140, 17);

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jLabel18.setText("CENOP SERVIÇOS SÃO PAULO/SP");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(240, 540, 200, 17);

        jLabel19.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 255));
        jLabel19.setText("Resposta:");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(10, 190, 140, 26);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("Digite as iniciaios do seu nome:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(430, 200, 210, 16);

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
        txtAbc.setBounds(650, 200, 60, 18);

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jLabel20.setText("Rua Boa Vista, 254, 14º andar - Centro - CEP 01014-000 - São Paulo-SP");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(180, 800, 390, 17);

        btnOficio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnOficio.setText("OFICIO");
        btnOficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOficioActionPerformed(evt);
            }
        });
        getContentPane().add(btnOficio);
        btnOficio.setBounds(10, 730, 150, 30);

        btnAR.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAR.setText("Corrigir BacenJud Extratos");
        btnAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnARActionPerformed(evt);
            }
        });
        getContentPane().add(btnAR);
        btnAR.setBounds(350, 730, 240, 30);

        btnLimpar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(600, 730, 105, 30);

        txtCorpo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCorpo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(txtCorpo);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 220, 700, 300);

        txtEndereco.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtEndereco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jScrollPane4.setViewportView(txtEndereco);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 610, 700, 110);

        txtOficio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtOficio.setToolTipText("");
        txtOficio.setBorder(null);
        getContentPane().add(txtOficio);
        txtOficio.setBounds(170, 108, 200, 15);

        txtProtocolo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtProtocolo.setToolTipText("");
        txtProtocolo.setBorder(null);
        txtProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProtocoloActionPerformed(evt);
            }
        });
        getContentPane().add(txtProtocolo);
        txtProtocolo.setBounds(170, 129, 200, 15);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("SEQUENCIAL :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 150, 90, 15);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("DATA :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(410, 110, 70, 15);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("PROCESSO :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 130, 90, 15);

        txtSequencial.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtSequencial.setToolTipText("");
        txtSequencial.setBorder(null);
        getContentPane().add(txtSequencial);
        txtSequencial.setBounds(170, 150, 200, 15);

        txtDatat.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDatat.setToolTipText("");
        txtDatat.setBorder(null);
        getContentPane().add(txtDatat);
        txtDatat.setBounds(500, 110, 200, 15);

        txtProcesso.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtProcesso.setToolTipText("");
        txtProcesso.setBorder(null);
        txtProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProcessoActionPerformed(evt);
            }
        });
        getContentPane().add(txtProcesso);
        txtProcesso.setBounds(500, 130, 200, 15);

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
        txtDestinatário.setBounds(10, 580, 220, 20);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel9.setText("Inserir linhas:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(570, 530, 100, 15);

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
        txtLinhas.setBounds(680, 530, 30, 20);

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
        //    GeraOficio G = new GeraOficio();

        Oficio oficio = new Oficio();

        try {
            oficio.setLinhas(Integer.parseInt(txtLinhas.getText()));
        } catch (Exception e) {
            oficio.setLinhas(0);
        }
        try {
            oficio.setOficio(txtOficio.getText());
        } catch (Exception e) {
            oficio.setOficio("");
        }
        try {
           oficio.setProtocolo(txtProtocolo.getText());
        } catch (Exception e) {
          oficio.setProtocolo("");
        }
        try {
            oficio.setSequencial(txtSequencial.getText());
        } catch (Exception e) {
            oficio.setSequencial("");
        }
        try {
            oficio.setDataExtenso(txtData.getText());
        } catch (Exception e) {
            oficio.setData("");
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
            oficio.setProcesso(txtProcesso.getText());
        } catch (Exception e) {
            oficio.setProcesso("");
        }
        try {
            oficio.setEndereco(txtEndereco.getText());
        } catch (Exception e) {
            oficio.setEndereco("");
        }      
        try {
            oficio.setData(txtDatat.getText());
        } catch (Exception e) {
            oficio.setData("");
        }
         try {
            oficio.setAbc(txtAbc.getText());
        } catch (Exception e) {
            oficio.setAbc("");
        }
        
        //  JOptionPane.showMessageDialog(txtOficio,"Dentro do form" +  txtOficio.getText());     
             
        GeraOficio GO = new GeraOficio();
//  teste2 Gd = new teste2();
        if ("xx".equals(txtOficio.getText())) {
            JOptionPane.showMessageDialog(txtOficio, "Favor digitar o número do Ofício");
        } else {
            if ("ABC".equals(txtAbc.getText())) {
                JOptionPane.showMessageDialog(txtAbc, "Favor digitar as iniciais do seu nome");
            } else {
                if ("xx".equals(txtCorpo.getText())) {
                    JOptionPane.showMessageDialog(txtCorpo, "Favor digitar a resposta");
                } else {
                    if ("xx".equals(txtEndereco.getText())) {
                        JOptionPane.showMessageDialog(txtEndereco, "Favor digitar o endereço");
                    } else {
                        try {
                            GO.GerarPagUm(oficio);
                            //  GO.colocaLogo();
                        } catch (IOException | DocumentException | InterruptedException ex) {
                            Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        try {
                            GO.GerarPagDois(oficio);
                            //  GO.colocaLogo();
                        } catch (IOException | DocumentException | InterruptedException ex) {
                            Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                       
                        /*
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
                        */
                          GeraOficio Ga = new GeraOficio();                       
            try {
                Ga.GerarAR(oficio);
            } catch (DocumentException | IOException e) {
            }
        
        
        
        
        //Criar aequivo com oficio e ar juntos
        ArrayList<InputStream> list = new ArrayList<>();
        try {
            list.add(new FileInputStream(new File("c:\\temp\\OficioComLogoPagUm.pdf")));
          list.add(new FileInputStream(new File("c:\\temp\\OficioComLogoPagDois.pdf")));
            list.add(new FileInputStream(new File("c:\\temp\\ARF.pdf")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
    String caminho="c:\\temp\\OficioJunto.pdf";
        try {
            OutputStream out = new FileOutputStream(new File(caminho));
            doMerge(list, out); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Process k = Runtime.getRuntime().exec("cmd.exe /C c:\\temp\\OficioJunto.pdf");
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(Level.SEVERE, null, ex);    
        }                   
                    }
                }
            }
        }
        Oficio oficio2 = new Oficio();
    }//GEN-LAST:event_btnOficioActionPerformed

     
    private void buscaVersao(String Programa) throws SQLException, IOException {//Busca o código do contratado para inserir no banco

        String versao = null;

        try (com.mysql.jdbc.Connection cnenv = (com.mysql.jdbc.Connection) new Conexao().conectar()) {

            String sqlBuscaVesao = "Select * from tbl_VersaoProgramas where tbl_VersaoProgramas.NOMEDOPROGRAMA= " + "'" + Programa + "'";

            java.sql.Statement stm = cnenv.createStatement();
            try {
                ResultSet rs = stm.executeQuery(sqlBuscaVesao);
                //cn.close();
                if (rs.next()) {
                    //Processar, do jeito que você já fez                    
                    versao = rs.getString("VERSAO");
                    //cn.close();                    
                } else {

                }
            } catch (SQLException e) {
            }
        }

        if ("1.06".equals(versao)) {
        } else {
            JOptionPane.showMessageDialog(this, "Versão desatualizada. "
                    + "Favor Copiar a nova em G:\\Publica\\CENTRAL DE OFICIOS");
            try {
                Runtime.getRuntime().exec("explorer G:\\Publica\\CENTRAL DE OFICIOS");
            } catch (IOException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                Runtime.getRuntime().exec("\\\\Srispo02525\\cso1981servjudfunci$\\Publica\\CENTRAL DE OFICIOS");
            }
            System.exit(0);
        }

    }
    
    
    
    
    private void btnARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnARActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:        
         //  Ler o Oficio               
            try{                
      // String local = System.getProperty("user.dir");
        String local ="G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD EXTRATOS\\";
        JFileChooser cx_caminho = new JFileChooser(local);
        int caminho = cx_caminho.showOpenDialog(jLabel1);                
                
   //System.out.println(cx_caminho.getSelectedFile().getAbsolutePath());      
            
            PdfReader reader = new PdfReader(cx_caminho.getSelectedFile().getAbsolutePath());
            int n = reader.getNumberOfPages();
       //    System.out.println("Total de páginas para este pdf: "+n);
            
          String str="";
          String correio="";              
              
          //deixar cabeçalho só na primeira pagina
          int cabeçalho=0;
          
          for (int i = 1; i < n; i++) {              
              if (cabeçalho==0) {
                   correio= PdfTextExtractor.getTextFromPage(reader,i);                   
                   str=correio.replaceAll("______________________________________________________________________________\n" +
"CENOP SERVIÇOS Judiciais SÃO PAULO/SP\n" +
"Rua Boa Vista, 254, 14º andar - Centro - CEP 01014-000 - São Paulo-SP", "");  
                   cabeçalho=1;
              }else{
                   correio= PdfTextExtractor.getTextFromPage(reader,i);
                   int tamanhoCorreio;
                   tamanhoCorreio=correio.length();
                   correio=correio.substring(69, tamanhoCorreio);
                   correio=correio.replaceAll("______________________________________________________________________________\n" +
"CENOP SERVIÇOS Judiciais SÃO PAULO/SP\n" +
"Rua Boa Vista, 254, 14º andar - Centro - CEP 01014-000 - São Paulo-SP", "");
                   str=str+correio;
                   
//                   String a[]=str.split("de 2014");//mudar em 2015
//                   str=a[cabeçalho];  
                   cabeçalho=cabeçalho++;
              }         
          }
  
           System.out.println(str);                
          //extraindo o conteúdo de uma página específica         
          
    //      System.out.println("Conteudo: "+str);
            
    //   JOptionPane.showMessageDialog(txtCorpo, str);
            
        //NÚMERO DO OFICIO
         String A[] = str.split("SJ N.º :");
         String nOfiocio = (A[1]);      
         String B[] = nOfiocio.split("\n");
         nOfiocio = (B[0]).trim(); 
   //      System.out.println(nOfiocio);     
        txtOficio.setText(nOfiocio);        
        txtAbc.setText("ABC");
        
          //PROTOCOLO
         String i[] = str.split("Protocolo ...................... :");
         String protocolo = (i[1]);      
         String j[] = protocolo.split("\n");
         protocolo = (j[0]).trim(); 
        
        txtProtocolo.setText(protocolo);     
        
        //NÚMERO DO sequencial 
         String C[] = str.split("Sequencial ................... :");
         String sequencial = (C[1]);      
         String D[] = sequencial.split("\n");
         sequencial = (D[0]).trim(); 
    //     System.out.println(nProcesso);           
        txtSequencial.setText(sequencial);
        
        //data
         String E[] = str.split("Data ............................. :");
         String data = (E[1]);      
         String F[] = data.split("\n");
         data = (F[0]).trim(); 
     //    System.out.println(autor);           
        txtDatat.setText(data);
                       
          //PROCESSO
         String c[] = str.split("Processo ...................... :");
         String processo = (c[1]);      
         String d[] = processo.split("\n");
         processo = (d[0]).trim();
         txtProcesso.setText(processo);
         
         //CORPO
               
         
         String co[] = str.split("&&");          
         String corpo = (co[1]);      
         String Co[] = corpo.split("##");
         corpo = (Co[0]).trim();    
        
      
         
       txtCorpo.setText(corpo);             
        
       txtDestinatário.setText("Ao (A) Excelentíssimo (A) Dr(a):");
     //   txtOficioN.setText("");
     //   txtEnvolvido.setText("");
        
        System.out.println(str);
        //endereço
         String K[] = str.split("CENOP SERVIÇOS SÃO PAULO/SP");
         String endereco = (K[1]);
       //  System.out.println("/////////// \n"+endereco); 
//         String k[] = endereco.split(":");    
//         endereco = (k[1]);
//         
//         String kv[] = str.split("CEP:");         
//         String endereco2 = (kv[1].trim());
//         String tt[] = endereco2.split("\n");
//         endereco2 = (tt[0]).trim();
         
         String kv[] = endereco.split(":");         
         endereco = (kv[1].trim());
         
         System.out.println("*************"+endereco.trim());    
         
         
//         String L[] = endereco.split("______________________________________________________________________________");
//         endereco = (L[0]).trim(); 
//         System.out.println(endereco);        
           txtEndereco.setText(endereco.trim());    
            
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
        GeraOficio Ga = new GeraOficio();

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
            txtProcesso.setText(rs.getString("nome"));
            txtProtocolo.setText(rs.getString("gsv"));
            txtSequencial.setText(rs.getString("processo"));
//            txtReu.setText(rs.getString("AUTOR_PRINC"));
            txtDestinatário.setText("");
            txtDatat.setText(rs.getString("n_ofic_orig"));
  //          txtEnvolvido.setText("");
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
        txtProcesso.setText("");
        txtProtocolo.setText("");
        txtSequencial.setText("");
//        txtReu.setText("");
        txtDestinatário.setText("");
        txtDatat.setText("");
  //      txtEnvolvido.setText("");
        txtCorpo.setText("");
        txtDestinatário.setText("");
        txtEndereco.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProtocoloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProtocoloActionPerformed

    private void txtProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProcessoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProcessoActionPerformed

    private void txtDestinatárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinatárioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinatárioActionPerformed

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
        txtProcesso.setText("Agnaldo Terra Rocha");
        txtProtocolo.setText("2014/10120");
        txtSequencial.setText("0004853-70.2013.8.26.0269");
//        txtReu.setText("Paloma Martins Rocha e outros");
        txtDestinatário.setText("");
        txtDatat.setText("");
  //      txtEnvolvido.setText("");
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
            java.util.logging.Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FrmPrincipal_Extratos().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(FrmPrincipal_Extratos.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txtAbc;
    private javax.swing.JTextPane txtCorpo;
    private javax.swing.JLabel txtData;
    private javax.swing.JTextField txtDatat;
    private javax.swing.JTextField txtDestinatário;
    private javax.swing.JTextPane txtEndereco;
    private javax.swing.JTextField txtLinhas;
    private javax.swing.JTextField txtOficio;
    private javax.swing.JTextField txtProcesso;
    private javax.swing.JTextField txtProtocolo;
    private javax.swing.JTextField txtSequencial;
    // End of variables declaration//GEN-END:variables

    private void EXIT_ON_CLOSE(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
