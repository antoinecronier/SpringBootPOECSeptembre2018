<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>
<div>
<#include "editableform.ftl"/>
<#if role?? && role.getId()??>
	<div><a href="/roles/delete/${role.getId()}">Delete</a></div>
</#if>
</div>
<div><a href="/roles/index">Back</a></div>