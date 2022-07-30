package com.email.Email_sending;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Preparing to send message" );
        String message="Hello User";
        String subject="To identify user";
        String to ="adityamulik.scoe.entc@gmail.com";
        String from="mulikadi001@gmail.com";
        sendEmail(message,subject,to,from);
        sendAttach(message,subject,to,from);
        		 
    }
    		//for message with attachment
    		private static void sendAttach(String message, String subject, String to, String from) {
		// TODO Auto-generated method stub
    			// TODO Auto-generated method stub
    			//Variable for mail
    			String host ="smtp.gmail.com";
    			
    			//get system properties
    			Properties properties =System.getProperties();
    			System.out.println("PROPERTIES"+properties);
    			
    			//setting important information to properties object
    			
    			//host
    			properties.put("mail.smtp.host", host);
    			properties.put("mail.smtp.host", "465");
    			properties.put("mail.smtp.ssl.enable", "true");
    			properties.put("mail.smtp.auth","true");
    			
    			//Session to 
    		Session session=Session.getInstance(properties,new Authenticator() {
    			@Override
    			protected PasswordAuthentication getPasswordAuthentication() {
    				return new PasswordAuthentication("write your mail here ","write your mail password");
    			}
    			});
    		session.setDebug(true);
    		
    			// compose the message[text,multimedia]
    		MimeMessage m= new MimeMessage(session);
    		
    			try {
    				m.setFrom(from);
    				//adding recipient to
    				m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
    				
    				
    				//adding subject
    				m.setSubject(subject);
    				
    				//adding text to message
    			//message with attachments
    				
    				String path="C:\\Users\\mulik\\Desktop\\REsume and internships\\Aditya Mulik Resume Updated.pdf";
    				
    				MimeMultipart mimeMultipart= new MimeMultipart();
    				
    				
    				MimeBodyPart textMime =new MimeBodyPart();
    				
    				 MimeBodyPart fileMime =new MimeBodyPart();
    				
    				 try {
    					 textMime.setText(message);
    					 File file =new File(path);
    					 fileMime.attachFile(file);
    					 
    					 mimeMultipart.addBodyPart(textMime);
    					 mimeMultipart.addBodyPart(textMime);
    					 	
    					 m.setContent(mimeMultipart);
    	    				//send message using transport class
    	    				
    	    				Transport.send(m);
    	    				System.out.println("Message Send");
    					 
    				 }
    				 catch(Exception e) {
    					 e.printStackTrace();
    				 }
    				 
    				 
    				
    				
    			} catch (MessagingException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		//
    			
		
	}
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
			//Send Email
	 static void sendEmail(String message, String subject, String to, String from) {
		// TODO Auto-generated method stub
		//Variable for mail
		String host ="smtp.gmail.com";
		
		//get system properties
		Properties properties =System.getProperties();
		System.out.println("PROPERTIES"+properties);
		
		//setting important information to properties object
		
		//host
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.host", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth","true");
		
		//Session to 
	Session session=Session.getInstance(properties,new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("write your mail here ","write your mail password");
		}
		});
	session.setDebug(true);
	
		// compose the message[text,multimedia]
	MimeMessage m= new MimeMessage(session);
	
		try {
			m.setFrom(from);
			//adding recipient to
			m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			
			
			//adding subject
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message);
			
			//send message using transport class
			
			Transport.send(m);
			System.out.println("Message Send");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//



		
	}
}
