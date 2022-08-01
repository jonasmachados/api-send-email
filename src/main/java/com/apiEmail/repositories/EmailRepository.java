
package com.apiEmail.repositories;

import com.apiEmail.models.Email;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}