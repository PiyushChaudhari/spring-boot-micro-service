package com.notification.service.services;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.notification.service.vo.WelcomeMailVO;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class EmailServiceImpl implements EmailService{
	
	Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
    private JavaMailSender emailSender;

    @Autowired
    private Configuration freemarkerConfig;

	@Override
	public ResponseEntity<Object> sendMail(WelcomeMailVO welcomeMailVO){
		log.info("Request WelcomeMailVO:> {} ",welcomeMailVO);
		
		try {
		
		 MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message,
	                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
	                StandardCharsets.UTF_8.name());

	        
	        Map<String,String> model = new HashMap<>();

	        model.put("name", welcomeMailVO.getName());
	        model.put("location", welcomeMailVO.getLocation());
	        model.put("signature", welcomeMailVO.getSignature());
	        
	        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates/");
	        Template t = freemarkerConfig.getTemplate("welcom-template.ftl");
	        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
	        helper.setTo(welcomeMailVO.getTo());
	        helper.setText(html, true);
	        helper.setSubject("Welcome");
	        
	        emailSender.send(message);
	        return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
