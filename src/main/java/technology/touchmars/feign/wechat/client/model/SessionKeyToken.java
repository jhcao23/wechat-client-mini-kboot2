package technology.touchmars.feign.wechat.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Sample output: 
 * 	{"session_key":"oy2x8R1XYz9soGBTKoMzWQ==","expires_in":7200,"openid":"oHF4L0SJMT9PJJse6qNSqGZeESzo"}
 * 
 * 	Connection →keep-alive
	Content-Length →100
	Content-Type →text/plain
	
 * @author jhcao
 *
 */
@Data
public class SessionKeyToken {

	@JsonProperty("openid")
	private String openId;
	
	@JsonProperty("session_key")
	private String sessionKey;
	
	@JsonProperty("unionid")
	private String unionId;
	
	@JsonProperty("expires_in")
	private Integer expiresIn;
	
}
