/**
 * 
 */
package technology.touchmars.feign.wechat.client.config;

import feign.codec.DecodeException;

/**
 * @author jhcao
 *
 */
@SuppressWarnings("serial")
public class WechatClientException extends DecodeException {

	private int errorCode;
	
	public WechatClientException(SimpleResponse modelApiResponse) {
		super(modelApiResponse.getErrmsg());
		this.errorCode = modelApiResponse.getErrcode();
	}
	
	public WechatClientException(int errCode, String errMsg){
		super(errMsg);
		this.errorCode = errCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString(){
		return String.format("WechatClientException::\n errorCode = %s, errorMsg = %s", errorCode, getMessage());
	}
}
