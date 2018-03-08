package technology.touchmars.outside.feign.wechat.config

import feign.Logger
import feign.codec.Decoder
import feign.codec.ErrorDecoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.filter.CommonsRequestLoggingFilter
import technology.touchmars.feign.wechat.client.config.WechatErrorDecoder
import technology.touchmars.feign.wechat.client.config.WechatSpringDecoder
import java.util.*
import javax.servlet.Filter

//import org.springframework.cloud.netflix..support.ResponseEntityDecoder;

@Configuration
class WechatMiniProgramCommonConfiguration(val messageConverters: ObjectFactory<HttpMessageConverters>) {

//    @Autowired
//    private val messageConverters: ObjectFactory<HttpMessageConverters>? = null

    @Bean
    fun errorDecoder(): ErrorDecoder {
        return WechatErrorDecoder(feignDecoder())
    }

    @Bean
    fun feignDecoder(): Decoder {
        val list = this.messageConverters.getObject().getConverters()
        for (c0 in list) {
            if (c0 is MappingJackson2HttpMessageConverter) {
                val c = c0 as MappingJackson2HttpMessageConverter
                val types0 = c.getSupportedMediaTypes()
                val types = ArrayList<MediaType>()
                types.add(MediaType.TEXT_PLAIN)
                for (t in types0) {
                    types.add(t)
                }
                c.setSupportedMediaTypes(types)
            }
        }
        return ResponseEntityDecoder(WechatSpringDecoder(this.messageConverters))
    }

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }

    @Bean
    fun commonsRequestLoggingFilter(): Filter {
        val filter = CommonsRequestLoggingFilter()
        filter.setIncludeClientInfo(true)
        filter.setIncludeQueryString(true)
        filter.setIncludeHeaders(true)
        filter.setIncludePayload(true)
        return filter
    }

}
