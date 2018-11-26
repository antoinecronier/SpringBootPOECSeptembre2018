<#import "/spring.ftl" as spring/>
<title tiles:fragment="title">Login</title>
    <#include "../utils/bootstrap.ftl"/>
    <h1>Spring Security Login (Freemarker)</h1>

    <form action="/login" method="POST">
      <table>
        <tr><td>User:</td><td><input type='text' name='login' value=''/></td></tr>
        <tr><td>Password:</td><td><input type='password' name='password' value=''/></td></tr>
        <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
        <tr><td colspan='2'><input name="submit" type="submit"></td></tr>
        <tr><td colspan='2'><input name="reset" type="reset"></td></tr>
      </table>

    </form>

<#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
    <h1>Bad credential</h1>
</#if>