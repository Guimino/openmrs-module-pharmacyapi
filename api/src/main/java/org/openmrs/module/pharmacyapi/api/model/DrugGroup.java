/**
 * 
 */
package org.openmrs.module.pharmacyapi.api.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.search.annotations.DocumentId;
import org.openmrs.BaseOpenmrsData;
import org.openmrs.Drug;

/**
 * @author Guimino Neves
 */
public class DrugGroup extends BaseOpenmrsData implements Serializable {
	
	private static final long serialVersionUID = -1619599668675538201L;
	
	// Fields
	@DocumentId
	private Integer drugGroupId;
	
	List<Drug> members;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.drugGroupId;
	}
	
	@Override
	public void setId(final Integer drugGroupId) {
		
		this.drugGroupId = drugGroupId;
	}
	
	public List<Drug> getMembers() {
		return this.members;
	}
	
	public void setMembers(final List<Drug> members) {
		this.members = members;
	}
	
}
