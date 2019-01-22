/*
 * Copyright 2017-2019 The OpenAds Project
 *
 * The OpenAds Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package ai.houyi.zhuque.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ai.houyi.dorado.rest.annotation.Controller;
import ai.houyi.dorado.rest.annotation.DELETE;
import ai.houyi.dorado.rest.annotation.GET;
import ai.houyi.dorado.rest.annotation.POST;
import ai.houyi.dorado.rest.annotation.Path;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.IController;
import ai.houyi.zhuque.core.model.query.AuditAdvertiserQueryReq;
import ai.houyi.zhuque.core.service.AuditAdvertiserService;
import ai.houyi.zhuque.dao.model.AdvertiserQualification;
import ai.houyi.zhuque.dao.model.AuditAdvertiser;
import io.swagger.annotations.Api;

/**
 * @author weiping wang
 */
@Controller
@Path("/audit-advertisers")
@Api(tags = "审核广告主管理")
public class AuditAdvertiserController implements IController<AuditAdvertiser, AuditAdvertiserQueryReq, Integer> {
	@Autowired
	private AuditAdvertiserService auditAdvertiserService;

	@POST
	@Path
	public void saveOrUpdate(AuditAdvertiser t) {
		if (t.getId() == null) {
			auditAdvertiserService.save(t);
		} else {
			auditAdvertiserService.update(t);
		}
	}

	@DELETE
	@Path("/{id}")
	public void deleteById(Integer id) {
		auditAdvertiserService.deleteById(id);
	}

	@GET
	@Path("/{id}")
	public AuditAdvertiser loadById(Integer id) {
		return auditAdvertiserService.loadById(id);
	}

	@POST
	@Path("/list")
	public Page<AuditAdvertiser> selectPage(AuditAdvertiserQueryReq queryReq) {
		queryReq.initPageInfoIfNeed();
		return auditAdvertiserService.selectPageList(queryReq);
	}

	@GET
	@Path("/qualifications/{advertiserId}")
	public List<AdvertiserQualification> getAdvertiserQualifications(Integer advertiserId) {
		return auditAdvertiserService.getAdvertiserQualificationsByAdvertiserId(advertiserId);
	}

	@POST
	@Path("/qualifications")
	public void addAdvertiserQualification(AdvertiserQualification qualification) {
		auditAdvertiserService.addAdvertiserQualification(qualification);
	}
	
	@DELETE
	@Path("/qualifications/{qualificationId}")
	public void deleteAdvertiserQualification(Integer qualificationId) {
		auditAdvertiserService.deleteAdvertiserQualification(qualificationId);
	}
}
