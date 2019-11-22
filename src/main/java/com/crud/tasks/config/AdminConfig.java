package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AdminConfig {
    @Value("${admin.mail}")
    private String adminMail;
    @Value("${cc.mail}")
    private String ccMail;
    @Value("${admin.name}")
    private String adminName;

    @Value("${info.company.name}")
    private String companyName;
    @Value("${info.company.goal}")
    private String companyGoal;
    @Value("${info.company.phone}")
    private String companyPhone;
    @Value("${info.app.administrator.address.street}")
    private String companyAddressStreet;
    @Value("${info.app.administrator.address.number}")
    private String companyAddressNumber;
}
