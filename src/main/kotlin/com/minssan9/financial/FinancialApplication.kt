package com.minssan9.financial

import com.minssan9.financial.krbank.Service.ApiService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.PropertySource
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@SpringBootApplication
@PropertySource("account.properties")
class FinancialApplication

val dateFormatString = DateTimeFormatter.ofPattern("yyyyMMdd")
val timeFormatString = DateTimeFormatter.ofPattern("HHmm")

val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

val logger = LoggerFactory.getLogger(FinancialApplication::class.java)

fun main(args: Array<String>) {
    runApplication<FinancialApplication>(*args)
}


@Autowired
lateinit var apiService: ApiService

@Bean
fun  applicationRunner() : ApplicationRunner {
    return ApplicationRunner() {
        fun run(){
            var startDate =
                    LocalDateTime.of(2020, 1, 1, 0, 0)
                            .format(dateFormatString)
            var endDate = LocalDateTime.now().format(dateFormatString)


            logger.info(apiService.getKOSPI(startDate, endDate).toString())
        }
    }
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

