package com.fpbm.pack.repositories;

import com.fpbm.pack.entities.Courstdtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourstdtpRepository extends JpaRepository<Courstdtp, Long> {
}
