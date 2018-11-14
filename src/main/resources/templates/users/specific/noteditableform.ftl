<input type="hidden" readonly name="users[${index}].id" value="<#if i?? && i.getId()??>${i.getId()}<#else>null</#if>">
<input type="text" readonly name="users[${index}].firstname" value="<#if i?? && i.getFirstname()??>${i.getFirstname()}<#else>null</#if>">
<input type="text" readonly name="users[${index}].lastname" value="<#if i?? && i.getLastname()??>${i.getLastname()}<#else>null</#if>"> 