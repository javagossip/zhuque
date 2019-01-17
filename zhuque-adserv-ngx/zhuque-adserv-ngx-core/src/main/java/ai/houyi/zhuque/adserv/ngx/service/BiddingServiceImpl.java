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
package ai.houyi.zhuque.adserv.ngx.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;

import ai.houyi.adserv.ngx.proto.BiddingProto.BiddingReq;
import ai.houyi.adserv.ngx.proto.BiddingProto.BiddingRsp;
import ai.houyi.adserv.ngx.proto.BiddingProto.BiddingService;
import ai.houyi.adserv.ngx.proto.BiddingProto.BiddingService.BlockingInterface;
import ai.houyi.adserv.ngx.proto.BiddingProto.BiddingService.Interface;

/**
 *
 * @author weiping wang
 */
public class BiddingServiceImpl implements BlockingInterface, Interface {
	private static final Logger LOG = LoggerFactory.getLogger(BiddingService.class);

	@Override
	public void search(RpcController controller, BiddingReq request, RpcCallback<BiddingRsp> done) {
		try {
			done.run(search(controller, request));
		} catch (ServiceException ex) {
			LOG.error("handle search ad request error, cause: "+ex.getMessage(),ex);
		}
	}

	@Override
	public BiddingRsp search(RpcController controller, BiddingReq request) throws ServiceException {
		//TODO 
		return null;
	}

}
