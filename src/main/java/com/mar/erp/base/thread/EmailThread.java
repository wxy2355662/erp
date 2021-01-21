package com.mar.erp.base.thread;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;


public class EmailThread implements Runnable {

    //邮件发送
    private JavaMailSenderImpl mailSender;
    private String email;
    private String msg;


        public EmailThread(JavaMailSenderImpl mailSender, String email, String msg) {
        this.mailSender = mailSender;
        this.email = email;
        this.msg = msg;
    }

    @Override
    public void run() {
        //发送邮件通知密码重置成功
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setFrom("2397632516@qq.com");//一定要写，501 mail from address must be same as authorization user的错误
        String textX=msg;
        mailMessage.setSubject("您好,本邮件由ERP系统推送！");
        mailMessage.setText(textX);
        mailSender.send(mailMessage);
    }
}
