package com.placamas.vista;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.swing.JOptionPane;


public class Email {

	public void sendMail(String address, String subject, String message)throws Exception{
		String from = "";
		String pass = "";
		String[] to={address};
		String host="smtp.gmail.com";
		
		Properties prop=System.getProperties();
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.user", from);
		prop.put("mail.smtp.password", pass);
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		
		
		Session session = Session.getDefaultInstance(prop);
		MimeMessage msg= new MimeMessage(session);
		msg.setFrom(new InternetAddress(from));
		InternetAddress[] toaddress= new InternetAddress[to.length];
		
		for(int i = 0; i< to.length;i++){
			toaddress[i]=new InternetAddress(to[i]);
		}
		
		for(int i = 0; i< toaddress.length;i++){
			msg.setRecipient(Message.RecipientType.TO, toaddress[i]);
		}
		
		msg.setSubject(subject);
		msg.setContent(message , "text/html; charset=utf-8");
		Transport transport = session.getTransport("smtp");
		transport.connect(host, from, pass);
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();
		
	}

	/*
	
	try{
		
		if(txtMail.getText() != null && !txtMail.getText().equals("")){
			
			Email email= new Email();
			email.sendMail(txtMail.getText(), txtSubject.getText(), txtMessage.getText());
			txtMail.setText("");
			txtSubject.setText("");
			txtMessage.setText("");
		}else{
			JOptionPane.showMessageDialog(null,"Value required : Mail","Error", JOptionPane.OK_OPTION);
		}
	}catch(Exception e) {
		
		
	}
	
	*/
	
}
