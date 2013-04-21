package com.lysoft.business.web.aes.common.upload;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.lysoft.framework.common.service.ResponseObject;
import com.lysoft.framework.common.service.ServiceUtils;

public class UploadUtil {
	private static UploadUtil instance = null;
	private static String location = null;
	
	private UploadUtil() {}
	
	public static UploadUtil getInstance () {
		if(instance == null) {
			instance = new UploadUtil();
		}
		return instance;
	}
	
	public String getLocation() {
		if(location == null) {
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("configKey", "AES_LOCATION");
			ResponseObject result = ServiceUtils.invoke("component:aes/common","read_config", params);
			if(result.getStatus() != 0) {
				return null;
			} else {
				location = (String) result.getResult();
				File file = new File(location + File.separator + "temp");
				if(!file.exists()) {
					file.mkdirs();
				}
			}
		}
		return location;
	}

	public void createRecord(String guuid, String fileName) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("guuid", guuid);
		params.put("fileName", fileName);
		ServiceUtils.invoke("component:aes/common","add_attachment", params);
	}
}
