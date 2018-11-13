<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>
<div>
<form action="/users/edit" method="POST">
<#if user??>
	<div>Id</div>
	<#if user.getId()??>
	<div>${user.getId()}</div>
	<input type="hidden" name="id" value="${user.getId()}">
	<#else>
	<div>NA</div>
	</#if>
</#if>
	<div>Firstname</div>
	<input type="text" name="firstname" value="<#if user?? && user.getLastname()??>${user.getFirstname()}</#if>">
	<div>Lastname</div>
	<input type="text" name="lastname" value="<#if user?? && user.getLastname()??>${user.getLastname()}</#if>">
	<input type="submit" value="Save">
</form> 
<#if user?? && user.getId()??>
	<div><a href="/users/delete/${user.getId()}">Delete</a></div>
</#if>
</div>
<div><a href="/users/index">Back</a></div>