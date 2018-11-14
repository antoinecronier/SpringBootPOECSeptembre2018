<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>

<form action="/users/find" method="POST">
    <div>Firstname</div>
    <input type="text" name="firstname" value="">
    <div>Lastname</div>
    <input type="text" name="lastname" value="">
    <input type="submit" value="Search">
</form> 

<div>
<#if users??>
    <#list users as u>
        <#include "show.ftl"/>
    </#list>
</#if>
<#if notFound??>
    ${notFound}
</#if>
</div>

<div><a href="/users/index">Back</a></div>