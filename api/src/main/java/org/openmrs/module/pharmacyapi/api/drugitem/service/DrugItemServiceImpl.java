package org.openmrs.module.pharmacyapi.api.drugitem.service;

import java.util.List;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.pharmacyapi.api.common.exception.PharmacyBusinessException;
import org.openmrs.module.pharmacyapi.api.drugitem.dao.DrugItemDAO;
import org.openmrs.module.pharmacyapi.api.drugitem.model.DrugItem;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *
 */

@Transactional
public class DrugItemServiceImpl extends BaseOpenmrsService implements DrugItemService {
	
	private DrugItemDAO drugItemDAO;
	
	@Override
	public void setDrugItemDAO(final DrugItemDAO drugItemDAO) {
		this.drugItemDAO = drugItemDAO;
	}
	
	@Override
	public void saveDrugItem(final DrugItem drugItem) {
		this.drugItemDAO.save(drugItem);
	}
	
	@Override
	public DrugItem findDrugItemByUuid(final String uuid) {
		return this.drugItemDAO.findByUuid(uuid);
	}
	
	@Override
	public List<DrugItem> findAllDrugItem(final Boolean retired) {
		return this.drugItemDAO.findAll(retired);
	}
	
	@Override
	public DrugItem findDrugItemByDrugId(Integer drugId) throws PharmacyBusinessException {
		return this.drugItemDAO.findByDrugId(drugId);
	}
}
