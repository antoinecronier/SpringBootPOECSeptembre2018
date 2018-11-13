<#import "/spring.ftl" as spring/>
<#include "../utils/bootstrap.ftl"/>
<h1>${pageName}</h1>

<form action="/users/find" method="POST">
    <div>Firstname</div>
    <input type="text" name="firstname" value="">
    <div>Lastname</div>
    <input type="text" name="lastname" value="">
    <input type="submit" value="Search">
</form> 

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
<#if notFound??>
    ${notFound}
</#if>
</div>

<div><a href="/users/index">Back</a></div>