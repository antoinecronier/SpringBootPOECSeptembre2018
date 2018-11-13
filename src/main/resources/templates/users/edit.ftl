<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>
<div>
<#include "editableform.ftl"/>
<#if user?? && user.getId()??>
	<div><a href="/users/delete/${user.getId()}">Delete</a></div>
</#if>
</div>
<div><a href="/users/index">Back</a></div>