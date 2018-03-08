package technology.touchmars.outside.feign.wechat.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * the request format is:
 * {@code https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code}
 * 
 * @author jhcao
 *
 */
public class WechatMiniProgramExchangeCodeRequestInterceptor implements RequestInterceptor {

	private String clientId;
	private String secret;
	
	public static final String PARAM_NAME_APP_ID="appid";
	public static final String PARAM_NAME_SECRET="secret";
	public static final String PARAM_NAME_GRANT_TYPE="grant_type";
	public static final String PARAM_VALUE_GRANT_TYPE="authorization_code";
	
	protected WechatMiniProgramExchangeCodeRequestInterceptor(String clientId, String secret) {		
		this.clientId = clientId;
		this.secret = secret;
	}

	@Override
	public void apply(RequestTemplate template) {
		template
			.query(PARAM_NAME_APP_ID, clientId)
			.query(PARAM_NAME_SECRET, secret)
			.query(PARAM_NAME_GRANT_TYPE, PARAM_VALUE_GRANT_TYPE)
		;

	}

}
