package technology.touchmars.feign.wechat.client.config;

import java.util.Map;
import java.util.Objects;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * ErrorResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-28T18:50:31.709-04:00")

public class SimpleResponse {

	public static final String OK = "ok";
	public static final String NAME_ERROR_CODE = "errcode";
	public static final String NAME_ERROR_MSG = "errmsg";
	public static final String NAME_ERROR_HINTS = "hints";

	@JsonProperty(NAME_ERROR_CODE)
	private Integer errcode = null;

	@JsonProperty(NAME_ERROR_MSG)
	private String errmsg = null;
	
	@Getter @Setter
	@JsonProperty(NAME_ERROR_HINTS)
	private Map<String, String> hints = null;	

	public SimpleResponse errcode(Integer errcode) {
		this.errcode = errcode;
		return this;
	}

	/**
	 * Get errcode
	 * 
	 * @return errcode
	 **/
	@ApiModelProperty(value = "")
	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public SimpleResponse errmsg(String errmsg) {
		this.errmsg = errmsg;
		return this;
	}

	/**
	 * Get errmsg
	 * 
	 * @return errmsg
	 **/
	@ApiModelProperty(value = "")
	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	public boolean isOk(){
		return isZero(errcode) && StringUtils.hasText(errmsg) && errmsg.trim().equalsIgnoreCase(OK);
	}
	public boolean isError(){
		return notZero(errcode);
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SimpleResponse _apiResponse = (SimpleResponse) o;
		return Objects.equals(this.errcode, _apiResponse.errcode) && Objects.equals(this.errmsg, _apiResponse.errmsg);
	}

	@Override
	public int hashCode() {
		return Objects.hash(errcode, errmsg);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ErrorResponse {\n");
		sb.append("    "+NAME_ERROR_CODE+": ").append(toIndentedString(errcode)).append("\n");
		sb.append("    "+NAME_ERROR_MSG+": ").append(toIndentedString(errmsg)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public static boolean notZero(Integer number){
		return number!=null && number.intValue()!=0;
	}
	
	public static boolean isZero(Integer number){
		return number!=null && number.intValue()==0;
	}
}
