<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>
<div><a href="/roles/edit/">Create New</a></div>
<div><a href="/roles/find/">Find by criteria</a></div>
<div><a href="/roles/delete/">Delete by criteria</a></div>
<div>
<#if roles??>
	<#list roles as r>
	<div>
		<div>${r.getId()}</div>
		<#if r.getName()??>
		<div>${r.getName()}</div>
		<#else>
		<div>NULL</div>
		</#if>
		<div>
			<a href="/roles/edit/${r.getId()}">Show</a>
			<a href="/roles/delete/${r.getId()}">Delete</a>
		</div>
	</div>
	</#list>
</#if>
</div>