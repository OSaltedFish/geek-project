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