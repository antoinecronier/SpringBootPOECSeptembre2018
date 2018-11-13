<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>

<form action="/users/delete" method="POST">
    <div>Firstname</div>
    <input type="text" name="firstname" value="">
    <div>Lastname</div>
    <input type="text" name="lastname" value="">
    <input type="submit" value="Search">
</form> 

<div>
<#if users??>
<#assign index = 0>
<form action="/users/deletecriteria" method="POST">
    <div class="row">
        <div class="col-md-6">Firstname</div>
        <div class="col-md-6">Lastname</div>
    </div>
    <#list users as u>
    <#include "noteditableform.ftl"/>
    <#assign index++>
    </#list>
    <input type="submit" value="Delete">
</form>
</#if>
<#if notFound??>
    ${notFound}
</#if>
</div>

<div><a href="/users/index">Back</a></div>