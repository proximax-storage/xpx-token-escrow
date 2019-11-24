package io.proximax.escrow.repository;

import io.proximax.escrow.document.Escrow;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EscrowRepository extends MongoRepository<Escrow, String> {
}
