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