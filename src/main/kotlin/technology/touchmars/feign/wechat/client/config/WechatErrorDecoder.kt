/**
 *
 */
package technology.touchmars.feign.wechat.client.config

import feign.FeignException
import feign.Response
import feign.codec.Decoder
import feign.codec.ErrorDecoder
import java.io.IOException

/**
 * @author jhcao
 */
class WechatErrorDecoder(private val decoder: Decoder) : ErrorDecoder {

    /* (non-Javadoc)
	 * @see feign.codec.ErrorDecoder#decode(java.lang.String, feign.Response)
	 */
    @Override
    override fun decode(methodKey: String, response: Response): Exception {
        try {
            val errorResponse = decoder.decode(response, SimpleResponse::class.java) as SimpleResponse
            return WechatClientException(errorResponse)
        } catch (e: FeignException) {
            e.printStackTrace()
            return ErrorDecoder.Default().decode(methodKey, response)
        } catch (e: IOException) {
            e.printStackTrace()
            return ErrorDecoder.Default().decode(methodKey, response)
        }

    }

}
