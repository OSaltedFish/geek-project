## 参考com.salesmanager.shop.tags.CommonResponseHeadersTag 实现一个自定义的 Tag，将 Hard Code 的 Header 名值对，变为属性配置的方式

### 实现javax.servlet.jsp.tagext.SimpleTagSupport

```java
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

```



### tld文件

customer-tags.tld

```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>

<taglib xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="2.0"
        xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-jsptaglibrary_2_0.xsd">
    <description><![CDATA["Shopizer tag libs"]]></description>
    <display-name>"CustomerTags"</display-name>
    <tlib-version>2.2</tlib-version>
    <short-name>sm</short-name>


    <tag>
        <name>CommonResponseHeadersTag</name>
        <tag-class>com.geek.projects.tags.CommonResponseHeadersTag</tag-class>
        <body-content>empty</body-content>

        <attribute>
            <name>cacheControl</name>
            <required>false</required>
            <rtexprvalue>1111</rtexprvalue>
            <type>java.lang.String</type>
        </attribute>
        <attribute>
            <name>pragma</name>
            <required>false</required>
            <rtexprvalue>true</rtexprvalue>
            <type>java.lang.String</type>
        </attribute>
        <attribute>
            <name>expires</name>
            <required>false</required>
            <rtexprvalue>true</rtexprvalue>
            <type>java.lang.Long</type>
        </attribute>
    </tag>

</taglib>

```



### 调用

hello.jsp

```jsp
<%@ taglib prefix="sm" uri="/WEB-INF/view/tld/customer-tags.tld"%>
<sm:CommonResponseHeadersTag cacheControl="no-cache"/>
<sm:CommonResponseHeadersTag pragma="no-cache"/>
<sm:CommonResponseHeadersTag expires="-1"/>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试自定义标签</title>
</head>
<body>
Hi . 现在时间是  ${now}
<hr>
</body>
</html>
```

