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
    <div>Name</div>
    <input type="text" name="name" value="<#if item?? && item.getName()??>${item.getName()}</#if>">
    <div><input type="submit" value="Save"></div>
</form> 