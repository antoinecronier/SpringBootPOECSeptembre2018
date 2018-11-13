<input type="hidden" readonly name="users[${index}].id" value="<#if u?? && u.getId()??>${u.getId()}<#else>null</#if>">
<input type="text" readonly name="users[${index}].firstname" value="<#if u?? && u.getFirstname()??>${u.getFirstname()}<#else>null</#if>">
<input type="text" readonly name="users[${index}].lastname" value="<#if u?? && u.getLastname()??>${u.getLastname()}<#else>null</#if>"> 