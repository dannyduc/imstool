package com.ingenuity.imstool;

import com.ingenuity.inguser.api.v1.model.User;
import com.ingenuity.inguser.api.v1.service.ServiceException;
import com.ingenuity.inguser.api.v1.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetUserID {

    public static void main(String[] args) throws ServiceException {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("conf/inguser-client.xml");
        UserService userService = (UserService) appContext.getBean("inguser:clientUserService");
        User user = userService.getUserByUsername(args[0]);
        int userId = user.getUserId();
        System.out.println(userId);
    }
}
