<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>

<form action="/roles/delete" method="POST">
    <div>Name</div>
    <input type="text" name="name" value="">
    <input type="submit" value="Search">
</form> 

<div>
<#if roles??>
<#assign index = 0>
<form action="/roles/deletecriteria" method="POST">
    <div class="row">
        <div class="col-md-6">Name</div>
    </div>
    <#list roles as r>
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

<div><a href="/roles/index">Back</a></div>