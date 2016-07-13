package zb.vos;

import java.util.HashMap;
import java.util.Map;

/**
 * json结果值对象
 * 
 * @author wenjizou
 * 
 */
public class JsonResult {

	private boolean success;
	private String errMsg;
	private Map<String, Object> map = new HashMap<>();

	public JsonResult() {
	}

	public JsonResult(boolean success) {
		this.success = success;
	}

	public JsonResult add(String key, Object value) {
		map.put(key, value);
		return this;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public JsonResult setErrMsg(String errMsg) {
		this.errMsg = errMsg;
		return this;
	}
}
