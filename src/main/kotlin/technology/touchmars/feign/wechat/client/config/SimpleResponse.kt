package technology.touchmars.feign.wechat.client.config

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModelProperty
import org.springframework.util.StringUtils
import java.util.*

/**
 * ErrorResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-28T18:50:31.709-04:00")
class SimpleResponse {

    /**
     * Get errcode
     *
     * @return errcode
     */
    @JsonProperty(NAME_ERROR_CODE)
    @get:ApiModelProperty(value = "")
    var errcode: Int? = null

    /**
     * Get errmsg
     *
     * @return errmsg
     */
    @JsonProperty(NAME_ERROR_MSG)
    @get:ApiModelProperty(value = "")
    var errmsg: String? = null

    //TODO: need setter and getter
    @JsonProperty(NAME_ERROR_HINTS)
    val hints: Map<String, String>? = null

    val isOk: Boolean
        get() = isZero(errcode) && StringUtils.hasText(errmsg) && errmsg!!.trim().equals(OK, true)
    val isError: Boolean
        get() = notZero(errcode)

    fun errcode(errcode: Int): SimpleResponse {
        this.errcode = errcode
        return this
    }

    fun errmsg(errmsg: String): SimpleResponse {
        this.errmsg = errmsg
        return this
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass !== o!!.javaClass) {
            return false
        }
        val _apiResponse = o as SimpleResponse?
        return Objects.equals(this.errcode, _apiResponse!!.errcode) && Objects.equals(this.errmsg, _apiResponse.errmsg)
    }

    @Override
    override fun hashCode(): Int {
        return Objects.hash(errcode, errmsg)
    }

    @Override
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class ErrorResponse {\n")
        sb.append("    $NAME_ERROR_CODE: ").append(toIndentedString(errcode)).append("\n")
        sb.append("    $NAME_ERROR_MSG: ").append(toIndentedString(errmsg)).append("\n")
        sb.append("}")
        return sb.toString()
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private fun toIndentedString(o: Any?): String {
        return if (o == null) {
            "null"
        } else o!!.toString().replace("\n", "\n    ")
    }

    companion object {

        const val OK = "ok"
        const val NAME_ERROR_CODE = "errcode"
        const val NAME_ERROR_MSG = "errmsg"
        const val NAME_ERROR_HINTS = "hints"

        fun notZero(number: Int?): Boolean {
            return number != null && number!!.toInt() !== 0
        }

        fun isZero(number: Int?): Boolean {
            return number != null && number!!.toInt() === 0
        }
    }
}
