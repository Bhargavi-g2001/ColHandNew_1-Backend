package com.example.demo.dto;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.controller.EmailService;
import com.example.demo.entity.PendingCustomerdetails;
import com.example.demo.service.PendingCustomerService;

import jakarta.mail.MessagingException;
@Component
public class EmailScheduler {


	private final PendingCustomerService customerService;

    private final EmailService emailService;

 

    @Autowired

    public EmailScheduler(PendingCustomerService customerService, EmailService emailService) {

        this.customerService = customerService;

        this.emailService = emailService;

    }

 
//method for remainder mail - today
    @Scheduled(cron = "0 07 15 * * ?") // This schedules the task to run every day at midnight

    public void sendDueDateReminders() {

    	System.out.println("Scheduled mail executed at 07:35 PM.");

        List<PendingCustomerdetails> customers = customerService.getCustomersWithDueDateToday();

        for (PendingCustomerdetails customer : customers) {

            String emailContent = "<html><body>Dear Customer, Your Postpaid plan will expire on " +customer.getDuedate() + "To continue services,click below button to pay.<form action='http://localhost:4200/Customer'><input type='submit' value='pay'></form></body></html>";

            try {

                emailService.sendEmail(customer.getEmail(), "Payment Reminder", emailContent);

            } catch (MessagingException e) {

                // Handle email sending exception (log or rethrow if necessary)

                e.printStackTrace();

            }

        }

    }
    
    //email for 1 day ago
    @Scheduled(cron = "0 34 10 * * ?") // This schedules the task to run every day at midnight

    public void sendDueDateReminders1() {

    	System.out.println("Scheduled mail executed at 07:35 PM.");

        List<PendingCustomerdetails> customers = customerService.getDueCustomers1();
        for (PendingCustomerdetails customer : customers) {

            String emailContent ="<html><body>Dear Customer, Your Postpaid plan will expire on " +customer.getDuedate() + " . Once Plan expired ,your services will be stopped.To continue services,click below button to pay.<form action='http://localhost:4200/Customer'><input type='submit' value='pay'></form></body></html>";

            
            try {
               emailService.sendEmail(customer.getEmail(), "Payment Reminder 1 day ago", emailContent);
           } catch (MessagingException e) {

               // Handle email sending exception (log or rethrow if necessary)

               e.printStackTrace();
           }

      }

    }
  
    //email for 3 days ago
    @Scheduled(cron = "0 39 10 * * ?") // This schedules the task to run every day at midnight

    public void sendDueDateReminders3() {

    	System.out.println("Scheduled mail executed at 07:35 PM.");

        List<PendingCustomerdetails> customers = customerService.getDueCustomer3();
        for (PendingCustomerdetails customer : customers) {

            String emailContent = "<html><body>Dear Customer, Your Postpaid plan will expire on " +customer.getDuedate() + " . Once Plan expired ,your services will be stopped.To continue services,click below button to pay.<form action='http://localhost:4200/Customer'><input type='submit' value='pay'></form></body></html>";


            try {
               emailService.sendEmail(customer.getEmail(), "Payment Reminder 3 day ago", emailContent);
           } catch (MessagingException e) {

               // Handle email sending exception (log or rethrow if necessary)

               e.printStackTrace();
           }

      }

    }
    
    //email for termination
    @Scheduled(cron = "0 52 10 * * ?") // This schedules the task to run every day at midnight

    public void sendDueDateReminders5() {

    	System.out.println("Scheduled mail executed at 07:35 PM.");

        List<PendingCustomerdetails> customers = customerService.getDueCustomer5();
        for (PendingCustomerdetails customer : customers) {

            String emailContent = "<html><body>Dear Customer, Your Postpaid service is terminated.To continue services,click below link to pay.<form action='http://localhost:4200/customer1'><input type='submit' value='pay'></form></body></html>";

            try {
               emailService.sendEmail(customer.getEmail(), "Reminder, Your Recharge service is terminated", emailContent);
           } catch (MessagingException e) {

               // Handle email sending exception (log or rethrow if necessary)

               e.printStackTrace();
           }

      }

    }
  
  
}
