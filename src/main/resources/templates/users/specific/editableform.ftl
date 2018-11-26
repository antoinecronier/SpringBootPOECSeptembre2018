<form action="${detailPath}/edit" method="POST">
<#if item??>
    <div>Id</div>
    <#if item.getId()??>
    <div>${item.getId()}</div>
    <input type="hidden" name="id" value="${item.getId()}">
    <#else>
    <div>NA</div>
    </#if>
</#if>
    <div>Firstname</div>
    <input type="text" name="firstname" value="<#if item?? && item.getFirstname()??>${item.getFirstname()}</#if>">
    <div>Lastname</div>
    <input type="text" name="lastname" value="<#if item?? && item.getLastname()??>${item.getLastname()}</#if>">
    <div>Email</div>
    <input type="text" name="email" value="<#if item?? && item.getEmail()??>${item.getEmail()}</#if>">
    <div>Password</div>
    <input type="text" name="password" value="<#if item?? && item.getPassword()??>${item.getPassword()}</#if>">
    <#if roles??>
    <select name="roles">
        <#list roles as r>
            <option value=${r.getId()}>${r.getName()}</option>
        </#list>
    </select>
    </#if>
    <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
    <div><input type="submit" value="Save"></div>
</form> 