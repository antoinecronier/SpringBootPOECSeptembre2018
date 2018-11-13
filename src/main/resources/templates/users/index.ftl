<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>
<div><a href="/users/edit/">Create New</a></div>
<div><a href="/users/find/">Find by criteria</a></div>
<div><a href="/users/delete/">Delete by criteria</a></div>
<div>
<#if users??>
	<#list users as u>
	<div>
		<div>${u.getId()}</div>
		<#if u.getFirstname()??>
		<div>${u.getFirstname()}</div>
		<#else>
		<div>NULL</div>
		</#if>
		<#if u.getLastname()??>
		<div>${u.getLastname()}</div>
		<#else>
		<div>NULL</div>
		</#if>
		<div>
			<a href="/users/edit/${u.getId()}">Show</a>
			<a href="/users/delete/${u.getId()}">Delete</a>
		</div>
	</div>
	</#list>
</#if>
</div>