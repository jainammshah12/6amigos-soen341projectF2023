package com.realestate.real_estate.services;

import com.realestate.real_estate.repos.AppointmentRepository;
import com.realestate.real_estate.repos.Appointment;
import com.realestate.real_estate.repos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(String id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No appointment by ID: " + id));
    }
    public Appointment bookAppointment(String dateTime, String username) {
        Appointment appointment = new Appointment();
        appointment.setDateTime(dateTime);
        appointment.setUsername(username);
        appointmentRepository.save(appointment);
        return appointment;
    }

}