package com.minssan9.financial

import com.minssan9.financial.krbank.Service.ApiService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:account.properties")
//@CrossOrigin({"http://shop.voyagerss.com", "http://localhost", "http://www.voyagerss.com"})
class FinancialApplication

    fun main(args: Array<String>) {
        runApplication<FinancialApplication>(*args)
    }

//    val logger = LoggerFactory.getLogger(FinancialApplication::class.java)

    @Autowired
    lateinit var apiService : ApiService

    @Throws(Exception::class)
    fun run(args: ApplicationRunner){
        println(apiService.getKOSPI().toString())
    }




    // @Value("${email.account}")
    // String emailAccount;
    // @Value("${email.password}")
    // String emailPassword;

    // @Value("${file-resources-path}")
    // public static String FILE_RESOURCES_PATH;

//    @Bean
//    fun passwordEncoder()
//    {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }

    // @Bean
    // public JavaMailSender getJavaMailSender() {
    //     // 구글 계정에서 보안 수준이 낮은 앱의 액세스 설정이 허용하기

    //     JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    //     mailSender.setHost("smtp.gmail.com");
    //     mailSender.setPort(587);

    //     mailSender.setUsername(emailAccount);
    //     mailSender.setPassword(emailPassword);

    //     Properties props = mailSender.getJavaMailProperties();
    //     props.put("mail.transport.protocol", "smtp");
    //     props.put("mail.smtp.auth", "true");
    //     props.put("mail.smtp.starttls.enable", "true");
    //     props.put("mail.debug", "true");

    //     return mailSender;
    // }

