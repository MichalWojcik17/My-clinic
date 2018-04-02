package com.MichalWojcik.Clinic1.repository;

import com.MichalWojcik.Clinic1.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface doctorRepository extends CrudRepository<Doctor,Long> {

}
