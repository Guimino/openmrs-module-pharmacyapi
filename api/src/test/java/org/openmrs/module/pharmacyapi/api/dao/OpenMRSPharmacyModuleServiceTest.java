/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.pharmacyapi.api.dao;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.openmrs.module.pharmacyapi.Item;
import org.openmrs.module.pharmacyapi.api.dao.OpenMRSPharmacyModuleDao;
import org.openmrs.module.pharmacyapi.api.impl.OpenMRSPharmacyModuleServiceImpl;

/**
 * This is a unit test, which verifies logic in OpenMRSPharmacyModuleService. It doesn't extend
 * BaseModuleContextSensitiveTest, thus it is run without the in-memory DB and Spring context.
 */
public class OpenMRSPharmacyModuleServiceTest {
	
	@InjectMocks
	OpenMRSPharmacyModuleServiceImpl basicModuleService;
	
	@Mock
	OpenMRSPharmacyModuleDao dao;
	
	@Mock
	UserService userService;
	
	@Before
	public void setupMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveItem_shouldSetOwnerIfNotSet() {
		//Given
		final Item item = new Item();
		item.setDescription("some description");
		
		when(this.dao.saveItem(item)).thenReturn(item);
		
		final User user = new User();
		when(this.userService.getUser(1)).thenReturn(user);
		
		//When
		this.basicModuleService.saveItem(item);
		
		//Then
		assertThat(item, hasProperty("owner", is(user)));
	}
}
