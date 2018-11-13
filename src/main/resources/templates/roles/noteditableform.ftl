<input type="hidden" readonly name="roles[${index}].id" value="<#if r?? && r.getId()??>${r.getId()}<#else>null</#if>">
<input type="text" readonly name="roles[${index}].name" value="<#if r?? && r.getName()??>${r.getName()}<#else>null</#if>">
