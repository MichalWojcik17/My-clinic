package com.MichalWojcik.Clinic1.repository;

import com.MichalWojcik.Clinic1.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository <Patient,Long> {
}
