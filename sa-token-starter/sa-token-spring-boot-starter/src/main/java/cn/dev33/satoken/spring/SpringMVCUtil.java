package cn.dev33.satoken.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.dev33.satoken.error.SaSpringBootErrorCode;
import cn.dev33.satoken.exception.NotWebContextException;

/**
 * SpringMVC相关操作  
 * @author kong
 *
 */
public class SpringMVCUtil {
	
	private SpringMVCUtil() {
	}
	
	/**
	 * 获取当前会话的 request 
	 * @return request
	 */
	public static HttpServletRequest getRequest() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if(servletRequestAttributes == null) {
			throw new NotWebContextException("非Web上下文无法获取Request").setCode(SaSpringBootErrorCode.CODE_20101);
		}
		return servletRequestAttributes.getRequest();
	}

	public static void main(String[] args) {
		RequestAttributes requestAttributes=new RequestAttributes(){

			@Override
			public Object getAttribute(String name, int scope) {
				return null;
			}

			@Override
			public void setAttribute(String name, Object value, int scope) {

			}

			@Override
			public void removeAttribute(String name, int scope) {

			}

			@Override
			public String[] getAttributeNames(int scope) {
				return new String[0];
			}

			@Override
			public void registerDestructionCallback(String name, Runnable callback, int scope) {

			}

			@Override
			public Object resolveReference(String key) {
				return null;
			}

			@Override
			public String getSessionId() {
				return null;
			}

			@Override
			public Object getSessionMutex() {
				return null;
			}
		};
		System.out.println(requestAttributes instanceof ServletRequestAttributes);
		ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) requestAttributes;
		System.out.println(requestAttributes1);
	}
	
	/**
	 * 获取当前会话的 response
	 * @return response
	 */
	public static HttpServletResponse getResponse() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
		if(servletRequestAttributes == null) {
			throw new NotWebContextException("非Web上下文无法获取Response").setCode(SaSpringBootErrorCode.CODE_20101);
		}
		return servletRequestAttributes.getResponse();
	}

	/**
	 * 判断当前是否处于 Web 上下文中  
	 * @return request
	 */
	public static boolean isWeb() {
		return RequestContextHolder.getRequestAttributes() != null;
	}
	
}
