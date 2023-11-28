/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package springHibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springHibernate.service.MahasiswaService;

/**
 *
 * @author Tamcin
 */
public class App {
    private static ApplicationContext applicationContext;
    
    public static void main(String[] args) {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-configuration.xml");
        new MahasiswaView().setVisible(true);
    }
    
    public static MahasiswaService getMahasiswaService() {
        return (MahasiswaService) applicationContext.getBean("MahasiswaService");
    }
}
