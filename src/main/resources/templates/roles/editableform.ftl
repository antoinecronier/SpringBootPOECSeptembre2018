<form action="/roles/edit" method="POST">
<#if role??>
    <div>Id</div>
    <#if role.getId()??>
    <div>${role.getId()}</div>
    <input type="hidden" name="id" value="${role.getId()}">
    <#else>
    <div>NA</div>
    </#if>
</#if>
    <div>Name</div>
    <input type="text" name="name" value="<#if role?? && role.getName()??>${role.getName()}</#if>">
    <div><input type="submit" value="Save"></div>
</form> 