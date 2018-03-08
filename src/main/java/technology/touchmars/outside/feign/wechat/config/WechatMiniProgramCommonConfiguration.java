package technology.touchmars.outside.feign.wechat.config;

import feign.Logger;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import technology.touchmars.feign.wechat.client.config.WechatErrorDecoder;
import technology.touchmars.feign.wechat.client.config.WechatSpringDecoder;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.cloud.netflix..support.ResponseEntityDecoder;

@Configuration
public class WechatMiniProgramCommonConfiguration {

	@Autowired
	private ObjectFactory<HttpMessageConverters> messageConverters;
	
	@Bean
	public ErrorDecoder errorDecoder(){
		return new WechatErrorDecoder(feignDecoder());
	}
	
	@Bean
	public Decoder feignDecoder() {
		List<HttpMessageConverter<?>> list = this.messageConverters.getObject().getConverters();
		for(HttpMessageConverter<?> c0: list) {
			if(c0 instanceof MappingJackson2HttpMessageConverter) {
				MappingJackson2HttpMessageConverter c = (MappingJackson2HttpMessageConverter)c0;
				List<MediaType> types0 = c.getSupportedMediaTypes();
				List<MediaType> types = new ArrayList<MediaType>();
				types.add(MediaType.TEXT_PLAIN);
				for(MediaType t: types0) {
					types.add(t);
				}
				c.setSupportedMediaTypes(types);
			}
		}
		return new ResponseEntityDecoder(new WechatSpringDecoder(this.messageConverters));
	}
	
	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public Filter commonsRequestLoggingFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeClientInfo(true);
		filter.setIncludeQueryString(true);
		filter.setIncludeHeaders(true);
		filter.setIncludePayload(true);
		return filter;
	}
		
}
