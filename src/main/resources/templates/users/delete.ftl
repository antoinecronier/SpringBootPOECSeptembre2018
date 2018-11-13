<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>

<form action="/users/delete" method="POST">
    <div>Firstname</div>
    <input type="text" name="firstname" value="">
    <div>Lastname</div>
    <input type="text" name="lastname" value="">
    <input type="submit" value="Search">
</form> 

<div>
<#if users??>
<#assign index = 0>
<form action="/users/deletecriteria" method="POST">
    <#list users as u>
    <input type="hidden" readonly name="users[${index}].id" value="<#if u?? && u.getId()??>${u.getId()}<#else>null</#if>">
    <input type="text" readonly name="users[${index}].firstname" value="<#if u?? && u.getFirstname()??>${u.getFirstname()}<#else>null</#if>">
    <input type="text" readonly name="users[${index}].lastname" value="<#if u?? && u.getLastname()??>${u.getLastname()}<#else>null</#if>"> 
    <#assign index++>
    </#list>
    <input type="submit" value="Delete">
</form>
</#if>
<#if notFound??>
    ${notFound}
</#if>
</div>

<div><a href="/users/index">Back</a></div>