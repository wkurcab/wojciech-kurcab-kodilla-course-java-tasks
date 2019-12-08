package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("companyName", adminConfig.getCompanyName());
        context.setVariable("companyGoal", adminConfig.getCompanyGoal());
        context.setVariable("companyAddress",
                adminConfig.getCompanyAddressStreet() + " " +
                        adminConfig.getCompanyAddressNumber());
        context.setVariable("companyPhone", "phone: " + adminConfig.getCompanyPhone());
        context.setVariable("goodbye_message", "Best regards ;)");
        context.setVariable("show_button", true);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);

        context.setVariable("scheduler_preview", "Email scheduler");
        context.setVariable("is_report", false);
        context.setVariable("scheduler_report", "Daily report");
        context.setVariable("end_message", "Thanks for your attention :)");

        return templateEngine.process("mail/created-trello-card-mail-scheduler", context);
    }
}
