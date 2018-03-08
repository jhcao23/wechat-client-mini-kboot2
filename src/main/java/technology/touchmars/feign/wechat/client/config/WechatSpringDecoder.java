package technology.touchmars.feign.wechat.client.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
//import org.springframework.cloud.netflix.feign.support.SpringDecoder;

public class WechatSpringDecoder extends SpringDecoder {

	public WechatSpringDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
		super(messageConverters);		
	}
	
//	@Override
//	public Object decode(final Response response, Type type) throws IOException, FeignException {
//		final SimpleResponse o;
//		try{
//			o = (SimpleResponse)super.decode(response, SimpleResponse.class);			
//		}catch(Exception e){
//			//TODO: this part may be stupid => need rethink!!!
//			e.printStackTrace();
//			if(type.equals(SimpleResponse.class)){
//				throw e;
//			}else{
//				return super.decode(response, type);
//			}			
//		}
//		if(o!=null && SimpleResponse.notZero(o.getErrcode())){
//			if(type.equals(SimpleResponse.class)){
//				return o;
//			}else{
//				throw new WechatClientException(o);
//			}
//		}else{//not error
//			if(type.equals(SimpleResponse.class)){
//				return null;
//			}else{
//				return super.decode(response, type);
//			}
//		}
//	}

}
