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