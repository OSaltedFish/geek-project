# 通过 MicroProfile REST Client 实现 POST 接口去请求项目中的 ShutdownEndpoint，URI：http://127.0.0.1:8080/actuator/shutdown

ShutdownService.java

```java
public interface ShutdownService {

    @POST
    @Path("/actuator/shutdown")
    public Map<String,String> shutdown();

}

```



# 可选：完善 my-rest-client 框架 POST 方法，实现 org.geektimes.rest.client.DefaultInvocationBuilder#buildPost 方法



功能未实现完成。。。