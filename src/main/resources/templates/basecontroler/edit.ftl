<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>
<div>
<#include "..${detailPath}/specific/editableform.ftl"/>
<#if item?? && item.getId()??>
	<div><a href="${detailPath}/delete/${item.getId()}">Delete</a></div>
</#if>
</div>
<div><a href="${detailPath}/index">Back</a></div>