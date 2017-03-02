/*
 * Friends in Global Health - FGH © 2016
 */
package org.openmrs.module.pharmacyapi.db;

import org.hibernate.FlushMode;

/**
 * @author Stélio Moiane
 */
public interface DbSessionManager {
	
	FlushMode getCurrentFlushMode();
	
	void setManualFlushMode();
	
	void setFlushMode(FlushMode flushMode);
	
	void setAutoFlushMode();
}
