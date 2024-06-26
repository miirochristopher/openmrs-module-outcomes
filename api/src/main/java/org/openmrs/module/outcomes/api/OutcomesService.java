/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.outcomes.api;

import org.openmrs.PersonAttributeType;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.outcomes.Questionaire;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
public interface OutcomesService extends OpenmrsService {
	
	/**
	 * Returns a Questionaire by uuid. It can be called by any authenticated user. It is fetched in
	 * read only transaction.
	 */
	@Transactional(readOnly = true)
	Questionaire getQuestionnaireByUuid(String uuid) throws APIException;
	
	/**
	 * Saves a Questionaire. Sets the owner to superuser, if it is not set. It can be called by
	 * users with this module's privilege. It is executed in a transaction.
	 */
	@Transactional
	Questionaire saveQuestionnaire(Questionaire questionaire) throws APIException;
	
	/**
	 * Voids a Questionaire. It can be called by users with this module's privilege
	 */
	@Transactional
	Questionaire voidQuestionnaire(Questionaire questionaire, String reason) throws APIException;
	
	/**
	 * Voids a Questionaire. It can be called by users with this module's privilege
	 */
	@Transactional
	void purgeQuestionnaire(Questionaire questionaire) throws APIException;
	
	/**
	 * Get patients having person attributes of a particular type or that contain certain values.
	 * 
	 * @return patient matching the query
	 */
	Integer getPatientHavingPersonAttributes(PersonAttributeType attributeType, List<String> values) throws APIException;
}
