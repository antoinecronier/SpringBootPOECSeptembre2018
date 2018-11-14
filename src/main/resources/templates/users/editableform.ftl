<form action="/users/edit" method="POST">
<#if user??>
    <div>Id</div>
    <#if user.getId()??>
    <div>${user.getId()}</div>
    <input type="hidden" name="id" value="${user.getId()}">
    <#else>
    <div>NA</div>
    </#if>
</#if>
    <div>Firstname</div>
    <input type="text" name="firstname" value="<#if user?? && user.getFirstname()??>${user.getFirstname()}</#if>">
    <div>Lastname</div>
    <input type="text" name="lastname" value="<#if user?? && user.getLastname()??>${user.getLastname()}</#if>">
    <div><input type="submit" value="Save"></div>
</form> 