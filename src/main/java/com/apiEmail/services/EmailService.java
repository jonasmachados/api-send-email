package com.apiEmail.services;

import com.apiEmail.dto.EmailDto;
import com.apiEmail.enums.StatusEmail;
import com.apiEmail.models.Email;
import com.apiEmail.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public Email sendEmail(EmailDto emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        email.setSendDateEmail(LocalDateTime.now());

        try {
            String body = "Name: " + email.getOwnerRef() + "\n\n"
                    + "From: " + email.getEmailFrom() + "\n\n"
                    + email.getText();

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(body);
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        }

        return emailRepository.save(email);
    }

    public Page<Email> findAll(Pageable pageable) {
        return emailRepository.findAll(pageable);
    }

    public Optional<Email> findById(UUID emailId) {
        return emailRepository.findById(emailId);
    }
}
