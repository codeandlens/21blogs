/**
 * @author bustlesoft.com
 * woottipong
 * 
 */
package com.blogs.service;

import com.blogs.entity.Appointment;
import com.blogs.entity.Booking;
import com.blogs.entity.Branch;
import com.blogs.entity.CustomerDetail;
import com.blogs.entity.Doctor;
import com.blogs.entity.InviteDetail;
import com.blogs.entity.PaymentSlip;
import com.blogs.entity.Questionnaire;
import com.blogs.entity.User;

public interface SubscriptedService {
    
    public CustomerDetail getLastestCustomer();
    public Appointment getLastestAppointment();
    public Booking getLastestBooking();
    public Doctor getLastestDoctor();
    public Branch getLastestBranch();
    public Questionnaire getLastestQuestionnaire();
    public InviteDetail getLastestInvite();
    public User getLastestUser();
    public PaymentSlip getLastestPaymentSlip();
    
    public void saveAppointment(Appointment appointment);
    public void saveDoctor(Doctor appointment);
    public void saveBranch(Branch appointment);
    public void saveQuestionnaire(Questionnaire questionnaire);
    
    public void saveUser(User user);
    
    public void saveSlip(PaymentSlip slip);

}
