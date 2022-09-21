//Clase para enviar correos.
//Importar los archivos jar:
/*
mail.jar
java-inject.jar
javax.activation.jar
java.ejb.jar
javax.faces.jar
*/
package enviodecorreos;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Erik Jose
 */
public class Correo {
    private String correoDeOrigen;
    private String correoDeDestino;
    private String asunto;
    private String mensajeDeTexto;
    private String contraseña16Digitos;
            
  public Correo(String origen,String destino,String asunto,
          String txt,String contra16Digitos){
   this.correoDeOrigen = origen;
   this.correoDeDestino = destino;
   this.asunto = asunto;
   this.mensajeDeTexto = txt;
   this.contraseña16Digitos = contra16Digitos;
   
  }
  public void envioDeCorreos(){
      envioDeMensajes();
  }
  private void envioDeMensajes(){
      try{
  Properties p = new Properties();  
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user",correoDeOrigen);
        p.setProperty("mail.smtp.auth", "true");
        Session s = Session.getDefaultInstance(p); 
        MimeMessage mensaje = new MimeMessage(s);
        mensaje.setFrom(new InternetAddress(correoDeOrigen));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDeDestino));
        mensaje.setSubject(asunto);
        mensaje.setText(mensajeDeTexto);
            
          Transport t = s.getTransport("smtp");
          t.connect(correoDeOrigen,contraseña16Digitos);
          t.sendMessage(mensaje, mensaje.getAllRecipients());
          t.close();
          JOptionPane.showMessageDialog(null,"Mensaje enviado");
          } catch (MessagingException e) {
           
        }
  }
}
