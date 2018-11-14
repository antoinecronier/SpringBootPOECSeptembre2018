<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>

<form action="${detailPath}/delete" method="POST">
<#include "..${detailPath}/specific/emptyshowform.ftl"/>
<input type="submit" value="Search">
</form> 

<div>
<#if items??>
<#assign index = 0>
<form action="${detailPath}/deletecriteria" method="POST">
    <#list items as i>
    <#include "..${detailPath}/specific/noteditableform.ftl"/>
    <#assign index++>
    </#list>
    <input type="submit" value="Delete">
</form>
</#if>
<#if notFound??>
    ${notFound}
</#if>
</div>

<div><a href="${detailPath}/index">Back</a></div>