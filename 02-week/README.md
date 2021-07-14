# 在 my-configuration 基础上，实现 ServletRequest 请求参 数的 ConfigSource（MicroProfile Config）

ServletRequestConfigSource.java

```java
public class ServletRequestConfigSource extends MapBasedConfigSource {

    private ServletRequest request;

    public ServletRequestConfigSource(ServletRequest request) {
        super("ServletRequest Init Parameters", 650);
        this.request = request;
    }


    @Override
    protected void prepareConfigData(Map configData) throws Throwable {
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            String[] values = request.getParameterValues(parameterName);
            if(values != null && values.length !=0){
                List<String> result = new ArrayList<>(values.length);
                for (String val : values) {
                    result.add(val);
                }
                configData.put(parameterName,result);

            }

        }

    }
}
```

