package com.example.TurneraMedica.service.impl;

import com.example.TurneraMedica.dto.Appointment.AppointmentCreateDTO;
import com.example.TurneraMedica.dto.Appointment.AppointmentDTO;
import com.example.TurneraMedica.exception.BusinessException;
import com.example.TurneraMedica.exception.NotFoundException;
import com.example.TurneraMedica.mapper.MapperAppointment;
import com.example.TurneraMedica.model.*;
import com.example.TurneraMedica.repository.*;
import com.example.TurneraMedica.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private AppointmentRepository repoAppointment;

    @Autowired
    private DoctorRepository repoDoctor;

    @Autowired
    private PatientRepository repoPatient;

    @Autowired
    private PatientHealthInsuranceRepository repoPatientInsurance;

    @Autowired
    private DoctorHealthInsuranceRepository repoDoctorInsurance;


    @Override
    public List<AppointmentDTO> findAllAppointments() {

        return repoAppointment.findAll().stream().map(MapperAppointment::toDTO).toList();
    }

    @Override
    public AppointmentDTO findById(Long id){

        return MapperAppointment.toDTO(repoAppointment.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO APPOINTMENT WITH THAT ID")));
    }

    @Override
    public AppointmentDTO createAppoinment(AppointmentCreateDTO appointmentCreateDTO) {

        Appointment newAppointment = MapperAppointment.toEntity(appointmentCreateDTO);

        //nos falta el objeto paciente y el objeto medico

        //verifico que la fecha sea valida antes de buscar para no perder tiempo buscando
        //el paciente y el doctor si despues es invalida la fecha del turno.

        LocalDateTime appointmentDateTime = LocalDateTime.of(newAppointment.getDate(), newAppointment.getTime());


        if (appointmentDateTime.isBefore(LocalDateTime.now())) {

            throw new BusinessException("APPOINTMENT CANNOT BE IN THE PAST");
        }

        Patient patient = repoPatient.findById(appointmentCreateDTO.getPatientId())
                .orElseThrow(() -> new NotFoundException("THERE IS NO PATIENT WITH THAT ID"));

        Doctor doctor = repoDoctor.findById(appointmentCreateDTO.getDoctorId())
                .orElseThrow(() -> new NotFoundException("THERE IS NO DOCTOR WITH THAT ID"));

        //los agrego a la entidad

        newAppointment.setDoctor(doctor);
        newAppointment.setPatient(patient);

        newAppointment.setBasePrice(new BigDecimal("10000.00"));

        verifyInsurance(doctor, patient, newAppointment);

        return MapperAppointment.toDTO(repoAppointment.save(newAppointment));
    }

    @Override
    public void cancelAppointment(Long id) {

        if (!repoAppointment.existsById(id)) throw new NotFoundException("IT DOES NOT EXITS AN APPOINTMENT WITH THAT ID");

        repoAppointment.deleteById(id);
    }


    private void verifyInsurance(Doctor doctor, Patient patient, Appointment appointment){

        //los traigo todos los que coinciden en una lista
        List<PatientHealthInsurance> patientInsurances = repoPatientInsurance.findByPatientId(patient.getId()).stream().toList();

        List<DoctorHealthInsurance> doctorHealthInsurances = repoDoctorInsurance.findByDoctorId(doctor.getId()).stream().toList();

        appointment.setTotalPrice(appointment.getBasePrice());

        //con for
        for (PatientHealthInsurance patientInsurance : patientInsurances){

            for (DoctorHealthInsurance doctorInsurance : doctorHealthInsurances){

                //si coinciden la obra social y el plan

                if ((patientInsurance.getHealthInsurance().getId().equals(doctorInsurance.getHealthInsurance().getId())) && (patientInsurance.getPlan().getId().equals(doctorInsurance.getPlan().getId()))){

                    BigDecimal total = BigDecimal.ZERO;
                    BigDecimal insurance = BigDecimal.ZERO;



                    insurance = appointment.getBasePrice().multiply(patientInsurance.getPlan().getCoveragePercentage()).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
                    total = appointment.getBasePrice().subtract(insurance);

                    if (appointment.getTotalPrice().compareTo(total) > 0){

                        appointment.setTotalPrice(total);
                    }
                }
            }
        }
    }
}
