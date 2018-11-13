<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>

<form action="/roles/find" method="POST">
    <div>Name</div>
    <input type="text" name="name" value="">
    <input type="submit" value="Search">
</form> 

<div>
<#if roles??>
    <#list roles as r>
        <#include "show.ftl"/>
    </#list>
</#if>
<#if notFound??>
    ${notFound}
</#if>
</div>

<div><a href="/roles/index">Back</a></div>