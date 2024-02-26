package com.aihairadvise.repository;

import com.aihairadvise.model.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdviceRepository extends JpaRepository<Advice, Long> {

    Optional<Advice> findByAttributes(Advice.FaceShape faceShape,
                                      Advice.ForeheadHeight foreheadHeight,
                                      Advice.NoseSize noseSize,
                                      Advice.LipFullness lipFullness,
                                      Advice.EyeColor eyeColor,
                                      Advice.Gender gender);
}
