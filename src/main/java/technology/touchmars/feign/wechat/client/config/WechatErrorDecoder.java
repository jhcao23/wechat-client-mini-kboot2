/**
 * 
 */
package technology.touchmars.feign.wechat.client.config;

import java.io.IOException;

import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

/**
 * @author jhcao
 *
 */
public class WechatErrorDecoder implements ErrorDecoder {

	private Decoder decoder;
	
	public WechatErrorDecoder(Decoder decoder) {
		super();
		this.decoder = decoder;
	}

	/* (non-Javadoc)
	 * @see feign.codec.ErrorDecoder#decode(java.lang.String, feign.Response)
	 */
	@Override
	public Exception decode(String methodKey, Response response) {		
		try {
			SimpleResponse errorResponse = 
				(SimpleResponse)decoder.decode(response, SimpleResponse.class);
			return new WechatClientException(errorResponse);
		} catch (FeignException | IOException e) {
			e.printStackTrace();
			return new ErrorDecoder.Default().decode(methodKey, response);
		}		
	}

}
