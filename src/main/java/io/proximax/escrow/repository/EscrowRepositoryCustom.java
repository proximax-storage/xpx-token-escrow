package io.proximax.escrow.repository;

import io.proximax.escrow.document.Escrow;

public interface EscrowRepositoryCustom {

	public long findMaxId();	
	
	public boolean monitor();
	
	public void save(Escrow row);
	
}
