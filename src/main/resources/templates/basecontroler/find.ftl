<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>

<form action="${detailPath}/find" method="POST">
<#include "..${detailPath}/specific/emptyshowform.ftl"/>
<input type="submit" value="Search">
</form> 

<div>
<#if items??>
    <#list items as i>
        <#include "..${detailPath}/specific/show.ftl"/>
    </#list>
</#if>
<#if notFound??>
    ${notFound}
</#if>
</div>

<div><a href="${detailPath}/index">Back</a></div>