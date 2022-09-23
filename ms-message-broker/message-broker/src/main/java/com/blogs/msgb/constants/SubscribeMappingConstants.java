/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.msgb.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SubscribeMappingConstants {
	public Map<String,List<String>> mainToSubscribe = new HashMap<String, List<String>>();
	public Map<String,List<String>> mainToSubscribeName = new HashMap<String, List<String>>();
	
	@SuppressWarnings("serial")
	public SubscribeMappingConstants(
			@Value(value = "${msg.service.admin-service-event-receiver}") String adminServiceReceiver,
			@Value(value = "${msg.service.customer-service-event-receiver}") String customerServiceReceiver,
			@Value(value = "${msg.service.authenticate-service-event-receiver}") String authenServiceReceiver
	){
		/**Mapping Subscript register-service**/
		mainToSubscribe.put("customer-service",new ArrayList<String>(){{
			add(authenServiceReceiver);
		}});
		mainToSubscribe.put("admin-service",new ArrayList<String>(){{
		    	add(authenServiceReceiver);
		}});
		mainToSubscribe.put("authenticate-service",new ArrayList<String>(){{
		}});
		/*==================================================================================*/
		mainToSubscribeName.put("customer-service", new ArrayList<String>(){{
			add("authenticate-service");
		}});
		mainToSubscribeName.put("admin-service",new ArrayList<String>(){{
		    	add("authenticate-service");
		}});
		mainToSubscribeName.put("authenticate-service",new ArrayList<String>(){{
		}});
	}
}
