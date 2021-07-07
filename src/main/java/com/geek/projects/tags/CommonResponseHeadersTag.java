package com.geek.projects.tags;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * TODO
 *
 * @author <a href="mailto:fuchaozh@gmail.com">Charles</a>
 * @since
 */
public class CommonResponseHeadersTag extends SimpleTagSupport {

    private String cacheControl;
    private String pragma;
    private Long expires;

    @Override
    public void doTag(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        HttpServletRequest request = attributes.getRequest();

        if(!StringUtils.isBlank(cacheControl)) {
            response.setHeader("Cache-Control",cacheControl);
        }else if(!StringUtils.isBlank(pragma)) {
            response.setHeader("Pragma",pragma);
        }else if(null != expires) {
            response.setDateHeader("Expires",expires);
        }

    }


    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public String getPragma() {
        return pragma;
    }

    public void setPragma(String pragma) {
        this.pragma = pragma;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }
}
