package technology.touchmars.outside.feign.wechat.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import feign.RequestInterceptor

@Configuration
class WechatMiniProgramRequestInterceptorConfiguration(private val miniProgramProperties: WechatMiniProgramProperties) {

//    @Autowired
//    private val miniProgramProperties: WechatMiniProgramProperties? = null

    @Bean
    fun wechatMiniProgramExchangeCodeRequestInterceptor(): RequestInterceptor {
        return WechatMiniProgramExchangeCodeRequestInterceptor(
                miniProgramProperties!!.clientId!!, miniProgramProperties!!.secret!!
        )
    }

}
